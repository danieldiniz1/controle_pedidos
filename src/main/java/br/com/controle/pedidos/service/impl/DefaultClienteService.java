package br.com.controle.pedidos.service.impl;

import br.com.controle.pedidos.controller.dto.ClienteResponseDTO;
import br.com.controle.pedidos.controller.form.ClienteForm;
import br.com.controle.pedidos.exception.ObjetoNotFoundException;
import br.com.controle.pedidos.model.Cliente;
import br.com.controle.pedidos.populator.Populator;
import br.com.controle.pedidos.populator.impl.ClienteResponsePopulator;
import br.com.controle.pedidos.repository.ClienteRepository;
import br.com.controle.pedidos.service.ClienteService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DefaultClienteService implements ClienteService {

    private static final Logger LOGGER = LogManager.getLogger();

    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    private ClienteResponsePopulator clienteResponsePopulator;

    @Autowired
    private Populator<ClienteForm,Cliente> clientePopulator;

    @Override
    public void cadastrarCliente(Cliente cliente) {
        LOGGER.info("iniciando o cadastro do cliente com nome: " + cliente.getNome());
        clienteRepository.save(cliente);
    }

    @Override
    public void cadastrarClientes(List<Cliente> clientes) {
        clienteRepository.saveAll(clientes);
    }

    @Override
    public ClienteResponseDTO buscarClientePorId(Long id) {
        Cliente cliente = clienteRepository.findById(id).orElseThrow(() -> new ObjetoNotFoundException("não foi encontrado cliente com id: " + id.toString()));
        return converterToClienteResponseDTO(cliente,new ClienteResponseDTO());
    }

    @Override
    public void atualizarCliente(Cliente cliente) {
        clienteRepository.save(cliente);
    }

    @Override
    public void atualizarCliente(ClienteForm clienteForm, Long id) {
        atualizarCliente(converterToCLienteFromForm(
                clienteForm,
                clienteRepository.findById(id).orElseThrow(() -> new ObjetoNotFoundException("não foi encontrado cliente com id: " + id))));
    }

    private Cliente converterToCLienteFromForm(ClienteForm clienteForm, Cliente cliente) {
        clientePopulator.populate(clienteForm,cliente);
        return cliente;
    }

    private ClienteResponseDTO converterToClienteResponseDTO(Cliente cliente, ClienteResponseDTO clienteResponseDTO) {
        clienteResponsePopulator.populate(cliente,clienteResponseDTO);
        return clienteResponseDTO;
    }
}
