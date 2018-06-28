package swing.extras;

import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class JDesktopPaneComImagem2 {
	
    public static void main(String[]args) {   
        JFrame tela = new JFrame("Programa");   
        final JDesktopPane deska = new JDesktopPane();   
        JMenuBar barra = new JMenuBar();   
        JMenu opcoes = new JMenu("Opções");   
        JMenuItem abreinterna = new JMenuItem("Abrir telinha interna");   
       
        Icon imagem = new ImageIcon("javaone.jpg");   
        JLabel lab = new JLabel();   
        lab.setIcon(imagem);   
        double alt = Toolkit.getDefaultToolkit().getScreenSize().getHeight();   
        double larg = Toolkit.getDefaultToolkit().getScreenSize().getWidth();   
           
        int altura = (int) alt;   
        int largura = (int) larg;   
        lab.setBounds(0,0,largura,altura);   
           
        deska.add(lab);   
           
        abreinterna.addActionListener(new ActionListener() {   
            public void actionPerformed(ActionEvent e) {   
                JInternalFrame interna = new JInternalFrame("Tela menor", true, true, true, true);   
                interna.setBounds(10,10,400,400);   
                interna.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);   
                deska.add(interna);   
                interna.setVisible(true);   
            }});   
           
           
        opcoes.add(abreinterna);   
        barra.add(opcoes);   
           
           
        tela.getContentPane().add(deska);   
        tela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);   
        tela.setExtendedState(JFrame.MAXIMIZED_BOTH);   
        tela.setJMenuBar(barra);   
        tela.setVisible(true);   
    }   
}  
