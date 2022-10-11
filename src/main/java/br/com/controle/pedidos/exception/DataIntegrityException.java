package br.com.controle.pedidos.exception;

public class DataIntegrityException extends RuntimeException{

    public DataIntegrityException(String message) {
        super(message);
    }
}
