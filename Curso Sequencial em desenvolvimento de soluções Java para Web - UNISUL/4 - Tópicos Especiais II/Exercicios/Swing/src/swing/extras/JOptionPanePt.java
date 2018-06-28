package swing.extras;

import java.util.Locale;

import javax.swing.JOptionPane;
import javax.swing.UIManager;

public class JOptionPanePt {

	public static void main(String[] args) {
		//Exemplo 1
        //Para vários países basta a linha abaixo, mas para pt_BR não tem
		Locale.setDefault(Locale.GERMAN);
		JOptionPane.showConfirmDialog(null, "Olá. Botões e título em Alemão!!!");

		//Exemplo 2
		UIManager.put("OptionPane.yesButtonText", "Sim");
		UIManager.put("OptionPane.noButtonText", "Não");
		UIManager.put("OptionPane.cancelButtonText", "Cancelar");
		//--
		JOptionPane.showConfirmDialog(null, "Olá. Botões em português!!!");
		//--
		JOptionPane.showConfirmDialog(null, "Olá. Botões e título em português!!!", "Selecione uma opção", JOptionPane.YES_NO_CANCEL_OPTION);
		
		
		//Exemplo 3
		String [] botoes = {"Sim", "Não", "Cancelar"};   
		//--  
        JOptionPane.showOptionDialog(null, "Olá. Botões em português com OptionDialog.", "Botões em Português",    
                JOptionPane.YES_OPTION, JOptionPane.ERROR_MESSAGE,    
                null, botoes, null);   

	}
}
