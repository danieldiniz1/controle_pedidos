package br.com.controle.pedidos.controller;

import br.com.controle.pedidos.controller.dto.CategoriaResponseDTO;
import br.com.controle.pedidos.controller.form.CategoriaForm;
import br.com.controle.pedidos.model.Categoria;
import br.com.controle.pedidos.service.CategoriaService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/categorias")
public class CategoriaController {

    private static final Logger LOGGER = LogManager.getLogger();

    @Autowired
    private CategoriaService categoriaService;

    @GetMapping(value = "/{id}")
    public ResponseEntity buscarCategoriaPorId(@PathVariable Long id){

        return ResponseEntity.status(200).body(categoriaService.buscarPorId(id));
    }

    @PostMapping()
    public ResponseEntity cadastroCategoria(@RequestBody @Valid CategoriaForm categoriaForm){
        Categoria categoriaCriada = categoriaService.salvarCategoria(categoriaForm);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(categoriaCriada.getId())
                .toUri();
        return ResponseEntity.created(uri).build();
    }

    @PutMapping("/{id}")
    public ResponseEntity atualizarCategoria(@RequestBody @Valid CategoriaForm categoriaForm,@PathVariable Long id){
        categoriaService.atualizarCategoria(categoriaForm,id);
        return ResponseEntity.noContent().build();
    }
}
