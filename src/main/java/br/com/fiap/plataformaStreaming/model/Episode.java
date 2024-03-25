package br.com.fiap.plataformaStreaming.model;

import br.com.fiap.plataformaStreaming.controller.dto.episode.EpisodeDTO;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Episode {

    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String title;
    private Integer numberEpisode;
    private Integer season;

    @ManyToOne
    @JoinColumn(name = "serie_id")
    @JsonIgnore
    private Serie serie;

    public Episode(EpisodeDTO episodeDTO) {
        this.title = episodeDTO.title();
        this.numberEpisode = episodeDTO.numberEpisode();
        this.season = episodeDTO.season();
        this.serie = new Serie(episodeDTO.serie());
    }

    public Episode(String title, Integer numberEpisode, Integer season) {
        this.title = title;
        this.numberEpisode = numberEpisode;
        this.season = season;
    }
}
