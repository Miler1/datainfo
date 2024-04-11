package com.datainfo.desafionv2.exception;

public class RegraDeNegocioException extends Exception{

    public RegraDeNegocioException(String message){
        super(message);
    }

    public RegraDeNegocioException(String message, Exception e){
        super(message, e);
    }
}
