package br.com.fiap.plataformaStreaming.model;


import br.com.fiap.plataformaStreaming.controller.dto.episode.EpisodeDTO;
import br.com.fiap.plataformaStreaming.controller.dto.serie.SerieDTO;
import br.com.fiap.plataformaStreaming.controller.dto.serie.SerieUpdateDTO;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Serie {

    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String title;
    private String description;
    private Integer releaseYear;
    private String gender;

    @OneToMany(mappedBy = "serie", cascade = CascadeType.ALL)
    private List<Episode> episodes = new ArrayList<>();

    public Serie(SerieDTO serieDTO) {
        this.title = serieDTO.title();
        this.description = serieDTO.description();
        this.releaseYear = serieDTO.releaseYear();
        this.gender = serieDTO.gender();

        List<EpisodeDTO> episodiosDTO = serieDTO.episodes();

        for (EpisodeDTO episodeDTO : episodiosDTO) {
            Episode episode = new Episode(episodeDTO.title(), episodeDTO.numberEpisode(), episodeDTO.season());
            episode.setSerie(this);
            episodes.add(episode);
        }
    }

    public Serie(String title, String description, Integer releaseYear, String gender, List<EpisodeDTO> episode) {
        this.title = title;
        this.description = description;
        this.releaseYear = releaseYear;
        this.gender = gender;
        this.episodes = new ArrayList<>();

        for (EpisodeDTO episodeDTO : episode) {
            Episode episodes = new Episode(episodeDTO.title(), episodeDTO.numberEpisode(), episodeDTO.season());
            episodes.setSerie(this);
            this.episodes.add(episodes);
        }
    }

    public void updateInformations(SerieUpdateDTO serieUpdateDTO) {
        if (serieUpdateDTO.title() != null){
            this.title = serieUpdateDTO.title();
        }

        if (serieUpdateDTO.description() != null){
            this.description = serieUpdateDTO.description();
        }

        if (serieUpdateDTO.releaseYear() != null) {
            this.releaseYear = serieUpdateDTO.releaseYear();
        }

        if (serieUpdateDTO.gender() != null){
            this.gender = serieUpdateDTO.gender();
        }
    }
}
