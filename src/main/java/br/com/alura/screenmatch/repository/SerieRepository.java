package br.com.alura.screenmatch.repository;


import br.com.alura.screenmatch.model.Categoria;
import br.com.alura.screenmatch.model.Episodio;
import br.com.alura.screenmatch.model.Serie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;


public interface SerieRepository extends JpaRepository<Serie, Long> {


    Optional<Serie> findByTituloContainingIgnoreCase(String nomeSerie);


    List<Serie> findByAtoresContainingIgnoreCaseAndAvaliacaoGreaterThanEqual(String nomeAtor, Double avaliacao);

    List<Serie> findTop5ByOrderByAvaliacaoDesc();

    List<Serie> findByGenero(Categoria categoria);

    List<Serie> findByTotalTemporadasGreaterThanEqualAndAvaliacaoGreaterThanEqual(Integer totalTemporadas, Double avaliacao);


    /*
    Consulta JPQL -> Query JPQL
     */
    @Query("select s from Serie s WHERe s.totalTemporadas <= totalTemporadas AND s.avaliacao >= avaliacao")
    List<Serie> seriePorTemporadaEAValiacao(Integer totalTemporadas, Double avaliacao);

    @Query("SELECT e FROM Serie s JOIN s.episodios e WHERE e.titulo ILIKE %:trechoEpisodio%")
    List<Episodio> episodiosPorTrechos(String trechoEpisodio);
}
