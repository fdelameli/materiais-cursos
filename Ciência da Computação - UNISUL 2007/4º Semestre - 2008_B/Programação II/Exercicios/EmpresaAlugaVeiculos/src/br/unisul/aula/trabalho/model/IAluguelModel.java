package br.unisul.aula.trabalho.model;

import java.util.ArrayList;

import br.unisul.aula.trabalho.entidades.Aluguel;
import br.unisul.aula.trabalho.entidades.Cliente;
import br.unisul.aula.trabalho.entidades.Veiculo;

/**
 * Interface que define os métodos de negócio da entidade Aluguel.
 * @author Fabio Dela Bruna / Marcio Ozório Teixeira.
 * @since 12/06/2008.
 */
public interface IAluguelModel {

	/**
	 * Método para cadastrar um determinado aluguel.
	 * @param a - Aluguel a ser cadastrado.
	 */
	public abstract void cadastraAluguel(Aluguel a);
	
	/**
	 * Método que returna uma lista de todos os alugueis de um determinado veículo.
	 * @param v - Veículo a ser buscado.
	 * @return ArrayList de aluguesi de um determinado veículo.
	 */
	public abstract ArrayList<Aluguel> buscaAluguel(Veiculo v);
	
	/**
	 * Método que returna uma lista de todos os alugueis de um determinado veículo.
	 * @param c - Cliente a ser buscado.
	 * @return ArrayList de alugueis de um determinado Cliente.
	 */
	public abstract ArrayList<Aluguel> buscaAluguel(Cliente c);
	
	/**
	 * Metodo que mostra um histórico de todos os alugueis já efetuados.
	 * @return ArrayList com o histórico de alugueis efetuados.
	 */
	public abstract ArrayList<Aluguel> buscaAluguel();
	
	
}
