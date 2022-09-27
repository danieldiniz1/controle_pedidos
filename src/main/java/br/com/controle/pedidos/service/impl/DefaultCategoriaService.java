package br.com.controle.pedidos.service.impl;

import br.com.controle.pedidos.exception.CategoriaNotFoundException;
import br.com.controle.pedidos.model.Categoria;
import br.com.controle.pedidos.repository.CategoriaRepository;
import br.com.controle.pedidos.service.CategoriaService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DefaultCategoriaService implements CategoriaService {

    private static final Logger LOGGER = LogManager.getLogger();

    @Autowired
    private CategoriaRepository categoriaRepository;

    @Override
    public Categoria buscarPorId(Long id) {
        return categoriaRepository.findById(id).orElseThrow(() -> new CategoriaNotFoundException("" +
                "Não foi encontrado uma categoria com o id " + id.toString()));
    }

    @Override
    public void salvarListaCategorias(List<Categoria> categorias) {
        LOGGER.info("Cadastrando lista de categorias no banco de dados");
        categoriaRepository.saveAll(categorias);
    }
}
