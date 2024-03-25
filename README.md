# Checkpoint 01 - Java Advanced

------------------

### API para Gerenciamento de Catálogo: Plataforma de Streaming

* Funcionalidades para Filmes e Series: cadastrar, atualizar, visualizar e Remover.<br>
Além disso, o usuário pode buscar filmes e séries por id, titulo, genero, ano de lançamento ou até mesmo pela quantidade de temporadas (séries).

------------------

### Tecnologias utilizadas
- [x] Spring Data JPA
- [x] Bean Validation
- [x] Spring Web
- [x] Lombok
- [x] H2 Database
- [x] Spring Dev Tools

------------------

### Integrantes
- Kaique Santos de Andrade - RM99562
- Marcelo Augusto de Mello Paixão - RM99466

------------------

## Variáveis Utilizadas

------------------

#### Movie:  /api/movie

* String title;
* String description;
* Integer releaseYear;
* String director;
* String gender;

##### Consultas: /{id} ou /find?

------------------

#### Serie:  /api/serie

* Long id;
* String title;
* String description;
* Integer releaseYear;
* String gender;

##### Consultas: /{id} ou /find?

------------------

#### Episode:         

* Long id;
* String title;
* Integer numberEpisode;
* Integer season;
