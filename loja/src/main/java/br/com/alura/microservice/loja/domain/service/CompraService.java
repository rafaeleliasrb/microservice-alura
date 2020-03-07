package br.com.alura.microservice.loja.domain.service;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import br.com.alura.microservice.loja.api.dto.CompraForm;
import br.com.alura.microservice.loja.api.dto.InfoFornecedorDTO;

@Service
public class CompraService {

	private RestTemplate restTemplate;
	
	@Autowired
	public CompraService(RestTemplate restTemplate) {
		this.restTemplate = restTemplate;
	}

	public void realizarCompra(CompraForm compra) {
		
		ResponseEntity<InfoFornecedorDTO> infoFornecedor = 
				restTemplate.exchange("http://fornecedor/infos/" + compra.getEndereco().getUf(), 
				HttpMethod.GET, null, InfoFornecedorDTO.class);
		
		System.out.println(infoFornecedor);
	}
	
}
