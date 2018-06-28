package br.unisul.transportadora.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.unisul.transportadora.bean.CaminhaoBean;
import br.unisul.transportadora.dao.connection.ConexaoJDBC;

/**
 * Classe Java que efetua as operações no banco
 * de dados para a entidade Caminhao.
 * @author Fabio Dela Bruna
 */
public class CaminhaoDao {

	/**
	 * Método que retorna o maior valor no campo código da tabela.
	 * @return Maior Código se houver algum registro na table, caso contrário, 0.
	 */
	public Integer getMaxValueFromCodigo() {
		
		String sql = "SELECT MAX(CD_CAM) FROM CAMINHAO";
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
	 * Método que retorna um objeto do tipo CaminhãoBean atravéz do código.
	 * @param codigo Código do caminhão a ser buscado.
	 * @return Objeto do tipo CaminhaoBean se encontrado, ou null.
	 */
	public CaminhaoBean findById (Integer codigo) {
		
		String sql = "SELECT CD_CAM, DS_CAM FROM CAMINHAO WHERE CD_CAM = ?";
		Connection con = ConexaoJDBC.getConnection();
		PreparedStatement ps = null;
		ResultSet rs = null;
		CaminhaoBean cam = null;
		
		try {
			
			ps = con.prepareStatement(sql);
			ps.setInt(1, codigo);
			
			rs = ps.executeQuery();
			
			if (rs.next()) {
				cam = new CaminhaoBean();
				cam.setCodigo( rs.getInt(1) );
				cam.setDescricao( rs.getString(2) );
			}
			return cam;
			
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
		return cam;
	}
	
	
	/**
	 * Método que insere o registro de um caminhão no banco.
	 * @param cam Objeto do tipo CaminhaoBean a ser inserido.
	 * @return True se inserido com sucesso, caso contrário, False.
	 */
	public boolean insertCaminhao(CaminhaoBean cam) {
		
		String sql = "INSERT INTO CAMINHAO (CD_CAM, DS_CAM) VALUES (?, ?)";
		Connection con = ConexaoJDBC.getConnection();
		PreparedStatement ps = null;
		boolean retorno = false;
		
		try {
			
			ps = con.prepareStatement(sql);
			ps.setInt(1, cam.getCodigo());
			ps.setString(2, cam.getDescricao());
			
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
	 * @param cam Objeto do tipo CaminhaoBean atualizado.
	 * @return True se atualizado com sucesso, caso contrário, False.
	 */
	public boolean updateCaminhao(CaminhaoBean cam) {
		
		String sql = "UPDATE CAMINHAO SET DS_CAM = ? WHERE CD_CAM = ?";
		Connection con = ConexaoJDBC.getConnection();
		PreparedStatement ps = null;
		boolean retorno = false;
		
		try {
			
			ps = con.prepareStatement(sql);
			ps.setString(1, cam.getDescricao());
			ps.setInt(2, cam.getCodigo());
			
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
	public boolean deleteCaminhao(Integer codigo) throws SQLException {
		
		String sql = "DELETE FROM CAMINHAO WHERE CD_CAM = ?";
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
	 * @return Lista com todos os registros de caminhões.
	 */
	public List<CaminhaoBean> findAllCaminhao() {
		
		String sql = "SELECT CD_CAM, DS_CAM FROM CAMINHAO ORDER BY (DS_CAM)";
		Connection con = ConexaoJDBC.getConnection();
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<CaminhaoBean> lista = new ArrayList<CaminhaoBean>();
		
		try {
			
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			
			while (rs.next()) {
				
				CaminhaoBean cam = new CaminhaoBean();
				cam.setCodigo( rs.getInt(1) );
				cam.setDescricao( rs.getString(2) );
				
				lista.add(cam);
				
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
