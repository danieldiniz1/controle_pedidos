package br.com.controle.pedidos.controller.dto;

import br.com.controle.pedidos.model.Categoria;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MapaCategoriasDTO {

    private Map<String,String> categorias;

    public MapaCategoriasDTO() {
    }

    public MapaCategoriasDTO(HashMap<String, String> categorias) {
        this.categorias = categorias;
    }

    public Map<String, String> getCategorias() {
        return categorias;
    }

    public void setCategorias(HashMap<String, String> categorias) {
        this.categorias = categorias;
    }

    public static MapaCategoriasDTO valueOf(List<Categoria> categorias){
        HashMap<String,String> categoriaMap = new HashMap<>();
        categorias.forEach(categoria -> categoriaMap.put(categoria.getId().toString(),categoria.getNome()));
        return new MapaCategoriasDTO(categoriaMap);
    }
}
