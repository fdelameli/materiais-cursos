package compiladorLMS.gui.lexico;

import java.awt.Dimension;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableColumnModel;

import compiladorLMS.analise_lexica.Token;
import compiladorLMS.gui.JDialogBase;


/**
 * Classe que mostra a tabela de tokens reconhecidos pela análise léxica.
 * @author Fabio Dela Bruna, Márcio Ozório Teixeira.
 */
public class AnaliseLexicaGUI extends JDialogBase {
	
	private static final long serialVersionUID = 1L;
	private javax.swing.JScrollPane scrollPane; // barra de relagem
	private javax.swing.JTable table; // tabela para exibir os simbolos
	private DefaultTableModel dtm; // modelo da tabela
	
	
	/**
	 * Construtor da classe. Monta a GUI.
	 */
	public AnaliseLexicaGUI( JFrame parent, ArrayList<Token> tokens ) {
		setTitle( "Tabela de Símbolos Reconhecidos" );
		setResizable( false );
		setSize( 500,500 );
	
		scrollPane = new JScrollPane();
		
		table = new JTable();
		table.setModel( new DefaultTableModel(
				new Object [][] {},
				new String [] { "Código", "Token", "Descrição" }
		));
		
		table.setEnabled( false );
		
		defineRenderers();

		setaValoresNaTabela( tokens );
		
		scrollPane.setViewportView( table );

		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
		getContentPane().setLayout(layout);
		layout.setHorizontalGroup(
				layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
						.addContainerGap()
						.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
								.addComponent(scrollPane, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 380, Short.MAX_VALUE))
								.addContainerGap())
		);
		layout.setVerticalGroup(
				layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
						.addContainerGap()
						.addComponent(scrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 344, Short.MAX_VALUE)
						.addGap(18, 18, 18)
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
						.addContainerGap())
		);
		
    	setLocation(
            	(int)parent.getX() + (parent.getWidth()/2) - (getWidth()/2), 
            	(int)parent.getY() + (parent.getHeight()/2) - (getHeight()/2)
            );
		
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

		JTableHeader header = table.getTableHeader();   
		header.setPreferredSize(new Dimension(0, 35));   
		TableColumnModel modeloDaColuna = table.getColumnModel();  

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
	 * Método para preencher os dados dos tokens reconhecidos.
	 */
	private void setaValoresNaTabela( ArrayList<Token> tokens ) {
		dtm = ( DefaultTableModel ) table.getModel();
		
		for ( int i = 0; i < tokens.size(); i++ ) {
			dtm.addRow( new Object[] { tokens.get(i).getCodigo(),
										tokens.get(i).getToken(),
										tokens.get(i).getTipo() } );
		}
		
		
	}
	
}
