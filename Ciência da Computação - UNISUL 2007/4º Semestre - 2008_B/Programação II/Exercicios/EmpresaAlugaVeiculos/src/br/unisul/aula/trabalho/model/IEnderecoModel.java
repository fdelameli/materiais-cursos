package br.unisul.aula.trabalho.model;

import java.util.ArrayList;

import br.unisul.aula.trabalho.entidades.Endereco;

/**
 * Interface que define os métodos de negócio da entidade Endereco.
 * @author Fabio Dela Bruna / Marcio Ozório Teixeira.
 * @since 12/06/2008.
 */
public interface IEnderecoModel {

	/**
	 * Método para cadastrar um determinado endereço.
	 * @param e - Endereço a ser cadastrado.
	 */
	public abstract void cadastraEndereco(Endereco e);
	
	/**
	 * Método para remover o cadastro de um endereco.
	 * @param e - Endereco a ser removido.
	 */
	public abstract void removeEndereco(Endereco e);
	
	/**
	 * Método para atualizar os dados cadastrais de um endereco.
	 * @param antigo - Dados cadastrais desatualizados.
	 * @param novo - Dados cadastrais atualizados.
	 */
	public abstract void atualizaDadosEndereco(Endereco antigo, Endereco novo);
	
	/**
	 * Método para mostrar todos os enderecos cadastrados.
	 * @return ArrayList de enderecos cadastrados.
	 */
	public abstract ArrayList<Endereco> mostraEnderecos();
}
