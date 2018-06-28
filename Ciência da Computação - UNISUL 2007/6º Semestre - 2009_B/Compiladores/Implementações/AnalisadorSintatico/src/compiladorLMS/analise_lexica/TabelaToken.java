package compiladorLMS.analise_lexica;

import java.util.ArrayList;

/**
 * Classe que armazena todos os símbolos (tokens) que são
 * reconhecidos pela gramática da linguagem LMS.
 * 
 * @author Fabio Dela Bruna, Márcio Ozório Teixeira.
 */
public class TabelaToken implements DefinicoesLexicas {

	/**
	 * Armazena os tokens da linguagem.
	 */
	private ArrayList<Token> tabelaTokens;
	

	/**
	 * Construtor que preenche a tabela de tokens.
	 */
	public TabelaToken() {
		
		tabelaTokens = new ArrayList<Token>(); // inicializa tabelaTokens.

		tabelaTokens.add( new Token(  1, SYMBOLS_TABLE.get(  0 ), PALAVRA_RESERVADA ) );
		tabelaTokens.add( new Token(  2, SYMBOLS_TABLE.get(  1 ), PALAVRA_RESERVADA ) );
		tabelaTokens.add( new Token(  3, SYMBOLS_TABLE.get(  2 ), PALAVRA_RESERVADA ) );
		tabelaTokens.add( new Token(  4, SYMBOLS_TABLE.get(  3 ), PALAVRA_RESERVADA ) );
		tabelaTokens.add( new Token(  5, SYMBOLS_TABLE.get(  4 ), PALAVRA_RESERVADA ) );
		tabelaTokens.add( new Token(  6, SYMBOLS_TABLE.get(  5 ), PALAVRA_RESERVADA ) );
		tabelaTokens.add( new Token(  7, SYMBOLS_TABLE.get(  6 ), PALAVRA_RESERVADA ) );
		tabelaTokens.add( new Token(  8, SYMBOLS_TABLE.get(  7 ), PALAVRA_RESERVADA ) );
		tabelaTokens.add( new Token(  9, SYMBOLS_TABLE.get(  8 ), PALAVRA_RESERVADA ) );
		tabelaTokens.add( new Token( 10, SYMBOLS_TABLE.get(  9 ), PALAVRA_RESERVADA ) );
		tabelaTokens.add( new Token( 11, SYMBOLS_TABLE.get( 10 ), PALAVRA_RESERVADA ) );
		tabelaTokens.add( new Token( 12, SYMBOLS_TABLE.get( 11 ), PALAVRA_RESERVADA ) );
		tabelaTokens.add( new Token( 13, SYMBOLS_TABLE.get( 12 ), PALAVRA_RESERVADA ) );
		tabelaTokens.add( new Token( 14, SYMBOLS_TABLE.get( 13 ), PALAVRA_RESERVADA ) );
		tabelaTokens.add( new Token( 15, SYMBOLS_TABLE.get( 14 ), PALAVRA_RESERVADA ) );
		tabelaTokens.add( new Token( 16, SYMBOLS_TABLE.get( 15 ), PALAVRA_RESERVADA ) );
		tabelaTokens.add( new Token( 17, SYMBOLS_TABLE.get( 16 ), PALAVRA_RESERVADA ) );
		tabelaTokens.add( new Token( 18, SYMBOLS_TABLE.get( 17 ), PALAVRA_RESERVADA ) );
		tabelaTokens.add( new Token( 19, SYMBOLS_TABLE.get( 18 ), PALAVRA_RESERVADA ) );
		tabelaTokens.add( new Token( 20, SYMBOLS_TABLE.get( 19 ), PALAVRA_RESERVADA ) );
		tabelaTokens.add( new Token( 21, SYMBOLS_TABLE.get( 20 ), PALAVRA_RESERVADA ) );
		tabelaTokens.add( new Token( 22, SYMBOLS_TABLE.get( 21 ), OPERADOR ) );
		tabelaTokens.add( new Token( 23, SYMBOLS_TABLE.get( 22 ), OPERADOR ) );
		tabelaTokens.add( new Token( 24, SYMBOLS_TABLE.get( 23 ), OPERADOR ) );
		tabelaTokens.add( new Token( 25, SYMBOLS_TABLE.get( 24 ), IDENTIFICADOR ) );
		tabelaTokens.add( new Token( 26, SYMBOLS_TABLE.get( 25 ), INTEIRO ) );
		tabelaTokens.add( new Token( 27, SYMBOLS_TABLE.get( 26 ), PALAVRA_RESERVADA ) );
		tabelaTokens.add( new Token( 28, SYMBOLS_TABLE.get( 27 ), PALAVRA_RESERVADA ) );
		tabelaTokens.add( new Token( 29, SYMBOLS_TABLE.get( 28 ), PALAVRA_RESERVADA ) );
		tabelaTokens.add( new Token( 30, SYMBOLS_TABLE.get( 29 ), OPERADOR ) );
		tabelaTokens.add( new Token( 31, SYMBOLS_TABLE.get( 30 ), OPERADOR ) );
		tabelaTokens.add( new Token( 32, SYMBOLS_TABLE.get( 31 ), OPERADOR ) );
		tabelaTokens.add( new Token( 33, SYMBOLS_TABLE.get( 32 ), OPERADOR ) );
		tabelaTokens.add( new Token( 34, SYMBOLS_TABLE.get( 33 ), SIMBOLO_ESPECIAL ) );
		tabelaTokens.add( new Token( 35, SYMBOLS_TABLE.get( 34 ), SIMBOLO_ESPECIAL ) );
		tabelaTokens.add( new Token( 36, SYMBOLS_TABLE.get( 35 ), SIMBOLO_ESPECIAL ) );
		tabelaTokens.add( new Token( 37, SYMBOLS_TABLE.get( 36 ), SIMBOLO_ESPECIAL ) );
		tabelaTokens.add( new Token( 38, SYMBOLS_TABLE.get( 37 ), OPERADOR ) );
		tabelaTokens.add( new Token( 39, SYMBOLS_TABLE.get( 38 ), SIMBOLO_ESPECIAL ) );
		tabelaTokens.add( new Token( 40, SYMBOLS_TABLE.get( 39 ), OPERADOR ) );
		tabelaTokens.add( new Token( 41, SYMBOLS_TABLE.get( 40 ), OPERADOR ) );
		tabelaTokens.add( new Token( 42, SYMBOLS_TABLE.get( 41 ), OPERADOR ) );
		tabelaTokens.add( new Token( 43, SYMBOLS_TABLE.get( 42 ), OPERADOR ) );
		tabelaTokens.add( new Token( 44, SYMBOLS_TABLE.get( 43 ), OPERADOR ) );
		tabelaTokens.add( new Token( 45, SYMBOLS_TABLE.get( 44 ), OPERADOR ) );
		tabelaTokens.add( new Token( 46, SYMBOLS_TABLE.get( 45 ), SIMBOLO_ESPECIAL ) );
		tabelaTokens.add( new Token( 47, SYMBOLS_TABLE.get( 46 ), SIMBOLO_ESPECIAL ) );
		tabelaTokens.add( new Token( 48, SYMBOLS_TABLE.get( 47 ), LITERAL ) );
		tabelaTokens.add( new Token( 49, SYMBOLS_TABLE.get( 48 ), SIMBOLO_ESPECIAL ) );
		tabelaTokens.add( new Token( 50, SYMBOLS_TABLE.get( 49 ), SIMBOLO_ESPECIAL ) );
		tabelaTokens.add( new Token( 51, SYMBOLS_TABLE.get( 50 ), FINAL_DE_ARQUIVO ) );
		
	}
	
	
	/**
	 * Retorna a tabela de tokens da linguagem LMS.
	 */
	public ArrayList<Token> getTabelaTokens() {
		return tabelaTokens;
	}
	
	
}
