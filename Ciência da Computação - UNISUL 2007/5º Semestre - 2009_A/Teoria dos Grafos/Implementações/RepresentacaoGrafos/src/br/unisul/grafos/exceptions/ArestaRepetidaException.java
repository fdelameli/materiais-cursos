package br.unisul.grafos.exceptions;

/**
 * Exceção que será disparada quando o usuário tentar
 * inserir uma aresta que já esteja inserida no grafo.
 * @author Fabio Dela Bruna, Marcio Ozório Teixeira.
 */
public class ArestaRepetidaException extends Exception {

	private static final long serialVersionUID = 1L;

	
	/**
	 * Construtor default.
	 * @param reason String contendo a razão da exceção ter sido disparada.
	 */
	public ArestaRepetidaException(String reason) {
		super(reason);
	}
	
}
