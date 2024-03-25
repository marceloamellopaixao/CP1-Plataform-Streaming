package br.com.fiap.plataformaStreaming.controller;

import br.com.fiap.plataformaStreaming.controller.dto.serie.SerieDTO;
import br.com.fiap.plataformaStreaming.controller.dto.serie.SerieListingDTO;
import br.com.fiap.plataformaStreaming.controller.dto.serie.SerieUpdateDTO;
import br.com.fiap.plataformaStreaming.model.Serie;
import br.com.fiap.plataformaStreaming.service.SerieService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/serie")
public class SerieController {
    private final SerieService service;

    @Autowired
    public SerieController(SerieService service){
        this.service = service;
    }

    @PostMapping
    @Transactional
    public ResponseEntity<Serie> createSerie(@RequestBody @Valid SerieDTO serieDTO){
        Serie serie = service.createSerie(serieDTO);
        return ResponseEntity.ok(serie);
    }

    @GetMapping
    public ResponseEntity<List<Serie>> findAllSeries() {
        List<Serie> series = service.findAllSeries();
        return ResponseEntity.ok(series);
    }

    @GetMapping("/{id}")
    public ResponseEntity<SerieListingDTO> findSerieById(@PathVariable Long id) {
        SerieListingDTO serieDTO = service.findSerieById(id);
        return ResponseEntity.ok(serieDTO);
    }

    @GetMapping("/find")
    public List<Serie> findSeriesByTitleGenerYearOrSeasonQtt(
            @RequestParam(required = false) String title,
            @RequestParam(required = false) String gender,
            @RequestParam(required = false) Integer releaseYear,
            @RequestParam(required = false) Integer season) {

        return service.findSeriesByTitleGenerYearOrSeasonQtt(title, gender, releaseYear, season);
    }

    @PutMapping
    @Transactional
    public ResponseEntity<SerieDTO> updateSerie(@RequestBody @Valid SerieUpdateDTO serieUpdateDTO){
        SerieDTO serieDTO = service.updateSerie(serieUpdateDTO);
        return ResponseEntity.ok(serieDTO);
    }


    @DeleteMapping("/{id}")
    public void deleteSerie(@PathVariable Long id) {
        service.deleteSerie(id);
    }
}
