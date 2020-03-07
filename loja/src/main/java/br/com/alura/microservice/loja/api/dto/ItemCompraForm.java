package br.com.alura.microservice.loja.api.dto;

public class ItemCompraForm {

	private Long id;
	private Integer quantidade;
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}
}
