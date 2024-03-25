package br.com.fiap.plataformaStreaming.service;

import br.com.fiap.plataformaStreaming.controller.dto.serie.SerieDTO;
import br.com.fiap.plataformaStreaming.controller.dto.serie.SerieListingDTO;
import br.com.fiap.plataformaStreaming.controller.dto.serie.SerieUpdateDTO;
import br.com.fiap.plataformaStreaming.model.Serie;
import br.com.fiap.plataformaStreaming.repository.SerieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SerieService {
    private final SerieRepository repository;
    @Autowired
    public SerieService(SerieRepository repository) {
        this.repository = repository;
    }

    // Método para Criar a Serie
    public Serie createSerie(SerieDTO serieDTO){
        return repository.save(new Serie(serieDTO));
    }

    // Método para Listar Todas as Series
    public List<Serie> findAllSeries() {
        return repository.findAll();
    }

    public SerieListingDTO findSerieById(Long id) {
        Serie serie = repository.findById(id).orElseThrow(() -> new IllegalArgumentException(
                "Série com o ID: [" + id + "] não foi encontrado, verifique e tente novamente!"));
        return new SerieListingDTO(serie);
    }

    public List<Serie> findSeriesByTitleGenerYearOrSeasonQtt(String title, String gender, Integer releaseYear, Integer season) {

        // Verifica se algum parâmetro foi fornecido para a consulta
        if (title == null && gender == null && releaseYear == null && season == null) {
            // Se nenhum parâmetro for fornecido, retorna todos os Series
            return repository.findAll();
        } else {
            // Se algum parâmetro for fornecido, realiza a consulta personalizada
            return repository.findByTitleContainingOrGenderContainingOrReleaseYearOrEpisodes_Season(title, gender, releaseYear, season);
        }
    }

    public SerieDTO updateSerie(SerieUpdateDTO serieUpdateDTO){
        // Busca a série pelo ID
        Serie serie = repository.findById(serieUpdateDTO.id())
                .orElseThrow(() -> new IllegalArgumentException(
                        "Série com o ID: [" + serieUpdateDTO.id() + "] não foi encontrado, verifique e tente novamente!"));

        serie.updateInformations(serieUpdateDTO);
        repository.save(serie);
        return new SerieDTO(serie);
    }

    public void deleteSerie(Long id) {
        // Verifique se o ID da série solicitada existe
        Optional<Serie> optionalSerie = repository.findById(id);

        // Caso a série não existir irá mostrar essa mensagem abaixo.
        if (optionalSerie.isEmpty()){
            throw new IllegalArgumentException(
                    "Série com o ID: [" + id + "] não foi encontrado, verifique e tente novamente!"
            );
        }
        else{
            // Caso a série exista irá deletar.
            repository.deleteById(id);
        }
    }
}
