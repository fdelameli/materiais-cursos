package compiladorLMS.analise_sintatica;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Classe que representa as definições da gramática.
 * Tais como: a gramática em si, e a tabela de parse.
 * @author Fabio Dela Bruna, Marcio Ozório Teixeira.
 */
public class DefinicoesSintaticas {

	/**
	 * Estrutura que armazena as regras da tabela de parse
	 * correspondente à gramática LMS.
	 */
	private ArrayList<Regra> tabelaDeParse;

	
	/**
	 * Construtor que inicializa o ArrayList tabelaDeParse e preenche a tabela com as regras.
	 * Também preenche a tabela de derivação dos nao-terminais.
	 */
	public DefinicoesSintaticas() {

		// PREENCHE A TABELA DE PARSE E AS DERIVAÇÕES DE CADA REGRA
		
		tabelaDeParse = new ArrayList<Regra>();
		
		tabelaDeParse.add( new Regra(  1, 52,  1, new ArrayList<Integer>(Arrays.asList( 1,25,47,53,49) ) ) );
		tabelaDeParse.add( new Regra(  2, 53,  2, new ArrayList<Integer>(Arrays.asList(54,57,59,62,64) ) ) );
		tabelaDeParse.add( new Regra(  2, 53,  3, new ArrayList<Integer>(Arrays.asList(54,57,59,62,64) ) ) );
		tabelaDeParse.add( new Regra(  2, 53,  4, new ArrayList<Integer>(Arrays.asList(54,57,59,62,64) ) ) );
		tabelaDeParse.add( new Regra(  2, 53,  5, new ArrayList<Integer>(Arrays.asList(54,57,59,62,64) ) ) );
		tabelaDeParse.add( new Regra(  2, 53,  6, new ArrayList<Integer>(Arrays.asList(54,57,59,62,64) ) ) );
		tabelaDeParse.add( new Regra(  3, 54,  2, new ArrayList<Integer>(Arrays.asList( 2,55,47) ) ) );
		tabelaDeParse.add( new Regra(  4, 55, 25, new ArrayList<Integer>(Arrays.asList(25,56) ) ) );
		tabelaDeParse.add( new Regra(  5, 56, 39, new ArrayList<Integer>(Arrays.asList( 0) ) ) );
		tabelaDeParse.add( new Regra(  5, 56, 47, new ArrayList<Integer>(Arrays.asList( 0) ) ) );
		tabelaDeParse.add( new Regra(  6, 56, 46, new ArrayList<Integer>(Arrays.asList(46,25,56) ) ) );
		tabelaDeParse.add( new Regra(  7, 54,  3, new ArrayList<Integer>(Arrays.asList( 0) ) ) );
		tabelaDeParse.add( new Regra(  7, 54,  4, new ArrayList<Integer>(Arrays.asList( 0) ) ) );
		tabelaDeParse.add( new Regra(  7, 54,  5, new ArrayList<Integer>(Arrays.asList( 0) ) ) );
		tabelaDeParse.add( new Regra(  7, 54,  6, new ArrayList<Integer>(Arrays.asList( 0) ) ) );
		tabelaDeParse.add( new Regra(  8, 57,  3, new ArrayList<Integer>(Arrays.asList( 3,25,40,26,47,58) ) ) );
		tabelaDeParse.add( new Regra(  9, 58,  4, new ArrayList<Integer>(Arrays.asList( 0) ) ) );
		tabelaDeParse.add( new Regra(  9, 58,  5, new ArrayList<Integer>(Arrays.asList( 0) ) ) );
		tabelaDeParse.add( new Regra(  9, 58,  6, new ArrayList<Integer>(Arrays.asList( 0) ) ) );
		tabelaDeParse.add( new Regra( 10, 58, 25, new ArrayList<Integer>(Arrays.asList(25,40,26,47,58) ) ) );
		tabelaDeParse.add( new Regra( 11, 57,  4, new ArrayList<Integer>(Arrays.asList( 0) ) ) );
		tabelaDeParse.add( new Regra( 11, 57,  5, new ArrayList<Integer>(Arrays.asList( 0) ) ) );
		tabelaDeParse.add( new Regra( 11, 57,  6, new ArrayList<Integer>(Arrays.asList( 0) ) ) );
		tabelaDeParse.add( new Regra( 12, 59,  4, new ArrayList<Integer>(Arrays.asList( 4,55,39,61,47,60) ) ) );
		tabelaDeParse.add( new Regra( 13, 60,  5, new ArrayList<Integer>(Arrays.asList( 0) ) ) );
		tabelaDeParse.add( new Regra( 13, 60,  6, new ArrayList<Integer>(Arrays.asList( 0) ) ) );
		tabelaDeParse.add( new Regra( 14, 60, 25, new ArrayList<Integer>(Arrays.asList(55,39,61,47,60) ) ) );
		tabelaDeParse.add( new Regra( 15, 59,  5, new ArrayList<Integer>(Arrays.asList( 0) ) ) );
		tabelaDeParse.add( new Regra( 15, 59,  6, new ArrayList<Integer>(Arrays.asList( 0) ) ) );
		tabelaDeParse.add( new Regra( 16, 61,  8, new ArrayList<Integer>(Arrays.asList( 8) ) ) );
		tabelaDeParse.add( new Regra( 17, 61,  9, new ArrayList<Integer>(Arrays.asList( 9,34,26,50,26,35,10, 8) ) ) );
		tabelaDeParse.add( new Regra( 18, 62,  5, new ArrayList<Integer>(Arrays.asList( 5,25,63,47,53,47,62) ) ) );
		tabelaDeParse.add( new Regra( 19, 62,  6, new ArrayList<Integer>(Arrays.asList( 0) ) ) );
		tabelaDeParse.add( new Regra( 20, 63, 47, new ArrayList<Integer>(Arrays.asList( 0) ) ) );
		tabelaDeParse.add( new Regra( 21, 63, 36, new ArrayList<Integer>(Arrays.asList(36,55,39,8,37) ) ) );
		tabelaDeParse.add( new Regra( 22, 64,  6, new ArrayList<Integer>(Arrays.asList( 6,66,65, 7) ) ) );
		tabelaDeParse.add( new Regra( 23, 65,  7, new ArrayList<Integer>(Arrays.asList( 0) ) ) );
		tabelaDeParse.add( new Regra( 24, 65, 47, new ArrayList<Integer>(Arrays.asList(47,66,65) ) ) );
		tabelaDeParse.add( new Regra( 25, 66, 25, new ArrayList<Integer>(Arrays.asList(25,67) ) ) );
		tabelaDeParse.add( new Regra( 26, 67, 39, new ArrayList<Integer>(Arrays.asList(39,66) ) ) );
		tabelaDeParse.add( new Regra( 27, 67, 34, new ArrayList<Integer>(Arrays.asList(68,38,77) ) ) );
		tabelaDeParse.add( new Regra( 27, 67, 38, new ArrayList<Integer>(Arrays.asList(68,38,77) ) ) );
		tabelaDeParse.add( new Regra( 28, 68, 38, new ArrayList<Integer>(Arrays.asList( 0) ) ) );
		tabelaDeParse.add( new Regra( 29, 68, 34, new ArrayList<Integer>(Arrays.asList(34,77,35) ) ) );
		tabelaDeParse.add( new Regra( 30, 66,  6, new ArrayList<Integer>(Arrays.asList(64) ) ) );
		tabelaDeParse.add( new Regra( 31, 66,  7, new ArrayList<Integer>(Arrays.asList( 0) ) ) );
		tabelaDeParse.add( new Regra( 31, 66, 15, new ArrayList<Integer>(Arrays.asList( 0) ) ) );
		tabelaDeParse.add( new Regra( 31, 66, 19, new ArrayList<Integer>(Arrays.asList( 0) ) ) );
		tabelaDeParse.add( new Regra( 31, 66, 47, new ArrayList<Integer>(Arrays.asList( 0) ) ) );
		tabelaDeParse.add( new Regra( 32, 66, 11, new ArrayList<Integer>(Arrays.asList(11,25,69) ) ) );
		tabelaDeParse.add( new Regra( 33, 69,  7, new ArrayList<Integer>(Arrays.asList( 0) ) ) );
		tabelaDeParse.add( new Regra( 33, 69, 15, new ArrayList<Integer>(Arrays.asList( 0) ) ) );
		tabelaDeParse.add( new Regra( 33, 69, 19, new ArrayList<Integer>(Arrays.asList( 0) ) ) );
		tabelaDeParse.add( new Regra( 33, 69, 47, new ArrayList<Integer>(Arrays.asList( 0) ) ) );
		tabelaDeParse.add( new Regra( 34, 69, 36, new ArrayList<Integer>(Arrays.asList(36,77,70,37) ) ) );
		tabelaDeParse.add( new Regra( 35, 70, 37, new ArrayList<Integer>(Arrays.asList( 0) ) ) );
		tabelaDeParse.add( new Regra( 36, 70, 46, new ArrayList<Integer>(Arrays.asList(46,77,70) ) ) );
		tabelaDeParse.add( new Regra( 37, 66, 12, new ArrayList<Integer>(Arrays.asList(12,25) ) ) );
		tabelaDeParse.add( new Regra( 38, 66, 13, new ArrayList<Integer>(Arrays.asList(13,77,14,66,71) ) ) );
		tabelaDeParse.add( new Regra( 39, 71,  7, new ArrayList<Integer>(Arrays.asList( 0) ) ) );
		tabelaDeParse.add( new Regra( 39, 71, 19, new ArrayList<Integer>(Arrays.asList( 0) ) ) );
		tabelaDeParse.add( new Regra( 39, 71, 47, new ArrayList<Integer>(Arrays.asList( 0) ) ) );
		tabelaDeParse.add( new Regra( 40, 71, 15, new ArrayList<Integer>(Arrays.asList(15,66) ) ) );
		tabelaDeParse.add( new Regra( 41, 66, 16, new ArrayList<Integer>(Arrays.asList(16,77,17,66) ) ) );
		tabelaDeParse.add( new Regra( 42, 66, 18, new ArrayList<Integer>(Arrays.asList(18,66,19,77) ) ) );
		tabelaDeParse.add( new Regra( 43, 66, 20, new ArrayList<Integer>(Arrays.asList(20,36,72,74,37) ) ) );
		tabelaDeParse.add( new Regra( 44, 72, 25, new ArrayList<Integer>(Arrays.asList(25,73) ) ) );
		tabelaDeParse.add( new Regra( 45, 73,  7, new ArrayList<Integer>(Arrays.asList( 0) ) ) );
		tabelaDeParse.add( new Regra( 45, 73, 10, new ArrayList<Integer>(Arrays.asList( 0) ) ) );
		tabelaDeParse.add( new Regra( 45, 73, 14, new ArrayList<Integer>(Arrays.asList( 0) ) ) );
		tabelaDeParse.add( new Regra( 45, 73, 15, new ArrayList<Integer>(Arrays.asList( 0) ) ) );
		tabelaDeParse.add( new Regra( 45, 73, 17, new ArrayList<Integer>(Arrays.asList( 0) ) ) );
		tabelaDeParse.add( new Regra( 45, 73, 19, new ArrayList<Integer>(Arrays.asList( 0) ) ) );
		tabelaDeParse.add( new Regra( 45, 73, 22, new ArrayList<Integer>(Arrays.asList( 0) ) ) );
		tabelaDeParse.add( new Regra( 45, 73, 23, new ArrayList<Integer>(Arrays.asList( 0) ) ) );
		tabelaDeParse.add( new Regra( 45, 73, 28, new ArrayList<Integer>(Arrays.asList( 0) ) ) );
		tabelaDeParse.add( new Regra( 45, 73, 30, new ArrayList<Integer>(Arrays.asList( 0) ) ) );
		tabelaDeParse.add( new Regra( 45, 73, 31, new ArrayList<Integer>(Arrays.asList( 0) ) ) );
		tabelaDeParse.add( new Regra( 45, 73, 32, new ArrayList<Integer>(Arrays.asList( 0) ) ) );
		tabelaDeParse.add( new Regra( 45, 73, 33, new ArrayList<Integer>(Arrays.asList( 0) ) ) );
		tabelaDeParse.add( new Regra( 45, 73, 35, new ArrayList<Integer>(Arrays.asList( 0) ) ) );
		tabelaDeParse.add( new Regra( 45, 73, 37, new ArrayList<Integer>(Arrays.asList( 0) ) ) );
		tabelaDeParse.add( new Regra( 45, 73, 40, new ArrayList<Integer>(Arrays.asList( 0) ) ) );
		tabelaDeParse.add( new Regra( 45, 73, 41, new ArrayList<Integer>(Arrays.asList( 0) ) ) );
		tabelaDeParse.add( new Regra( 45, 73, 42, new ArrayList<Integer>(Arrays.asList( 0) ) ) );
		tabelaDeParse.add( new Regra( 45, 73, 43, new ArrayList<Integer>(Arrays.asList( 0) ) ) );
		tabelaDeParse.add( new Regra( 45, 73, 44, new ArrayList<Integer>(Arrays.asList( 0) ) ) );
		tabelaDeParse.add( new Regra( 45, 73, 45, new ArrayList<Integer>(Arrays.asList( 0) ) ) );
		tabelaDeParse.add( new Regra( 45, 73, 46, new ArrayList<Integer>(Arrays.asList( 0) ) ) );
		tabelaDeParse.add( new Regra( 45, 73, 47, new ArrayList<Integer>(Arrays.asList( 0) ) ) );
		tabelaDeParse.add( new Regra( 46, 73, 34, new ArrayList<Integer>(Arrays.asList(34,77,35) ) ) );
		tabelaDeParse.add( new Regra( 47, 74, 37, new ArrayList<Integer>(Arrays.asList( 0) ) ) );
		tabelaDeParse.add( new Regra( 48, 74, 46, new ArrayList<Integer>(Arrays.asList(46,72,74) ) ) );
		tabelaDeParse.add( new Regra( 49, 66, 21, new ArrayList<Integer>(Arrays.asList(21,36,75,76,37) ) ) );
		tabelaDeParse.add( new Regra( 50, 75, 48, new ArrayList<Integer>(Arrays.asList(48) ) ) );
		tabelaDeParse.add( new Regra( 51, 75, 24, new ArrayList<Integer>(Arrays.asList(77) )) );
		tabelaDeParse.add( new Regra( 51, 75, 25, new ArrayList<Integer>(Arrays.asList(77) ) ) );
		tabelaDeParse.add( new Regra( 51, 75, 26, new ArrayList<Integer>(Arrays.asList(77) ) ) );
		tabelaDeParse.add( new Regra( 51, 75, 30, new ArrayList<Integer>(Arrays.asList(77) ) ) );
		tabelaDeParse.add( new Regra( 51, 75, 31, new ArrayList<Integer>(Arrays.asList(77) ) ) );
		tabelaDeParse.add( new Regra( 51, 75, 36, new ArrayList<Integer>(Arrays.asList(77) ) ) );
		tabelaDeParse.add( new Regra( 52, 76, 37, new ArrayList<Integer>(Arrays.asList( 0) ) ) );
		tabelaDeParse.add( new Regra( 53, 76, 46, new ArrayList<Integer>(Arrays.asList(46,75,76) ) ) );
		tabelaDeParse.add( new Regra( 54, 66, 29, new ArrayList<Integer>(Arrays.asList(29,77,10,84,7) ) ) );
		tabelaDeParse.add( new Regra( 55, 84, 26, new ArrayList<Integer>(Arrays.asList(26,86,39,66,85) ) ) );
		tabelaDeParse.add( new Regra( 56, 86, 46, new ArrayList<Integer>(Arrays.asList(46,26,86) ) ) );
		tabelaDeParse.add( new Regra( 57, 86, 39, new ArrayList<Integer>(Arrays.asList( 0) ) ) );
		tabelaDeParse.add( new Regra( 58, 85,  7, new ArrayList<Integer>(Arrays.asList( 0) ) ) );
		tabelaDeParse.add( new Regra( 59, 85, 47, new ArrayList<Integer>(Arrays.asList(47,84) ) ) );
		tabelaDeParse.add( new Regra( 60, 66, 27, new ArrayList<Integer>(Arrays.asList(27,25,38,77,28,77,17,66) ) ) );
		tabelaDeParse.add( new Regra( 61, 77, 24, new ArrayList<Integer>(Arrays.asList(79,78) ) ) );
		tabelaDeParse.add( new Regra( 61, 77, 25, new ArrayList<Integer>(Arrays.asList(79,78) ) ) );
		tabelaDeParse.add( new Regra( 61, 77, 26, new ArrayList<Integer>(Arrays.asList(79,78) ) ) );
		tabelaDeParse.add( new Regra( 61, 77, 30, new ArrayList<Integer>(Arrays.asList(79,78) ) ) );
		tabelaDeParse.add( new Regra( 61, 77, 31, new ArrayList<Integer>(Arrays.asList(79,78) ) ) );
		tabelaDeParse.add( new Regra( 61, 77, 36, new ArrayList<Integer>(Arrays.asList(79,78) ) ) );
		tabelaDeParse.add( new Regra( 62, 78,  7, new ArrayList<Integer>(Arrays.asList( 0) ) ) );
		tabelaDeParse.add( new Regra( 62, 78, 10, new ArrayList<Integer>(Arrays.asList( 0) ) ) );
		tabelaDeParse.add( new Regra( 62, 78, 14, new ArrayList<Integer>(Arrays.asList( 0) ) ) );
		tabelaDeParse.add( new Regra( 62, 78, 15, new ArrayList<Integer>(Arrays.asList( 0) ) ) );
		tabelaDeParse.add( new Regra( 62, 78, 17, new ArrayList<Integer>(Arrays.asList( 0) ) ) );
		tabelaDeParse.add( new Regra( 62, 78, 19, new ArrayList<Integer>(Arrays.asList( 0) ) ) );
		tabelaDeParse.add( new Regra( 62, 78, 28, new ArrayList<Integer>(Arrays.asList( 0) ) ) );
		tabelaDeParse.add( new Regra( 62, 78, 35, new ArrayList<Integer>(Arrays.asList( 0) ) ) );
		tabelaDeParse.add( new Regra( 62, 78, 37, new ArrayList<Integer>(Arrays.asList( 0) ) ) );
		tabelaDeParse.add( new Regra( 62, 78, 46, new ArrayList<Integer>(Arrays.asList( 0) ) ) );
		tabelaDeParse.add( new Regra( 62, 78, 47, new ArrayList<Integer>(Arrays.asList( 0) ) ) );
		tabelaDeParse.add( new Regra( 63, 78, 40, new ArrayList<Integer>(Arrays.asList(40,79) ) ) );
		tabelaDeParse.add( new Regra( 64, 78, 43, new ArrayList<Integer>(Arrays.asList(43,79) ) ) );
		tabelaDeParse.add( new Regra( 65, 78, 41, new ArrayList<Integer>(Arrays.asList(41,79) ) ) );
		tabelaDeParse.add( new Regra( 66, 78, 42, new ArrayList<Integer>(Arrays.asList(42,79) ) ) );
		tabelaDeParse.add( new Regra( 67, 78, 44, new ArrayList<Integer>(Arrays.asList(44,79) ) ) );
		tabelaDeParse.add( new Regra( 68, 78, 45, new ArrayList<Integer>(Arrays.asList(45,79) ) ) );
		tabelaDeParse.add( new Regra( 69, 79, 30, new ArrayList<Integer>(Arrays.asList(30,81,80) ) ) );
		tabelaDeParse.add( new Regra( 70, 79, 31, new ArrayList<Integer>(Arrays.asList(31,81,80) ) ) );
		tabelaDeParse.add( new Regra( 71, 79, 24, new ArrayList<Integer>(Arrays.asList(81,80) ) ) );
		tabelaDeParse.add( new Regra( 71, 79, 25, new ArrayList<Integer>(Arrays.asList(81,80) ) ) );
		tabelaDeParse.add( new Regra( 71, 79, 26, new ArrayList<Integer>(Arrays.asList(81,80) ) ) );
		tabelaDeParse.add( new Regra( 71, 79, 36, new ArrayList<Integer>(Arrays.asList(81,80) ) ) );
		tabelaDeParse.add( new Regra( 72, 80, 30, new ArrayList<Integer>(Arrays.asList(30,81,80) ) ) );
		tabelaDeParse.add( new Regra( 73, 80, 31, new ArrayList<Integer>(Arrays.asList(31,81,80) )) );
		tabelaDeParse.add( new Regra( 74, 80, 22, new ArrayList<Integer>(Arrays.asList(22,81,80) ) ) );
		tabelaDeParse.add( new Regra( 75, 80,  7, new ArrayList<Integer>(Arrays.asList(0) ) ) );
		tabelaDeParse.add( new Regra( 75, 80, 10, new ArrayList<Integer>(Arrays.asList(0) ) ) );
		tabelaDeParse.add( new Regra( 75, 80, 14, new ArrayList<Integer>(Arrays.asList(0) ) ) );
		tabelaDeParse.add( new Regra( 75, 80, 15, new ArrayList<Integer>(Arrays.asList(0) ) ) );
		tabelaDeParse.add( new Regra( 75, 80, 17, new ArrayList<Integer>(Arrays.asList(0) ) ) );
		tabelaDeParse.add( new Regra( 75, 80, 19, new ArrayList<Integer>(Arrays.asList(0) ) ) );
		tabelaDeParse.add( new Regra( 75, 80, 28, new ArrayList<Integer>(Arrays.asList(0) ) ) );
		tabelaDeParse.add( new Regra( 75, 80, 35, new ArrayList<Integer>(Arrays.asList(0) ) ) );
		tabelaDeParse.add( new Regra( 75, 80, 37, new ArrayList<Integer>(Arrays.asList(0) ) ) );
		tabelaDeParse.add( new Regra( 75, 80, 40, new ArrayList<Integer>(Arrays.asList(0) ) ) );
		tabelaDeParse.add( new Regra( 75, 80, 41, new ArrayList<Integer>(Arrays.asList(0) ) ) );
		tabelaDeParse.add( new Regra( 75, 80, 42, new ArrayList<Integer>(Arrays.asList(0) ) ) );
		tabelaDeParse.add( new Regra( 75, 80, 43, new ArrayList<Integer>(Arrays.asList(0) ) ) );
		tabelaDeParse.add( new Regra( 75, 80, 44, new ArrayList<Integer>(Arrays.asList(0) ) ) );
		tabelaDeParse.add( new Regra( 75, 80, 45, new ArrayList<Integer>(Arrays.asList(0) ) ) );
		tabelaDeParse.add( new Regra( 75, 80, 46, new ArrayList<Integer>(Arrays.asList(0) ) ) );
		tabelaDeParse.add( new Regra( 75, 80, 47, new ArrayList<Integer>(Arrays.asList(0) ) ) );
		tabelaDeParse.add( new Regra( 76, 81, 24, new ArrayList<Integer>(Arrays.asList(83,82) ) ) );
		tabelaDeParse.add( new Regra( 76, 81, 25, new ArrayList<Integer>(Arrays.asList(83,82) ) ) );
		tabelaDeParse.add( new Regra( 76, 81, 26, new ArrayList<Integer>(Arrays.asList(83,82) ) ) );
		tabelaDeParse.add( new Regra( 76, 81, 36, new ArrayList<Integer>(Arrays.asList(83,82) ) ) );
		tabelaDeParse.add( new Regra( 77, 82,  7, new ArrayList<Integer>(Arrays.asList(0) ) ) );
		tabelaDeParse.add( new Regra( 77, 82, 10, new ArrayList<Integer>(Arrays.asList(0) ) ) );
		tabelaDeParse.add( new Regra( 77, 82, 14, new ArrayList<Integer>(Arrays.asList(0) ) ) );
		tabelaDeParse.add( new Regra( 77, 82, 15, new ArrayList<Integer>(Arrays.asList(0) ) ) );
		tabelaDeParse.add( new Regra( 77, 82, 17, new ArrayList<Integer>(Arrays.asList(0) ) ) );
		tabelaDeParse.add( new Regra( 77, 82, 19, new ArrayList<Integer>(Arrays.asList(0) ) ) );
		tabelaDeParse.add( new Regra( 77, 82, 22, new ArrayList<Integer>(Arrays.asList(0) ) ) );
		tabelaDeParse.add( new Regra( 77, 82, 28, new ArrayList<Integer>(Arrays.asList(0) ) ) );
		tabelaDeParse.add( new Regra( 77, 82, 30, new ArrayList<Integer>(Arrays.asList(0) ) ) );
		tabelaDeParse.add( new Regra( 77, 82, 31, new ArrayList<Integer>(Arrays.asList(0) ) ) );
		tabelaDeParse.add( new Regra( 77, 82, 35, new ArrayList<Integer>(Arrays.asList(0) ) ) );
		tabelaDeParse.add( new Regra( 77, 82, 37, new ArrayList<Integer>(Arrays.asList(0) ) ) );
		tabelaDeParse.add( new Regra( 77, 82, 40, new ArrayList<Integer>(Arrays.asList(0) ) ) );
		tabelaDeParse.add( new Regra( 77, 82, 41, new ArrayList<Integer>(Arrays.asList(0) ) ) );
		tabelaDeParse.add( new Regra( 77, 82, 42, new ArrayList<Integer>(Arrays.asList(0) ) ) );
		tabelaDeParse.add( new Regra( 77, 82, 43, new ArrayList<Integer>(Arrays.asList(0) ) ) );
		tabelaDeParse.add( new Regra( 77, 82, 44, new ArrayList<Integer>(Arrays.asList(0) ) ) );
		tabelaDeParse.add( new Regra( 77, 82, 45, new ArrayList<Integer>(Arrays.asList(0) ) ) );
		tabelaDeParse.add( new Regra( 77, 82, 46, new ArrayList<Integer>(Arrays.asList(0) ) ) );
		tabelaDeParse.add( new Regra( 77, 82, 47, new ArrayList<Integer>(Arrays.asList(0) ) ) );
		tabelaDeParse.add( new Regra( 78, 82, 32, new ArrayList<Integer>(Arrays.asList(32,83,82) ) ) );
		tabelaDeParse.add( new Regra( 79, 82, 33, new ArrayList<Integer>(Arrays.asList(33,83,82) ) ) );
		tabelaDeParse.add( new Regra( 80, 82, 23, new ArrayList<Integer>(Arrays.asList(23,83,82) ) ) );
		tabelaDeParse.add( new Regra( 81, 83, 26, new ArrayList<Integer>(Arrays.asList(26) ) ) );
		tabelaDeParse.add( new Regra( 82, 83, 24, new ArrayList<Integer>(Arrays.asList(36,77,37) ) ) );
		tabelaDeParse.add( new Regra( 83, 83, 24, new ArrayList<Integer>(Arrays.asList(24,83) ) ) );
		tabelaDeParse.add( new Regra( 84, 83, 25, new ArrayList<Integer>(Arrays.asList(72) ) ) );
		
	}

	
	/**
	 * Retorna a tabelaDeParse.
	 */
	public ArrayList<Regra> getTabelaDeParse() {
		return tabelaDeParse;
	}

	
}
