package com.example.restaurante.domain.notification;

import com.example.restaurante.domain.modelo.Cliente;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
@Qualifier("urgente")
public class NotificadorSMS implements Notificador {

    @Override
    public void notificar(Cliente cliente, String mensagem) {
        System.out.printf("Notificando %s por SMS atraves do telefone %s: %s\n",
                cliente.getNome(), cliente.getTelefone(), mensagem);
    }

}
