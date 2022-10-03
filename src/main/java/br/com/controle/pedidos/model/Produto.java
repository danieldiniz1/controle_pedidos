package br.com.controle.pedidos.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.util.Assert;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.*;
import java.util.stream.Collectors;

@Entity(name = "produtos")
public class Produto {

    private static final Logger LOGGER = LogManager.getLogger();

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private BigDecimal preco;
    @ManyToMany(mappedBy = "produtos")
    @JsonIgnore
    private List<Categoria> categorias = new ArrayList<>();

    @OneToMany(mappedBy = "id.produto")
    @JsonIgnore
    private Set<ItemPedido> itens = new HashSet<>();

    public Produto() {
    }

    public Produto(String nome, BigDecimal preco) {
        this.nome = nome;
        this.preco = preco;
    }

    public List<Pedido> getPedidos(){
        List<Pedido> listaPedidos = new ArrayList<>();
        itens.stream().collect(Collectors.toList()).forEach((itemPedido -> listaPedidos.add(itemPedido.getPedido())));
       listaPedidos.forEach((p) -> LOGGER.info(p.getCliente().getNome()));
        return listaPedidos;
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

    public Set<ItemPedido> getItens() {
        return itens;
    }

    public void setItens(Set<ItemPedido> itens) {
        this.itens = itens;
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
