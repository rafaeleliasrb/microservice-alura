package br.com.alura.microservice.fornecedor.api.domain;

import br.com.alura.microservice.fornecedor.domain.model.InfoFornecedor;

public class InfoFornecedorDTO {

	private Long id;
	private String nome;
	private String uf;
	private String endereco;

	public InfoFornecedorDTO(InfoFornecedor infoForncedor) {
		this.id = infoForncedor.getId();
		this.nome = infoForncedor.getNome();
		this.uf = infoForncedor.getUf();
		this.endereco = infoForncedor.getEndereco();
	}

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
