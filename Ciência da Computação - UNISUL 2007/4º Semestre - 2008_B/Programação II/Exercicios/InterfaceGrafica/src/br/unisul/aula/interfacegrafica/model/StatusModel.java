package br.unisul.aula.interfacegrafica.model;

import java.util.List;

import br.unisul.aula.interfacegrafica.dao.DAOException;
import br.unisul.aula.interfacegrafica.dao.StatusDAO;
import br.unisul.aula.interfacegrafica.dto.StatusDTO;

public class StatusModel {

	
	public StatusModel() {
		// TODO Auto-generated constructor stub
	}
	
	
	public List<StatusDTO> listAll() throws DAOException {
		return StatusDAO.listAll();
	}
	
}
