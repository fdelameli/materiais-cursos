import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import java.awt.Dimension;
import java.awt.event.*;
import javax.swing.JToolBar;
import java.awt.Rectangle;
import java.awt.FlowLayout;
import java.awt.BorderLayout;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import javax.swing.JDesktopPane;
import javax.swing.KeyStroke;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JOptionPane;
import java.awt.event.WindowListener;
import java.awt.event.WindowEvent;
import javax.swing.JSplitPane;
import javax.swing.JPanel;
import javax.swing.BorderFactory;
import java.awt.Color;
import javax.swing.JTextPane;
import java.awt.Toolkit;
import java.awt.Container;
import java.util.Vector;
import javax.swing.UIManager;

public class Principal extends JFrame 
{
  private JMenu File = new JMenu();
  private JMenuBar menuBar = new JMenuBar();
  private JMenuItem Exit = new JMenuItem();
  private JMenuItem Open = new JMenuItem();
  private JMenuItem Close = new JMenuItem();
  private JMenuItem Save = new JMenuItem();
  private JMenu Run = new JMenu();
  private JMenuItem RunProj = new JMenuItem();
  private JMenu Help = new JMenu();
  private JMenuItem About = new JMenuItem();
  private JToolBar jToolBar1 = new JToolBar();
  private JButton BNew = new JButton();
  private BorderLayout borderLayout1 = new BorderLayout();
  private JDesktopPane desktop = new JDesktopPane();
  private JButton BOpen = new JButton();
  private JButton BSave = new JButton();
  private JButton BRun = new JButton();
  private JButton BExe = new JButton();
  private JMenuItem New = new JMenuItem();
  private JPanel Panel = new JPanel();
  private BorderLayout borderLayout2 = new BorderLayout();
  private Vector ret;
  private boolean erro_lexico;
  private Memo frame;
  private Erro err;
  private Token tk;
  private DadosInstrucao[] inst;
  private String areaInst;
  private Vector lit;
  String msg;
  
  public Principal()
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
    this.setJMenuBar(menuBar);
    this.getContentPane().setLayout(borderLayout1);

    Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
    this.setSize(screenSize.width, screenSize.height);
    //this.setSize(new Dimension(800, 600));
    this.setTitle("Compilador XP");   
    File.setText("Arquivo");
    File.setMnemonic('A');
    Exit.setText("Sair");
    Exit.setMnemonic('S');
    Exit.setAccelerator(KeyStroke.getKeyStroke(
                KeyEvent.VK_F4, ActionEvent.ALT_MASK));                
    Exit.addActionListener(new ActionListener()
      {
        public void actionPerformed(ActionEvent e)
        {
          Exit_actionPerformed(e);
        }
      });
    Open.setText("Abrir");
    Open.setMnemonic('A');    
    Open.setAccelerator(KeyStroke.getKeyStroke(
                KeyEvent.VK_O, ActionEvent.ALT_MASK));
    Open.addActionListener(new ActionListener()
      {
        public void actionPerformed(ActionEvent e)
        {
          Open_actionPerformed(e);
        }
      });
    Close.setText("Fechar");
    Close.setMnemonic('F');
    Close.setAccelerator(KeyStroke.getKeyStroke(
                KeyEvent.VK_F4, ActionEvent.CTRL_MASK));
    Close.addActionListener(new ActionListener()
      {
        public void actionPerformed(ActionEvent e)
        {
          Close_actionPerformed(e);
        }
      });
    Save.setText("Salvar");
    Save.setMnemonic('S');    
    Save.setAccelerator(KeyStroke.getKeyStroke(
                KeyEvent.VK_S, ActionEvent.CTRL_MASK));
                
    Save.addActionListener(new ActionListener()
      {
        public void actionPerformed(ActionEvent e)
        {
          Salvar_actionPerformed(e);
        }
      });
                      
    Run.setText("Compilar");
    Run.setMnemonic('C');    
    RunProj.setText("Compilar projeto");
    RunProj.setMnemonic('p');    

