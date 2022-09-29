package br.com.controle.pedidos.service.impl;

import br.com.controle.pedidos.model.Pedido;
import br.com.controle.pedidos.repository.PedidoRepository;
import br.com.controle.pedidos.service.PedidoService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DefaultPedidoService implements PedidoService {

    private static final Logger LOGGER = LogManager.getLogger();
    @Autowired
    private PedidoRepository pedidoRepository;

    @Override
    public void salvarPedidos(List<Pedido> pedidos) {
        pedidoRepository.saveAll(pedidos);
    }
}
