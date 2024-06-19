package com.example.restaurante.domain.service;

import com.example.restaurante.domain.modelo.Cliente;
import com.example.restaurante.domain.notification.Notificador;
import com.example.restaurante.domain.notification.NotificadorEmail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class AtivacaoClienteService {

    @Autowired
    private List<Notificador> notificadores;

    public void ativar(Cliente cliente) {
        cliente.ativar();

        for(Notificador notificador: notificadores){
            notificador.notificar(cliente, "Seu cadastro no sistema está ativo!");
        }
    }
}
