package projetojogo;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Insets;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class FrameJogo extends JFrame {
 

	private static final long serialVersionUID = 1L;
	
	//Frutas
    private ImageIcon imagemAmeixa = new ImageIcon(FrameJogo.class.getResource("ameixa.jpg"));
    private ImageIcon imagemBanana = new ImageIcon(FrameJogo.class.getResource("banana.jpg"));
    private ImageIcon imagemCereja = new ImageIcon(FrameJogo.class.getResource("cereja.jpg"));
    private ImageIcon imagemJabuticaba = new ImageIcon(FrameJogo.class.getResource("jabuticaba.jpg"));
    private ImageIcon imagemLaranja = new ImageIcon(FrameJogo.class.getResource("laranja.jpg"));
    private ImageIcon imagemLimao = new ImageIcon(FrameJogo.class.getResource("limao.jpg"));
    private ImageIcon imagemMaca = new ImageIcon(FrameJogo.class.getResource("maca.jpg"));
    private ImageIcon imagemMorango = new ImageIcon(FrameJogo.class.getResource("morango.jpg"));
    private ImageIcon imagemPera = new ImageIcon(FrameJogo.class.getResource("pera.jpg"));

    
    private String nomeFruta = "";
    private int preco = 0;
    private int qtde = 0;

    private JFrame pai = null;
    private JLabel jLabel3 = new JLabel();
    private JLabel jLabel4 = new JLabel();
    private JLabel jLabel5 = new JLabel();
    private JLabel jLabel6 = new JLabel();
    private JLabel jLabel7 = new JLabel();
    private JLabel jLabel8 = new JLabel();
    private JLabel jLabel9 = new JLabel();
    private JLabel jLabel10 = new JLabel();
    private JLabel jLabel11 = new JLabel();
    private JLabel lblEscolha = new JLabel();
    private JLabel jLabel2 = new JLabel();
    private JLabel jLabel12 = new JLabel();
    private JLabel jLabel13 = new JLabel();
    private JLabel jLabel14 = new JLabel();
    private JLabel jLabel15 = new JLabel();
    private JLabel jLabel16 = new JLabel();
    private JLabel jLabel17 = new JLabel();
    private JLabel jLabel18 = new JLabel();
    private JPanel pnlEscolha = new JPanel();
    private JPanel pnlQtde = new JPanel();
    private JLabel lblQtde = new JLabel();
    private JTextField txfQtde = new JTextField();
    private JButton btnComprar = new JButton();
    private JPanel pnlVerificar = new JPanel();
    private JButton btnVerificar = new JButton();
    private JTextField txfValor = new JTextField();
    private JLabel lblValor = new JLabel();
    private JLabel jLabel19 = new JLabel();
    private JLabel jLabel1 = new JLabel();
    private JLabel lblNome = new JLabel();
    private JLabel lblQtdeMostra = new JLabel();
    private JLabel jLabel22 = new JLabel();

    public FrameJogo(JFrame pai) {
        try {
            this.pai = pai;
            jbInit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void jbInit() throws Exception {
        pai.setVisible(false);
        jLabel3.setBounds(new Rectangle(25, 195, 125, 105));
        jLabel3.setIcon(imagemAmeixa);
        jLabel3.addMouseListener(new MouseAdapter() {
                    public void mousePressed(MouseEvent e) {
                        jLabel3_mousePressed(e);
                    }
                });
        jLabel4.setBounds(new Rectangle(365, 135, 100, 165));
        jLabel4.setIcon(imagemBanana);
        jLabel4.addMouseListener(new MouseAdapter() {
                    public void mousePressed(MouseEvent e) {
                        jLabel4_mousePressed(e);
                    }
                });
        jLabel5.setBounds(new Rectangle(365, 380, 125, 105));
        jLabel5.setIcon(imagemCereja);
        jLabel5.addMouseListener(new MouseAdapter() {
                    public void mousePressed(MouseEvent e) {
                        jLabel5_mousePressed(e);
                    }
                });
        jLabel6.setBounds(new Rectangle(530, 190, 150, 105));
        jLabel6.setIcon(imagemJabuticaba);
        jLabel6.addMouseListener(new MouseAdapter() {
                    public void mousePressed(MouseEvent e) {
                        jLabel6_mousePressed(e);
                    }
                });
        jLabel7.setBounds(new Rectangle(30, 385, 110, 105));
        jLabel7.setIcon(imagemLaranja);
        jLabel7.addMouseListener(new MouseAdapter() {
                    public void mousePressed(MouseEvent e) {
                        jLabel7_mousePressed(e);
                    }
                });
        jLabel8.setBounds(new Rectangle(190, 370, 100, 120));
        jLabel8.setIcon(imagemLimao);
        jLabel8.addMouseListener(new MouseAdapter() {
                    public void mousePressed(MouseEvent e) {
                        jLabel8_mousePressed(e);
                    }
                });
        jLabel9.setBounds(new Rectangle(185, 170, 125, 130));
        jLabel9.setIcon(imagemMaca);
        jLabel9.addMouseListener(new MouseAdapter() {
                    public void mousePressed(MouseEvent e) {
                        jLabel9_mousePressed(e);
                    }
                });
        jLabel10.setBounds(new Rectangle(545, 360, 125, 130));
        jLabel10.setIcon(imagemMorango);
        jLabel10.addMouseListener(new MouseAdapter() {
                    public void mousePressed(MouseEvent e) {
                        jLabel10_mousePressed(e);
                    }
                });
        jLabel11.setBounds(new Rectangle(720, 360, 110, 130));
        jLabel11.setIcon(imagemPera);
        jLabel11.addMouseListener(new MouseAdapter() {
                    public void mousePressed(MouseEvent e) {
                        jLabel11_mousePressed(e);
                    }
                });
        
        jLabel3.setCursor(new Cursor(Cursor.HAND_CURSOR));
        jLabel4.setCursor(new Cursor(Cursor.HAND_CURSOR));
        jLabel5.setCursor(new Cursor(Cursor.HAND_CURSOR));
        jLabel6.setCursor(new Cursor(Cursor.HAND_CURSOR));
        jLabel7.setCursor(new Cursor(Cursor.HAND_CURSOR));
        jLabel8.setCursor(new Cursor(Cursor.HAND_CURSOR));
        jLabel9.setCursor(new Cursor(Cursor.HAND_CURSOR));
        jLabel10.setCursor(new Cursor(Cursor.HAND_CURSOR));
        jLabel11.setCursor(new Cursor(Cursor.HAND_CURSOR));
        
        lblEscolha.setText("Clique na fruta que você deseja comprar.");
        lblEscolha.setBounds(new Rectangle(5, 5, 525, 50));
        lblEscolha.setFont(new Font("Dialog", 0, 26));
        jLabel2.setText("Ameixa - R$ 1,00");
        jLabel2.setBounds(new Rectangle(25, 305, 125, 20));
        jLabel2.setFont(new Font("Dialog", 0, 14));
        jLabel12.setText("Maça - R$ 2,00");
        jLabel12.setBounds(new Rectangle(185, 305, 125, 20));
        jLabel12.setFont(new Font("Dialog", 0, 14));
        jLabel13.setText("Banana - R$ 3,00");
        jLabel13.setBounds(new Rectangle(365, 305, 125, 20));
        jLabel13.setFont(new Font("Dialog", 0, 14));
        jLabel14.setText("Jabuticaba - R$ 4,00");
        jLabel14.setBounds(new Rectangle(530, 305, 145, 20));
        jLabel14.setFont(new Font("Dialog", 0, 14));
        jLabel15.setText("Laranja - R$ 5,00");
        jLabel15.setBounds(new Rectangle(25, 495, 125, 20));
        jLabel15.setFont(new Font("Dialog", 0, 14));
        jLabel16.setText("Limão - R$ 6,00");
        jLabel16.setBounds(new Rectangle(190, 495, 125, 20));
        jLabel16.setFont(new Font("Dialog", 0, 14));
        jLabel17.setText("Cereja - R$ 7,00");
        jLabel17.setBounds(new Rectangle(360, 490, 125, 20));
        jLabel17.setFont(new Font("Dialog", 0, 14));
        jLabel18.setText("Morango - R$ 8,00");
        jLabel18.setBounds(new Rectangle(545, 495, 125, 20));
        jLabel18.setFont(new Font("Dialog", 0, 14));
        pnlEscolha.setBounds(new Rectangle(5, 5, 675, 60));
        pnlEscolha.setLayout(null);
        pnlEscolha.setBackground(Color.white);
        pnlQtde.setBounds(new Rectangle(5, 70, 675, 90));
        pnlQtde.setLayout(null);
        pnlQtde.setBackground(Color.white);
        pnlQtde.addComponentListener(new ComponentAdapter() {
                    public void componentShown(ComponentEvent e) {
                        pnlQtde_componentShown(e);
                    }
                });
        lblQtde.setText("Qual a quantidade?");
        lblQtde.setBounds(new Rectangle(5, 5, 240, 35));
        lblQtde.setFont(new Font("Dialog", 0, 26));
        txfQtde.setBounds(new Rectangle(5, 45, 80, 35));
        txfQtde.setFont(new Font("Dialog", 0, 26));
        btnComprar.setText("Comprar");
        btnComprar.setBounds(new Rectangle(105, 45, 115, 35));
        btnComprar.setFont(new Font("Dialog", 0, 18));
        btnComprar.setMargin(new Insets(1, 1, 1, 1));
        btnComprar.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        btnComprar_actionPerformed(e);
                    }
                });
        pnlVerificar.setBounds(new Rectangle(5, 165, 675, 90));
        pnlVerificar.setLayout(null);
        pnlVerificar.setBackground(Color.white);
        pnlVerificar.addComponentListener(new ComponentAdapter() {
                    public void componentShown(ComponentEvent e) {
                        pnlVerificar_componentShown(e);
                    }
                });
        btnVerificar.setText("Verificar");
        btnVerificar.setBounds(new Rectangle(105, 45, 115, 35));
        btnVerificar.setFont(new Font("Dialog", 0, 18));
        btnVerificar.setMargin(new Insets(1, 1, 1, 1));
        btnVerificar.setActionCommand("Verificar");
        btnVerificar.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        btnVerificar_actionPerformed(e);
                    }
                });
        txfValor.setBounds(new Rectangle(10, 40, 75, 40));
        txfValor.setFont(new Font("Dialog", 0, 26));
        lblValor.setText("Informe o valor da compra:");
        lblValor.setBounds(new Rectangle(5, 5, 325, 35));
        lblValor.setFont(new Font("Dialog", 0, 26));
        jLabel19.setText("Pera - R$ 9,00");
        jLabel19.setBounds(new Rectangle(720, 495, 125, 20));
        jLabel19.setFont(new Font("Dialog", 0, 14));
        jLabel1.setText("Fruta escolhida");
        jLabel1.setBounds(new Rectangle(700, 20, 140, 20));
        jLabel1.setFont(new Font("Dialog", 0, 18));
        lblNome.setBounds(new Rectangle(700, 40, 140, 20));
        lblNome.setFont(new Font("Dialog", 1, 18));
        lblQtdeMostra.setBounds(new Rectangle(700, 95, 90, 20));
        lblQtdeMostra.setFont(new Font("Dialog", 1, 18));
        lblQtdeMostra.setHorizontalAlignment(SwingConstants.RIGHT);
        jLabel22.setText("Quantidade");
        jLabel22.setBounds(new Rectangle(700, 75, 140, 20));
        jLabel22.setFont(new Font("Dialog", 0, 18));
        this.getContentPane().setLayout( null );
        this.getContentPane().setBackground(Color.white);
        this.setSize(new Dimension(863, 555));
        this.setBounds(new Rectangle(10, 10, 863, 555));
        this.setDefaultCloseOperation(3);
        this.setResizable(false);

        this.setTitle("Feirinha da Rosi");
        pnlQtde.setBounds(pnlEscolha.getX(), pnlEscolha.getY(), pnlQtde.getWidth(), pnlQtde.getHeight());
        pnlVerificar.setBounds(pnlQtde.getBounds());
        pnlQtde.setVisible(false);
        pnlVerificar.setVisible(false);

        pnlEscolha.add(lblEscolha, null);
        pnlQtde.add(btnComprar, null);
        pnlQtde.add(txfQtde, null);
        pnlQtde.add(lblQtde, null);
        pnlVerificar.add(lblValor, null);
        pnlVerificar.add(btnVerificar, null);
        pnlVerificar.add(txfValor, null);


        this.getContentPane().add(jLabel22, null);
        this.getContentPane().add(lblQtdeMostra, null);
        this.getContentPane().add(lblNome, null);
        this.getContentPane().add(jLabel1, null);
        this.getContentPane().add(jLabel19, null);
        this.getContentPane().add(pnlVerificar, null);
        this.getContentPane().add(pnlQtde, null);
        this.getContentPane().add(pnlEscolha, null);
        this.getContentPane().add(jLabel18, null);
        this.getContentPane().add(jLabel17, null);
        this.getContentPane().add(jLabel16, null);
        this.getContentPane().add(jLabel15, null);
        this.getContentPane().add(jLabel14, null);
        this.getContentPane().add(jLabel13, null);
        this.getContentPane().add(jLabel12, null);
        this.getContentPane().add(jLabel2, null);
        this.getContentPane().add(jLabel11, null);
        this.getContentPane().add(jLabel10, null);
        this.getContentPane().add(jLabel6, null);
        this.getContentPane().add(jLabel5, null);
        this.getContentPane().add(jLabel9, null);
        this.getContentPane().add(jLabel8, null);
        this.getContentPane().add(jLabel4, null);
        this.getContentPane().add(jLabel7, null);
        this.getContentPane().add(jLabel3, null);
        
    }

    private void btnComprar_actionPerformed(ActionEvent e) {
        try {
            qtde = Integer.parseInt(txfQtde.getText());
            pnlVerificar.setVisible(true);
            pnlQtde.setVisible(false);
            lblQtdeMostra.setText(txfQtde.getText());
        }
        catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Digite somente números!", "Aviso", JOptionPane.WARNING_MESSAGE);
            txfQtde.requestFocus();
        }
    }

    private void jLabel3_mousePressed(MouseEvent e) {
        escolheFruta("Ameixa", 1);
    }
    
    private void escolheFruta(String nome, int preco) {
        if (!pnlQtde.isVisible()) {
            this.nomeFruta = nome;
            this.preco = preco;
            pnlQtde.setVisible(true);
            lblNome.setText(nome);
        }
    }

    private void jLabel9_mousePressed(MouseEvent e) {
        escolheFruta("Maça", 2);
    }

    private void jLabel4_mousePressed(MouseEvent e) {
        escolheFruta("Banana", 3);
    }

    private void jLabel6_mousePressed(MouseEvent e) {
        escolheFruta("Jabuticaba", 4);
    }

    private void jLabel7_mousePressed(MouseEvent e) {
        escolheFruta("Laranja", 5);
    }

    private void jLabel8_mousePressed(MouseEvent e) {
        escolheFruta("Limao", 6);
    }

    private void jLabel5_mousePressed(MouseEvent e) {
        escolheFruta("Cereja", 7);
    }

    private void jLabel10_mousePressed(MouseEvent e) {
        escolheFruta("Morango",8);
    }

    private void pnlQtde_componentShown(ComponentEvent e) {
        txfQtde.requestFocus();
    }

    private void pnlVerificar_componentShown(ComponentEvent e) {
        txfValor.requestFocus();
    }

    private void btnVerificar_actionPerformed(ActionEvent e) {
        try {
            int valorDigitado = Integer.parseInt(txfValor.getText());
            int valorCorreto  = preco * qtde;
            if (valorDigitado != valorCorreto) {
                JOptionPane.showMessageDialog(this, "Você errou. Tente novamente", "Aviso", JOptionPane.WARNING_MESSAGE);
                txfValor.requestFocus(); 
            } else {
                JOptionPane.showMessageDialog(this, "Parabéns! Resposta correta!", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
                pnlVerificar.setVisible(false);
                txfQtde.setText("");
                txfValor.setText("");
                lblNome.setText("");
                lblQtdeMostra.setText("");
            }
        }
        catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Digite somente números!", "Aviso", JOptionPane.WARNING_MESSAGE);
            txfValor.requestFocus();
        }
    }

    private void jLabel11_mousePressed(MouseEvent e) {
        escolheFruta("Pera",9);
    }
}
