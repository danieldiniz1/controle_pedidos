package br.com.controle.pedidos.service;

import br.com.controle.pedidos.model.Produto;

import java.util.List;

public interface ProdutoService {

    Produto buscarPorId(Long id);

    void salvarListaProdutos(List<Produto> produtos);

}
