import java.io.*;
import javax.swing.*;

public class ClasseEscolherArquivo {

	public static void main(String[] args) {
		JFileChooser chooser = new JFileChooser();
		chooser.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
		File file = null;
		if (chooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
			file = chooser.getSelectedFile();
			JOptionPane.showMessageDialog(chooser, file.getAbsolutePath());
		}

	}

}