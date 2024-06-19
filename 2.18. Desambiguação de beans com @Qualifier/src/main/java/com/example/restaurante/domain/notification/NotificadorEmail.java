package com.example.restaurante.domain.notification;

import com.example.restaurante.domain.modelo.Cliente;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Qualifier("normal") // é uma anotação para qualificar o nosso componente
public class NotificadorEmail implements Notificador {

    @Override
    public void notificar(Cliente cliente, String mensagem) {
        System.out.printf("Notificando %s através do e-mail %s usando SMTP %s: %s\n",
                cliente.getNome(), cliente.getEmail(), mensagem);
    }

}
