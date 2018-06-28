package aula01.exercicio01;

public class Operacoes {
	
	public static int somarInteiros(int n1, int n2){
		return n1+n2;		
	}
	
	public static int subtrairInteiros(int n1, int n2){
		return n1-n2;
	}
	
	public static int multiplicarInteiros(int n1, int n2){
		return n1*n2;
	}
	
	public static double dividirNumeros(int n1, int n2){
		if(n2!=0){
			return n1/n2;
		}else{
			return 0;
		}
	}

}
