package AnalisadorLexico.EVT;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import AnalisadorLexico.GUI.GuiAnaLex;
import AnalisadorLexico.GUI.GuiTabelaResultado;
import AnalisadorLexico.Nucleo.Analisador;
import AnalisadorLexico.Nucleo.TabelaTokens;
import AnalisadorLexico.Nucleo.Token;

/**
 * Classe de eventos da GuiAnaLex.
 * @author 	Hideraldo Luís Simon Júnior
 * 			Marco Aurélio Lima Fernandes
 * 			Rodrigo Paschoal Jeremias
 * @since setembro de 2008
 *
 */
public class EvtGuiAnaLex implements ActionListener{

	public void actionPerformed(ActionEvent e) {
		if (e.getSource()==GuiAnaLex.btAnalisar){
			if (GuiAnaLex.txCadeia.getText().length()!=0){
				Analisador a= new Analisador();
				ArrayList<Token> resul= a.analisar(GuiAnaLex.txCadeia.getText());
				if (a.getERRO()){
					JOptionPane.showMessageDialog(GuiAnaLex.painel, a.getDescricaoERRO(), "Analisador Léxico", JOptionPane.ERROR_MESSAGE);
				}else{
					GuiTabelaResultado t= new GuiTabelaResultado("Resultado da Análise");
					preencheTabela(resul);
				}
			}else{
				JOptionPane.showMessageDialog(GuiAnaLex.painel, "Por favor inserir a cadeia a ser analisada.", "Analisador Léxico", JOptionPane.ERROR_MESSAGE);
			}
		}
		if (e.getSource()==GuiAnaLex.btTabela){
			TabelaTokens tb= new TabelaTokens();
			ArrayList<Token> tabelaCompleta= (tb.TabelaCompleta());
			GuiTabelaResultado t= new GuiTabelaResultado("Tabela de Tokens");
			preencheTabela(tabelaCompleta);
		}
	}
	
	/**
	 * Insere os tokens na tabela
	 * @param tokens
	 */
	private void preencheTabela(ArrayList<Token> tokens){
		for (int i=0; i<tokens.size(); i++){
			String[] dados= {
					tokens.get(i).getCodigo()+"",
					tokens.get(i).getNome(),
					tokens.get(i).getDescricao()
			};
			DefaultTableModel dfm= (DefaultTableModel) GuiTabelaResultado.tabela.getModel();
			dfm.addRow(dados);
			GuiTabelaResultado.tabela.setModel(dfm);
		}
	}

}
