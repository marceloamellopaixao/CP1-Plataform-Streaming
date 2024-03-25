package br.com.fiap.plataformaStreaming.repository;

import br.com.fiap.plataformaStreaming.model.Movie;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface MovieRepository extends JpaRepository<Movie, Long> {
    List<Movie> findByTitleContainingOrGenderContainingOrReleaseYear(String title, String gender, Integer releaseYear);

}
