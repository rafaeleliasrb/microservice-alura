package br.com.alura.microservice.fornecedor.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.alura.microservice.fornecedor.api.domain.InfoFornecedorDTO;
import br.com.alura.microservice.fornecedor.domain.repository.InfoFornecedorRepository;

@RestController
@RequestMapping("infos")
public class InfoFornecedorController {

	private InfoFornecedorRepository infoFornecedorRepository;
	
	@Autowired
	public InfoFornecedorController(InfoFornecedorRepository infoFornecedorRepository) {
		this.infoFornecedorRepository = infoFornecedorRepository;
	}

	@GetMapping(path = "/{uf}")
	public InfoFornecedorDTO recuperarInfoFornecedor(@PathVariable String uf) {
		return new InfoFornecedorDTO(infoFornecedorRepository.getByUf(uf));
	}
}
