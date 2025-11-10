package br.edu.insper.films.film.service;

import br.edu.insper.films.common.exception.ResourceNotFoundException;
import br.edu.insper.films.film.Film;
import br.edu.insper.films.film.dto.FilmSaveDTO;
import br.edu.insper.films.film.repository.FilmRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FilmService {
    @Autowired
    private FilmRepository repository;

    public List<Film> getFilms() {
        return repository.findAll();
    }

    public Film getFilm(int id) throws ResourceNotFoundException {
        Optional<Film> film = repository.findById(id);

        if(film.isEmpty()) {
            throw new ResourceNotFoundException(id, "film");
        }

        return film.get();
    }

    public Film deleteFilm(int id) throws ResourceNotFoundException {
        Film film = getFilm(id);
        repository.deleteById(id);
        return film;
    }

    public Film addFilm(FilmSaveDTO dto) {
        return repository.save(dto.to());
    }
}
