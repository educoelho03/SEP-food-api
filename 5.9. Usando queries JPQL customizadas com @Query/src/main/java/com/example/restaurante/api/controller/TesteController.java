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
        return cozinhaRepository.findTodasByNomeContaining(nome);
    }

    @GetMapping("/cozinhas/unica-por-nome")
    public Optional<Cozinha> cozinhaPorNome(@RequestParam("nome") String nome){
        return cozinhaRepository.findByNome(nome);
    }

    @GetMapping("/cozinhas/exists")
    public boolean cozinhaExistsByNome(String nome){
        return cozinhaRepository.existsByNome(nome);
    }


    @GetMapping("/restaurantes/por-taxa-frete")
    public List<Restaurante> restaurantesPorTaxaFrete(BigDecimal taxaFreteInicial, BigDecimal taxaFreteFinal){
        return restauranteRepository.findByTaxaFreteBetween(taxaFreteInicial, taxaFreteFinal);
    }

    @GetMapping("/restaurantes/unico-por-nome")
    public List<Restaurante> restaurantePorNome(String nome, Long cozinhaId){
        return restauranteRepository.consultarPorNome(nome, cozinhaId);
    }

    @GetMapping("/restaurantes/primeiro-por-nome")
    public Optional<Restaurante> restaurantePrimeiroPorNome(String nome){
        return restauranteRepository.findFirstByNomeContaining(nome);
    }

    @GetMapping("/restaurantes/top2-por-nome")
    public List<Restaurante> restaurantesTop2PorNome(String nome){
        return restauranteRepository.findTop2ByNomeContaining(nome);
    }

    @GetMapping("/restaurantes/count-cozinha")
    public Integer restauranteByCozinhaId(Long cozinhaId){
        return restauranteRepository.countByCozinhaId(cozinhaId);
    }
}
