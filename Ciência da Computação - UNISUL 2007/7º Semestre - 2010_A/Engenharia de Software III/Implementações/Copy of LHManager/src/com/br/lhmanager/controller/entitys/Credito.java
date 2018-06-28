package com.br.lhmanager.controller.entitys;

/**
 * Classe que representa uma entidade Crédito.
 * 
 * @author Fabio Dela Bruna.
 * @since 04/05/2010.
 */
public class Credito {

	// Atributos

	/**
	 * Código do crédito.
	 */
	private int codigo;

	/**
	 * Valor do crédito.
	 */
	private double valor;

	/**
	 * Horas de utilização equivalentes àquele crédito.
	 */
	private double horas;

	/**
	 * Uma promoção feita sobre os créditos.
	 */
	private Promocao promocao;

	// Construtores

	/**
	 * Construtor sem parâmetros (padrão).
	 */
	public Credito() {
		this(0, 0.0, 0.0, new Promocao());
	}

	/**
	 * Construtor com parâmetros.
	 * 
	 * @param codigo
	 *            Código do crédito.
	 * @param valor
	 *            Valor do crédito.
	 * @param horas
	 *            Horas de utilização equivalentes àquele crédito.
	 * @param promocao
	 *            Uma promoção feita sobre os créditos.
	 */
	public Credito(int codigo, double valor, double horas,
			Promocao promocao) {
		this.codigo = codigo;
		this.valor = valor;
		this.horas = horas;
		this.promocao = promocao;
	}

	// Métodos de persistência

	public boolean incluirCredito() {
		return false;
	}

	public boolean atualizarCredito() {
		return false;
	}

	// toString
	@Override
	public String toString() {
		return String.format(
				"Código: %d\nValor: %.2f\nHoras: %.2f\nPromoção: %s\n",
				getCodigo(), getValor(), getHoras(), getPromocao()
						.getDescricao());
	}

	// Getters e Setters

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public double getValor() {
		return valor;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}

	public double getHoras() {
		return horas;
	}

	public void setHoras(double horas) {
		this.horas = horas;
	}

	public Promocao getPromocao() {
		return promocao;
	}

	public void setPromocao(Promocao promocao) {
		this.promocao = promocao;
	}

}
