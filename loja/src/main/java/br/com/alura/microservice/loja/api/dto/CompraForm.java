package br.com.alura.microservice.loja.api.dto;

import java.util.List;

public class CompraForm {

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
}
