package br.com.controle.pedidos.service;

import br.com.controle.pedidos.model.ItemPedido;

import java.util.List;

public interface ItemPedidoService {
    void cadastrarTodosItenPedido(List<ItemPedido> itemPedidos);
}
