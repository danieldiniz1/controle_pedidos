package br.com.controle.pedidos.controller.dto;

import br.com.controle.pedidos.model.Cliente;
import br.com.controle.pedidos.model.Endereco;
import br.com.controle.pedidos.model.ItemPedido;
import br.com.controle.pedidos.model.Pagamento;

import java.util.Set;

public class PedidoResponseDTO {

    private String id;
    private String dataPedido;
    private Cliente cliente;
    private Endereco enderecoDeEntrega;

    private Set<ItemPedido> itemPedido;

    private Pagamento pagamento;

    public PedidoResponseDTO() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDataPedido() {
        return dataPedido;
    }

    public void setDataPedido(String dataPedido) {
        this.dataPedido = dataPedido;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Endereco getEnderecoDeEntrega() {
        return enderecoDeEntrega;
    }

    public void setEnderecoDeEntrega(Endereco enderecoDeEntrega) {
        this.enderecoDeEntrega = enderecoDeEntrega;
    }

    public Pagamento getPagamento() {
        return pagamento;
    }

    public void setPagamento(Pagamento pagamento) {
        this.pagamento = pagamento;
    }

    public Set<ItemPedido> getItemPedido() {
        return itemPedido;
    }

    public void setItemPedido(Set<ItemPedido> itemPedido) {
        this.itemPedido = itemPedido;
    }
}
