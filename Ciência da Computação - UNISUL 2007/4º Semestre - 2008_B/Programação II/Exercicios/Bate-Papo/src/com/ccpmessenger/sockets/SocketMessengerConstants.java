package com.ccpmessenger.sockets;


/**
 * SocketMessengerConstants define as constantes para os números
 * da porta e o endereço de multcast em CCPMessenger.
 * 
 * @author Fabio Dela Bruna
 *
 */
public interface SocketMessengerConstants {

	
	/**
	 * Endereço para datagramas de multicast.
	 */
	public static final String MULTCAST_ADDRESS = "239.0.0.1";
	
	/**
	 * Porta para ouvir datagramas de multicast.
	 */
	public static final int MULTICAST_LISTENING_PORT = 5555;
	
	/**
	 * Porta para enviar datagramas de multicast.
	 */
	public static final int MULTICAST_SENDING_PORT = 5554;
	
	/**
	 * Porta para conexões de Socket com o CCPMessengerServer.
	 */
	public static final int SERVER_PORT = 12345;
	
	/**
	 * String que indica desconexão.
	 */
	public static final String DISCONNECT_STRING = "DISCONNECT";
	
	/**
	 * String que separa o nome de usuário do corpo da mensagem.
	 */
	public static final String MESSAGE_SEPARATOR = ">>>";
	
	/**
	 * Tamanho da mensagem (em bytes).
	 */
	public static final int MESSAGE_SIZE = 512;
	
	
}
