package com.br.lhmanager.model.dao;

import java.sql.SQLException;
import java.util.ArrayList;

import javax.persistence.EntityManager;

import org.hibernate.Criteria;
import org.hibernate.Session;

import com.br.lhmanager.controller.entitys.TipoDespesa;
import com.br.lhmanager.main.LHManager;

/**
 * Classe que implementa a interface ICrudBase responsável por persistir um tipo
 * de despesa a base de dados.
 * 
 * @author Márcio Ozório Teixeira
 * @since 04/05/2010.
 */
public class TipoDespesaDAO implements ICrudBase {

	EntityManager em = LHManager.em;
	TipoDespesa tp = null;


	@Override
	public void alterar( Object obj ) {

	}

	@SuppressWarnings( "unchecked" )
	@Override
	public ArrayList consultar() throws SQLException {
		ArrayList<TipoDespesa> lista = new ArrayList<TipoDespesa>();
		Session session = ( Session ) em.getDelegate();
		Criteria criteria = session.createCriteria( TipoDespesa.class );
//		criteria.addOrder( Order.asc( "ds_tp_des" ) );
		lista = ( ArrayList<TipoDespesa> ) criteria.list();
		return lista;
	}

	@Override
	public Object findById( Object obj ) throws SQLException {
		tp = ( TipoDespesa ) obj;
		return em.find( TipoDespesa.class, tp.getCodigo() );
	}

	@Override
	public void excluir( Object obj ) {

	}

	@Override
	public void inserir( Object obj ) {

	}

}
