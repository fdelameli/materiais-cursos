package br.unisul.banco.bean;

public class ProdutoBean {

	private Integer codigo;
	private String nome;
	private Double preco;
	private Integer tipo;
	
	
	
	
	public ProdutoBean() {
		super();
	}
	
	
	public ProdutoBean(Integer codigo, String nome, Double preco, Integer tipo) {
		super();
		this.codigo = codigo;
		this.nome = nome;
		this.preco = preco;
		this.tipo = tipo;
	}
	public Integer getCodigo() {
		return codigo;
	}
	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public Double getPreco() {
		return preco;
	}
	public void setPreco(Double preco) {
		this.preco = preco;
	}
	public Integer getTipo() {
		return tipo;
	}
	public void setTipo(Integer tipo) {
		this.tipo = tipo;
	}

	
	
	
}
