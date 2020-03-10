package br.com.alura.microservice.fornecedor.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.alura.microservice.fornecedor.domain.model.Produto;
import br.com.alura.microservice.fornecedor.domain.repository.ProdutoRepository;

@RestController
@RequestMapping("/produtos")
public class ProdutoController {

	private ProdutoRepository produtoRepository;
	
	@Autowired
	public ProdutoController(ProdutoRepository produtoRepository) {
		this.produtoRepository = produtoRepository;
	}

	@GetMapping("/{uf}")
	public List<Produto> getProdutosPorEstado(@PathVariable("uf") String uf) {
		return produtoRepository.findByUf(uf);
	}
}
