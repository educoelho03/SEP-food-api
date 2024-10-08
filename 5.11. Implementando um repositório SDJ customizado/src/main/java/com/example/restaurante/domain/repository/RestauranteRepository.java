package com.example.restaurante.domain.repository;

import com.example.restaurante.domain.model.Cozinha;
import com.example.restaurante.domain.model.Restaurante;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@Repository
public interface RestauranteRepository extends JpaRepository<Restaurante, Long>, RestauranteRepositoryQueries {
    List<Restaurante> findByTaxaFreteBetween (BigDecimal taxaInicial, BigDecimal taxaFinal);

    @Query("from Restaurante where nome like %:nome% and cozinha.id = :id")
    List<Restaurante> consultarPorNome (String nome, @Param("id") Long cozinhaId);

    Optional<Restaurante> findFirstByNomeContaining (String nome);
    List<Restaurante> findTop2ByNomeContaining (String nome);
    int countByCozinhaId (Long cozinhaId);

    @Override
    List<Restaurante> find(String nome, BigDecimal taxaFreteinicial, BigDecimal taxaFreteFinal);
}
