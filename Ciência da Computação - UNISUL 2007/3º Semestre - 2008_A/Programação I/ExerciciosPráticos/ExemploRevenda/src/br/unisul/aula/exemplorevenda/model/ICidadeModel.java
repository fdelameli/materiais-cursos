package br.unisul.aula.exemplorevenda.model;

import java.util.ArrayList;

import br.unisul.aula.exemplorevenda.entidade.Cidade;

/**
 * Interface que estabelece os métodos de negócio da entidade Cidade
 * @author Fabio Dela Bruna
 * @since 04/05/2008
 */
public interface ICidadeModel {

	/**
	 * Cadastra uma cidade.
	 * @param c - cidade.
	 */
	public abstract void cadastraCidade(Cidade c);
	
	/**
	 * Retorna um array com as cidades cadastradas.
	 * @return - arrayList de cidades.
	 */
	public abstract ArrayList<Cidade> mostraCidades();
	
	/**
	 * Remove uma cidade específica.
	 * @param c - Cidade.
	 */
	public abstract void removeCidade(Cidade c);
	
	/**
	 * Busca e retorna uma cidade específica.
	 * @param nome - Nome da cidade.
	 * @return - cidade encontrada ou null se não encontrou.
	 */
	public abstract Cidade buscaCidade(String nome);
}
