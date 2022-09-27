package br.com.controle.pedidos.exception;

public class CategoriaNotFoundException extends RuntimeException{

    public CategoriaNotFoundException(String message) {
        super(message);
    }
}
