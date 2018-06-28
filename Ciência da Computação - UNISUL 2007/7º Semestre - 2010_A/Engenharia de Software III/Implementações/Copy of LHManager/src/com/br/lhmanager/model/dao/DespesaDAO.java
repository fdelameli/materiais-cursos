//package com.br.lhmanager.model.dao;
//
//import java.sql.Connection;
//import java.sql.PreparedStatement;
//import java.sql.ResultSet;
//import java.sql.SQLException;
//import java.util.ArrayList;
//
//import com.br.lhmanager.controller.entitys.Despesa;
//import com.br.lhmanager.controller.entitys.TipoDespesa;
//import com.br.lhmanager.main.LHManager;
//
///**
// * Classe que implementa a interface ICrudBase respons�vel por persistir uma
// * despesa a base de dados.
// * 
// * @author M�rcio Oz�rio Teixeira
// * @since 04/05/2010.
// */
//public class DespesaDAO implements ICrudBase {
//
//	private Connection conn = LHManager.conn;
//	private Despesa d = null;
//
//	@Override
//	public void alterar( Object obj ) throws SQLException {
//		d = (Despesa ) obj;
//		String sql = "update despesa set ds_des=?, vl_des=?, dt_pagto=?, tp_des=? " +
//				"where cd_des=?";
//
//		PreparedStatement ps = conn.prepareStatement( sql );
//		ps.setString( 1, d.getDescricao() );
//		ps.setDouble( 2, d.getValor() );
//		ps.setString( 3, d.getDataPagametoMysql() );
//		ps.setInt( 4, d.getTipoDespesa().getCodigo() );
//		ps.setInt( 5, d.getCodigo() );
//
//		ps.executeUpdate();
//	}
//
//	@SuppressWarnings( "unchecked" )
//	@Override
//	public ArrayList consultar() throws SQLException {
//		ArrayList<Despesa> lista = new ArrayList<Despesa>();
//		String sql = "select * from despesa, tipo_despesa " +
//				"where tp_des = cd_tp_des";
//
//		PreparedStatement ps = conn.prepareStatement( sql );
//		ResultSet rs = ps.executeQuery();
//
//		while ( rs.next() ) {
//			lista.add( new Despesa(
//					rs.getInt( "cd_des" ),
//					rs.getString( "ds_des" ),
//					rs.getDouble( "vl_des" ),
//					rs.getString( "dt_pagto" ),
//					new TipoDespesa(
//							rs.getInt( "cd_tp_des" ),
//							rs.getString( "ds_tp_des" ) )
//					)
//			);
//		}
//
//		return lista;
//	}
//
//	@Override
//	public Object findById( Object obj ) throws SQLException {
//		d = (Despesa ) obj;
//		String sql = "select * from despesa, tipo_despesa " +
//				"where cd_des = ? " +
//				"and cd_tp_des = ? " +
//				"and tp_des = cd_tp_des";
//
//		PreparedStatement ps = conn.prepareStatement( sql );
//		ps.setInt( 1, d.getCodigo() );
//		ps.setInt( 2, d.getTipoDespesa().getCodigo() );
//
//		ResultSet rs = ps.executeQuery();
//
//		d = new Despesa(
//				rs.getInt( "cd_des" ),
//				rs.getString( "ds_des" ),
//				rs.getDouble( "vl_des" ),
//				rs.getString( "dt_pagto" ),
//				new TipoDespesa(
//						rs.getInt( "cd_tp_des" ),
//						rs.getString( "rs_tp_des" ) )
//				);
//
//		return d;
//	}
//
//	@Override
//	public void excluir( Object obj ) throws SQLException {
//		d = (Despesa ) obj;
//		String sql = "delete from despesa where cd_des = ?";
//
//		PreparedStatement ps = conn.prepareStatement( sql );
//		ps.setInt( 1, d.getCodigo() );
//
//		ps.executeUpdate();
//	}
//
//	@Override
//	public void inserir( Object obj ) throws SQLException {
//		d = (Despesa ) obj;
//		String sql = "insert into despesa" +
//				"(ds_des,vl_des,dt_pagto,tp_des)" +
//				"values(?,?,?,?)";
//
//		PreparedStatement ps = conn.prepareStatement( sql );
//		ps.setString( 1, d.getDescricao() );
//		ps.setDouble( 2, d.getValor() );
//		ps.setString( 3, d.getDataPagametoMysql() );
//		ps.setInt( 4, d.getTipoDespesa().getCodigo() );
//
//		ps.executeUpdate();
//	}
//
//}
