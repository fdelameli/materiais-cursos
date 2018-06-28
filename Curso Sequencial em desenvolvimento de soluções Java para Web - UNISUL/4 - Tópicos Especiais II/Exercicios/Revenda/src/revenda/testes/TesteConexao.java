package revenda.testes;

import java.sql.Connection;

import revenda.dao.ConexaoBanco;


/**
 * Classe usada para efetuar testes do programa.
 * @author Fabio Dela Bruna.
 * @since 04/10/2008.
 */
public class TesteConexao {

	public static void main(String[] args) {
		
		try {
			
			Connection con = ConexaoBanco.getInstance().getConnection();
			System.out.println("Conexao estabelecida com sucesso!");
			
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println(e.getMessage());
			
		} finally {
			
			try {
				ConexaoBanco.getInstance().closeConnection();
				System.out.println("Conexao fechada com sucesso!");
			} catch (Exception e){
				System.err.println("Erro ao fechar conexao");
			}
		}
	}
		
}
