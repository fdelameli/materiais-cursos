import java.io.*;

public class ClasseFile3 {
	
	public static void main(String[] args) {
		File file = new File("C:/Sequencial Java");
		file.mkdir();
		System.out.println(file.exists());
		System.out.println(file.getAbsolutePath());
		System.out.println(file.getParent());
		System.out.println(file.isDirectory());
		System.out.println(file.isFile());
		System.out.println(file.length());
		File[] arquivos = file.listFiles();
		for (int i = 0; i < arquivos.length; i++) {
			System.out.println(arquivos[i].getAbsolutePath()); 
		}		
	}
}