package br.unisul.transportadora.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.unisul.transportadora.bean.TransportadoraBean;
import br.unisul.transportadora.dao.connection.ConexaoJDBC;

/**
 * Classe Java que efetua as operações no banco
 * de dados para a entidade Transportadora.
 * @author Fabio Dela Bruna
 */
public class TransportadoraDao {

	/**
	 * Método que retorna o maior valor no campo código da tabela.
	 * @return Maior Código se houver algum registro na table, caso contrário, 0.
	 */
	public Integer getMaxValueFromCodigo() {
		
		String sql = "SELECT MAX(CD_TRANSP) FROM TRANSPORTADORA";
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
	 * Método que busca uma transportadora pelo código.
	 * @param codigo Código da transportadora.
	 * @return Objeto do tipo TransportadoraBean, ou null.
	 */
	public TransportadoraBean findById (Integer codigo) {
		
		String sql = "SELECT CD_TRANSP, NM_TRANSP FROM TRANSPORTADORA WHERE CD_TRANSP = ?";
		Connection con = ConexaoJDBC.getConnection();
		PreparedStatement ps = null;
		ResultSet rs = null;
		TransportadoraBean transp = null;
		
		try {
			
			ps = con.prepareStatement(sql);
			ps.setInt(1, codigo);
			
			rs = ps.executeQuery();
			
			if (rs.next()) {
				transp = new TransportadoraBean();
				transp.setCodigo( rs.getInt(1) );
				transp.setNome( rs.getString(2) );
			}
			return transp;
		
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
		return transp;
	}
	
	
	/**
	 * Método que insere o registro de uma transportadora no banco.
	 * @param transp Objeto do tipo TransportadoraBean a ser inserido.
	 * @return True se inserido com sucesso, caso contrário, False.
	 */
	public boolean insertTransportadora(TransportadoraBean transp) {
		
		String sql = "INSERT INTO TRANSPORTADORA (CD_TRANSP, NM_TRANSP) VALUES (?, ?)";
		Connection con = ConexaoJDBC.getConnection();
		PreparedStatement ps = null;
		boolean retorno = false;
		
		try {
			
			ps = con.prepareStatement(sql);
			ps.setInt(1, transp.getCodigo());
			ps.setString(2, transp.getNome());
			
			retorno = ps.execute();
			
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
		return retorno;
	}
	
	
	/**
	 * Método que atualiza um determinado registro no banco.
	 * @param transp Objeto do tipo TransportadoraBean atualizado.
	 * @return True se atualizado com sucesso, caso contrário, False.
	 */
	public boolean updateTransportadora(TransportadoraBean transp) {
		
		String sql = "UPDATE TRANSPORTADORA SET NM_TRANSP = ? WHERE CD_TRANSP = ?";
		Connection con = ConexaoJDBC.getConnection();
		PreparedStatement ps = null;
		boolean retorno = false;
		
		try {
			
			ps = con.prepareStatement(sql);
			ps.setString(1, transp.getNome());
			ps.setInt(2, transp.getCodigo());
			
			retorno = ps.execute();
			
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
		return retorno;
	}
	

	/**
	 * Método que apaga um registro do banco atravéz do código (PK);
	 * @param codigo Código do registro a ser excluído.
	 * @return True se excluído com sucesso, caso contrário, False.
	 */
	public boolean deleteTransportadora(Integer codigo) throws SQLException {
		
		String sql = "DELETE FROM TRANSPORTADORA WHERE CD_TRANSP = ?";
		Connection con = ConexaoJDBC.getConnection();
		PreparedStatement ps = null;
		boolean retorno = false;
		
		try {
			
			ps = con.prepareStatement(sql);
			ps.setInt(1, codigo);
			
			retorno = ps.execute();
			
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
		return retorno;
	}
	
	
	/**
	 * Método que retorna uma lista contendo todos os registros no banco.
	 * @return Lista com todos os registros de transportadoras.
	 */
	public List<TransportadoraBean> findAllTransportadora() {
		
		String sql = "SELECT CD_TRANSP, NM_TRANSP FROM TRANSPORTADORA ORDER BY (NM_TRANSP)";
		Connection con = ConexaoJDBC.getConnection();
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<TransportadoraBean> lista = new ArrayList<TransportadoraBean>();
		
		try {
			
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			
			while (rs.next()) {
				
				TransportadoraBean transp = new TransportadoraBean();
				transp.setCodigo( rs.getInt(1) );
				transp.setNome( rs.getString(2) );
				
				lista.add(transp);
				
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
