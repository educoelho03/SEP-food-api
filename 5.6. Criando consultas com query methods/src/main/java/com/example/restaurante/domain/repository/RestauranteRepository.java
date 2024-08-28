package com.example.restaurante.domain.repository;

import com.example.restaurante.domain.model.Cozinha;
import com.example.restaurante.domain.model.Restaurante;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RestauranteRepository extends JpaRepository<Restaurante, Long> {

}
