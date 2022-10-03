package br.com.controle.pedidos.controller.dto;

public class PedidoResponseDTO {

    private String id;
    private String dataPedido;

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
}
