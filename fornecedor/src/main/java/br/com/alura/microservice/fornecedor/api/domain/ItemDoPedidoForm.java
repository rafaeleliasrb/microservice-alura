package br.com.alura.microservice.fornecedor.api.domain;

import java.util.List;
import java.util.stream.Collectors;

import br.com.alura.microservice.fornecedor.domain.model.PedidoItem;
import br.com.alura.microservice.fornecedor.domain.model.Produto;
import br.com.alura.microservice.fornecedor.domain.repository.ProdutoRepository;

public class ItemDoPedidoForm {

	private Long id;
	private Integer quantidade;

	public static List<PedidoItem> toPedidoItem(List<ItemDoPedidoForm> itens, ProdutoRepository produtoRepository) {
		
		List<Long> idsProdutos = itens
				.stream()
				.map(ItemDoPedidoForm::getId)
				.collect(Collectors.toList());
		
		List<Produto> produtosDoPedido = produtoRepository.findByIdIn(idsProdutos);
		
		return itens
			.stream()
			.map(item -> {
				Produto produto = produtosDoPedido
						.stream()
						.filter(p -> p.getId() == item.getId())
						.findFirst().get();
				
				PedidoItem pedidoItem = new PedidoItem();
				pedidoItem.setProduto(produto);
				pedidoItem.setQuantidade(item.getQuantidade());
				return pedidoItem;
			})
			.collect(Collectors.toList());
	}
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public int getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}
}
