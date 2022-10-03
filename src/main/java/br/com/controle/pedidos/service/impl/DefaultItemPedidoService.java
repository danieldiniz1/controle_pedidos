package br.com.controle.pedidos.service.impl;

import br.com.controle.pedidos.model.ItemPedido;
import br.com.controle.pedidos.repository.ItemPedidoRepository;
import br.com.controle.pedidos.service.ItemPedidoService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DefaultItemPedidoService implements ItemPedidoService {

    private static final Logger LOGGER = LogManager.getLogger();

    @Autowired
    private ItemPedidoRepository itemPedidoRepository;


    @Override
    public void cadastrarTodosItenPedido(List<ItemPedido> itemPedidos) {
        itemPedidoRepository.saveAll(itemPedidos);
    }
}
