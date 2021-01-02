package com.example.demo.exceptions;

public class ClienteNotFoundException extends RuntimeException {

    public ClienteNotFoundException(String mensagem) {
        super(mensagem);
    }

    public ClienteNotFoundException(String mensagem, Throwable causa) {
        super(mensagem, causa);
    }
}
