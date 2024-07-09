package com.msconcesionario.ms_concesionario.exception;

import jakarta.validation.UnexpectedTypeException;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@ControllerAdvice
public class HandleException {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Message> handleValidationException(MethodArgumentNotValidException methodArgumentNotValidException){

        Message messageError = Message.builder()
                .meta(Meta.builder()
                        ._messageId("c4e6bd04-5149-11e7-b114-b2f933d5fe66")
                        ._requestDateTime("2016-06-23T09:07:21.205-07:00")
                        ._applicationId("acxff62e-6f12-42de-9012-3e7304418abd")
                        ._service("ms-concesionario")
                        .build())
                .title(methodArgumentNotValidException.getBody().getDetail())
                .status(methodArgumentNotValidException.getBody().getStatus())
                .build();
        List<String> errores = new ArrayList<>();
        for (FieldError error: methodArgumentNotValidException.getBindingResult().getFieldErrors()) {
            String message = error.getField()+" : "+error.getDefaultMessage();
            errores.add(message);
        }
        messageError.setErrors(errores);
        return ResponseEntity.badRequest().body(messageError);
    }

}
