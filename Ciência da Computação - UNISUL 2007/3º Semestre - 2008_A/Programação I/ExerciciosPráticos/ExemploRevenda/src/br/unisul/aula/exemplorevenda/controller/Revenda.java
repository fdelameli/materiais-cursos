package br.unisul.aula.exemplorevenda.controller;

import java.util.ArrayList;

import br.unisul.aula.exemplorevenda.entidade.*;
import br.unisul.aula.exemplorevenda.model.*;

/**
 * Classe de negócio responsável por manipular os
 * dados da revenda.
 * @author Fabio Dela Bruna
 * @since 22/04/2008
 */
public class Revenda implements ICarroModel, IMotoModel, IClienteModel, IFuncionarioModel, ICidadeModel, IVendaModel {
	
	// atributos
	
	private Cidade cidade;
	private String nome;
	private String endereco;
	private String telefone;
	private String site;
	
	private ArrayList<Carro> carros;
	private ArrayList<Moto> motos;
	private ArrayList<Cliente> clientes;
	private ArrayList<Funcionario> funcionarios;
	private ArrayList<Cidade> cidades;
	private ArrayList<Venda> vendas;
	
	private ICarroModel carroModel;
	private IMotoModel motoModel;
	private IClienteModel clienteModel;
	private IFuncionarioModel funcionarioModel;
	private ICidadeModel cidadeModel;
	private IVendaModel vendaModel;
	
	
	// construtores
	
	/**
	 * Construtor default.
	 */
	public Revenda() {
		super();
		this.carros = new ArrayList<Carro>();
		this.motos = new ArrayList<Moto>();
		this.clientes = new ArrayList<Cliente>();
		this.funcionarios = new ArrayList<Funcionario>();
		this.cidades = new ArrayList<Cidade>();
		this.vendas = new ArrayList<Venda>();
		
		this.carroModel = new CarroModel(carros);
		this.motoModel = new MotoModel(motos);
		this.clienteModel = new ClienteModel(clientes);
		this.funcionarioModel = new FuncionarioModel(funcionarios);
		this.cidadeModel = new CidadeModel(cidades);
		this.vendaModel = new VendaModel(vendas);
	}
	
	
	// métodos referentes à carros
	
	@Override
	public void insereCarro(Carro c) {
		this.carroModel.insereCarro(c);
	}

	@Override
	public void atualizaCarro(Carro antigo, Carro novo) {
		this.carroModel.atualizaCarro(antigo, novo);
	}

	@Override
	public void removeCarro(Carro c) {
		this.carroModel.removeCarro(c);
	}

	@Override
	public Carro buscaCarro(String placa, String chassi) {
		return this.carroModel.buscaCarro(placa, chassi);
	}

	@Override
	public ArrayList<Carro> mostraCarros() {
		return this.carroModel.mostraCarros();
	}
	
	
	// métodos referentes à motos
	
	@Override
	public void atualizaMoto(Moto antiga, Moto nova) {
		this.motoModel.atualizaMoto(antiga, nova);
	}

	@Override
	public Moto buscaMoto(String placa, String chassi) {
		return this.motoModel.buscaMoto(placa, chassi);
	}

	@Override
	public void insereMoto(Moto m) {
		this.motoModel.insereMoto(m);
	}

	@Override
	public ArrayList<Moto> mostraMotos() {
		return this.motoModel.mostraMotos();
	}

	@Override
	public void removeMoto(Moto m) {
		this.motoModel.removeMoto(m);
	}

	
	// métodos referentes à clientes
	
	@Override
	public void atualizaCliente(Cliente novo, Cliente antigo) {
		this.clienteModel.atualizaCliente(novo, antigo);		
	}

