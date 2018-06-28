package br.unisul.aula.exemplorevenda.model;

import java.util.ArrayList;

import br.unisul.aula.exemplorevenda.entidade.Funcionario;

/**
 * Interface que estabelece os métodos de negócio da entidade Funcionario
 * @author Fabio Dela Bruna
 * @since 05/05/2008
 */
public interface IFuncionarioModel {

	/**
	 * Cadastra um funcionário na revenda.
	 * @param f - Funcionário.
	 */
	public abstract void cadastraFuncionario(Funcionario f);
	
	/**
	 * Remove um funcionário da revenda.
	 * @param f - Funcionário.
	 */
	public abstract void removeFuncionario(Funcionario f);
	
	/**
	 * Atualiza os dados cadastrais de um funcionario da revenda.
	 * @param antigo - Funcionário com dados desatualizados.
	 * @param novo - Funcionário com dados atualizados.
	 */
	public abstract void atualizaFuncionario(Funcionario antigo, Funcionario novo);
	
	/**
	 * Busca um funcionário específico.
	 * @param nome - Nome do funcionário.
	 * @param cpf - Cpf do funcionário.
	 * @return Funcionario encontrado ou null se não encontrou.
	 */
	public abstract Funcionario buscaFuncionario(String nome, String cpf);
	
	/**
	 * Lista todos os funcionários da revenda.
	 * @return - Lista de Funcionários.
	 */
	public abstract ArrayList<Funcionario> mostraFuncionarios();
}

