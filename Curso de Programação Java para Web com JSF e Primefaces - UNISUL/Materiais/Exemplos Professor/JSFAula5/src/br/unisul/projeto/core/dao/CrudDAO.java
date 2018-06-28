package br.unisul.projeto.core.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.unisul.projeto.core.dao.conexao.EntityManagerProvider;

public class CrudDAO<E> {

	public void insert(E entidade){
		EntityManager em = EntityManagerProvider.
				getEntityManagerFactory().createEntityManager();

		try{
			em.getTransaction().begin();
			em.persist(entidade);
			em.getTransaction().commit();
		}finally{
			em.close();
		}
	}
	
	public void update(E entidade){
		EntityManager em = EntityManagerProvider.
				getEntityManagerFactory().createEntityManager();

		try{
			em.getTransaction().begin();
			em.merge(entidade);
			em.getTransaction().commit();
		}finally{
			em.close();
		}
	}
	
	public void remove(E entidade){
		EntityManager em = EntityManagerProvider.
				getEntityManagerFactory().createEntityManager();

		try{
			em.getTransaction().begin();
			em.remove(em.merge(entidade));
			em.getTransaction().commit();
		}finally{
			em.close();
		}
	}
	
	public E buscarPorId(Class clazz, Object id){
		
		EntityManager em = EntityManagerProvider.
				getEntityManagerFactory().createEntityManager();
		
		try{
			em.getTransaction().begin();
			return (E)em.find(clazz, id);
		}finally{
			em.close();
		}
	}
	
	public List<E> listarTodos(Class clazz){
		
		String hql = "from " + clazz.getName(); 
		
		EntityManager em = EntityManagerProvider.
				getEntityManagerFactory().createEntityManager();

		try{
			em.getTransaction().begin();
			Query q = em.createQuery(hql);
			return q.getResultList();
		}finally{
			em.close();
		}
	}
	



}

