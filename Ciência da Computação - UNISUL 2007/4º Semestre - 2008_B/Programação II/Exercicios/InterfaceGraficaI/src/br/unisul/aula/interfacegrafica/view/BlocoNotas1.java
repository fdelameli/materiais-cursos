package br.unisul.aula.interfacegrafica.view;

import javax.swing.JInternalFrame;

public class BlocoNotas1 extends JInternalFrame {
	
	private static final long serialVersionUID = 1L;

	public BlocoNotas1() {
		
		super ("Bloco de Notas");

		this.setSize(500, 500);
	
		this.setDefaultCloseOperation(JInternalFrame.DISPOSE_ON_CLOSE);
	
		this.setVisible(true);
	
		
		
	}
	
	public static void main(String[] args) {
		new BlocoNotas1();
	}
	

}
