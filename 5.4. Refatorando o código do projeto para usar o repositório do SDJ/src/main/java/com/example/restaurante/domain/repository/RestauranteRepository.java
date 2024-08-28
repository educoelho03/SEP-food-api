package com.example.restaurante.domain.repository;

import com.example.restaurante.domain.model.Cozinha;
import com.example.restaurante.domain.model.Restaurante;

import java.util.List;

public interface RestauranteRepository {

    List<Restaurante> listar();
    Restaurante buscar(Long id);
    Restaurante salvar(Restaurante cozinha);
    void remover(Restaurante cozinha);
}
