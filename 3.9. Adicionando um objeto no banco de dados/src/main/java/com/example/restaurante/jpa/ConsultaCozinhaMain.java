package com.example.restaurante.jpa;

import com.example.restaurante.RestauranteApplication;
import com.example.restaurante.domain.model.Cozinha;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ApplicationContext;

import java.util.List;

public class ConsultaCozinhaMain {
    public static void main(String[] args) {
        ApplicationContext applicationContext = new SpringApplicationBuilder(RestauranteApplication.class)
                .web(WebApplicationType.NONE)
                .run(args);

        CadastroCozinha cadastroCozinha = applicationContext.getBean(CadastroCozinha.class);
        List<Cozinha> listaCozinha = cadastroCozinha.listar();

        for(Cozinha cozinhas : listaCozinha){
            System.out.println(cozinhas.getNome());
        }

    }
}
