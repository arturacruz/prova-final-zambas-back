package br.edu.insper.films.film.controller;

import br.edu.insper.films.film.Film;
import br.edu.insper.films.film.dto.FilmSaveDTO;
import br.edu.insper.films.film.service.FilmService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/film")
public class LivroController {

    @Autowired
    private FilmService service;

    @GetMapping
    public List<Film> getFilms() {
        return service.getFilms();
    }

    @GetMapping("/{id}")
    public Film getFilm(@PathVariable Integer id) {
        return service.getFilm(id);
    }

    @PostMapping
    public Film addFilm(@Valid @RequestBody FilmSaveDTO dto) {
        return service.addFilm(dto);
    }

    @DeleteMapping("/{id}")
    public Film deleteFilm(@PathVariable Integer id) {
        return service.deleteFilm(id);
    }
}
