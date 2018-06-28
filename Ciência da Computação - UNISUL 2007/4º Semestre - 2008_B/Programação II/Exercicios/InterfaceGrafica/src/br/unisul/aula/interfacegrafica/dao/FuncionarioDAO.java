package br.unisul.aula.interfacegrafica.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.unisul.aula.interfacegrafica.dto.FuncionarioDTO;

public class FuncionarioDAO {

	/**
	 * Construtor default.
	 *
	 */
	public FuncionarioDAO() {
	
	}
	
	
	
	/**
	 * Método que retorna uma lista de funcionarios cadastrados
	 * no banco. A busca é feita de acordo com o parâmetro que
	 * o usuário informar na tela de busca.
	 * @param nome Parâmetro de Busca (nome do funcionário).
	 * @return Lista de Funcionários encontrados ou null
	 * caso não seja encontrado nenhum funcionário.
	 */
	public static List<FuncionarioDTO> find (String nome) throws DAOException {
		List<FuncionarioDTO> lista = new ArrayList<FuncionarioDTO>();
		Connection con = null;
		
		try {
			
			con = ConPooling.getInstance().getConnection();
			String sql = "SELECT * FROM FUNCIONARIO WHERE UPPER(NOME) " +
				"LIKE '%" + nome.toUpperCase() + "%' ORDER BY NOME ASC";
			
			PreparedStatement stm = con.prepareStatement(sql);
			
			ResultSet rs = stm.executeQuery();
			
			while (rs.next()) {
				FuncionarioDTO func = new FuncionarioDTO();
				func.setCodigo( rs.getInt("codigo"));
				func.setNome( rs.getString("nome"));
				func.setCpf( rs.getString("cpf"));
				func.setPis( rs.getString("pis"));
				func.setEndereco( rs.getString("endereco"));
				func.setCidade( rs.getString("cidade"));
				func.setUf( rs.getInt("uf"));
				func.setFone( rs.getString("telefone"));
				func.setEmail( rs.getString("email"));
				
				lista.add(func);
			}
			
		} catch (DAOException daoe) {
			throw new DAOException ("Não foi possível efetuar a busca");
		} catch (SQLException sqle) {
			
		} finally {
			ConPooling.getInstance().retConnection(con);
		}
		
		return lista;
	}
	
	
	/**
	 * Método que insere um funcionario no banco de dados.
	 * @param funcionario Funcionario a ser inserido.
	 */
	public static void insert (FuncionarioDTO funcionario) throws DAOException {
		Connection con = null;
		
		try {
			
			con = ConPooling.getInstance().getConnection();
			String sql = "INSERT INTO FUNCIONARIO (NOME, CPF, PIS, " +
				"ENDERECO, CIDADE, UF, TELEFONE, EMAIL) " +
				"VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
			
			PreparedStatement stm = con.prepareStatement(sql);
			stm.setString(1, funcionario.getNome());
			stm.setString(2, funcionario.getCpf());
			stm.setString(3, funcionario.getPis());
			stm.setString(4, funcionario.getEndereco());
			stm.setString(5, funcionario.getCidade());
			stm.setInt(6, funcionario.getUf());
			stm.setString(7, funcionario.getFone());
			stm.setString(8, funcionario.getEmail());
			
			stm.executeUpdate();
			
		} catch (DAOException daoe) {
			daoe.printStackTrace();
			throw new DAOException ("Não foi possível cadastrar este funcionário");
		} catch (SQLException sqle) {
			sqle.printStackTrace();
		} finally {
			ConPooling.getInstance().retConnection(con);
		}
	}
	
	
	/**
	 * Método que apaga o registro de determinado cliente no banco.
	 * @param funcionario Funcionario a ser excluído.
	 */
	public static void delete (FuncionarioDTO funcionario) throws DAOException {
		Connection con = null;
		
		try {
			
			con = ConPooling.getInstance().getConnection();
			String sql = "DELETE FROM FUNCIONARIO WHERE CODIGO = ?";
			
			PreparedStatement stm = con.prepareStatement(sql);
			stm.setInt(1, funcionario.getCodigo());
			
			stm.executeUpdate();
			
		} catch (DAOException daoe) {
			throw new DAOException("Erro indefinido ao tentar exclui o funcionário: " + funcionario.getNome());
		} catch (SQLException slqe) {
			
		} finally {
			ConPooling.getInstance().retConnection(con);
		}
	}
	
	
	/**
	 * Método que atualiza o cadastro de determinado Funcionario.
	 * @param funcionario Funcionario a ter o cadastro atualizado.
	 */
	public static void update (FuncionarioDTO funcionario) throws DAOException {
		Connection con = null;
		
		try {
			
			con = ConPooling.getInstance().getConnection();
			String sql = "UPDATE FUNCIONARIO SET NOME = ?, CPF = ?, PIS = ?, ENDERECO = ?," +
				"CIDADE = ?, UF = ?, TELEFONE = ?, EMAIL = ? WHERE CODIGO = ?";
			
			PreparedStatement stm = con.prepareStatement(sql);
			stm.setString(1, funcionario.getNome());
			stm.setString(2, funcionario.getCpf());
			stm.setString(3, funcionario.getPis());
			stm.setString(4, funcionario.getEndereco());
			stm.setString(5, funcionario.getCidade());
			stm.setInt(6, funcionario.getUf());
			stm.setString(7, funcionario.getFone());
			stm.setString(8, funcionario.getEmail());
			stm.setInt(9, funcionario.getCodigo());
			
			stm.executeUpdate();
			
		} catch (DAOException daoe) {
			throw new DAOException ("Não foi possível atualizar os dados deste funcionário");
		} catch (SQLException sqle) {
			
		} finally {
			ConPooling.getInstance().retConnection(con);
		}
	}
	
	
}
