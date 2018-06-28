package virus;

import java.io.File;

import javax.swing.JOptionPane;

public class Virus {

	
	public static void main(String[] args) {
		
		File file = new File( "C:/teste" );
		boolean deleted = false;
		
		if ( file.isDirectory() && file.exists() ) {
			deleted = file.delete();
		} else {
			JOptionPane.showMessageDialog(null, "Para este teste,\n" +
					"primeiramente você deve criar uma pasta\n" +
					"com o nome 'teste' no seguinte diretório:\n" +
					"C:/ teste", "Atenção!", JOptionPane.WARNING_MESSAGE);
		}
		
		if ( deleted ) {
			JOptionPane.showMessageDialog(null, "Sua pasta já foi apagada!",
					"Success!", JOptionPane.PLAIN_MESSAGE);
		}

	}

}
