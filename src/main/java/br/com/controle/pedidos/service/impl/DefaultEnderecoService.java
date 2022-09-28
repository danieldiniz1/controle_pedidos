package br.com.controle.pedidos.service.impl;

import br.com.controle.pedidos.model.Endereco;
import br.com.controle.pedidos.repository.EnderecoRepository;
import br.com.controle.pedidos.service.EnderecoService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DefaultEnderecoService implements EnderecoService {

    private static final Logger LOGGER = LogManager.getLogger();

    @Autowired
    private EnderecoRepository enderecoRepository;

    @Override
    public void cadastrarEnderecos(List<Endereco> enderecos) {
        enderecoRepository.saveAll(enderecos);
    }
}
