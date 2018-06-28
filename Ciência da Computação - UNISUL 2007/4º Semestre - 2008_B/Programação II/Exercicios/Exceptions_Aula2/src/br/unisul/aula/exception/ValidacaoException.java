package br.unisul.aula.exception;

/**
 * Classe que expressa um erro de validação.
 * Geralmente utilizada no método validate();
 * 
 * @author Fabio Dela Bruna
 * @since 05/08/2008
 */
public class ValidacaoException extends Exception {
	
	public ValidacaoException() {
		super();
	}
	
	public ValidacaoException(String reason) {
		super(reason);
	}

}
