import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

public class Banco {

	// atributos
	private Connection con = null;
	
	// construtor default
	public Banco() {
		
		String driverName = "org.postgresql.Driver";  // carrega o diver JDBC
		String serverName = "localhost";
		String dataBase = "aula";
		String userName = "postgres";
		String password = "roger";
		String url = "jdbc:postgresql://" + serverName + "/" + dataBase;
		
		try {
			
			Class.forName(driverName);
			
			con = DriverManager.getConnection(url, userName, password);
			
		} catch (ClassNotFoundException cnfe) {
			JOptionPane.showMessageDialog(null, "Driver não encontrado.",
					"Error!", JOptionPane.ERROR_MESSAGE);
			cnfe.printStackTrace();
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Não foi possível conectar com o Banco.",
					"Error!", JOptionPane.ERROR_MESSAGE);
			e.printStackTrace();
		}
		
	}
	
	// método que efetua uma busca por pessoas no banco
	public List<String> buscaNomePessoas() {
		
		List<String> lista = new ArrayList<String>();
		String sql = "SELECT * FROM PESSOA";
		
		try {
			
			Statement stm = con.createStatement();
			
			ResultSet rs = stm.executeQuery(sql);
			
			while (rs.next()) {
				lista.add(rs.getString("nome"));
			}
			
		} catch (SQLException sqle) {
			JOptionPane.showMessageDialog(null, "Erro de sql.", "Error!", JOptionPane.ERROR_MESSAGE);
			sqle.printStackTrace();
		}
		
		return lista;
	}
	
	
	public boolean inserePessoa() {
		
		boolean inserido = false;
		String sql = "INSERT INTO PESSOA (CODIGO, NOME, IDADE, SEXO, ENDERECO) " +
						"VALUES (?, ?, ?, ?, ?)";
		try {
			
			PreparedStatement preparedStatement = con.prepareStatement(sql);
			
			preparedStatement.setInt(1, 10);
			preparedStatement.setString(2, "Sueli Scremin");
			preparedStatement.setInt(3, 18);
			preparedStatement.setString(4, "F");
			preparedStatement.setInt(5, 1);
			
			preparedStatement.execute();
			
			inserido = true;
			
		} catch (SQLException sqle) {
			JOptionPane.showMessageDialog(null, "Erro de sql.", "Error!", JOptionPane.ERROR_MESSAGE);
			sqle.printStackTrace();
		}
		
		return inserido;
	}
	
	public boolean atualizaDadosPessoa() {
		
		boolean atualizado = false;
		String sql = "UPDATE PESSOA SET NOME = ?, IDADE = ? WHERE CODIGO = ?";
		
		try {
			
			PreparedStatement preparedStatement = con.prepareStatement(sql);
			
			preparedStatement.setString(1, "testando");
			preparedStatement.setInt(2, 20);
			preparedStatement.setInt(3, 10);
			
			preparedStatement.executeUpdate();
			
			atualizado = true;
			
		} catch (SQLException sqle) {
			JOptionPane.showMessageDialog(null, "Erro de sql.", "Error!", JOptionPane.ERROR_MESSAGE);
			sqle.printStackTrace();
		}
		
		return atualizado;
	}
	
	
	// método principal
	public static void main(String[] args) {

		Banco banco = new Banco();
		
		boolean atualizar = banco.atualizaDadosPessoa();
		System.out.println(atualizar);
		
//		boolean inserir = banco.inserePessoa();
//		System.out.println(inserir);
		
		
		List<String> pessoas = banco.buscaNomePessoas();
		
		for (String p : pessoas) {
			System.out.println(p);
		}
	

	}

}
