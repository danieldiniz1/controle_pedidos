package br.com.controle.pedidos.controller.dto;

import br.com.controle.pedidos.model.Categoria;

import java.util.List;

public class ListaCategoriasDTO {

    private List<Categoria> categorias;

    public ListaCategoriasDTO() {
    }

    public ListaCategoriasDTO(List<Categoria> categorias) {
        this.categorias = categorias;
    }

    public List<Categoria> getCategorias() {
        return categorias;
    }

    public void setCategorias(List<Categoria> categorias) {
        this.categorias = categorias;
    }

    public static ListaCategoriasDTO valueOf(List<Categoria> categorias){
        return new ListaCategoriasDTO(categorias);
    }
}
