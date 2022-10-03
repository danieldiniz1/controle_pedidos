package br.com.controle.pedidos.controller;

import br.com.controle.pedidos.controller.dto.PedidoResponseDTO;
import br.com.controle.pedidos.service.PedidoService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/pedidos")
public class PedidoController {

    private static final Logger LOGGER = LogManager.getLogger();

    @Autowired
    private PedidoService pedidoService;


    @GetMapping("{id}")
    public ResponseEntity buscarPedidoPorId(@PathVariable Long id){
        PedidoResponseDTO responseDTO = pedidoService.buscarPedidoPorId(id);
        return ResponseEntity.status(200).body(responseDTO);
    }
}
