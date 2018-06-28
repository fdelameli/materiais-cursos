import java.math.BigInteger;


public class Principal {

	public static void main(String[] args) {
		
		
		String bin = "1010.11";
		int pos = bin.indexOf(".");
		int res = 0;
		
		double exp = 0;
		for (int i = pos-1; i >= 0; i--) {
			int aux = Integer.parseInt(String.valueOf(bin.charAt(i)));
			res += aux * Math.pow(2, exp);		
			exp ++;
		}
//		System.out.println(res);
		
		double res2 = 0;
		exp = 0.5;
		for (int i = pos+1; i < bin.length(); i++) {
			int aux = Integer.parseInt(String.valueOf(bin.charAt(i)));
			double aux2 = 2 ;
			System.out.println(aux2);
			res2 += (aux * aux2);
			exp /= 2;
		}

		double total = res + res2;

		System.out.println(total);
		
		
		
		
		
		
		
/*		String vetor[] = new String [2];
		
		vetor = bin.split(",");
		
		int binA = Integer.parseInt(vetor[0], 2);
		int binB = Integer.parseInt(vetor[1], 2);   
		        
		String result = "" + binA + binB;
		System.out.println(result); 

		
		
		
		
		
/*		  String valor = "10011";   
		  double bin = Integer.parseInt(valor, 2);   
		        
		  System.out.println("valor: " + valor);   
		  System.out.println("bin..: " + bin); 
		  
		  double num = 129.5;   
		  String bin2 = "";
		  
		  while (num>0) {   
			  bin2 = ((num % 2 == 0)?"0":"1" ) + bin2;   
		  	num /=2; 
		  }
		  
		  System.out.println(bin2);
		 */
	}
}

