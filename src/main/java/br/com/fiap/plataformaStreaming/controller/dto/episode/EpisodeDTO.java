package br.com.fiap.plataformaStreaming.controller.dto.episode;

import br.com.fiap.plataformaStreaming.controller.dto.serie.SerieDTO;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record EpisodeDTO(

        @NotBlank
        String title,

        @NotNull
        Integer numberEpisode,

        @NotNull
        Integer season,

        @NotNull @JsonIgnore
        SerieDTO serie) {
}
