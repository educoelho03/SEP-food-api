package com.example.restaurante.jpa.restaurante;

import com.example.restaurante.RestauranteApplication;
import com.example.restaurante.domain.model.Restaurante;
import com.example.restaurante.domain.repository.RestauranteRepository;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ApplicationContext;

import java.util.List;

public class ConsultaRestauranteMain {
    public static void main(String[] args) {
        ApplicationContext applicationContext = new SpringApplicationBuilder(RestauranteApplication.class)
                .web(WebApplicationType.NONE)
                .run(args);


        RestauranteRepository restauranteRepository = applicationContext.getBean(RestauranteRepository.class);
        List<Restaurante> listaRestaurantes = restauranteRepository.listar();

        for (Restaurante restaurantes : listaRestaurantes){
            System.out.println(restaurantes.getNome());
        }
    }
}
