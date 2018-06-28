package revenda.gui;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.PlainDocument;

import framework.gui.components.BotaoBase;
import framework.gui.components.DialogBase;
import framework.gui.components.LabelBase;
import framework.gui.components.PanelBase;

public class FrameLogin extends DialogBase implements ActionListener {

	private static final long serialVersionUID = 1L;
	
	private LabelBase labelLogin;
	private LabelBase labelSenha;
	private LabelBase observacao;
	private JTextField textFieldLogin;
	private JPasswordField passwordFieldSenha;
	private BotaoBase botaoOK;
	private BotaoBase botaoCancelar;
	private PanelBase panelLabels;
	private PanelBase panelTextFields;
	private PanelBase panelGeral;
	private PanelBase panelBotoes;
	
	
	
	/**
	 * Construtor defautl.
	 */
	public FrameLogin(String title) {
		setTitle(title);
		setSize(275, 200);
		setLayout(new BorderLayout());
	}
	
	
	/**
	 * Este método chama o método de montar a janela
	 * e depois exibe a janela na tela.
	 */
	public void mostraJanela() {
		montaJanela();
		setVisible(true);
	}
	
	
	/**
	 * Este método monta a janela de Login.
	 */
	private void montaJanela() {
		labelLogin = new LabelBase("Login:");
		labelSenha = new LabelBase("Senha:");
		
		panelLabels = new PanelBase();
		panelLabels.setLayout(new GridLayout(2,1));
		panelLabels.add(labelLogin);
		panelLabels.add(labelSenha);
		
		textFieldLogin = new JTextField(new LimitadorTexto(15),"", 16);
		passwordFieldSenha = new JPasswordField(new LimitadorTexto(15),"", 15);
		
		panelTextFields = new PanelBase();
		panelTextFields.setLayout(new GridLayout(2,1));
		panelTextFields.add(textFieldLogin);
		panelTextFields.add(passwordFieldSenha);
		
		panelGeral = new PanelBase();
		panelGeral.setLayout(new BorderLayout());
		panelGeral.setBorder(BorderFactory.createEmptyBorder(20,20,0,20));
		panelGeral.add(panelLabels, BorderLayout.WEST);
		panelGeral.add(panelTextFields, BorderLayout.EAST);
		
		
		botaoOK = new BotaoBase("OK");
		botaoOK.addActionListener(this);
		
		botaoCancelar = new BotaoBase("Cancelar");
		botaoCancelar.addActionListener(this);
		
		panelBotoes = new PanelBase();
		panelBotoes.setLayout(new FlowLayout(FlowLayout.RIGHT));
		panelBotoes.add(botaoOK);
		panelBotoes.add(botaoCancelar);
		
		
		observacao = new LabelBase("          OBS:  limite máx. de 15 caracteres.");
		
		
		Container c = getContentPane();
		c.add(panelGeral, BorderLayout.NORTH);
		c.add(observacao, BorderLayout.CENTER);
		c.add(panelBotoes, BorderLayout.SOUTH);
		
	}
	
	
	public static void main(String[] args) {
		FrameLogin app = new FrameLogin("Login");
		app.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		app.mostraJanela();
	}
	
	
	/**
	 * Classe responsável por tratar do limite máximo de
	 * caracteres que podem ser digitados nos campos de textos.
	 */
	private class LimitadorTexto extends PlainDocument {  
		
		private static final long serialVersionUID = 1L;
		private int limite = 0;  
	  
	    public LimitadorTexto(int l){  
	        this.limite = l;  
	    }  
	  
	    public void insertString(int offs, String str, AttributeSet a)  
	               throws BadLocationException {  
	  
	        int sobra = limite - getLength();  
	        int comprimento =  ( sobra > str.length() ) ? str.length() : sobra;  
	        super.insertString(offs, str.substring(0, comprimento), a);  
	    }  
	} 
	

	/**
	 * Método responsável por tratar das ações dos componentes da tela.
	 */
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
	
}


