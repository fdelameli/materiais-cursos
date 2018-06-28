import javax.swing.JOptionPane;


public class LogTela extends LogBase {

	protected void log(String tipo, String data, String message) {
		JOptionPane.showMessageDialog(null, tipo + ": " + data + ": " + message);	
	}

}
