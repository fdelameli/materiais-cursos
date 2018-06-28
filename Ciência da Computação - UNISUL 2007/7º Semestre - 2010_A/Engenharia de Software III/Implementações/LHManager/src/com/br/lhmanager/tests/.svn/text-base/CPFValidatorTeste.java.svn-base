package com.br.lhmanager.tests;

import com.br.lhmanager.util.CPFValidator;

import junit.framework.Test;
import junit.framework.TestCase;


public class CPFValidatorTeste extends TestCase implements Test {

	String[] cpfs = {"070.071.939-35", "044.113.237-53", "523.523.654-99", "743.643.765-97" };
	
	@Override
	protected void setUp() throws Exception {
		System.out.println("Iniciando...");
	}
	
	
	public void testValidaCpf() {
		
		
		
		for ( int i = 0; i < cpfs.length; i++ ) {
			assertEquals( true, CPFValidator.validaCpf( cpfs[i] ) );
			System.out.println(i);
		}
//    	assertEquals( "Validação de CPF", true, CPFValidator.validaCpf( "070.071.939-35" ) );
//		assertEquals( true, CPFValidator.validaCpf( "523.523.654-99" ) );
	}

	
	@Override
	protected void tearDown() throws Exception {
		System.out.println("Finalizado!");
	}
	
	
}
