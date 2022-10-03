package br.com.controle.pedidos.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import org.springframework.util.Assert;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity(name = "pedidos")
@Inheritance(strategy = InheritanceType.JOINED)
public class Pedido {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDateTime instante;

    @OneToOne(cascade = CascadeType.ALL, mappedBy = "pedido")
    private Pagamento pagamento;
    @ManyToOne
    @JoinColumn(name = "cliente_id")
    private Cliente cliente;
    @ManyToOne
    @JoinColumn(name = "endereco_de_entrega_id")
    private Endereco enderecoDeEntrega;

    @OneToMany(mappedBy = "id.pedido")
    private Set<ItemPedido> itens = new HashSet<>();

    public Pedido() {
    }

    public Pedido(LocalDateTime instante, Pagamento pagamento, Cliente cliente, Endereco enderecoDeEntrega) {
        this.instante = instante;
        this.pagamento = pagamento;
        this.cliente = cliente;
        this.enderecoDeEntrega = enderecoDeEntrega;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDateTime getInstante() {
        return instante;
    }

    public void setInstante(LocalDateTime instante) {
        this.instante = instante;
    }

    public Pagamento getPagamento() {
        return pagamento;
    }

    public void setPagamento(Pagamento pagamento) {
        this.pagamento = pagamento;
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

    public Set<ItemPedido> getItens() {
        return itens;
    }

    public void setItens(Set<ItemPedido> itens) {
        this.itens = itens;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Pedido pedido)) return false;
        return getId().equals(pedido.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }

    public static Pedido valueOf(LocalDateTime instante, Pagamento pagamento, Cliente cliente, Endereco enderecoDeEntrega){
        validation(pagamento, cliente, enderecoDeEntrega);
        return new Pedido(instante == null ? LocalDateTime.now() : instante,
                pagamento,cliente,enderecoDeEntrega);
    }

    private static void validation(Pagamento pagamento, Cliente cliente, Endereco enderecoDeEntrega) {
//        Assert.notNull(pagamento,"Pagamento não pode estar nulo");
        Assert.notNull(cliente,"cliente não pode estar nulo");
        Assert.notNull(enderecoDeEntrega,"Endereco não pode estar nulo");
    }
}
