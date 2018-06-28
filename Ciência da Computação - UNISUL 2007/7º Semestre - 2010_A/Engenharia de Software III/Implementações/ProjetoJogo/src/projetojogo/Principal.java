package projetojogo;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Rectangle;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.border.BevelBorder;

public class Principal extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel jPanel1 = new JPanel();
    private JLabel jLabel1 = new JLabel();
    private JLabel jLabel2 = new JLabel();
    private JLabel jLabel3 = new JLabel();
    private ImageIcon imagemFrutas = new ImageIcon(Principal.class.getResource("frutas.jpg"));

    
    public Principal() {
        try {
            jbInit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void jbInit() throws Exception {
        this.getContentPane().setLayout( null );
        this.setSize(new Dimension(763, 472));
        this.setBackground(Color.black);
        this.setDefaultCloseOperation(3);
        this.setResizable(false);
        this.setTitle("Feirinha da Rosi");
        this.addKeyListener(new KeyAdapter() {
                    public void keyPressed(KeyEvent e) {
                        this_keyPressed(e);
                    }
                });
        jPanel1.setBounds(new Rectangle(0, 0, 760, 445));
        jPanel1.setLayout(null);
        jPanel1.setBackground(Color.white);
        jPanel1.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED));
        jLabel1.setText("Feirinha da Rosi");
        jLabel1.setBounds(new Rectangle(375, 300, 380, 60));
        jLabel1.setFont(new Font("Dialog", 0, 50));
        jLabel2.setText("Pressione ENTER para iniciar");
        jLabel2.setBounds(new Rectangle(485, 400, 265, 45));
        jLabel2.setFont(new Font("Dialog", 0, 20));
        jLabel3.setBounds(new Rectangle(0, 0, 420, 380));
        jLabel3.setIcon(imagemFrutas);
        jPanel1.add(jLabel2, null);
        jPanel1.add(jLabel1, null);
        jPanel1.add(jLabel3, null);
        this.getContentPane().add(jPanel1, null);
    }
    
    public static void main(String[] args) {
    	try {
    		UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
    	} catch (Exception e) {
    		System.out.println(e.getMessage());
    	}
    	
        Principal p =new Principal();
        p.setVisible(true);
    }


    private void this_keyPressed(KeyEvent e) {
        if(e.getKeyCode()==10){
            FrameJogo jogo =new FrameJogo(this);
            jogo.setVisible(true);
        }
    }
}
