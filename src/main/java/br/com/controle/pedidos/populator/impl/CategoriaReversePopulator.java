package br.com.controle.pedidos.populator.impl;

import br.com.controle.pedidos.controller.form.CategoriaForm;
import br.com.controle.pedidos.model.Categoria;
import br.com.controle.pedidos.populator.Populator;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;

@Component
public class CategoriaReversePopulator implements Populator<CategoriaForm, Categoria> {
    @Override
    public void populate(CategoriaForm source, Categoria target) {
        target.setId(source.getId());
        target.setNome(source.getNome());

    }


}
