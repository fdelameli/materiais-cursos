package br.unisul.banco.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.unisul.banco.bean.ProdutoBean;
import br.unisul.banco.dao.connection.ConexaoJDBC;

public class ProdutoDao {
	
	public ProdutoBean buscarProdutoPorCodigo(Integer codigo) {
		
		String sql = "SELECT CODIGO, DESCRICAO, GENERO, VALOR " +
			"FROM PRODUTO WHERE CODIGO = ?";
		
		Connection con = ConexaoJDBC.getConnection();
		ProdutoBean produto = null;
		PreparedStatement stm = null;
		ResultSet rs = null;
		
		try {
			
			stm = con.prepareStatement(sql);
			stm.setInt(1, codigo);
			
			rs = stm.executeQuery();
			
			if (rs.next()) {
				produto = new ProdutoBean();
				produto.setCodigo(rs.getInt(1));
				produto.setDescricao(rs.getString(2));
				produto.setGenero(rs.getString(3));
				produto.setValor(rs.getDouble(4));
			}
			
		} catch (SQLException e) {
			System.err.println(e);
		} finally {
			
			try {
				rs.close();
				stm.close();
				con.close();
			} catch (SQLException e) {
				System.err.println("Não foi possível fechar as conexões!\n" + e);
			}
			
		}
		return produto;
	}

	
	public boolean insertProduto(ProdutoBean produto) {
		
		String sql = "INSERT INTO PRODUTO (CODIGO, DESCRICAO, " +
			"GENERO, VALOR) VALUES (?, ?, ?, ?)";
		
		Connection con = ConexaoJDBC.getConnection();
		boolean retorno = false;
		
		try {
			
			PreparedStatement stm = con.prepareStatement(sql);
			stm.setInt(1, produto.getCodigo());
			stm.setString(2, produto.getDescricao());
			stm.setString(3, produto.getGenero());
			stm.setDouble(4, produto.getValor());
			
			retorno = stm.execute();
			
			stm.close();
			con.close();
			
		} catch (SQLException e) {
			System.out.println(e);
		}
		
		return retorno;
		
	}
	

	public List<ProdutoBean> listarProdutos() {
		
		String sql = "SELECT CODIGO, DESCRICAO, GENERO, VALOR FROM PRODUTO";
		
		Connection con = ConexaoJDBC.getConnection();
		List<ProdutoBean> resultado = new ArrayList<ProdutoBean>();
		
		try {
			
			PreparedStatement stm = con.prepareStatement(sql);
			ResultSet rs = stm.executeQuery();
			
			while (rs.next()) {
				
				ProdutoBean produto = new ProdutoBean();
				produto.setCodigo(rs.getInt(1));
				produto.setDescricao(rs.getString(2));
				produto.setGenero(rs.getString(3));
				produto.setValor(rs.getDouble(4));
				
				resultado.add(produto);
			}
			
			stm.close();
			rs.close();
			con.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return resultado;
		
	}
	
	
	public void excluirProduto(Integer codigo) {
		
		String sql = "DELETE FROM PRODUTO WHERE CODIGO = ?";
		PreparedStatement stm = null;
		Connection con = null;
		
		try {
			
			con = ConexaoJDBC.getConnection();
			
			stm = con.prepareStatement(sql);
			stm.setInt(1, codigo);
			
			stm.execute();
		
		} catch (SQLException e) {
			System.err.println(e);
		} finally {
			
			try {
				stm.close();
				con.close();
			} catch (SQLException e) {
				System.err.println("Não foi possível fechar as conexões!" + e);
			}
			
		}
	}
	
	
}
