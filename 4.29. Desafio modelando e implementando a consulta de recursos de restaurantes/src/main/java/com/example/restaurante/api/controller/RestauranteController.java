package com.example.restaurante.api.controller;

import com.example.restaurante.domain.model.Restaurante;
import com.example.restaurante.domain.repository.RestauranteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController()
@RequestMapping("/restaurantes")
public class RestauranteController {

    @Autowired
    private RestauranteRepository restauranteRepository;

    @GetMapping
    public List<Restaurante> listar(Restaurante restaurante){
        return restauranteRepository.listar();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Restaurante> buscar(@PathVariable Long id){
        Restaurante restaurante = restauranteRepository.buscar(id);

        if(restaurante != null){
            return ResponseEntity.status(HttpStatus.OK).body(restaurante);
        }

        return ResponseEntity.notFound().build();
    }

}
