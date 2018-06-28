package com.br.lhmanager.controller.entitys;

import java.util.ArrayList;

/**
 * Representa um tipo de despesa.
 * 
 * @author Fabio Dela Bruna.
 * @since 04/05/2010.
 */
public class TipoDespesa implements ICrudBase {

	// Atributos

	/**
	 * Código do tipo de despesa.
	 */
	private int codigo;

	/**
	 * Descrição do tipo de despesa.
	 */
	private String descricao;

	// Construtores

	/**
	 * Construtor sem parâmetros (padrão).
	 */
	public TipoDespesa() {
		this(0, "");
	}

	/**
	 * Construtor com parâmetros.
	 * 
	 * @param codigo
	 *            Código do tipo de despesa.
	 * @param descricao
	 *            Descrição do tipo de despesa.
	 */
	public TipoDespesa(int codigo, String descricao) {
		this.codigo = codigo;
		this.descricao = descricao;
	}

	// métodos de persistência

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
	public ArrayList<TipoDespesa> listar(Object obj) {
		// TODO Auto-generated method stub
		return null;
	}

	// toString
	@Override
	public String toString() {
		return String.format("Código: %d\nDescrição: %s\n", getCodigo(),
				getDescricao());
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

}
