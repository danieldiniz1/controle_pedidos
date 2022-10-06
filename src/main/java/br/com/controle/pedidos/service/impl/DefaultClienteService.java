package br.com.controle.pedidos.service.impl;

import br.com.controle.pedidos.controller.dto.ClienteResponseDTO;
import br.com.controle.pedidos.controller.form.ClienteForm;
import br.com.controle.pedidos.exception.DataIntegrityException;
import br.com.controle.pedidos.exception.DataViolationException;
import br.com.controle.pedidos.exception.ObjetoNotFoundException;
import br.com.controle.pedidos.model.Cliente;
import br.com.controle.pedidos.model.Endereco;
import br.com.controle.pedidos.populator.Populator;
import br.com.controle.pedidos.populator.impl.ClienteResponsePopulator;
import br.com.controle.pedidos.repository.ClienteRepository;
import br.com.controle.pedidos.service.CidadeService;
import br.com.controle.pedidos.service.ClienteService;
import br.com.controle.pedidos.service.EnderecoService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.exception.ConstraintViolationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class DefaultClienteService implements ClienteService {

    private static final Logger LOGGER = LogManager.getLogger();

    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    private EnderecoService enderecoService;

    @Autowired
    private CidadeService cidadeService;

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
    public Cliente cadastrarCliente(ClienteForm clienteForm) {
        //verificar se o cliente já não está cadastrado
        Cliente cliente = Cliente.clienteEmpty();
        List<Endereco> enderecos = Arrays.asList(Endereco.valueOf(clienteForm.getLogradouro(), clienteForm.getNumero(), clienteForm.getComplemento(), clienteForm.getBairro(),
                clienteForm.getCep(), cliente, cidadeService.buscarCidadePorId(clienteForm.getCidadeId())));
        clientePopulator.populate(clienteForm,cliente);
        cliente.setEnderecos(enderecos);
        cadastrarCliente(cliente);
        enderecoService.cadastrarEnderecos(enderecos);
        return cliente;
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

    @Override
    public Page<ClienteResponseDTO> buscarTodosClientes(Integer page, Integer linesPerPage, String orderBy, String direction) {
        Page<Cliente> allClientes = clienteRepository.findAll(PageRequest.of(page, linesPerPage, Sort.Direction.valueOf(direction), orderBy));
        Page<ClienteResponseDTO> response = allClientes.map((c) -> ClienteResponseDTO.ValueOf(c));
        return response;
    }

    @Override
    public void excluirClientePorId(Long id) {
        try {
            clienteRepository.deleteById(id);
        } catch (DataIntegrityViolationException e){
            throw new DataViolationException("Não é possivel deletar o cliente porque existem associações para ele");
        }
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
