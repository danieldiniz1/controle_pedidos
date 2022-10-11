package br.com.controle.pedidos.populator.impl;

import br.com.controle.pedidos.controller.dto.ProdutoResponseDTO;
import br.com.controle.pedidos.model.Produto;
import br.com.controle.pedidos.populator.Populator;
import org.springframework.stereotype.Component;

@Component
public class ProdutoPopulator implements Populator<Produto, ProdutoResponseDTO> {


    @Override
    public void populate(Produto source, ProdutoResponseDTO target) {
        target.setNome(source.getNome());
        target.setPreco(source.getPreco().toString());
    }
}
