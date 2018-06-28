import java.awt.BorderLayout;

import javax.swing.JDialog;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;


public class FrameLog extends JDialog {

	private static final long serialVersionUID = 1L;
	private JTextArea texto;
	private int count = 0;
	
	
	public FrameLog() {
		setTitle("Log do Sistema");
		setSize(800, 500);
		texto = new JTextArea();
		JScrollPane scroll = new JScrollPane(texto);
		
		getContentPane().add( scroll, BorderLayout.CENTER );
	}
	
	
	public void setTextToLog(Cromossomo cromossomo) {
		texto.setText(texto.getText() + "Iteração: " + ++count + "\t");
		texto.setText(texto.getText() + cromossomo.getCodigoGenetico().toString()+ "\t");
		texto.setText(texto.getText() + cromossomo.getFitness()+"\n\n");
	}
	
	public void setTextToLog(String text) {
		texto.setText(texto.getText() + text + "\n\n");
	}
	
	
}