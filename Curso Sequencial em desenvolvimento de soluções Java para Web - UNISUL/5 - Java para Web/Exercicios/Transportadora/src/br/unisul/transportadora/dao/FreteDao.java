package br.unisul.transportadora.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.unisul.transportadora.bean.FreteBean;
import br.unisul.transportadora.bean.UsuarioBean;
import br.unisul.transportadora.dao.connection.ConexaoJDBC;

/**
 * Classe Java que efetua as operações no banco
 * de dados para a entidade Frete.
 * @author Fabio Dela Bruna
 */
public class FreteDao {

	/**
	 * Método que retorna o maior valor no campo código da tabela.
	 * @return Maior Código se houver algum registro na table, caso contrário, 0.
	 */
	public Integer getMaxValueFromCodigo() {
		
		String sql = "SELECT MAX(CD_FRE) FROM FRETE";
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
	 * Método que busca um frete de acordo com o código.
	 * @param codigo Código do frete.
	 * @return Objeto do tipo FreteBean, se encontrado, ou null.
	 */
	public FreteBean findById(Integer codigo) {
		
		String sql = "SELECT CD_FRE, KM_FRE, VL_FRE, CD_TRANSP, CD_CAM, CD_USER " +
		"FROM FRETE WHERE CD_FRE = ?";
		Connection con = ConexaoJDBC.getConnection();
		PreparedStatement ps = null;
		ResultSet rs = null;
		FreteBean fre = null;
		
		try {
			
			ps = con.prepareStatement(sql);
			ps.setInt(1, codigo);
			
			rs = ps.executeQuery();
			
			if (rs.next()) {
				fre = new FreteBean();
				fre.setCodigo( rs.getInt(1) );
				fre.setQuilometragem( rs.getDouble(2) );
				fre.setValor( rs.getDouble(3) );
				fre.setCodigoTransportadora( rs.getInt(4) );
				fre.setCodigoCaminhao( rs.getInt(5) );
				fre.setCodigoCliente( rs.getInt(6) );
			}
			return fre;
			
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
		return fre;
	}
	
	
	/**
	 * Este método busca os fretes de acordo com o cliente.
	 * @param user Cliente que solicitou o frete.
	 * @return ArrayList de fretes do cliente em questão.
	 */
	public ArrayList<FreteBean> findByCliente(UsuarioBean user) {
		
		String sql = "SELECT CD_FRE, KM_FRE, VL_FRE, CD_TRANSP, CD_CAM, CD_USER " +
					"FROM FRETE WHERE CD_USER = ? ORDER BY (CD_FRE)";
		Connection con = ConexaoJDBC.getConnection();
		ArrayList<FreteBean> lista = new ArrayList<FreteBean>();
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try {
				
			ps = con.prepareStatement(sql);
			ps.setInt(1, user.getCodigo());
			rs = ps.executeQuery();
			
			while (rs.next()) {
				FreteBean fre = new FreteBean();
				fre.setCodigo( rs.getInt(1) );
				fre.setQuilometragem( rs.getDouble(2) );
				fre.setValor( rs.getDouble(3) );
				fre.setCodigoTransportadora( rs.getInt(4) );
				fre.setCodigoCaminhao( rs.getInt(5) );
				fre.setCodigoCliente( rs.getInt(6) );
				
				lista.add(fre);
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
	
	
	/**
	 * Método que insere o registro de um frete no banco.
	 * @param fre Objeto do tipo FreteBean a ser inserido.
	 * @return True se inserido com sucesso, caso contrário, False.
	 */
	public boolean insertFrete(FreteBean fre) {
		
		String sql = "INSERT INTO FRETE (CD_FRE, KM_FRE, VL_FRE, " +
				"CD_TRANSP, CD_CAM, CD_USER) VALUES (?, ?, ?, ?, ?, ?)";
		Connection con = ConexaoJDBC.getConnection();
		PreparedStatement ps = null;
		boolean retorno = false;
		
		try {
			
			ps = con.prepareStatement(sql);
			ps.setInt(1, fre.getCodigo());
			ps.setDouble(2, fre.getQuilometragem());
			ps.setDouble(3, fre.getValor());
			ps.setInt(4, fre.getCodigoTransportadora());
			ps.setInt(5, fre.getCodigoCaminhao());
			ps.setInt(6, fre.getCodigoCliente());
			
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
	 * @param fre Objeto do tipo FreteBean atualizado.
	 * @return True se atualizado com sucesso, caso contrário, False.
	 */
	public boolean updateFrete(FreteBean fre) {
		
		String sql = "UPDATE FRETE SET KM_FRE = ?, VL_FRE = ?, " +
				"CD_TRANSP = ?, CD_CAM = ?, CD_USER = ? WHERE CD_FRE = ?";
		Connection con = ConexaoJDBC.getConnection();
		PreparedStatement ps = null;
		boolean retorno = false;
		
		try {
			
			ps = con.prepareStatement(sql);
			ps.setDouble(1, fre.getQuilometragem());
			ps.setDouble(2, fre.getValor());
			ps.setInt(3, fre.getCodigoTransportadora());
			ps.setInt(4, fre.getCodigoCaminhao());
			ps.setInt(5, fre.getCodigoCliente());
			ps.setInt(6, fre.getCodigo());
			
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
	public boolean deleteFrete(Integer codigo) {
		
		String sql = "DELETE FROM FRETE WHERE CD_FRE = ?";
		Connection con = ConexaoJDBC.getConnection();
		PreparedStatement ps = null;
		boolean retorno = false;
		
		try {
			
			ps = con.prepareStatement(sql);
			ps.setInt(1, codigo);
			
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
	 * Método que retorna uma lista contendo todos os registros no banco.
	 * @return Lista com todos os registros de fretes.
	 */
	public List<FreteBean> findAllFrete() {
		
		String sql = "SELECT CD_FRE, KM_FRE, VL_FRE, " +
				"CD_TRANSP, CD_CAM, CD_USER FROM FRETE ORDER BY(CD_FRE)";
		Connection con = ConexaoJDBC.getConnection();
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<FreteBean> lista = new ArrayList<FreteBean>();
		
		try {
			
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			
			while (rs.next()) {
				
				FreteBean fre = new FreteBean();
				fre.setCodigo( rs.getInt(1) );
				fre.setQuilometragem( rs.getDouble(2) );
				fre.setValor( rs.getDouble(3) );
				fre.setCodigoTransportadora( rs.getInt(4) );
				fre.setCodigoCaminhao( rs.getInt(5) );
				fre.setCodigoCliente( rs.getInt(6) );
				
				lista.add(fre);
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
