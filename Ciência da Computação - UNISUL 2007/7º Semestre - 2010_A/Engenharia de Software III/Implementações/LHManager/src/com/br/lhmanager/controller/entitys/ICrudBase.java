package com.br.lhmanager.controller.entitys;

import java.util.ArrayList;

/**
 * Interface que define os métodos básicos de persistência (CRUD).
 * @author Fabio Dela Bruna.
 * @since 04/05/2010.
 */
public interface ICrudBase {
 
	/**
	 * Método utilizado para inserir um objeto no banco de dados.
	 * @param obj Objeto a ser inserido.
	 * @return true se foi inserido com sucesso, false se ouve algum erro ao inserir.
	 */
	public abstract boolean inserir(Object obj);
	
	/**
	 * Método utilizado para atualizar um objeto no banco de dados.
	 * @param obj Objeto a ser atualizado.
	 * @return true se foi atualizado com sucesso, false se ouve algum erro ao atualizar.
	 */
	public abstract boolean atualizar(Object obj);
	
	/**
	 * Método utilizado para deletar um objeto no banco de dados.
	 * @param obj Objeto a ser deletado.
	 * @return true se foi deletado com sucesso, false se ouve algum erro ao deletar.
	 */
	public abstract boolean deletar(Object obj);
	
	/**
	 * Método utilizado para buscar os objetos no banco de dados.
	 * @param obj Objeto a ser buscado.
	 * @return Lista de objetos encontrados no banco de dados.
	 */
	@SuppressWarnings("unchecked")
	public abstract ArrayList listar(Object obj);
	
	
}
 
