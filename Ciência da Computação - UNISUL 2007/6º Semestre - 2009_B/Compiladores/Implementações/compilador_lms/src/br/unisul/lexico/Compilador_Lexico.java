package br.unisul.lexico;

import java.util.LinkedList;
import java.util.List;
import br.unisul.model.Token;
import br.unisul.model.constants.PalavrasReservadasConstants;

/**
 * Analisador Léxico para a linguagem LMS.
 */
public class Compilador_Lexico
{
    public int line;

	/**
	 * Constroi um analisador léxico.
	 */
	public Compilador_Lexico()
	{
		super();
	}

	/**
	 * Realiza a análise léxica da sequencia passada.
	 * 
	 * @param A sequencia que será analisada.
	 * 
	 * @return Uma lista de tokens.
	 */
	public List<Token> analisar( String sequencia )
	{
        line = 0;
		List<Token> returnList = new LinkedList<Token>();

		int estadoAtual = 0;
		StringBuilder sequenciaAtual = null;

		int sequenciaLength = sequencia.length();
		for( int i = 0; i < sequenciaLength; i++ )
		{
			char charAtual = sequencia.charAt( i );
            
            if ( ((int) charAtual) == 10 ) {
               line++;
            }

			switch( estadoAtual )
			{
				case 0:
				{
					sequenciaAtual = new StringBuilder();
					estadoAtual = processaEstadoInicial( charAtual );

					break;
				}
				case 1:
				{
					estadoAtual = processaEstado1( charAtual );

					if( estadoAtual == 0 )
					{
						if( PalavrasReservadasConstants.PALAVRAS_RESERVADAS.containsKey( sequenciaAtual.toString().toUpperCase() ) )
						{
							returnList.add( new Token( PalavrasReservadasConstants.PALAVRAS_RESERVADAS.get( sequenciaAtual.toString().toUpperCase() ).intValue(), sequenciaAtual.toString(), "Palavra-reservada" ) );
						}
						else
						{
							if(sequenciaAtual.toString().length() <= 30){
								returnList.add( new Token( 25, sequenciaAtual.toString(), "IDENT" ) );	
							}else {
								returnList.add( new Token( 0, sequenciaAtual.toString(), "Um Identificador não pode conter mais de 30 caracteres! Linha: "+line ) );
							}
							
						}
						
						i--;
                        decrementLine(charAtual);
					} else if(estadoAtual < 0) {
                       				returnList.add(new Token(0, sequenciaAtual.toString(), "Caractere não reconhecido! Linha: "+line));
                       				return returnList;
                    			}
					
					break;
				}
				case 2:
				{
					estadoAtual = processaEstado2( charAtual );
                    if(estadoAtual < 0) {
                        returnList.add(new Token(0, sequenciaAtual.toString(), "Um identificador deve terminar com letra ou numero! Linha: "+line));
                        return returnList;
                    }
					break;
				}
				case 3:
				{
					estadoAtual = processaEstado3( charAtual );
					break;
				}
				case 4:
				{
					estadoAtual = processaEstado4( charAtual );

					if( estadoAtual == 0 )
					{
						if(sequenciaAtual.toString().length() < 257){
							returnList.add(new Token(48, sequenciaAtual.toString(), "LITERAL"));	
						}else {
							returnList.add(new Token(0, sequenciaAtual.toString(), "ILEGAL, valor fora da escala! Linha:" +line));
						}
						
						i--;
                        decrementLine(charAtual);
					}
					break;
				}
				case 5:
				{
					estadoAtual = processaEstado5( charAtual );

					if( estadoAtual == 0 )
					{
						returnList.add(new Token(43, sequenciaAtual.toString(), "Sinal-de-Menor"));
						i--;
                        decrementLine(charAtual);
					}

					break;
				}
				case 6:
				{
					estadoAtual = processaEstado6( charAtual );

					if( estadoAtual == 0 )
					{
						returnList.add(new Token(41, sequenciaAtual.toString(), "Sinal-de-Maior"));
						i--;
                        decrementLine(charAtual);
					}
					break;
				}
				case 7:
				{
					estadoAtual = processaEstado7( charAtual );

					if( estadoAtual == 0 )
					{
						if( sequenciaAtual.toString().equals( "-" ) )
						{
							returnList.add( new Token( 31, sequenciaAtual.toString(), "Sinal-de-Subtração" ) );
						}
						else if( sequenciaAtual.toString().equals( "=" ) )
						{
							returnList.add( new Token( 40, sequenciaAtual.toString(), "Sinal-de-Igualdade" ) );
						}
						else if( sequenciaAtual.toString().equals( "<>" ) )
						{
							returnList.add( new Token( 45, sequenciaAtual.toString(), "Sinal-de-Diferente" ) );
						}
						else if( sequenciaAtual.toString().equals( ">=" ) )
						{
							returnList.add( new Token( 42, sequenciaAtual.toString(), "Sinal-de-Maior-igual" ) );
						}
						else if( sequenciaAtual.toString().equals( "<=" ) )
						{
							returnList.add( new Token( 44, sequenciaAtual.toString(), "Sinal-de-Menor-igual" ) );
						}
						else if( sequenciaAtual.toString().equals( "+" ) )
						{
							returnList.add( new Token( 30, sequenciaAtual.toString(), "Sinal-de-Adição" ) );
						}
						else if( sequenciaAtual.toString().equals( "*" ) )
						{
							returnList.add( new Token( 32, sequenciaAtual.toString(), "Sinal-de-Multiplicação" ) );
						}

						else if( sequenciaAtual.toString().equals( ")" ) )
						{
							returnList.add( new Token( 37, sequenciaAtual.toString(), "Fechamento-de-parênteses" ) );
						}
						else if( sequenciaAtual.toString().equals( "[" ) )
						{
							returnList.add( new Token( 34, sequenciaAtual.toString(), "Abertura-de-colchetes" ) );
						}
						else if( sequenciaAtual.toString().equals( "]" ) )
						{
							returnList.add( new Token( 35, sequenciaAtual.toString(), "Fechamento-de-colchetes" ) );
						}
						else if( sequenciaAtual.toString().equals( "," ) )
						{
							returnList.add( new Token( 46, sequenciaAtual.toString(), "Vírgula" ) );
						}
						else if( sequenciaAtual.toString().equals( ";" ) )
						{
							returnList.add( new Token( 47, sequenciaAtual.toString(), "Ponto-e-vírgula" ) );
						}
						else if( sequenciaAtual.toString().equals( ".." ) )
						{
							returnList.add( new Token( 50, sequenciaAtual.toString(), "Ponto-ponto" ) );
						}
						else if( sequenciaAtual.toString().equals( ":=" ) )
						{
							returnList.add( new Token( 38, sequenciaAtual.toString(), "Sinal-de-atribuição" ) );
						}
						else if( sequenciaAtual.toString().equals( "$" ) )
						{
							returnList.add( new Token( 51, sequenciaAtual.toString(), "Fim-de-Arquivo" ) );
							System.err.println("[WARNING] Ignorou Token Inválido! Linha:"+ line);
//							JOptionPane.showMessageDialog(null, "Ignorou");
							i= sequenciaLength;
							break;
						}
						
						i--;
                        decrementLine(charAtual);
					}
					break;
				}
				case 8:
				{
					estadoAtual = processaEstado8( charAtual );

					if( estadoAtual == 0 )
					{
						returnList.add(new Token(49, sequenciaAtual.toString(), "Ponto-final"));
						i--;
                        decrementLine(charAtual);
					}
					break;
				}
				case 9:
				{
					estadoAtual = processaEstado9( charAtual );

					if( estadoAtual == 0 )
					{
						returnList.add( new Token( 39, sequenciaAtual.toString(), "Dois-pontos" ) );
						i--;
                        decrementLine(charAtual);
					}
					break;
				}
				case 10:
				{
					estadoAtual = processaEstado15( charAtual );

					if( estadoAtual == 0 )
					{
						returnList.add( new Token( 33, sequenciaAtual.toString(), "Sinal-de-divisão" ) );
						i--;
                        decrementLine(charAtual);
					}
					break;
				}
				case 11:
				{
					estadoAtual = processaEstado11( charAtual );
                    if(estadoAtual < 0) {
                        returnList.add(new Token(0, sequenciaAtual.toString().replaceAll("\n", "/n").replaceAll("\t", "/t"), "Um identificador deve terminar com letra ou numero! Linha: " +line));
                        return returnList;
                    }
					break;
				}
				case 12:
				{
					estadoAtual = processaEstado12( charAtual );
					break;
				}
				case 13:
				{
					estadoAtual = processaEstado13( charAtual );

					if( estadoAtual == 0 )
					{
						i--;
                        decrementLine(charAtual);
					}

					break;
				}
				case 14:
				{
					estadoAtual = processaEstado14( charAtual );

					if( estadoAtual <= 0 )
					{
						if(estadoAtual == 0){
							i--;
						}
						try {
							int numInteiro = Integer.parseInt(sequenciaAtual.toString());
							if(numInteiro > 32767 || numInteiro < -32767){
								returnList.add( new Token( 0, sequenciaAtual.toString(), "ILEGAL, valor fora da escala! Linha: "+line ) );
							}else{
								returnList.add( new Token( 26, numInteiro+"", "INTEIRO" ) );	
							}
							
						} catch (Exception e) {
							 returnList.add( new Token( 0, sequenciaAtual.toString(), "ILEGAL, não aceita ponto decimal nem outros caracteres! Linha: "+line ) );
						}
						
					}
					break;
				}
				case 15:
				{
					estadoAtual = processaEstado10( charAtual );

					if( estadoAtual == 0 )
					{
						returnList.add( new Token( 36, sequenciaAtual.toString(), "Abertura-de-Parenteses" ) );
						i--;
                        decrementLine(charAtual);
					}
					break;
				}
				case -1:
				{
					break;
				}
			}

			if( estadoAtual >= 0 )
			{
				sequenciaAtual.append( charAtual );
			}else{
				returnList.add( new Token( 0, ""+charAtual, "[WARNING] Ignorou Token Inválido! Linha: "+line ) );
				estadoAtual = 0;
			}
			
		}

		return returnList;
	}

