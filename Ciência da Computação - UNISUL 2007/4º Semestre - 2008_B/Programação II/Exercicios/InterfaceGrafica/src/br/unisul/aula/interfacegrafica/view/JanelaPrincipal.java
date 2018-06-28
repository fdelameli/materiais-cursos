package br.unisul.aula.interfacegrafica.view;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Event;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JToolBar;
import javax.swing.KeyStroke;
import javax.swing.UIManager;


/**
 * Classe que representa a Janela Principal do programa.
 * @author Fabio Dela Bruna.
 *
 */
public class JanelaPrincipal extends JFrame {

	private static final long serialVersionUID = 1L;
	private JMenuBar menuBar;
	private JMenu menuArquivo, menuAjuda, menuAbrir, menuOperacao, menuRelatorio;
	private JMenuItem menuSair, menuCalc, menuSobre, menuBlocoNotas,
			menuManterCliente, menuManterFuncionario, menuManterReserva,
			menuManterQuarto, menuRelatorioCliente, menuRelatorioQuartosDisp;
	private JToolBar toolBar;
	private JButton botaoCalc, botalBlocoNotas, botaoSair, botaoFechaFrameAtivo, fechaTodasJanelas;
	private JDesktopPane desktopPane;
	
	
	/**
	 * Construtor default.
	 */
	public JanelaPrincipal() {
		super("Sistema exemplo para Hotéis");
		
		Container c = this.getContentPane();
				
		this.desktopPane = new JDesktopPane();
		
		
		
		//ícones
		
		String dir32 = "images/32x32/"; //diretório dos ícones em 32x32 pixels.
		
		ImageIcon iconCalc = new ImageIcon(dir32 + "calc32x32.gif");
		ImageIcon iconBlocoNotas = new ImageIcon(dir32 + "notepad32x32.gif");
//		ImageIcon iconSalvar = new ImageIcon(dir32 + "salvar32x32.gif");
		ImageIcon iconSair = new ImageIcon(dir32 + "close32x32.gif");
		ImageIcon iconSobre = new ImageIcon(dir32 + "help32x32.gif");
		ImageIcon iconCloseJanAti = new ImageIcon(dir32 + "f_jan_ativ32x32.gif");
		ImageIcon iconCloseAllJan = new ImageIcon(dir32 + "f_jan_aber32x32.gif");
		
//		String dir16 = "images/16x16"; //diretório dos ícones em 16x16 pixels.

//		ImageIcon iconInfo = new ImageIcon(dir16 + "info16x16.gif");
		
		
		this.menuBar = new JMenuBar();
		
		this.menuArquivo = new JMenu("Arquivo");
		this.menuArquivo.setMnemonic('A');
		
		this.menuAbrir = new JMenu("Abrir");
		this.menuAbrir.setMnemonic('r');
		
		this.menuAjuda = new JMenu("Ajuda");
		this.menuAjuda.setMnemonic('j');
		
		this.menuCalc = new JMenuItem("Calculadora");
		this.menuCalc.setMnemonic('C');
		this.menuCalc.setIcon(iconCalc);
		this.menuCalc.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_O, Event.CTRL_MASK));
		this.menuCalc.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				abrirCalculadora();
			}
		});
		
		this.menuBlocoNotas = new JMenuItem("Bloco de Notas");
		this.menuBlocoNotas.setMnemonic('B');
		this.menuBlocoNotas.setIcon(iconBlocoNotas);
		this.menuBlocoNotas.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_B, Event.CTRL_MASK));
		this.menuBlocoNotas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				abrirBlocoNotas();
			}
		});
		
		this.menuSair = new JMenuItem("Sair");
		this.menuSair.setMnemonic('S');
		this.menuSair.setIcon(iconSair);
		this.menuSair.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F4, Event.ALT_MASK));
		this.menuSair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				sairPrograma();
			}
		});
		
		this.menuSobre = new JMenuItem("Sobre");
		this.menuSobre.setMnemonic('b');
		this.menuSobre.setIcon(iconSobre);
		this.menuSobre.addActionListener( new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				openFrameSobre();
			}
		});
		
		
		this.menuOperacao= new JMenu("Operações");
		this.menuOperacao.setMnemonic('O');
		
		
		this.menuManterCliente = new JMenuItem("Manter Clientes");
		this.menuManterCliente.setMnemonic('e');
		this.menuManterCliente.addActionListener( new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				abrirFrameManterCliente();
			}
		});
		
		this.menuManterFuncionario = new JMenuItem("Manter Funcionários");
		this.menuManterFuncionario.setMnemonic('F');
		this.menuManterFuncionario.addActionListener( new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				abrirFrameManterFuncionario();
			}
		});
		
		this.menuManterReserva = new JMenuItem("Manter Reservas");
		this.menuManterReserva.setMnemonic('R');
		this.menuManterReserva.addActionListener( new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				abrirFrameManterReserva();
			}
			
		});
		
		this.menuManterQuarto = new JMenuItem("Manter Quartos");
		this.menuManterQuarto.setMnemonic('Q');
		this.menuManterQuarto.addActionListener( new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				abrirFrameManterQuarto();
			}
		});
		
		this.menuRelatorio = new JMenu("Relatórios");
		this.menuRelatorio.setMnemonic('R');
		
		this.menuRelatorioCliente = new JMenuItem("Clientes");
		this.menuRelatorioCliente.setMnemonic('C');
		this.menuRelatorioCliente.addActionListener( new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
			}
			
		});
		
		this.menuRelatorioQuartosDisp = new JMenuItem("Quartos Disponíveis");
		this.menuRelatorioQuartosDisp.setMnemonic('Q');
		this.menuRelatorioQuartosDisp.addActionListener( new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
			}
		});
		
		
		
		//botão para abrir a calculadora.
		this.botaoCalc = new JButton();
		this.botaoCalc.setToolTipText("Calculadora");
		this.botaoCalc.setIcon(iconCalc);
		this.botaoCalc.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				abrirCalculadora();
			}
		});
		
		
		//botão para abrir o bloco de notas
		this.botalBlocoNotas = new JButton();
		this.botalBlocoNotas.setToolTipText("Bloco de Notas");
		this.botalBlocoNotas.setIcon(iconBlocoNotas);
		this.botalBlocoNotas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				abrirBlocoNotas();
			}
		});
		
		
		//botão para sair do programa
		this.botaoSair = new JButton();
		this.botaoSair.setToolTipText("Sair");
		this.botaoSair.setIcon(iconSair);
		this.botaoSair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				sairPrograma();	
			}
		});
		
		
		this.botaoFechaFrameAtivo = new JButton();
		this.botaoFechaFrameAtivo.setToolTipText("Fecha a janela que estiver selecionada");
		this.botaoFechaFrameAtivo.setIcon(iconCloseJanAti);
		this.botaoFechaFrameAtivo.addActionListener( new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				fechaFrameAtivo();
			}
		});
		
		
		this.fechaTodasJanelas = new JButton();
		this.fechaTodasJanelas.setToolTipText("Fecha todas as janelas abertas");
		this.fechaTodasJanelas.setIcon(iconCloseAllJan);
		this.fechaTodasJanelas.addActionListener ( new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				fechaTodasJanelas();
			}
		});
		
		
		//adicionando botões à barra de tarefas
		this.toolBar = new JToolBar();
		this.toolBar.setSize(1000, 40);
		this.toolBar.setLocation(0, 0);
		this.toolBar.add(this.botaoCalc);
		this.toolBar.add(this.botalBlocoNotas);
		this.toolBar.addSeparator();
		this.toolBar.add(this.botaoFechaFrameAtivo);
		this.toolBar.add(this.fechaTodasJanelas);
		this.toolBar.addSeparator();
		this.toolBar.add(this.botaoSair);
		
		
		
		//adicionando menus ao menu abrir
		this.menuAbrir.add(this.menuCalc);
		this.menuAbrir.add(this.menuBlocoNotas);
		
		//menu arquivo
		this.menuArquivo.add(menuAbrir);
		this.menuArquivo.addSeparator();
		this.menuArquivo.add(this.menuSair);
		
		
		this.menuOperacao.add(this.menuManterCliente);
		this.menuOperacao.add(this.menuManterFuncionario);
		this.menuOperacao.add(this.menuManterReserva);
		this.menuOperacao.add(this.menuManterQuarto);
		
		
		this.menuRelatorio.add(this.menuRelatorioCliente);
		this.menuRelatorio.add(this.menuRelatorioQuartosDisp);	
		
		//menu ajuda
		this.menuAjuda.add(this.menuSobre);
		
		//barra de menus
		this.menuBar.add(this.menuArquivo);
		this.menuBar.add(this.menuOperacao);
		this.menuBar.add(this.menuRelatorio);
		this.menuBar.add(this.menuAjuda);
		
		
		c.add(this.toolBar, BorderLayout.NORTH);
		c.add(this.desktopPane, BorderLayout.CENTER);
		
		this.setJMenuBar(this.menuBar);
	
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
	}
	

	
	/**
	 * Método que finaliza o programa.
	 */
	private void sairPrograma() {
		
		UIManager.put("OptionPane.yesButtonText", "Sim");
		UIManager.put("OptionPane.noButtonText", "Não");
		
		int opt = JOptionPane.showConfirmDialog(null, "Deseja realmente fechar o programa?",
				"Fechar...", JOptionPane.YES_NO_OPTION);
		if (opt == 0)
			System.exit(0);
	}
	
	/**
	 * Método para abrir a calculadora.
	 */
	private void abrirCalculadora() {
		Calculadora calc = new Calculadora();
		this.desktopPane.add(calc);
		calc.setVisible(true);
	}
	
	/**
	 * Método para abrir o bloco de notas.
	 */
	private void abrirBlocoNotas() {
		BlocoNotas bn = new BlocoNotas();
		this.desktopPane.add(bn);
		bn.setVisible(true);
	}
	
	/**
	 * Método que abre a janela de manutenção de clientes.
	 */
	private void abrirFrameManterCliente() {
		ManterCliente mc = new ManterCliente(this);
		this.desktopPane.add(mc);
		mc.setVisible(true);
	}
	
	/**
	 * Método que abre a janela de manutenção de funcionários.
	 */
	private void abrirFrameManterFuncionario() {
		ManterFuncionarios mf = new ManterFuncionarios(this);
		this.desktopPane.add(mf);
		mf.setVisible(true);
	}
	
	/**
	 * Método que abre a janela de manutenção de Reservas.
	 */
	private void abrirFrameManterReserva() {
		ManterReserva mr = new ManterReserva(this);
		this.desktopPane.add(mr);
		mr.setVisible(true);
	}
	
	/**
	 * Método que abre a janela de manutenção de Quartos.
	 */
	private void abrirFrameManterQuarto() {
		ManterQuarto mq = new ManterQuarto(this);
		this.desktopPane.add(mq);
		mq.setVisible(true);
	}
	
	/**
	 * Método que abre a janela de informações Sobre.
	 */
	private void openFrameSobre() {
		Sobre sobre = new Sobre();
		this.desktopPane.add(sobre);
		sobre.setVisible(true);
	}
	
	/**
	 * Método para fechar a janela que estiver selecionada dentro do DesktopPane
	 */
	private void fechaFrameAtivo() {
		if (this.desktopPane.getSelectedFrame() != null)
			this.desktopPane.getSelectedFrame().dispose();
	}
	
	/**
	 * Método para fechar todas as janelas dentro do DesktopPane.
	 */
	private void fechaTodasJanelas() {
		JInternalFrame[] list = this.desktopPane.getAllFrames();
		for (JInternalFrame frame : list) {
			frame.dispose();
		}
	}


	
	// getters e setters

	public JDesktopPane getDesktopPane() {
		return desktopPane;
	}

	public void setDesktopPane(JDesktopPane desktopPane) {
		this.desktopPane = desktopPane;
	}
	
	
}
