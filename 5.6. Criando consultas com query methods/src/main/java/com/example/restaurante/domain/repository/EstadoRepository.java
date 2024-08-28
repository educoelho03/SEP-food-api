package com.example.restaurante.domain.repository;

import com.example.restaurante.domain.model.Estado;
import com.example.restaurante.domain.model.Estado;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EstadoRepository extends JpaRepository<Estado, Long> {
}