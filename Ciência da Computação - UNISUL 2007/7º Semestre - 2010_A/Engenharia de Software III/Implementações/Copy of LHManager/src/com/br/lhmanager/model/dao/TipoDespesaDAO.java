//package com.br.lhmanager.model.dao;
//
//import java.sql.Connection;
//import java.sql.PreparedStatement;
//import java.sql.ResultSet;
//import java.sql.SQLException;
//import java.util.ArrayList;
//
//import com.br.lhmanager.controller.entitys.TipoDespesa;
//import com.br.lhmanager.main.LHManager;
//
///**
// * Classe que implementa a interface ICrudBase respons�vel por persistir um tipo
// * de despesa a base de dados.
// * 
// * @author M�rcio Oz�rio Teixeira
// * @since 04/05/2010.
// */
//public class TipoDespesaDAO implements ICrudBase {
//
////	Connection conn = LHManager.conn;
//	TipoDespesa tp = null;
//
//
//	@Override
//	public void alterar( Object obj ) {
//
//	}
//
//	@SuppressWarnings( "unchecked" )
//	@Override
//	public ArrayList consultar() throws SQLException {
//		ArrayList<TipoDespesa> lista = new ArrayList<TipoDespesa>();
//		String sql = "select * from tipo_despesa order by ds_tp_des";
//
//		PreparedStatement ps = conn.prepareStatement( sql );
//		ResultSet rs = ps.executeQuery();
//
//		while ( rs.next() ) {
//			lista.add( new TipoDespesa( rs.getInt( "cd_tp_des" ), rs.getString( "ds_tp_des" ) ) );
//		}
//
//		return lista;
//	}
//
//	@Override
//	public Object findById( Object obj ) throws SQLException {
//		tp = (TipoDespesa ) obj;
//		String sql = "select * from tipo_despesa where cd_tp_des = ?";
//
//		PreparedStatement ps = conn.prepareStatement( sql );
//		ps.setInt( 1, tp.getCodigo() );
//		ResultSet rs = ps.executeQuery();
//
//		while ( rs.next() ) {
//			tp = new TipoDespesa( rs.getInt( "cd_tp_des" ), rs.getString( "ds_tp_des" ) );
//			return tp;
//		}
//		
//		return tp;
//	}
//
//	@Override
//	public void excluir( Object obj ) {
//
//	}
//
//	@Override
//	public void inserir( Object obj ) {
//
//	}
//
//}
