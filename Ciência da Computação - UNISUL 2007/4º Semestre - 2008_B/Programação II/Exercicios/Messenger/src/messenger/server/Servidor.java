package messenger.server;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.EOFException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

import static messenger.MessengerConstants.*;

/**
 * Classe que representa um servidor.
 * Este servidor permite que um cliente se conecte e possa enviar e receber mesnsagens.
 * @author Fabio Dela Bruna
 */
public class Servidor extends JFrame {

	private static final long serialVersionUID = 1L;
	private JTextField enterField; // insere a menssagem do usuário.
	private JTextArea displayArea; // exibe informações para o usuário.
	private ObjectOutputStream output; // gera fluxo de saída para o cliente.
	private ObjectInputStream input; // gera o fluxo de entrada a partir do cliente.
	private ServerSocket server; // socket de servidor.
	private Socket connection; // conexão com o cliente.
	private int counter = 1; // contador do numero de conexões.
	
	
	/**
	 * Construtor da classe Servidor, que configura a GUI.
	 */
	public Servidor() {
		super( "CCP-Messenger (server)" );
		
		enterField = new JTextField();
		enterField.setEditable( false );
		enterField.addActionListener(
				new ActionListener() {
					
					public void actionPerformed( ActionEvent e ) {
						sendData( e.getActionCommand() );
						enterField.setText( "" );
					}
					
				}
		);
		
		add( enterField, BorderLayout.SOUTH );
		
		
		displayArea = new JTextArea();
		displayArea.setEditable( false );
		add( new JScrollPane( displayArea ), BorderLayout.CENTER );
		
		
		setSize( 600, 300 );
		setVisible( true );
		
	}
	
	
	
	/**
	 * Este método configura e executa o servidor.
	 */
	public void runServer() {
		
		try {
			
			server = new ServerSocket( SERVER_PORT, NUMBER_OF_ROWS ); // cria SocketServer.
			
			while ( true ) {
				
				try {
					
					waitForConnection(); // espera uma conexão.
					getStreams(); // obtém fluxos de entrada e saída.
					processConnection(); // precessa a conexão.
					
				} catch ( EOFException eofe ) {
					displayMessage( "\nA conexão do servidor terminou!\n" );
				} finally {
					closeConnection(); // fecha a conexão.
					counter++;
				}
			}
			
		} catch ( IOException ioe ) {
			ioe.printStackTrace();
		}
	}
	
	
	/**
	 * Este método espera que a conexão chegue e então exibe informações sobre a conexão.
	 * @throws IOException
	 */
	private void waitForConnection() throws IOException {
		
		displayMessage( "\nAguardando por uma conexão!\n" );
		connection = server.accept(); // permite que o servidor aceite a conexão.
		displayMessage( "Conexão " + counter + " recebida de " + 
				connection.getInetAddress().getHostName() );
		
	}
	
	
	/**
	 * Este método obtém fluxos para enviar e receber dados.
	 * @throws IOException
	 */
	private void getStreams() throws IOException {
		
		// configura o fluxo de saída para objetos.
		output = new ObjectOutputStream( connection.getOutputStream() );
		output.flush(); // esvazia buffer de saída para enviar as informações de cabeçalho.
		
		// configura o fluxo de entrada para objetos.
		input = new ObjectInputStream( connection.getInputStream() );
		
		displayMessage( "\nFluxos de entrada/saída inicializados e configurados.\n" );
		
	}
	
	
	/**
	 * Este método processa a conexão com o cliente.
	 * @throws IOException
	 */
	private void processConnection() throws IOException {
		
		String message = "Conexão efetuada com sucesso!\n";
		sendData( message ); // envia uma mensagem de conexão bem sucedida.
		
		// ativa enterField de modo que o usuário do servidor possa enviar mensagens.
		setTextFieldEditable( true );
		
		do { // processa as mensagens enviadas pelo cliente.
			
			try { // lê e exibe a mensagem.
				
				message = ( String ) input.readObject(); // lê uma nova mensagem.
				displayMessage( "\n" + message ); // exibe a mensagem.
				
			} catch ( ClassNotFoundException cnfe ) {
				displayMessage( "\nA mensagem não pode ser recebida" );
			} catch ( SocketException se ) {
				break;
			}
			
			
		} while ( !message.equals( "CLIENTE" + STRING_SEPARATOR + "TERMINATE" ) );
		
	}
	
	
	/**
	 * Este método fecha os fluxos e o socket.
	 */
	private void closeConnection() {

		displayMessage( "\nConexão encerrada!\n" );
		setTextFieldEditable( false );
		
		try {
			
			output.close(); // fecha o fluxo de saída.
			input.close(); // fecha o fluxo de entrada.
			connection.close(); // fecha o socket.
			
		} catch ( IOException ioe ) {
			ioe.printStackTrace();
		}
	}
	
	
	/**
	 * Este método envia a mensságem ao cliente.
	 * @param message String com a mensagem a ser enviada.
	 */
	private void sendData ( String message ) {
		
		try { // envia o objeto ao cliente.
			
			output.writeObject( "SERVER" + STRING_SEPARATOR + message );
			output.flush(); // esvazia a saída para o cliente.
			displayMessage( "\nSERVER" + STRING_SEPARATOR + message );
			
		} catch ( IOException ioe ) {
			displayArea.append( "\nErro ao processar a menssagem" );
		}
	}

	
	/**
	 * Este método manipula o displayArea na thread de despacho de eventos.
	 * @param message Menssagem a ser exibida.
	 */
	private void displayMessage( final String messageToDisplay ) {

		SwingUtilities.invokeLater(
				new Runnable() {

					public void run() { // atualiza o displayArea
						displayArea.append( messageToDisplay ); // acrescenta a mensagem.
					}
					
				}
		);

	}
	

	/**
	 * Este método o enterField na thread de despacho de eventos.
	 * @param editable Variável booleana.
	 */
	private void setTextFieldEditable( final boolean editable ) {

		SwingUtilities.invokeLater( 
				new Runnable() {

					public void run() {
						enterField.setEditable( editable );	// configura a editabilidade do enterField.
					}

				}
		);

	}
	
	
}
