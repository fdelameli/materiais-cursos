package br.unisul.transportadora.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.unisul.transportadora.bean.UsuarioBean;
import br.unisul.transportadora.dao.connection.ConexaoJDBC;

/**
 * Classe Java que efetua as operações no banco
 * de dados para a entidade UsuarioBean.
 * @author Fabio Dela Bruna
 */
public class UsuarioDao {

	/**
	 * Método que retorna o maior valor no campo código da tabela.
	 * @return Maior Código se houver algum registro na table, caso contrário, 0.
	 */
	public Integer getMaxValueFromCodigo() {
		
		String sql = "SELECT MAX(CD_USER) FROM USUARIO";
		Connection con = ConexaoJDBC.getConnection();
		PreparedStatement ps = null;
		ResultSet rs = null;
		Integer codigo = null;
		
		try {
			
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			
			while (rs.next()) {
				codigo = rs.getInt(1);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			
			try {
				rs.close();
				ps.close();
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
		}
		return codigo;
	}
	
	
	/**
	 * Método que retorna todos os usuários de acordo com o tipo.
	 * @param tipo Tipo do usuário: 1 - cliente | 2 - administrador.
	 * @return Lista de usuários encontrados.
	 */
	public List<UsuarioBean> findAllById(Integer tipo) {
		
		String sql = "SELECT CD_USER, NM_USER, EMAIL_USER, SENHA_USER, ENDERECO_USER, " +
		"CIDADE_USER, UF_USER, TIPO_USER FROM USUARIO WHERE TIPO_USER = ? ORDER BY(CD_USER)";
		
		Connection con = ConexaoJDBC.getConnection();
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<UsuarioBean> lista = new ArrayList<UsuarioBean>();
		
		try {
			
			ps = con.prepareStatement(sql);
			ps.setInt(1, tipo);
			
			rs = ps.executeQuery();
			
			while (rs.next()) {
				UsuarioBean usuario = new UsuarioBean();
				usuario = new UsuarioBean();
				usuario.setCodigo( rs.getInt(1) );
				usuario.setNome( rs.getString(2) );
				usuario.setEmail( rs.getString(3) );
				usuario.setSenha( rs.getString(4) );
				usuario.setEndereco( rs.getString(5) );
				usuario.setCidade( rs.getString(6) );
				usuario.setUf( rs.getString(7) );
				usuario.setTipo( rs.getInt(8) );
				
				lista.add(usuario);
			}
			return lista;
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			
			try {
				rs.close();
				ps.close();
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return lista;
	}
	
	
	/**
	 * Método que busca um usuário pelo código.
	 * @param codigo Código do usuário.
	 * @return Objeto do tipo UsuarioBean, ou null.
	 */
	public UsuarioBean findById(Integer codigo) {
		
		String sql = "SELECT CD_USER, NM_USER, EMAIL_USER, SENHA_USER, ENDERECO_USER, " +
		"CIDADE_USER, UF_USER, TIPO_USER FROM USUARIO WHERE CD_USER = ? ORDER BY(CD_USER)";
		
		Connection con = ConexaoJDBC.getConnection();
		PreparedStatement ps = null;
		ResultSet rs = null;
		UsuarioBean usuario = null;
		
		try {
			
			ps = con.prepareStatement(sql);
			ps.setInt(1, codigo);
			
			rs = ps.executeQuery();
			
			if (rs.next()) {
				usuario = new UsuarioBean();
				usuario.setCodigo( rs.getInt(1) );
				usuario.setNome( rs.getString(2) );
				usuario.setEmail( rs.getString(3) );
				usuario.setSenha( rs.getString(4) );
				usuario.setEndereco( rs.getString(5) );
				usuario.setCidade( rs.getString(6) );
				usuario.setUf( rs.getString(7) );
				usuario.setTipo( rs.getInt(8) );
			}
			return usuario;

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			
			try {
				rs.close();
				ps.close();
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return usuario;
	}
	
	
	/**
	 * Método que busca um usuário de acordo com seu email
	 * e senha que são usados para acessar a área restrita do site.
	 * @param email Login utilizado pelo usuário para logar no site.
	 * @param senha Senha do usuário.
	 * @return Objeto do tipo UsuarioBean se encontrado, ou null.
	 */
	public UsuarioBean findByEmailSenha(String email, String senha) {
		
		String sql = "SELECT * FROM USUARIO WHERE EMAIL_USER = ? AND SENHA_USER = ?";
		
		Connection con = ConexaoJDBC.getConnection();
		PreparedStatement ps = null;
		ResultSet rs = null;
		UsuarioBean usuario = null;
		
		try {
			
			ps = con.prepareStatement(sql);
			ps.setString(1, email);
			ps.setString(2, senha);
			
			rs = ps.executeQuery();
			
			if (rs.next()) {
				usuario = new UsuarioBean();
				usuario.setCodigo( rs.getInt("CD_USER") );
				usuario.setNome( rs.getString("NM_USER") );
				usuario.setEmail( rs.getString("EMAIL_USER") );
				usuario.setSenha( rs.getString("SENHA_USER") );
				usuario.setEndereco( rs.getString("ENDERECO_USER") );
				usuario.setCidade( rs.getString("CIDADE_USER") );
				usuario.setUf( rs.getString("UF_USER") );
				usuario.setTipo( rs.getInt("TIPO_USER") );
				
				return usuario;
			} else {
				System.out.println("Não achou!");
			}
		
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			
			try {
				rs.close();
				ps.close();
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
		}
		return usuario;
	}
	
	
	/**
	 * Método que insere o registro de um usuario no banco.
	 * @param user Objeto do tipo UsuarioBean a ser inserido.
	 */
	public void insertUsuario(UsuarioBean user) {
		
		String sql = "INSERT INTO USUARIO (CD_USER, NM_USER, EMAIL_USER, SENHA_USER, ENDERECO_USER, " +
				"CIDADE_USER, UF_USER, TIPO_USER) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
		Connection con = ConexaoJDBC.getConnection();
		PreparedStatement ps = null;
		
		try {
			
			ps = con.prepareStatement(sql);
			ps.setInt(1, user.getCodigo());
			ps.setString(2, user.getNome());
			ps.setString(3, user.getEmail());
			ps.setString(4, user.getSenha());
			ps.setString(5, user.getEndereco());
			ps.setString(6, user.getCidade());
			ps.setString(7, user.getUf());
			ps.setInt(8, user.getTipo());
			
			ps.execute();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			
			try {
				ps.close();
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
		}
	}
	
	
	/**
	 * Método que atualiza um determinado registro no banco.
	 * @param user Objeto do tipo UsuarioBean atualizado.
	 */
	public void updateUsuario(UsuarioBean user) {
		
		String sql = "UPDATE USUARIO SET NM_USER = ?, EMAIL_USER = ?, SENHA_USER = ?, " +
				"ENDERECO_USER = ?, CIDADE_USER = ?, UF_USER = ?, TIPO_USER = ? WHERE CD_USER = ?";
		Connection con = ConexaoJDBC.getConnection();
		PreparedStatement ps = null;
		
		try {
			
			ps = con.prepareStatement(sql);
			ps.setString(1, user.getNome());
			ps.setString(2, user.getEmail());
			ps.setString(3, user.getSenha());
			ps.setString(4, user.getEndereco());
			ps.setString(5, user.getCidade());
			ps.setString(6, user.getUf());
			ps.setInt(7, user.getTipo());
			ps.setInt(8, user.getCodigo());
			
			ps.execute();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			
			try {
				ps.close();
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
		}
	}
	

	/**
	 * Método que apaga um registro do banco atravéz do código (PK);
	 * @param codigo Código do registro a ser excluído.
	 */
	public void deleteUsuario(Integer codigo) throws SQLException {
		
		String sql = "DELETE FROM USUARIO WHERE CD_USER = ?";
		Connection con = ConexaoJDBC.getConnection();
		PreparedStatement ps = null;

		try {

			ps = con.prepareStatement(sql);
			ps.setInt(1, codigo);

			ps.execute();

		} catch (SQLException e) {
			throw new SQLException(e);
		} finally {
			try {
				ps.close();
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	
	/**
	 * Método que retorna uma lista contendo todos os registros no banco.
	 * @return Lista com todos os registros de usuarios.
	 */
	public List<UsuarioBean> findAllUsuario() {
		
		String sql = "SELECT CD_USER, NM_USER, EMAIL_USER, SENHA_USER, ENDERECO_USER, " +
				"CIDADE_USER, UF_USER, TIPO_USER FROM USUARIO ORDER BY (CD_USER)";
		Connection con = ConexaoJDBC.getConnection();
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<UsuarioBean> lista = new ArrayList<UsuarioBean>();
		
		try {
			
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			
			while (rs.next()) {
				
				UsuarioBean user = new UsuarioBean();
				user.setCodigo( rs.getInt(1) );
				user.setNome( rs.getString(2) );
				user.setEmail( rs.getString(3) );
				user.setSenha( rs.getString(4) );
				user.setEndereco( rs.getString(5) );
				user.setCidade( rs.getString(6) );
				user.setUf( rs.getString(7) );
				user.setTipo( rs.getInt(8) );
				
				lista.add(user);
				
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			
			try {
				rs.close();
				ps.close();
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
		}
		return lista;
	}
	
	
}
