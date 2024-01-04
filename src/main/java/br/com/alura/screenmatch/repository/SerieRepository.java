package br.com.alura.screenmatch.repository;


import br.com.alura.screenmatch.model.Serie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


public interface SerieRepository extends JpaRepository<Serie, Long> {



}
