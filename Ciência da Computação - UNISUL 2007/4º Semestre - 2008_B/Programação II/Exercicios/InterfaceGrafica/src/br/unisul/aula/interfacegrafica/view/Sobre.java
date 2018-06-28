package br.unisul.aula.interfacegrafica.view;

import java.awt.Dimension;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyVetoException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Sobre extends JInternalFrame {

	private static final long serialVersionUID = 1L;
	private JPanel jContentPane = null;
	private JLabel jLabelTexto = null;
	private JButton jButtonOK = null;
	
	

	/**
	 * This is the xxx default constructor
	 */
	public Sobre() {
		super();
		initialize();
	}
	

	/**
	 * This method initializes this
	 * 
	 * @return void
	 */
	private void initialize() {
		this.setSize(300, 300);
		this.setIconifiable(true);
		this.setClosable(true);
		this.setTitle("Sobre");
		this.setContentPane(getJContentPane());
		this.setFrameIcon(new ImageIcon("images/16x16/info16x16.gif"));
	}

	/**
	 * This method initializes jContentPane
	 * 
	 * @return javax.swing.JPanel
	 */
	private JPanel getJContentPane() {
		if (jContentPane == null) {
			jLabelTexto = new JLabel();
			jLabelTexto.setText("À desenvolver...");
			jLabelTexto.setSize(new Dimension(100, 20));
			jLabelTexto.setLocation(new Point(98, 61));
			jContentPane = new JPanel();
			jContentPane.setLayout(null);
			jContentPane.add(jLabelTexto, null);
			jContentPane.add(getJButtonOK(), null);
		}
		return jContentPane;
	}

	/**
	 * This method initializes jButtonOK	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getJButtonOK() {
		if (jButtonOK == null) {
			jButtonOK = new JButton();
			jButtonOK.setLocation(new Point(100, 200));
			jButtonOK.setText("OK");
			jButtonOK.addActionListener( new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					closeFrameSobre();
				}
			});
			jButtonOK.setSize(new Dimension(100, 30));
		}
		return jButtonOK;
	}
	
	/**
	 * Método para fechar o frame Sobre.
	 */
	private void closeFrameSobre() {
		try {
			this.setClosed(true);
		} catch (PropertyVetoException e) {
			System.err.println("Erro indefinido ao fechar a janela.");
			e.printStackTrace();
		}
	}

} 
