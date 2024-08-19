package com.example.restaurante.domain.exception;

public class EntidadeNaoEncontradaException extends RuntimeException{

    public EntidadeNaoEncontradaException(String msg){
        super(msg);
    }
}
