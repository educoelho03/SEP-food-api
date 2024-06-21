package com.example.restaurante.domain.notification;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties("notificador.email") // adicionar o prefixo
public class NotificadorProperties {

    private String hostServidor; // host-servidor do app.properties vai se transformar nesse atributo
    private Integer portaServidor;

    public String getHostServidor() {
        return hostServidor;
    }

    public void setHostServidor(String hostServidor) {
        this.hostServidor = hostServidor;
    }

    public Integer getPortaServidor() {
        return portaServidor;
    }

    public void setPortaServidor(Integer portaServidor) {
        this.portaServidor = portaServidor;
    }
}
