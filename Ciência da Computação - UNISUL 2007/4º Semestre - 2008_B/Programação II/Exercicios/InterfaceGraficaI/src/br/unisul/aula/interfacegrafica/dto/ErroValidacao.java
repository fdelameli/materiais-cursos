package br.unisul.aula.interfacegrafica.dto;

public class ErroValidacao extends Throwable {

	private static final long serialVersionUID = 1L;

	
	/**
	 * Construtor default.
	 */
	public ErroValidacao() {
		super();
	}
	
	/**
	 * Construtor que recebe a causa do problema.
	 * @param reason Causa do problema.
	 */
	public ErroValidacao (String reason) {
		super(reason);
	}
}
