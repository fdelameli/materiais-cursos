import java.io.*;
import javax.swing.*;

public class PreOrder {

	public void list(File file) {
		list(file, 0);
	}

	// Algoritmo PreOrder(T, v) - T pode ser ignorado, v = file
	// execute a ação prevista para o nodo v
	// para cada filho w de v faça
	//		recursivamente percorra a sub-árvore com raiz em w chamando PreOrder(T, w)
	private void list(File file, int depth){
		String tab = "";
		for (int i = 0; i < depth; i++) {
			tab+="    ";
		}
		if (file.isDirectory()){
			System.out.println(tab + "-" + file.getName());
			depth++;
			File files[] = file.listFiles();
			for (int i = 0; i < files.length; i++) {
				File file2 = files[i];
				list(file2, depth);
			}
		}else{
			System.out.println(tab + file.getName());
		}
	}

	public static void main(String[] args) {
		PreOrder pre = new PreOrder();
		JFileChooser fc = new JFileChooser();
		fc.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
		int ret = fc.showOpenDialog(null);
		if (ret == JFileChooser.APPROVE_OPTION) {
			pre.list(fc.getSelectedFile());
		}
		else {
			JOptionPane.showMessageDialog(null, "Escolha um diretorio");
		}
	}
}