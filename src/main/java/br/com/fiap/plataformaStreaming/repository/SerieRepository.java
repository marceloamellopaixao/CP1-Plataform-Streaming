package br.com.fiap.plataformaStreaming.repository;

import br.com.fiap.plataformaStreaming.model.Serie;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SerieRepository extends JpaRepository<Serie, Long> {
    List<Serie> findByTitleContainingOrGenderContainingOrReleaseYearOrEpisodes_Season(String title, String gender, Integer releaseYear, Integer season);

}
