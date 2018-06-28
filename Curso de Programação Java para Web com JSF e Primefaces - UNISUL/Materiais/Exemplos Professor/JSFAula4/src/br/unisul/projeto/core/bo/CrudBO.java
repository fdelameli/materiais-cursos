package br.unisul.projeto.core.bo;

import java.util.List;

import br.unisul.projeto.core.dao.CrudDAO;

public class CrudBO<E>{
	
	CrudDAO<E> dao;
	
	public CrudBO() {
		dao = new CrudDAO<E>();
	}
	
	public void insert(E entidade){
		dao.insert(entidade);
	}
	
	public void update(E entidade){
		dao.update(entidade);
	}
	
	public void remove(E entidade){
		dao.remove(entidade);
	}

	public E buscarPorId(Class clazz, Object id){
		return dao.buscarPorId(clazz, id);
	}
	
	public List<E> listarTodos(Class clazz){
		return dao.listarTodos(clazz);
	}
}
