package com.example.restaurante.api.controller;

import com.example.restaurante.domain.exception.EntidadeEmUsoException;
import com.example.restaurante.domain.exception.EntidadeNaoEncontradaException;
import com.example.restaurante.domain.model.Cidade;
import com.example.restaurante.domain.service.CadastroCidadeService;
import com.example.restaurante.infrastructure.repository.CidadeRepositoryImpl;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/cidades")
public class CidadeController {

    @Autowired
    private CadastroCidadeService cidadeService;
    @Autowired
    private CidadeRepositoryImpl cidadeRepositoryImpl;

    @GetMapping("/{id}")
    public ResponseEntity<Cidade> cadastrarCidade(@PathVariable Long id) {
        Cidade cidade = cidadeRepositoryImpl.buscar(id);

        if( cidade != null ) {
            return ResponseEntity.ok(cidade);
        }

        return ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<?> adicionarCidade(@RequestBody Cidade cidade) {
        try{
            cidade = cidadeRepositoryImpl.salvar(cidade);
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(cidade);

        } catch (EntidadeNaoEncontradaException e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PutMapping
    public ResponseEntity<Cidade> atualizarCidade(@PathVariable Long id, @RequestBody Cidade cidade) {
        Cidade cidadeAtual = cidadeRepositoryImpl.buscar(id);

        if( cidadeAtual != null ) {
            BeanUtils.copyProperties(cidade, cidadeAtual, "id");
            cidadeAtual = cidadeRepositoryImpl.salvar(cidadeAtual);

            return ResponseEntity.ok(cidadeAtual);
        }

        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> excluirCidade(@PathVariable Long id) {
        try {
            cidadeService.excluir(id);
            return ResponseEntity.noContent().build();

        } catch (EntidadeNaoEncontradaException e) {
            return ResponseEntity.notFound().build();

        } catch (EntidadeEmUsoException e) {
            return ResponseEntity.status(HttpStatus.CONFLICT)
                    .body(e.getMessage());
        }
    }



}
