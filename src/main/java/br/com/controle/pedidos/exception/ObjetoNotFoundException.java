package br.com.controle.pedidos.exception;

public class ObjetoNotFoundException extends RuntimeException{

    public ObjetoNotFoundException(String message) {
        super(message);
    }
}
