package br.com.fiap.plataformaStreaming.controller.dto.serie;

import br.com.fiap.plataformaStreaming.controller.dto.episode.EpisodeDTO;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.util.List;

public record SerieUpdateDTO(
        @NotNull
        Long id,

        String title,

        String description,

        Integer releaseYear,

        String gender,

        @JsonIgnore
        List<EpisodeDTO> episodes) {
}
