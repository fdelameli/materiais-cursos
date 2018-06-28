package meubanco.service;

import meubanco.dao.PessoaDAO;
import framework.service.ServiceBase;

/**
 * Classe de serviço responsável por fazer a ligação entre
 * a camada de negócio e a camada de banco de dados.
 * 
 * @author Fabio Dela Bruna
 * @since 26/10/2008.
 */
public class PessoaService extends ServiceBase {
	
	/**
	 * Construtor default.
	 * @throws Exception
	 */
	public PessoaService() throws Exception {
		super(new PessoaDAO());
	}
	
}
