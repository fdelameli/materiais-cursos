import java.io.*;

import javax.swing.*;

public class PostOrder {
	
	public void size(File file) {
		long tamanho = 0;
		tamanho += size(file, 0);
	}

	// Algoritmo PostOrder(T, v) - T pode ser ignorado, v = file
	// para cada filho w de v faça
	//		recursivamente percorra a sub-árvore com raiz em w, chamando PostOrder(T,w)
	// execute a ação prevista para o nodo v
	private long size (File file, int depth) {
		long a = 0;
		String tab = "";
		for (int i = 0; i < depth; i++) {
			tab+="    ";
		}
		if(file.isDirectory()){
			System.out.println(tab + file.getName() + " - " + a);
			depth++;
			File files[] = file.listFiles();
			for (int i = 0; i < files.length; i++) {
				File file2 = files[i];
				a += file2.length();
				size(file2, depth);
			}	
		}else{
			System.out.println(tab + file.getName() + " - " + file.length());
		}
		return a;
	}

	public static void main(String[] args) {
		PostOrder post = new PostOrder();
		JFileChooser fc = new JFileChooser();
		fc.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
		int ret = fc.showOpenDialog(null);
		if (ret == JFileChooser.APPROVE_OPTION) {
			post.size(fc.getSelectedFile());
		}
		else {
			JOptionPane.showMessageDialog(null, "Escolha um diretorio");
		}
	}
}