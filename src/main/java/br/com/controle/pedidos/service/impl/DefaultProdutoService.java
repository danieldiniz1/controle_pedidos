package br.com.controle.pedidos.service.impl;

import br.com.controle.pedidos.exception.CategoriaNotFoundException;
import br.com.controle.pedidos.model.Categoria;
import br.com.controle.pedidos.model.Produto;
import br.com.controle.pedidos.repository.ProdutoRepository;
import br.com.controle.pedidos.service.CategoriaService;
import br.com.controle.pedidos.service.ProdutoService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DefaultProdutoService implements ProdutoService {

    private static final Logger LOGGER = LogManager.getLogger();

    @Autowired
    private ProdutoRepository produtoRepository;

    @Override
    public Produto buscarPorId(Long id) {
        return produtoRepository.findById(id).orElseThrow(() -> new CategoriaNotFoundException("" +
                "Não foi encontrado produto com o id " + id));
    }

    @Override
    public void salvarListaProdutos(List<Produto> produtos) {
        produtoRepository.saveAll(produtos);
    }


}
