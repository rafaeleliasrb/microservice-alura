package br.com.alura.microservice.fornecedor.api.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.alura.microservice.fornecedor.api.domain.ItemDoPedidoForm;
import br.com.alura.microservice.fornecedor.domain.model.Pedido;
import br.com.alura.microservice.fornecedor.domain.model.PedidoItem;
import br.com.alura.microservice.fornecedor.domain.repository.PedidoRepository;
import br.com.alura.microservice.fornecedor.domain.repository.ProdutoRepository;

@RestController
@RequestMapping("pedidos")
public class PedidoController {

	private static final Logger LOG = LoggerFactory.getLogger(PedidoController.class);
	
	private PedidoRepository pedidoRepository;
	private ProdutoRepository produtoRepository;
	
	@Autowired
	public PedidoController(PedidoRepository pedidoRepository, ProdutoRepository produtoRepository) {
		this.pedidoRepository = pedidoRepository;
		this.produtoRepository = produtoRepository;
	}

	@PostMapping
	public Pedido realizarPedido(@RequestBody List<ItemDoPedidoForm> produtos) {
		LOG.info("Realizando o pedido com os produtos:");
		produtos.stream().forEach(produto -> LOG.info(produto.toString()));
		
		List<PedidoItem> pedidoItens = ItemDoPedidoForm.toPedidoItem(produtos, produtoRepository);
		Pedido pedido = new Pedido(pedidoItens);
		pedido.setTempoDePreparo(pedidoItens.size());
		
		return pedidoRepository.save(pedido);
	}
	
	@GetMapping("/{id}")
	public Pedido getPedidoPorId(@PathVariable Long id) {
		return pedidoRepository.findById(id).orElse(new Pedido());
	}
	
}
