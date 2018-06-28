package br.unisul.banco.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.unisul.banco.LoggMac;
import br.unisul.banco.bean.ProdutoBean;
import br.unisul.banco.dao.connection.ConexaoJDBC;

public class ProdutoDao {

	public void insertProduto(ProdutoBean produto){
		
		String sql = "insert into produto (nome, " +
				"preco, tipo) values (?,?,?)";
		
		Connection con = ConexaoJDBC.getConnection();
		
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			
			ps.setString(1, produto.getNome());
			ps.setDouble(2, produto.getPreco());
			ps.setInt(3, produto.getTipo());
			LoggMac.logSql(ps.toString(), this.getClass().getName());
			ps.execute();
			
			ps.close();
			
			con.close();			
		} catch (SQLException e) {
			System.out.println(e);
		}			
		
	}
	
	public List<ProdutoBean> listarProduto(){
		
		String sql = "select codigo, nome, preco, " +
				" tipo from produto";
		
		//importar de java.sql
		Connection con = ConexaoJDBC.getConnection();
		
		List<ProdutoBean> resultado = new ArrayList<ProdutoBean>();
		
		try {
			PreparedStatement ps = con.prepareStatement(sql);
		
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()){
				ProdutoBean produto = new ProdutoBean();
				
				produto.setCodigo(rs.getInt(1));
				produto.setNome(rs.getString(2));
				produto.setPreco(rs.getDouble(3));
				produto.setTipo(rs.getInt(4));
				
				resultado.add(produto);				
			}		
			LoggMac.logSql(ps.toString(), this.getClass().getName());
			ps.close();
			rs.close();
			con.close();
		} catch (SQLException e) {
			System.out.println(e);
		} 
		
		return resultado;
	}
	
	
	public void excluirProduto(Integer codigo){
		
		String sql = "delete from produto where codigo = ?";
		
		Connection con = null;
		PreparedStatement ps = null;
		
		try {
		con = ConexaoJDBC.getConnection();
		
		ps = con.prepareStatement(sql);
				
		ps.setInt(1, codigo);
		LoggMac.logSql(ps.toString(), this.getClass().getName());
		ps.execute();	
				
		} catch (SQLException e) {
			System.out.println(e);
		} finally {
			try {
				ps.close();
				con.close();
			} catch (SQLException e) {
				System.out.println("Nao consegui fechar a conexao!" + e);
			}
		}
	}
	
	public ProdutoBean buscarProdutoPorCodigo(Integer codigo){
		
		String sql = "select codigo, nome, preco, tipo " +
				"from produto where codigo = ?";
		
		ProdutoBean produto = null;
		
		try {
			Connection con = ConexaoJDBC.getConnection();
	
			PreparedStatement ps = con.prepareStatement(sql);
		
			ps.setInt(1, codigo);
			
			ResultSet rs = ps.executeQuery();
			
			if(rs.next()){
				produto = new ProdutoBean();
				produto.setCodigo(rs.getInt(1));
				produto.setNome(rs.getString(2));
				produto.setPreco(rs.getDouble(3));
				produto.setTipo(rs.getInt(4));				
			}
			LoggMac.logSql(ps.toString(), this.getClass().getName());
			rs.close();
			ps.close();
			con.close();			
			
		} catch (SQLException e) {
			System.out.println(e);
		}
		
		return produto;
		
	}

	public void alterarProduto(ProdutoBean produto){
		
		String sql = "update produto set nome = ?, preco = ?, " +
				"tipo = ? where codigo = ? ";
		
		try {
			Connection con = ConexaoJDBC.getConnection();
		
			PreparedStatement ps = con.prepareStatement(sql);
			
			ps.setString(1, produto.getNome());
			ps.setDouble(2, produto.getPreco());
			ps.setInt(3, produto.getTipo());
			ps.setInt(4, produto.getCodigo());
			LoggMac.logSql(ps.toString(), this.getClass().getName());
			ps.execute();
			
			ps.close();
			con.close();
			
		} catch (SQLException e) {
			System.out.println(e);
		}		
	}
	
	public List<ProdutoBean> pesquisarProduto(ProdutoBean produto){
		
		StringBuffer sql = new StringBuffer();
		sql.append("select * from produto ");
				 
		boolean andString = false;
		
		if(produto.getCodigo() != -1){
			if(!andString){
				sql.append("where ");
				andString = true;
			}else
				sql.append("and ");
			//CUIDADO
			sql.append("codigo = " + produto.getCodigo() + " " );
		}
		
		if(!produto.getNome().equals("")){
			if(!andString){
				sql.append("where ");
				andString = true;
			}else
				sql.append("and ");
			
			sql.append("upper(nome) like '%"+ produto.getNome().toUpperCase() + "%' ");
		}
		
		if(produto.getPreco() != -1.0){
			if(!andString){
				sql.append("where ");
				andString = true;
			}else
				sql.append("and ");
			
			sql.append("preco = " + produto.getPreco()+" ");
		}
		
		
		String sqlString = sql.toString();
						
		try {
			Connection con = ConexaoJDBC.getConnection();
						
			PreparedStatement ps = con.prepareStatement(sqlString);
			LoggMac.logSql(ps.toString(), this.getClass().getName());
			ResultSet rs = ps.executeQuery();
			
			List<ProdutoBean> listProduto = new ArrayList<ProdutoBean>();
			
			while(rs.next()){
				ProdutoBean produtoBean = new ProdutoBean();
				produtoBean.setCodigo(rs.getInt("codigo"));
				produtoBean.setNome(rs.getString("nome"));
				produtoBean.setPreco(rs.getDouble("preco"));
				produtoBean.setTipo(rs.getInt("tipo"));
				
				listProduto.add(produtoBean);
			}
		
			rs.close();
			ps.close();
			con.close();
			
			return listProduto;		
		} catch (SQLException e) {
			System.out.println(e);
		}
				
		return null;
	}
	
}








