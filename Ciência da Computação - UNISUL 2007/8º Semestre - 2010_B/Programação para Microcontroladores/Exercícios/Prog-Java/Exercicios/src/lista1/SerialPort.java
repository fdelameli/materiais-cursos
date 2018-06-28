package lista1;


import gnu.io.CommPortIdentifier;
import gnu.io.NoSuchPortException;
import gnu.io.PortInUseException;
import gnu.io.SerialPort;
import gnu.io.UnsupportedCommOperationException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.util.Enumeration;
import java.util.zip.ZipFile;


public class SerialPort {

	private SerialPort porta;
	private BufferedReader in;
	private PrintStream out;

	public static final int VELOCIDADE_PADRAO = 9600;
	public static final int BITS_DADOS_PADRAO = SerialPort.DATABITS_8;
	public static final int BITS_PARADA_PADRAO = SerialPort.STOPBITS_1;
	public static final int PARIDADE_PADRAO = SerialPort.PARITY_NONE;
	public static final int TIMEOUT_PADRAO = 500;

	public static final String PORTA_PADRAO_WINDOWS = "COM1";
	public static final String PORTA_PADRAO_LINUX = "/dev/ttyS0";

	public SerialPort() {
		String osname = System.getProperty( "os.name" );
		String nomePorta;
		if ( osname.startsWith( "Windows" ) ) {
			nomePorta = PORTA_PADRAO_WINDOWS;
		} else {
			nomePorta = PORTA_PADRAO_LINUX;
		}

	}

	public SerialPort( String nomePorta ) {
		abre( nomePorta );
	}

	public Enumeration getListaPorta() {
		return CommPortIdentifier.getPortIdentifiers();

	}


	public SerialPort( String nomePorta, int timeout ) {
		abre( nomePorta, VELOCIDADE_PADRAO, timeout );
	}

	public void abre( String porta, int timeout ) {
		abre( porta, VELOCIDADE_PADRAO, timeout );
	}

	public SerialPort( String nomePorta, int velocidade, int timeout ) {
		abre( nomePorta, velocidade, timeout );
	}

	public synchronized String recebe() {
		try {
			return in.readLine();
		} catch ( IOException ex ) {
			return "";
		}
	}

	public synchronized String recebe( int qtd ) {
		try {
			char[] buf = new char[ qtd ];
			int len = in.read( buf );
			return new String( buf, 0, len );
		} catch ( IOException ex ) {
			return "";
		}
	}

	public synchronized void envia( char c ) {
		out.print( c );
	}

	public synchronized void envia( String dados ) {
		out.print( dados );
	}

	private void abre( String nomePorta ) {
		abre( nomePorta, VELOCIDADE_PADRAO, TIMEOUT_PADRAO );
	}


	private void abre( String nomePorta, int velocidade, int timeout ) {
		try {
			porta =	( SerialPort ) CommPortIdentifier.getPortIdentifier( 
						nomePorta ).open( "conexaoSerial",timeout );
			setParametros( velocidade, BITS_DADOS_PADRAO, BITS_PARADA_PADRAO,PARIDADE_PADRAO );
			porta.setFlowControlMode( SerialPort.FLOWCONTROL_NONE );
			in = new BufferedReader( new InputStreamReader( porta.getInputStream() ) );
			out = new PrintStream( porta.getOutputStream() );
		} catch ( UnsupportedCommOperationException ex ) {
			System.out.println( "Opera��o na porta n�o suportada" );
		} catch ( PortInUseException e ) {
			System.out.println( "A porta " + nomePorta + " est� em uso" );
		} catch ( NoSuchPortException e ) {
			System.out.println( "Porta n�o encontrada" );
		} catch ( IOException e ) {
			System.out.println( "Problema na comunica��o" );
		}
	}

	public void fecha() {
		try {
			if ( in != null ) {
				in.close();
			}
			if ( out != null ) {
				out.close();
			}
			if ( porta != null ) {
				porta.close();
			}
		} catch ( IOException e ) {
			System.out.println( "Erro ao fechar porta" );
		}
	}

	public void setParametros( int velocidade, int dados, int parada,
							int paridade ) {
		try {
			porta.setSerialPortParams( velocidade, dados, parada, paridade );
		} catch ( UnsupportedCommOperationException e ) {
			System.out.println( "Opera��o n�o suportada" );
		}
	}

	@Override
	public void finalize() throws Throwable {
		fecha();
	}


}
