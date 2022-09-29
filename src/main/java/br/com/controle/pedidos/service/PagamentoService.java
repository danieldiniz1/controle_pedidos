package br.com.controle.pedidos.service;

import br.com.controle.pedidos.model.Pagamento;

import java.util.List;

public interface PagamentoService {
    void salvarPagamentos(List<Pagamento> pagamentos);
}
