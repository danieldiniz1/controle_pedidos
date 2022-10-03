package br.com.controle.pedidos.service.impl;

import br.com.controle.pedidos.controller.dto.PedidoResponseDTO;
import br.com.controle.pedidos.exception.ObjetoNotFoundException;
import br.com.controle.pedidos.model.Pedido;
import br.com.controle.pedidos.controller.populator.Populator;
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

    @Autowired
    private Populator<Pedido,PedidoResponseDTO> pedidoResponseDTOPopulator;

    @Override
    public void salvarPedidos(List<Pedido> pedidos) {
        pedidoRepository.saveAll(pedidos);
    }

    @Override
    public PedidoResponseDTO buscarPedidoPorId(Long id) {
        Pedido pedido = pedidoRepository.findById(id).orElseThrow(() -> new ObjetoNotFoundException("Não foi encontrado pedido com id:" + id.toString()));

        return converterFromPedidoToPedidoResponseDTO(pedido);
    }

    private PedidoResponseDTO converterFromPedidoToPedidoResponseDTO(Pedido pedido) {
        PedidoResponseDTO pedidoResponseDTO = new PedidoResponseDTO();
        pedidoResponseDTOPopulator.populate(pedido,pedidoResponseDTO);
        return pedidoResponseDTO;
    }
}
