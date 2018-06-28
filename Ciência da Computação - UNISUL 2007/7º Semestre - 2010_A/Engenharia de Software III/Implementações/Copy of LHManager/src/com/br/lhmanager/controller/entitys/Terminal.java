package com.br.lhmanager.controller.entitys;

import java.util.ArrayList;

/**
 * Classe que representa um terminal (computador) da Lan House.
 * 
 * @author Fabio Dela Bruna.
 * @since 04/05/2010.
 */
public class Terminal implements ICrudBase {

	// Atributos

	/**
	 * MAC Address da placa de rede do terminal.
	 */
	private String macAddress;

	/**
	 * IP do terminal.
	 */
	private String ip;

	/**
	 * Descrição do terminal.
	 */
	private String descricao;

	// Construtores

	/**
	 * Construtor sem parâmetros (padrão).
	 */
	public Terminal() {
		this("", "", "");
	}

	/**
	 * Construtor com parâmetros.
	 * 
	 * @param macAddress
	 *            MAC Address da placa de rede.
	 * @param ip
	 *            IP do terminal.
	 * @param descricao
	 *            Descrição do terminal.
	 */
	public Terminal(String macAddress, String ip, String descricao) {
		this.macAddress = macAddress;
		this.ip = ip;
		this.descricao = descricao;
	}

	// Métodos de controle da classe

	/**
	 * Altera o ip de determinado terminal.
	 * 
	 * @param ip
	 *            Novo IP do teminal.
	 * @return true se o IP foi alterado com sucesso, false se ouve algum erro
	 *         ao alterar.
	 */
	public boolean alterarIP(String ip) {
		return false;
	}

	/**
	 * Altera o MAC Address de um terminal (para o caso de a placa de rede ter
	 * sido trocada).
	 * 
	 * @param mac
	 *            Novo MAC Address do terminal.
	 * @return true se o MAC foi alterado com sucesso, false se ouve algum erro
	 *         ao alterar.
	 */
	public boolean alterarMAC(String mac) {
		return false;
	}

	/**
	 * Gera um log contendo informações do que foi acesso no terminal.
	 * 
	 * @return Log gerado pelo terminal.
	 */
	public Log gerarLog() {
		return null;
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
	public ArrayList<Terminal> listar(Object obj) {
		// TODO Auto-generated method stub
		return null;
	}

	// toString
	@Override
	public String toString() {
		return String.format("IP: %s\nMAC Address: %s\nDescrição: %s\n",
				getIp(), getMacAddress(), getDescricao());
	}

	// Getters e Setters

	public String getMacAddress() {
		return macAddress;
	}

	public void setMacAddress(String macAddress) {
		this.macAddress = macAddress;
	}

	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

}
