package br.unisul.projeto.core.dao;

import br.unisul.projeto.core.entity.UsuarioEntity;

public class UsuarioDAO extends CrudDAO<UsuarioEntity>{

//	public void insertUsuario(UsuarioEntity usuario){
//		EntityManager em = EntityManagerProvider
//					.getEntityManagerFactory().createEntityManager();
//		
//		try{
//			em.getTransaction().begin();
//			em.persist(usuario);
//			em.getTransaction().commit();
//		}finally{
//			em.close();
//		}
//	}
//	
//	public List<UsuarioEntity> listarUsuario(){
//		
//		String hql = "from UsuarioEntity";
//		
//		EntityManager em = EntityManagerProvider
//					.getEntityManagerFactory().createEntityManager();
//		
//		Query q = em.createQuery(hql);
//		
//		return q.getResultList();
//	}
//	
//	public void atualizarUsuario(UsuarioEntity usuario){
//		
//		EntityManager em = EntityManagerProvider.
//				getEntityManagerFactory().createEntityManager();
//		
//		try{
//			em.getTransaction().begin();
//			em.merge(usuario);
//			em.getTransaction().commit();
//		}finally{
//			em.close();
//		}
//	}
//	
//	public void removerUsuario(UsuarioEntity usuario){
//		
//		EntityManager em = EntityManagerProvider.
//				getEntityManagerFactory().createEntityManager();
//		
//		try{
//			em.getTransaction().begin();
//			em.remove(em.merge(usuario));
//			em.getTransaction().commit();
//		}finally{
//			em.close();
//		}
//	}
}















