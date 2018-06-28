

/**
 * Classe para representar o autamato do exercicio 1 e 2.
 * @author Fabio Dela Bruna, Marcio Ozorio Teixeira.
 */
public class AutomatoIdentificador {

    /**
     * Metodo privado que faz a varredura na cadeia caracter
     * por caracter e no final diz se a cadeia é valida ou nao.
     * @param c Variavel contendo a cadeia digitada pelo usuurio.
     * @return Retorna true se a cadeia for reconhecida, e false ser nao for.
     */
    public static boolean recognizer(String c) {
		int estado = 0;
		String s = "";
		
		for (int i = 0; i < c.length(); i++) {
			
			s = String.valueOf(c.charAt(i));
			
			switch (estado) {
			
				case 0 : {
					if (isUnderline(s))
						estado = 1;
					else if (isLetterLowerCase(s))
						estado = 2;
					else if (isOperator(s))
						estado = 3;
					else if (isNumber(s))
						estado = 4;
					else return false;
					break;
				}
				
				case 1 : {
					if (isUnderline(s))
						estado = 1;
					else if (isLetterLowerCase(s) || isNumber(s))
						estado = 2;
					else return false;
					break;
				}
				
				case 2 : {
					if (isUnderline(s)) 
						estado = 1;
					else if (isLetterLowerCase(s) || isNumber(s))
						estado = 2;
					else return false;
					break;
				}
				
				case 3 : {
					if (isNumber(s))
						estado = 4;
					else return false;
					break;
				}
				
				case 4 : {
					if (isNumber(s))
						estado = 4;
					else if (isDot(s))
						estado = 5;
					else return false;
					break;
				}
				
				case 5 : {
					if (isNumber(s))
						estado = 6;
					else return false;
					break;
				}
				
				case 6 : {
					if (isNumber(s))
						estado = 6;
					else if (isExponential(s))
						estado = 7;
					else return false;
					break;
				}
				
				case 7 : {
					if (isOperator(s))
						estado = 8;
					else if (isNumber(s))
						estado = 9;
					else return false;
					break;
				}
				
				case 8 : {
					if (isNumber(s))
						estado = 9;
					else return false;
					break;
				}
				
				case 9 : {
					if (isNumber(s))
						estado = 9;
					else return false;
					break;
				}
				
			}
			
		}
		
		if (estado == 2 || estado == 4 || estado == 6 || estado == 9) {
			return true;
		} else {
			return false;
		}
    }
    

    /**
     * Metodo que verifica se o token passado por
     * parametro é um underline (_).
     * @return Rotorna true se for underline, caso contrario retorna false.
     */
    public static boolean isUnderline(String s) {
        return s.matches("[_]");
    }

    /**
     * Metodo que verifica se o token passado por
     * parametro é uma letra minuscula de a-z.
     * @return Rotorna true se for de a-z, caso contrario retorna false.
     */
    public static boolean isLetterLowerCase(String s) {
        return s.matches("[a-z]");
    }

    /**
     * Metodo que verifica se o token passado por
     * parametro é um numero de 0 a 9.
     * @return Rotorna true se for de 0-9, caso contrario retorna false.
     */
    public static boolean isNumber(String s) {
        return s.matches("[0-9]");
    }

    /**
     * Metodo que verifica se o token passado por
     * parametro é o caractere mais (+) ou menos (-).
     * @return Rotorna true se for o + ou -, caso contrario retorna false.
     */
    public static boolean isOperator(String s) {
        return s.matches("[+-]");
    }

    /**
     * Metodo que verifica se o token passado por
     * parametro é o caractere ponto (.).
     * @return Rotorna true se for o ponto, caso contrario retorna false.
     */
    public static boolean isDot(String s) {
        return s.matches("[.]");
    }

    /**
     * Metodo que verifica se o token passado por
     * parametro é o caractere/letra de expoente (E).
     * @return Rotorna true se for o caracter E, caso contrario retorna false.
     */
    public static boolean isExponential(String s) {
        return s.matches("[E]");
    }

    
    /**
     * Metodo que verifica se a cadeia passado por parametro
     * É uma cadeia que possui somente caracteres válidos
     * @return "ok" se a cadeia estiver caracteres validos para o automato, 
     * caso contrario retorna o caracter inválido.
     */
    public static String isChainValid(String s) {

    	String e = "";
    	int isValid = 1;
    	String err = "";

    	for (int i = 0; i < s.length(); i++) {
    		e = String.valueOf(s.charAt(i));

    		if (!(isUnderline(e) || isNumber(e) || isLetterLowerCase(e) || 
    				isExponential(e) || isOperator(e)|| isDot(e))) {
    			isValid = -1;
    			err = e;
    			break;
    		} 
    	}

    	if (isValid == -1) {
    		return err;
    	} else {
    		err = "ok";
    		return err;
    	}
    	
    }
}
