package meubanco.testes;

import javax.swing.UIManager;
import javax.swing.UIManager.LookAndFeelInfo;

public class TesteLookAndFeel {

	public static void main(String[] args) {
		
//		javax.swing.plaf.metal.MetalLookAndFeel
//		com.sun.java.swing.plaf.motif.MotifLookAndFeel
//		com.sun.java.swing.plaf.windows.WindowsLookAndFeel
//		com.sun.java.swing.plaf.windows.WindowsClassicLookAndFeel
		
		LookAndFeelInfo[] lookAndFeelInfo = UIManager.getInstalledLookAndFeels();

		for (LookAndFeelInfo info : lookAndFeelInfo) {
			System.out.println(info.getClassName());
		}
	}
}
