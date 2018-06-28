package br.unisul.aula.trabalho.model;

import java.util.ArrayList;

import br.unisul.aula.trabalho.entidades.Funcionario;

/**
 * Interface que define os métodos de negócio da entidade Funcionario.
 * @author Fabio Dela Bruna / Marcio Ozório Teixeira.
 * @since 12/06/2008.
 */
public interface IFuncionarioModel {

	/**
	 * Método para cadastrar um funcionário.
	 * @param f - Funcionário a ser cadastrado.
	 */
	public abstract void cadastraFuncionario(Funcionario f);

	/**
	 * Método para remover o cadastro de um funcionário.
	 * @param f - Funcionario à remover.
	 */
	public abstract void removeFuncionario(Funcionario f);
	
	/**
	 * Mátodo para atualizar os dados cadastrais de um Funcionario.
	 * @param antigo - Dados cadastrais antigos.
	 * @param novo - Dados cadastrais atualizados.
	 */
	public abstract void atualizaDadosFuncionario(Funcionario antigo, Funcionario novo);
	
	/**
	 * Método para efetuar uma busca por um funcionário específico.
	 * @param nome - Nome do funcionário.
	 * @return ArrayList com os funcionarios que contem o mesmo nome.
	 */
	public abstract ArrayList<Funcionario> buscaFuncionario(String nome);
	
	/**
	 * Método que retorna todos os funcionários cadastrados.
	 * @return ArrayList de funcionários cadastrados.
	 */
	public abstract ArrayList<Funcionario> buscaFuncionario();
}
