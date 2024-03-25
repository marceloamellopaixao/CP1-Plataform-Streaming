package br.com.fiap.plataformaStreaming.controller.dto.filme;

import br.com.fiap.plataformaStreaming.model.Movie;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record MovieDTO(
        @NotBlank
        String title,
        @NotBlank
        String description,

        @NotNull
        Integer releaseYear,

        @NotBlank
        String director,

        @NotBlank
        String gender) {

        public MovieDTO(Movie movie) {
                this(movie.getTitle(), movie.getDescription(), movie.getReleaseYear(), movie.getDirector(), movie.getGender());
        }
}
