package br.com.controle.pedidos.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.util.Assert;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity(name = "produtos")
public class Produto {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private BigDecimal preco;
    @ManyToMany(mappedBy = "produtos")
    @JsonIgnore
    private List<Categoria> categorias = new ArrayList<>();

    public Produto() {
    }

    public Produto(String nome, BigDecimal preco) {
        this.nome = nome;
        this.preco = preco;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public BigDecimal getPreco() {
        return preco;
    }

    public void setPreco(BigDecimal preco) {
        this.preco = preco;
    }

    public List<Categoria> getCategorias() {
        return categorias;
    }

    public void setCategorias(List<Categoria> categorias) {
        this.categorias = categorias;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Produto produto)) return false;
        return getId().equals(produto.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }

    public static Produto novoProduto(String nome, BigDecimal preco, List<Categoria> categorias){
        validation(nome,preco);
        Assert.notNull(categorias,"Lista de categoria não pode ser nula");
        Produto produto = new Produto(nome, preco);
        produto.setCategorias(categorias);
        return produto;
    }

    public static Produto novoProdutoSemCategoria(String nome, BigDecimal preco){
        validation(nome,preco);
       return new Produto(nome,preco);
    }

    private static void validation(String nome, BigDecimal preco){
        Assert.notNull(nome,"nome do produto não pode ser nulo");
        Assert.notNull(preco,"preco do produto não pode ser nulo");
    }
}
