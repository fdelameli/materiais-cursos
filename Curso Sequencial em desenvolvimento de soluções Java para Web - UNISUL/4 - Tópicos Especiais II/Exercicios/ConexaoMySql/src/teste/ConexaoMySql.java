package teste;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ConexaoMySql {

	
	public static Connection con = null;
	
	
	/**
	 * @param args
	 */
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		String driver = "com.mysql.jdbc.Driver";
		String url = "jdbc:mysql://localhost:3306/meubanco";
		String user = "root";
		String password = "mysql";
		
		
		try {
			
			// efetua a conexao com o banco
			Class.forName(driver);
			con = DriverManager.getConnection(url, user, password);
			System.out.println("Conexão com o banco aberta com sucesso!\n\n");
						
		
			//cadastraPessoas();
			//updatePessoa();
			//deletePessoa();
			//buscaPessoas();
			
			//DDL: alter talbe
//			String sql = "ALTER TABLE PESSOA ADD DS_ENDERECO VARCHAR(200)";
//			Statement statement = con.createStatement();
//			statement.execute(sql);
			
			
			DatabaseMetaData md = con.getMetaData();
			ResultSet rsTables = md.getTables(null, null, null, null);
			
			while (rsTables.next()) {
				
				System.out.println();
				
				String tableName = rsTables.getString("TABLE_NAME");
				System.out.println("Tabela: " + tableName);
				
				ResultSet rsColumns = md.getColumns(null, null, tableName, null);
				System.out.print("Colunas: ");
				
				while (rsColumns.next()) {
					System.out.print(rsColumns.getString("COLUMN_NAME") + "  --  ");
				}
				
				System.out.println();
				
//				System.out.println(rs.getString(1));
//				System.out.println(rs.getString(2));
//				System.out.println(rs.getString(3));
//				System.out.println(rs.getString(4));
//				System.out.println(rs.getString(5));
				System.out.println("----------------------------------------------------------------------------------------------------\n");
			}
			
		} catch (ClassNotFoundException cnfe) {
			System.err.println("Erro ao carregar o driver JDBC: " + cnfe.getMessage());
			cnfe.printStackTrace();
		} catch (SQLException sqle) {
			System.err.println("Erro ao conectar com o banco: " + sqle.getMessage());
			sqle.printStackTrace();			
		} finally {
			
			try {
				
				if (con != null && !con.isClosed())
					con.close();
				
			} catch (SQLException sqle) {
				System.err.println("Erro ao fechar conexão com o banco: " + sqle.getMessage());
				sqle.printStackTrace();
			}
		}
	}
	
	
	/**
	 * Cadastra uma pessoa no banco.
	 * @throws SQLException
	 */
	private static void cadastraPessoas() throws SQLException {
		
		String sql = "INSERT INTO PESSOA (CODIGO_PESSOA, NOME_PESSOA) VALUES (?, ?)";
		
		PreparedStatement statement = con.prepareStatement(sql);
		statement.setInt(1, 8);
		statement.setString(2, "José Maria João");
		
		int countInsert = statement.executeUpdate();
		
		if (countInsert == 1) {
			System.out.println("Registro inserido com sucesso!");
		} else {
			System.out.println("Nenhum registro inserido!");
		}
		
	}
	
	
	/**
	 * Busca todas as pessoas cadastradas no banco.
	 * @throws SQLException
	 */
	private static void buscaPessoas() throws SQLException {
		
		String sql = "SELECT * FROM PESSOA";
		
		PreparedStatement statement = con.prepareStatement(sql);
		ResultSet rs = statement.executeQuery();
		
		while (rs.next()) {
			long cdPessoa = rs.getInt("CODIGO_PESSOA");
			String nmPessoa = rs.getString("NOME_PESSOA");
			System.out.println("Código: " + cdPessoa + "  -  Nome: " + nmPessoa);
		}
	}
	
	/**
	 * Apaga o registro de uma pessoa no banco.
	 * @throws SQLException
	 */
	private static void deletePessoa() throws SQLException {
		
		String sql = "DELETE FROM PESSOA WHERE CODIGO_PESSOA = ?";
		
		PreparedStatement statement = con.prepareStatement(sql);
		statement.setInt(1, 8);
		
		int countDelete = statement.executeUpdate();
		
		if (countDelete > 0) {
			System.out.println("Foram excluídos " + countDelete + " registros.");
		} else {
			System.out.println("Nenhum registro excluído!");
		}
	}
	
	
	/**
	 * Atualiza os dados de uma pessoa no banco.
	 * @throws SQLException
	 */
	private static void updatePessoa() throws SQLException {
		
		String sql = "UPDATE PESSOA SET NOME_PESSOA = ? "
			+ "WHERE CODIGO_PESSOA = ?";
		
		PreparedStatement statement = con.prepareStatement(sql);
		statement.setString(1, "Pedro de Souza Paragua");
		statement.setInt(2, 8);
		
		int countUpdate = statement.executeUpdate();
		
		if (countUpdate > 0) {
			System.out.println("Foram atualizados " + countUpdate + " registros.");
		} else {
			System.out.println("Nenhum registro atualizado!");
		}
	}

}
