package br.edu.insper.films.film.dto;

import br.edu.insper.films.film.Film;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record FilmSaveDTO(
        @NotBlank(message = "Name cannot be blank.")
        @NotNull(message = "Name cannot be null.")
        String name,
       
        @NotBlank(message = "Description cannot be blank.")
        @NotNull(message = "Description cannot be null.")
        String description,

        @NotBlank(message = "Director cannot be blank.")
        @NotNull(message = "Director cannot be null.")
        String director,

        @Max(value = 5, message = "Score must be between 0 and 5")
        @Min(value = 0, message = "Score must be between 0 and 5")
        int score
) {

    public Film to() {
        return new Film(
                name,
                description,
                score,
                director
        );
    }
}
