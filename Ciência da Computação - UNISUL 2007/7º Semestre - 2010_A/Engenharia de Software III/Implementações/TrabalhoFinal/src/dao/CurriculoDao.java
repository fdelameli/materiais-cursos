package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import main.Principal;
import entitys.Curriculo;

public class CurriculoDao {

	private Connection conn = Principal.conn;
	
	/*
	 * Realiza a inserção de um currículo no banco de dados
	 */
	public void inserir(Curriculo curriculo) {
		String sql = "INSERT INTO curriculo (codigo, nome, telefone, endereco, idade, qtdFilhos, sexo, ensinoMedio, cursoSuperior, cursos, empresa, cargo, salario, motivoSaida, areaPretendida, salarioPretendido) VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
		try {

			PreparedStatement ps = conn.prepareStatement(sql);
			
			ps.setInt(1, curriculo.getCodigo());
			ps.setString(2, curriculo.getNome());
			ps.setInt(3, curriculo.getTelefone());
			ps.setString(4, curriculo.getEndereco());
			ps.setInt(5, curriculo.getIdade());
			ps.setInt(6, curriculo.getQuantidadeFilhos());
			ps.setString(7, curriculo.getSexo() + "");
			ps.setString(8, curriculo.getEnsinoMedio() + "");
			ps.setString(9, curriculo.getCursoSuperior());
			ps.setString(10, curriculo.getCursos());
			ps.setString(11, curriculo.getEmpresa());
			ps.setString(12, curriculo.getCargo());
			ps.setDouble(13, curriculo.getSalario());
			ps.setString(14, curriculo.getMotivoSaida());
			ps.setInt(15, curriculo.getAreaPretendida());
			ps.setDouble(16, curriculo.getSalarioPretendido());

			ps.executeUpdate();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
	}
	
	/*
	 * Realiza a pesquisa de currículos de acordo com os filtros fornecidos.
	 */
	public ArrayList<Curriculo> pesquisar(char sexo, int areaPretendida, String cursoSuperior){
		ArrayList<Curriculo> listaCurriculo = new ArrayList<Curriculo>();
		String sql = "SELECT * FROM curriculo WHERE sexo = '" + sexo + "' and areaPretendida = " + areaPretendida + " and cursoSuperior like '%" + cursoSuperior + "%'";
		try
		{
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()){
				listaCurriculo.add( new Curriculo(
						rs.getInt("codigo"),
						rs.getString("nome"),
						rs.getString("endereco"),
						rs.getInt("telefone"),
						rs.getInt("idade"),
						rs.getInt("qtdFilhos"),
						rs.getString("sexo").charAt(0),
						rs.getString("ensinoMedio").charAt(0),
						rs.getString("cursoSuperior"),
						rs.getString("cursos"),
						rs.getString("empresa"),
						rs.getString("cargo"),
						rs.getDouble("Salario"),
						rs.getString("motivoSaida"),
						rs.getInt("areaPretendida"),
						rs.getDouble("salarioPretendido")
				));
			}
			return listaCurriculo;
		}catch(SQLException e){
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
		return null;
	}
}
