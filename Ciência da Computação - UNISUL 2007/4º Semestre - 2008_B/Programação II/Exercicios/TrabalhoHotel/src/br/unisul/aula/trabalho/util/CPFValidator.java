package br.unisul.aula.trabalho.util;

public class CPFValidator {

	/**
	 * M�todo para verifica se determinado cpf � v�lido (FONTE: www.guj.com.br).
	 * @param cpf - Uma String contendo o cpf.
	 * @return true se o cpf � v�lido e false se n�o � v�lido.
	 */
	public static boolean validaCpf(String xCPF){   
		try {   

			//	Testa se o CPF � v�lido ou n�o   
			int d1, d4, xx, nCount, resto, digito1, digito2;   
			String Check;   
			String Separadores = "/-.";   
			d1 = 0; d4 = 0; xx = 1;
			
			for (nCount = 0; nCount < xCPF.length() -2; nCount++){   
				String s_aux = xCPF.substring(nCount, nCount+1);   

				if (Separadores.indexOf(s_aux) == -1) {   
					d1 = d1 + ( 11 - xx ) * Integer.valueOf (s_aux).intValue();   
					d4 = d4 + ( 12 - xx ) * Integer.valueOf (s_aux).intValue();   
					xx++;   
				}
			}
			
			resto = (d1 % 11);
			
			if (resto < 2)   
				digito1 = 0;   
			else   
				digito1 = 11 - resto;   
			   
			
			d4 = d4 + 2 * digito1;   
			resto = (d4 % 11);
			
			if (resto < 2)      
				digito2 = 0;   
			else  
				digito2 = 11 - resto;   

			Check = String.valueOf(digito1) + String.valueOf(digito2);   

			String s_aux2 = xCPF.substring (xCPF.length()-2, xCPF.length());   

			if (s_aux2.compareTo (Check) != 0)  
				return false;   
			
			return true; 
			
		}catch (Exception e){   
			return false;   
		}   
	}	 
	
}
