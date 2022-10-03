package br.com.controle.pedidos.controller.populator;

public interface Populator<SOURCE,TARGET> {

    void populate(SOURCE source, TARGET target);
}
