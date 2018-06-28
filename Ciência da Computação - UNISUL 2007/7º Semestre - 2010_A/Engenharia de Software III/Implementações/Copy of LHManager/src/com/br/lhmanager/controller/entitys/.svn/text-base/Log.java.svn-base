package com.br.lhmanager.controller.entitys;

import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Representa um log que será gerado a partir de um terminal.
 * 
 * @author Fabio Dela Bruna.
 * @since 04/05/2010.
 */
public class Log {

	// Atributos

	/**
	 * Código do log.
	 */
	private int codigo;

	/**
	 * Informação do log.
	 */
	private String descricao;

	/**
	 * Data de geração do log.
	 */
	private Date data;

	/**
	 * Terminal que gerou o log.
	 */
	private Terminal terminal;

	// Construtores

	/**
	 * Construtor sem parâmetros (padrão).
	 */
	public Log() {
		this(0, "", new Date(), new Terminal());
	}

	/**
	 * Construtor com parâmetros.
	 * 
	 * @param codigo
	 *            Código do log.
	 * @param descricao
	 *            Informações do log.
	 * @param data
	 *            Data de geração do log.
	 * @param terminal
	 *            Terminal que gerou o log.
	 */
	public Log(int codigo, String descricao, Date data, Terminal terminal) {
		this.codigo = codigo;
		this.descricao = descricao;
		this.data = data;
		this.terminal = terminal;
	}

	// toString
	@Override
	public String toString() {
		Format f = new SimpleDateFormat("dd/MM/yyyy");
		return String.format(
				"Código: %d\nDescrição: %s\nData: %s\nTerminal: %s (%s)\n",
				getCodigo(), getDescricao(), f.format(getData()), getTerminal()
						.getDescricao(), getTerminal().getIp());
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

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public Terminal getTerminal() {
		return terminal;
	}

	public void setTerminal(Terminal terminal) {
		this.terminal = terminal;
	}

}