    RunProj.setAccelerator(KeyStroke.getKeyStroke(
                KeyEvent.VK_F9, ActionEvent.CTRL_MASK));
    RunProj.addActionListener(new ActionListener()
      {
        public void actionPerformed(ActionEvent e)
        {
          RunProj_actionPerformed(e);
        }
      });
    Help.setText("Ajuda");
    Help.setMnemonic('j');
    About.setText("Sobre");
    About.setMnemonic('S');
    About.addActionListener(new ActionListener()
      {
        public void actionPerformed(ActionEvent e)
        {
          About_actionPerformed(e);
        }
      });
      
    BNew.setToolTipText("Novo");
    BNew.setHorizontalTextPosition(SwingConstants.LEFT);
    BNew.setIcon(new javax.swing.ImageIcon(getClass().getResource( "./icons/New24.gif" ) ));    
    BNew.setBorder(BorderFactory.createLineBorder(new Color(77, 119, 255), 1));
    BNew.addActionListener(new ActionListener()
      {
        public void actionPerformed(ActionEvent e)
        {
          BNew_actionPerformed(e);
        }
      });
    desktop.setAutoscrolls(true);
  
  	BSave.setToolTipText("Salvar");
    BSave.setIcon(new javax.swing.ImageIcon(getClass().getResource( "./icons/Save24.gif" ) ));
    BSave.setBorder(BorderFactory.createLineBorder(new Color(77, 119, 255), 1));
    BSave.addActionListener(new ActionListener()
      {
        public void actionPerformed(ActionEvent e)
        {
          Salvar_actionPerformed(e);
        }
      });
    
    BOpen.setToolTipText("Abrir");
    BOpen.setIcon(new javax.swing.ImageIcon(getClass().getResource( "./icons/Open24.gif" ) ));
    BOpen.setBorder(BorderFactory.createLineBorder(new Color(77, 119, 255), 1));
    BOpen.addActionListener(new ActionListener()
      {
        public void actionPerformed(ActionEvent e)
        {
          BOpen_actionPerformed(e);
        }
      });
      
    BRun.setToolTipText("Compilar");
    BRun.setIcon(new javax.swing.ImageIcon(getClass().getResource( "./icons/Play24.gif" ) ));
    BRun.setBorder(BorderFactory.createLineBorder(new Color(77, 119, 255), 1));
    BRun.addActionListener(new ActionListener()
      {
        public void actionPerformed(ActionEvent e)
        {
          BRun_actionPerformed(e);
        }
      });
      
    BExe.setToolTipText("Executar");
    BExe.enable(false);
    BExe.setIcon(new javax.swing.ImageIcon(getClass().getResource( "./icons/Executar.gif" ) ));
    BExe.setBorder(BorderFactory.createLineBorder(new Color(77, 119, 255), 1));
    BExe.addActionListener(new ActionListener()
      {
        public void actionPerformed(ActionEvent e)
        {
          BExe_actionPerformed(e);
        }
      });

