package br.com.controle.pedidos.service.impl;

import br.com.controle.pedidos.exception.CategoriaNotFoundException;
import br.com.controle.pedidos.model.Categoria;
import br.com.controle.pedidos.repository.CategoriaRepository;
import br.com.controle.pedidos.service.CategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DefaultCategoriaService implements CategoriaService {

    @Autowired
    private CategoriaRepository categoriaRepository;

    @Override
    public Categoria buscarPorId(Long id) {
        return categoriaRepository.findById(id).orElseThrow(() -> new CategoriaNotFoundException("" +
                "Não foi encontrado uma categoria com o id " + id.toString()));
    }
}
