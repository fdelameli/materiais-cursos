package com.br.lhmanager.tests;


public class TesteValoresDouble {

	public static void main( String[] args ) {

		double v = 2.3;
		System.out.println(String.format( "%.2f", v ));
		
		int v2 = 10;
		System.out.println(String.format( "%05d", v2 ));
		
//		try {
//			String valor = "20,12";
//			double valorConvertido = 0.0;
//
//			System.out.println( valor.replaceAll( ",", "." ) );
//
//			valorConvertido = Double.parseDouble( valor.replaceAll( ",", "." ) );
//
//			System.out.println( "\n\n" );
//			System.out.println( valorConvertido );
//		} catch ( NumberFormatException e ) {
//
//		}
	}

}
