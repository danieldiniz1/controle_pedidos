package br.com.controle.pedidos.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.util.Assert;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import java.math.BigDecimal;
import java.util.Objects;

@Entity
public class ItemPedido {

    private static final Logger LOGGER = LogManager.getLogger();

    @JsonIgnore
    @EmbeddedId
    private ItemPedidoPK id = new ItemPedidoPK();
    private BigDecimal desconto;
    private Integer quantidade;
    private BigDecimal preco;

    public ItemPedido() {
    }

    public ItemPedido(Pedido pedido,Produto produto, BigDecimal desconto, Integer quantidade, BigDecimal preco) {
        id.setPedido(pedido);
        id.setProduto(produto);
        this.desconto = desconto;
        this.quantidade = quantidade;
        this.preco = preco;
    }

    @JsonIgnore
    public Pedido getPedido(){
        return id.getPedido();
    }


    public Produto getProduto(){
        return id.getProduto();
    }

    public ItemPedidoPK getId() {
        return id;
    }

    public void setId(ItemPedidoPK id) {
        this.id = id;
    }

    public BigDecimal getDesconto() {
        return desconto;
    }

    public void setDesconto(BigDecimal desconto) {
        this.desconto = desconto;
    }

    public Integer getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }

    public BigDecimal getPreco() {
        return preco;
    }

    public void setPreco(BigDecimal preco) {
        this.preco = preco;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ItemPedido that)) return false;
        return Objects.equals(getId(), that.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }

    public static ItemPedido valueOf(Pedido pedido,Produto produto, BigDecimal desconto, Integer quantidade, BigDecimal preco){
        validationNotNull(pedido,produto,quantidade);
        desconto = desconto == null ? BigDecimal.ZERO : desconto;
        preco = preco == null ? produto.getPreco() : preco;

        LOGGER.info("preço atribuido: " + preco.toString() + " E desconto de R$ " + desconto.toString());
        return new ItemPedido(pedido,produto,desconto,quantidade,preco);
    }

    private static void validationNotNull(Pedido pedido, Produto produto, Integer quantidade) {
        Assert.notNull(pedido,"Pedido não pode ser null");
        Assert.notNull(produto,"Produto não pode ser null");
        Assert.notNull(quantidade,"Quantidade não pode ser null");
    }
}
