package teste_para_analisador_lexico;


public class Teste {

	
	public static void main(String[] args) {
		
		String teste = "ABCDE";
		teste += "$";
		int count = 0;
		String c = "";
		
		while (count < teste.length()) {
		
			c = ""+teste.charAt(count);

			if (c.matches("[$]")) {
				System.out.println("Encontrou o final do arquivo na posição " + count);
			}
			
			count++;
			
		}
		
		
		
	}
}
