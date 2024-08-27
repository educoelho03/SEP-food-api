package com.example.restaurante.domain.repository;

import com.example.restaurante.domain.model.Estado;
import com.example.restaurante.domain.model.Estado;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EstadoRepository {

    List<Estado> listar();
    Estado buscar(Long id);
    Estado salvar(Estado estado);
    void remover(Long id);
}
