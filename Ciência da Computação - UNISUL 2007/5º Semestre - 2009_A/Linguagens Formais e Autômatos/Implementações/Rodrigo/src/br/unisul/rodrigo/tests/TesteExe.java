package br.unisul.rodrigo.tests;

import java.io.IOException;

public class TesteExe {

	public static void main(String[] args) {
		
		try {
			Runtime.getRuntime().exec("C:/notepad.exe");
//			Runtime.getRuntime().exec("cmd /c C:/del_temp.bat"); 
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}  


		
	}
}
