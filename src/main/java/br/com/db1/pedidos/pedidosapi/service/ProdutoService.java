package br.com.db1.pedidos.pedidosapi.service;

import java.util.List;
import java.util.stream.Collectors;

import javax.validation.ConstraintViolationException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.db1.pedidos.pedidosapi.domain.dto.ProdutoDTO;
import br.com.db1.pedidos.pedidosapi.domain.entity.Produto;
import br.com.db1.pedidos.pedidosapi.domain.entity.ProdutoStatus;
import br.com.db1.pedidos.pedidosapi.repositorio.ProdutoRepository;

@Service
public class ProdutoService {

	@Autowired
	private ProdutoRepository produtoRepository;

	public List<ProdutoDTO> getAllActive() {
		return this.getByStatus(ProdutoStatus.ATIVO);
	}

	public List<ProdutoDTO> getByStatus(ProdutoStatus status) {
		return produtoRepository.findByStatus(status).stream().map(produto -> this.produtoToDto(produto))
				.collect(Collectors.toList());
	}

	public ProdutoDTO salvar(ProdutoDTO dto) {
		Produto produto = new Produto(dto.getCodigo(), dto.getNome(), dto.getValor());
		Produto produtoSalvo = produtoRepository.save(produto);
		return this.produtoToDto(produtoSalvo);
	}

	private ProdutoDTO produtoToDto(Produto produto) {
		return new ProdutoDTO(produto.getCodigo(), produto.getNome(), produto.getValor());
	}

	public ProdutoDTO alterar(Long id, ProdutoDTO body) {
		try {
			Produto produtoDatabase = produtoRepository.getOne(id);
			produtoDatabase.setCodigo(body.getCodigo());
			produtoDatabase.setNome(body.getNome());
			produtoDatabase.setValor(body.getValor());
			produtoRepository.save(produtoDatabase);
			return this.produtoToDto(produtoDatabase);
		} catch (ConstraintViolationException e) {
			throw new RuntimeException("Código do produto esta duplicado");
		}
	}

}