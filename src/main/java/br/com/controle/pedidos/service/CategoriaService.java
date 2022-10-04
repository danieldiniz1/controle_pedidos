package br.com.controle.pedidos.service;

import br.com.controle.pedidos.controller.dto.CategoriaResponseDTO;
import br.com.controle.pedidos.controller.dto.MapaCategoriasDTO;
import br.com.controle.pedidos.controller.form.CategoriaForm;
import br.com.controle.pedidos.model.Categoria;

import java.util.List;

public interface CategoriaService {

    CategoriaResponseDTO buscarPorId(Long id);

    void salvarListaCategorias(List<Categoria> categorias);

    Categoria salvarCategoria(CategoriaForm categoriaForm);

    void atualizarCategoria(CategoriaForm categoriaForm, Long id);

    void deletarCategoria(Long id);

    MapaCategoriasDTO buscarTodasCategorias();
}
