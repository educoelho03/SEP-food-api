package com.example.restaurante.listener;

import com.example.restaurante.domain.notification.NivelUrgencia;
import com.example.restaurante.domain.notification.Notificador;
import com.example.restaurante.domain.notification.TipoDoNotificador;
import com.example.restaurante.domain.service.ClienteAtivadoEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class NotificacaoService {

    @TipoDoNotificador(NivelUrgencia.SEM_URGENCIA)
    @Autowired
    private Notificador notificador;

    @EventListener // dizendo que ele é um ouvinte de um evento
    public void clienteAtivadoListener(ClienteAtivadoEvent event){
        notificador.notificar(event.getCliente(),"Seu cadastro no sistema esta ativo.");

    }
}
