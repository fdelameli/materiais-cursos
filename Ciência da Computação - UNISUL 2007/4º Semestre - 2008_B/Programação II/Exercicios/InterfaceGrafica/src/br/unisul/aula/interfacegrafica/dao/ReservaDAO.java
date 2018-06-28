package br.unisul.aula.interfacegrafica.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import br.unisul.aula.interfacegrafica.dto.ReservaDTO;

public class ReservaDAO {

	/**
	 * Construtor default.
	 *
	 */
	public ReservaDAO() {
		// TODO Auto-generated constructor stub
	}
	
	
	
	/**
	 * Método que retorna uma lista de reservas efetuadas por
	 * determinado cliente. A busca é feita pelo nome no cliente.
	 * @param nome Parâmetro de Busca (nome do cliente).
	 * @return Lista de reservas encontrados ou null
	 * caso não seja encontrado nenhuma reserva.
	 */
	public static List<ReservaDTO> find (String nome) throws DAOException {
		List<ReservaDTO> lista = new ArrayList<ReservaDTO>();
		Connection con = null;
		
		try {
			
			con = ConPooling.getInstance().getConnection();
			String sqlPog = "SELECT * FROM CLIENTE WHERE NOME = ?";
			PreparedStatement stmPog = con.prepareStatement(sqlPog);
			stmPog.setString(1, nome);
			ResultSet rsPog = stmPog.executeQuery();
			
			long codigoCliente = 0;
			while (rsPog.next()) {
				JOptionPane.showMessageDialog(null, rsPog.getLong("CODIGO"));
				codigoCliente = rsPog.getLong("CODIGO");
				JOptionPane.showMessageDialog(null, "Cod: " + codigoCliente);
			}
			
			String sql = "SELECT * FROM RESERVA WHERE CODIGO_CLIENTE = ?";
			
			PreparedStatement stm = con.prepareStatement(sql);
			stm.setLong(1, codigoCliente);
			
			ResultSet rs = stm.executeQuery();
			
			while (rs.next()) {
				ReservaDTO reserva = new ReservaDTO();
				reserva.setCodigo( rs.getLong("codigo"));
				reserva.setCliente( rs.getInt("codigo_cliente"));
				reserva.setQuarto( rs.getInt("codigo_quarto"));
				reserva.setDataEntrada( rs.getDate("data_entrada"));
				reserva.setDataSaida( rs.getDate("data_saida"));
				
				lista.add(reserva);
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
	 * Método que insere uma reserva no banco de dados.
	 * @param reserva Reserva a ser registrada.
	 */
	public static void insert (ReservaDTO reserva) throws DAOException {
Connection con = null;
		
		try {
			
			con = ConPooling.getInstance().getConnection();
			String sql = "INSERT INTO RESERVA (CLIENTE, QUARTO, DATA_ENTRADA, " +
				"DATA_SAIDA) VALUES (?, ?, ?, ?)";
			
			PreparedStatement stm = con.prepareStatement(sql);
			stm.setInt(1, reserva.getCliente());
			stm.setInt(2, reserva.getQuarto());
			stm.setDate(3, (Date) reserva.getDataEntrada());
			stm.setDate(4, (Date) reserva.getDataSaida());
			
			stm.executeUpdate();
			
		} catch (DAOException daoe) {
			throw new DAOException ("Erro cadastrar a reserva");
		} catch (SQLException sqle) {
			
		} finally {
			ConPooling.getInstance().retConnection(con);
		}
		
	}
	
	
	/**
	 * Método que cancela determinada reserva do banco.
	 * @param reserva Reserva a ser cancelada.
	 */
	public static void delete (ReservaDTO reserva) throws DAOException {
		Connection con = null;
		
		try {
			
			con = ConPooling.getInstance().getConnection();
			String sql = "DELETE RESERVA WHERE CLIENTE = ? AND QUARTO = ?";
			
			PreparedStatement stm = con.prepareStatement(sql);
			stm.setInt(1, reserva.getCliente());
			stm.setInt(2, reserva.getQuarto());
			
			stm.executeUpdate();
			
		} catch (DAOException daoe) {
			throw new DAOException ("Erro ao excluir a reserva");
		} catch (SQLException sqle) {
			
		} finally {
			ConPooling.getInstance().retConnection(con);
		}
		
	}
	
	
	/**
	 * Método que atualiza os dados de determinada Reserva.
	 * @param reserva Reserva a ter o cadastro atualizado.
	 */
	public static void update (ReservaDTO reserva) throws DAOException {
		Connection con = null;
		
		try {
			
			con = ConPooling.getInstance().getConnection();
			String sql = "UPDATE RESERVA SET CLIENTE = ?, QUARTO = ?, DATA_ENTRADA = ?, " +
				"DATA_SAIDA = ? WHERE CODIGO = ?";
			
			PreparedStatement stm = con.prepareStatement(sql);
			stm.setInt(1, reserva.getCliente());
			stm.setInt(2, reserva.getQuarto());
			stm.setDate(3, (Date) reserva.getDataEntrada());
			stm.setDate(4, (Date) reserva.getDataSaida());
			stm.setLong(5, reserva.getCodigo());
			
			stm.executeUpdate();
			
		} catch (DAOException daoe) {
			throw new DAOException ("Erro ao atualizar os dados da reserva");
		} catch (SQLException sqle) {
			
		} finally {
			ConPooling.getInstance().retConnection(con);
		}
	}
	
	
	public static List<ReservaDTO> listCodigoCliente() throws SQLException, DAOException{
		Connection con = null;
		List<ReservaDTO> lista = new ArrayList<ReservaDTO>();
		
		try {
			
			con = ConPooling.getInstance().getConnection();
			String sql = "SELECT * FROM RESERVA";
			
			PreparedStatement stm = con.prepareStatement(sql);
			
			ResultSet rs = stm.executeQuery();
			
			while (rs.next()) {
				ReservaDTO res = new ReservaDTO();
				res.setCliente(rs.getInt("CODIGO_CLIENTE"));
				JOptionPane.showMessageDialog(null, res.getCliente());
				lista.add(res);
			}
			
		
		} catch (SQLException sqle){
			
		} finally {
			ConPooling.getInstance().retConnection(con);
		}
		
		return lista;
	}
}
