package br.com.controle.pedidos.service.impl;

import br.com.controle.pedidos.controller.dto.CategoriaResponseDTO;
import br.com.controle.pedidos.controller.dto.MapaCategoriasDTO;
import br.com.controle.pedidos.controller.form.CategoriaForm;
import br.com.controle.pedidos.exception.DataIntegrityException;
import br.com.controle.pedidos.exception.ObjetoNotFoundException;
import br.com.controle.pedidos.model.Categoria;
import br.com.controle.pedidos.populator.Populator;
import br.com.controle.pedidos.repository.CategoriaRepository;
import br.com.controle.pedidos.service.CategoriaService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DefaultCategoriaService implements CategoriaService {

    private static final Logger LOGGER = LogManager.getLogger();

    @Autowired
    private CategoriaRepository categoriaRepository;
    @Autowired
    private Populator<Categoria,CategoriaResponseDTO> categoriaResponseDTOPopulator;

    @Autowired
    private Populator<CategoriaForm,Categoria> categoriaPopulator;

    @Override
    public CategoriaResponseDTO buscarPorId(Long id) {
        Categoria categoria = categoriaRepository.findById(id).orElseThrow(() -> new ObjetoNotFoundException("" +
                "Não foi encontrado uma categoria com o id " + id.toString()));
        return converterCategoriaDTO(categoria, new CategoriaResponseDTO());
    }

    @Override
    public void salvarListaCategorias(List<Categoria> categorias) {
        LOGGER.info("Cadastrando lista de categorias no banco de dados");
        categoriaRepository.saveAll(categorias);
    }

    @Override
    public Categoria salvarCategoria(CategoriaForm categoriaForm) {
        Categoria categoria = Categoria.categoriaBlank();
        categoriaForm.setId(null);
        converterCategoriaFromDTO(categoriaForm, categoria);
        return categoriaRepository.save(categoria);

    }

    @Override
    public void atualizarCategoria(CategoriaForm categoriaForm, Long id) {
        Categoria categoria = categoriaRepository.findById(id).orElseThrow(() -> new ObjetoNotFoundException("" +
                "Não foi encontrado uma categoria com o id " + id.toString()));
        categoriaForm.setId(id);
        converterCategoriaFromDTO(categoriaForm,categoria);
        categoriaRepository.save(categoria);
    }

    @Override
    public void deletarCategoria(Long id) {
        try {
            categoriaRepository.deleteById(id);
        } catch (EmptyResultDataAccessException ex){
            throw new DataIntegrityException("Não foi possivel realizar a deleção pois a categoria não existe");
        }
    }

    @Override
    public MapaCategoriasDTO buscarTodasCategorias() {
        return MapaCategoriasDTO.valueOf(categoriaRepository.findAll());
    }

    @Override
    public Page<Categoria> bucarPagina(Integer page, Integer linesPerPage, String orderBy, String direction) {
        return categoriaRepository.findAll(PageRequest.of(page,linesPerPage, Sort.Direction.valueOf(direction),orderBy));
    }

    private void converterCategoriaFromDTO(CategoriaForm categoriaForm, Categoria categoria) {
        categoriaPopulator.populate(categoriaForm, categoria);
    }

    private CategoriaResponseDTO converterCategoriaDTO(Categoria categoria, CategoriaResponseDTO categoriaResponseDTO) {
        categoriaResponseDTOPopulator.populate(categoria,categoriaResponseDTO);
        return categoriaResponseDTO;
    }
}
