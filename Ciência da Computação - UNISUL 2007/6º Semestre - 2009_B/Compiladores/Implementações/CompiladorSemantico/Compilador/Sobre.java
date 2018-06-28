import javax.swing.JFrame;
import java.awt.Dimension;
import javax.swing.JLabel;
import java.awt.Rectangle;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.BorderFactory;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Sobre extends JFrame 
{
  private JLabel jLabel1 = new JLabel();
  private JLabel jLabel2 = new JLabel();
  private JLabel jLabel3 = new JLabel();
  private JLabel jLabel4 = new JLabel();
  private JLabel jLabel5 = new JLabel();
  private JLabel jLabel6 = new JLabel();
  private JButton jButton1 = new JButton();

  public Sobre()
  {
    try
    {
      jbInit();
    }
    catch(Exception e)
    {
      e.printStackTrace();
    }

  }

  private void jbInit() throws Exception
  {
    this.getContentPane().setLayout(null);
    this.setSize(new Dimension(379, 188));
    jLabel1.setText("UNISUL - UNIVERSIDADE DO SUL DE SANTA CATARINA");
    jLabel1.setBounds(new Rectangle(30, 10, 325, 15));
    jLabel1.setFont(new Font("Times New Roman", 1, 12));
    jLabel1.setForeground(new Color(91, 128, 207));
    jLabel2.setText("Disciplinas: Compiladores I e II");
    jLabel2.setBounds(new Rectangle(30, 30, 180, 15));
    jLabel2.setForeground(new Color(104, 121, 189));
    jLabel3.setText("Prof.: Dr. Luiz Alfredo Soares Garcindo");
    jLabel3.setBounds(new Rectangle(30, 50, 220, 15));
    jLabel3.setForeground(new Color(104, 121, 189));
    jLabel4.setText("Acadêmicos:");
    jLabel4.setBounds(new Rectangle(30, 70, 100, 15));
    jLabel4.setForeground(new Color(104, 121, 189));
    jLabel5.setText("CHARBEL SZYMANSKI");
    jLabel5.setBounds(new Rectangle(55, 100, 125, 15));
    jLabel5.setForeground(new Color(104, 121, 189));
    jLabel6.setText("ROGÉRIO CORTINA");
    jLabel6.setBounds(new Rectangle(55, 115, 115, 15));
    jLabel6.setForeground(new Color(104, 121, 189));
    jButton1.setText("Fechar");
    jButton1.setBounds(new Rectangle(250, 125, 75, 25));
    jButton1.setBorder(BorderFactory.createLineBorder(new Color(92, 158, 202), 1));
    jButton1.addActionListener(new ActionListener()
      {
        public void actionPerformed(ActionEvent e)
        {
          jButton1_actionPerformed(e);
        }
      });
    this.getContentPane().add(jButton1, null);
    this.getContentPane().add(jLabel6, null);
    this.getContentPane().add(jLabel5, null);
    this.getContentPane().add(jLabel4, null);
    this.getContentPane().add(jLabel3, null);
    this.getContentPane().add(jLabel2, null);
    this.getContentPane().add(jLabel1, null);
    setResizable(false);
  }

  private void jButton1_actionPerformed(ActionEvent e)
  {
    hide();
  }
}