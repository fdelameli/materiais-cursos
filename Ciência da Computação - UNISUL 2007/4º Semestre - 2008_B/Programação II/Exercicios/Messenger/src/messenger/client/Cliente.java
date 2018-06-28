package messenger.client;

import static messenger.MessengerConstants.CHARS_LIMIT;
import static messenger.MessengerConstants.SERVER_IP;
import static messenger.MessengerConstants.SERVER_PORT;
import static messenger.MessengerConstants.STRING_SEPARATOR;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.EOFException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ConnectException;
import java.net.InetAddress;
import java.net.Socket;
import java.net.SocketException;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.PlainDocument;

/**
 * Classe que representa um cliente de um servidor.
 * Este cliente lê e exibe as informações enviadas a partir de um servidor.
 * @author Fabio Dela Bruna
 */
public class Cliente extends JFrame {

	private static final long serialVersionUID = 1L;
	
	private JTextField enterField; // insere informações fornecidas pelo usuário.
	private JTextArea displayArea; // exibe informações para o usuário.
	private JPanel centerPanel; // painel central com a displayArea.
	private JPanel southPanel; // painel da parte inferior contendo o enterField e o botão para enviar a mensagem.
	private JLabel limitCharsLabel; // jLabel para informar na tela o limite de characters do enterField.
	private ObjectOutputStream output; // gera o fluxo de saída para o servidor.
	private ObjectInputStream input; // gera o fluxo de entrada a partir do servido.
	private String message; // mensagem do servidor.
	private Socket client; // socket para comunicação com o servidor.
	
	
	/**
	 * Contrutor da classe Cliente.
	 * O construtor é que monta a GUI.
	 */
	public Cliente( ) {
		
		super ( "CCP-Messenger (client)" );
		
		// cria enterField e "seta" os atributos.
		enterField = new JTextField( new LimitadorTexto( CHARS_LIMIT ), "", 53 );
		enterField.setEditable( false );
		enterField.setToolTipText( "Está inativo, pois ainda não há uma conexão!" );
		enterField.addActionListener( new SendMessageListener() );
		
		// cria limitCharsLabel e "seta" os seus atributos.
		limitCharsLabel = new JLabel( "( máx. " + CHARS_LIMIT + " caracteres )" );
		//limitCharsLabel.setFont(new Font( "Brush Script MT", Font.ITALIC, 20 ) );

		// cria southPanel e adiciona a ele: enterField e limitCharsLabel
		southPanel = new JPanel();
		southPanel.add( enterField);
		southPanel.add( limitCharsLabel );
		add( southPanel, BorderLayout.SOUTH );
		
		
		// cria displayArea e "seta" os atributos.
		displayArea = new JTextArea( 11, 67 );
		displayArea.setBorder( BorderFactory.createEmptyBorder( 5, 5, 5, 5 ) );
		displayArea.setEditable( false ); // impossibilita de editar a displayArea.
		//displayArea.setFont( new Font( "A", Font.PLAIN, 15 ) );

		
		// cria centerPanel e adiciona a ele: displayArea em um JScrollPane.
		centerPanel = new JPanel();
		centerPanel.add( new JScrollPane( displayArea ) );
		
		add(centerPanel, BorderLayout.CENTER );
		

		setSize( 600, 300 );
		setResizable( false );
		setVisible( true );
		
	} // fim do construtor da classe.
	
	
	
