package br.unisul.aula.interfacegrafica.view;

import java.awt.Dimension;
import java.awt.Rectangle;

import javax.swing.JInternalFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class BlocoNotas extends JInternalFrame {

	private static final long serialVersionUID = 1L;
	private JPanel jContentPane = null;
	private JMenuBar jMenuBar = null;
	private JMenu jMenuArquivo = null;
	private JMenu jMenuAjuda = null;
	private JMenuItem jMenuItemSobre = null;
	private JMenuItem jMenuItemSair = null;
	private JTextArea jTextArea = null;
	
	/**
	 * This is the xxx default constructor
	 */
	public BlocoNotas() {
		super();
		initialize();
	}

	/**
	 * This method initializes this
	 * 
	 * @return void
	 */
	private void initialize() {
		this.setSize(506, 419);
		this.setJMenuBar(getJMenuBar());
		this.setTitle("Bloco de Notas");
		this.setClosable(true);
		this.setMaximizable(true);
		this.setIconifiable(true);
		this.setContentPane(getJContentPane());
	}

	/**
	 * This method initializes jContentPane
	 * 
	 * @return javax.swing.JPanel
	 */
	private JPanel getJContentPane() {
		if (jContentPane == null) {
			jContentPane = new JPanel();
			jContentPane.setLayout(null);
			jContentPane.add(getJTextArea(), null);
		}
		return jContentPane;
	}

	/**
	 * This method initializes jMenuBar	
	 * 	
	 * @return javax.swing.JMenuBar	
	 */
	public JMenuBar getJMenuBar() {
		if (jMenuBar == null) {
			jMenuBar = new JMenuBar();
			jMenuBar.setPreferredSize(new Dimension(20, 20));
			jMenuBar.add(getJMenuArquivo());
			jMenuBar.add(getJMenuAjuda());
		}
		return jMenuBar;
	}

	/**
	 * This method initializes jMenuArquivo	
	 * 	
	 * @return javax.swing.JMenu	
	 */
	private JMenu getJMenuArquivo() {
		if (jMenuArquivo == null) {
			jMenuArquivo = new JMenu();
			jMenuArquivo.setText("Arquivo");
			jMenuArquivo.add(getJMenuItemSair());
		}
		return jMenuArquivo;
	}

	/**
	 * This method initializes jMenuAjuda	
	 * 	
	 * @return javax.swing.JMenu	
	 */
	private JMenu getJMenuAjuda() {
		if (jMenuAjuda == null) {
			jMenuAjuda = new JMenu();
			jMenuAjuda.setText("Ajuda");
			jMenuAjuda.add(getJMenuItemSobre());
		}
		return jMenuAjuda;
	}

	/**
	 * This method initializes jMenuItemSobre	
	 * 	
	 * @return javax.swing.JMenuItem	
	 */
	private JMenuItem getJMenuItemSobre() {
		if (jMenuItemSobre == null) {
			jMenuItemSobre = new JMenuItem();
		}
		return jMenuItemSobre;
	}

	/**
	 * This method initializes jMenuItemSair	
	 * 	
	 * @return javax.swing.JMenuItem	
	 */
	private JMenuItem getJMenuItemSair() {
		if (jMenuItemSair == null) {
			jMenuItemSair = new JMenuItem();
		}
		return jMenuItemSair;
	}

	/**
	 * This method initializes jTextArea	
	 * 	
	 * @return javax.swing.JTextArea	
	 */
	private JTextArea getJTextArea() {
		if (jTextArea == null) {
			jTextArea = new JTextArea();
			jTextArea.setBounds(new Rectangle(0, 0, 513, 386));
		}
		return jTextArea;
	}

}  //  @jve:decl-index=0:visual-constraint="10,10"
