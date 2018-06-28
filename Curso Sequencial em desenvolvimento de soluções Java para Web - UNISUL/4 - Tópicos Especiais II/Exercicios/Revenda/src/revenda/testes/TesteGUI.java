package revenda.testes;

import javax.swing.UIManager;

import revenda.gui.FramePrincipal;
import revenda.gui.Splash;

public class TesteGUI {

	public static void main(String[] args) {
		
		Splash.getInstance().inicia("images/abertura.png", "Carregando o sistema...");
		
		try {
			
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());  // LookAndFeel do Sistema Operacional.
//			UIManager.setLookAndFeel("net.sourceforge.napkinlaf.NapkinLookAndFeel");  // --> LookAndFeel Personalizado.
			
		} catch (Exception e) {
			
		}
		for (long i = 0; i < 1000000000; i++) {
		//	System.out.println("I = " + i);
		}
		
		FramePrincipal app = new FramePrincipal();
		app.showPrincipalFrame();
		
		Splash.getInstance().finaliza();
	}
}
