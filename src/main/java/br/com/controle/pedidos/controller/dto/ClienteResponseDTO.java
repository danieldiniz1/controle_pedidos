package br.com.controle.pedidos.controller.dto;

import br.com.controle.pedidos.model.Endereco;

import java.util.List;

public class ClienteResponseDTO {

    private String nome;
    private String email;
    private List<String> telefones;
    private List<Endereco> enderecos;


    public ClienteResponseDTO() {
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

    public List<String> getTelefones() {
        return telefones;
    }

    public void setTelefones(List<String> telefones) {
        this.telefones = telefones;
    }

    public List<Endereco> getEnderecos() {
        return enderecos;
    }

    public void setEnderecos(List<Endereco> enderecos) {
        this.enderecos = enderecos;
    }


}
