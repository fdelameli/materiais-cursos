/*

    CAMPO MINADO --> Desenvolvido por Thiago Ananias Negreiros Silva
    Data:   14/07/2006
    http://forum.ievolutionweb.com

*/
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridLayout;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.util.Random;

public class CampoMinado extends JFrame implements ActionListener {

    private JButton [] Botoes   = new JButton[100];
    private int     [] Vetor    = new int[100];
    private JLabel credito;
    private JButton novo = new JButton("Novo Jogo");
    private JPanel grid = new JPanel();
    Container cp;
    private boolean fim = false;

    private Random rnd;

    public CampoMinado() {

        setSize(500, 400);
        setTitle("Campo Minado");
        centerJFrame(this);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);

        cp = getContentPane();
        cp.setLayout(null);

        grid.setBounds(3, 53, 497, 327);
        grid.setLayout(new GridLayout(10, 10, 2, 2));

        for(int i=0;i<100;i++) {
            Botoes[i] = new JButton("");
            Botoes[i].addActionListener(this);
            Botoes[i].setFocusable(false);
            grid.add(Botoes[i]);
        }

        credito = new JLabel("<html>Desenvolvido por: Thiago Ananias<br>http://www.forum.ievolutionweb.com</html>");
        credito.setBounds(290, 10, 400, 30);
        novo.setBounds(3, 4, 100, 44);
        novo.setFocusable(false);
        novo.addActionListener(this);

        cp.add(grid);
        cp.add(credito);
        cp.add(novo);

        preencheVetor(Vetor);

    }

    private void preencheVetor(int[] Vetor) {

        int contador=0, flag=0;
        rnd = new Random();

        while(contador < 10) {

            contador = 0;

            for(int i=0;i<100;i++) {

                flag = rnd.nextInt(2);

                if(contador >= 10) {
                    flag = 0;
                }
                // REDUNDÂNCIA PARA AS "BOMBAS" SEREM BEM DISTRIBUÍDAS
                if(flag == 1) {
                    flag = rnd.nextInt(2);
                    if(flag == 1) {
                        flag = rnd.nextInt(2);
                        if(flag == 1) {
                            flag = rnd.nextInt(2);
                            if(flag == 1) {
                                contador += 1;
                            }
                        }
                    }

                }

                Vetor[i] = flag;

            }

        }

    }

    private void centerJFrame(JFrame frame) {

        Dimension paneSize      = frame.getSize();
        Dimension screenSize    = frame.getToolkit().getScreenSize();
        frame.setLocation( (screenSize.width - paneSize.width) / 2, (screenSize.height - paneSize.height) / 2);

    }

    private void abreJogo() {
        for(int i=0;i<100;i++) {
            Botoes[i].doClick();
        }
    }

    public void actionPerformed(ActionEvent e) {

        if(e.getSource() == novo) {

            preencheVetor(Vetor);
            for(int i=0;i<100;i++) {
                Botoes[i].setText("");
                Botoes[i].setEnabled(true);
            }

            fim = false;
            JOptionPane.showMessageDialog(this, "Jogo reiniciado!", "Novo Jogo", JOptionPane.INFORMATION_MESSAGE);

        }

        for(int i=0;i<100;i++) {
            if(e.getSource() == Botoes[i]) {

               if(Vetor[i] == 0) {

                    int contador = 0;
                    contador = getBombas(i);
                        
                    if(!fim) {

                        if(contador > 0) {
                            Botoes[i].setText(""+contador);
                            Botoes[i].setEnabled(false);
                        
                        } else {
                            explodir(i);
                        }
                    } else {
                        
                        if(contador > 0) {
                            Botoes[i].setText(""+contador);
                        }

                        Botoes[i].setEnabled(false);

                    }
               } else if(Vetor[i] == 1) {
                    Botoes[i].setText("X");
                    if(!fim) {
                        JOptionPane.showMessageDialog(null, "OPS! Você perdeu!");
                        fim = true;
                        abreJogo();
                    }
               }

            }
        }

    }

    private void explodir(int i) {

        int contador = 0;

        Botoes[i].setEnabled(false);

        if(i + 1 < 100 & i % 10 != 9) {
            contador = getBombas(i+1);
            if(contador == 0) {
                if(Botoes[i+1].isEnabled() == true){
                    Botoes[i+1].doClick();
                }
            }
        }

        if(i - 1 >= 0 & i % 10 != 0) {
            contador = getBombas(i-1);
            if(contador == 0) {
                if(Botoes[i-1].isEnabled() == true){
                    Botoes[i-1].doClick();
                }
            }
        }

        if(i - 10 >= 0) {
            contador = getBombas(i-10);
            if(contador == 0) {
                if(Botoes[i-10].isEnabled() == true){
                    Botoes[i-10].doClick();
                }
            }
        }

       //Verifica bomba abaixo
       if(i + 10 < 100) {
            contador = getBombas(i+10);
            if(contador == 0) {
                if(Botoes[i+10].isEnabled() == true){
                    Botoes[i+10].doClick();
                }
            }
       }

    }

    private int getBombas(int i) {

        int contador = 0;

       //Verifica bomba a direita
       if(i + 1 < 100 & i % 10 != 9) {
           if(Vetor[i+1] == 1) {
               contador += 1;
           }
       }

       //Verifica bomba a esquerda
       if(i - 1 >= 0 & i % 10 != 0) {
           if(Vetor[i-1] == 1) {
               contador += 1;
           }
       }

       //Verifica bomba acima
       if(i - 10 >= 0) {
           if(Vetor[i-10] == 1) {
               contador += 1;
           }
       }

       //Verifica bomba abaixo
       if(i + 10 < 100) {
           if(Vetor[i+10] == 1) {
               contador += 1;
           }
       }

       //Verifica bomba a esquerda acima
       if(i - 11 >= 0 & i % 10 != 0) {
           if(Vetor[i-11] == 1) {
               contador += 1;
           }
       }

       //Verifica bomba a direita acima
       if(i - 9 >= 0 & i % 10 != 9) {
           if(Vetor[i-9] == 1) {
               contador += 1;
           }
       }

       //Verifica bomba esquerda abaixo
       if(i + 9 < 100 && i % 10 != 0) {
           if(Vetor[i+9] == 1) {
               contador += 1;
           }
       }

       //Verifica bomba direita abaixo
       if(i + 11 < 100 && i % 10 != 9) {
           if(Vetor[i+11] == 1) {
               contador += 1;
           }
       }

        return contador;

    }

    public static void main(String args[]) {

        CampoMinado app = new CampoMinado();
        app.show();

    }

}