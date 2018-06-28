package br.unisul.exemplo.core.bo;

import br.unisul.exemplo.core.bean.PessoaBean;
import br.unisul.exemplo.core.dao.PessoaDAO;

/**
 * Classe responsável por realizar métodos
 * de negócio referente ao objeto Pessoa.
 * 
 * @author Fabio Dela Bruna
 *
 */
public class PessoaBO {

	public void inser(PessoaBean pessoa) {
		
		PessoaDAO dao = new PessoaDAO();
		
		if (pessoa.getCodigo() == null) {
			dao.insertPessoa(pessoa);
		} else {
			//Não insere
			;
		}
	}
}
