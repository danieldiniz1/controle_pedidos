package br.com.controle.pedidos.service.impl;

import br.com.controle.pedidos.model.Cidade;
import br.com.controle.pedidos.repository.CidadeRepository;
import br.com.controle.pedidos.service.CidadeService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DefaultCidadeService implements CidadeService {

    private static final Logger LOGGER = LogManager.getLogger();
    @Autowired
    private CidadeRepository cidadeRepository;

    @Override
    public void salvarCidades(List<Cidade> cidades) {
        cidadeRepository.saveAll(cidades);
    }
}
