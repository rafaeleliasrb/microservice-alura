package br.com.alura.microservice.loja.domain.client;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import br.com.alura.microservice.loja.api.dto.InfoFornecedorDTO;
import br.com.alura.microservice.loja.api.dto.InfoPedidoDTO;
import br.com.alura.microservice.loja.api.dto.ItemCompraForm;

@FeignClient("fornecedor")
public interface FornecedorClient {

	@GetMapping(path = "/infos/{uf}")
	public InfoFornecedorDTO recuperarInfoFornecedor(@PathVariable String uf);
	
	@PostMapping(path = "/pedidos")
	public InfoPedidoDTO realizaPedido(@RequestBody List<ItemCompraForm> produtos);
}
