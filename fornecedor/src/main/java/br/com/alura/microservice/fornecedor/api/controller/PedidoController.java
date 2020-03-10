package br.com.alura.microservice.fornecedor.api.controller;

import java.util.List;

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

	private PedidoRepository pedidoRepository;
	private ProdutoRepository produtoRepository;
	
	@Autowired
	public PedidoController(PedidoRepository pedidoRepository, ProdutoRepository produtoRepository) {
		this.pedidoRepository = pedidoRepository;
		this.produtoRepository = produtoRepository;
	}

	@PostMapping
	public Pedido realizaPedido(@RequestBody List<ItemDoPedidoForm> produtos) {
		
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
