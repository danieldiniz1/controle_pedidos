package br.com.controle.pedidos.model;

import br.com.controle.pedidos.model.enums.EstadoPagamento;

import javax.persistence.*;
import java.util.Objects;

@Entity(name = "pagamentos")
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Pagamento {

    @Id
    private Long id;
    private Integer estadoPagamento;
    @OneToOne
    @JoinColumn(name = "pedido_id")
    @MapsId
    private Pedido pedido;

    public Pagamento() {
    }

    public Pagamento(EstadoPagamento estadoPagamento, Pedido pedido) {
        this.estadoPagamento = estadoPagamento.getCodigo();
        this.pedido = pedido;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public EstadoPagamento getEstadoPagamento() {
        return EstadoPagamento.toEnum(estadoPagamento);
    }

    public void setEstadoPagamento(EstadoPagamento estadoPagamento) {
        this.estadoPagamento = estadoPagamento.getCodigo();
    }

    public Pedido getPedido() {
        return pedido;
    }

    public void setPedido(Pedido pedido) {
        this.pedido = pedido;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Pagamento pagamento)) return false;
        return getId().equals(pagamento.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }
}