	/**
	 * Processa a entrada para o estado "inicial".
	 * 
	 * @param c O caracter de entrada.
	 */
	private int processaEstadoInicial( char c )
	{
		if( isLetra( c ) )
		{
			return 1;
		}
		else if( c == '_' )
		{
			return 2;
		}
		else if( c == '\"' )
		{
			return 3;
		}
		else if( c == '<' )
		{
			return 5;
		}
		else if( c == '>' )
		{
			return 6;
		}
		else if( c == '-' || c == '=' || c == '+' || c == '*'
			|| c == ')' || c == '[' || c == ']' || c == ',' || c == ';' || c == '$' )
		{
			return 7;
		}
		else if( c == '.' )
		{
			return 8;
		}
		else if( c == ':' )
		{
			return 9;
		}
		else if( c == '/' )
		{
			return 10;
		}
		else if( c == '(' )
		{
			return 15;
		}
		else if( isNumero( c ) )
		{
			return 14;
   	} else if(c == ' ') {
       return 0;
    } else if( ((int) c) == 10 ) {
       return 0;
    }
		
		return -1;
	}

	/**
	 * Processa a entrada para o estado "1".
	 * 
	 * @param c O caracter de entrada.
	 */
	private int processaEstado1( char c )
	{
		if( isLetra( c ) || isNumero( c ) )
		{
			return 1;
		}


		return 0;

	}

