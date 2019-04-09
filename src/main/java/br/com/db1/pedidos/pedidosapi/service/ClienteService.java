package br.com.db1.pedidos.pedidosapi.service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.db1.pedidos.pedidosapi.domain.dto.ClienteDTO;
import br.com.db1.pedidos.pedidosapi.domain.entity.Cliente;
import br.com.db1.pedidos.pedidosapi.domain.entity.ClienteStatus;
import br.com.db1.pedidos.pedidosapi.repositorio.ClienteRepository;

@Service
public class ClienteService {

	
		@Autowired
		private ClienteRepository clienteRepository;

		List<ClienteDTO> cliente = new ArrayList<>();
		
		public List<ClienteDTO> getAll() {
			Iterable<Cliente> clienteDataBase = clienteRepository.findByStatus(ClienteStatus.ATIVO);
			Iterator<Cliente> iterator = clienteDataBase.iterator();
			
			while (iterator.hasNext()) {
				Cliente next = iterator.next();
				ClienteDTO clienteDTO = new ClienteDTO(next.getNome(), next.getCpf());
				cliente.add(clienteDTO);
			}
			return cliente;
		}
}
