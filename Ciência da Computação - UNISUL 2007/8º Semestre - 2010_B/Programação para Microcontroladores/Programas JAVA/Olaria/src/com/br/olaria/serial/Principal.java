package com.br.olaria.serial;
import java.util.Enumeration;

import javax.swing.JOptionPane;

import gnu.io.CommPortIdentifier;

public class Principal {

	public static PortaSerial porta = null;

	public static void listaPortas() {

		Enumeration<?> pList = porta.getListaPorta();
		while ( pList.hasMoreElements() ) {
			CommPortIdentifier cpi = ( CommPortIdentifier ) pList.nextElement();
			if ( cpi.getPortType() == CommPortIdentifier.PORT_SERIAL ) {
				System.out.println( cpi.getName() );
			}
		}
	}

	public static void escreveSerial( String str ) {
		try {
			porta.envia( str );
		} catch ( Exception e ) {

		}
	}

	public static void leSerial() {
		try {
			System.out.println( porta.recebe() );
		} catch ( Exception e ) {
			e.printStackTrace();
		}
	}

	public static void main( String[] a ) {
		porta = new PortaSerial();
		listaPortas();

		try {
			porta.abre( "COM4", 1000 );
			while ( true ) {
				escreveSerial( JOptionPane.showInputDialog( "Digite............." ) );
				leSerial();
			}
		} catch ( Exception e ) {
			e.printStackTrace();
		}
	}

}
