package br.com.controle.pedidos.service.impl;

import br.com.controle.pedidos.model.Pagamento;
import br.com.controle.pedidos.repository.PagamentoRepository;
import br.com.controle.pedidos.service.PagamentoService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DefaultPagamentoService implements PagamentoService {

    private static final Logger LOGGER = LogManager.getLogger();
    @Autowired
    private PagamentoRepository pagamentoRepository;

    @Override
    public void salvarPagamentos(List<Pagamento> pagamentos) {
        pagamentoRepository.saveAll(pagamentos);
    }
}
