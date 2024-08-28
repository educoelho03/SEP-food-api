package com.example.restaurante.api.controller;

import com.example.restaurante.domain.model.Cozinha;
import com.example.restaurante.domain.model.Restaurante;
import com.example.restaurante.domain.repository.CozinhaRepository;
import com.example.restaurante.domain.repository.RestauranteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/teste")
public class TesteController {

    @Autowired
    private CozinhaRepository cozinhaRepository;

    @Autowired
    private RestauranteRepository restauranteRepository;

    @GetMapping("/cozinhas/por-nome")
    public List<Cozinha> cozinhasPorNome(@RequestParam("nome") String nome){
        return cozinhaRepository.findTodasByNameContaining(nome);
    }

    @GetMapping("/cozinhas/unica-por-nome")
    public Optional<Cozinha> cozinhaPorNome(@RequestParam("nome") String nome){
        return cozinhaRepository.findByNome(nome);
    }

    @GetMapping("/restaurantes/por-taxa-frete")
    public List<Restaurante> restaurantesPorTaxaFrete(BigDecimal taxaFreteInicial, BigDecimal taxaFreteFinal){
        return restauranteRepository.findByTaxaFreteBetween(taxaFreteInicial, taxaFreteFinal);
    }

    @GetMapping("/restaurantes/unico-por-nome")
    public Optional<Restaurante> restaurantePorNome(String nome, Long cozinhaId){
        return restauranteRepository.findByNomeContainingAndCozinhaId(nome, cozinhaId);
    }
}
