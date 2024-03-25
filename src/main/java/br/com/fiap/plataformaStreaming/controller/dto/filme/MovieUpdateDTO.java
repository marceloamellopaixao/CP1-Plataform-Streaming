package br.com.fiap.plataformaStreaming.controller.dto.filme;

import jakarta.validation.constraints.NotNull;

public record MovieUpdateDTO(
        @NotNull
        Long id,
        String title,
        String description,

        Integer releaseYear,

        String director,

        String gender) {
}
