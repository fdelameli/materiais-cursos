package br.unisul.aula.interfacegrafica.model;

import java.util.List;

import br.unisul.aula.interfacegrafica.dao.DAOException;
import br.unisul.aula.interfacegrafica.dao.ReservaDAO;
import br.unisul.aula.interfacegrafica.dto.ErroValidacao;
import br.unisul.aula.interfacegrafica.dto.ReservaDTO;

public class ReservaModel extends BaseModel {

	
	public ReservaModel() {
		// TODO Auto-generated constructor stub
	}
	
	
	@Override
	public void validate(Object obj) throws ErroValidacao {
		ReservaDTO res = (ReservaDTO) obj;
		
		if (res.getCliente() == null)
			throw new ErroValidacao("Selecione um Cliente");
		if (res.getQuarto() == null)
			throw new ErroValidacao("Selecione um Quarto");
		if (res.getDataEntrada() == null) {
			throw new ErroValidacao("Informa a data de entrada");
		}
		
	}
	
	
	/**
	 * Método para inserir o cadastro de uma reserva no Banco.
	 * @param reserva Reserva a ser inserida.
	 * @throws ErroValidacao 
	 */
	public void insert (ReservaDTO reserva) throws ErroValidacao, DAOException {
		validate(reserva);
		ReservaDAO.insert(reserva);
	}
	
	
	/**
	 * Método para atualizar o cadastro de uma reserva.
	 * @param reserva Reserva a ter o cadastro atualizado.
	 */
	public void update (ReservaDTO reserva) throws ErroValidacao, DAOException {
		validate(reserva);
		ReservaDAO.update(reserva);
	}
	
	
	/**
	 * Método para apagar o cadastro de uma reserva do Banco.
	 * @param reserva Reserva a ser apagada.
	 */
	public void delete (ReservaDTO reserva) throws ErroValidacao, DAOException {
		validate(reserva);
		ReservaDAO.delete(reserva);
	}
	
	
	/**
	 * Método para efetuar uma busca de cadastro de reservas
	 * atravéz de um determinado cliente.
	 * @param cliente Cliente da Reserva a ser buscada.
	 * @return Retorna uma lista de Reservas com o cliente especificado.
	 * Caso nenhuma reserva for encontrada, é retornado null.
	 */
	public List<ReservaDTO> find (String cliente) throws DAOException {
		return ReservaDAO.find(cliente);
	}
}
