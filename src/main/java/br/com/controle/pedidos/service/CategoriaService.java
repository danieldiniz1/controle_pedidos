package br.com.controle.pedidos.service;

import br.com.controle.pedidos.controller.dto.CategoriaResponseDTO;
import br.com.controle.pedidos.model.Categoria;
import br.com.controle.pedidos.model.Produto;

import java.util.List;

public interface CategoriaService {

    CategoriaResponseDTO buscarPorId(Long id);

    void salvarListaCategorias(List<Categoria> categorias);

}
