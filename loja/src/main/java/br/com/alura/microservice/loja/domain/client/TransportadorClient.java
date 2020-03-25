package br.com.alura.microservice.loja.domain.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import br.com.alura.microservice.loja.api.dto.InfoEntregaDTO;
import br.com.alura.microservice.loja.api.dto.VoucherDTO;

@FeignClient("transportador")
public interface TransportadorClient {

	@PostMapping(path = "/entregas")
	public VoucherDTO reservaEntrega(@RequestBody InfoEntregaDTO pedidoDTO);
}
