package br.unisul.aula.trabalho.model;

import java.util.ArrayList;

import br.unisul.aula.trabalho.entidades.Cliente;
import br.unisul.aula.trabalho.entidades.Estadia;

/**
 * Interface que define os métodos de negócio da entidade Estadia.
 * @author Fabio Dela Bruna / Márcio Teixeira Ozório.
 * @since 14/05/2008.
 */
public interface IEstadiaModel {
	
	/**
	 * Efetua o cadastro de uma Estadia.
	 * @param e - Estadia a ser cadastrada.
	 */
	public abstract void cadastraEstadia(Estadia e);
	
	/**
	 * Efetua uma busca por uma estadia específica.
	 * @param c - Cliente.
	 * @return ArrayList de clientes (se o cliente tiver estadias) ou null se não tiver.
	 */
	public abstract ArrayList<Estadia> buscaEstadia(Cliente c);
	
	/**
	 * Mostra o histórico de todas as estadias cadastradas.
	 * @return ArrayList de Estadias.
	 */
	public abstract ArrayList<Estadia> mostraEstadias();

}
