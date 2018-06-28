package com.br.lhmanager.controller.entitys;

import java.util.ArrayList;

/**
 * Classe que representa um impressão realizada na Lan House.
 * 
 * @author Fabio Dela Bruna.
 * @since 04/05/2010.
 */
public class Impressao implements ICrudBase {

	// Atributos

	/**
	 * Código da impressão.
	 */
	private int codigo;

	/**
	 * Descrição da impressão.
	 */
	private String descricao;

	/**
	 * Quantidade de páginas impressas.
	 */
	private int qtdPaginas;

	/**
	 * Valor unitário das páginas.
	 */
	private double valorUnit;

	/**
	 * Valor total da impressão;
	 */
	private double valorTotal;

	// Construtores

	/**
	 * Construtor sem parâmetros (padrão).
	 */
	public Impressao() {
		this(0, "", 0, 0.0, 0.0);
	}

	/**
	 * Construtor com parâmetros.
	 * 
	 * @param codigo
	 *            Código da impressão.
	 * @param descricao
	 *            Descrição da impressão.
	 * @param qtdPaginas
	 *            Quantidade de páginas impressas.
	 * @param valorUnit
	 *            Valor unitário de cada página.
	 * @param valorTotal
	 *            Valor total da impressão.
	 */
	public Impressao(int codigo, String descricao, int qtdPaginas,
			double valorUnit, double valorTotal) {
		this.codigo = codigo;
		this.descricao = descricao;
		this.qtdPaginas = qtdPaginas;
		this.valorUnit = valorUnit;
		this.valorTotal = valorTotal;
	}

	// Métodos de persistência

	@Override
	public boolean atualizar(Object obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean deletar(Object obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean inserir(Object obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public ArrayList<Impressao> listar(Object obj) {
		// TODO Auto-generated method stub
		return null;
	}

	// toString
	@Override
	public String toString() {
		return String
				.format(
						"Código: %d\nDescrição: %s\nQtd. Páginas: %d\nValor Unit.: %.2f\nValor Total: %.2f\n",
						getCodigo(), getDescricao(), getQtdPaginas(),
						getValorUnit(), getValorTotal());
	}

	// Getters e Setters

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public int getQtdPaginas() {
		return qtdPaginas;
	}

	public void setQtdPaginas(int qtdPaginas) {
		this.qtdPaginas = qtdPaginas;
	}

	public double getValorUnit() {
		return valorUnit;
	}

	public void setValorUnit(double valorUnit) {
		this.valorUnit = valorUnit;
	}

	public double getValorTotal() {
		this.valorTotal = getQtdPaginas() * getValorUnit();
		return this.valorTotal;
	}

	public void setValorTotal(double valorTotal) {
		this.valorTotal = valorTotal;
	}

}
