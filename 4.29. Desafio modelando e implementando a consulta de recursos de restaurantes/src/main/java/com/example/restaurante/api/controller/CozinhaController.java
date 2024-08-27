package com.example.restaurante.api.controller;

import com.example.restaurante.domain.exception.EntidadeEmUsoException;
import com.example.restaurante.domain.exception.EntidadeNaoEncontradaException;
import com.example.restaurante.domain.model.Cozinha;
import com.example.restaurante.domain.repository.CozinhaRepository;
import com.example.restaurante.domain.service.CadastroCozinhaService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cozinhas")
public class CozinhaController {

    @Autowired
    private CozinhaRepository cozinhaRepository;

    @Autowired
    private CadastroCozinhaService cozinhaService;

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Cozinha> listar(){
        return cozinhaRepository.listar();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Cozinha> buscar(@PathVariable Long id){
        Cozinha cozinha = cozinhaRepository.buscar(id);

        if(cozinha != null){
            return ResponseEntity.status(HttpStatus.OK).body(cozinha);
        }

       	return ResponseEntity.notFound().build();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Cozinha adicionar(@RequestBody Cozinha cozinha){ // isso quer dizer que o parametro cozinha, vai receber o corpo da requisição

        // Cozinha addCozinha = cozinhaRepository.salvar(cozinha);
        // ResponseEntity.status(HttpStatus.CREATED).body(addCozinha);
        return cozinhaService.salvar(cozinha);

    }

    @PutMapping("/{id}")
    public ResponseEntity<Cozinha> atualizar(@PathVariable Long id, @RequestBody Cozinha cozinha){
        Cozinha cozinhaAtual = cozinhaRepository.buscar(id);

        if(cozinhaAtual != null){
            BeanUtils.copyProperties(cozinha, cozinhaAtual, "id");

            cozinhaAtual = cozinhaRepository.salvar(cozinhaAtual);
            return ResponseEntity.ok(cozinhaAtual);
        }

        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Cozinha> remover(@PathVariable Long cozinhaId) {
        try {
            cozinhaService.excluir(cozinhaId);
            return ResponseEntity.noContent().build();

        } catch (EntidadeNaoEncontradaException e){
            return ResponseEntity.notFound().build();

        } catch (EntidadeEmUsoException e) {
            return ResponseEntity.status(HttpStatus.CONFLICT).build();
        }
    }


}