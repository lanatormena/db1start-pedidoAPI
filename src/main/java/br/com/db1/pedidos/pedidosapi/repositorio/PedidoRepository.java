package br.com.db1.pedidos.pedidosapi.repositorio;

import org.springframework.data.repository.CrudRepository;

import br.com.db1.pedidos.pedidosapi.domain.entity.Pedido;

public interface PedidoRepository extends CrudRepository<Pedido, Long> {

	Pedido findByCodigo(String codigo);
}