	/**
	 * Processa a entrada para o estado "2".
	 * 
	 * @param c O caracter de entrada.
	 */
	private int processaEstado2( char c )
	{

		if( isLetra( c ) || isNumero( c ) )
		{
			return 1;
		}

		return -1;
	}

	/**
	 * Processa a entrada para o estado "3".
	 * 
	 * @param c O caracter de entrada.
	 */
	private int processaEstado3( char c )
	{
		if( c == '\"' )
		{
			return 4;
		}
//		else if( c == '$' )
//		{
//			return -1;
//		}

		return 3;
	}

	/**
	 * Processa a entrada para o estado "4".
	 * 
	 * @param c O caracter de entrada.
	 */
	private int processaEstado4( char c )
	{
		return 0;
	}

	/**
	 * Processa a entrada para o estado "5".
	 * 
	 * @param c O caracter de entrada.
	 */
	private int processaEstado5( char c )
	{
		if( c == '=' || c == '>' )
		{
			return 7;
		}

		return 0;
	}

	/**
	 * Processa a entrada para o estado "6".
	 * 
	 * @param c O caracter de entrada.
	 */
	private int processaEstado6( char c )
	{
		if( c == '=' )
		{
			return 7;
		}

		return 0;
	}

	/**
	 * Processa a entrada para o estado "7".
	 * 
	 * @param c O caracter de entrada.
	 */
	private int processaEstado7( char c )
	{
		return 0;
	}

