package com.javanauta_agendador_tarefas.infrastructure.exceptions;

public class ResourceNotFoundException extends RuntimeException {

    public ResourceNotFoundException (String menssagem) {
        super(menssagem);
    }

    public ResourceNotFoundException (String menssagem, Throwable throwable) {
        super(menssagem, throwable);
    }
}
