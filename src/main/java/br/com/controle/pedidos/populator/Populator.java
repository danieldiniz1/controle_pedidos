package br.com.controle.pedidos.populator;

public interface Populator<SOURCE,TARGET> {

    void populate(SOURCE source, TARGET target);
}
