package br.com.alura.microservice.loja.domain.model;

public class Compra {

	private Long pedidoId;
	private Integer tempoDePreparo;
	private String enderecoDestino;
	
	public Compra(Long pedidoId, Integer tempoDePreparo, String enderecoDestino) {
		this.pedidoId = pedidoId;
		this.tempoDePreparo = tempoDePreparo;
		this.enderecoDestino = enderecoDestino;
	}

	public Long getPedidoId() {
		return pedidoId;
	}

	public Integer getTempoDePreparo() {
		return tempoDePreparo;
	}

	public String getEnderecoDestino() {
		return enderecoDestino;
	}
	
}
