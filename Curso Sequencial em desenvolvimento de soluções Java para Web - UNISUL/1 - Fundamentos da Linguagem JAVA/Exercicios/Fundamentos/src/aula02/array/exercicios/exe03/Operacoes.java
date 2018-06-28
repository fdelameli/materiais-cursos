package aula02.array.exercicios.exe03;

public class Operacoes {
	
	public static double somar(double n1, double n2){
		return n1+n2;		
	}
	
	public static double subtrair(double n1, double n2){
		return n1-n2;
	}
	
	public static double multiplicar(double n1, double n2){
		return n1*n2;
	}
	
	public static double dividir(double n1, double n2){
		if(n2!=0){
			return n1/n2;
		}else{
			return 0;
		}
	}

}
