package br.com.controle.pedidos.repository;

import br.com.controle.pedidos.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

public interface ClienteRepository extends JpaRepository<Cliente,Long> {

    @Transactional(readOnly = true)
    Cliente findByEmail(String email);

    Boolean existsByEmail(String email);
}
