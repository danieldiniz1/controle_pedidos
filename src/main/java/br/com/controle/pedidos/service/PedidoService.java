package br.com.controle.pedidos.service;

import br.com.controle.pedidos.model.Pedido;

import java.util.List;

public interface PedidoService {
    void salvarPedidos(List<Pedido> pedidos);
}
