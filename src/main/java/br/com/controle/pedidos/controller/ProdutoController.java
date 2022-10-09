package br.com.controle.pedidos.controller;

import br.com.controle.pedidos.service.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/produtos")
public class ProdutoController {

    @Autowired
    ProdutoService produtoService;

    @GetMapping
    public ResponseEntity buscarProdutosPorNome(@RequestParam(value = "nome") String nome,
                                                @RequestParam(value = "page",defaultValue = "0") Integer page,
                                                @RequestParam(value = "linesPerPage",defaultValue = "24") Integer linesPerPage,
                                                @RequestParam(value = "orderBy",defaultValue = "nome") String orderBy,
                                                @RequestParam(value = "direction",defaultValue = "ASC") String direction){
        return ResponseEntity.ok().body(produtoService.buscarProdutos(page,linesPerPage,orderBy,direction,nome,null));
    }
}
