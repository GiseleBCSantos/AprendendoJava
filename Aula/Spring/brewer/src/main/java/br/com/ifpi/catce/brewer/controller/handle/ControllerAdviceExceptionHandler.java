package br.com.ifpi.catce.brewer.controller.handle;

import br.com.ifpi.catce.brewer.service.exception.NomeEstiloJaCadastradoException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ControllerAdviceExceptionHandler {

    @ExceptionHandler(NomeEstiloJaCadastradoException.class)
    public ResponseEntity<String> handleEstiloJaCadastradoException(NomeEstiloJaCadastradoException e){
        return ResponseEntity.badRequest().body(e.getMessage());

    }
}
