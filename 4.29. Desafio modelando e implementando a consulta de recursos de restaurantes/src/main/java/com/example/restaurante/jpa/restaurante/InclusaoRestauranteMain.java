package com.example.restaurante.jpa.restaurante;

import com.example.restaurante.RestauranteApplication;
import com.example.restaurante.domain.model.Restaurante;
import com.example.restaurante.domain.repository.RestauranteRepository;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ApplicationContext;

import java.math.BigDecimal;

public class InclusaoRestauranteMain {
    public static void main(String[] args) {
        ApplicationContext applicationContext = new SpringApplicationBuilder(RestauranteApplication.class)
                .web(WebApplicationType.NONE)
                .run(args);


        RestauranteRepository restauranteRepository = applicationContext.getBean(RestauranteRepository.class);

        Restaurante restaurante1 = new Restaurante();
        restaurante1.setNome("teste1");
        restaurante1.setTaxaFrete(BigDecimal.valueOf(10.0));

        Restaurante restaurante2 = new Restaurante();
        restaurante2.setNome("teste2");
        restaurante2.setTaxaFrete(BigDecimal.valueOf(8.93));

        restaurante1 = restauranteRepository.salvar(restaurante1);
        restaurante2 = restauranteRepository.salvar(restaurante2);

        System.out.printf("%d - %s \n", restaurante1.getId(), restaurante1.getNome());
        System.out.printf("%d - %s \n", restaurante2.getId(), restaurante2.getNome());
    }
}
