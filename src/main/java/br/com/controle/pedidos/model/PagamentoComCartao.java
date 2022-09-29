package br.com.controle.pedidos.model;

import br.com.controle.pedidos.model.enums.EstadoPagamento;

import javax.persistence.Entity;

@Entity
public class PagamentoComCartao extends Pagamento{

    private Integer numeroParcelas;

    public PagamentoComCartao() {
    }

    public PagamentoComCartao(EstadoPagamento estadoPagamento, Pedido pedido, Integer numeroParcelas) {
        super(estadoPagamento, pedido);
        this.numeroParcelas = numeroParcelas;
    }

    public Integer getNumeroParcelas() {
        return numeroParcelas;
    }

    public void setNumeroParcelas(Integer numeroParcelas) {
        this.numeroParcelas = numeroParcelas;
    }

    public static PagamentoComCartao valueOf(EstadoPagamento estadoPagamento, Pedido pedido, Integer numeroParcelas){
        return new PagamentoComCartao(estadoPagamento,pedido,numeroParcelas);
    }
}
