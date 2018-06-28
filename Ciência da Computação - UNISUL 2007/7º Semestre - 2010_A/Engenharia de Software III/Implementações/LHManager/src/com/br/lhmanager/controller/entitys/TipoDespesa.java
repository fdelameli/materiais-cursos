package com.br.lhmanager.controller.entitys;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Representa um tipo de despesa.
 * 
 * @author Fabio Dela Bruna.
 * @since 04/05/2010.
 */
@Entity
@Table( name = "tipo_despesa" )
public class TipoDespesa implements Serializable {

	private static final long serialVersionUID = 1L;

	// Atributos

	/**
	 * Código do tipo de despesa.
	 */
	@Id
	@GeneratedValue( strategy = GenerationType.IDENTITY )
	@Column( name = "cd_tp_des" )
	private Integer codigo;

	/**
	 * Descrição do tipo de despesa.
	 */
	@Column( name = "ds_tp_des" )
	private String descricao;

	// Construtores

	/**
	 * Construtor sem parâmetros (padrão).
	 */
	public TipoDespesa() {
		this( 0, "" );
	}

	/**
	 * Construtor com parâmetros.
	 * 
	 * @param codigo
	 * Código do tipo de despesa.
	 * @param descricao
	 * Descrição do tipo de despesa.
	 */
	public TipoDespesa( Integer codigo, String descricao ) {
		this.codigo = codigo;
		this.descricao = descricao;
	}


	// toString
	@Override
	public String toString() {
		return String.format( "Código: %d\nDescrição: %s\n", getCodigo(),
				getDescricao() );
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

}
