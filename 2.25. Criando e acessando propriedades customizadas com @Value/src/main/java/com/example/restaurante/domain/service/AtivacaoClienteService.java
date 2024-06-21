package com.example.restaurante.domain.service;

import com.example.restaurante.domain.modelo.Cliente;
import com.example.restaurante.domain.notification.NivelUrgencia;
import com.example.restaurante.domain.notification.Notificador;
import com.example.restaurante.domain.notification.TipoDoNotificador;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

//@Component
public class AtivacaoClienteService {

    @Autowired
    private ApplicationEventPublisher  applicationEventPublisher;

    public void ativar(Cliente cliente) {
        cliente.ativar();


        applicationEventPublisher.publishEvent(new ClienteAtivadoEvent(cliente)); // disparando o evento
    }
}