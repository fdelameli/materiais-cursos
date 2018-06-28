package br.unisul.rodrigo.tests;

import java.awt.HeadlessException;
import java.io.IOException;

import javax.swing.JOptionPane;

import br.unisul.rodrigo.login.VerificaLogin;

public class Teste {
	
	public static void main(String[] args) {
		
		VerificaLogin vl = new VerificaLogin();
		
		try {
			JOptionPane.showMessageDialog(null, "User: " + vl.getUserProperties() +
					"\nPassword: " + vl.getPasswordProperties());
		} catch (HeadlessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
}