    New.setText("Novo");
    New.setMnemonic('N');
    New.setAccelerator(KeyStroke.getKeyStroke(
                KeyEvent.VK_N, ActionEvent.CTRL_MASK));
    New.addActionListener(new ActionListener()
      {
        public void actionPerformed(ActionEvent e)
        {
          New_actionPerformed(e);
        }
      });
    Panel.setLayout(borderLayout2);
    File.add(New);
    File.add(Open);
    File.add(Save);
    File.add(Close);
    File.addSeparator();
    File.add(Exit);
    menuBar.add(File);
    Run.add(RunProj);
    menuBar.add(Run);
    Help.add(About);
    menuBar.add(Help);
    jToolBar1.add(BNew, null);
    jToolBar1.add(BOpen, null);
    jToolBar1.add(BSave, null);
    jToolBar1.add(BRun, null);
    jToolBar1.add(BExe, null);
    this.getContentPane().add(jToolBar1, BorderLayout.NORTH);
    this.getContentPane().add(desktop, BorderLayout.WEST);
    Panel.add(desktop,BorderLayout.CENTER);
    this.getContentPane().add(Panel, BorderLayout.CENTER);

  }

  //Cria um novo internal frame.
    protected void createFrame() 
    {        
        frame = new Memo(true);

        //int offset = 30 * desktop.getAllFrames().length;
      	//frame.setLocation( offset, offset );
        frame.setLocation( 0, 0 );
        
        frame.setVisible(true); //necessary as of 1.3
        desktop.add(frame);
        try {
            frame.setSelected(true);
        } catch (java.beans.PropertyVetoException e) {}
    }

    //Abre um novo internal frame.
    protected void openFrame() 
    {        
        frame = new Memo(false);

        /*int offset = 30 * desktop.getAllFrames().length;
      	frame.setLocation( offset, offset );*/
        frame.setLocation(0,0);
        
        frame.setVisible(true); //necessary as of 1.3
        desktop.add(frame);
        try {
            frame.setSelected(true);
        } catch (java.beans.PropertyVetoException e) {}
    }

  void fileExit_ActionPerformed(ActionEvent e)
  {
    System.exit(0);
  }

  private void Exit_actionPerformed(ActionEvent e)
  {
    Object[] options = { "Sim", "Não" };
    int decisao = JOptionPane.showOptionDialog(null, 
    "Deseja realmente sair?", "Sair do programa!", 
    JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE,
    null, options, options[0]);
	
    if (decisao == 0) 
    {
        this.dispose();
        System.exit(0);
    }
  }  

  private void BNew_actionPerformed(ActionEvent e)
  {
    desktop.removeAll();
    createFrame();
  }

  private void New_actionPerformed(ActionEvent e)
  {
    desktop.removeAll();
    createFrame();
  }

  private void Salvar_actionPerformed(ActionEvent e)
  {
    
    
  }

  private void BOpen_actionPerformed(ActionEvent e)
  {
    openFrame();
  }

  private void Open_actionPerformed(ActionEvent e)
  {
    openFrame();
  }

  private void Close_actionPerformed(ActionEvent e)
  {        
    desktop.remove(desktop.getSelectedFrame());
    desktop.getSelectedFrame().dispose();
    System.gc();
    this.repaint();
  }
  
 private String pegaAreaInst()
  {
  	areaInst = "";
  	String nome;
   	String op1;
   	String op2;
   	
   	int cont=0;
   	
  	areaInst += "[  ]\tCODIGO\tOP1\tOP2\n";
  	
   	do
   	{
   		nome = inst[cont].nome;   		
   		op1 = ""+inst[cont].op1;
   		op2 = ""+inst[cont].op2;
   		
   		if(op1.equals("-1"))
   			op1 = "-";
   		
   		if(op2.equals("-1"))
   			op2 = "-";
   		
   		areaInst += (cont) + "\t" + nome + "\t" + op1 + "\t" + op2 + "\n";
   		  		
   		cont = cont + 1;
   		
   	}while(inst[cont]!=null);
   	
   	return areaInst;
   	
  }


  private void executar()
  {
        String aux_erro;  
        ret = new Lexico().analisar(frame);
        
        BExe.enable(false);
        
        if(err == null)
        {
          err = new Erro((String)ret.elementAt(1)); 
        }
        else
        {
          desktop.remove(err);
          aux_erro = (String)ret.elementAt(1);        
          err.setTexto(aux_erro);
          erro_lexico = false;
          if (!aux_erro.toUpperCase().equals("SUCESSO!")){
          	err.setTexto("Erro léxico:\n" + aux_erro);
          	erro_lexico = true;
          }
        }

        Vector tokens = (Vector)ret.elementAt(0);

        String aux = "";

          aux += ("CÓDIGO" + "\t");         
          aux += ("DESCRIÇÃO" + "\t");
          aux += ("VALOR" + "\n\n");
          
        for(int i = 0; i < tokens.size(); i++)
        {
          aux += ((Tabela)tokens.elementAt(i)).codigo + "\t";
          aux += ((Tabela)tokens.elementAt(i)).nome + "\t";
          aux += ((Tabela)tokens.elementAt(i)).valor + "\n";
        }
        
        //###### SINTÁTICO ######
        if (!erro_lexico){
        	SintaticoNovo sintatico = new SintaticoNovo(tokens);
        	Vector ret_sint = sintatico.executar();
        	
        	msg = (String)ret_sint.elementAt(0);
        	inst = (DadosInstrucao[])ret_sint.elementAt(1);
        	lit = (Vector)ret_sint.elementAt(2);
        	
        	err.setTexto(msg);
        	
        	if (msg.toUpperCase().equals("SUCESSO!"))
				BExe.enable(true);

        }
        
        if(tk == null)
        {
          tk = new Token(aux, pegaAreaInst());
        }
        else
        {
          desktop.remove(tk);
          tk.setTextoToken(aux);
          tk.setTextoArea(pegaAreaInst());
          //tk.show();
        }
        
               
        //int offset = 30 * desktop.getAllFrames().length;
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        //this.setSize(, screenSize.height);
      	tk.setLocation( screenSize.width-264/*718*/, 0 );
        err.setLocation( 0, 370 );
        
        tk.setVisible(true); //necessary as of 1.3
        desktop.add(tk);
        desktop.add(err);
        try {
            tk.setSelected(true);
        } catch (java.beans.PropertyVetoException ex) {}

  }


  private int getCodigoInstrucao(String nome)
  {
  	if ( nome.equals("RETU") )
  		return 1;
  	if ( nome.equals("CRVL") )
  		return 2;
  	if ( nome.equals("CRCT") )
  		return 3;
  	if ( nome.equals("ARMZ") )
  		return 4;
  	if ( nome.equals("SOMA") )
  		return 5;
  	if ( nome.equals("SUBT") )
  		return 6;
  	if ( nome.equals("MULT") )
  		return 7;
  	if ( nome.equals("DIVI") )
  		return 8;
  	if ( nome.equals("INVR") )
  		return 9;
  	if ( nome.equals("NEGA") )
  		return 10;
  	if ( nome.equals("CONJ") )
  		return 11;
  	if ( nome.equals("DISJ") )
  		return 12;
  	if ( nome.equals("CMME") )
  		return 13;
  	if ( nome.equals("CMMA") )
  		return 14;
  	if ( nome.equals("CMIG") )
  		return 15;
  	if ( nome.equals("CMDF") )
  		return 16;
  	if ( nome.equals("CMEI") )
  		return 17;
  	if ( nome.equals("CMAI") )
  		return 18;
  	if ( nome.equals("DSVS") )
  		return 19;
  	if ( nome.equals("DSVF") )
  		return 20;
  	if ( nome.equals("LEIT") )
  		return 21;
  	if ( nome.equals("IMPR") )
  		return 22;
  	if ( nome.equals("IMPRLIT") )
  		return 23;
  	if ( nome.equals("AMEM") )
  		return 24;
  	if ( nome.equals("CALL") )
  		return 25;
  	if ( nome.equals("PARA") )
  		return 26;
  	if ( nome.equals("NADA") )
  		return 27;
  	if ( nome.equals("COPI") )
  		return 28;
  	if ( nome.equals("DSVT") )
  		return 29;
  		
  	return -1;
  }
  
  private void rodar()
  {
   	int cont = 0;
   	
   	String nome;
   	int operador; //usado pela maquina hipotetica como sendo a instrucao
   	int op1;
   	int op2;
   	Hipotetica hip = new Hipotetica();
	AreaInstrucoes AI = new AreaInstrucoes();
	AreaLiterais AL = new AreaLiterais();

   	hip.InicializaAI(AI);
   	hip.InicializaAL(AL);
   	
   	//Area de instrucoes
   	do
   	{
   		nome = inst[cont].nome;
   		operador = getCodigoInstrucao(nome);
   		op1 = inst[cont].op1;
   		op2 = inst[cont].op2;
   		
   		if (operador <= 0)
   		{
   			JOptionPane.showMessageDialog(null,"Instrucao nao encontrada!","Erro fatal!",JOptionPane.ERROR_MESSAGE);
   		}
   		else
   		{
   			hip.IncluirAI(AI,operador,op1,op2);
   		}
   		
   		cont = cont + 1;
   	}while(inst[cont]!=null);
   	
   	
   	//Area de literais
	for (cont=0;cont<lit.size();cont++)
   	{
		hip.IncluirAL(AL,(String)lit.elementAt(cont));
   	}
   	
   	hip.Interpreta(AI,AL);
  }

  private void BRun_actionPerformed(ActionEvent e)
  {
    executar();
  }

  private void RunProj_actionPerformed(ActionEvent e)
  {
    executar();
  }

  private void About_actionPerformed(ActionEvent e)
  {
    new Sobre().show();
  }

  private void BExe_actionPerformed(ActionEvent e)
  {
    rodar();
  }
  
}