	/**
	 * Este método efetua a conexão com o servidor e
	 * processa as mensagens a partir do servidor.
	 */
	public void runClient() {
		
		try {
			
			connectToServer(); // cria um Socket para fazer a conexão.
			getStreams(); // obtém os fluxos de entrada e saída.
			processConnection(); // processa a conexão.
			
		} catch ( EOFException eofe ) {
			displayMessage( "\nA conexão foi encerrada!" );
			
		} catch ( IOException ioe ) {
			ioe.printStackTrace();
			
		} finally {
			closeConnection(); // fecha a conexão.
		}
	}
	
	
	/**
	 * Este método efetua a conexão com o servidor.
	 * @throws IOException
	 */
	private void connectToServer() throws IOException {
		
		displayMessage( "Aguardando na fila para se conectar!\n" );
		
		try {
		
			// cria Socket para fazer a conexão ao servidor.
			client = new Socket( InetAddress.getByName( SERVER_IP ), SERVER_PORT );
			
			// exibe informações sobre a conexão.
			displayMessage( "Conectado a: " +
					client.getInetAddress().getHostName() );
		
		} catch ( ConnectException ce ) {
			displayMessage( "Você não pode se conectar no momento. Tente mais tarde!" );
		}
			
	}
	
	
	/**
	 * Este método obtém fluxos para enviar e receber dados.
	 * @throws IOException
	 */
	private void getStreams() throws IOException {
		
		// configura o fluxo de saída para objetos.
		output = new ObjectOutputStream( client.getOutputStream() );
		output.flush(); // esvazia buffer de saída para enviar as informações de cabeçalho.
		
		// configura o fluxo de entrada para objetos.
		input = new ObjectInputStream( client.getInputStream() );
		
		displayMessage( "\nFluxos de entrada/saída inicializados e configurados.\n" );
		
	}
	
	
	/**
	 * Este método pocessa a conexão com o servidor.
	 * @throws IOException
	 */
	private void processConnection() throws IOException {
		
		// ativa enterField de modo que o usuário cliente possa enviar mensagens.
		setTextFieldEditable( true, "Tecle ENTER para enviar a mensagem!" );
		
		do { // processa as mensagens enviadas do servidor.
			
			try {
				
				message = ( String ) input.readObject(); // lê uma nova mensagem.
				displayMessage( "\n" + message ); // exibe a mensagem.
				
			} catch ( ClassNotFoundException cnfe ) {
				displayMessage( "\nA mensagem não pode ser recebida." );	
				
			} catch ( SocketException se ) {
				break;
			}
			
		} while ( !message.equals( "SERVER" + STRING_SEPARATOR + "TERMINATE" ) );

	}
	

	
	/**
	 * Este método fecha os fluxos e o socket.
	 */
	private void closeConnection() {
		
		displayMessage( "\nConexão encerrada!\n" );
		// desativa enterField e altera o toolTipText.
		setTextFieldEditable( false, "Está inativo, pois ainda não há uma conexão!" );

		try {
			
			output.close(); // fecha o fluxo de saída.
			input.close(); // fecha o fluxo de entrada.
			client.close(); // fecha o socket.
			
		} catch ( IOException ioe ) {
			ioe.printStackTrace();
			
		} catch ( NullPointerException npe ) {
			displayMessage( "\nO servidor encontra-se inativo no momento!\n" );
		}
		
	}
	
	
	/**
	 * Este método envia a mensagem ao servidor.
	 * @param message String com a mensagem a ser enviada.
	 */
	private void sendData( String message ) {
		
		try { // envia o objeto ao servidor.
			
			output.writeObject( "CLIENTE" + STRING_SEPARATOR + message );
			output.flush(); // esvazia os dados para saída.
			displayMessage( "\nCLIENTE" + STRING_SEPARATOR + message );
			
		} catch ( IOException ioe ) {
			displayMessage( "\nErro ao processar a mensagem." );
		}
		
	}
	
	
	/**
	 * Este método manipula a displayArea na thread de despacho de eventos.
	 * @param message Mensagem a ser exibida.
	 */
	private void displayMessage( final String messageToDisplay ){

		SwingUtilities.invokeLater(
				new Runnable() {

					/**
					 * Atualiza a displayArea.
					 */
					public void run() {
						displayArea.append( messageToDisplay );
					}

				}
		);

	}
	
	
	/**
	 * Este método manipula o enterField na thread de despacho de eventos.
	 * @param editable Variável booleana.
	 * @param toolTipText Novo toolTipText a ser inserido.
	 */
	private void setTextFieldEditable( final boolean editable, final String toolTipText ) {

		SwingUtilities.invokeLater(
				new Runnable() {

					/**
					 * Configura a editabilidade do enterField
					 * e muda o toolTipText.
					 */
					public void run() {
						enterField.setEditable( editable );
						enterField.setToolTipText( toolTipText );
					}

				}
		);

	}
	
	
	// CLASSES PRIVADAS \\
	
	
	/**
	 * Classe privada responsável por tratar do envento de enviar uma mensagem.
	 * @author Fabio Dela Bruna
	 *
	 */
	private class SendMessageListener implements ActionListener {
		
		public void actionPerformed( ActionEvent event ) {
			sendData( event.getActionCommand() );
			enterField.setText( "" );
		}
		
	} // fim da classe privada SendMessageListener.
	
	
	/**
	 * Classe privada para tratar do limite de characteres que
	 * podem ser inserido pelo cliente no enterField.
	 * @author Fabio Dela Bruna
	 *
	 */
	private class LimitadorTexto extends PlainDocument {  
		
		private static final long serialVersionUID = 1L;
		private int limite = 0;  
	  
	    public LimitadorTexto( int limite ){  
	        this.limite = limite;  
	    }  
	  
	    /**
	     * Trata do limite de caractes no enterField.
	     */
	    public void insertString( int offs, String string, AttributeSet a )  
	               throws BadLocationException {  
	  
	        int sobra = limite - getLength();  
	        int comprimento =  ( sobra > string.length() ) ? string.length() : sobra;  
	        super.insertString( offs, string.substring( 0, comprimento ), a );  
	    }  
	    
	}  
	
}
