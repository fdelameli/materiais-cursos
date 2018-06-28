package br.unisul.grafos.exceptions;

/**
 * Exceção que será disparada quando o usuário tentar
 * inserir um vértice que já esteja inserido no grafo.
 * @author Fabio Dela Bruna, Marcio Ozório Teixeira.
 */
public class VerticeRepetidoException extends Exception {

	private static final long serialVersionUID = 1L;

	
	/**
	 * Construtor default.
	 * @param reason String contendo a razão da exceção ter sido disparada.
	 */
	public VerticeRepetidoException(String reason) {
		super(reason);
	}
	
}
