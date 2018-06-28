package br.unisul.aula.model;

import br.unisul.aula.dto.Pessoa;
import br.unisul.aula.exception.ValidacaoException;

public class ClasseExemplo {

	public void inserePessoa(Pessoa pessoa) throws ValidacaoException {
		validate(pessoa);
	}
	
	private void validate(Pessoa pessoa) throws ValidacaoException{
		if (pessoa.getEndereco() == null)
			throw new ValidacaoException("Endereço Inválido");
		if (pessoa.getIdade() < 18)
			throw new ValidacaoException("Precisa ser maior de idade");
		if (pessoa.getNacionalidade() == null || pessoa.getNacionalidade().trim().length() == 0)
			throw new ValidacaoException("Nacionalidade incorreta");
		if (pessoa.getNome() == null || pessoa.getNome().trim().length() == 0)
			throw new ValidacaoException("Nome incorreto");
		if (pessoa.getSexo() != 'M' && pessoa.getSexo() != 'F')
			throw new ValidacaoException("Sexo desconhecido");
		
		//verificação de endereço
		if (pessoa.getEndereco().getCep() == null || pessoa.getEndereco().getCep().trim().length() == 0)
			throw new ValidacaoException("CEP inválido");
		//...continua a verificação...
		
	}


	/*
	public void metodoA() {
		metodoB();
	}

	public void metodoB() {
		metodoC();
	}
	
	public void metodoC() throws NullPointerException, ArrayIndexOutOfBoundsException {
		throw new ValidacaoException();
	//	throw new NullPointerException();
	}
	*/

}
