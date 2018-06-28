package br.unisul.aula.interfacegrafica.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.unisul.aula.interfacegrafica.dto.StatusDTO;

public class StatusDAO {

	
	public StatusDAO() {
		// TODO Auto-generated constructor stub
	}
	
	
	public static List<StatusDTO> listAll() throws DAOException {
		List<StatusDTO> list = new ArrayList<StatusDTO>();
		Connection con = null;
		
		try {
			
			con = ConPooling.getInstance().getConnection();
			String sql = "SELECT * FROM STATUS ORDER BY (CODIGO)";
			
			PreparedStatement stm = con.prepareStatement(sql);
			
			ResultSet rs = stm.executeQuery();
			
			while (rs.next()) {
				StatusDTO status = new StatusDTO();
				status.setcodigo( rs.getInt("CODIGO"));
				status.setDescricao( rs.getString("DESCRICAO"));
				
				list.add(status);
			}
			
		} catch (DAOException daoe) {
			throw new DAOException ("Erro indefinido");
		} catch (SQLException sqle) {
			
		} finally {
			ConPooling.getInstance().retConnection(con);
		}
		
		return list;
	}
}
