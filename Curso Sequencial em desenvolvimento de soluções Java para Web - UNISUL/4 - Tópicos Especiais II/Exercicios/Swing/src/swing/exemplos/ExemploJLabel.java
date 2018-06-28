package swing.exemplos;

import java.awt.Color;
import java.awt.Container;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;


/**
 * Classe de exemplo para aprendizagem sobre o componente JLabel.
 * @author Fabio Dela Bruna.
 * @since 18/10/2008.
 */
public class ExemploJLabel extends JFrame {


	private static final long serialVersionUID = 1L;

	private JLabel rotulo;
	private JLabel imagem;
	private JLabel imagemRoluto;
	private JLabel person;
	
	
	/**
	 * Construtor default.
	 */
	public ExemploJLabel() {
		super ("Exemplo JLabel");
		setSize(300, 300);
		setLayout(null);
		
		rotulo = new JLabel("Apenas texto");
		rotulo.setBounds(25, 25, 100, 20);
		
		imagem = new JLabel(new ImageIcon("images/windows.gif"));
		imagem.setBounds(25, 75, 16, 16);
		
		imagemRoluto = new JLabel("Texto e imagem", new ImageIcon("images/windows.gif"), SwingConstants.LEFT);
		imagemRoluto.setBounds(25, 125, 150, 20);
		
		person = new JLabel("JLabel personalizado");
		person.setForeground(new Color(201, 200, 100));
		person.setFont(new Font("Brush Script MT", Font.BOLD, 20));
		person.setToolTipText("Exemplo de toolTip de rótulo");
		person.setBounds(25, 175, 200, 20);
		
		Container c = getContentPane();
		c.add(rotulo);
		c.add(imagem);
		c.add(imagemRoluto);
		c.add(person);
	}
	
	
	
	public static void main(String[] args) {
		ExemploJLabel label = new ExemploJLabel();
		
		label.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		label.setVisible(true);

	}

}
