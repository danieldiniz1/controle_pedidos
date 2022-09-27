package br.com.controle.pedidos.controller;

import br.com.controle.pedidos.model.Categoria;
import br.com.controle.pedidos.service.CategoriaService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
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
    public ResponseEntity testar(@PathVariable Long id){
//        Categoria informatica = Categoria.valueOf(1L, "Informática");
//        LOGGER.info("hashcode informatica: " + informatica.hashCode());
//        Categoria escritorio = Categoria.valueOf(2L, "Escritório");
//        LOGGER.info("hashcode categoria: " + informatica.hashCode());
        try {
            return ResponseEntity.status(200).body(categoriaService.buscarPorId(id));
        } catch (Exception e){
            LOGGER.error("erro: " + e.getMessage());
            return ResponseEntity.badRequest().build();
        }
    }
}
