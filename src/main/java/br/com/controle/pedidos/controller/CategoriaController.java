package br.com.controle.pedidos.controller;

import br.com.controle.pedidos.controller.dto.CategoriaResponseDTO;
import br.com.controle.pedidos.controller.dto.MapaCategoriasDTO;
import br.com.controle.pedidos.controller.form.CategoriaForm;
import br.com.controle.pedidos.model.Categoria;
import br.com.controle.pedidos.service.CategoriaService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;

@RestController
@RequestMapping("/categorias")
public class CategoriaController {

    private static final Logger LOGGER = LogManager.getLogger();

    @Autowired
    private CategoriaService categoriaService;

    @GetMapping()
    public ResponseEntity<MapaCategoriasDTO> buscarTodasCategorias(){
        return ResponseEntity.status(200).body(categoriaService.buscarTodasCategorias());
    }

    @GetMapping("/page")
    public ResponseEntity<Page<Categoria>> buscarTodasCategoriasComPaginacao(
            @RequestParam(value = "page",defaultValue = "0") Integer page,
            @RequestParam(value = "linesPerPage",defaultValue = "24") Integer linesPerPage,
            @RequestParam(value = "orderBy",defaultValue = "nome") String orderBy,
            @RequestParam(value = "direction",defaultValue = "ASC") String direction){
        Page<Categoria> categorias = categoriaService.bucarPagina(page, linesPerPage, orderBy, direction);
        return ResponseEntity.status(200).body(categorias);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<CategoriaResponseDTO> buscarCategoriaPorId(@PathVariable Long id){
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

    @DeleteMapping(value = "/{id}")
    public ResponseEntity deletarCategoriaPorId(@PathVariable Long id){
        categoriaService.deletarCategoria(id);
        return ResponseEntity.noContent().build();
    }
}
