package br.com.controle.pedidos.service.impl;

import br.com.controle.pedidos.controller.dto.ProdutoResponseDTO;
import br.com.controle.pedidos.exception.ObjetoNotFoundException;
import br.com.controle.pedidos.model.Produto;
import br.com.controle.pedidos.populator.Populator;
import br.com.controle.pedidos.repository.ProdutoRepository;
import br.com.controle.pedidos.service.ProdutoService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DefaultProdutoService implements ProdutoService {

    private static final Logger LOGGER = LogManager.getLogger();

    @Autowired
    private ProdutoRepository produtoRepository;

    @Autowired
    private Populator<Produto,ProdutoResponseDTO> produtoResponseDTOPopulator;

    @Override
    public Produto buscarPorId(Long id) {
        return produtoRepository.findById(id).orElseThrow(() -> new ObjetoNotFoundException("" +
                "Não foi encontrado produto com o id " + id));
    }

    @Override
    public void salvarListaProdutos(List<Produto> produtos) {
        produtoRepository.saveAll(produtos);
    }

    @Override
    public Page<ProdutoResponseDTO> buscarProdutos(Integer page, Integer linesPerPage, String orderBy, String direction,
                                                   String nome,
                                                   List<Long> ids) {
        Page<Produto> produtos = produtoRepository.findByNomeContaining(nome, PageRequest.of(page, linesPerPage, Sort.Direction.valueOf(direction), orderBy));
        Page<ProdutoResponseDTO> response = produtos.map((p) -> ProdutoResponseDTO.valueOf(p));
        return response;
    }


}
