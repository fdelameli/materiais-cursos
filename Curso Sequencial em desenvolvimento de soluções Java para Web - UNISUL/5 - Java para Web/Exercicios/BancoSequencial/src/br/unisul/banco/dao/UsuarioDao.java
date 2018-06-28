package br.unisul.banco.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.unisul.banco.bean.UsuarioBean;
import br.unisul.banco.dao.connection.ConexaoJDBC;

public class UsuarioDao {
	
	
	
	public UsuarioBean verificaAuth(UsuarioBean usuario) {
		
		String sql = "SELECT * FROM USUARIO WHERE LOGIN = ? AND SENHA = ?";
		Connection con = ConexaoJDBC.getConnection();
		PreparedStatement stm = null;
		
		try {
			
			stm = con.prepareStatement(sql);
			stm.setString(1, usuario.getLogin());
			stm.setString(2, usuario.getSenha());
			
			ResultSet rs = stm.executeQuery();
			
			if (rs.next()) {
				UsuarioBean usuarioResult = new UsuarioBean();
				usuarioResult.setCodigo(rs.getInt("CODIGO"));
				usuarioResult.setNome(rs.getString("NOME"));
				usuarioResult.setLogin(rs.getString("LOGIN"));
//				usuarioResult.setSenha(rs.getString("SENHA"));
				usuarioResult.setEmail(rs.getString("EMAIL"));
				usuarioResult.setTipo(rs.getInt("TIPO"));
		
				return usuarioResult;
			}
			
		} catch (SQLException e) {
			System.out.println(e);
		} finally {
			try {
				stm.close();
				con.close();
			} catch (SQLException e) {
				System.out.println(e);
			}
		}
		return null;
	}
	
	
	/**
	 * Efetua uma pesquisa por usuário utilizando filtros.
	 * @param usuario
	 * @return
	 */
	public List<UsuarioBean> pesquisarUsuario(UsuarioBean usuario) {
		
		StringBuffer sql = new StringBuffer("SELECT * FROM USUARIO ");
		
		boolean andString = false;
		
		if (usuario.getCodigo() != -1) {
			if (!andString) {
				sql.append("WHERE ");
				andString = true;
			} else {
				sql.append("AND ");
			}
			sql.append("CODIGO = " + usuario.getCodigo() + " "); //cuidado com sql injection
		}
		
		if (!usuario.getNome().equals("")) {
			if (!andString) {
				sql.append("WHERE ");
				andString = true;
			} else {
				sql.append("AND ");
			}
			sql.append("UPPER(NOME) LIKE '%" + usuario.getNome().toUpperCase() + "%' ");
		}
		
		if (!usuario.getLogin().equals("")) {
			if (!andString) {
				sql.append("WHERE ");
				andString = true;
			} else {
				sql.append("AND ");
			}
			sql.append("UPPER(LOGIN) LIKE '%" + usuario.getLogin().toUpperCase() + "%' ");
		}
		
		if (!usuario.getEmail().equals("")) {
			if (!andString) {
				sql.append("WHERE ");
				andString = true;
			} else {
				sql.append("AND ");
			}
			sql.append("UPPER(EMAIL) LIKE '%" + usuario.getEmail().toUpperCase() + "%' ");
		}

		String sqlString = sql.toString();
		Connection con = ConexaoJDBC.getConnection();
		List<UsuarioBean> lista = null;
		PreparedStatement stm = null;
		ResultSet rs = null;
		
		try {
			
			stm = con.prepareStatement(sqlString);
			rs = stm.executeQuery();
			
			lista = new ArrayList<UsuarioBean>();
			
			while (rs.next()) {
				UsuarioBean resultUsuario = new UsuarioBean();
				resultUsuario.setCodigo(rs.getInt("codigo"));
				resultUsuario.setNome(rs.getString("nome"));
				resultUsuario.setLogin(rs.getString("login"));
				resultUsuario.setSenha(rs.getString("senha"));
				resultUsuario.setEmail(rs.getString("email"));
				resultUsuario.setTipo(rs.getInt("tipo"));
			
				lista.add(resultUsuario);
			}
			
			return lista;
			
		} catch (SQLException e) {
			System.err.println(e);
		} finally {
			
			try {
				rs.close();
				stm.close();
				con.close();
			} catch (SQLException e) {
				System.err.println("Erro ao fechar conexões!\n" + e);
			}
			
		}
		return lista;
	}
	
	
	
	
	public void alterarUsuario(UsuarioBean usuario) {
		
		String sql = "UPDATE USUARIO SET NOME = ?, LOGIN = ?, SENHA = ?, " +
			"EMAIL = ?, TIPO = ? WHERE CODIGO = ? ";
		
		Connection con = ConexaoJDBC.getConnection();
		PreparedStatement stm = null;
		
		try {
			
			stm = con.prepareStatement(sql);
			stm.setString(1, usuario.getNome());
			stm.setString(2, usuario.getLogin());
			stm.setString(3, usuario.getSenha());
			stm.setString(4, usuario.getEmail());
			stm.setInt(5, usuario.getTipo());
			stm.setInt(6, usuario.getCodigo());
			
			stm.execute();
			
		} catch (SQLException e) {
			System.err.println(e);
		} finally {
			
			try {
				stm.close();
				con.close();
			} catch (SQLException e) {
				System.err.println("Não foi possível fechar as conexões!\n" + e);
			}
		}
	}
	
	
	
