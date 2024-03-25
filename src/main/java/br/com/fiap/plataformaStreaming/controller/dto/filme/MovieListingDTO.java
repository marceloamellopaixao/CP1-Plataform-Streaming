package br.com.fiap.plataformaStreaming.controller.dto.filme;

import br.com.fiap.plataformaStreaming.model.Movie;

public record MovieListingDTO(Long id, String title, String description, Integer releaseYear, String director, String gender) {

    public MovieListingDTO(Movie movie){
        this(movie.getId(), movie.getTitle(), movie.getDescription(), movie.getReleaseYear(), movie.getDirector(), movie.getGender());
    }
}
