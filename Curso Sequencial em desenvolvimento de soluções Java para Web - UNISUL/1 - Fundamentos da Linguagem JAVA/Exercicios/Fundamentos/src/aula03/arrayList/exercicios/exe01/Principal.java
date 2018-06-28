package aula03.arrayList.exercicios.exe01;

import java.util.ArrayList;

import javax.swing.JOptionPane;

public class Principal {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		ArrayList <Produto> lista = new ArrayList<Produto>();
		
		byte op = 0;
		
		do{
			op = Byte.parseByte(JOptionPane.showInputDialog("|1| - Cadastrar Produto\n\n|2| - SAIR"));
			
			switch(op){
			
			case 1:
				Produto p = new Produto();
				p.setNome(JOptionPane.showInputDialog("Nome:"));
				p.setValor(Double.parseDouble(JOptionPane.showInputDialog("Valor:")));
				p.setRotatividade(Byte.parseByte(JOptionPane.showInputDialog("Rotatividade:  1 - alto giro / 2 - baixo giro")));
				lista.add(p);
			}
		}while(op != 0);
	
	}
	
	
	/**
	 * Método para mostrar o menu do sistema.
	 */
	private static byte showMenu() {
		return Byte.parseByte(
				JOptionPane.showInputDialog(".:: MENU DO SISTEMA ::.\n\n" +
						"|1|  -  CADASTRAR PRODUTO\n\n" +
						"|2|  -  PRODUTO DE BAIXO GIRO DE VALOR MAIS ALTO\n" +
						"|3|  -  PRODUTO DE ALTO GIRO DE VALOR MAIS BAIXO\n" +
						"|4|  -  SOMATORIO DOO PRODUTOS DE ALTO GIRO\n" +
						"|5|  -  SOMATORIO DOS PRODUTOS DE BAIXO GIRO\n\n" +
						"|0|  -  SAIR"));
	}

}
