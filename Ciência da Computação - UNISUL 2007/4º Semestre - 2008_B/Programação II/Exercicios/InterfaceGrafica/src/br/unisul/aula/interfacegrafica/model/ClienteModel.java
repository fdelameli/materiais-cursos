package br.unisul.aula.interfacegrafica.model;

import java.util.List;

import br.unisul.aula.interfacegrafica.dao.ClienteDAO;
import br.unisul.aula.interfacegrafica.dao.DAOException;
import br.unisul.aula.interfacegrafica.dto.ClienteDTO;
import br.unisul.aula.interfacegrafica.dto.ErroValidacao;
import br.unisul.aula.interfacegrafica.util.CPFValidator;


/**
 * Classe ne negócio responsável por realizar as operações
 * de insert, delete, update e find em nível de negócio.
 * @author Fabio Dela Bruna.
 * @since 14/10/2008.
 */
public class ClienteModel extends BaseModel {
	
	
	/**
	 * Construtor default.
	 */
	public ClienteModel() {
		
	}

	
	@Override
	public void validate (Object obj) throws ErroValidacao {
		ClienteDTO cliente = (ClienteDTO) obj;
		
		if (cliente.getNome() == null || cliente.getNome().trim().length() == 0)
			throw new ErroValidacao("O campo Nome deve ser preenchido!");
		if (!CPFValidator.validaCpf( cliente.getCpf() ))
			throw new ErroValidacao("Digite um Cpf válido!");
		if (cliente.getRg() == null || cliente.getRg().trim().length() == 0)
			throw new ErroValidacao("O campo Rg deve ser preenchido!");
		if (cliente.getSexo() == ' ')
			throw new ErroValidacao("Selecione o seu Sexo!");
		if (cliente.getFone() == null || cliente.getFone().trim().length() == 0)
			throw new ErroValidacao("O campo Telefone deve ser preenchido!");
		if (cliente.getEndereco() == null || cliente.getEndereco().trim().length() == 0)
			throw new ErroValidacao("O campo Endereço deve ser preenchido!");
		if (cliente.getStatus() == 0) {
			throw new ErroValidacao("Selecione o status do cliente!");
		}
	}
	
	
	/**
	 * Método para inserir o cadastro de um cliente no Banco.
	 * @param cliente Cliente a ser inserido.
	 * @throws ErroValidacao 
	 */
	public void insert (ClienteDTO cliente) throws ErroValidacao, DAOException {
		validate(cliente);
		ClienteDAO.insert(cliente);
	}
	
	
	/**
	 * Método para atualizar o cadastro de um cliente.
	 * @param cliente Cliente a ter o cadastro atualizado.
	 */
	public void update (ClienteDTO cliente) throws ErroValidacao, DAOException {
		validate(cliente);
		ClienteDAO.update(cliente);
	}
	
	
	/**
	 * Método para apagar o cadastro de um cliente do Banco.
	 * @param cliente Cliente a ser apagado.
	 */
	public void delete (ClienteDTO cliente) throws ErroValidacao, DAOException {
		//validate(cliente);
		ClienteDAO.delete(cliente);
	}
	
	
	/**
	 * Método para efetuar uma busca de cadastro de clientes
	 * atravéz de um determinado nome.
	 * @param nome Nome do Cliente a ser buscado.
	 * @return Retorna uma lista de Clientes com o nome especificado.
	 * Caso nenhum cliente foi encontrado, é retornado null.
	 */
	public List<ClienteDTO> find (String nome) throws DAOException {
		return ClienteDAO.find(nome);
	}
	
	
	public List<ClienteDTO> listAll() throws DAOException {
		return ClienteDAO.listAll();
	}

}
