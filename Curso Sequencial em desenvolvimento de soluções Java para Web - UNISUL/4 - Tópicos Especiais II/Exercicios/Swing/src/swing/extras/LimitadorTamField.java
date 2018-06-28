package swing.extras;

import java.awt.FlowLayout;

import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.PlainDocument;

public class LimitadorTamField extends JFrame {

	private static final long serialVersionUID = 1L;

	public LimitadorTamField() {
		super("Teste de limite de tamanho");
		setSize(300, 400);
		setLayout(new FlowLayout());
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		add(new JTextField(new LimitadorTexto(10),"", 20));
	}

	public static void main(String[] args) {
		LimitadorTamField app = new LimitadorTamField();
		app.setVisible(true);
	}

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

}
