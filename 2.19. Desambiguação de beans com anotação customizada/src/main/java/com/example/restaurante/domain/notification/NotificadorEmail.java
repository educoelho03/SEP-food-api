package com.example.restaurante.domain.notification;

import com.example.restaurante.domain.modelo.Cliente;
import org.springframework.stereotype.Component;

@Component
@TipoDoNotificador(NivelUrgencia.SEM_URGENCIA)
public class NotificadorEmail implements Notificador {

    @Override
    public void notificar(Cliente cliente, String mensagem) {
        System.out.printf("Notificando %s através do e-mail %s: %s\n",
                cliente.getNome(), cliente.getEmail(), mensagem);
    }

}
