package br.com.controle.pedidos.controller;

import br.com.controle.pedidos.model.Categoria;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/categorias")
public class CategoriaController {

    private static final Logger LOGGER = LogManager.getLogger();

    @GetMapping
    public ResponseEntity testar(){
        Categoria informatica = Categoria.valueOf(1L, "Informática");
        LOGGER.info("hashcode informatica: " + informatica.hashCode());
        Categoria escritorio = Categoria.valueOf(2L, "Escritório");
        LOGGER.info("hashcode categoria: " + informatica.hashCode());
        List<Categoria> categorias = new ArrayList<>();
        categorias.addAll(Arrays.asList(informatica,escritorio));
        categorias.stream().forEach(System.out::println);
        return ResponseEntity.status(200).body(categorias);
    }
}
