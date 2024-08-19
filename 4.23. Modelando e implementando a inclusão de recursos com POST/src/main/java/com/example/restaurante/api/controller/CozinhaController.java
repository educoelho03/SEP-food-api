package com.example.restaurante.api.controller;

import com.example.restaurante.api.model.CozinhasXmlWrapper;
import com.example.restaurante.domain.model.Cozinha;
import com.example.restaurante.domain.repository.CozinhaRepository;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
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

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Cozinha> listar(){
        return cozinhaRepository.listar();
    }

    @GetMapping(produces = MediaType.APPLICATION_XML_VALUE)
    public CozinhasXmlWrapper listarXml() {
        return new CozinhasXmlWrapper(cozinhaRepository.listar());
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
        return cozinhaRepository.salvar(cozinha);

    }
}