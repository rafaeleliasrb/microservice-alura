package br.com.alura.microservice.loja.api.dto;

public class EnderecoForm {

	private String logradouro;
	private String numero;
	private String uf;
	
	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}
	
	public String getLogradouro() {
		return logradouro;
	}
	
	public void setNumero(String numero) {
		this.numero = numero;
	}

	public String getNumero() {
		return numero;
	}
	
	public void setUf(String uf) {
		this.uf = uf;
	}
	
	public String getUf() {
		return uf;
	}

	@Override
	public String toString() {
		return "EnderecoForm [logradouro=" + logradouro + ", numero=" + numero + ", uf=" + uf + "]";
	}
}
