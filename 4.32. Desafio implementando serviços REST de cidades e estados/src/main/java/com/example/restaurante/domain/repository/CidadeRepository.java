package com.example.restaurante.domain.repository;

import com.example.restaurante.domain.model.Cidade;
import com.example.restaurante.domain.model.Cozinha;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CidadeRepository  {

    List<Cidade> listar();
    Cidade buscar(Long id);
    Cidade salvar(Cidade cidade);
    void remover(Long id);
}
