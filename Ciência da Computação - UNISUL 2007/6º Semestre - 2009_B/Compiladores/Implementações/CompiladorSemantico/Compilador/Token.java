import javax.swing.JInternalFrame;
import java.awt.Dimension;
import javax.swing.JTextPane;
import java.awt.BorderLayout;
import javax.swing.event.InternalFrameListener;
import javax.swing.event.InternalFrameEvent;
import javax.swing.*;
import javax.swing.JTable;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import java.awt.Color;
import javax.swing.JTabbedPane;
import java.awt.*;

public class Token extends JInternalFrame 
{  
  private BorderLayout borderLayout1 = new BorderLayout();
  private int openFrameCount = 0;
  private final int xOffset = 30, yOffset = 30;  
  private JTextArea TextToken = new JTextArea();
  private JScrollPane jsp = new JScrollPane(TextToken);
  private JTabbedPane jTabbedPane1 = new JTabbedPane();
  private JTextArea AreaInst = new JTextArea();
  private JScrollPane jsp2 = new JScrollPane(AreaInst);
  private JButton Salvar = new JButton("Salvar");
  private JPanel painel = new JPanel();
    
  public Token(String par, String par2)
  {
  	
    setTextoToken(par);
    setTextoArea(par2);
    
    try
    {
      jbInit();
    }
    catch(Exception e)
    {
      e.printStackTrace();
    }
  }

  public void setTextoToken(String texto)
  {
    TextToken.setText(texto);
  }
  
  public void setTextoArea(String texto)
  {
    AreaInst.setText(texto);
  }

  private void jbInit() throws Exception
  {
    this.setLocation(xOffset*openFrameCount, yOffset*openFrameCount);
    this.setSize(new Dimension(254, 373));
    this.setIcon(true);
    this.setClosable(true);    
    this.getContentPane().setLayout(borderLayout1);
    this.setTitle("Dados obtidos");
    TextToken.setEditable(false);
    jTabbedPane1.setTabPlacement(JTabbedPane.BOTTOM);
    jTabbedPane1.addTab("Tokens", jsp);
    
    painel.add(jsp2);
    painel.add(Salvar);
    jsp2.setBounds(0,0,240,280);
    Salvar.setBounds(80,280,80,30);
    Salvar.setToolTipText("Salvar as instruções em arquivo");
    	
    painel.setLayout(null);
    painel.setSize(10,10);
    
    
    jTabbedPane1.addTab("Area de instruções", painel);
    this.getContentPane().add(jTabbedPane1, BorderLayout.CENTER);
  }
}