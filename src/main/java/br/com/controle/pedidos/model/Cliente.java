package br.com.controle.pedidos.model;

import br.com.controle.pedidos.model.enums.TipoCliente;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import org.springframework.util.Assert;

import javax.persistence.*;
import java.util.*;

@Entity(name = "clientes")
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String email;
    private String cpf;
    private String cnpj;
    private Integer tipoCliente;
    @OneToMany(mappedBy = "cliente")
    @JsonManagedReference
    private List<Endereco> enderecos = new ArrayList<>();
    @ElementCollection
    @CollectionTable(name = "Telefone")
    private Set<String> telefones = new HashSet<>();

    @OneToMany(mappedBy = "cliente")
    private List<Pedido> pedidos = new ArrayList<>();

    public Cliente() {
    }

    public Cliente(String nome, String email, String cpf,TipoCliente tipoCliente) {
        this.nome = nome;
        this.email = email;
        this.cpf = cpf;
        this.tipoCliente = tipoCliente.getCodigo();
    }

    public Cliente(String nome, String email,TipoCliente tipoCliente, String cnpj) {
        this.nome = nome;
        this.email = email;
        this.cnpj = cnpj;
        this.tipoCliente = tipoCliente.getCodigo();
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public List<Endereco> getEnderecos() {
        return enderecos;
    }

    public void setEnderecos(List<Endereco> enderecos) {
        this.enderecos = enderecos;
    }

    public Set<String> getTelefones() {
        return telefones;
    }

    public void setTelefones(Set<String> telefones) {
        this.telefones = telefones;
    }
    public void setTelefones(List<String> telefones) {
        getTelefones().addAll(telefones);
    }

    public TipoCliente getTipoCliente() {
        return TipoCliente.toEnum(this.tipoCliente);
    }

    public void setTipoCliente(TipoCliente tipoCliente) {
        this.tipoCliente = tipoCliente.getCodigo();
    }

    public List<Pedido> getPedidos() {
        return pedidos;
    }

    public void setPedidos(List<Pedido> pedidos) {
        this.pedidos = pedidos;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Cliente cliente)) return false;
        return getId().equals(cliente.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }

    public static Cliente valueOf(String nome, String email, String cpf, String cnpj,TipoCliente tipoCliente){
        validation(nome,email,cpf,cnpj,tipoCliente);
        if (tipoCliente.equals(TipoCliente.PESSOAFISICA)){
            return new Cliente(nome,email,cpf,tipoCliente);
        }
        return new Cliente(nome,email,tipoCliente,cnpj);
    }

    private static void validation(String nome, String email, String cpf, String cnpj, TipoCliente tipoCliente) {
        Assert.notNull(nome, "O nome não pode ser nulo");
        Assert.notNull(email, "O email não pode ser nulo");
        Assert.notNull(tipoCliente, "O tipo não pode ser nulo");
        if (tipoCliente.equals(TipoCliente.PESSOAFISICA)){
            Assert.notNull(cpf, "O cpf não pode ser nulo");
        } else {
            Assert.notNull(cnpj, "O cnpj não pode ser nulo");
        }
    }
}
