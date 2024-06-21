package com.example.restaurante;


import com.example.restaurante.domain.service.AtivacaoClienteService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ServiceConfig {

        @Bean(initMethod = "init", destroyMethod = "destroy")
        public AtivacaoClienteService ativacaoClienteService() {
            return new AtivacaoClienteService();
        }

    }
