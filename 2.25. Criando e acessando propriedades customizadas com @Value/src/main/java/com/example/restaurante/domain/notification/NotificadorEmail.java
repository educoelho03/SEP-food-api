package com.example.restaurante.domain.notification;

import com.example.restaurante.domain.modelo.Cliente;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Profile("prod")
@TipoDoNotificador(NivelUrgencia.SEM_URGENCIA)
@Component
public class NotificadorEmail implements Notificador {

    @Value("${notificador.email.host-servidor}") // pega o valor do host do servidor definido no properties
    private String host;

    @Value("${notificador.email.porta-servidor}")
    private Integer porta;

    public NotificadorEmail() {
        System.out.println("NotificadorEmail REAL");
    }

    @Override
    public void notificar(Cliente cliente, String mensagem) {
        System.out.println("Host: " + host);
        System.out.println("porta: " + porta);

        System.out.printf("Notificando %s através do e-mail %s: %s\n",
                cliente.getNome(), cliente.getEmail(), mensagem);
    }

}