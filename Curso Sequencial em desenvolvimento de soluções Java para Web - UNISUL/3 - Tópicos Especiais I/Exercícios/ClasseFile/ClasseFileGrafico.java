import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JFileChooser;

public class ClasseFileGrafico {
	
	public static void main(String[] args) {
		File file = escolhaArquivo();
		if (file != null) {
			File files[] = file.listFiles();
			for (int i = 0; i < files.length; i++) {
				File f = files[i];
				String temp = (f.isFile() ? "arquivo  " : "diretorio");
				temp += "\t" + f.length();
				//temp += "\t" + f.getAbsolutePath();
				temp += "\t" + dataCorrespondente(f.lastModified());
				temp += "\t" + f.getName();
				System.out.println(temp);
			}
		}
	}
	
	public static String dataCorrespondente(long v) {
		Date data = new Date(v);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		return sdf.format(data);
	}
	
	public static File escolhaArquivo() {
		JFileChooser chooser = new JFileChooser();
		chooser.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
		File file = null;
		if (chooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
			file = chooser.getSelectedFile();
			return file;
		}
		return null;
	}
}


