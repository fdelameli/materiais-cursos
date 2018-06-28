package com.br.lhmanager.controller.entitys;

import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

/**
 * Classe que representa uma promo��o.
 * 
 * @author Fabio Dela Bruna.
 * @since 04/05/2010.
 */
public class Promocao implements ICrudBase {

	// Atributos

	/**
	 * C�digo da promo��o.
	 */
	private int codigo;

	/**
	 * Descri��o da promo��o.
	 */
	private String descricao;

	/**
	 * Data de in�cio da promo��o.
	 */
	private Date dataInicio;

	/**
	 * Data de t�rmino da promo��o.
	 */
	private Date dataFim;

	// Construtores

	/**
	 * Construtor sem par�metros (padr�o).
	 */
	public Promocao() {
		this(0, "", new Date(), new Date());
	}

	/**
	 * Construtor com par�metros.
	 * 
	 * @param codigo
	 *            C�digo da promo��o.
	 * @param descricao
	 *            Descri��o da promo��o.
	 * @param dataInicio
	 *            Data de in�cio da promo��o.
	 * @param dataFim
	 *            Data de t�rmino da promo��o.
	 */
	public Promocao(int codigo, String descricao, Date dataInicio,
			Date dataFim) {
		this.codigo = codigo;
		this.descricao = descricao;
		this.dataInicio = dataInicio;
		this.dataFim = dataFim;
	}

	// M�todos de controle da classe

	/**
	 * Incia a promo��o em quest�o.
	 */
	public void iniciar() {

	}

	/**
	 * Finaliza a promo��o em quest�o.
	 */
	public void finalizar() {

	}

	// M�todos de persist�ncia

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
	public ArrayList<Promocao> listar(Object obj) {
		// TODO Auto-generated method stub
		return null;
	}

	// toString
	@Override
	public String toString() {
		Format f = new SimpleDateFormat("dd/MM/yyyy");
		return String.format(
				"C�digo: %d\nDescri��o: %s\nData In�cio: %s\nData Fim: %s\n",
				getCodigo(), getDescricao(), f.format(getDataInicio()), f
						.format(getDataFim()));
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

	public Date getDataInicio() {
		return dataInicio;
	}

	public void setDataInicio(Date dataInicio) {
		this.dataInicio = dataInicio;
	}

	public Date getDataFim() {
		return dataFim;
	}

	public void setDataFim(Date dataFim) {
		this.dataFim = dataFim;
	}

}
