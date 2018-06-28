import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableColumnModel;

/**
 * Classe gráfica que representa uma tabela
 * onde será mostrados o resultado da análise léxica.
 * 
 * @author Fabio Dela Bruna, Márcio Ozório Teixeira.
 */
public class TabelaSimbolosReconhecidos extends javax.swing.JFrame {


	// Variables declaration - do not modify   
	private static final long serialVersionUID = 1L;
	private javax.swing.JLabel jLabel1;
	private javax.swing.JScrollPane jScrollPane1;
	private javax.swing.JScrollPane jScrollPane2;
	private javax.swing.JTable jTable1;
	private javax.swing.JTextArea jTextArea1;
	private DefaultTableModel dtm;
	// End of variables declaration  


	/**
	 * Construtor da Classe. Chama o método
	 * que inicializa os componentes da janela.
	 */
	public TabelaSimbolosReconhecidos() {
		initComponents();
	}

	
	
	/**
	 * Recebe por parâmetro o log da análise.
	 */
	public void setLog(String log) {
		this.jTextArea1.setText(log);
	}
	
	
	
	/**
	 * Método privado que inicializa e monta
	 * os componentes da janela.                       
	 */
	private void initComponents() {

		jScrollPane1 = new javax.swing.JScrollPane();
		jTable1 = new javax.swing.JTable();
		jScrollPane2 = new javax.swing.JScrollPane();
		jTextArea1 = new javax.swing.JTextArea();
		jLabel1 = new javax.swing.JLabel();

		setTitle("Tabela de Tokens Reconhecidos");
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

		
		jTable1.setModel(new javax.swing.table.DefaultTableModel(
				new Object [][] {},
				new String [] {"Código", "Token", "Descrição"}
		));
		jTable1.setEnabled(false);
		defineRenderers();
		
		jScrollPane1.setViewportView(jTable1);

		jTextArea1.setColumns(20);
		jTextArea1.setRows(5);
		jTextArea1.setEditable(false);
		jScrollPane2.setViewportView(jTextArea1);

		jLabel1.setText("Log:");

		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
		getContentPane().setLayout(layout);
		layout.setHorizontalGroup(
				layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
						.addContainerGap()
						.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
								.addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 380, Short.MAX_VALUE)
								.addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 380, Short.MAX_VALUE)
								.addComponent(jLabel1, javax.swing.GroupLayout.Alignment.LEADING))
								.addContainerGap())
		);
		layout.setVerticalGroup(
				layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
						.addContainerGap()
						.addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 344, Short.MAX_VALUE)
						.addGap(18, 18, 18)
						.addComponent(jLabel1)
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
						.addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
						.addContainerGap())
		);

//		pack();
         
	}
	
	/**
	 * Método privado que define uma largura
	 * específica para cada coluna da tabela.
	 */
	private void defineRenderers() {  
		DefaultTableCellRenderer rendererCentro = new DefaultTableCellRenderer();  
		rendererCentro.setHorizontalAlignment(SwingConstants.CENTER);  
		DefaultTableCellRenderer rendererDireita = new DefaultTableCellRenderer();  
		rendererDireita.setHorizontalAlignment(SwingConstants.RIGHT);  
		DefaultTableCellRenderer rendererEsquerda = new DefaultTableCellRenderer();  
		rendererEsquerda.setHorizontalAlignment(SwingConstants.LEFT);  

		JTableHeader header = jTable1.getTableHeader();   
		header.setPreferredSize(new Dimension(0, 35));   
		TableColumnModel modeloDaColuna = jTable1.getColumnModel();  

		modeloDaColuna.getColumn(0).setCellRenderer(rendererCentro);  
		modeloDaColuna.getColumn(1).setCellRenderer(rendererCentro);  
		modeloDaColuna.getColumn(2).setCellRenderer(rendererCentro);  

		modeloDaColuna.getColumn(0).setMaxWidth(50);  
		modeloDaColuna.getColumn(1).setMaxWidth(260);
		modeloDaColuna.getColumn(1).setMinWidth(175);
		modeloDaColuna.getColumn(2).setMaxWidth(165);  
		modeloDaColuna.getColumn(2).setMinWidth(125);  
	}  
	
	
	/**
	 * Método que é chamado a cada token reconhecido na análise.
	 * É responsável por jogar os dados da análise na tabela.
	 */
	public void setaValoresNaTabela(int codigo, String token, String descricao) {
		dtm = (DefaultTableModel) jTable1.getModel();
		
		// Adiciona os dados na tabela.
		dtm.addRow(new Object[] {
				codigo,	token, descricao }
		);
		
	}


}
