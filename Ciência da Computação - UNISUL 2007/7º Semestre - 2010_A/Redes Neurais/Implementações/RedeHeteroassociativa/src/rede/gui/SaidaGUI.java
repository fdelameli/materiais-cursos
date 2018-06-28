package rede.gui;

import java.awt.BorderLayout;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class SaidaGUI extends JDialog {

	private static final long serialVersionUID = 1L;
	private JTextArea textArea;



	/**
	 * Construtor da classe.
	 * Monta a interface e inicializa os componentes.
	 * @param matrizEntrada Matriz de entrada que representa a letra que o usuário escolheu!
	 */
	public SaidaGUI( String letra, JFrame parent  ) {

		String url = "arquivos/treinamento/saidas/";

		if ( letra.equals( "A" ) ) url += "A2.txt";
		else if ( letra.equals( "B" ) ) url += "B2.txt";
		else if ( letra.equals( "C" ) ) url += "C2.txt";

		String texto = leArquivo( new File( url ) );

		setTitle( "Saída" );

		textArea = new JTextArea( texto );
		textArea.setOpaque( false );
		textArea.setEditable( false );

		JPanel panel = new JPanel();
		panel.add( textArea, BorderLayout.CENTER );

		add( panel, BorderLayout.CENTER );

		pack();

		// Seta localização da janela.

		int eixoY = ( parent.getY() + parent.getHeight() / 2 ) - ( getHeight() / 2 );
		int eixoX = parent.getX() + parent.getWidth();
		setLocation( eixoX , eixoY );

		//.

	}


	/**
	 * Le o arquivo passado por parâmetro para posteriormente ser exibido na tela.
	 */
	private String leArquivo( File arquivo ) {
		FileReader reader = null;
		String texto = "";
		char c;

		try {
			reader = new FileReader( arquivo );
			while ( reader.ready() ) {

				c = ( char )reader.read();
				texto += c;

			}
		} catch ( IOException ioe ) {
			JOptionPane.showMessageDialog( null , ioe.getMessage(), "Erro!", JOptionPane.ERROR_MESSAGE );
		} finally {

			try {
				reader.close(); // fecha o arquivo
			} catch ( IOException ioe ) {
				JOptionPane.showMessageDialog( null , ioe.getMessage(), "Erro!", JOptionPane.ERROR_MESSAGE );
			}
		}
		return texto;
	}
}
