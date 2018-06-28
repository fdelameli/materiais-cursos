package br.unisul.aula.exemplorevenda.model;

import java.util.ArrayList;

import br.unisul.aula.exemplorevenda.entidade.Carro;

/**
 * Interface que estabelece os métodos de negócio da entidade Carro
 * @author Fabio Dela Bruna
 * @since 22/04/2008
 */
public interface ICarroModel {

	
	/**
	 * Insere um carro na revenda.
	 * @param c - Carro.
	 */
	public abstract void insereCarro(Carro c);
	
	/**
	 * Remove um carro da revenda.
	 * @param c - Carro.
	 */
	public abstract void removeCarro(Carro c);
	
	/**
	 * Atualiza um carro da revenda.
	 * @param antigo - Carro com dados desatualizados.
	 * @param novo - Carro com dados atualizados.
	 */
	public abstract void atualizaCarro(Carro antigo, Carro novo);
	
	/**
	 * Busca um carro específico.
	 * @param placa - Placa do Carro.
	 * @param chassi - Chassi do carro.
	 * @return Carro encontrado ou null se não encontrou.
	 */
	public abstract Carro buscaCarro(String placa, String chassi);
	
	/**
	 * Lista todos os carros da revenda.
	 * @return - Lista de Carros.
	 */
	public abstract ArrayList<Carro> mostraCarros();
}
