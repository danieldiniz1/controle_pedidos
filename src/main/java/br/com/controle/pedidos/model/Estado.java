package br.com.controle.pedidos.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.util.Assert;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
public class Estado {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    @OneToMany(mappedBy = "estado")
    @JsonIgnore
    private List<Cidade> cidades = new ArrayList<>();

    public Estado() {
    }

    public Estado(String nome) {
        this.id = id;
        this.nome = nome;
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

    public List<Cidade> getCidades() {
        return cidades;
    }

    public void setCidades(List<Cidade> cidades) {
        this.cidades = cidades;
    }

    public void adicionarCidade(Cidade cidade){
        cidades.add(cidade);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Estado estado)) return false;
        return getId().equals(estado.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }

    public static Estado valueOf(String nome){
        Assert.notNull(nome, "O nome não pode ser nulo");
        return new Estado(nome);
    }
}
