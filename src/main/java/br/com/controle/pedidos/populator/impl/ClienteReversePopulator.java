package br.com.controle.pedidos.populator.impl;

import br.com.controle.pedidos.controller.form.ClienteForm;
import br.com.controle.pedidos.model.Cliente;
import br.com.controle.pedidos.populator.Populator;
import org.springframework.stereotype.Component;

@Component
public class ClienteReversePopulator implements Populator<ClienteForm, Cliente> {
    @Override
    public void populate(ClienteForm source, Cliente target) {
        target.setNome(source.getNome());
        target.setEmail(source.getEmail());
    }
}
