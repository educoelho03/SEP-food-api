package com.example.restaurante.domain.repository;

import com.example.restaurante.domain.model.Restaurante;

import java.math.BigDecimal;
import java.util.List;

public interface RestauranteRepositoryQueries {
    List<Restaurante> find(String nome, BigDecimal taxaFreteinicial, BigDecimal taxaFreteFinal);
}
