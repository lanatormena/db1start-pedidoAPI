package br.com.db1.pedidos.pedidosapi.repositorio;

import org.springframework.data.repository.CrudRepository;

import br.com.db1.pedidos.pedidosapi.domain.entity.Produto;
import br.com.db1.pedidos.pedidosapi.domain.entity.ProdutoStatus;

public interface ProdutoRepository extends CrudRepository<Produto, Long> {

	Produto findByCodigo(String codigo);

	Iterable<Produto> findByStatus(ProdutoStatus status);
}
