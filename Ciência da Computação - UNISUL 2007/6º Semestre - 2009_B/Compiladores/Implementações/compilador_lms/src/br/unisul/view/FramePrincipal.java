package br.unisul.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JToolBar;
import javax.swing.KeyStroke;
import javax.swing.SwingConstants;

import br.unisul.lexico.Compilador_Lexico;
import br.unisul.model.Token;
import br.unisul.sintatico.Compilador_Sintatico;

/**
 * Classe que exibe a tabela de tokens da linguagem LMS.
 * @author Fabio Dela Bruna, Márcio Ozório Teixeira.
 */
public class FramePrincipal extends JFrame {

	private static final long serialVersionUID = 1L;
	private JMenuBar menuBar; // barra de menus
	private JMenu menuArquivo; // menu arquivo
	private JMenu menuAnalise; // menu análise
	private JToolBar toolBar; // barra de ferramentas
	private JTextArea textArea; // área para digitar o código fonte
	private File arquivo; // arquivo de texto para armazenar o fonte
	private JFileChooser fileChooser; // diálogo de navegação
	private final String DIRETORIO_TESTES = "testes";
	private Compilador_Lexico analisadorLexico;
	
	
	
	
	/**
	 * Construtor da classe. Monta a GUI.
	 */
	public FramePrincipal() {
		super( "Compilador LMS - Ambiente para compilação e execução da linguagem LMS" );
		analisadorLexico = new Compilador_Lexico();
		
		ImageIcon iconImage = new ImageIcon( "icons/icon1.gif" );
		super.setIconImage( iconImage.getImage() );
		
		setResizable( false );
		
		// seta tamanho da janela.
		Dimension dimensionFrame = Toolkit.getDefaultToolkit().getScreenSize();
		setSize( dimensionFrame );
		
		menuBar = new JMenuBar(); // inicializa menuBar
		
		// cria menuArquivo e seus componentes
		menuArquivo = new JMenu( "Arquivo" );
		menuArquivo.setMnemonic( 'A' );
		
		// cria item de menu: novo
		JMenuItem menuItemNovo = new JMenuItem( "Novo" );
		menuItemNovo.setAccelerator( KeyStroke.getKeyStroke( KeyEvent.VK_N, ActionEvent.CTRL_MASK ) );
		menuItemNovo.setMnemonic( 'N' );
		menuItemNovo.addActionListener( 
				new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						novo();
					}
				}
		);
		
		// cria item de menu: abrir
		JMenuItem menuItemAbrir = new JMenuItem( "Abrir" );
		menuItemAbrir.setAccelerator( KeyStroke.getKeyStroke( KeyEvent.VK_A, ActionEvent.CTRL_MASK ) );
		menuItemAbrir.setMnemonic( 'A' );
		menuItemAbrir.addActionListener( 
				new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						abrir();
					}
				}
		);
		
		// cria item de menu: salvar
		JMenuItem menuItemSalvar = new JMenuItem( "Salvar" );
		menuItemSalvar.setAccelerator( KeyStroke.getKeyStroke( KeyEvent.VK_B, ActionEvent.CTRL_MASK ) );
		menuItemSalvar.setMnemonic( 'S' );
		menuItemSalvar.addActionListener( 
				new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						salvar();
					}
				}
		);
		
		// cria item de menu: salvar como
		JMenuItem menuItemSalvarComo = new JMenuItem( "Salvar como" );
		menuItemSalvarComo.setAccelerator( KeyStroke.getKeyStroke( KeyEvent.VK_O, ActionEvent.CTRL_MASK ) );
		menuItemSalvarComo.setMnemonic( 'v' );
		menuItemSalvarComo.addActionListener(
				new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						salvarComo();
					}
				}
		);
		
		// cria item de menu: fechar
		JMenuItem menuItemSair = new JMenuItem( "Sair" );
		menuItemSair.setAccelerator( KeyStroke.getKeyStroke( KeyEvent.VK_F4, ActionEvent.ALT_MASK ) );
		menuItemSalvar.setMnemonic( 'r' );
		menuItemSair.addActionListener( 
				new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						closeAplication();
					}
				}
		);
		
		
		// cria menuAnalise e seus componentes
		menuAnalise = new JMenu( "Compilar" );
		menuAnalise.setMnemonic( 'C' );
		
		JMenuItem executar = new JMenuItem( "Compilar e Executar!" );
		executar.setMnemonic( 'E' );
		executar.setAccelerator(  KeyStroke.getKeyStroke( KeyEvent.VK_F11, ActionEvent.CTRL_MASK ) );
		executar.addActionListener( new ActionListener() {
				public void actionPerformed(ActionEvent e) {
						compilar();
					}
				}
		);
		
		
		menuAnalise.add( executar ); // item de menu que chama o método para análise e execução do fonte.
		
		
		
		// adiciona itens de menu ao menuArquivo
		menuArquivo.add( menuItemNovo );
		menuArquivo.add( menuItemAbrir );
		menuArquivo.add( menuItemSalvar );
		menuArquivo.add( menuItemSalvarComo );
		menuArquivo.addSeparator(); // adiciona separador
		menuArquivo.add( menuItemSair );
		
		// adiciona menus à barra de menus
		menuBar.add( menuArquivo );
		menuBar.add( menuAnalise );
		
		// cria toolBar e seus componentes
		toolBar = new JToolBar();
		
		// cria botão: novo
		JButton buttonNovo = new JButton();
		buttonNovo.setIcon( new ImageIcon( "icons/new.gif" ) );
		buttonNovo.setToolTipText( "Novo documento em branco." );
		buttonNovo.addActionListener( 
				new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						novo();
					};
				}
		);
		
		// cria botão: abrir
		JButton buttonAbrir = new JButton();
		buttonAbrir.setIcon( new ImageIcon( "icons/open.gif" ) );
		buttonAbrir.setToolTipText( "Abrir documento." );
		buttonAbrir.addActionListener( 
				new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						abrir();
					}
				}
		);
		
		// cria botão: salvar
		JButton buttonSalvar = new JButton();
		buttonSalvar.setIcon( new ImageIcon( "icons/save.gif" ) );
		buttonSalvar.setToolTipText( "Salvar documento." );
		buttonSalvar.addActionListener( 
				new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						salvar();
					}
				}
		);
		
		// cria item de menu: salvar como
		JButton buttonSalvarComo = new JButton();
		buttonSalvarComo.setIcon( new ImageIcon( "icons/saveas.gif" ) );
		buttonSalvarComo.setToolTipText( "Salvar documento como..." );
		buttonSalvarComo.addActionListener(
				new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						salvarComo();
					}
				}
		);
		
		JButton buttonExecutar = new JButton();
		buttonExecutar.setIcon( new ImageIcon( "icons/exec2.gif" ) );
		buttonExecutar.setToolTipText( "Compila e executa o projeto." );
		buttonExecutar.addActionListener( new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					compilar();
				}
			}
		);

		// adiciona componentes à toolBar
		toolBar.add( buttonNovo );
		toolBar.add( buttonAbrir );
		toolBar.add( buttonSalvar );
		toolBar.add( buttonSalvarComo );
		toolBar.addSeparator();
		toolBar.add( buttonExecutar );

		// cria textArea e o adiciona em um jScrollPane
		textArea = new JTextArea();
		textArea.setTabSize( 3 );
		textArea.setFont( new Font( "Monospaced", Font.BOLD, 18 ) );
		textArea.setBorder( BorderFactory.createEmptyBorder( 5, 10, 0, 0 ) );
		JScrollPane scroll = new JScrollPane( textArea );
		
		// adiciona a menubar
		setJMenuBar( menuBar );

		// cria painel para armazenar textArea e panel de imagem
		JPanel panelImage = new JPanel( new BorderLayout() );
		panelImage.setBackground( Color.WHITE );
		panelImage.setBorder( BorderFactory.createLineBorder( Color.GRAY ) );
		
		ImageIcon lmsIcon = new ImageIcon( "icons/lmsIcon.gif" );
		
		
		GridLayout layout = new GridLayout();
		layout.setRows( 12 );
		
		JPanel panelSobre = new JPanel( layout );
		panelSobre.setBackground( Color.WHITE );
		
		Color cor = new Color( 96, 197, 236 );
		Font font = new Font( "Trebuched MS", Font.BOLD, 14 );
		
		JLabel unisul1 = new JLabel( "UNIVERSIDADE DO SUL DE SANTA CATARINA", SwingConstants.CENTER );
		unisul1.setFont( font );
		unisul1.setForeground( cor );
		
		JLabel unisul2 = new JLabel( "UNISUL", SwingConstants.CENTER );
		unisul2.setFont( font );
		unisul2.setForeground( cor );
		
		JLabel labelVazioParaGambiarra1 = new JLabel( "" );

		JLabel labelDescricao = new JLabel( "Trabalho da disciplina de Compiladores", SwingConstants.CENTER );
		labelDescricao.setFont( font );
		labelDescricao.setForeground( cor );
		
		JLabel labelVazioParaGambiarra2 = new JLabel( "" );
		
		JLabel labelOrientadorDes = new JLabel( "Orientado pelo professor:", SwingConstants.CENTER );
		labelOrientadorDes.setFont( font );
		labelOrientadorDes.setForeground( cor );
		
		JLabel labelOrientador = new JLabel( "Dr. Luiz Alfredo Soares Garcindo", SwingConstants.CENTER );
		labelOrientador.setFont( font );
		labelOrientador.setForeground( cor );
		
		JLabel labelVazioParaGambiarra3 = new JLabel( "" );
		
		JLabel labelDesenvolv = new JLabel( "Desenvolvido por:", SwingConstants.CENTER );
		labelDesenvolv.setFont( font );
		labelDesenvolv.setForeground( cor );
		
		JLabel labelDevelopers = new JLabel( "Fabio Dela Bruna / Márcio Ozório Teixeira", SwingConstants.CENTER );
		labelDevelopers.setFont( font );
		labelDevelopers.setForeground( cor );
		
		panelSobre.add( unisul1 );
		panelSobre.add( unisul2 );
		panelSobre.add( labelVazioParaGambiarra1 );
		panelSobre.add( labelDescricao );
		panelSobre.add( labelVazioParaGambiarra2 );
		panelSobre.add( labelOrientadorDes );
		panelSobre.add( labelOrientador );
		panelSobre.add( labelVazioParaGambiarra3 );
		panelSobre.add( labelDesenvolv );
		panelSobre.add( labelDevelopers );
		
		
		panelImage.add( new JLabel( lmsIcon ), BorderLayout.NORTH );
		panelImage.add( panelSobre, BorderLayout.SOUTH );
		
		getContentPane().add( toolBar, BorderLayout.NORTH );
		getContentPane().add( panelImage, BorderLayout.EAST );
		getContentPane().add( scroll, BorderLayout.CENTER );
		
	}
	
	
	// métodos para tratar eventos da aplicação
	
	
	/**
	 * Fecha a janela principal.
	 */
	private void closeAplication() {
		dispose();
	}
	
	
	/**
	 * Abre um diálogo para que o usuário possa escolher
	 * o local e o nome do arquivo a ser salvo.
	 */
	private void salvarComo() {
		
		fileChooser = new JFileChooser( DIRETORIO_TESTES );
		fileChooser.setFileFilter( new br.unisul.view.FileFilter() );
		fileChooser.setFileSelectionMode( JFileChooser.FILES_ONLY );
		
		int result = fileChooser.showSaveDialog( this );
		String nome = null;
		
		// se o usuário clicar no botão cancel
		if ( result == JFileChooser.CANCEL_OPTION ) {
			return;
		} else {
			arquivo = fileChooser.getSelectedFile();
			nome = arquivo.getPath();
			
			if ( !nome.toLowerCase().endsWith( ".lms" ) )
				nome = nome + ".lms";
		}
		
		gravarArquivo( nome );
		
	}
	
	
	/**
	 * Salva o programa-fonte em um arquivo de 
	 * texto simples e com extensão <code>.lms</code>
	 */
	private void gravarArquivo( String nome ) {
		if ( ( arquivo = new File( nome ) ).exists() ) {

			Object[] options = { "Sim", "Não" };

			int decisao = JOptionPane.showOptionDialog( this , "Deseja sobrescrever o arquivo existente?", "Salvar!",
					JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE,
					new ImageIcon("icons/warn.png"), options, options[0] );

			if ( decisao == 0 ) {
				gravaNoArquivo();
			} else {
				salvarComo();
			}

		} else {
			gravaNoArquivo();
		}
	}
	
	
	/**
	 * Se o arquivo já existir apenas grava no arquivo.
	 */
	private void salvar() {
		if ( arquivo != null ) {
			gravaNoArquivo();
		} else {
			salvarComo();
		}
	}
	
	
	/**
	 * Grava dados no arquivo.
	 */
	private void gravaNoArquivo() {
		try {
			FileWriter writer = new FileWriter( arquivo, false );
			writer.write( textArea.getText() );
			writer.flush();
			writer.close();
			
			JOptionPane.showMessageDialog( null, new JLabel( "Arquivo salvo com sucesso!", SwingConstants.CENTER ),
					"Sucesso!", JOptionPane.PLAIN_MESSAGE, new ImageIcon("icons/ok.png") );
			
			textArea.requestFocus();
			
		} catch ( IOException ioe ) {
			JOptionPane.showMessageDialog( this, "Erro ao gravar arquivo!",
					"Erro", JOptionPane.ERROR_MESSAGE, new ImageIcon("icons/error.png")  );
		}
	}
	
	
	/**
	 * Abre um diálogo para que o usuário
	 * possa escolher o arquivo à abrir.
	 */
	private void abrir() {

		fileChooser = new JFileChooser( DIRETORIO_TESTES );
		fileChooser.setFileFilter( new br.unisul.view.FileFilter() );
		fileChooser.setFileSelectionMode( JFileChooser.FILES_ONLY );
		
		int result = fileChooser.showOpenDialog( this );
		
		// se o usuário clicar no botão cancel
		if ( result == JFileChooser.CANCEL_OPTION ) {
			return;
		} else {
			arquivo = fileChooser.getSelectedFile();
		}
		
		cleanTextArea();
		abrirArquivo();
		textArea.requestFocus();
		
	}
	
	/**
	 * Abre um arquivo-fonte de texto simples
	 * e com extensão <code>.lms</code>
	 */
	private void abrirArquivo() {

		try {
			
			BufferedReader reader = new BufferedReader( new FileReader( arquivo ) );
			String str = null;
			
			// enquanto ainda houver linhas no arquivo.
			while ( ( str = reader.readLine() ) != null ) {
				textArea.append( str + "\n" );
			}
			
		} catch ( IOException ioe ) {
			JOptionPane.showMessageDialog( this , "Erro ao abrir arquivo:\n" + ioe.getMessage(),
					"Erro", JOptionPane.ERROR_MESSAGE, new ImageIcon("icons/erro/r.png")  );
		}
		
	}
	
	/**
	 * Limpa o campo de texto para que o usuário
	 * possa trabalho com um novo código-fonte.
	 * Antes de limpar o campo de texto, é solicitado
	 * ao usuário se ele deseja salvar ou não o fonte.
	 */
	private void novo() {
		
		Object[] options = { "Sim", "Não" };

		int decisao = JOptionPane.showOptionDialog( this ,
				new JLabel( "Deseja salvar o arquivo atual?", SwingConstants.CENTER ),
				"Salvar?", JOptionPane.YES_NO_OPTION, JOptionPane.PLAIN_MESSAGE,
				new ImageIcon("icons/saved.png"), options, options[0]
		);

		if ( decisao == 0 ) {
			salvar(); // chama o método para salvar o arquivo
			cleanTextArea();
		} else {
			cleanTextArea();
			textArea.requestFocus();
		}
		
	}
	
	
	/**
	 * Inicia a compilação e execução do compilador LMS.
	 */
	private void compilar() {
		List<Token> tokens = analisadorLexico.analisar(textArea.getText() + "$");

		if(tokens != null && tokens.size() >= 0)
		{
			StringBuilder resposta = new StringBuilder();

			resposta.append("Código");
			resposta.append("\t");
			resposta.append("Token");
			resposta.append("\t");
			resposta.append("Descrição");
			resposta.append("\n");
			resposta.append("\n");

			boolean sucess = true;
			for(Token token : tokens)
			{
				//verifica se não teve nenhum erro na analise lexica
				if(token.getCdToken() == -1){
					sucess = false;
				}

				resposta.append(token.getCdToken());
				resposta.append("\t");
				resposta.append(token.getNmToken());
				resposta.append("\t");
				resposta.append(token.getTpToken());
				resposta.append("\n");
			}



			JDialog respostaFrame = new JDialog();
			respostaFrame.setTitle("Resposta da análise léxica: ");
			respostaFrame.setSize(300, (int)Toolkit.getDefaultToolkit().getScreenSize().getHeight());
			respostaFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			JTextArea respostaArea = new JTextArea(resposta.toString());
			respostaArea.setEditable(false);
			respostaFrame.add(new JScrollPane(respostaArea));
			respostaFrame.setVisible(true);

			if(sucess){
				Compilador_Sintatico cs = new Compilador_Sintatico();
				List<Token> suporte = new ArrayList<Token>();
				for (Token token : tokens) {
					if(token.getCdToken() != 0 && token.getCdToken() != 51){
						suporte.add(token);
					}else{
						System.err.println("[WARNING] Ignorou Token Inválido! --> "+token.getCdToken());
						//						JOptionPane.showMessageDialog(null, "Ignorou --> "+token.getCdToken());
					}
				}
				cs.analisarBaseInteiro(suporte);
			}else{
				JOptionPane.showMessageDialog(null, "ERRO NA ANÁLISE LÉXICA, ANÁLISE SINTÁTICA NÃO EXECUTADA!");
			}
		}
		else
		{
			JOptionPane.showMessageDialog(null
					, "Erro!!!" );
		}
	}
	
	/**
	 * Limpa o campo de texto.
	 */
	private void cleanTextArea() {
		textArea.setText( "" );
	}
	
	
	/**
	 * Seta o focus para o textArea.
	 */
	public void setFocusTextArea() {
		textArea.requestFocus();
	}
	
	
}
