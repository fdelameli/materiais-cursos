package br.unisul.aula.interfacegrafica.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import br.unisul.aula.interfacegrafica.dto.FuncionarioDTO;

public class FuncionarioDAO {

	/**
	 * Construtor default.
	 *
	 */
	public FuncionarioDAO() {
	
	}
	
	
	
	/**
	 * M�todo que retorna uma lista de funcionarios cadastrados
	 * no banco. A busca � feita de acordo com o par�metro que
	 * o usu�rio informar na tela de busca.
	 * @param nome Par�metro de Busca (nome do funcion�rio).
	 * @return Lista de Funcion�rios encontrados ou null
	 * caso n�o seja encontrado nenhum funcion�rio.
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
				func.setCodigo( rs.getLong("codigo"));
				func.setNome( rs.getString("nome"));
				func.setCpf( rs.getString("cpf"));
				func.setPis( rs.getString("pis"));
				func.setDataCadastro( rs.getDate("data_admissao"));
				func.setEndereco( rs.getString("endereco"));
				func.setNumero( rs.getInt("numero"));
				func.setCidade( rs.getString("cidade"));
				func.setUf( rs.getInt("uf"));
				func.setFone( rs.getString("telefone"));
				func.setEmail( rs.getString("email"));
				
				lista.add(func);
			}
			
		} catch (DAOException daoe) {
			throw new DAOException ("N�o foi poss�vel efetuar a busca");
		} catch (SQLException sqle) {
			
		} finally {
			ConPooling.getInstance().retConnection(con);
		}
		
		return lista;
	}
	
	
	/**
	 * M�todo que insere um funcionario no banco de dados.
	 * @param funcionario Funcionario a ser inserido.
	 */
	public static void insert (FuncionarioDTO funcionario) throws DAOException {
		Connection con = null;
		
		JOptionPane.showMessageDialog(null, funcionario.getNome());
		
		try {
			
			con = ConPooling.getInstance().getConnection();
			String sql = "INSERT INTO FUNCIONARIO (NOME, CPF, PIS, " +
				"ENDERECO, NUMERO, CIDADE, UF, " +
				"TELEFONE, EMAIL) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
			
			PreparedStatement stm = con.prepareStatement(sql);
			stm.setString(1, funcionario.getNome());
			stm.setString(2, funcionario.getCpf());
			stm.setString(3, funcionario.getPis());
			stm.setDate(4, new Date(funcionario.getDataCadastro().getTime()));
			stm.setString(4, funcionario.getEndereco());
			stm.setInt(5, funcionario.getNumero());
			stm.setString(6, funcionario.getCidade());
			stm.setInt(7, funcionario.getUf());
			stm.setString(8, funcionario.getFone());
			stm.setString(9, funcionario.getEmail());
			
			stm.executeUpdate();
			
		} catch (DAOException daoe) {
			daoe.printStackTrace();
			throw new DAOException ("N�o foi poss�vel cadastrar este funcion�rio");
		} catch (SQLException sqle) {
			
		} finally {
			ConPooling.getInstance().retConnection(con);
		}
	}
	
	
	/**
	 * M�todo que apaga o registro de determinado cliente no banco.
	 * @param funcionario Funcionario a ser exclu�do.
	 */
	public static void delete (FuncionarioDTO funcionario) throws DAOException {
		Connection con = null;
		
		try {
			
			con = ConPooling.getInstance().getConnection();
			String sql = "DELETE FUNCIONARIO WHERE CODIGO = ?";
			
			PreparedStatement stm = con.prepareStatement(sql);
			stm.setLong(1, funcionario.getCodigo());
			
			stm.executeUpdate();
			
		} catch (DAOException daoe) {
			throw new DAOException("Erro indefinido ao tentar exclui o funcion�rio: " + funcionario.getNome());
		} catch (SQLException slqe) {
			
		} finally {
			ConPooling.getInstance().retConnection(con);
		}
	}
	
	
	/**
	 * M�todo que atualiza o cadastro de determinado Funcionario.
	 * @param funcionario Funcionario a ter o cadastro atualizado.
	 */
	public static void update (FuncionarioDTO funcionario) throws DAOException {
Connection con = null;
		
		try {
			
			con = ConPooling.getInstance().getConnection();
			String sql = "UPDATE FUNCIONARIO SET NOME = ?, CPF = ?, PIS = ?, " +
				"DATA_ADMISSAO = ?, ENDERECO = ?, NUMERO = ?, " +
				"CIDADE = ?, UF = ?, TELEFONE = ?, EMAIL = ? WHERE CODIGO = ?";
			
			PreparedStatement stm = con.prepareStatement(sql);
			stm.setString(1, funcionario.getNome());
			stm.setString(2, funcionario.getCpf());
			stm.setString(3, funcionario.getPis());
			stm.setDate(4, new Date(funcionario.getDataCadastro().getTime()));
			stm.setString(5, funcionario.getEndereco());
			stm.setInt(6, funcionario.getNumero());
			stm.setString(7, funcionario.getCidade());
			stm.setInt(8, funcionario.getUf());
			stm.setString(9, funcionario.getFone());
			stm.setString(10, funcionario.getEmail());
			stm.setLong(11, funcionario.getCodigo());
			
			stm.executeUpdate();
			
		} catch (DAOException daoe) {
			throw new DAOException ("N�o foi poss�vel atualizar os dados deste funcion�rio");
		} catch (SQLException sqle) {
			
		} finally {
			ConPooling.getInstance().retConnection(con);
		}
	}
	
	
}
