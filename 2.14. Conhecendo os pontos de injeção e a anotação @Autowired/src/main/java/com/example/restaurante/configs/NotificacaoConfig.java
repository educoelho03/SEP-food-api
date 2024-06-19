package com.example.restaurante.configs;

import com.example.restaurante.domain.notification.NotificadorEmail;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class NotificacaoConfig {

    @Bean
    public NotificadorEmail notificadorEmail(){
        NotificadorEmail notificador = new NotificadorEmail("smtp.foodmail.com.br");
        notificador.setCaixaAlta(true);

        return notificador;
    }
}
