package br.unisul.exemplo.core.dao;

import br.unisul.exemplo.core.bean.PessoaBean;

/**
 * Classe referente a executar métodos
 * que acessem a base de dados
 * manipulando o objeto PessoaBean.
 * 
 * @author Fabio Dela Bruna
 *
 */
public class PessoaDAO {

	public void insertPessoa(PessoaBean pessoa) {
		
		String sql = "INSERT INTO Pessoa (codigo, ...)";
		
		//Insere no banco o objeto pessoa.
	}
}
