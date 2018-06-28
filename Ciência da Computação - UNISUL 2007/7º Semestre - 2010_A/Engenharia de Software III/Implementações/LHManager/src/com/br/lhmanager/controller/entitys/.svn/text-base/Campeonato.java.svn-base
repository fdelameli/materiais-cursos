package com.br.lhmanager.controller.entitys;

import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

/**
 * Classe que representa um campeonato de games na Lan House.
 * 
 * @author Fabio Dela Bruna.
 * @since 04/05/2010.
 */
public class Campeonato implements ICrudBase {

	// Atributos

	/**
	 * Código do campeonato.
	 */
	private int codigo;

	/**
	 * Descrição do campeonato.
	 */
	private String descricao;

	/**
	 * Data do campeonato.
	 */
	private Date data;

	/**
	 * Lista de clientes que participam do campeonato.
	 */
	private ArrayList<Cliente> clientes;

	// Construtores

	/**
	 * Construtor sem parâmetros (padrão).
	 */
	public Campeonato() {
		this(0, "", new Date(), new ArrayList<Cliente>());
	}

	/**
	 * Construtor com parâmetros.
	 * 
	 * @param codigo
	 *            Código do campeonato.
	 * @param descricao
	 *            Descrição do campeonato.
	 * @param data
	 *            Data do campeonato.
	 * @param clientes
	 *            Lista de clientes que participam do campeonato.
	 */
	public Campeonato(int codigo, String descricao, Date data,
			ArrayList<Cliente> clientes) {
		this.codigo = codigo;
		this.descricao = descricao;
		this.data = data;
		this.clientes = clientes;
	}

	// Métodos de controle da classe

	/*
	 * REVISAR ESTES MÉTODOS
	 * 
	 * public void iniciar() {
	 * 
	 * }
	 * 
	 * public void finalizar() {
	 * 
	 * }
	 */

	/**
	 * Adiciona um cliente ao campeonato.
	 * 
	 * @param cliente
	 *            Cliente a ser inserido.
	 * @return true se o cliente foi adicionado, false se ocorreu algum erro ao
	 *         inserir.
	 */
	public boolean adicionarCliente(Cliente cliente) {
		return false;
	}

	/**
	 * Retira um determinado cliente do campeonato.
	 * 
	 * @param cliente
	 *            Cliente a ser retirado.
	 * @return true se o cliente foi excluído, false se ocorreu algum erro ao
	 *         excluir.
	 */
	public boolean deletarCliente(Cliente cliente) {
		return false;
	}

	/**
	 * Método que busca todos os clientes que participam do campeonato.
	 * 
	 * @return Lista que clientes participantes.
	 */
	public ArrayList<Cliente> listarClientes() {
		return null;
	}

	// Métodos de persistência.

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
	public ArrayList<Campeonato> listar(Object obj) {
		// TODO Auto-generated method stub
		return null;
	}

	// toString
	@Override
	public String toString() {
		Format f = new SimpleDateFormat("dd/MM/yyyy");
		return String.format("Código: %d\nDescrição: %s\nData: %s\n",
				getCodigo(), getDescricao(), f.format(getData()));
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

	public ArrayList<Cliente> getClientes() {
		return clientes;
	}

	public void setClientes(ArrayList<Cliente> clientes) {
		this.clientes = clientes;
	}

}
