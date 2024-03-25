package br.com.fiap.plataformaStreaming.controller.dto.serie;

import br.com.fiap.plataformaStreaming.controller.dto.episode.EpisodeDTO;
import br.com.fiap.plataformaStreaming.model.Serie;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.util.List;

public record SerieDTO(
        @NotBlank
        String title,

        @NotBlank
        String description,

        @NotNull
        Integer releaseYear,

        @NotBlank
        String gender,

        @NotNull
        List<EpisodeDTO> episodes
) {
        public SerieDTO(Serie serie){
                this(serie.getTitle(), serie.getDescription(), serie.getReleaseYear(), serie.getGender(), null);
        }
}
