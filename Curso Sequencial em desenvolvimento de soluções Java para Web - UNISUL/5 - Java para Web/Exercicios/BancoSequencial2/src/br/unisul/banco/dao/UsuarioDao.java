package br.unisul.banco.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.unisul.banco.LoggMac;
import br.unisul.banco.bean.UsuarioBean;
import br.unisul.banco.dao.connection.ConexaoJDBC;

public class UsuarioDao {

	public void insertUsuario(UsuarioBean usuario){
		
		String sql = "insert into usuario (nome, " +
				"login, senha, email, tipo) values (?,?,?,?,?)";
		
		Connection con = ConexaoJDBC.getConnection();
		
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			
			ps.setString(1, usuario.getNome());
			ps.setString(2, usuario.getLogin());
			ps.setString(3, usuario.getSenha());
			ps.setString(4, usuario.getEmail());
			ps.setInt(5, usuario.getTipo());
			
			
			LoggMac.logSql(ps.toString(), this.getClass().getName());
			
			
			ps.execute();
			ps.close();
			con.close();			
		} catch (SQLException e) {
			System.out.println(e);
		}			
		
	}
	
	public List<UsuarioBean> listarUsuario(){
		
		String sql = "select codigo, nome, login, senha, " +
				"email, tipo from usuario";
		
		//importar de java.sql
		Connection con = ConexaoJDBC.getConnection();
		
		List<UsuarioBean> resultado = new ArrayList<UsuarioBean>();
		
		try {
			PreparedStatement ps = con.prepareStatement(sql);
		
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()){
				UsuarioBean usuario = new UsuarioBean();
				
				usuario.setCodigo(rs.getInt(1));
				usuario.setNome(rs.getString(2));
				usuario.setLogin(rs.getString(3));
				usuario.setSenha(rs.getString(4));
				usuario.setEmail(rs.getString(5));
				usuario.setTipo(rs.getInt(6));
				
				resultado.add(usuario);				
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
	
	
	public void excluirUsuario(Integer codigo){
		
		String sql = "delete from usuario where codigo = ?";
		
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
	
	public UsuarioBean buscarUsuarioPorCodigo(Integer codigo){
		
		String sql = "select codigo, nome, login, senha, email, tipo " +
				"from usuario where codigo = ?";
		
		UsuarioBean usuario = null;
		
		try {
			Connection con = ConexaoJDBC.getConnection();
	
			PreparedStatement ps = con.prepareStatement(sql);
		
			ps.setInt(1, codigo);
			
			ResultSet rs = ps.executeQuery();
			
			if(rs.next()){
				usuario = new UsuarioBean();
				usuario.setCodigo(rs.getInt(1));
				usuario.setNome(rs.getString(2));
				usuario.setLogin(rs.getString(3));
				usuario.setSenha(rs.getString(4));
				usuario.setEmail(rs.getString(5));
				usuario.setTipo(rs.getInt(6));				
			}
			LoggMac.logSql(ps.toString(), this.getClass().getName());
			rs.close();
			ps.close();
			con.close();			
			
		} catch (SQLException e) {
			System.out.println(e);
		}
		
		return usuario;
		
	}

	public void alterarUsuario(UsuarioBean usuario){
		
		String sql = "update usuario set nome = ?, login = ?, " +
				"senha = ?, email = ?, tipo = ? " + 
				" where codigo = ? ";
		
		try {
			Connection con = ConexaoJDBC.getConnection();
		
			PreparedStatement ps = con.prepareStatement(sql);
			
			ps.setString(1, usuario.getNome());
			ps.setString(2, usuario.getLogin());
			ps.setString(3, usuario.getSenha());
			ps.setString(4, usuario.getEmail());
			ps.setInt(5, usuario.getTipo());
			ps.setInt(6, usuario.getCodigo());
			LoggMac.logSql(ps.toString(), this.getClass().getName());
			ps.execute();
			
			ps.close();
			con.close();
			
		} catch (SQLException e) {
			System.out.println(e);
		}		
	}
	
	public List<UsuarioBean> pesquisarUsuario(UsuarioBean usuario){
		
		StringBuffer sql = new StringBuffer();
		sql.append("select * from usuario ");
				 
		boolean andString = false;
		
		if(usuario.getCodigo() != -1){
			if(!andString){
				sql.append("where ");
				andString = true;
			}else
				sql.append("and ");
			//CUIDADO
			sql.append("codigo = " + usuario.getCodigo() + " " );
		}
		
		if(!usuario.getNome().equals("")){
			if(!andString){
				sql.append("where ");
				andString = true;
			}else
				sql.append("and ");
			
			sql.append("upper(nome) like '%"+ usuario.getNome().toUpperCase() + "%' ");
		}
		
		if(!usuario.getLogin().equals("")){
			if(!andString){
				sql.append("where ");
				andString = true;
			}else
				sql.append("and ");
			
			sql.append("upper(login) like '%" + usuario.getLogin().toUpperCase() + 
					"%' ");
		}
		
		if(!usuario.getEmail().equals("")){
			if(!andString){
				sql.append("where ");
				andString = true;
			}else
				sql.append("and ");
			
			sql.append("upper(email) like '%" + usuario.getEmail().toUpperCase() +
					"%' ");
		}
		
		String sqlString = sql.toString();
						
		try {
			Connection con = ConexaoJDBC.getConnection();
						
			PreparedStatement ps = con.prepareStatement(sqlString);
			LoggMac.logSql(ps.toString(), this.getClass().getName());
			ResultSet rs = ps.executeQuery();
			
			List<UsuarioBean> listUsuario = new ArrayList<UsuarioBean>();
			
			while(rs.next()){
				UsuarioBean resultUsuario = new UsuarioBean();
				resultUsuario.setCodigo(rs.getInt("codigo"));
				resultUsuario.setNome(rs.getString("nome"));
				resultUsuario.setLogin(rs.getString("login"));
				resultUsuario.setSenha(rs.getString("senha"));
				resultUsuario.setEmail(rs.getString("email"));
				resultUsuario.setTipo(rs.getInt("tipo"));
				
				listUsuario.add(resultUsuario);
			}
			
			rs.close();
			ps.close();
			con.close();
			
			return listUsuario;		
		} catch (SQLException e) {
			System.out.println(e);
		}
				
		return null;
	}
	
	public UsuarioBean verificaAuth(UsuarioBean usuario){
		String sql = "select * from usuario where login = ? and senha = ?";
		
		try{
		Connection con = ConexaoJDBC.getConnection();
		
		PreparedStatement ps = con.prepareStatement(sql);
		
		ps.setString(1, usuario.getLogin());
		ps.setString(2, usuario.getSenha());
		
		ResultSet rs = ps.executeQuery();
		
		if(rs.next()){
			UsuarioBean u = new UsuarioBean();
			u.setCodigo(rs.getInt("codigo"));
			u.setNome(rs.getString("nome"));
			u.setLogin(rs.getString("login"));
			u.setEmail(rs.getString("email"));
			u.setTipo(rs.getInt("tipo"));
			
			return u;
		}
		rs.close();
		ps.close();
		con.close();
		
		}catch(SQLException s){
			s.printStackTrace();
		}
		return null;
	}
	
}








