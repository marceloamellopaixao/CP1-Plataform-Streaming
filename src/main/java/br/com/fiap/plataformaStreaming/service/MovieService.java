package br.com.fiap.plataformaStreaming.service;

import br.com.fiap.plataformaStreaming.controller.dto.filme.MovieDTO;
import br.com.fiap.plataformaStreaming.controller.dto.filme.MovieListingDTO;
import br.com.fiap.plataformaStreaming.controller.dto.filme.MovieUpdateDTO;
import br.com.fiap.plataformaStreaming.model.Movie;
import br.com.fiap.plataformaStreaming.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MovieService {
    private final MovieRepository repository;

    @Autowired
    public MovieService(MovieRepository repository) {
        this.repository = repository;
    }

    public Movie createMovie(MovieDTO movieDTO){
        return repository.save(new Movie(movieDTO));
    }

    public List<Movie> findAllMovies() {
        return repository.findAll();
    }

    public MovieListingDTO findMovieById(Long id) {
        Movie movie = repository.findById(id).orElseThrow(() -> new IllegalArgumentException(
                "Filme com o ID: [" + id + "] não foi encontrado, verifique e tente novamente!"));
        return new MovieListingDTO(movie);
    }

    public List<Movie> findMoviesByTitleGenderOrReleaseYear(String title, String gender, Integer releaseYear) {

        // Verifica se algum parâmetro foi fornecido para a consulta
        if (title == null && gender == null && releaseYear == null) {
            // Se nenhum parâmetro for fornecido, retorna todos os filmes
            return repository.findAll();
        } else {
            // Se algum parâmetro for fornecido, realiza a consulta personalizada
            return repository.findByTitleContainingOrGenderContainingOrReleaseYear(title, gender, releaseYear);
        }
    }


    public MovieDTO updateMovie(MovieUpdateDTO movieUpdateDTO){
        Movie movie = repository.findById(movieUpdateDTO.id())
                .orElseThrow(() -> new IllegalArgumentException(
                        "Filme com o ID: [" + movieUpdateDTO.id() + "] não foi encontrado, verifique e tente novamente!"));
        movie.updateInformations(movieUpdateDTO);
        repository.save(movie);
        return new MovieDTO(movie);
    }

    public void deleteMovie(Long id) {
        Optional<Movie> optionalMovie = repository.findById(id);
        if (optionalMovie.isEmpty()){
            throw new IllegalArgumentException(
                    "Filme com o ID: [" + id + "] não foi encontrado, verifique e tente novamente!");
        }
        else {
            repository.deleteById(id);
        }
    }
}
