package com.br.lhmanager.model.dao;

import java.sql.SQLException;
import java.util.ArrayList;

import javax.persistence.EntityManager;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

import com.br.lhmanager.controller.entitys.Despesa;
import com.br.lhmanager.main.LHManager;

/**
 * Classe que implementa a interface ICrudBase responsável por persistir uma
 * despesa na base de dados.
 * 
 * @author Márcio Ozório Teixeira
 * @since 04/05/2010.
 */
public class DespesaDAO implements ICrudBase {

	private EntityManager em = LHManager.em;
	private Despesa d = null;

	@Override
	public void alterar( Object obj ) throws SQLException {
		d = ( Despesa ) obj;
		em.getTransaction().begin();
		em.merge( d );
		em.getTransaction().commit();

	}

	@SuppressWarnings( "unchecked" )
	@Override
	public ArrayList consultar() throws SQLException {
		ArrayList<Despesa> lista = new ArrayList<Despesa>();
		Session session = ( Session ) em.getDelegate();
		Criteria criteria = session.createCriteria( Despesa.class );
		criteria.addOrder( Order.desc( "dataPagamento" ) );
		lista = ( ArrayList<Despesa> ) criteria.list();
		return lista;
	}

	@SuppressWarnings( "unchecked" )
	public ArrayList<Despesa> filtrar( String filtro ) throws SQLException {
		ArrayList<Despesa> lista = new ArrayList<Despesa>();
		Session session = ( Session ) em.getDelegate();
		Criteria criteria = session.createCriteria( Despesa.class );
		criteria.add( Restrictions.like( "descricao", /* "%" + */filtro + "%" ) );
		criteria.addOrder( Order.desc( "dataPagamento" ) );
		lista = ( ArrayList<Despesa> ) criteria.list();
		return lista;
	}

	@Override
	public Object findById( Object obj ) throws SQLException {
		d = ( Despesa ) obj;
		return em.find( Despesa.class, d.getCodigo() );
	}

	@Override
	public void excluir( Object obj ) throws SQLException {
		d = ( Despesa ) obj;
		d = ( Despesa ) findById( d );
		em.getTransaction().begin();
		em.remove( em.merge( d ) );
		em.getTransaction().commit();
	}

	@Override
	public void inserir( Object obj ) throws SQLException {
		d = ( Despesa ) obj;
		em.getTransaction().begin();
		em.persist( em.merge( d ) );
		em.getTransaction().commit();
	}

}
