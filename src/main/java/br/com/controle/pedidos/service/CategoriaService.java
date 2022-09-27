package br.com.controle.pedidos.service;

import br.com.controle.pedidos.model.Categoria;

import java.util.List;

public interface CategoriaService {

    Categoria buscarPorId(Long id);

    void salvarListaCategorias(List<Categoria> categorias);
}
