package br.com.controle.pedidos.exception;

public class DataViolationException extends RuntimeException{

    public DataViolationException(String message) {
        super(message);
    }
}
