package br.com.controle.pedidos.controller.form;



import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.List;

public class CategoriaForm {

//    @NotNull(message = "O Nome da Categoria não pode ser nulo")
    @NotBlank(message = "O Nome da Categoria não pode ser em branco ou vazio")
    private String nome;


    public CategoriaForm() {
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }


}
