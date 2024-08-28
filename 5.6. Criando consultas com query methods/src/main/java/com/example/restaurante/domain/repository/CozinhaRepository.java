package com.example.restaurante.domain.repository;

import com.example.restaurante.domain.model.Cozinha;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;


@Repository
public interface CozinhaRepository extends JpaRepository<Cozinha, Long> {
    List<Cozinha> findTodasByName (String nome); // FindBy é um prefixo entao só vai importar a propriedade apos o BY, podendo colocar "qualquer coisa antes do BY"
    Optional<Cozinha> findByNome (String nome);

}
