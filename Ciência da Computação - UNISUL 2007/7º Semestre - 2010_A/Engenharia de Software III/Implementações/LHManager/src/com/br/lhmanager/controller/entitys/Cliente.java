package com.br.lhmanager.controller.entitys;

import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

/**
 * Classe que representa um Cliente.
 * 
 * @author Fabio Dela Bruna.
 * @since 04/05/2010.
 */
public class Cliente implements ICrudBase {

	// Atributos

	/**
	 * CPF do cliente.
	 */
	private String cpf;

	/**
	 * Nome do cliente.
	 */
	private String nome;

	/**
	 * Data de nascimento do cliente.
	 */
	private Date nascimento;

	/**
	 * Total de créditos que o cliente possui.
	 */
	private double totalCreditos;

	/**
	 * Telefone do cliente.
	 */
	private String telefone;

	/**
	 * Email do cliente.
	 */
	private String email;

	/**
	 * Endereço resumido do cliente.
	 */
	private String endereco;

	/**
	 * Lista de créditos que o cliente possui.
	 */
	private ArrayList<Credito> creditos;

	// Construtores

	/**
	 * Construtor sem parâmetros (padrão).
	 */
	public Cliente() {
		this("", "", new Date(), 0.0, "", "", "",
				new ArrayList<Credito>());
	}

	/**
	 * Construtor com parãmetros.
	 * 
	 * @param cpf
	 *            Cpf do cliente.
	 * @param nome
	 *            Nome do cliente.
	 * @param nascimento
	 *            Data de Nascimento do cliente.
	 * @param totalCreditos
	 *            Total de créditos que o cliente possui.
	 * @param telefone
	 *            Telefone do cliente.
	 * @param email
	 *            Email do cliente.
	 * @param endereco
	 *            Endereço resumido do cliente.
	 * @param creditos
	 *            Lista de créditos que o cliente possui.
	 */
	public Cliente(String cpf, String nome, Date nascimento,
			double totalCreditos, String telefone, String email,
			String endereco, ArrayList<Credito> creditos) {
		this.cpf = cpf;
		this.nome = nome;
		this.nascimento = nascimento;
		this.totalCreditos = totalCreditos;
		this.telefone = telefone;
		this.email = email;
		this.endereco = endereco;
		this.creditos = creditos;
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
	public ArrayList<Cliente> listar(Object obj) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String toString() {
		Format f = new SimpleDateFormat("dd/MM/yyyy");
		return String
				.format(
						"Cpf: %s\nNome: %s\n Data Nascimento: %s\nTelefone: %s\nEmail: %s\nEndereço: %s\nCréditos: %.2f\n",
						getCpf(), getNome(), f.format(getNascimento()),
						getTelefone(), getEmail(), getEndereco(),
						getTotalCreditos());
	}

	// Getters e Setters

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Date getNascimento() {
		return nascimento;
	}

	public void setNascimento(Date nascimento) {
		this.nascimento = nascimento;
	}

	public double getTotalCreditos() {
		return totalCreditos;
	}

	public void setTotalCreditos(double totalCreditos) {
		this.totalCreditos = totalCreditos;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public ArrayList<Credito> getCreditos() {
		return creditos;
	}

	public void setCreditos(ArrayList<Credito> creditos) {
		this.creditos = creditos;
	}

}
