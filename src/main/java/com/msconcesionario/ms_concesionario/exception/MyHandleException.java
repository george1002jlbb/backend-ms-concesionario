package com.msconcesionario.ms_concesionario.exception;

public class MyHandleException extends RuntimeException{

    private Message messageError;

    public MyHandleException(String mensaje, Message messageError) {
        super(mensaje);
        this.messageError = messageError;
    }
}
