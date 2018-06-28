package br.unisul.aula.dto;

public class Endereco {

	private int numero;
	private String rua;
	private String cep;
	private String cidade;
	private String uf;

	public Endereco() {
		super();

	}

	public Endereco(int numero, String rua, String cep, String cidade, String uf) {
		super();
		this.numero = numero;
		this.rua = rua;
		this.cep = cep;
		this.cidade = cidade;
		this.uf = uf;
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public String getRua() {
		return rua;
	}

	public void setRua(String rua) {
		this.rua = rua;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getUf() {
		return uf;
	}

	public void setUf(String uf) {
		this.uf = uf;
	}

}
