package br.unisul.aula.trabalho.controller;

import java.util.ArrayList;

import br.unisul.aula.trabalho.entidades.Aluguel;
import br.unisul.aula.trabalho.entidades.Cliente;
import br.unisul.aula.trabalho.entidades.Endereco;
import br.unisul.aula.trabalho.entidades.Funcionario;
import br.unisul.aula.trabalho.entidades.Veiculo;
import br.unisul.aula.trabalho.model.AluguelModel;
import br.unisul.aula.trabalho.model.ClienteModel;
import br.unisul.aula.trabalho.model.EnderecoModel;
import br.unisul.aula.trabalho.model.FuncionarioModel;
import br.unisul.aula.trabalho.model.IAluguelModel;
import br.unisul.aula.trabalho.model.IClienteModel;
import br.unisul.aula.trabalho.model.IEnderecoModel;
import br.unisul.aula.trabalho.model.IFuncionarioModel;
import br.unisul.aula.trabalho.model.IReceitaModel;
import br.unisul.aula.trabalho.model.IVeiculoModel;
import br.unisul.aula.trabalho.model.ReceitaModel;
import br.unisul.aula.trabalho.model.VeiculoModel;


/**
 * Classe de negócio responsável por manipular os dados da Concessionaria.
 * @author Fabio Dela Bruna / Marcio Ozório Teixeira.
 * @since 17/06/2008.
 */
