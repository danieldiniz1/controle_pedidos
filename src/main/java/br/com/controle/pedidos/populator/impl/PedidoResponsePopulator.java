package br.com.controle.pedidos.populator.impl;

import br.com.controle.pedidos.controller.dto.PedidoResponseDTO;
import br.com.controle.pedidos.model.Pedido;
import br.com.controle.pedidos.populator.Populator;
import org.springframework.stereotype.Component;

@Component
public class PedidoResponsePopulator implements Populator<Pedido, PedidoResponseDTO> {
    @Override
    public void populate(Pedido source, PedidoResponseDTO target) {
        target.setId(source.getId().toString());
        target.setDataPedido(source.getInstante().toString());
        target.setCliente(source.getCliente());
        target.setEnderecoDeEntrega(source.getEnderecoDeEntrega());
        target.setPagamento(source.getPagamento());
        target.setItemPedido(source.getItens());
    }
}
