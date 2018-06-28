package br.unisul.aula.banco.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import br.unisul.aula.banco.dto.Pessoa;

public class Banco {

	public static ConPooling cn = ConPooling.getInstance();
	
	public Banco(){
		
	}
	
	public void inserePessoa(String nome, int idade){
		Connection con = cn.getConnection();
		
		
		try {			
			
			String sql = "INSERT INTO TESTE (NOME, IDADE) VALUES (?, ?)";
			
			PreparedStatement preparedStatement = con.prepareStatement(sql);
			preparedStatement.setInt(2, idade);
			preparedStatement.setString(1, nome);			
			
			preparedStatement.execute();
			
			
			cn.retConnection(con);
			
			
		} catch (SQLException e) {
			cn.retConnection(con);
		}
		
	}
	
	public ArrayList<Pessoa> listaPessoas(){
		
		Connection con = cn.getConnection();
		ArrayList<Pessoa> array = new ArrayList<Pessoa>();
		
		try {
			
			Statement stm = con.createStatement();
			String sql = "SELECT * FROM PESSOA";		
			
			ResultSet rs = stm.executeQuery(sql);
			
			while(rs.next()){
				array.add( new Pessoa(rs.getInt("codigo"), rs.getString("nome"), rs.getInt("idade")) );
			}
			
			cn.retConnection(con);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return array;
	}

	public static void main(String args[]) {

		Banco banco = new Banco();

		ArrayList<Pessoa> aux = banco.listaPessoas();
		System.out.println(aux.size());
		
		for (Pessoa pessoa : aux) {
			
		}
		
		System.out.println("Funcionou!");
	}
}