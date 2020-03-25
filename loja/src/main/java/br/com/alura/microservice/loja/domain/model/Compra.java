package br.com.alura.microservice.loja.domain.model;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Compra {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private Long pedidoId;
	private Integer tempoDePreparo;
	private String enderecoDestino;
	private LocalDate dataEntrega;
	private Long voucher;
	
	@Enumerated(EnumType.STRING)
	private CompraStatus status;
	
	public Compra() {}

	public Compra(String enderecoDestino) {
		this.enderecoDestino = enderecoDestino;
		status = CompraStatus.RECEBIDO;
	}
	
	public void adicionarPedido(Long pedidoId, Integer tempoDePreparo) {
		this.pedidoId = pedidoId;
		this.tempoDePreparo = tempoDePreparo;
		status = CompraStatus.PEDIDO_REALIZADO;
	}
	
	public void reservarEntrega(LocalDate dataParaEntrega, Long numero) {
		dataEntrega = dataParaEntrega;
		voucher = numero;
		status = CompraStatus.RESERVA_ENTREGA_REALIZADA;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public LocalDate getDataEntrega() {
		return dataEntrega;
	}

	public Long getVoucher() {
		return voucher;
	}

	public CompraStatus getStatus() {
		return status;
	}
}
