package br.com.controle.pedidos.controller.dto;

import br.com.controle.pedidos.model.Produto;

import java.util.List;

public class CategoriaResponseDTO {

    private String nome;
    private List<Produto> produtos;

    public CategoriaResponseDTO() {
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public List<Produto> getProdutos() {
        return produtos;
    }

    public void setProdutos(List<Produto> produtos) {
        this.produtos = produtos;
    }
}
