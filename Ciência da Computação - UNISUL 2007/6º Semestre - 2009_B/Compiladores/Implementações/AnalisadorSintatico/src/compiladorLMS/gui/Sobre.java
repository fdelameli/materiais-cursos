package compiladorLMS.gui;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;


/**
 * Classe que define a janela sobre, que fica no menu Ajuda.
 * @author Fabio Dela Bruna, Márcio Ozório Teixeira.
 */
public class Sobre extends JDialogBase {

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
	public Sobre( JFrame parent ) {
        super( parent );
        initComponents(parent);
    }

    

    
    /**
     * Inicialisa os componentes.
     */
    private void initComponents( JFrame parent) {
    	setTitle("Sobre");
    	setModal(true);
    	
    	
    	image = new JLabel (new ImageIcon("icons/about.png"));
    	
    	labelTitle = new JLabel(" LMS - Analisador Léxico/Sintático");
    	labelTitle.setFont(new Font("Comic Sans MS", Font.BOLD, 18));
    	
    	labelDescription = new JLabel("  Ambiente de análise léxica e sintática para a linguagem LMS.  \n");
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
    
    
}
