package com.todos.exceptions;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.LocalDateTime;

@ControllerAdvice
@RequiredArgsConstructor
public class CreateExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(GlobalException.class)
    public ResponseEntity<Object> handleException(GlobalException ex, WebRequest request) {

        Exception exception = new Exception();
        exception.setStatus(ex.getStatus().value());
        exception.setTitle(ex.getMessage());
        exception.setDateTime(LocalDateTime.now());

        return handleExceptionInternal(ex, exception, new HttpHeaders(), ex.getStatus(), request);
    }
}
