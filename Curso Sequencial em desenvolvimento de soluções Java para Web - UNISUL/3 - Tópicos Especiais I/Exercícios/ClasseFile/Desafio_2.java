import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;


public class Desafio_2 {

	public static void main(String[] args) {


		File file = new File( "D:/Install Games" );
		String total = "";
		File files[] = file.listFiles();
		for (int i = 0; i < files.length; i++) {
			File f = files[i];
			String result = "";
			result += (f.isDirectory() ? "Diretório" : "Arquivo");
			result += "  ---  " + f.getName();
			result += "  ---  " + f.getAbsolutePath();
			result += "  ---  " + f.getParent();
			result += "  ---  " + getData(f.lastModified());
			result += "  ---  " + f.length();
			//System.out.println( result );
			//JOptionPane.showMessageDialog(null, result );
			total += result + "\n";
		}

		JOptionPane.showMessageDialog(null, total);


	}

	public static String getData(long v) {
		Date data = new Date(v);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		return sdf.format(data);
	}

}
