package com.example.restaurante.domain.repository;

import com.example.restaurante.domain.model.Cozinha;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;


@Repository
public interface CozinhaRepository extends JpaRepository<Cozinha, Long> {
    List<Cozinha> findTodasByNameContaining (String nome); // Containing é como se fosse um "LIKE", adicionando '%' no inicio e no fim da palvra
    Optional<Cozinha> findByNome (String nome);

}
