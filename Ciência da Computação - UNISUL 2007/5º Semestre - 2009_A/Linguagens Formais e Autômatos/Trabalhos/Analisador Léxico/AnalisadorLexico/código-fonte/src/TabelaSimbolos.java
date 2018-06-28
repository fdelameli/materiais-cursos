import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableColumnModel;

/**
 * Classe gráfica que representa uma tabela
 * para exibir os símbolos que devem ser reconhecidos.
 * 
 * @author Fabio Dela Bruna, Márcio Ozório Teixeira.
 */
public class TabelaSimbolos extends javax.swing.JFrame implements ConstantsInterface {


	// Variables declaration - do not modify   
	private static final long serialVersionUID = 1L;
	private javax.swing.JScrollPane jScrollPane1;
	private javax.swing.JTable jTable1;
	private DefaultTableModel dtm;
	// End of variables declaration  


	/**
	 * Construtor da Classe. Chama o método
	 * que inicializa os componentes da janela.
	 */
	public TabelaSimbolos(JFrame parent) {
		initComponents();
		setLocation(parent.getLocation());
	}


	/**
	 * Método privado que inicializa e monta
	 * os componentes da janela.                       
	 */
	private void initComponents() {

		jScrollPane1 = new javax.swing.JScrollPane();
		jTable1 = new javax.swing.JTable();

		setTitle("Tabela de Símbolos Terminais");
		setResizable(false);
		setSize(500,500);


		jTable1.setModel(new javax.swing.table.DefaultTableModel(
				new Object [][] {},
				new String [] {"Código", "Token", "Descrição"}
		));
		jTable1.setEnabled(false);
		defineRenderers();
		setaValoresNaTabela();

		jScrollPane1.setViewportView(jTable1);

		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
		getContentPane().setLayout(layout);
		layout.setHorizontalGroup(
				layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
						.addContainerGap()
						.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
								.addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 380, Short.MAX_VALUE))
								.addContainerGap())
		);
		layout.setVerticalGroup(
				layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
						.addContainerGap()
						.addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 344, Short.MAX_VALUE)
						.addGap(18, 18, 18)
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
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
	 * É responsável por jogar os dados na tabela.
	 */
	private void setaValoresNaTabela() {
		dtm = (DefaultTableModel) jTable1.getModel();

		// Preenche a tabela com as palavras reservadas.
		for (int j = 0; j < 21; j++) {
			dtm.addRow(new Object[] {j+1, SYMBOLS_TABLE.get(j), PALAVRA_RESERVADA} );
		}

		dtm.addRow(new Object[] {22, SYMBOLS_TABLE.get(21), OPERADOR} );
		dtm.addRow(new Object[] {23, SYMBOLS_TABLE.get(22), OPERADOR} );
		dtm.addRow(new Object[] {24, SYMBOLS_TABLE.get(23), OPERADOR} );
		dtm.addRow(new Object[] {25, SYMBOLS_TABLE.get(24), IDENTIFICADOR} );
		dtm.addRow(new Object[] {26, SYMBOLS_TABLE.get(25), INTEIRO} );
		dtm.addRow(new Object[] {27, SYMBOLS_TABLE.get(26), PALAVRA_RESERVADA} );
		dtm.addRow(new Object[] {28, SYMBOLS_TABLE.get(27), PALAVRA_RESERVADA} );
		dtm.addRow(new Object[] {29, SYMBOLS_TABLE.get(28), PALAVRA_RESERVADA} );
		dtm.addRow(new Object[] {30, SYMBOLS_TABLE.get(29), OPERADOR} );
		dtm.addRow(new Object[] {31, SYMBOLS_TABLE.get(30), OPERADOR} );
		dtm.addRow(new Object[] {32, SYMBOLS_TABLE.get(31), OPERADOR} );
		dtm.addRow(new Object[] {33, SYMBOLS_TABLE.get(32), OPERADOR} );
		dtm.addRow(new Object[] {34, SYMBOLS_TABLE.get(33), SIMBOLO_ESPECIAL} );
		dtm.addRow(new Object[] {35, SYMBOLS_TABLE.get(34), SIMBOLO_ESPECIAL} );
		dtm.addRow(new Object[] {36, SYMBOLS_TABLE.get(35), SIMBOLO_ESPECIAL} );
		dtm.addRow(new Object[] {37, SYMBOLS_TABLE.get(36), SIMBOLO_ESPECIAL} );
		dtm.addRow(new Object[] {38, SYMBOLS_TABLE.get(37), OPERADOR} );
		dtm.addRow(new Object[] {39, SYMBOLS_TABLE.get(38), SIMBOLO_ESPECIAL} );
		dtm.addRow(new Object[] {40, SYMBOLS_TABLE.get(39), OPERADOR} );
		dtm.addRow(new Object[] {41, SYMBOLS_TABLE.get(40), OPERADOR} );
		dtm.addRow(new Object[] {42, SYMBOLS_TABLE.get(41), OPERADOR} );
		dtm.addRow(new Object[] {43, SYMBOLS_TABLE.get(42), OPERADOR} );
		dtm.addRow(new Object[] {44, SYMBOLS_TABLE.get(43), OPERADOR} );
		dtm.addRow(new Object[] {45, SYMBOLS_TABLE.get(44), OPERADOR} );
		dtm.addRow(new Object[] {46, SYMBOLS_TABLE.get(45), SIMBOLO_ESPECIAL} );
		dtm.addRow(new Object[] {47, SYMBOLS_TABLE.get(46), SIMBOLO_ESPECIAL} );
		dtm.addRow(new Object[] {48, SYMBOLS_TABLE.get(47), LITERAL} );
		dtm.addRow(new Object[] {49, SYMBOLS_TABLE.get(48), SIMBOLO_ESPECIAL} );
		dtm.addRow(new Object[] {50, SYMBOLS_TABLE.get(49), SIMBOLO_ESPECIAL} );
		dtm.addRow(new Object[] {51, SYMBOLS_TABLE.get(50), "FINAL DE ARQUIVO"} );


	}


}
