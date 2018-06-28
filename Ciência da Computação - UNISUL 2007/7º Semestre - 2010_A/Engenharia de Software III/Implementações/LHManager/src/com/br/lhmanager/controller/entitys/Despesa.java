package com.br.lhmanager.controller.entitys;

import java.io.Serializable;
import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * Classe que representa uma despesa que será "lançada" no sistema.
 * 
 * @author Fabio Dela Bruna.
 * @since 04/05/2010.
 */
@Entity
@Table( name = "despesa" )
public class Despesa implements Serializable {

	private static final long serialVersionUID = 1L;

	// Atributos

	/**
	 * Código da despesa.
	 */
	@Id
	@GeneratedValue( strategy = GenerationType.IDENTITY )
	@Column( name = "cd_des" )
	private Integer codigo;

	/**
	 * Descrição da despesa.
	 */
	@Column( name = "ds_des" )
	private String descricao;

	/**
	 * Valor total da despesa.
	 */
	@Column( name = "vl_des" )
	private Double valor;

	/**
	 * Data de pagamento da despesa.
	 */
	@Column( name = "dt_pagto" )
	private Date dataPagamento;

	/**
	 * Tipo da despesa.
	 */
	@JoinColumn( name = "tp_des", referencedColumnName = "cd_tp_des" )
	@ManyToOne
	private TipoDespesa tipoDespesa;

	// Construtores

	/**
	 * Construtor sem parâmetros (padrão).
	 */
	public Despesa() {
		this( null, "", null, new Date(), new TipoDespesa() );
	}

	/**
	 * Construtor com parâmetros.
	 * 
	 * @param codigo
	 * Código da despesa.
	 * @param descricao
	 * Descrição da despesa.
	 * @param valor
	 * Valor da despesa.
	 * @param dataPagameto
	 * Data de pagamento da despesa.
	 * @param tipoDespesa
	 * Tipo da despesa.
	 */
	public Despesa( Integer codigo, String descricao, Double valor,
			Date dataPagamento, TipoDespesa tipoDespesa ) {
		this.codigo = codigo;
		this.descricao = descricao;
		this.valor = valor;
		this.dataPagamento = dataPagamento;
		this.tipoDespesa = tipoDespesa;
	}

	// toString
	@Override
	public String toString() {
		Format f = new SimpleDateFormat( "dd/MM/yyyy" );
		return String
				.format(
						"Código: %d\nDescrição: %s\nTipo: %s\nData Pagamento: %s\nValor: %.2f",
						getCodigo(), getDescricao(), getTipoDespesa().getDescricao(), f.format( getDataPagamento() ), getValor() );
	}

	// Getters e Setters

	public Integer getCodigo() {
		return codigo;
	}

	public void setCodigo( Integer codigo ) {
		this.codigo = codigo;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao( String descricao ) {
		this.descricao = descricao;
	}

	public Double getValor() {
		return valor;
	}

	public void setValor( Double valor ) {
		this.valor = valor;
	}

	public Date getDataPagamento() {
		return dataPagamento;
	}

	public String getDataPagamentoString() {
		SimpleDateFormat sdf = new SimpleDateFormat( "dd/MM/yyyy" );
		String data = sdf.format( dataPagamento );
		return data;
	}

	public void setDataPagamento( Date dataPagamento ) {
		this.dataPagamento = dataPagamento;
	}


	public TipoDespesa getTipoDespesa() {
		return tipoDespesa;
	}

	public void setTipoDespesa( TipoDespesa tipoDespesa ) {
		this.tipoDespesa = tipoDespesa;
	}

}
