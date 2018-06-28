package com.ccpmessenger.sockets.server;

import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import com.ccpmessenger.MessageListener;
import static com.ccpmessenger.sockets.SocketMessengerConstants.*;

/**
 * CCPMessengerServer é um servidor de bate-papo com múltiplas threads,
 * baseado em com.deitel.messenger.sockets.server.DeitelMessengerServer.
 * @author Fabio Dela Bruna
 *
 */
public class CCPMessengerServer implements MessageListener {

	private ExecutorService serverExecutor; // executor para o servidor.
	
	
	/**
	 * Este método inicia o servidor de bate-papo.
	 */
	public void startServer() {
		// cria o executor para executáveis de servidor.
		serverExecutor = Executors.newCachedThreadPool();
		
		// cria o servidor e gerencia novos clientes.
		try {
			
			// cria ServerSocket para conexões entrantes.
			ServerSocket serverSocket = new ServerSocket( SERVER_PORT, 100 );
			
			System.out.printf( "%s%d%s" , "Servidor pronto para conexões na porta ",
					SERVER_PORT, "..." );
			
			// recebe conexões constantemente.
			while ( true ) {
				// aceita nova conexão de cliente.
				Socket clientSocket = serverSocket.accept();
				
				// cria MessageReceiver para receber mensagens do cliente.
				
			}
			
		}
		
		
	}


	public void messageReceived(String from, String message) {
		// TODO Auto-generated method stub
		
	}
}
