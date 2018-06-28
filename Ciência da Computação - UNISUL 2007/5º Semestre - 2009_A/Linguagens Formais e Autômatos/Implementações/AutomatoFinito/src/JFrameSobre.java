

/**
 * Classe para representar a tela Sobre.
 * @author Fabio Dela Bruna, Marcio Ozorio Teixeira.
 */
public class JFrameSobre extends javax.swing.JFrame {


	// Variables declaration - do not modify
	private static final long serialVersionUID = 1L;
	private javax.swing.JLabel jLabelDesenvolvido;
	private javax.swing.JLabel jLabelSobre;
	private javax.swing.JPanel jPanel1;
	// End of variables declaration



	/** Creates new form JFrameSobre */
	public JFrameSobre() {
		initComponents();
	}


	/** 
	 * This method is called from within the constructor to initialize the form.
	 */
	private void initComponents() {

		jPanel1 = new javax.swing.JPanel();
		jLabelDesenvolvido = new javax.swing.JLabel();
		jLabelSobre = new javax.swing.JLabel();

		setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
		setTitle("Sobre");
		setBounds(new java.awt.Rectangle(520, 350, 0, 0));
		setResizable(false);

		jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

		jLabelDesenvolvido.setText("<html><font>Desenvolvido por:<BR> <BR> <p style=\"margin-left: 16\">Fabio Dela Bruna <BR> Márcio Ozório Teixeira</p></font></html>");

		jLabelSobre.setText("<html><font>Programa Capaz de Verificar se Determinada<BR>Cadeia Informada é Valida, Baseado na <BR>Implementação de um Autômato Finito.</font></html>");

		javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
		jPanel1.setLayout(jPanel1Layout);
		jPanel1Layout.setHorizontalGroup(
				jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(jPanel1Layout.createSequentialGroup()
						.addContainerGap()
						.addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
								.addComponent(jLabelSobre)
								.addGroup(jPanel1Layout.createSequentialGroup()
										.addComponent(jLabelDesenvolvido, javax.swing.GroupLayout.DEFAULT_SIZE, 181, Short.MAX_VALUE)
										.addGap(33, 33, 33))))
		);
		
		jPanel1Layout.setVerticalGroup(
				jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(jPanel1Layout.createSequentialGroup()
						.addComponent(jLabelSobre)
						.addGap(18, 18, 18)
						.addComponent(jLabelDesenvolvido, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
						.addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);

		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
		getContentPane().setLayout(layout);
		layout.setHorizontalGroup(
				layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(layout.createSequentialGroup()
						.addContainerGap()
						.addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
						.addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		
		layout.setVerticalGroup(
				layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(layout.createSequentialGroup()
						.addContainerGap()
						.addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
						.addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);

		pack();
	}

}
