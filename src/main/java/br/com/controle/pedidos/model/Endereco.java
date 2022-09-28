package br.com.controle.pedidos.model;

import org.springframework.util.Assert;

import javax.persistence.*;
import java.util.Objects;

@Entity(name = "enderecos")
public class Endereco {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String logradouro;
    private String numero;
    private String complemento;
    private String bairro;
    private String cep;
    @ManyToOne
    @JoinColumn(name = "cliente_id")
    private Cliente cliente;
    @ManyToOne
    @JoinColumn(name = "cidade_id")
    private Cidade cidade;

    public Endereco() {
    }

    public Endereco(String logradouro, String numero, String complemento, String bairro, String cep, Cliente cliente,
                    Cidade cidade) {
        this.logradouro = logradouro;
        this.numero = numero;
        this.complemento = complemento;
        this.bairro = bairro;
        this.cep = cep;
        this.cliente = cliente;
        this.cidade = cidade;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLogradouro() {
        return logradouro;
    }

    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Cidade getCidade() {
        return cidade;
    }

    public void setCidade(Cidade cidade) {
        this.cidade = cidade;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Endereco endereco)) return false;
        return getId().equals(endereco.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }

    public static Endereco valueOf(String logradouro, String numero, String complemento, String bairro, String cep, Cliente cliente,
                                   Cidade cidade ){
        validate(logradouro,numero,complemento,bairro,cep,cliente,cidade);
        return new Endereco(logradouro,numero,complemento,bairro,cep,cliente,cidade);

    }

    private static void validate(String logradouro, String numero, String complemento, String bairro, String cep, Cliente cliente, Cidade cidade) {
        validationNotEmpty(logradouro,numero,cep);
        validationNotNull(logradouro, numero, complemento, bairro, cep, cliente, cidade);
    }

    private static void validationNotNull(String logradouro, String numero, String complemento, String bairro, String cep, Cliente cliente, Cidade cidade) {
        Assert.notNull(logradouro,"Logradouro não pode ser nulo");
        Assert.notNull(numero,"número não pode ser nulo");
        Assert.notNull(complemento,"complemento não pode ser nulo");
        Assert.notNull(bairro,"Bairro não pode ser nulo");
        Assert.notNull(cep,"CEP não pode ser nulo");
        Assert.notNull(cliente,"Cliente não pode ser nulo");
        Assert.notNull(cidade,"cidade não pode ser nulo");
    }

    private static void validationNotEmpty(String logradouro, String numero, String cep) {
        if (logradouro.isEmpty() || numero.isEmpty() || cep.isEmpty()){
            throw new IllegalArgumentException("Argumentos não podem ser vazios");
        }
    }
}
