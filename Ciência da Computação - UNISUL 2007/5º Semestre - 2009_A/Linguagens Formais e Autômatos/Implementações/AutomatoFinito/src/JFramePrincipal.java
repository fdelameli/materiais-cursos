
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

/**
 * Classe para representar a tela Principal.
 * @author Fabio Dela Bruna, Marcio Ozorio Teixeira.
 */
public class JFramePrincipal extends javax.swing.JFrame {


	// Variables declaration - do not modify
	private static final long serialVersionUID = 1L;
	private javax.swing.JButton jButtonAlterarCadeia;
	private javax.swing.JButton jButtonNovaCadeia;
	private javax.swing.JButton jButtonVerificarCadeia;
	private javax.swing.JLabel jLabelCadeia;
	private javax.swing.JLabel jLabelResultado;
	private javax.swing.JMenu jMenuAjuda;
	private javax.swing.JMenuBar jMenuBarPrincipal;
	private javax.swing.JMenuItem jMenuItem1;
	private javax.swing.JMenuItem jMenuItemDesenho;
	private javax.swing.JMenuItem jMenuItemSobre;
	private javax.swing.JMenu jMenuPrincipal;
	private javax.swing.JPanel jPanelResultado;
	private javax.swing.JSeparator jSeparatorPrincipal;
	private javax.swing.JTextField jTextFieldCadeia;
	// End of variables declaration



	/** Creates new form JFramePrincipal */
	public JFramePrincipal() {
		initComponents();
	}


