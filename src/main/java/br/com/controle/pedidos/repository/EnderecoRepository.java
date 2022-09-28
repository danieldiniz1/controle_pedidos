package br.com.controle.pedidos.repository;

import br.com.controle.pedidos.model.Endereco;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EnderecoRepository extends JpaRepository<Endereco,Long> {
}
