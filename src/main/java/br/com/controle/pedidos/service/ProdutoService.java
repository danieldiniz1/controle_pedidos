package br.com.controle.pedidos.service;

import br.com.controle.pedidos.controller.dto.ProdutoResponseDTO;
import br.com.controle.pedidos.model.Produto;
import org.springframework.data.domain.Page;

import java.util.List;

public interface ProdutoService {

    Produto buscarPorId(Long id);

    void salvarListaProdutos(List<Produto> produtos);

    Page<ProdutoResponseDTO> buscarProdutos(Integer Page, Integer linesPerPage, String orderBy, String direction, String nome,
                                            List<Long> ids);

}
