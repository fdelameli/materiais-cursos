package br.unisul.aula.interfacegrafica.model;

import java.util.List;

import br.unisul.aula.interfacegrafica.dao.DAOException;
import br.unisul.aula.interfacegrafica.dao.QuartoDAO;
import br.unisul.aula.interfacegrafica.dto.ErroValidacao;
import br.unisul.aula.interfacegrafica.dto.QuartoDTO;

public class QuartoModel extends BaseModel {

	
	public QuartoModel() {
		// TODO Auto-generated constructor stub
	}
	
	
	@Override
	public void validate(Object obj) throws ErroValidacao {
		QuartoDTO quartoDTO = (QuartoDTO) obj;
		
		if (quartoDTO.getNumero() <= 0)
			throw new ErroValidacao("O número do quarto deve ser maior que 0 (zero)");
		if (quartoDTO.getDescricao() == null || quartoDTO.getDescricao().trim().length() == 0)
			throw new ErroValidacao("O campo Descrição deve ser preechido");
		if (quartoDTO.getValorDiaria() <= 0) {
			throw new ErroValidacao("O valor da diária deve ser maior que 0 (zero)");
		}
	}
	
	
	/**
	 * Método para inserir o cadastro de um quarto no Banco.
	 * @param quarto Quarto a ser inserido.
	 * @throws ErroValidacao 
	 */
	public void insert (QuartoDTO quarto) throws ErroValidacao, DAOException {
		validate(quarto);
		QuartoDAO.insert(quarto);
	}
	
	
	/**
	 * Método para atualizar o cadastro de um quarto.
	 * @param quarto Quarto a ter o cadastro atualizado.
	 */
	public void update (QuartoDTO quarto) throws ErroValidacao, DAOException {
		validate(quarto);
		QuartoDAO.insert(quarto);
	}
	
	
	/**
	 * Método para apagar o cadastro de um quarto do Banco.
	 * @param quarto Quarto a ser apagado.
	 */
	public void delete (QuartoDTO quarto) throws ErroValidacao, DAOException {
		QuartoDAO.delete(quarto);
	}
	
	
	/**
	 * Método para efetuar uma busca de cadastro de quartos
	 * atravéz de um determinado número.
	 * @return Retorna uma lista de Quato.
	 * Caso nenhum quarto for encontrado, é retornado null.
	 */
	public List<QuartoDTO> find () throws DAOException {
		return QuartoDAO.find();
	}

}
