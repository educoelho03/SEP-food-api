package com.example.restaurante.jpa.cidade;

import com.example.restaurante.RestauranteApplication;
import com.example.restaurante.domain.model.Cidade;
import com.example.restaurante.domain.repository.CidadeRepository;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ApplicationContext;

import java.util.List;

public class ConsultaCidadeMain {

    public static void main(String[] args) {
        ApplicationContext applicationContext = new SpringApplicationBuilder(RestauranteApplication.class)
                .web(WebApplicationType.NONE)
                .run(args);

        CidadeRepository cidadeRepository = applicationContext.getBean(CidadeRepository.class);

        List<Cidade> todasCidades = cidadeRepository.listar();

        for (Cidade cidade : todasCidades) {
            System.out.printf("%s - %s\n", cidade.getNome(), cidade.getEstado().getNome());
        }
    }

}