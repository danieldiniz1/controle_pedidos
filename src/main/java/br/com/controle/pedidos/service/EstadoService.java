package br.com.controle.pedidos.service;

import br.com.controle.pedidos.model.Estado;

import java.util.List;

public interface EstadoService {
    void salvarEstado(Estado estado);

    void salvarEstados(List<Estado> estados);
}
