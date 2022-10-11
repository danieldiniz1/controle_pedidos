package br.com.controle.pedidos.service;

import br.com.controle.pedidos.controller.dto.ClienteResponseDTO;
import br.com.controle.pedidos.controller.form.ClienteForm;
import br.com.controle.pedidos.model.Cliente;
import org.springframework.data.domain.Page;

import java.util.List;

public interface ClienteService {
    void cadastrarCliente(Cliente cliente);

    Cliente cadastrarCliente(ClienteForm clienteForm);

    void cadastrarClientes(List<Cliente> clientes);

    ClienteResponseDTO buscarClientePorId(Long id);

    void atualizarCliente(Cliente cliente);

    void atualizarCliente(ClienteForm clienteForm, Long id);

    Page<ClienteResponseDTO> buscarTodosClientes(Integer page, Integer linesPerPage, String orderBy, String direction);

    void excluirClientePorId(Long id);
}
