import javax.swing.JInternalFrame;
import java.awt.Dimension;
import javax.swing.JTextPane;
import java.awt.BorderLayout;
import javax.swing.event.InternalFrameListener;
import javax.swing.event.InternalFrameEvent;
import javax.swing.*;
import java.io.File;
import java.io.FileWriter;
import java.io.BufferedReader;
import java.io.FileReader;

public class Memo extends JInternalFrame 
{
  private JTextArea TextPane = new JTextArea();
  private BorderLayout borderLayout1 = new BorderLayout();
  private JScrollPane jsp = new JScrollPane(TextPane);
  private int openFrameCount = 0;
  private final int xOffset = 30, yOffset = 30;
  public String titulo = null;

  public String getTexto()
  {
    return TextPane.getText();
  }
  
  public Memo(boolean op)  
  { 
  
    try
    {
      if(op)
      {
        jbInit();
      }else
      {
         telaAbrir();
      }
      
    }
    catch(Exception e)
    {
      e.printStackTrace();
    }
  }

  private void jbInit() throws Exception
  {
    this.setTitle(titulo);
    //this.setLocation(xOffset*openFrameCount, yOffset*openFrameCount);
    this.setLocation(0,0);
    this.setSize(new Dimension(535, 370));
    this.setIcon(true);
    this.setClosable(true);
    //this.setIconifiable(true);
    //this.setMaximizable(true);
    this.setResizable(true);    
    this.getContentPane().setLayout(borderLayout1);
    this.addInternalFrameListener(new javax.swing.event.InternalFrameAdapter()
      {
        public void internalFrameClosing(InternalFrameEvent e)
        {
          this_internalFrameClosing(e);
        }
      });
    this.getContentPane().add(jsp, BorderLayout.CENTER);
  }
  
  private void gravarArquivo(String arq)
  {
      if(new File(arq).exists())
      {
        Object[] options = { "Sim", "Não" };
        int decisao = JOptionPane.showOptionDialog(null, 
        "Sobrescrever?", "Salvar!", 
        JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE,
        null, options, options[0]);
	
        if (decisao == 0) 
        {
          try 
          {
            FileWriter fr = new FileWriter(arq,false);
            fr.write(TextPane.getText()+"\n");
            fr.flush();	          
            fr.close();
            fr = null;
          }
          catch (Exception e)
          {
              JOptionPane.showMessageDialog(null, "Erro ao gravar arquivo!","Erro",JOptionPane.ERROR_MESSAGE);
          }
        }
        else
        {
          telaSalvar();
        }
      }else
      {
          try 
          {
            FileWriter fr = new FileWriter(arq,false);
            fr.write(TextPane.getText()+"\n");
            fr.flush();	          
            fr.close();
            fr = null;
          }
          catch (Exception e)
          {
              JOptionPane.showMessageDialog(null, "Erro ao gravar arquivo!","Erro",JOptionPane.ERROR_MESSAGE);
          }
      }
  }
  private void setTextPane(File arq)
  {
    try 
		{				
			BufferedReader in = new BufferedReader(new FileReader(arq));
			String str = null;
			
        while ((str = in.readLine()) != null)
        {
          TextPane.append(str + "\n");
        }
        jbInit();
    }catch(Exception ioex)
    {
      	JOptionPane.showMessageDialog(null, "Erro ao ler arquivo!","Erro",JOptionPane.ERROR_MESSAGE);
    }
  }
  
  private void telaAbrir()
  {
	  JFileChooser fileChooser = new JFileChooser();
	  fileChooser.setFileFilter(new FileFilter());
    fileChooser.setFileSelectionMode( JFileChooser.FILES_ONLY );				

	  int result = fileChooser.showOpenDialog( this );
        
	  // se o usuário clicar no botão cancel no diálogo
	  if( result == JFileChooser.CANCEL_OPTION )
		return;
      else
      {
        File arquivo = fileChooser.getSelectedFile();

        titulo = arquivo.getPath();
        setTextPane(arquivo);
      }
  }
  
  private void telaSalvar()
  {
    JFileChooser fileChooser = new JFileChooser();
	  fileChooser.setFileFilter(new FileFilter());
    fileChooser.setFileSelectionMode( JFileChooser.FILES_ONLY );				

	  int result = fileChooser.showSaveDialog(this);// showOpenDialog( this );
        
	  // se o usuário clicar no botão cancel no diálogo
	if( result == JFileChooser.CANCEL_OPTION )
		return;
    else
    {
      File arquivo = fileChooser.getSelectedFile();
      
      String nome = arquivo.getPath();
      if ( !nome.toUpperCase().endsWith(".PAS") )
      	nome = nome + ".pas";
      gravarArquivo(nome);
      
    }
  }

  private void this_internalFrameClosing(InternalFrameEvent e)
  {
    if(TextPane.getText().length() != 0 )
    {
      Object[] options = { "Sim", "Não" };
      int decisao = JOptionPane.showOptionDialog(null, 
      "Salvar o projeto?", "Salvar", 
      JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE,
      null, options, options[0]);
	
      if (decisao == 0) 
      {
          telaSalvar();
      }
    }       
  }
}