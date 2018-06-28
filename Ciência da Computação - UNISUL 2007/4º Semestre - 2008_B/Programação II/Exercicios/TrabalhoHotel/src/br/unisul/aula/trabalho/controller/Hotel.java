package br.unisul.aula.trabalho.controller;

import java.util.ArrayList;

import br.unisul.aula.trabalho.dto.*;
import br.unisul.aula.trabalho.model.*;

/**
 * Classe de negócio responsável por manipular os dados do Hotel.
 * @author Fabio Dela Bruna / Marcio Teixeira Ozório.
 * @since 13/05/2008.
 */
public class Hotel implements IClienteModel, IQuartoModel, IEstadiaModel {
	
	//atributos
	
	private String nome;
	private Endereco endereco;
	private String fone;
	private String site;
	
	private ArrayList<Cliente> clientes;
	private ArrayList<Quarto> quartos;
	private ArrayList<Estadia> estadias;
	
	private IClienteModel clienteModel;
	private IQuartoModel quartoModel;
	private IEstadiaModel estadiaModel;
	
	
	//construtor
	
	/**
	 * Construtor default.
	 */
	public Hotel(){
		super();
		
		this.clientes = new ArrayList<Cliente>();
		this.quartos = new ArrayList<Quarto>();
		this.estadias = new ArrayList<Estadia>();
		
		this.clienteModel = new ClienteModel(clientes);
		this.quartoModel = new QuartoModel(quartos);
		this.estadiaModel = new EstadiaModel(estadias);
	}
	
	/**
	 * Construtor com parâmetros.
	 * @param nome - Nome do Hotel.
	 * @param endereco - Endereço.
	 * @param site - Site.
	 * @param fone - Telefone.
	 */
	public Hotel(String nome, Endereco endereco, String site, String fone){
		super();
		this.nome = nome;
		this.endereco = endereco;
		this.site = site;
		this.fone = fone;
		
		this.clientes = new ArrayList<Cliente>();
		this.quartos = new ArrayList<Quarto>();
		this.estadias = new ArrayList<Estadia>();
		
		this.clienteModel = new ClienteModel(clientes);
		this.quartoModel = new QuartoModel(quartos);
		this.estadiaModel = new EstadiaModel(estadias);
	}


	//métodos referentes à clientes

	@Override
	public void atualizaDadosCliente(Cliente antigo, Cliente novo) {
		this.clienteModel.atualizaDadosCliente(antigo, novo);
	}

	@Override
	public Cliente buscaCliente(String nome, String sobrenome) {
		return this.clienteModel.buscaCliente(nome, sobrenome);
	}

	@Override
	public void cadastraCliente(Cliente c) {
		this.clienteModel.cadastraCliente(c);
	}

	@Override
	public ArrayList<Cliente> mostraClientes() {
		return this.clienteModel.mostraClientes();
	}
	
	@Override
	public void removeCliente(Cliente c) {
		this.clienteModel.removeCliente(c);
	}

	
	//	métodos referentes à Quartos
	
	@Override
	public void cadastraQuarto(Quarto q) {
		this.quartoModel.cadastraQuarto(q);		
	}

	@Override
	public ArrayList<Quarto> mostraQuartos() {
		return this.quartoModel.mostraQuartos();
	}

	@Override
	public void removeQuarto(Quarto q) {
		this.quartoModel.removeQuarto(q);
	}


	//métodos referentes à Estadias
	
	@Override
	public ArrayList<Estadia> buscaEstadia(Cliente c) {
		return this.estadiaModel.buscaEstadia(c);
	}

	@Override
	public void cadastraEstadia(Estadia e) {
		this.estadiaModel.cadastraEstadia(e);
	}

	@Override
	public ArrayList<Estadia> mostraEstadias() {
		return this.estadiaModel.mostraEstadias();
	}
	
	
	//getters e setters

	/**
	 * @return the clienteModel
	 */
	public IClienteModel getClienteModel() {
		return clienteModel;
	}

	/**
	 * @param clienteModel the clienteModel to set
	 */
	public void setClienteModel(IClienteModel clienteModel) {
		this.clienteModel = clienteModel;
	}

	/**
	 * @return the clientes
	 */
	public ArrayList<Cliente> getClientes() {
		return clientes;
	}

	/**
	 * @param clientes the clientes to set
	 */
	public void setClientes(ArrayList<Cliente> clientes) {
		this.clientes = clientes;
	}

	/**
	 * @return the endereco
	 */
	public Endereco getEndereco() {
		return endereco;
	}

	/**
	 * @param endereco the endereco to set
	 */
	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

	/**
	 * @return the estadiaModel
	 */
	public IEstadiaModel getEstadiaModel() {
		return estadiaModel;
	}

	/**
	 * @param estadiaModel the estadiaModel to set
	 */
	public void setEstadiaModel(IEstadiaModel estadiaModel) {
		this.estadiaModel = estadiaModel;
	}

	/**
	 * @return the estadias
	 */
	public ArrayList<Estadia> getEstadias() {
		return estadias;
	}

	/**
	 * @param estadias the estadias to set
	 */
	public void setEstadias(ArrayList<Estadia> estadias) {
		this.estadias = estadias;
	}

	/**
	 * @return the fone
	 */
	public String getFone() {
		return fone;
	}

	/**
	 * @param fone the fone to set
	 */
	public void setFone(String fone) {
		this.fone = fone;
	}

	/**
	 * @return the nome
	 */
	public String getNome() {
		return nome;
	}

	/**
	 * @param nome the nome to set
	 */
	public void setNome(String nome) {
		this.nome = nome;
	}

	/**
	 * @return the quartoModel
	 */
	public IQuartoModel getQuartoModel() {
		return quartoModel;
	}

	/**
	 * @param quartoModel the quartoModel to set
	 */
	public void setQuartoModel(IQuartoModel quartoModel) {
		this.quartoModel = quartoModel;
	}

	/**
	 * @return the quartos
	 */
	public ArrayList<Quarto> getQuartos() {
		return quartos;
	}

	/**
	 * @param quartos the quartos to set
	 */
	public void setQuartos(ArrayList<Quarto> quartos) {
		this.quartos = quartos;
	}

	/**
	 * @return the site
	 */
	public String getSite() {
		return site;
	}

	/**
	 * @param site the site to set
	 */
	public void setSite(String site) {
		this.site = site;
	}

}
