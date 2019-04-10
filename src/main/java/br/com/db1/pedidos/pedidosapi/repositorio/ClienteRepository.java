package br.com.db1.pedidos.pedidosapi.repositorio;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.db1.pedidos.pedidosapi.domain.entity.Cliente;
import br.com.db1.pedidos.pedidosapi.domain.entity.ClienteStatus;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {

	Cliente findByCpf(String cpf);

	List<Cliente> findByStatus(ClienteStatus status);
}