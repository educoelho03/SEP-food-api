package com.example.restaurante.domain.service;

import com.example.restaurante.domain.modelo.Cliente;
import com.example.restaurante.domain.notification.Notificador;
import com.example.restaurante.domain.notification.NotificadorEmail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class AtivacaoClienteService {

    @Qualifier("normal") // estou dizendo para ele usar o bean que tem o qualificador chamado "email"
    @Autowired
    private Notificador notificador;

    public void ativar(Cliente cliente) {
        cliente.ativar();
        notificador.notificar(cliente, "Seu cadastro no sistema está ativo!");
    }
}
