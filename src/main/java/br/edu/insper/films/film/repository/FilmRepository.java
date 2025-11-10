package br.edu.insper.films.film.repository;

import br.edu.insper.films.film.Film;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FilmRepository extends JpaRepository<Film, Integer> {
}
