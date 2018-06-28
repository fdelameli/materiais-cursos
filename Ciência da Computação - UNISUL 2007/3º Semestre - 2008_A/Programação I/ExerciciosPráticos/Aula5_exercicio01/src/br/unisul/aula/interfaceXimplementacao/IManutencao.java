package br.unisul.aula.interfaceXimplementacao;


/**
 * Interface que estabelece os métodos da classe Manutencao.
 * @author Fabio Dela Bruna
 * @since 18/03/2008
 */
public interface IManutencao {
	
	
	/**
	 * Efetua o concerto do Pneu..
	 */
	public abstract void concertaPneu();
	
	
	/**
	 * Retorna se o veículo tem óleo ou não..
	 * @return String
	 */
	public abstract boolean verificaOleo();

}
