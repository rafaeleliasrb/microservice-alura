package br.com.alura.microservice.fornecedor.domain.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class InfoForncedor {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String nome;
	private String uf;
	private String endereco;
	
	public Long getId() {
		return id;
	}
	public String getNome() {
		return nome;
	}
	public String getUf() {
		return uf;
	}
	public String getEndereco() {
		return endereco;
	}
	
	
}
