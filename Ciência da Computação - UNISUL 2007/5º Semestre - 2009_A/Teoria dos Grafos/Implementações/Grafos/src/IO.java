import java.util.Scanner;


public class IO {
	private static Scanner Entrada = new Scanner(System.in);
	
	public static String LerLinha(){
		return Entrada.nextLine();
	}
	
	public static Integer LerInteiro(){
		return Entrada.nextInt();
	}

	public static void ImprimirLinha(String saida){
		System.out.println(saida);
	}
	
	public static void ImprimirLinha(){
		System.out.println();
	}
}
