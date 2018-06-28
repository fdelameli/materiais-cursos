package br.unisul.aula.exemplorevenda.entidade;

import java.util.Date;

/**
 * Entidade Venda.
 * @author Fabio Dela Bruna
 * @since 22/04/2008
 */
public class Venda {
	
	// atributos
	
	private long codigo;
	private String cliente;
	private Date dataVenda;
	private String observacoes;
	private float valorVenda;
	
	
	// construtores
	
	/**
	 * Construtor padrão.
	 */
	public Venda() {
		super();
	}

	/**
	 * Construtor com parâmetros (com dados da venda).
	 * @param codigo - Código da venda.
	 * @param cliente - Cliente comprador.
	 * @param dataVenda - Data da venda.
	 * @param observacoes - Observaçoes sobre a venda.
	 * @param valorVenda - Valor da Venda.
	 */
	public Venda(long codigo, String cliente, Date dataVenda, String observacoes, float valorVenda) {
		super();
		this.codigo = codigo;
		this.cliente = cliente;
		this.dataVenda = dataVenda;
		this.observacoes = observacoes;
		this.valorVenda = valorVenda;
	}


	// getters e setters

	public long getCodigo() {
		return codigo;
	}

	public void setCodigo(long codigo) {
		this.codigo = codigo;
	}

	public String getCliente() {
		return cliente;
	}

	public void setCliente(String cliente) {
		this.cliente = cliente;
	}

	public Date getDataVenda() {
		return dataVenda;
	}

	public void setDataVenda(Date dataVenda) {
		this.dataVenda = dataVenda;
	}

	public String getObservacoes() {
		return observacoes;
	}

	public void setObservacoes(String observacoes) {
		this.observacoes = observacoes;
	}

	public float getValorVenda() {
		return valorVenda;
	}

	public void setValorVenda(float valorVenda) {
		this.valorVenda = valorVenda;
	}
	
	
	// toString
	
	public String toString(){
		return String.format("Código: %s\nNome cliente: %s\nData venda: %s\nValor da venda: %s\nObservações: %s", this.codigo, this.cliente, this.dataVenda, this.valorVenda, this.observacoes);
	}
}
