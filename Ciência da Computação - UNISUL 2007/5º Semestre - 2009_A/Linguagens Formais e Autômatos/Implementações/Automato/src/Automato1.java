import javax.swing.JOptionPane;

/**
 * Classe para representar o autômato do exercício 1.
 * @author Fabio Dela Bruna, Marcio Ozório Teixeira.
 */
public class Automato1 {

	/**
	 * Método privado que faz a varredura na cadeia caracter
	 * por caracter e no final diz se a cadeia é válida ou não.
	 * @param c Variável contendo a cadeia digitada pelo usuário.
	 * @return Retorna true se a cadeia for reconhecida, e false ser não for.
	 */
	private static boolean recognizer (String c) {
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
					if (isLetterLowerCase(s) || isNumber(s))
						estado = 2;
					else return false;
					break;
				}
				
				case 2 : {
					if (isUnderline(s)) 
						estado = 1;
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
					if (isDot(s))
						estado = 5;
					else if (isNumber(s))
						estado = 4;
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
					if (isExponential(s))
						estado = 7;
					else if (isNumber(s))
						estado = 6;
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
				
				
			}
			
		}
		
		if (estado == 2 || estado == 4 || estado == 6 || estado == 9) {
			return true;
		} else {
			return false;
		}
		
	}


	/**
	 * Método principal, é o método que inicializa o sistema.
	 */
	public static void main(String[] args) {
		int opcao = 1;
		
		do {
			
			String cadeia = JOptionPane.showInputDialog(null, "Digite a cadeia:", "AUTOMATO", JOptionPane.PLAIN_MESSAGE);
			
			if (recognizer(cadeia)) {
				JOptionPane.showMessageDialog(null, "Cadeia reconhecida!", "AUTOMATO", JOptionPane.PLAIN_MESSAGE);
			} else {
				JOptionPane.showMessageDialog(null, "Cadeia não reconhecida!", "AUTOMATO", JOptionPane.PLAIN_MESSAGE);
			}
			
			opcao = JOptionPane.showConfirmDialog(null, "Deseja continuar?", "", JOptionPane.YES_NO_OPTION);
			System.out.println(opcao);
			
		} while (opcao != 1);
		
	}

	


	public static boolean isUnderline(String s) {
		return s.matches("[_]");
	}
	
	public static boolean isDot(String s) {
		return s.matches("[.]");
	}
	
	public static boolean isExponential(String s) {
		return s.matches("[E]");
	}
	
	public static boolean isOperator(String s) {
		return s.matches("[+-]");
	}

	public static boolean isLetterLowerCase(String s) {
		return s.matches("[a-z]");
	}

	public static boolean isNumber(String s) {
		return s.matches("[0-9]");
	}

}
