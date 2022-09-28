package br.com.controle.pedidos.service;

import br.com.controle.pedidos.model.Cliente;

import java.util.List;

public interface ClienteService {
    void cadastrarCliente(Cliente cliente);

    void cadastrarClientes(List<Cliente> clientes);
}
