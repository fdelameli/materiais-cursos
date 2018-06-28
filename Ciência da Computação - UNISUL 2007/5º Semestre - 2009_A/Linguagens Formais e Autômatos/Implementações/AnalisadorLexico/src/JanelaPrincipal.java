import java.awt.Toolkit;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;
import javax.swing.WindowConstants;

/**
 * Classe que inicializa a Tela principal do
 * programa, tal como seus componentes.
 * 
 * @author Fabio Dela Bruna, Márcio Ozório Teixeira.
 * 
 */
public class JanelaPrincipal extends javax.swing.JFrame implements ActionListener {

	// Variables declaration - do not modify     
	private static final long serialVersionUID = 1L;
	private javax.swing.JButton jButton1;
	private javax.swing.JButton jButton2;
	private javax.swing.JMenu jMenu1;
	private javax.swing.JMenu jMenu2;
	private javax.swing.JMenuBar jMenuBar1;
	private javax.swing.JMenuItem jMenuItem1;
	private javax.swing.JMenuItem jMenuItem2;
	private javax.swing.JMenuItem jMenuItem3;
	private javax.swing.JMenuItem jMenuItem4;
	private javax.swing.JMenuItem jMenuItem5;
	private javax.swing.JScrollPane jScrollPane1;
	private javax.swing.JSeparator jSeparator3;
	private javax.swing.JTextArea jTextArea1;
	// End of variables declaration     



	/**
	 * Contrutor da classe. Chama o método
	 * que inicializa a interface gráfica.
	 */
	public JanelaPrincipal() {
		initComponents();
	}


	/**
	 * Método privado responsável por inicializar todos
	 * os componentes e formar a tela principal do programa.
	 */
	private void initComponents() {

		setTitle("Analizador Léxico Para Lingagem LMS");
		setResizable(false);
		setSize(500,500);

		int screenX = (int)Toolkit.getDefaultToolkit().getScreenSize().getWidth();
		int screenY = (int)Toolkit.getDefaultToolkit().getScreenSize().getHeight();

		int frameX = (int)getSize().getWidth();
		int frameY = (int)getSize().getHeight();

		setLocation(
				(int)(screenX/2)-(frameX/2),
				(int)(screenY/2)-(frameY/2)
		);

		jScrollPane1 = new javax.swing.JScrollPane();
		jTextArea1 = new javax.swing.JTextArea();
		jButton1 = new javax.swing.JButton();
		jButton2 = new javax.swing.JButton();
		jMenuBar1 = new javax.swing.JMenuBar();
		jMenu1 = new javax.swing.JMenu();
		jMenuItem1 = new javax.swing.JMenuItem();
		jMenuItem2 = new javax.swing.JMenuItem();
		jSeparator3 = new javax.swing.JSeparator();
		jMenuItem3 = new javax.swing.JMenuItem();
		jMenu2 = new javax.swing.JMenu();
		jMenuItem4 = new javax.swing.JMenuItem();
		jMenuItem5 = new javax.swing.JMenuItem();

		jTextArea1.setColumns(20);
		jTextArea1.setRows(5);
		jScrollPane1.setViewportView(jTextArea1);

		jButton1.setText("Iniciar Análise");
		jButton1.addActionListener(this);

		jButton2.setText("Tabela de Símbolos");
		jButton2.addActionListener(this);

		jMenu1.setText("Arquivo");

		jMenuItem1.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_N, java.awt.event.InputEvent.CTRL_MASK));
		jMenuItem1.setText("Iniciar Análise");
		jMenuItem1.addActionListener(this);
		jMenu1.add(jMenuItem1);

		jMenuItem2.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_A, java.awt.event.InputEvent.CTRL_MASK));
		jMenuItem2.setText("Desenho do Autômato");
		jMenuItem2.addActionListener(this);

		jMenuItem5.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_T, java.awt.event.InputEvent.CTRL_MASK));
		jMenuItem5.setText("Tabela de Símbolos");
		jMenuItem5.addActionListener(this);

		jMenu1.add(jMenuItem5);
		jMenu1.add(jMenuItem2);

		jMenu1.add(jSeparator3);

		jMenuItem3.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F4, java.awt.event.InputEvent.ALT_MASK));
		jMenuItem3.setText("Sair");
		jMenuItem3.addActionListener(this);
		jMenu1.add(jMenuItem3);

		jMenuBar1.add(jMenu1);

		jMenu2.setText("Ajuda");

		jMenuItem4.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_J, java.awt.event.InputEvent.CTRL_MASK));
		jMenuItem4.setText("Sobre");
		jMenuItem4.addActionListener(this);
		jMenu2.add(jMenuItem4);

		jMenuBar1.add(jMenu2);

		setJMenuBar(jMenuBar1);

		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
		getContentPane().setLayout(layout);
		layout.setHorizontalGroup(
				layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
						.addContainerGap()
						.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
								.addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 380, Short.MAX_VALUE)
								.addGroup(layout.createSequentialGroup()
										.addComponent(jButton2)
										.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
										.addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))
										.addContainerGap())
		);
		layout.setVerticalGroup(
				layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
						.addContainerGap()
						.addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 423, Short.MAX_VALUE)
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
						.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
								.addComponent(jButton1)
								.addComponent(jButton2))
								.addContainerGap())
		);

	}         



	/**
	 * Inicia a análise.
	 */
	private void iniciaAnalise() {
		if (jTextArea1.getText().isEmpty()) {
			JOptionPane.showMessageDialog(this, "Digite o código no campo de texto!",
					"Erro!", JOptionPane.ERROR_MESSAGE);
			jTextArea1.requestFocus();
		} else {
			Analisador ana = new Analisador();
			TabelaSimbolosReconhecidos tab = ana.efetuarAnalise(jTextArea1.getText());
			tab.setLog(ana.getLog());
			tab.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			tab.setVisible(true);
		}
	}

	/**
	 * Abre a Tabela de Símbolos.
	 */
	private void abreTabelaSimbolos() {
		TabelaSimbolos t = new TabelaSimbolos(this);
		t.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		t.setVisible(true);
	}

	/**
	 * Abre a tela Sobre.
	 */
	private void abreJDialogSobre() {
		Sobre s = new Sobre(this);
		s.setVisible(true);
	}

	/**
	 * Abre o desenho do autômato.
	 */
	private void abreJFrameDesenho() {
		DesenhoAutomato des = new DesenhoAutomato();
		des.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		des.setVisible(true);
	}


	/**
	 * Método privado responsável pela ação
	 * dos componentes da tela.
	 */
	public void actionPerformed(java.awt.event.ActionEvent evt) {   

		if (evt.getSource() == jButton1) {
			iniciaAnalise();
		} else if (evt.getSource() == jButton2) {
			abreTabelaSimbolos();
		} else if (evt.getSource() == jMenuItem1) {
			iniciaAnalise();
		} else if (evt.getSource() == jMenuItem2) {
			abreJFrameDesenho();
		} else if (evt.getSource() == jMenuItem3) {
			System.exit(0);
		} else if (evt.getSource() == jMenuItem4) {
			abreJDialogSobre();
		} else if (evt.getSource() == jMenuItem5) {
			abreTabelaSimbolos();
		}


	}                                      

}
