package br.com.fiap.plataformaStreaming.model;


import br.com.fiap.plataformaStreaming.controller.dto.filme.MovieDTO;
import br.com.fiap.plataformaStreaming.controller.dto.filme.MovieUpdateDTO;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Movie {

    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String title;
    private String description;
    private Integer releaseYear;
    private String director;
    private String gender;

    public Movie(MovieDTO movieDTO) {
        this.title = movieDTO.title();
        this.description = movieDTO.description();
        this.releaseYear = movieDTO.releaseYear();
        this.director = movieDTO.director();
        this.gender = movieDTO.gender();
    }

    public void updateInformations(MovieUpdateDTO movieUpdate) {
        if (movieUpdate.title() != null){
            this.title = movieUpdate.title();
        }

        if (movieUpdate.description() != null){
            this.description = movieUpdate.description();
        }

        if (movieUpdate.releaseYear() != null){
            this.releaseYear = movieUpdate.releaseYear();
        }

        if (movieUpdate.director() != null){
            this.director = movieUpdate.director();
        }

        if (movieUpdate.gender() != null){
            this.gender = movieUpdate.gender();
        }

    }
}
