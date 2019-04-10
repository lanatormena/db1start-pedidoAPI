package br.com.db1.pedidos.pedidosapi.repositorio;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.db1.pedidos.pedidosapi.domain.entity.Produto;
import br.com.db1.pedidos.pedidosapi.domain.entity.ProdutoStatus;

public interface ProdutoRepository extends JpaRepository<Produto, Long> {

	Produto findByCodigo(String codigo);

	List<Produto> findByStatus(ProdutoStatus status);
}
