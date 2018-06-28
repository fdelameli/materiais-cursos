package classemath;

import com.sun.org.apache.xerces.internal.impl.xpath.regex.Match;


public class Randow {
	public static void main(String[] args) {
		int n1 = 3;
		int n2 = 5;
		//METODO RANDOM	
		System.out.println(Math.random());

		//o metodo max é utilizado  para imprimir o numero maior
		System.out.println( "O número maior é: " + Math.max( n1, n2));
		//o metodo min é utilizado para imprimir o numero menor
		System.out.println( "O número menor é: " + Math.min( n1, n2));
//METODO POW:
		System.out.print("o resulatado da elevação é: " + Math.pow(n1, n2));
	}
}