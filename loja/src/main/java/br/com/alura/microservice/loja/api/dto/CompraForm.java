package br.com.alura.microservice.loja.api.dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class CompraForm {

	@JsonIgnore
	private Long pedidoId;
	
	private List<ItemCompraForm> itens;
	private EnderecoForm endereco;
	
	public void setItens(List<ItemCompraForm> itens) {
		this.itens = itens;
	}
	
	public void setEndereco(EnderecoForm endereco) {
		this.endereco = endereco;
	}
	
	public EnderecoForm getEndereco() {
		return endereco;
	}
	
	public List<ItemCompraForm> getItens() {
		return itens;
	}

	public Long getPedidoId() {
		return pedidoId;
	}

	public void setPedidoId(Long pedidoId) {
		this.pedidoId = pedidoId;
	}
}
