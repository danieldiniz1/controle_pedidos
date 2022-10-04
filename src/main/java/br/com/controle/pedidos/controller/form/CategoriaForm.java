package br.com.controle.pedidos.controller.form;



import org.hibernate.validator.constraints.Length;
import org.springframework.beans.factory.annotation.Value;

import javax.validation.constraints.Max;
import javax.validation.constraints.NotBlank;

public class CategoriaForm {

    public Long id;
    //    @NotNull(message = "O Nome da Categoria não pode ser nulo")
    @NotBlank(message = "O Nome da Categoria não pode ser em branco ou vazio")
    @Length(min = 5, max = 80, message = "Quantidade de caracteres fora da especificação (tamnanhao 5 a 80 caracteres) ")
    private String nome;


    public CategoriaForm() {
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long getId) {
        this.id = getId;
    }
}
