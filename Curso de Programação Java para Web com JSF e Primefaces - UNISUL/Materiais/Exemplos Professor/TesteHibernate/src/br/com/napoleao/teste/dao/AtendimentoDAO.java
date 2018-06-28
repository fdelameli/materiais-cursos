package br.com.napoleao.teste.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;

import br.com.napoleao.teste.dao.conexao.EntityManagerProvider;
import br.com.napoleao.teste.entity.AtendimentoEntity;

public class AtendimentoDAO extends CrudDAO<AtendimentoEntity>{

	public List<AtendimentoEntity> buscarFiltrado(AtendimentoEntity atend){
		
		em = EntityManagerProvider.getEntityManagerFactory().createEntityManager();
		em.getTransaction().begin();
		
//		Criteria c = getHibernateSession().createCriteria(AtendimentoEntity.class);
//		
//		return c.list();
		
//		Criteria crit = getHibernateSession().createCriteria(AtendimentoEntity.class);
//		crit.add(Restrictions.eq("identificao", "teste")); 
//		crit.add(Restrictions.ilike("identificao", "Rogério%"));
//		return crit.list();
		
//		Criteria crit = getHibernateSession().createCriteria(AtendimentoEntity.class);
//		crit.add(Restrictions.eq("identificao", "teste"));
//		Criteria pacientes = crit.createCriteria("pacientes");
//		pacientes.add(Restrictions.eq("nome", "Rogério"));
		
		Criteria crit = getHibernateSession().createCriteria(AtendimentoEntity.class);
		crit.add(Restrictions.eq("identificao", "teste"));
		crit.createAlias("pacientes", "p");
		crit.add(Restrictions.eq("p.nome", "Rogério"));
		
		return crit.list();
	}
}
