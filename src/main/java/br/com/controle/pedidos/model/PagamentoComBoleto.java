package br.com.controle.pedidos.model;

import br.com.controle.pedidos.model.enums.EstadoPagamento;

import javax.persistence.Entity;
import java.time.LocalDateTime;
@Entity
public class PagamentoComBoleto extends Pagamento{

    private LocalDateTime dataVencimento;
    private LocalDateTime dataPagamento;

    public PagamentoComBoleto() {
    }

    public PagamentoComBoleto(EstadoPagamento estadoPagamento, Pedido pedido, LocalDateTime dataVencimento, LocalDateTime dataPagamento) {
        super(estadoPagamento, pedido);
        this.dataVencimento = dataVencimento;
        this.dataPagamento = dataPagamento;
    }

    public LocalDateTime getDataVencimento() {
        return dataVencimento;
    }

    public void setDataVencimento(LocalDateTime dataVencimento) {
        this.dataVencimento = dataVencimento;
    }

    public LocalDateTime getDataPagamento() {
        return dataPagamento;
    }

    public void setDataPagamento(LocalDateTime dataPagamento) {
        this.dataPagamento = dataPagamento;
    }

    public static PagamentoComBoleto valueOf(EstadoPagamento estadoPagamento, Pedido pedido, LocalDateTime dataVencimento, LocalDateTime dataPagamento){
        //colocar validation;
        return new PagamentoComBoleto(estadoPagamento,pedido,dataVencimento,dataPagamento);
    }
}
