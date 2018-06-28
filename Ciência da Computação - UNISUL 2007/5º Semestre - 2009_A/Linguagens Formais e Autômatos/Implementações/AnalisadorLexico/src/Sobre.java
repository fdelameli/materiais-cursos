import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;


/**
 * Classe que define a janela sobre, que fica no menu Ajuda.
 * @author Fabio Dela Bruna, Márcio Ozório Teixeira.
 */
public class Sobre extends javax.swing.JDialog {

	// Variables declaration - do not modify     
	private static final long serialVersionUID = 1L;
	private JLabel image;
	private JLabel labelTitle;
	private JLabel labelDescription;
	private JLabel labelDevelopers;
	private JLabel labelDeveloper1;
	private JLabel labelDeveloper2;
	private JLabel labelVazioParaGambiarra;
	// End of variables declaration     
	
	
	
	/**
	 * Construtor da classe.
	 */
	public Sobre(java.awt.Frame parent) {
        super(parent);
        initComponents(parent);
    }

    

    
    /**
     * Inicialisa os componentes.
     */
    private void initComponents(java.awt.Frame parent) {
    	setTitle("Sobre");
    	setModal(true);
    	setResizable(false);
    	
    	
    	image = new JLabel (new ImageIcon("img/about.png"));
    	
    	labelTitle = new JLabel(" Analisador Léxico");
    	labelTitle.setFont(new Font("Comic Sans MS", Font.BOLD, 18));
    	
    	labelDescription = new JLabel("  Analisador léxico para a linguagem LMS.  \n");
    	labelDescription.setFont(new Font("Comic Sans MS", Font.ITALIC, 12));
    	
    	labelDevelopers = new JLabel(" Desenvolvido por:");
    	labelDevelopers.setFont(new Font("Comic Sans MS", Font.BOLD, 15));
    	
    	labelDeveloper1 = new JLabel("  Fabio Dela Bruna");
    	labelDeveloper1.setFont(new Font("Comic Sans MS", Font.ITALIC, 12));
    	labelDeveloper2 = new JLabel("  Márcio Ozório Teixeira");
    	labelDeveloper2.setFont(new Font("Comic Sans MS", Font.ITALIC, 12));
    
    	labelVazioParaGambiarra = new JLabel("");
    	
    	JPanel main = new JPanel();
    	main.setLayout(new BorderLayout());
    	
    	JPanel left = new JPanel();
    	left.setLayout(new BorderLayout());
    	left.add(image, BorderLayout.CENTER);
    	
    	JPanel right = new JPanel();
    	right.setLayout(new GridLayout(6,1));
    	right.add(labelTitle);
    	right.add(labelDescription);
    	right.add(labelVazioParaGambiarra);
    	right.add(labelDevelopers);
    	right.add(labelDeveloper1);
    	right.add(labelDeveloper2);
    	
    	main.add(left, BorderLayout.WEST);
    	main.add(right, BorderLayout.EAST);
    	
    	Container c = getContentPane();
    	c.add(main, BorderLayout.NORTH);
    	
    	pack();
    	
    	setLocation(
            	(int)parent.getX() + (parent.getWidth()/2) - (getWidth()/2), 
            	(int)parent.getY() + (parent.getHeight()/2) - (getHeight()/2)
            );
    }
    
    
    public void closeAboutBox() {
        dispose();
    }
    
}
