package compiladorLMS.analise_lexica;

import java.util.ArrayList;


/**
 * Classe que faz a varredura no programa para
 * verificar e identificar os tokens válidos.
 * 
 * @author Fabio Dela Bruna, Marcio Ozório Teixeira.
 * 
 */
public class AnalisadorLexico implements DefinicoesLexicas {

	
	/**
	 * Armazena o programa-fonte digitado pelo usuário.
	 */
	private String programa;
	
	/**
	 * Variável que armazena todo o log do sistema.
	 */
	private String log;

	/**
	 * Contador que é utilizado para controle do loop
	 * realizado para percorrer todo o programa-fonte.
	 */
	private int count;

	/**
	 * Armazena a quantidade de linhas. A cada caracter
	 * especial do tipo "\n", é incrementado a variável.
	 */
	private int line;

	/**
	 * Armazena temporariamente cada token que é reconhecido.
	 * Após um token ser reconhecido, é setado "" (vazio) para ela.
	 */
	private String token;

	
	/**
	 * Armazena os tokens reconhecidos durante a análise léxica.
	 */
	private ArrayList<Token> tabelaTokens;
	
	
	
	/**
	 * Construtor da classe Analisador.
	 */
	public AnalisadorLexico() {
		this.programa = "";
		this.log = "";
		this.token = "";
		this.count = 0;
		this.line = 1;
		this.tabelaTokens = new ArrayList<Token>();
	}



