package br.unisul.aula.interfacegrafica.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.unisul.aula.interfacegrafica.dto.QuartoDTO;

public class QuartoDAO {

	/**
	 * Construtor default.
	 *
	 */
	public QuartoDAO() {
		// TODO Auto-generated constructor stub
	}
	
	
	
	
	/**
	 * Método que retorna uma lista de quartos cadastrados no banco.
	 * @return Lista de Quartos encontrados ou null
	 * caso não seja encontrado nenhum quarto.
	 */
	public static List<QuartoDTO> find () throws DAOException {
		List<QuartoDTO> lista = new ArrayList<QuartoDTO>();
		Connection con = null;
		
		try {
			
			con = ConPooling.getInstance().getConnection();
			String sql = "SELECT * FROM QUARTO ORDER BY NUMERO ASC";
			
			PreparedStatement stm = con.prepareStatement(sql);
			
			ResultSet rs = stm.executeQuery();
			
			while (rs.next()) {
				QuartoDTO quarto = new QuartoDTO();
				quarto.setCodigo( rs.getLong("codigo"));
				quarto.setNumero( rs.getInt("numero"));
				quarto.setDescricao( rs.getString("descricao"));
				quarto.setValorDiaria( rs.getDouble("valor_diaria"));
				
				lista.add(quarto);
			}
			
		} catch (DAOException daoe) {
			throw new DAOException ("Erro ao efetuar a busca");
		} catch (SQLException sqle) {
			
		} finally {
			ConPooling.getInstance().retConnection(con);
		}
		
		return lista;
	}
	
	
	/**
	 * Método que insere um quarto no banco de dados.
	 * @param quarto Quarto a ser inserido.
	 */
	public static void insert (QuartoDTO quarto) throws DAOException {
		Connection con = null;
		
		try {
			
			con = ConPooling.getInstance().getConnection();
			String sql = "INSERT INTO QUARTO (NUMERO, DESCRICAO, VALOR_DIARIA) " +
				"VALUES (?, ?, ?)";
			
			PreparedStatement stm = con.prepareStatement(sql);
			stm.setInt(1, quarto.getNumero());
			stm.setString(2, quarto.getDescricao());
			stm.setDouble(3, quarto.getValorDiaria());
			
			stm.executeUpdate();
			
		} catch (DAOException daoe) {
			throw new DAOException ("Não foi possível cadastrar este quarto");
		} catch (SQLException sqle) {
			
		} finally {
			ConPooling.getInstance().retConnection(con);
		}
	}
	
	
	/**
	 * Método que apaga o registro de determinado quarto no banco.
	 * @param quarto Quarto a ser excluído.
	 */
	public static void delete (QuartoDTO quarto) throws DAOException {
		Connection con = null;
		
		try {
			
			con = ConPooling.getInstance().getConnection();
			String sql = "DELETE QUARTO WHERE CODIGO = ?";
			
			PreparedStatement stm = con.prepareStatement(sql);
			stm.setLong(1, quarto.getCodigo());
			
			stm.executeUpdate();
			
		} catch (DAOException daoe) {
			throw new DAOException ("Não foi possível excluir o cadastro deste quarto");
		} catch (SQLException sqle) {
			
		} finally {
			ConPooling.getInstance().retConnection(con);
		}
	}
	
	
	/**
	 * Método que atualiza o cadastro de determinado Quarto.
	 * @param quarto Quarto a ter o cadastro atualizado.
	 */
	public static void update (QuartoDTO quarto) throws DAOException {
		Connection con = null;
		
		try {
			
			con = ConPooling.getInstance().getConnection();
			String sql = "UPDATE QUARTO SET NUMERO = ?, DESCRICAO = ?, " +
				"VALOR_DIARIA = ? WHERE CODIGO = ?";
			
			PreparedStatement stm = con.prepareStatement(sql);
			stm.setInt(1, quarto.getNumero());
			stm.setString(2, quarto.getDescricao());
			stm.setDouble(3, quarto.getValorDiaria());
			stm.setLong(4, quarto.getCodigo());
			
			stm.executeUpdate();
			
		} catch (DAOException daoe) {
			throw new DAOException ("Não foi possível atualizar o cadastro deste quarto");
		} catch (SQLException sqle) {
			
		} finally {
			ConPooling.getInstance().retConnection(con);
		}
	}
}
