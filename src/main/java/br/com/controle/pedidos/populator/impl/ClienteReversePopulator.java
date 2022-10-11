package br.com.controle.pedidos.populator.impl;

import br.com.controle.pedidos.controller.form.ClienteForm;
import br.com.controle.pedidos.model.Cliente;
import br.com.controle.pedidos.model.Endereco;
import br.com.controle.pedidos.model.enums.TipoCliente;
import br.com.controle.pedidos.populator.Populator;
import br.com.controle.pedidos.repository.CidadeRepository;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.Set;

@Component
public class ClienteReversePopulator implements Populator<ClienteForm, Cliente> {
    @Override
    public void populate(ClienteForm source, Cliente target) {
        if (target.getTipoCliente() != null){
            populateToUpdate(source, target);
        } else {
            populateToNewCliente(source,target);
        }
    }

    private void populateToNewCliente(ClienteForm source, Cliente target) {
        populateToUpdate(source,target);
        target.setTipoCliente(TipoCliente.toEnum(source.getTipoCliente()));
        target.setTelefones(Set.of(source.getTelefone(),source.getTelefone2(),source.getTelefone3()));
        target.setCpf(source.getCpf().isEmpty() ? null : source.getCpf());
        target.setCnpj(source.getCnpj().isEmpty() ? null : source.getCnpj());
//        target.setEnderecos(Arrays.asList(Endereco.valueOf(
//                source.getLogradouro(),
//                source.getNumero(),
//                source.getComplemento(),
//                source.getBairro(),
//                source.getCep(), null, null)));

    }

    private static void populateToUpdate(ClienteForm source, Cliente target) {
        target.setNome(source.getNome());
        target.setEmail(source.getEmail());
    }
}
