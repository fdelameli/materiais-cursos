package com.br.lhmanager.model.dao;

import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Interface que define os métodos responsáveis pelas persistencia das entidades
 * na base de dados
 * 
 * @author Márcio Ozório Teixeira
 * @since 04/05/2010
 */
public interface ICrudBase {

	/**
	 * Método responsável por inserir um objeto na base de dados
	 * 
	 * @param obj
	 *            objeto a ser inserido na base de dados
	 * @return true, caso tenha sido inserido com sucesso, false, caso contrário
	 */
	public abstract void inserir(Object obj) throws SQLException;

	/**
	 * Método responsável por alterar um objeto na base de dados.
	 * 
	 * @param obj
	 *            objeto a ser alterado na base de dados
	 * @return true, caso tenha sido alterado com sucesso, false, caso contrário
	 */
	public abstract void alterar(Object obj) throws SQLException;

	/**
	 * Método responsável por excluir um objeto da base de dados.
	 * 
	 * @param obj
	 *            objeto a ser excluido da base de dados
	 * @return true, caso tenha sido excluido com sucesso, false, caso contrário
	 */
	public abstract void excluir(Object obj) throws SQLException;

	/**
	 * Método responsável por consultar um objeto na base de dados
	 * 
	 * @return uma lista de todos os objetos encontrados na base de dados.
	 */
	@SuppressWarnings("unchecked")
	public abstract ArrayList consultar() throws SQLException;
	
	/**
	 * Método responsável por consultar um objeto na base de dados atravéz do código.
	 * 
	 * @param obj objeto a ser consultado na base de dados
	 * @return objeto encontrado na base de dados.
	 */
	public abstract Object findById(Object obj) throws SQLException;

}
