package br.unisul.transportadora.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.unisul.transportadora.bean.DuvidaBean;
import br.unisul.transportadora.dao.connection.ConexaoJDBC;

/**
 * Classe Java que efetua as operações no banco
 * de dados para a entidade DuvidaBean.
 * @author Fabio Dela Bruna
 */
public class DuvidaDao {
	
	
	/**
	 * Método que retorna o maior valor no campo código da tabela.
	 * @return Maior Código se houver algum registro na table, caso contrário, 0.
	 */
	public Integer getMaxValueFromCodigo() {
		
		String sql = "SELECT MAX(CODIGO) FROM DUVIDA";
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
	 * Método que cadastra uma dúvida no banco de dados.
	 * @param duv Objeto do tipo DuvidaBean a ser cadastrado.
	 */
	public void insertDuvida(DuvidaBean duv) {
		
		String sql = "INSERT INTO DUVIDA (CODIGO, NOME, EMAIL, EMPRESA, " +
		"DDD, FONE, ASSUNTO, MENSSAGEM) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
		
		Connection con = ConexaoJDBC.getConnection();
		PreparedStatement ps = null;
		
		try {
			
			ps = con.prepareStatement(sql);
			ps.setInt(1, duv.getCodigo());
			ps.setString(2, duv.getNome());
			ps.setString(3, duv.getEmail());
			ps.setString(4, duv.getEmpresa());
			ps.setString(5, duv.getDdd());
			ps.setString(6, duv.getFone());
			ps.setString(7, duv.getAssunto());
			ps.setString(8, duv.getMenssagem());
			
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
	 * Método que apaga um registro do bando de acordo com o código.
	 * @param codigo Código do registro a ser apagado.
	 */
	public void deleteDuvida (Integer codigo) {
		
		String sql = "DELETE FROM DUVIDA WHERE CODIGO = ?";
		Connection con = ConexaoJDBC.getConnection();
		PreparedStatement ps = null;
		
		try {
			
			ps = con.prepareStatement(sql);
			ps.setInt(1, codigo);
			
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
	 * Método que retorna todos os registros de dúvidas.
	 * @return List com as dúvidas.
	 */
	public List<DuvidaBean> findAllDuvida() {
		
		String sql = "SELECT CODIGO, NOME, EMAIL, EMPRESA, DDD, " +
				"FONE, ASSUNTO, MENSSAGEM FROM DUVIDA ORDER BY(CODIGO)";
		
		Connection con = ConexaoJDBC.getConnection();
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<DuvidaBean> lista = new ArrayList<DuvidaBean>();
		
		try {
			
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
		
			int countTeste = 0;
			while (rs.next()) {
				DuvidaBean duv = new DuvidaBean();
				duv.setCodigo( rs.getInt(1) );
				duv.setNome( rs.getString(2) );
				duv.setEmail( rs.getString(3) );
				duv.setEmpresa( rs.getString(4) );
				duv.setDdd( rs.getString(5) );
				duv.setFone( rs.getString(6) );
				duv.setAssunto( rs.getString(7) );
				duv.setMenssagem( rs.getString(8) );
				
				lista.add(duv);
				countTeste++;
			}
			System.err.println(countTeste+"");
			
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
