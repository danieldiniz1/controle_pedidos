package br.com.controle.pedidos.populator.impl;

import br.com.controle.pedidos.controller.dto.CategoriaResponseDTO;
import br.com.controle.pedidos.model.Categoria;
import br.com.controle.pedidos.populator.Populator;
import org.springframework.stereotype.Component;

import java.util.Collections;

@Component // anotaçãop para que o Spring consiga resolver esta classe como bean
public class CategoriaResponsePopulator implements Populator<Categoria, CategoriaResponseDTO> {
    @Override
    public void populate(Categoria source, CategoriaResponseDTO target) {
        target.setNome(source.getNome());
//        target.setProdutos(source.getProdutos() == null ? Collections.emptyList() : source.getProdutos());
    }
}
