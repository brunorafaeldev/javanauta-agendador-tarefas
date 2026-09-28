package com.javanauta_agendador_tarefas.infrastructure.exceptions;

import jakarta.servlet.UnavailableException;

import javax.naming.AuthenticationException;

public class UnauthorizedException extends AuthenticationException {

    public UnauthorizedException(String mensage) {super(mensage);}

    public UnauthorizedException(String mensage, Throwable throwable) {

        super (mensage);
    }
}
