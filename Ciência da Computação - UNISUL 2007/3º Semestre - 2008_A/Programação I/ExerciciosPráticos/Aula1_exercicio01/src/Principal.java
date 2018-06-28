import aula01.exercicio02.IMC;

//import javax.swing.JOptionPane;

public class Principal {


	public static void main(String[] args) {

		for (int i = 0; i < 10; i++)
		{
			System.out.println("Valor de i: " + i);
		}
		
		double a = IMC.calcularIMC(82, 1.88);
		System.out.println("IMC = " + a);
		

	}

}