	/** 
	 * This method is called from within the constructor to initialize the form.
	 */
	private void initComponents() {

		jLabelCadeia = new javax.swing.JLabel();
		jTextFieldCadeia = new javax.swing.JTextField();
		jButtonNovaCadeia = new javax.swing.JButton();
		jButtonVerificarCadeia = new javax.swing.JButton();
		jButtonAlterarCadeia = new javax.swing.JButton();
		jSeparatorPrincipal = new javax.swing.JSeparator();
		jPanelResultado = new javax.swing.JPanel();
		jLabelResultado = new javax.swing.JLabel();
		jMenuBarPrincipal = new javax.swing.JMenuBar();
		jMenuPrincipal = new javax.swing.JMenu();
		jMenuItemDesenho = new javax.swing.JMenuItem();
		jMenuItem1 = new javax.swing.JMenuItem();
		jMenuAjuda = new javax.swing.JMenu();
		jMenuItemSobre = new javax.swing.JMenuItem();

		setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
		setResizable(false);
		setTitle("Autômatos");
		setBounds(new java.awt.Rectangle(450, 250, 0, 0));
		setName("framePricnipal");

		jLabelCadeia.setText("Digite a Cadeia:");

		jTextFieldCadeia.setBorder(javax.swing.BorderFactory.createEtchedBorder());
		jTextFieldCadeia.setEnabled(false);

		jButtonNovaCadeia.setText("Nova Cadeia");
		jButtonNovaCadeia.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jButtonNovaCadeiaActionPerformed(evt);
			}
		});

		jButtonVerificarCadeia.setText("Verificar Cadeia");
		jButtonVerificarCadeia.setEnabled(false);
		jButtonVerificarCadeia.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jButtonVerificarCadeiaActionPerformed(evt);
			}
		});

		jButtonAlterarCadeia.setText("Alterar Cadeia");
		jButtonAlterarCadeia.setEnabled(false);
		jButtonAlterarCadeia.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jButtonAlterarCadeiaActionPerformed(evt);
			}
		});

		jPanelResultado.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Resultado"));
		jLabelResultado.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
		javax.swing.GroupLayout jPanelResultadoLayout = new javax.swing.GroupLayout(jPanelResultado);
		jPanelResultado.setLayout(jPanelResultadoLayout);
		jPanelResultadoLayout.setHorizontalGroup(
				jPanelResultadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(jPanelResultadoLayout.createSequentialGroup()
						.addContainerGap()
						.addComponent(jLabelResultado, javax.swing.GroupLayout.DEFAULT_SIZE, 354, Short.MAX_VALUE)
						.addContainerGap())
		);

		jPanelResultadoLayout.setVerticalGroup(
				jPanelResultadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(jPanelResultadoLayout.createSequentialGroup()
						.addContainerGap()
						.addComponent(jLabelResultado, javax.swing.GroupLayout.DEFAULT_SIZE, 96, Short.MAX_VALUE)
						.addContainerGap())
		);

		jMenuPrincipal.setText("Menu");

		jMenuItemDesenho.setText("Desenho do Autômato");
		jMenuItemDesenho.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jMenuItemDesenhoActionPerformed(evt);
			}
		});

		jMenuPrincipal.add(jMenuItemDesenho);

		jMenuItem1.setText("Sair");
		jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jMenuItem1ActionPerformed(evt);
			}
		});

		jMenuPrincipal.add(jMenuItem1);

		jMenuBarPrincipal.add(jMenuPrincipal);

		jMenuAjuda.setText("Ajuda");

		jMenuItemSobre.setText("Sobre");
		jMenuItemSobre.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jMenuItemSobreActionPerformed(evt);
			}
		});

		jMenuAjuda.add(jMenuItemSobre);

		jMenuBarPrincipal.add(jMenuAjuda);

		setJMenuBar(jMenuBarPrincipal);

		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
		getContentPane().setLayout(layout);
		layout.setHorizontalGroup(
				layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(layout.createSequentialGroup()
						.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
								.addGroup(layout.createSequentialGroup()
										.addContainerGap()
										.addComponent(jLabelCadeia)
										.addGap(18, 18, 18))
										.addGroup(layout.createSequentialGroup()
												.addContainerGap()
												.addComponent(jSeparatorPrincipal, javax.swing.GroupLayout.DEFAULT_SIZE, 386, Short.MAX_VALUE))
												.addGroup(layout.createSequentialGroup()
														.addContainerGap()
														.addComponent(jPanelResultado, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
														.addGroup(layout.createSequentialGroup()
																.addGap(20, 20, 20)
																.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
																		.addGroup(layout.createSequentialGroup()
																				.addGap(10, 10, 10)
																				.addComponent(jButtonNovaCadeia, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
																				.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
																				.addComponent(jButtonAlterarCadeia)
																				.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
																				.addComponent(jButtonVerificarCadeia))
																				.addComponent(jTextFieldCadeia, javax.swing.GroupLayout.DEFAULT_SIZE, 376, Short.MAX_VALUE))))
																				.addContainerGap())
		);

		layout.setVerticalGroup(
				layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(layout.createSequentialGroup()
						.addGap(19, 19, 19)
						.addComponent(jLabelCadeia)
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
						.addComponent(jTextFieldCadeia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
						.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
								.addComponent(jButtonAlterarCadeia)
								.addComponent(jButtonNovaCadeia)
								.addComponent(jButtonVerificarCadeia))
								.addGap(18, 18, 18)
								.addComponent(jSeparatorPrincipal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
								.addGap(18, 18, 18)
								.addComponent(jPanelResultado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
								.addContainerGap(19, Short.MAX_VALUE))
		);

		pack();
	}


	// Methods declaration

	private void jButtonNovaCadeiaActionPerformed(java.awt.event.ActionEvent evt) {
		jTextFieldCadeia.setEnabled(true);
		jTextFieldCadeia.setEditable(true);
		jTextFieldCadeia.setText(null);
		jTextFieldCadeia.requestFocus();
		jButtonNovaCadeia.setEnabled(false);
		jButtonAlterarCadeia.setEnabled(false);
		jButtonVerificarCadeia.setEnabled(true);
		jLabelResultado.setText("");
	}

	private void jButtonAlterarCadeiaActionPerformed(java.awt.event.ActionEvent evt) {
		jTextFieldCadeia.setEditable(true);
		jTextFieldCadeia.requestFocus();
		jButtonNovaCadeia.setEnabled(false);
		jButtonAlterarCadeia.setEnabled(false);
		jButtonVerificarCadeia.setEnabled(true);
		jLabelResultado.setText("");
	}


	private void jButtonVerificarCadeiaActionPerformed(java.awt.event.ActionEvent evt) {

		String cadeia = jTextFieldCadeia.getText();
		String caracterErr = "";
		caracterErr = AutomatoIdentificador.isChainValid(jTextFieldCadeia.getText());

		if (jTextFieldCadeia.getText().trim().length() == 0) {
			JOptionPane.showMessageDialog(this, "Digite uma Cadeia para Ser Verificada!", "Autômatos - ERRO!", JOptionPane.ERROR_MESSAGE);
			jTextFieldCadeia.requestFocus();

		} else {

			if (!caracterErr.equals("ok")) {
				JOptionPane.showMessageDialog(this, "Cadeia Possui Caracter Inválido: " + caracterErr, "Autômatos - ERRO!", JOptionPane.ERROR_MESSAGE);
				cadeia = cadeia.replace(caracterErr, "");
				jTextFieldCadeia.setText(cadeia);
				jTextFieldCadeia.requestFocus();

			} else {
				if (AutomatoIdentificador.recognizer(cadeia)) {

					jLabelResultado.setText("<html><font color='green' size=7>CADEIA VÁLIDA!</font></html>");

					if (jTextFieldCadeia.getText().trim().length() > 20)
						JOptionPane.showMessageDialog(this, "A cadeia verificada é válida,\n" +
								"Porém possui mais que 20 Caracteres!\nPossui um total de: " + jTextFieldCadeia.getText().trim().length() + " Caracteres.", 
								"Autômatos - Warning!", JOptionPane.WARNING_MESSAGE);

					jTextFieldCadeia.setEditable(false);
					jButtonNovaCadeia.setEnabled(true);
					jButtonAlterarCadeia.setEnabled(true);
					jButtonVerificarCadeia.setEnabled(false);
				} else {

					jLabelResultado.setText("<html><font color='red' size=20>CADEIA INVÁLIDA!</font></html>");
					jTextFieldCadeia.setEditable(false);
					jButtonNovaCadeia.setEnabled(true);
					jButtonAlterarCadeia.setEnabled(true);
					jButtonVerificarCadeia.setEnabled(false);
				}
			}
		}
	}

	private void jMenuItemDesenhoActionPerformed(java.awt.event.ActionEvent evt) {
		Icon imagem = new ImageIcon("imagem/auto.png");
		JLabel labelDesenho = new JLabel();
		labelDesenho.setIcon(imagem);
		JOptionPane.showMessageDialog(null, labelDesenho, "Autômatos - Desenho!", JOptionPane.PLAIN_MESSAGE);
	}

	private void jMenuItemSobreActionPerformed(java.awt.event.ActionEvent evt) {
		JFrameSobre js = new JFrameSobre();
		js.setVisible(true);
	}

	private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {
		System.exit(0);
	}

	// End of methods declaration
}
