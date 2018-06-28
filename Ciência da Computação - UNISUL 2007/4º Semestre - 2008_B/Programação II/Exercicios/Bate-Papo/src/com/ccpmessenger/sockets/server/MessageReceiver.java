package com.ccpmessenger.sockets.server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.net.SocketTimeoutException;
import java.util.StringTokenizer;

import com.ccpmessenger.MessageListener;
import static com.ccpmessenger.sockets.SocketMessengerConstants.*;


/**
 * MessageReceiver é um executável que recebe mensagens a partir de um
 * cliente particuar e envia mensagens para um MessageListener.
 * @author Fabio Dela Bruna
 *
 */
public class MessageReceiver implements Runnable {

	private BufferedReader input; // fluxo de entrada.
	private MessageListener messageListener; // receptor da mensagem.
	private boolean keepListening = true; // quando false, termina o executável.
	
	
	/**
	 * Construtor de MessageReceiver.
	 */
	public MessageReceiver( MessageListener listener, Socket clientSocket ) {
		// configura o receptor ao qual novas mensagens devem ser enviadas.
		messageListener = listener;
		
		try {
			// configura o tempo-limite para leitura do cliente.
			clientSocket.setSoTimeout( 5000 ); // cinco segundos.
			
			// cria BufferedReader para ler mensagens entrantes.
			input = new BufferedReader( new InputStreamReader(
					clientSocket.getInputStream() ) );
			
		} catch ( IOException ioe ) {
			ioe.printStackTrace();
		}
		
	}
	
	
	/**
	 * Este método recebe novas mensagens e as envia para o MessageListener.
	 */
	public void run() {
		
		String message; // String para mensagens entrantes.
		
		// recebe mensagens até ser parado.
		while ( keepListening ) {
			
			try {
				
				message = input.readLine(); // lê a mensagem do cliente.
				
			} catch ( SocketTimeoutException stoe ) {
				continue; // continua para a próxima iteração para se manter receptor.
				
			} catch ( IOException ioe ) {
				ioe.printStackTrace();
				break;
			}
			
			// assegura que a mensagem não seja nula.
			if ( message != null ) {
				
				// divide a mensagem em tokens para recuperar o nome de usuário e o corpo da mensagem.
				StringTokenizer tokenizer = new StringTokenizer(
						message, MESSAGE_SEPARATOR );
				
				// ignora as mensagens que não contém um nome de usuário e um corpo de mensagem.
				if ( tokenizer.countTokens() == 2 ) {
					
					// envia a menssagem para MessageListener.
					messageListener.messageReceived(
							tokenizer.nextToken(), // nome de usuário.
							tokenizer.nextToken() ); // corpo da mensagem.
					
				} else {

					// se recebeu mensagem de desconexão, para de receber mensagens.
					if ( message.equalsIgnoreCase(
							MESSAGE_SEPARATOR + DISCONNECT_STRING ) )
						stopListening();

				}

			}
			
		}
		
		try {
			
			input.close(); // fecha o BefferedReader (também fecha o socket).
			
		} catch ( IOException ioe ) {
			ioe.printStackTrace();
		}
		
	}
	

	/**
	 * Este método faz com que para de receber as mensagens entrantes.
	 */
	public void stopListening() {
		keepListening = false;
	}
	

}
