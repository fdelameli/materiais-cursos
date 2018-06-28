package br.unisul.aula.trabalho.model;

import java.util.ArrayList;

import br.unisul.aula.trabalho.entidades.Veiculo;

/**
 * Interface que define os métodos de negócio da entidade Veiculo.
 * @author Fabio Dela Bruna / Marcio Ozório Teixeira.
 * @since 12/06/2008.
 */
public interface IVeiculoModel {

	/**
	 * Método para cadastrar um veículo.
	 * @param v - Veiculo a ser cadastrado.
	 */
	public abstract void cadastraVeiculo(Veiculo v);
	
	/**
	 * Método para remover o cadastro de um veículo.
	 * @param v - Veiculo à ser removido.
	 */
	public abstract void removeVeiculo(Veiculo v);
	
	/**
	 * Método para atualizar os dados cadastrais de um determinado veículo.
	 * @param novo - Dados cadastrais atualizados.
	 * @param antigo - Dados cadastrais desatualizados.
	 */
	public abstract void atualizaDadosVeiculo(Veiculo novo, Veiculo antigo);
	
	/**
	 * Método que retorna todos os veículos cadastrados na concessionária.
	 * @return ArrayList de veículos cadastrados.
	 */
	public abstract ArrayList<Veiculo> mostraVeiculos();
	
}
