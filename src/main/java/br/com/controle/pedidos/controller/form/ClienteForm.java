package br.com.controle.pedidos.controller.form;

import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

public class ClienteForm {

    private Long id;
    @NotBlank(message = "nome não pode estar vazio")
    @Length(min = 3, max = 255, message = "nome esta fora do padrão")
    private String nome;
    @Email
    private String email;

    public ClienteForm() {
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
}
