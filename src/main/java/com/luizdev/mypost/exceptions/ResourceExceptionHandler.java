package com.luizdev.mypost.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import jakarta.servlet.http.HttpServletRequest;

@ControllerAdvice
public class ResourceExceptionHandler {
    
    @ExceptionHandler(UserNotFoundException.class)
    public ResponseEntity<Error> userNotFound(UserNotFoundException e, HttpServletRequest hsr){
        HttpStatus status = HttpStatus.NOT_FOUND;
        Error error = new Error(System.currentTimeMillis(),status.value(),"Usuário não encontrado",e.getMessage(),hsr.getRequestURI());
        return ResponseEntity.status(status).body(error);
    }
}
