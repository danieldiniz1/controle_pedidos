package br.com.controle.pedidos.controller;

import br.com.controle.pedidos.controller.form.ClienteForm;
import br.com.controle.pedidos.service.ClienteService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
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

    @PutMapping("/{id}")
    public ResponseEntity atualizarClientePorId(@PathVariable Long id, @Valid @RequestBody ClienteForm form){
        clienteService.atualizarCliente(form,id);
        return ResponseEntity.noContent().build();
    }
}
