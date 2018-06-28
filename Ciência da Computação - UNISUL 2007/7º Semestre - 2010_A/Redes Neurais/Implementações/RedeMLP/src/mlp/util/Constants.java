package mlp.util;

import java.awt.Point;
import java.awt.Toolkit;

import javax.swing.JDialog;

import mlp.Backpropagation;


/**
 * Classe que define algumas variávels globais importantes para o funcionamento do sistema.
 * @author Fabio Dela Bruna.
 */
public class Constants {

	// Constants para o funcionamento do teste da rede.

	/**
	 * Define o nome para o arquivo de teste.
	 */
	public static String fileTestName = "teste.png";

	/**
	 * Arquivo padrão contendo a matriz de pesos PV.
	 */
	public static String filePVDefault = "pv.mlp";

	/**
	 * Arquivo padrão contendo a matriz de pesos PW.
	 */
	public static String filePWDefault = "pw.mlp";

	/**
	 * Quantidade padrão de neurônios para a camada de entrada.
	 */
	public static int qtdNeurEntrada = 18125;

	/**
	 * Quantidade padrão de neurônios para a camanda intermediária.
	 */
	public static int qtdNeurOculta = 200;

	/**
	 * Quantidade padrão de neurônios para a camada de saída.
	 */
	public static int qtdNeurSaida = 5;

	/**
	 * Define um Limiar para a formatação do resultado do teste.
	 */
	public static double limiar = 0.5;
	
	public static Backpropagation backp;
	
	/**
	 * DEFINE A MATRIZ DE TARGETS PARA O TREINAMENTO.
	 */
	public static double[][] t = { 
		{ 0, 0, 0, 0, 0 }, // A 0
		{ 0, 0, 0, 0, 1 }, // B 1
		{ 0, 0, 0, 1, 0 }, // C 2
		{ 0, 0, 0, 1, 1 }, // D 3
		{ 0, 0, 1, 0, 0 }, // E 4
		{ 0, 0, 1, 0, 1 }, // F 5
		{ 0, 0, 1, 1, 0 }, // G 6
		{ 0, 0, 1, 1, 1 }, // H 7
		{ 0, 1, 0, 0, 0 }, // I 8
		{ 0, 1, 0, 0, 1 }, // J 9
		{ 0, 1, 0, 1, 0 }, // K 10
		{ 0, 1, 0, 1, 1 }, // L 11
		{ 0, 1, 1, 0, 0 }, // M 12
		{ 0, 1, 1, 0, 1 }, // N 13
		{ 0, 1, 1, 1, 0 }, // O 14
		{ 0, 1, 1, 1, 1 }, // P 15
		{ 1, 0, 0, 0, 0 }, // Q 16
		{ 1, 0, 0, 0, 1 }, // R 17
		{ 1, 0, 0, 1, 0 }, // S 18
		{ 1, 0, 0, 1, 1 }, // T 19
		{ 1, 0, 1, 0, 0 }, // U 20
		{ 1, 0, 1, 0, 1 }, // V 21
		{ 1, 0, 1, 1, 0 }, // W 22
		{ 1, 0, 1, 1, 1 }, // X 23
		{ 1, 1, 0, 0, 0 }, // Y 24
		{ 1, 1, 0, 0, 1 } // Z 25
		};


	// Métodos para o funcionameto operacional do sistema.

	public static final Point CENTER_POSITION( JDialog frame ) {
		Point p = new Point();
		int width = ( Toolkit.getDefaultToolkit().getScreenSize().width / 2 ) - ( frame.getBounds().width / 2 );
		int heigh = ( Toolkit.getDefaultToolkit().getScreenSize().height / 2 ) - ( frame.getBounds().height / 2 );
		p.x = width;
		p.y = heigh;
		return p;
	}

}
