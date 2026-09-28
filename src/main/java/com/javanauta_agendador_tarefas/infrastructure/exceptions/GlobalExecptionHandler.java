package com.javanauta_agendador_tarefas.infrastructure.exceptions;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.client.ResourceAccessException;

@ControllerAdvice //para todas as controllers
public class GlobalExecptionHandler {


    @ExceptionHandler(ResourceAccessException.class) //para dizer que é uma exceção global
    public ResponseEntity<String> handlerResourceNotFoundException(ResourceNotFoundException ex) {
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(UnauthorizedException.class) //para dizer que é uma exceção global
    public ResponseEntity<String> handlerResourceNotFoundException(UnauthorizedException ex) {
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.UNAUTHORIZED);
    }


}