	/**
	 * Método responsável por percorrer todo o
	 * programa e reconhecer os tokens válidos.
	 */
	public ArrayList<Token> efetuarAnalise(String prog) {
		this.programa = prog;

		String c = "";
		if (!programa.isEmpty()) {
			c = getNextChar();
		}
	
		// Efetua um loop para percorrer todo o programa-fonte.
		while (this.count < programa.length()) {

			// Identifica caracteres de texto digitados.
			if (isLetter(c)) {
				do {
					token += c;
					if (isEndOfFile()) { break; }
					c = getNextChar();
					if (isDelimitator(c)) { break; }
				} while (isLetter(c) || isNumber(c));

				if (RESERVED_WORDS_TABLE.contains(token.toUpperCase())) {
					tabelaTokens.add( new Token( (SYMBOLS_TABLE.indexOf(token.toUpperCase())+1), token, PALAVRA_RESERVADA ) );
				
				} else if (OPERATORS_TABLE.contains(token.toUpperCase())) {
					tabelaTokens.add( new Token( (SYMBOLS_TABLE.indexOf(token.toUpperCase())+1), token, OPERADOR ) );

				} else {
					// Verifica se o identificador tem mais de 30 caracteres.
					if (token.length() > 30) { 
						tabelaTokens.add( new Token( (SYMBOLS_TABLE.indexOf(IDENTIFICADOR)+1), token.substring(0,30), IDENTIFICADOR ) ); // considera somente os 30 primeiros caracteres
						log += "Identificador com " + token.length() + " caracteres encontrado na linha " + line + ".\n";
					} else {
						tabelaTokens.add( new Token( (SYMBOLS_TABLE.indexOf(IDENTIFICADOR)+1), token, IDENTIFICADOR ) );
					}
				}
				setVazio();
			}

			// Identifica os números inteiros.
			else if (isNumber(c)) {
				do {
					token += c;
					if (isEndOfFile()) {break;}
					c = getNextChar();
					if (isDelimitator(c)) {break;}
				} while (isNumber(c));
				// Verifica se o número está na faxa de -32767 a 32767.
				if (Long.parseLong(token) < -32767 || Long.parseLong(token) > 32767) {
					log += "Inteiro fora da faixa encontrado na linha " + line + ".\n";
				}
				tabelaTokens.add( new Token( (SYMBOLS_TABLE.indexOf(INTEIRO)+1), token, INTEIRO ) );
				setVazio();
			}
			
			// Verifica se existem dois caracteres aspas (") para que seja um literal.
			else if (isAspas(c) && programa.indexOf("\"", count+1) > 0) {
				int aspa2 = programa.indexOf("\"", count+1);
				do {
					token += c;
					if (isEndOfFile()) {break;}
					c = getNextChar();
				} while (count != aspa2+1);
				// Verifica se o literal tem mais de 255 caracteres (ignorando aspas).
				if (token.length()-2 > 255) {
					tabelaTokens.add( new Token( SYMBOLS_TABLE.indexOf(LITERAL)+1, token.substring(0, 255), LITERAL ) );
					log += "Literal com mais de 255 caracteres encontrado na linha " + line + ".\n";
				} else {
					tabelaTokens.add( new Token( SYMBOLS_TABLE.indexOf(LITERAL)+1, token, LITERAL ) );
				}
				setVazio();
			}
			
			// Verifica se existe um "(*" e um "*)" para que seja um comentário.
			else if ((isAbrePar(c) && isAsterisco(""+programa.charAt(count+1)) && programa.indexOf("*)", count+1) > 0)) {
				int fechPar = programa.indexOf("*)", count+1);
				do {
					token += c;
					if (isEndOfFile()) {break;}
					c = getNextChar();
				} while (count != fechPar+2);
				setVazio();
				log += "Encontrado um comentário na linha " + line;
			}

			// Identifica os símbolos especiais.
			else if (isSpecialSymbols(c)) {
				do {
					String temp = c;
					token = c;
					try {
						if (isDot(""+programa.charAt(count+1)) && isDot(temp) && (count+1 != programa.length())) {
							++count;
							token += c;
							tabelaTokens.add( new Token( SYMBOLS_TABLE.indexOf(token)+1, token, SIMBOLO_ESPECIAL ) );
							if (isEndOfFile()) {break;}
							c = getNextChar();
							setVazio();
						} 
						else if (isIgual(""+programa.charAt(count+1)) && isDoisPontos(temp) && (count+1 != programa.length())) {
							++count;
							token += "=";
							tabelaTokens.add( new Token( SYMBOLS_TABLE.indexOf(token)+1, token, OPERADOR ) );
							if (isEndOfFile()) {break;}
							c = getNextChar();
							setVazio();	
						}
						else
						{
							tabelaTokens.add( new Token( SYMBOLS_TABLE.indexOf(token)+1, token, SIMBOLO_ESPECIAL ) );
							if (isEndOfFile()) {break;}
							c = getNextChar();
							setVazio();
						}
					} catch (StringIndexOutOfBoundsException e) {
						tabelaTokens.add( new Token( SYMBOLS_TABLE.indexOf(token)+1, token, SIMBOLO_ESPECIAL ) );
						if (isEndOfFile()) {break;}
						c = getNextChar();
						setVazio();
					}
				} while (isSpecialSymbols(c));
			}

			// Identifica os operadores.
			else if (isOperator(c)) {
				do {
					String temp = c;
					token = c;
					try {
						if (isIgual(""+programa.charAt(count+1)) && isDoisPontos(temp) && (count+1 != programa.length())) {
							++count;
							token += "=";
							tabelaTokens.add( new Token( SYMBOLS_TABLE.indexOf(token)+1, token, OPERADOR ) );
							if (isEndOfFile()) {break;}
							c = getNextChar();
							setVazio();	
						}
						else if (isMaiorQue(""+programa.charAt(count+1)) && isMenorQue(temp) && (count+1 != programa.length())) {
							++count;
							token += ">";
							tabelaTokens.add( new Token( SYMBOLS_TABLE.indexOf(token)+1, token, OPERADOR ) );
							if (isEndOfFile()) {break;}
							c = getNextChar();
							setVazio();
						} 
						else if (isIgual(""+programa.charAt(count+1)) && isMenorQue(temp) && (count+1 != programa.length())) {
							++count;
							token += "=";
							tabelaTokens.add( new Token( SYMBOLS_TABLE.indexOf(token)+1, token, OPERADOR ) );
							if (isEndOfFile()) {break;}
							c = getNextChar();
							setVazio();	
						}
						else if (isIgual(""+programa.charAt(count+1)) && isMaiorQue(temp) && (count+1 != programa.length())) {
							++count;
							token += "=";
							tabelaTokens.add( new Token( SYMBOLS_TABLE.indexOf(token)+1, token, OPERADOR ) );
							if (isEndOfFile()) {break;}
							c = getNextChar();
							setVazio();	
						}
						else
						{
							tabelaTokens.add( new Token( SYMBOLS_TABLE.indexOf(token)+1, token, OPERADOR ) );
							if (isEndOfFile()) {break;}
							c = getNextChar();
							System.err.println(c);
							setVazio();	
						}
					} catch (StringIndexOutOfBoundsException e) {
						tabelaTokens.add( new Token( SYMBOLS_TABLE.indexOf(token)+1, token, OPERADOR ) );
						if (isEndOfFile()) {break;}
						c = getNextChar();
						setVazio();
					}
				} while (isOperator(c));
			}

			// Identifica os delimitadores
			else if (isDelimitator(c)){
				do {
					// Incrementa a variável line se for quebra de linha.
					if (c.matches("[\n]")) {line++;}
					
					if (isEndOfFile()) {break;}
					c = getNextChar();
					setVazio();
				} while (isDelimitator(c));
			}

			// Finaliza a execução ao chegar no final do arquivo.
			else if (count == programa.length()) {
				System.out.println("SISTEMA FINALIZADO!");
				break;
			}

			// Identifica qualquer caracter inválido no programa-fonte.
			else {
				log += "Caracter inválido   " + c + "   encontrado na linha " + line + ".\n";
				if (isEndOfFile()) {break;}
				c = getNextChar();
				setVazio();
			}

		}
		return tabelaTokens;
	}



