package br.unisul.aula.interfacegrafica.model;

import java.util.List;

import br.unisul.aula.interfacegrafica.dao.DAOException;
import br.unisul.aula.interfacegrafica.dao.EstadoDAO;
import br.unisul.aula.interfacegrafica.dto.EstadoDTO;

public class EstadoModel {

	public EstadoModel() {
		// TODO Auto-generated constructor stub
	}
	
	
	public List<EstadoDTO> listAll() throws DAOException {
		return EstadoDAO.listAll();
	}
}
