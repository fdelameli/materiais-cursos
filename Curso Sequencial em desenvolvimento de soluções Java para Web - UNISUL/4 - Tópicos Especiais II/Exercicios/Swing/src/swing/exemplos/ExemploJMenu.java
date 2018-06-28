package swing.exemplos;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import javax.swing.ButtonGroup;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JRadioButtonMenuItem;


/**
 * Classe de exemplo para aprendizagem sobre o componente JMenu.
 * @author Fabio Dela Bruna.
 * @since 26/10/2008.
 */
public class ExemploJMenu extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;
	
	private JMenuBar menuBar;
	
	private JMenu menuArquivo;
	private JMenu menuArquivoNovo;
	
	private JMenuItem menuItemFechar;
	private JMenuItem menuItemNovoClasse;
	private JMenuItem menuItemNovoProjeto;
	
	private JMenu menuCodigo;
	private JCheckBoxMenuItem menuItemAutoCompletar;
	private JRadioButtonMenuItem menuItemTexto;
	private JRadioButtonMenuItem menuItemHtml;
	
	private ButtonGroup group;

	
	/**
	 * Construtor.
	 */
	public ExemploJMenu() {
		super("Exemplo JMenu");
		setSize(300, 300);
		setExtendedState(JFrame.MAXIMIZED_BOTH);
		
		menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		menuArquivo = new JMenu("Arquivo");
		menuArquivo.setMnemonic(KeyEvent.VK_A);
		menuBar.add(menuArquivo);
		
		menuItemFechar = new JMenuItem("Fechar");
		menuItemFechar.setMnemonic(KeyEvent.VK_F);
		menuItemFechar.addActionListener(this);

		menuArquivoNovo = new JMenu("Novo");
		
		menuItemNovoProjeto = new JMenuItem("Projeto");
		menuItemNovoClasse = new JMenuItem("Classe");
		
		menuArquivoNovo.add(menuItemNovoProjeto);
		menuArquivoNovo.add(menuItemNovoClasse);
		
		menuArquivo.add(menuArquivoNovo);
		menuArquivo.add(menuItemFechar);
		
		
		menuCodigo = new JMenu("Código");
		menuCodigo.setMnemonic(KeyEvent.VK_C);
		
		menuItemAutoCompletar = new JCheckBoxMenuItem("Auto completar", true); // parâmetro passado para indicar
																			   // que ele vai começar marcado.
		menuItemTexto = new JRadioButtonMenuItem("Texto");
		menuItemHtml = new JRadioButtonMenuItem("Html", true);
		
		menuCodigo.add(menuItemAutoCompletar);
		menuCodigo.addSeparator();
		
		group = new ButtonGroup();
		group.add(menuItemTexto);
		group.add(menuItemHtml);
		
		menuCodigo.add(menuItemTexto);
		menuCodigo.add(menuItemHtml);
		
		menuBar.add(menuCodigo);
		

	}
	
	
	
	
	
	
	public static void main(String[] args) {
		ExemploJMenu app = new ExemploJMenu();
		app.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		app.setVisible(true);
	}






	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == menuItemFechar) {
			System.exit(0);
		}
		
	}

}
