package com.example.restaurante.domain.repository;

import com.example.restaurante.domain.model.Cozinha;
import com.example.restaurante.domain.model.Permissao;

import java.util.List;

public interface PermissaoRepository {

    List<Permissao> listar();
    Permissao buscar(Long id);
    Permissao salvar(Permissao permissao);
    void remover(Permissao permissao);

}
