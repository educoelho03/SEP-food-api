package com.example.restaurante.api.controller;

import com.example.restaurante.domain.exception.EntidadeNaoEncontradaException;
import com.example.restaurante.domain.model.Restaurante;
import com.example.restaurante.domain.repository.RestauranteRepository;
import org.springframework.beans.BeanUtils;
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
    public ResponseEntity<?> buscar(@PathVariable Long id){
        try{
            Restaurante restaurante = restauranteRepository.buscar(id);

            return ResponseEntity.status(HttpStatus.CREATED)
                    .body(restaurante);

        } catch (EntidadeNaoEncontradaException e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> atualizar(@PathVariable Long id, @RequestBody Restaurante restaurante){
        try {
            Restaurante restauranteAtual = restauranteRepository.buscar(id);

            if(restauranteAtual != null){
                BeanUtils.copyProperties(restaurante, restauranteAtual, "id");

                restauranteAtual = restauranteRepository.salvar(restauranteAtual);
                return ResponseEntity.ok(restauranteAtual);
            }

            return ResponseEntity.notFound().build();

        } catch (EntidadeNaoEncontradaException e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }


}
