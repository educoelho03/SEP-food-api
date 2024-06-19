package com.example.restaurante.domain.service;

import com.example.restaurante.domain.modelo.Cliente;
import com.example.restaurante.domain.notification.NivelUrgencia;
import com.example.restaurante.domain.notification.Notificador;
import com.example.restaurante.domain.notification.TipoDoNotificador;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class AtivacaoClienteService {

    @TipoDoNotificador(NivelUrgencia.URGENTE)
    @Autowired
    private Notificador notificador;

    public void ativar(Cliente cliente) {
        cliente.ativar();
        notificador.notificar(cliente, "Seu cadastro no sistema está ativo!");
    }
}
