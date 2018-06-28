package br.com.napoleao.teste.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.ejb.EntityManagerImpl;

import br.com.napoleao.teste.dao.conexao.EntityManagerProvider;

public class CrudDAO<E>{
	
	public EntityManager em;
	
	public void cadastro(E entity){
		try{
			em = EntityManagerProvider.getEntityManagerFactory().createEntityManager();
			em.getTransaction().begin();
			em.persist(entity);
			em.getTransaction().commit();
		}finally{
			em.close();
		}
	}
	
	public void atualizar(E entity){
		try{
			em = EntityManagerProvider.getEntityManagerFactory().createEntityManager();
			em.getTransaction().begin();
			em.merge(entity);
			em.getTransaction().commit();
		}finally{
			em.close();
		}
	}
	
	public void excluir(E entity){
		try{
			em = EntityManagerProvider.getEntityManagerFactory().createEntityManager();
			em.getTransaction().begin();
			em.remove(em.merge(entity));
			em.getTransaction().commit();
		}finally{
			em.close();
		}
	}
	
	public E buscarPorId(Class clazz, Object id){
		try{
			em = EntityManagerProvider.getEntityManagerFactory().createEntityManager();
			em.getTransaction().begin();
			return (E)em.find(clazz, id);
		}finally{
			em.close();
		}
	}

	public List<E> listarTodos(Class clazz){
		try{
			em = EntityManagerProvider.getEntityManagerFactory().createEntityManager();
			em.getTransaction().begin();
			return em.createQuery("from " + clazz.getName()).getResultList();
		}finally{
			em.close();
		}
	}
	
	public List<E> listarTodos(Class clazz, Integer inicio, Integer qtdRegistro){
		try{
			em = EntityManagerProvider.getEntityManagerFactory().createEntityManager();
			em.getTransaction().begin();
			Query q = em.createQuery("from " + clazz.getName());
			q.setFirstResult(inicio);
			q.setMaxResults(qtdRegistro);
			return q.getResultList(); 
		}finally{
			em.close();
		}
	}
	
	public Session getHibernateSession()
	{
		Session session;
		if (em.getDelegate() instanceof EntityManagerImpl)
		{  
			EntityManagerImpl emImpl = (EntityManagerImpl) em.getDelegate();  
			session = emImpl.getSession();
		}
		else
		{  
			session = (Session) em.getDelegate();  
		}
		
		return session;
	}
}