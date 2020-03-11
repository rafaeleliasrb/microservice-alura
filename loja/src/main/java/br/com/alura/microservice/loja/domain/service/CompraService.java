package br.com.alura.microservice.loja.domain.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.alura.microservice.loja.api.dto.CompraForm;
import br.com.alura.microservice.loja.api.dto.InfoFornecedorDTO;
import br.com.alura.microservice.loja.api.dto.InfoPedidoDTO;
import br.com.alura.microservice.loja.domain.client.FornecedorClient;
import br.com.alura.microservice.loja.domain.model.Compra;

@Service
public class CompraService {

	private static final Logger LOG = LoggerFactory.getLogger(CompraService.class);
	
	private final FornecedorClient fornecedorClient;
	
	@Autowired
	public CompraService(FornecedorClient fornecedorClient) {
		this.fornecedorClient = fornecedorClient;
	}

	public Compra realizarCompra(CompraForm compra) {
		
		LOG.info("Buscar o infoFornecedor");
		InfoFornecedorDTO infoFornecedor = fornecedorClient.recuperarInfoFornecedor(compra.getEndereco().getUf());
		
		LOG.info("Realizar o pedido");
		InfoPedidoDTO pedido = fornecedorClient.realizarPedido(compra.getItens());
		
		return new Compra(pedido.getId(), pedido.getTempoDePreparo(), infoFornecedor.getEndereco().toString());
	}
	
}
