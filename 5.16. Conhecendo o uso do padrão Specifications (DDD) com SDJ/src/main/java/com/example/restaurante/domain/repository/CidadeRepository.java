package com.example.restaurante.domain.repository;

import com.example.restaurante.domain.model.Cidade;
import com.example.restaurante.domain.model.Cozinha;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CidadeRepository extends JpaRepository<Cidade, Long>  {
}
