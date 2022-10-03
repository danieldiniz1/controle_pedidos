package br.com.controle.pedidos.controller.form;



import javax.validation.constraints.NotBlank;

public class CategoriaForm {

    public Long id;
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

    public Long getId() {
        return id;
    }

    public void setId(Long getId) {
        this.id = getId;
    }
}
