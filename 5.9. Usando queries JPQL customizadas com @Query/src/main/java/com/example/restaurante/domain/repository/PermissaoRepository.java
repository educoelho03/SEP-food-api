package com.example.restaurante.domain.repository;

import com.example.restaurante.domain.model.Permissao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface PermissaoRepository extends JpaRepository<Permissao, Long> {
}