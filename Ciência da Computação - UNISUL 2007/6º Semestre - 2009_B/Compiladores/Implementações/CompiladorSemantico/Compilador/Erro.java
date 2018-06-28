import javax.swing.JInternalFrame;
import javax.swing.JTextArea;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Toolkit;
import javax.swing.JScrollPane;

public class Erro extends JInternalFrame 
{
  private JTextArea ErroTextArea = new JTextArea();
  private JScrollPane jsp = new JScrollPane(ErroTextArea);

  public Erro(String par)
  {
    ErroTextArea.setText(par);
    try
    {
      jbInit();
    }
    catch(Exception e)
    {
      e.printStackTrace();
    }

  }

  public void setTexto(String texto)
  {
    ErroTextArea.setText(texto);
  }
  
  private void jbInit() throws Exception
  {
    this.setTitle("Result");
    this.setClosable(true);
    Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
    this.setSize(new Dimension(screenSize.width, 124));
    ErroTextArea.setEditable(false);
    this.getContentPane().add(jsp, BorderLayout.CENTER);
    this.setVisible(true);
  }
}