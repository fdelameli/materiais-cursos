import java.math.BigInteger;


public class Principal {

	public static void main(String[] args) {
		
		
		// RETORMA O MAIR VALOR
		
/*		int a = 4;
		int b = 6;
		System.out.println(Math.max(a, b));
*/		

		// GERAR VALORES ALEATÓRIOS
		
/*		int valorGerado = 0;
		for (int i = 0; i < 100; i++) {
			//valorGerado = (int) (1 + ((Math.random() * 100)));
			valorGerado = 1 + (int)(Math.random() * 100); 
			System.out.println(valorGerado);
		}
*/	
		
		// MÓDULO
		
//		System.out.println(Math.abs(-48));
		
		
		//CASTING
		
/*		double d = 4.5676564;
		System.out.println((int) d);
*/
		
		
		//FATORIAL
		
		BigInteger resultado = new BigInteger("1");
		for (int i = 100; i > 0; i--) {
			BigInteger bigI = new BigInteger(String.valueOf(i));
			resultado = resultado.multiply(bigI);
		}
		
		String aux = resultado.toString();
		System.out.println(resultado);
		
		int cont = 0;
		for (int i = 0; i < aux.length(); i++) {
			if(aux.charAt(i) == '0')
				cont++;
		}
		
		System.out.println("Quantidade de zeros: " + cont);
	}
}
