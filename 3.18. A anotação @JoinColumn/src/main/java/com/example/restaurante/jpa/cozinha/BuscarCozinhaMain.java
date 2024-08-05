package com.example.restaurante.jpa.cozinha;

import com.example.restaurante.RestauranteApplication;
import com.example.restaurante.domain.model.Cozinha;
import com.example.restaurante.domain.repository.CozinhaRepository;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ApplicationContext;

import java.util.List;

public class BuscarCozinhaMain {
    public static void main(String[] args) {
        ApplicationContext applicationContext = new SpringApplicationBuilder(RestauranteApplication.class)
                .web(WebApplicationType.NONE)
                .run(args);

        CozinhaRepository cozinhaRepository = applicationContext.getBean(CozinhaRepository.class);

        Cozinha cozinha = cozinhaRepository.buscar(1L);

        System.out.println(cozinha.getNome());

    }
}