	public UsuarioBean buscarUsuarioPorCodigo(Integer codigo) {
		
		String sql = "SELECT CODIGO, NOME, LOGIN, SENHA, EMAIL, TIPO " +
			"FROM USUARIO WHERE CODIGO = ?";
		
		Connection con = ConexaoJDBC.getConnection();
		PreparedStatement stm = null;
		UsuarioBean usuario = null;
		ResultSet rs = null;
		
		try {
			
			stm = con.prepareStatement(sql);
			stm.setInt(1, codigo);
			
			rs = stm.executeQuery();
			
			if (rs.next()) {
				usuario = new UsuarioBean();
				usuario.setCodigo(rs.getInt(1));
				usuario.setNome(rs.getString(2));
				usuario.setLogin(rs.getString(3));
				usuario.setSenha(rs.getString(4));
				usuario.setEmail(rs.getString(5));
				usuario.setTipo(rs.getInt(6));
			}
			
		} catch (SQLException e) {
			System.err.println(e);
		} finally {
			
			try {
				rs.close();
				stm.close();
				con.close();
			} catch (SQLException e) {
				System.err.println("Não foi possível fechar as conexões!" + e);
			}
			
		}
		return usuario;
	}
	
	
	public boolean insertUsuario(UsuarioBean usuario) {
		
		String sql = "INSERT INTO USUARIO (CODIGO, NOME, LOGIN, " +
			"SENHA, EMAIL, TIPO) VALUES (?, ?, ?, ?, ?, ?)";
		
		Connection con = ConexaoJDBC.getConnection();
		PreparedStatement stm = null;
		boolean retorno = false;
		
		try {
			
			stm = con.prepareStatement(sql);
			stm.setInt(1, usuario.getCodigo());
			stm.setString(2, usuario.getNome());
			stm.setString(3, usuario.getLogin());
			stm.setString(4, usuario.getSenha());
			stm.setString(5, usuario.getEmail());
			stm.setInt(6, usuario.getTipo());
			
			retorno = stm.execute();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			
			try {
				stm.close();
				con.close();
			} catch (SQLException e) {
				System.err.println("Não foi possível fechar as conexões!\n" + e);
			}
			
		}
		
		return retorno;
		
	}
	
	
	public List<UsuarioBean> listarUsuarios() {
		
		String sql = "SELECT CODIGO, NOME, LOGIN, SENHA, EMAIL, TIPO " +
			"FROM USUARIO ORDER BY (CODIGO)";
		
		Connection con = ConexaoJDBC.getConnection();
		List<UsuarioBean> resultado = new ArrayList<UsuarioBean>();
		
		try {
			
			PreparedStatement stm = con.prepareStatement(sql);
			ResultSet rs = stm.executeQuery();
			
			while (rs.next()) {
				
				UsuarioBean usuario = new UsuarioBean();
				usuario.setCodigo(rs.getInt(1));
				usuario.setNome(rs.getString(2));
				usuario.setLogin(rs.getString(3));
				usuario.setSenha(rs.getString(4));
				usuario.setEmail(rs.getString(5));
				usuario.setTipo(rs.getInt(6));
				
				resultado.add(usuario);
			}
			
			stm.close();
			rs.close();
			con.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return resultado;
		
	}
	
	
	
	public void excluir(Integer codigo) {
		
		String sql = "DELETE FROM USUARIO WHERE CODIGO = ?";
		Connection con = ConexaoJDBC.getConnection();;
		PreparedStatement stm = null;
		
		
		try {
			
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
				System.err.println("Não foi possível fechar a conexão!\n" + e);
			}
			
		}
	}
	
	
	
}
