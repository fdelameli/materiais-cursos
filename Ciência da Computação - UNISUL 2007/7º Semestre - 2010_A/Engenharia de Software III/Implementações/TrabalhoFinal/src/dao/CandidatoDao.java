package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import main.Principal;
import entitys.Candidato;

/**
 * Classe CandidatoDao faz a inserção de um candidato(codigo do candidato e codigo do currículo), e pesquisa o candidato de
 * acordo com os filtros desejados.
 * @author Allan
 */
public class CandidatoDao {

	private Connection conn = Principal.conn;
	
	/**
	 * Método inserir: insere um candidato com um currículo
	 * @param candidato Objeto do tipo candidato a ser inserido no banco.
	 */
	public void inserir(Candidato candidato) {
		String sql = "INSERT INTO candidato (codigo, codCurriculo) values (?, ?)";
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, candidato.getCodigo());
			ps.setInt(2, candidato.getCurriculo().getCodigo());
			ps.executeUpdate();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
	}

}
