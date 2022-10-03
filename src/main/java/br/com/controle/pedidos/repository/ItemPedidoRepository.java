package br.com.controle.pedidos.repository;

import br.com.controle.pedidos.model.ItemPedido;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemPedidoRepository extends JpaRepository<ItemPedido,Long> {
}
