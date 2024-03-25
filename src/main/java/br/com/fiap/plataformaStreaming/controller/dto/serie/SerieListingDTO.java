package br.com.fiap.plataformaStreaming.controller.dto.serie;

import br.com.fiap.plataformaStreaming.controller.dto.episode.EpisodeDTO;
import br.com.fiap.plataformaStreaming.model.Serie;

import java.util.List;

public record SerieListingDTO(
        Long id,
        String title,
        String description,
        Integer releaseYear,
        String gender,
        List<EpisodeDTO> episodes) {
    public SerieListingDTO(Serie serie) {
        this(serie.getId(), serie.getTitle(), serie.getDescription(), serie.getReleaseYear(), serie.getGender(),
                serie.getEpisodes().stream().map(episode -> new EpisodeDTO(
                        episode.getTitle(), episode.getNumberEpisode(), episode.getSeason(), null)).toList());
    }
}
