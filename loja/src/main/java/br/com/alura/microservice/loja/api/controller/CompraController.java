package br.com.alura.microservice.loja.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.alura.microservice.loja.api.dto.CompraForm;
import br.com.alura.microservice.loja.domain.model.Compra;
import br.com.alura.microservice.loja.domain.service.CompraService;

@RestController
@RequestMapping("/compras")
public class CompraController {

	private CompraService compraService;
	
	@Autowired
	public CompraController(CompraService compraService) {
		this.compraService = compraService;
	}

	@PostMapping
	public Compra realizarCompra(@RequestBody CompraForm compra) {
		return compraService.realizarCompra(compra);
	}
}
