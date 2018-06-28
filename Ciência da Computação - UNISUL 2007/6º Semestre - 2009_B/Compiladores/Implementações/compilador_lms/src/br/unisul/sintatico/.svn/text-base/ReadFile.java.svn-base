package br.unisul.sintatico;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.StringTokenizer;



public class ReadFile {

	private File file;

	public ReadFile(File file) {
		super();
		this.file = file;
	}

	public ReadFile() {
		this(null);
	}
	
	public String [][] toArray(int linhas, int colunas, File file){
		String[][] sn = new String[linhas][colunas];
		try {
			BufferedReader reader = new BufferedReader(new FileReader(file));
			for (int i = 0; i < linhas; i++) {
				String linha = reader.readLine();
				StringTokenizer st = new StringTokenizer(linha);
				int j = 0;
			    while (st.hasMoreTokens()) {
			    	 sn[i][j] = st.nextToken();
			         j++;
			     }
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return sn;
	}
	


	public File getFile() {
		return file;
	}

	public void setFile(File file) {
		this.file = file;
	}
	

}
