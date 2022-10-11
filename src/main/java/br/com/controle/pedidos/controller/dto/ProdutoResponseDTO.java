package br.com.controle.pedidos.controller.dto;

import br.com.controle.pedidos.model.Produto;

public class ProdutoResponseDTO {

    private String nome;
    private String preco;

    public ProdutoResponseDTO() {
    }

    public ProdutoResponseDTO(String nome, String preco) {
        this.nome = nome;
        this.preco = preco;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getPreco() {
        return preco;
    }

    public void setPreco(String preco) {
        this.preco = preco;
    }

    public static ProdutoResponseDTO valueOf(Produto produto){
        return new ProdutoResponseDTO(produto.getNome(), produto.getPreco().toString());
    }
}
