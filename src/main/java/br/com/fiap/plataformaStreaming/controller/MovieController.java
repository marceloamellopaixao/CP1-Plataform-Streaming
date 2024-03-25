package br.com.fiap.plataformaStreaming.controller;


import br.com.fiap.plataformaStreaming.controller.dto.filme.MovieDTO;
import br.com.fiap.plataformaStreaming.controller.dto.filme.MovieListingDTO;
import br.com.fiap.plataformaStreaming.controller.dto.filme.MovieUpdateDTO;
import br.com.fiap.plataformaStreaming.model.Movie;


import br.com.fiap.plataformaStreaming.service.MovieService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/movie")
public class MovieController {

    private final MovieService service;

    @Autowired
    public MovieController(MovieService service) {
        this.service = service;
    }

    @PostMapping
    @Transactional
    public ResponseEntity<Movie> createMovie(@RequestBody @Valid MovieDTO movieDTO){
        Movie movie = service.createMovie(movieDTO);
        return ResponseEntity.ok(movie);
    }

    @GetMapping
    public ResponseEntity<List<Movie>> findAllMovies() {
        List<Movie> movies = service.findAllMovies();
        return ResponseEntity.ok(movies);
    }

    @GetMapping("/{id}")
    public ResponseEntity<MovieListingDTO> findMovieById(@PathVariable Long id) {
        MovieListingDTO movieListingDTO = service.findMovieById(id);
        return ResponseEntity.ok(movieListingDTO);
    }

    @GetMapping("/find")
    public List<Movie> findMoviesByTitleGenderOrReleaseYear(
            @RequestParam(required = false) String title,
            @RequestParam(required = false) String gender,
            @RequestParam(required = false) Integer releaseYear) {

        return service.findMoviesByTitleGenderOrReleaseYear(title, gender, releaseYear);
    }

    @PutMapping
    @Transactional
    public ResponseEntity<MovieDTO> updateMovie(@RequestBody @Valid MovieUpdateDTO movieUpdateDTO){
        MovieDTO movieDTO = service.updateMovie(movieUpdateDTO);
        return ResponseEntity.ok(movieDTO);
    }

    @DeleteMapping("/{id}")
    public void deleteMovie(@PathVariable Long id) {
        service.deleteMovie(id);
    }
}