	@Override
	public Cliente buscaCliente(String nome, String cpf) {
		return this.clienteModel.buscaCliente(nome, cpf);
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

	
	// métodos referentes à funcionários
	
	@Override
	public void atualizaFuncionario(Funcionario antigo, Funcionario novo) {
		this.funcionarioModel.atualizaFuncionario(antigo, novo);
	}

	@Override
	public Funcionario buscaFuncionario(String nome, String cpf) {
		return this.funcionarioModel.buscaFuncionario(nome, cpf);
	}

	@Override
	public void cadastraFuncionario(Funcionario f) {
		this.funcionarioModel.cadastraFuncionario(f);
	}

	@Override
	public ArrayList<Funcionario> mostraFuncionarios() {
		return this.funcionarioModel.mostraFuncionarios();
	}

	@Override
	public void removeFuncionario(Funcionario f) {
		this.funcionarioModel.removeFuncionario(f);
	}
	
	
	// métodos referentes à cidades

	@Override
	public Cidade buscaCidade(String nome) {
		return this.cidadeModel.buscaCidade(nome);
	}

	@Override
	public void cadastraCidade(Cidade c) {
		this.cidadeModel.cadastraCidade(c);
	}

	@Override
	public ArrayList<Cidade> mostraCidades() {
		return this.cidadeModel.mostraCidades();
	}

	@Override
	public void removeCidade(Cidade c) {
		this.cidadeModel.removeCidade(c);
	}
	
	
	// métodos referentes à Vendas.
	
	@Override
	public Venda buscaVenda(int codigo, String cliente) {
		return this.vendaModel.buscaVenda(codigo, cliente);
	}

	@Override
	public void efetuaVenda(Venda v) {
		this.vendaModel.efetuaVenda(v);
	}

	@Override
	public ArrayList<Venda> mostraVendas() {
		return this.vendaModel.mostraVendas();
	}

	
	// gettes e setters

	public Cidade getCidade() {
		return cidade;
	}

	public void setCidade(Cidade cidade) {
		this.cidade = cidade;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getSite() {
		return site;
	}

	public void setSite(String site) {
		this.site = site;
	}

	/**
	 * @return the carroModel
	 */
	public ICarroModel getCarroModel() {
		return carroModel;
	}

	/**
	 * @param carroModel the carroModel to set
	 */
	public void setCarroModel(ICarroModel carroModel) {
		this.carroModel = carroModel;
	}

	/**
	 * @return the carros
	 */
	public ArrayList<Carro> getCarros() {
		return carros;
	}

	/**
	 * @param carros the carros to set
	 */
	public void setCarros(ArrayList<Carro> carros) {
		this.carros = carros;
	}

	/**
	 * @return the cidadeModel
	 */
	public ICidadeModel getCidadeModel() {
		return cidadeModel;
	}

	/**
	 * @param cidadeModel the cidadeModel to set
	 */
	public void setCidadeModel(ICidadeModel cidadeModel) {
		this.cidadeModel = cidadeModel;
	}

	/**
	 * @return the cidades
	 */
	public ArrayList<Cidade> getCidades() {
		return cidades;
	}

	/**
	 * @param cidades the cidades to set
	 */
	public void setCidades(ArrayList<Cidade> cidades) {
		this.cidades = cidades;
	}

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
	 * @return the funcionarioModel
	 */
	public IFuncionarioModel getFuncionarioModel() {
		return funcionarioModel;
	}

	/**
	 * @param funcionarioModel the funcionarioModel to set
	 */
	public void setFuncionarioModel(IFuncionarioModel funcionarioModel) {
		this.funcionarioModel = funcionarioModel;
	}

	/**
	 * @return the funcionarios
	 */
	public ArrayList<Funcionario> getFuncionarios() {
		return funcionarios;
	}

	/**
	 * @param funcionarios the funcionarios to set
	 */
	public void setFuncionarios(ArrayList<Funcionario> funcionarios) {
		this.funcionarios = funcionarios;
	}

	/**
	 * @return the motoModel
	 */
	public IMotoModel getMotoModel() {
		return motoModel;
	}

	/**
	 * @param motoModel the motoModel to set
	 */
	public void setMotoModel(IMotoModel motoModel) {
		this.motoModel = motoModel;
	}

	/**
	 * @return the motos
	 */
	public ArrayList<Moto> getMotos() {
		return motos;
	}

	/**
	 * @param motos the motos to set
	 */
	public void setMotos(ArrayList<Moto> motos) {
		this.motos = motos;
	}

	/**
	 * @return the vendaModel
	 */
	public IVendaModel getVendaModel() {
		return vendaModel;
	}

	/**
	 * @param vendaModel the vendaModel to set
	 */
	public void setVendaModel(IVendaModel vendaModel) {
		this.vendaModel = vendaModel;
	}

	/**
	 * @return the vendas
	 */
	public ArrayList<Venda> getVendas() {
		return vendas;
	}

	/**
	 * @param vendas the vendas to set
	 */
	public void setVendas(ArrayList<Venda> vendas) {
		this.vendas = vendas;
	}

}
