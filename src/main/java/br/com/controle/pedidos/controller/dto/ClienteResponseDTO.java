package br.com.controle.pedidos.controller.dto;

import br.com.controle.pedidos.model.Cliente;
import br.com.controle.pedidos.model.Endereco;

import java.util.List;

public class ClienteResponseDTO {

    private String nome;
    private String email;
    private List<String> telefones;
    private List<Endereco> enderecos;


    public ClienteResponseDTO() {
    }

    public ClienteResponseDTO(String nome, String email, List<String> telefones, List<Endereco> enderecos) {
        this.nome = nome;
        this.email = email;
        this.telefones = telefones;
        this.enderecos = enderecos;
    }

    public static ClienteResponseDTO ValueOf(Cliente cliente) {
        return new ClienteResponseDTO(cliente.getNome(),cliente.getEmail(), cliente.getTelefones().stream().toList(),cliente.getEnderecos());
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
