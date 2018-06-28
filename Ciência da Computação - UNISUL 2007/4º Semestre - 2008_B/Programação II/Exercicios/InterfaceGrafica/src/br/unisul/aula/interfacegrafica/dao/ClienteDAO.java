package br.unisul.aula.interfacegrafica.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.unisul.aula.interfacegrafica.dto.ClienteDTO;

public class ClienteDAO {

	public ClienteDAO() {
		// TODO Auto-generated constructor stub
	}


	/**
	 * Método que retorna todos os clientes cadastrados na base de dados
	 * e que contém os parâmetros especificados na busca.
	 * @param nome Parâmetro de busca.
	 * @return Lista de clientes.
	 * @throws DAOException
	 */
	public static List<ClienteDTO> find (String nome) throws DAOException {
		List<ClienteDTO> clientes = new ArrayList<ClienteDTO>();
		Connection con = null;

		try {

			con = ConPooling.getInstance().getConnection();

			String sql = "SELECT * FROM CLIENTE WHERE NOME LIKE '%" 
				+ nome.toUpperCase() + "%' ORDER BY CODIGO";

			PreparedStatement stm = con.prepareStatement(sql);

			ResultSet rs = stm.executeQuery();

			while (rs.next()) {
				ClienteDTO cliente = new ClienteDTO();

				cliente.setCodigo( rs.getInt("codigo"));
				cliente.setNome( rs.getString("nome"));
				cliente.setCpf( rs.getString("cpf"));
				cliente.setRg( rs.getString("rg"));
				cliente.setSexo( rs.getString("sexo").charAt(0));
				cliente.setEmail( rs.getString("email"));
				cliente.setFone( rs.getString("telefone"));
				cliente.setCelular( rs.getString("celular"));
				cliente.setEndereco( rs.getString("endereco"));
				cliente.setCidade( rs.getString("cidade"));
				cliente.setUf(rs.getInt("uf"));
				cliente.setStatus( rs.getInt("status"));

				clientes.add(cliente);
			}

		} catch (DAOException daoe) {
			throw new DAOException("Não foi possível buscar clientes");
		} catch (SQLException sqle) {

		} finally {
			ConPooling.getInstance().retConnection(con);
		}
		return clientes;
	}

	
	public static List<ClienteDTO> listAll () throws DAOException {
		List<ClienteDTO> list = new ArrayList<ClienteDTO>();
		Connection con = null;

		try {

			con = ConPooling.getInstance().getConnection();
			String sql = "SELECT * FROM CLIENTE ORDER BY NOME ASC";

			PreparedStatement stm = con.prepareStatement(sql);

			ResultSet rs = stm.executeQuery();

			while (rs.next()) {
				ClienteDTO cliente = new ClienteDTO();

				cliente.setCodigo( rs.getInt("codigo"));
				cliente.setNome( rs.getString("nome"));
				cliente.setCpf( rs.getString("cpf"));
				cliente.setRg( rs.getString("rg"));
				cliente.setSexo( rs.getString("sexo").charAt(0));
				cliente.setEmail( rs.getString("email"));
				cliente.setFone( rs.getString("telefone"));
				cliente.setCelular( rs.getString("celular"));
				cliente.setEndereco( rs.getString("endereco"));
				cliente.setCidade( rs.getString("cidade"));
				
				list.add(cliente);
			}

		} catch (DAOException daoe) {
			throw new DAOException("Erro indefinido");
		} catch (SQLException sqle) {

		} finally {
			ConPooling.getInstance().retConnection(con);
		}
		return list;
	}
	

	/**
	 * Método que insere um cliente no banco de dados.
	 * @param cliente Cliente a ser inserido.
	 */
	public static void insert (ClienteDTO cliente) throws DAOException {
		Connection con = null;
		
		try {
			
			con = ConPooling.getInstance().getConnection();
			
			String sql = "INSERT INTO CLIENTE (NOME, CPF, RG, SEXO, EMAIL, TELEFONE, CELULAR, ENDERECO, CIDADE, UF, STATUS) " +
										 "VALUES (?,   ?,  ?,    ?,     ?,        ?,       ?,        ?,      ?,  ?,      ?)";
			
			PreparedStatement stm = con.prepareStatement(sql);
			stm.setString(1, cliente.getNome());
			stm.setString(2, cliente.getCpf());
			stm.setString(3, cliente.getRg());
			stm.setString(4, cliente.getSexo()+"");
			stm.setString(5, cliente.getEmail());
			stm.setString(6, cliente.getFone());
			stm.setString(7, cliente.getCelular());
			stm.setString(8, cliente.getEndereco());
			stm.setString(9, cliente.getCidade());
			stm.setInt(10, cliente.getUf());
			stm.setInt(11, cliente.getStatus());
			
			stm.executeUpdate();
			
			
		} catch (DAOException daoe) {
			throw new DAOException("Não foi possível inserir o cliente\n" + daoe.getMessage());
		} catch (SQLException sqle) {
			
		} finally {
			ConPooling.getInstance().retConnection(con);
		}
	}
	
	
	/**
	 * Método que apaga o registro de determinado cliente no banco.
	 * @param cliente Cliente a ser excluído.
	 */
	public static void delete (ClienteDTO cliente) throws DAOException {
		Connection con = null;
		
		try {
			
			con = ConPooling.getInstance().getConnection();
						
			String sql = "DELETE FROM CLIENTE WHERE CODIGO = ?";
			
			PreparedStatement stm = con.prepareStatement(sql);
			stm.setLong(1, cliente.getCodigo());
			
			stm.executeUpdate();
			
		} catch (DAOException daoe) {
			throw new DAOException("Erro ao tentar exclui o cliente: " + cliente.getNome() +
					"\n" + daoe.getMessage());
		} catch (SQLException sqle) {
			
		} finally {
			ConPooling.getInstance().retConnection(con);
		}
	}
	
	
	/**
	 * Método que atualiza o cadastro de determinado Cliente.
	 * @param cliente Cliente a ter o cadastro atualizado.
	 */
	public static void update (ClienteDTO cliente) throws DAOException {
		Connection con = null;

		try {

			con = ConPooling.getInstance().getConnection();

			String sql = "UPDATE CLIENTE SET NOME = ?, CPF = ?, RG = ?, " +
				"SEXO = ?, EMAIL = ?, TELEFONE = ?, CELULAR = ?, ENDERECO = ?, CIDADE = ?, " +
				"UF = ?, STATUS = ? WHERE CODIGO = ?";

			PreparedStatement stm = con.prepareStatement(sql);
			stm.setString(1, cliente.getNome());
			stm.setString(2, cliente.getCpf());
			stm.setString(3, cliente.getRg());
			stm.setString(4, cliente.getSexo()+"");
			stm.setString(5, cliente.getEmail());
			stm.setString(6, cliente.getFone());
			stm.setString(7, cliente.getCelular());
			stm.setString(8, cliente.getEndereco());
			stm.setString(9, cliente.getCidade());
			stm.setInt(10, cliente.getUf());
			stm.setInt(11, cliente.getStatus());
			stm.setLong(12, cliente.getCodigo());
			
			stm.executeUpdate();

		} catch (DAOException daoe) {
			throw new DAOException("Não foi possível atualizar os dados do cliente: " +
					cliente.getNome() + "\n" + daoe.getMessage());
		} catch (SQLException sqle) {

		} finally {
			ConPooling.getInstance().retConnection(con);
		}
	}
}
