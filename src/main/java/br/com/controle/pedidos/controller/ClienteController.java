package br.com.controle.pedidos.controller;

import br.com.controle.pedidos.controller.dto.ClienteResponseDTO;
import br.com.controle.pedidos.controller.form.ClienteForm;
import br.com.controle.pedidos.service.ClienteService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/clientes")
public class ClienteController {

    private static final Logger LOGGER = LogManager.getLogger();

    @Autowired
    private ClienteService clienteService;

    @GetMapping("{id}")
    public ResponseEntity buscarClienteId(@PathVariable Long id){

        return ResponseEntity.status(200).body(clienteService.buscarClientePorId(id));
    }

    @GetMapping
    public ResponseEntity<Page<ClienteResponseDTO>> buscarTodosClientes(
            @RequestParam(value = "page",defaultValue = "0") Integer page,
            @RequestParam(value = "linesPerPage",defaultValue = "24") Integer linesPerPage,
            @RequestParam(value = "orderBy",defaultValue = "nome") String orderBy,
            @RequestParam(value = "direction",defaultValue = "ASC") String direction){
        Page<ClienteResponseDTO> clientes = clienteService.buscarTodosClientes(page,linesPerPage,orderBy,direction);
        return ResponseEntity.ok(clientes);

    }

    @PutMapping("/{id}")
    public ResponseEntity atualizarClientePorId(@PathVariable Long id, @Valid @RequestBody ClienteForm form){
        clienteService.atualizarCliente(form,id);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity excluirClientePorId(@PathVariable Long id){
        clienteService.excluirClientePorId(id);
        return ResponseEntity.noContent().build();
    }
}