public class Concessionaria implements IClienteModel, IFuncionarioModel, IVeiculoModel,
								IAluguelModel, IEnderecoModel, IReceitaModel {

	//attributes
	
	private String nome;
	private String fone;
	private Endereco endereco;
	private String site;
	
	private ArrayList<Cliente> clientes;
	private ArrayList<Funcionario> funcionarios;
	private ArrayList<Veiculo> veiculos;
	private ArrayList<Aluguel> alugueis;
	private ArrayList<Endereco> enderecos;
	
	private IClienteModel clienteModel;
	private IFuncionarioModel funcionarioModel;
	private IVeiculoModel veiculoModel;
	private IAluguelModel aluguelModel;
	private IEnderecoModel enderecoModel;
	private IReceitaModel receitaModel;
	
	
	//constructors
	
	/**
	 * Construtor default.
	 */
	public Concessionaria() {
		this("", "", new Endereco(), "");
		
		this.clientes = new ArrayList<Cliente>();
		this.funcionarios = new ArrayList<Funcionario>();
		this.veiculos = new ArrayList<Veiculo>();
		this.alugueis = new ArrayList<Aluguel>();
		this.enderecos = new ArrayList<Endereco>();
		
		this.clienteModel = new ClienteModel(clientes);
		this.funcionarioModel = new FuncionarioModel(funcionarios);
		this.veiculoModel = new VeiculoModel(veiculos);
		this.aluguelModel = new AluguelModel(alugueis);
		this.enderecoModel = new EnderecoModel(enderecos);
		this.receitaModel = new ReceitaModel(alugueis, funcionarios);
	}

	/**
	 * @param nome
	 * @param endereco
	 * @param fone
	 * @param site
	 */
	public Concessionaria(String nome, String fone, Endereco endereco, String site) {
		super();
		this.nome = nome;
		this.fone = fone;
		this.endereco = endereco;
		this.site = site;
		
		this.clientes = new ArrayList<Cliente>();
		this.funcionarios = new ArrayList<Funcionario>();
		this.veiculos = new ArrayList<Veiculo>();
		this.alugueis = new ArrayList<Aluguel>();
		this.enderecos = new ArrayList<Endereco>();
		
		this.clienteModel = new ClienteModel(clientes);
		this.funcionarioModel = new FuncionarioModel(funcionarios);
		this.veiculoModel = new VeiculoModel(veiculos);
		this.aluguelModel = new AluguelModel(alugueis);
		this.enderecoModel = new EnderecoModel(enderecos);
		this.receitaModel = new ReceitaModel(alugueis, funcionarios);
	}
	
	
	//métodos referentes à Clientes

	@Override
	public void atualizaDadosCliente(Cliente antigo, Cliente novo) {
		this.clienteModel.atualizaDadosCliente(antigo, novo);
	}

	@Override
	public ArrayList<Cliente> buscaCliente() {
		return this.clienteModel.buscaCliente();
	}
	
	@Override
	public ArrayList<Cliente> buscaCliente(String nome) {
		return this.clienteModel.buscaCliente(nome);
	}

	@Override
	public void cadastraCliente(Cliente c) {
		this.clienteModel.cadastraCliente(c);
	}

	@Override
	public void removeCliente(Cliente c) {
		this.clienteModel.removeCliente(c);
	}
	
	@Override
	public void cadastraAluguel(Cliente c, Aluguel a) {
		this.clienteModel.cadastraAluguel(c, a);
	}
	
	
	//Métodos referentes à Alugueis
	
	@Override
	public ArrayList<Aluguel> buscaAluguel(Cliente c) {
		return this.aluguelModel.buscaAluguel(c);
	}

	@Override
	public ArrayList<Aluguel> buscaAluguel(Veiculo v) {
		return this.aluguelModel.buscaAluguel(v);
	}

	@Override
	public ArrayList<Aluguel> buscaAluguel() {
		return this.aluguelModel.buscaAluguel();
	}
	
	@Override
	public void cadastraAluguel(Aluguel a) {
		this.aluguelModel.cadastraAluguel(a);		
	}

	
	//métodos referentes à Funcionários
	
	@Override
	public void atualizaDadosFuncionario(Funcionario antigo, Funcionario novo) {
		this.funcionarioModel.atualizaDadosFuncionario(antigo, novo);
	}

	@Override
	public ArrayList<Funcionario> buscaFuncionario() {
		return this.funcionarioModel.buscaFuncionario();
	}
	
	@Override
	public ArrayList<Funcionario> buscaFuncionario(String nome) {
		return this.funcionarioModel.buscaFuncionario(nome);
	}

	@Override
	public void cadastraFuncionario(Funcionario f) {
		this.funcionarioModel.cadastraFuncionario(f);
	}

	@Override
	public void removeFuncionario(Funcionario f) {
		this.funcionarioModel.removeFuncionario(f);
	}

	
	//métodos referentes à Endereços
	
	@Override
	public void atualizaDadosEndereco(Endereco antigo, Endereco novo) {
		this.enderecoModel.atualizaDadosEndereco(antigo, novo);
	}

	@Override
	public void cadastraEndereco(Endereco e) {
		this.enderecoModel.cadastraEndereco(e);
	}

	@Override
	public ArrayList<Endereco> mostraEnderecos() {
		return this.enderecoModel.mostraEnderecos();
	}

	@Override
	public void removeEndereco(Endereco e) {
		this.enderecoModel.removeEndereco(e);
	}

	
	//Métodos referentes à Veículos
	
	@Override
	public void atualizaDadosVeiculo(Veiculo novo, Veiculo antigo) {
		this.veiculoModel.atualizaDadosVeiculo(novo, antigo);
	}

	@Override
	public void cadastraVeiculo(Veiculo v) {
		this.veiculoModel.cadastraVeiculo(v);
	}

	@Override
	public void removeVeiculo(Veiculo v) {
		this.veiculoModel.removeVeiculo(v);	
	}
	
	@Override
	public ArrayList<Veiculo> mostraVeiculos() {
		return this.veiculoModel.mostraVeiculos();
	}

	
	//métodos referentes à Receita

	@Override
	public double getTotalBruto() {
		return this.receitaModel.getTotalBruto();
	}

	@Override
	public double getTotalDispesa() {
		return this.receitaModel.getTotalDispesa();
	}

	@Override
	public double getTotalLiquido() {
		return this.receitaModel.getTotalLiquido();
	}
	
	
	//getters e setters

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getFone() {
		return fone;
	}

	public void setFone(String fone) {
		this.fone = fone;
	}

	public String getSite() {
		return site;
	}

	public void setSite(String site) {
		this.site = site;
	}
	
	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

	public ArrayList<Cliente> getClientes() {
		return clientes;
	}

	public void setClientes(ArrayList<Cliente> clientes) {
		this.clientes = clientes;
	}

	public ArrayList<Funcionario> getFuncionarios() {
		return funcionarios;
	}

	public void setFuncionarios(ArrayList<Funcionario> funcionarios) {
		this.funcionarios = funcionarios;
	}

	public ArrayList<Veiculo> getVeiculos() {
		return veiculos;
	}

	public void setVeiculos(ArrayList<Veiculo> veiculos) {
		this.veiculos = veiculos;
	}

	public ArrayList<Aluguel> getAlugueis() {
		return alugueis;
	}

	public void setAlugueis(ArrayList<Aluguel> alugueis) {
		this.alugueis = alugueis;
	}

	public ArrayList<Endereco> getEnderecos() {
		return enderecos;
	}

	public void setEnderecos(ArrayList<Endereco> enderecos) {
		this.enderecos = enderecos;
	}

	public IClienteModel getClienteModel() {
		return clienteModel;
	}

	public void setClienteModel(IClienteModel clienteModel) {
		this.clienteModel = clienteModel;
	}

	public IFuncionarioModel getFuncionarioModel() {
		return funcionarioModel;
	}

	public void setFuncionarioModel(IFuncionarioModel funcionarioModel) {
		this.funcionarioModel = funcionarioModel;
	}

	public IVeiculoModel getVeiculoModel() {
		return veiculoModel;
	}

	public void setVeiculoModel(IVeiculoModel veiculoModel) {
		this.veiculoModel = veiculoModel;
	}

	public IAluguelModel getAluguelModel() {
		return aluguelModel;
	}

	public void setAluguelModel(IAluguelModel aluguelModel) {
		this.aluguelModel = aluguelModel;
	}

	public IEnderecoModel getEnderecoModel() {
		return enderecoModel;
	}

	public void setEnderecoModel(IEnderecoModel enderecoModel) {
		this.enderecoModel = enderecoModel;
	}

	public IReceitaModel getReceitaModel() {
		return receitaModel;
	}

	public void setReceitaModel(IReceitaModel receitaModel) {
		this.receitaModel = receitaModel;
	}
	
	
}
