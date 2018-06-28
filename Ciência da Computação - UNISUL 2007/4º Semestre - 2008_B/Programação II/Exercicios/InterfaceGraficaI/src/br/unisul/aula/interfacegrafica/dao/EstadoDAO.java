package br.unisul.aula.interfacegrafica.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.unisul.aula.interfacegrafica.dto.EstadoDTO;

public class EstadoDAO {

	
	public EstadoDAO() {
		// TODO Auto-generated constructor stub
	}
	
	
	public static List<EstadoDTO> listAll()	throws DAOException {
		List<EstadoDTO> list = new ArrayList<EstadoDTO>();
		Connection con = null;
		
		try {
			
			con = ConPooling.getInstance().getConnection();
			String sql = "SELECT * FROM UF ORDER BY (SIGLA)";
			
			PreparedStatement stm = con.prepareStatement(sql);
			
			ResultSet rs = stm.executeQuery();
			
			while (rs.next()) {
				EstadoDTO estado = new EstadoDTO();
				estado.setCodigo( rs.getInt("CODIGO"));
				estado.setSigla( rs.getString("SIGLA"));
				estado.setNome( rs.getString("NOME"));
				
				list.add(estado);
			}
			
		} catch (DAOException daoe) {
			throw new DAOException ("Erro indefinido!!");
		} catch (SQLException sqle) {
			
		} finally {
			ConPooling.getInstance().retConnection(con);
		}
		
		return list;
	}
}
