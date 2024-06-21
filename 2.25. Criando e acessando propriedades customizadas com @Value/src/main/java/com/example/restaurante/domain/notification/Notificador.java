package com.example.restaurante.domain.notification;

import com.example.restaurante.domain.modelo.Cliente;

public interface Notificador {
    void notificar(Cliente cliente, String mensagem);
}