	/**
	 * Método privado que verifica se determinado 
	 * caracter é um número inteiro de 0 a 9.
	 */
	private boolean isNumber(String c) {
		return c.matches("[0-9]");
	}
	
	/**
	 * Método privado que verifica se determinado caracter é um 
	 * caracter de palavra no intervalo de [a-z] ou [A-Z].
	 */
	private boolean isLetter(String c) {
		return c.matches("[a-zA-Z]");
	}

	/**
	 * Método privado que verifica se determinado caracter
	 * é um operador dos seguintes tipos (*, /, +, -, <, >, =).
	 */
	private boolean isOperator(String c) {
		return c.matches("[*]|[/]|[+]|[-]|[<]|[>]|[=]");
	}

	/**
	 * Método privado que verifica se determinado caracter é um
	 * caracter delimitador, como: ' ', '\t', '\n'.
	 */
	private boolean isDelimitator(String c) {
		return c.matches("[ |\t|\n]");
	}

	/**
	 * Método privado que verifica se determinado
	 * caracter é um caracter do tipo aspas (").
	 */
	private boolean isAspas(String c) {
		return c.matches("[\"]");
	}

	/**
	 * Método privado que verifica se determinado
	 * caracter é um caracter do tipo " ( ".
	 */
	private boolean isAbrePar(String c) {
		return c.matches("[(]");
	}

	/**
	 * Método privado que verifica se determinado
	 * carater é um caracter do tipo asterisco (*).
	 */
	private boolean isAsterisco(String c) {
		return c.matches("[*]");
	}

	/**
	 * Método privado que verifica se determinado
	 * caracter é um caracter do tipo ponto (.)
	 */
	private boolean isDot(String c) {
		return c.matches("[.]");
	}

	/**
	 * Método privado que verifica se determinado
	 * caracter é um caracter do tipo maior que (>).
	 */
	private boolean isMaiorQue(String c) {
		return c.matches("[>]");
	}

	/**
	 * Método privado que verifica se determinado
	 * caracter é um caracter do tipo menor que (<).
	 */
	private boolean isMenorQue(String c) {
		return c.matches("[<]");
	}

	/**
	 * Método privado que verifica se determinado
	 * caracter é um caracter do tipo igual (=).
	 */
	private boolean isIgual(String c) {
		return c.matches("[=]");
	}

	/**
	 * Método privado que verifica se determinado
	 * caracter é um caracter do tipo dois pontos (:).
	 */
	private boolean isDoisPontos(String c) {
		return c.matches("[:]");
	}

	/**
	 * Método privado que verifica se determinado
	 * caracter é um símbolo especial definido pela gramática.
	 */
	private boolean isSpecialSymbols(String c) {
		return c.matches("[,]|[;]|[:]|[.]|[(]|[)]|[\\[]|[\\]]");
	}


	/**
	 * Método privado que primeiro incrementa a variável count,
	 * depois a compara com o tamanho total do programa. Com isso
	 * é possível verificar se chegou no final do arquivo ou não.
	 */
	private boolean isEndOfFile() {
		if (++count == programa.length()) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * Método privado que retorna um Literal com
	 * o próximo caracter a ser lido no programa.
	 */
	private String getNextChar() {
		return ""+programa.charAt(count);
	}
	
	/**
	 * Método privado que seta valor vazio ("")
	 * para a variável token.
	 */
	private void setVazio() {
		this.token = "";
	}
	
	
	/**
	 * Retorna a variável contendo o log da análise.
	 */
	public String getLog() {
		return this.log;
	}



}
