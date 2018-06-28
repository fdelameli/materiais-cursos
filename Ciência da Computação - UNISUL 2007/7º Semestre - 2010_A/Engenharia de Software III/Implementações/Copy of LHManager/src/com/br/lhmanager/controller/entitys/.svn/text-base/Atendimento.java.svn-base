package com.br.lhmanager.controller.entitys;

/**
 * Classe que representa um atendimento na LanHouse.
 * 
 * @author Fabio Dela Bruna.
 * @since 04/05/2010.
 */
public class Atendimento {

	// Atributos

	/**
	 * Representa um usuário.
	 */
	private Usuario usuario;

	/**
	 * Representa um cliente.
	 */
	private Cliente cliente;

	// Construtores

	/**
	 * Construtor sem parâmetros (padrão).
	 */
	public Atendimento() {
		this(new Usuario(), new Cliente());
	}

	/**
	 * Construtor com parâmetros.
	 * 
	 * @param usuario
	 *            Objeto do tipo UsuárioEntity.
	 * @param cliente
	 *            Objeto do tipo ClienteEntity
	 */
	public Atendimento(Usuario usuario, Cliente cliente) {
		this.usuario = usuario;
		this.cliente = cliente;
	}
	
	// Métodos de controle da classe

	/**
	 * Calcula o total a ser pago pelo cliente.
	 */
	public double calcularTotalSerPago() {
		return 0;
	}

	/**
	 * Efetua a compra de créditos ao cliente.
	 */
	public void comprarCredito() {

	}

	// Getters e Setters

	@Override
	public String toString() {
		return String.format("Usuário: %s\nCliente: %s\n", getUsuario()
				.getNome(), getCliente().getNome());
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

}
