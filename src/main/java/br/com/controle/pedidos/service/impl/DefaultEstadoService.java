package br.com.controle.pedidos.service.impl;

import br.com.controle.pedidos.model.Estado;
import br.com.controle.pedidos.repository.EstadoRepository;
import br.com.controle.pedidos.service.EstadoService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DefaultEstadoService implements EstadoService {

    private static final Logger LOGGER = LogManager.getLogger();
    @Autowired
    private EstadoRepository estadoRepository;


    @Override
    public void salvarEstado(Estado estado) {
        estadoRepository.save(estado);
    }

    @Override
    public void salvarEstados(List<Estado> estados) {
        estadoRepository.saveAll(estados);
    }
}
