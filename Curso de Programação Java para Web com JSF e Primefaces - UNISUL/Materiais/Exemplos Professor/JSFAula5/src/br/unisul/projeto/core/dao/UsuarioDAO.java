package br.unisul.projeto.core.dao;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Query;

import br.unisul.projeto.core.dao.conexao.EntityManagerProvider;
import br.unisul.projeto.core.entity.UsuarioEntity;

public class UsuarioDAO extends CrudDAO<UsuarioEntity>{
	
	//Busca usuario por login e senha no banco
	public UsuarioEntity buscarUsuarioPorLoginSenha(String login, String senha){
		
		//Comando "HQL"
		String hql = "from UsuarioEntity where login = :login and senha = :senha";
		
		//Abre conexao hibernate
		EntityManager em = EntityManagerProvider.
				getEntityManagerFactory().createEntityManager();
		
		try{
			em.getTransaction().begin();
			
			//Seta comando hql
			Query q = em.createQuery(hql);
			//Seta os parametros do comando
			q.setParameter("login", login);
			q.setParameter("senha", senha);
			
			try{
				//Busca no banco
				return (UsuarioEntity)q.getSingleResult();

				//caso nao traga resultado neste metodo ele retorna um NoResultException
			}catch (NoResultException e) {
				return null;
			}
		}finally{
			em.close();
		}
	}
}















