package br.com.controle.pedidos.repository;

import br.com.controle.pedidos.model.Produto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto,Long> {

    Page<Produto> findByNomeContaining(String nome, Pageable page);
}
