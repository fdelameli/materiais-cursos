package br.unisul.aula.exemplorevenda.model;

import java.util.ArrayList;

import br.unisul.aula.exemplorevenda.entidade.Moto;


/**
 * Interface que estabelece os métodos de negócio da entidade Moto.
 * @author Fabio Dela Bruna
 * @since 22/04/2008
 */
public interface IMotoModel {

	/**
	 * Insere uma moto na revenda.
	 * @param m - moto.
	 */
	public abstract void insereMoto(Moto m);
	
	/**
	 * Remove uma moto da revenda.
	 * @param m - moto.
	 */
	public abstract void removeMoto(Moto m);
	
	/**
	 * Atualiza uma moto da revenda.
	 * @param antiga - moto com dados desatualizados.
	 * @param nova - moto com dados atualizados.
	 */
	public abstract void atualizaMoto(Moto antiga, Moto nova);
	
	/**
	 * Busca uma moto específica.
	 * @param placa - Placa da moto.
	 * @param chassi - Chassi da moto.
	 * @return moto encontrada ou null se não encontrou.
	 */
	public abstract Moto buscaMoto(String placa, String chassi);
	
	/**
	 * Lista todas as motos da revenda.
	 * @return - Lista de motos.
	 */
	public abstract ArrayList<Moto> mostraMotos();
	
}
