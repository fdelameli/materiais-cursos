package teste_para_analisador_lexico;
import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.ScrollPane;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextArea;
import javax.swing.WindowConstants;


public class TesteMatches extends JFrame {

	private static final long serialVersionUID = 1L;
	private JTextArea textArea;
	private JButton buttonOK;
	
	
	public TesteMatches () {
		super("Teste de JTextArea");
		this.setSize(300, 300);
		this.setResizable(false);
		this.setLayout(new BorderLayout());
		
		this.textArea = new JTextArea();
		this.textArea.setAutoscrolls(true);
		
		ScrollPane scroll = new ScrollPane();
		scroll.add(this.textArea);
		
		this.buttonOK = new JButton("OK");
		this.buttonOK.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				verifica(textArea.getText());
			}
		});
	
		Container c = getContentPane();
		c.add(scroll, BorderLayout.CENTER);
		c.add(this.buttonOK, BorderLayout.SOUTH);
		
//		pack();
		
		this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		this.setVisible(true);
	
	}
	
	
	/**
	 * 
	 */
	private void verifica(String c) {
			
	}
	

	public static void main(String[] args) {
		
		new	TesteMatches();
		
	}
}
