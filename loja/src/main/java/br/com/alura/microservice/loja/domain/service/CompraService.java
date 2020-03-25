package br.com.alura.microservice.loja.domain.service;

import java.time.LocalDate;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

import br.com.alura.microservice.loja.api.dto.CompraForm;
import br.com.alura.microservice.loja.api.dto.InfoEntregaDTO;
import br.com.alura.microservice.loja.api.dto.InfoFornecedorDTO;
import br.com.alura.microservice.loja.api.dto.InfoPedidoDTO;
import br.com.alura.microservice.loja.api.dto.VoucherDTO;
import br.com.alura.microservice.loja.domain.client.FornecedorClient;
import br.com.alura.microservice.loja.domain.client.TransportadorClient;
import br.com.alura.microservice.loja.domain.model.Compra;
import br.com.alura.microservice.loja.domain.repository.CompraRepository;
import javassist.NotFoundException;

@Service
public class CompraService {

	private static final Logger LOG = LoggerFactory.getLogger(CompraService.class);
	
	private final FornecedorClient fornecedorClient;
	private final CompraRepository compraRepository;
	private final TransportadorClient transportadorClient;
	
	@Autowired
	public CompraService(FornecedorClient fornecedorClient, CompraRepository compraRepository,
			TransportadorClient transportadorClient) {
		this.fornecedorClient = fornecedorClient;
		this.compraRepository = compraRepository;
		this.transportadorClient = transportadorClient;
	}

	@HystrixCommand(threadPoolKey = "buscarCompraThreadPool")
	public Compra buscarCompra(Long idCompra) throws NotFoundException {
		return compraRepository.findByPedidoId(idCompra)
				.orElseThrow(() -> new NotFoundException("Compra não encontrada"));
	}
	
	@HystrixCommand(fallbackMethod = "realizarCompraFallback", threadPoolKey = "realizarCompraThreadPool")
	public Compra realizarCompra(CompraForm compra) {
		
		Compra compraSalva = new Compra(compra.getEndereco().toString());
		compraSalva = compraRepository.save(compraSalva);
		
		compra.setPedidoId(compraSalva.getId());
		
		LOG.info("Buscar o infoFornecedor");
		InfoFornecedorDTO infoFornecedor = fornecedorClient.recuperarInfoFornecedor(compra.getEndereco().getUf());
		LOG.info("Realizar o pedido");
		InfoPedidoDTO pedido = fornecedorClient.realizarPedido(compra.getItens());
		compraSalva.adicionarPedido(pedido.getId(), pedido.getTempoDePreparo());
		compraSalva = compraRepository.save(compraSalva);
		
		InfoEntregaDTO entregaDTO = new InfoEntregaDTO(pedido.getId(), LocalDate.now().plusDays(pedido.getTempoDePreparo()), 
				infoFornecedor.getEndereco(), compra.getEndereco().toString());
		LOG.info("Reservar entrega");
		VoucherDTO voucherDTO = transportadorClient.reservaEntrega(entregaDTO);
		compraSalva.reservarEntrega(entregaDTO.getDataParaEntrega(), voucherDTO.getNumero());
		compraSalva = compraRepository.save(compraSalva);
		
		return compraSalva;
	}
	
	public Compra realizarCompraFallback(CompraForm compra) {
		if(compra.getPedidoId() != null) {
			return compraRepository.findById(compra.getPedidoId()).get();
		}
		return new Compra(compra.getEndereco().toString());
	}
}