	/**
	 * Processa a entrada para o estado "8".
	 * 
	 * @param c O caracter de entrada.
	 */
	private int processaEstado8( char c )
	{
		if( c == '.' )
		{
			return 7;
		}

		return 0;
	}

	/**
	 * Processa a entrada para o estado "9".
	 * 
	 * @param c O caracter de entrada.
	 */
	private int processaEstado9( char c )
	{
		if( c == '=' )
		{
			return 7;
		}

		return 0;
	}

	/**
	 * Processa a entrada para o estado "10".
	 * 
	 * @param c O caracter de entrada.
	 */
	private int processaEstado10( char c )
	{
		if( c == '*' )
		{
			return 11;
		}

		return 0;
	}

	/**
	 * Processa a entrada para o estado "11".
	 * 
	 * @param c O caracter de entrada.
	 */
	private int processaEstado11( char c )
	{
		if( c == '*' )
		{
			return 12;
		}
//		else if( c == '$' )
//		{
//			return -1;
//		}

		return 11;
	}

	/**
	 * Processa a entrada para o estado "12".
	 * 
	 * @param c O caracter de entrada.
	 */
	private int processaEstado12( char c )
	{
		if( c == '*' )
		{
			return 12;
		}
		if( c == ')' )
		{
			return 13;
		}
		else if( c == '$' )
		{
			return -1;
		}

		return 11;
	}

	/**
	 * Processa a entrada para o estado "13".
	 * 
	 * @param c O caracter de entrada.
	 */
	private int processaEstado13( char c )
	{
		return 0;
	}

	/**
	 * Processa a entrada para o estado "14".
	 * 
	 * @param c O caracter de entrada.
	 */
	private int processaEstado14( char c )
	{
		if( isNumero( c ) )
		{
			return 14;
		} 
		
		if (processaEstadoInicial(c) < 0){
			return -1;
		}
		
		return 0;
	}
	/**
	 * 
	 * @param 
	 * @return
	 */
	private int processaEstado15( char c )
	{

		return 0;
	}


	private boolean isNumero( char c )
	{
		String cc = c+"";
		return cc.matches("[0-9]");
	}
	
	private boolean isLetra( char c )
	{
		String cc = c+"";
		return cc.matches("[a-zA-Z]");
	}
    
    private void decrementLine( char c ) {
       if ( ((int) c) == 10 ) {
          line--;
       }
    }
}
