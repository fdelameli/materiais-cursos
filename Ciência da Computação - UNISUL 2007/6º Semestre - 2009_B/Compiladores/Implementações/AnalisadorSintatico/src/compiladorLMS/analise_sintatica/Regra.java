package compiladorLMS.analise_sintatica;

import java.util.ArrayList;

/**
 * Classe interna privada que representa uma regra da tabela de parse.
 * @author Fabio Dela Bruna, Marcio Ozório Teixeira.
 */
public class Regra {

	/**
	 * Armazena o inteiro correspondente à regra.
	 */
	private int regra;
	
	/**
	 * Armazena o código do terminal correspondente.
	 */
	private int terminal;
	
	/**
	 * Armazena o código do não-terminal correspondente.
	 */
	private int naoTerminal;
	
	/**
	 * Armazena as derivações à que essa regra leva.
	 */
	private ArrayList<Integer> derivacoes;


	/**
	 * Construtor que recebe os dados por parâmetro.
	 */
	public Regra(int reg, int naoTerm, int term, ArrayList<Integer> der) {
		regra = reg;
		naoTerminal = naoTerm;
		terminal = term;
		derivacoes = der;
	}

	/**
	 * Define o formato de saída no console para os objetos do tipo Regra.
	 */
	public String toString() {
		return String.format("Regra: %s\tTerminal: %s\tNão-Terminal: %s\n",
				regra, terminal, naoTerminal);
	}

	/**
	 * Retorna a regra correspondente.
	 */
	public int getRegra() {
		return regra;
	}

	/**
	 * Retorna o terminal que faz parte da regra.
	 */
	public int getTerminal() {
		return terminal;
	}

	/**
	 * Retorna o não-terminal que faz parte da regra.
	 */
	public int getNaoTerminal() {
		return naoTerminal;
	}
	
	/**
	 * Retorna as derivaçoes à que a regra leva.
	 */
	public ArrayList<Integer> getDerivacoes() {
		return derivacoes;
	}

}
