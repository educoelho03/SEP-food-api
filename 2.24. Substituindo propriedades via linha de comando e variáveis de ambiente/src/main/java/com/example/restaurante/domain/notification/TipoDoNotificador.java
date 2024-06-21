package com.example.restaurante.domain.notification;

import org.springframework.beans.factory.annotation.Qualifier;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Qualifier
@Retention(RetentionPolicy.RUNTIME) // indica quanto tempo q essa anotação TipoDoNotificador deve ser mantida
public @interface TipoDoNotificador {

    NivelUrgencia value();
}
