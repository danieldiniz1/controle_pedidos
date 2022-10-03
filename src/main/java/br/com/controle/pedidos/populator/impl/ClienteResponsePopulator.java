package br.com.controle.pedidos.populator.impl;

import br.com.controle.pedidos.controller.dto.ClienteResponseDTO;
import br.com.controle.pedidos.model.Cliente;
import br.com.controle.pedidos.populator.Populator;
import org.springframework.stereotype.Component;

@Component
public class ClienteResponsePopulator implements Populator<Cliente, ClienteResponseDTO> {
    @Override
    public void populate(Cliente source, ClienteResponseDTO target) {
        target.setNome(source.getNome());
        target.setEmail(source.getEmail());
        target.setTelefones(source.getTelefones().stream().toList());
        target.setEnderecos(source.getEnderecos());

    }
}
