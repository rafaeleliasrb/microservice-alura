package br.com.alura.microservice.loja.api.dto;

public class InfoFornecedorDTO {

	private Long id;
	private String nome;
	private String uf;
	private String endereco;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getUf() {
		return uf;
	}
	public void setUf(String uf) {
		this.uf = uf;
	}
	public String getEndereco() {
		return endereco;
	}
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	@Override
	public String toString() {
		return "InfoFornecedorDTO [id=" + id + ", nome=" + nome + ", uf=" + uf + ", endereco=" + endereco + "]";
	}
}
