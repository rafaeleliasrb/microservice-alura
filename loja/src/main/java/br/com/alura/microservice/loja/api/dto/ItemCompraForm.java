package br.com.alura.microservice.loja.api.dto;

public class ItemCompraForm {

	private Long id;
	private Integer quantidade;
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public Long getId() {
		return id;
	}
	
	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}
	
	public Integer getQuantidade() {
		return quantidade;
	}
}
