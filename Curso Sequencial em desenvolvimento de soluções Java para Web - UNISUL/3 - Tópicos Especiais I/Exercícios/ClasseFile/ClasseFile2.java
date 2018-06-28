import java.io.*;

public class ClasseFile2 {
	
	public static void main(String[] args) {
		
		File arq2 = new File("/pasta", "arq2.txt");  
		System.out.println(arq2.exists());
		try {
			arq2.createNewFile();
		} catch (IOException ioe) {
			System.out.println(ioe);
		}
		System.out.println(arq2.exists());
		
		
		File d = new File("/pasta/pasta2");
		System.out.println(d.mkdirs());
		try {
			arq2.createNewFile();
		} catch (IOException ioe) {
			System.out.println(ioe);
		}
		System.out.println(arq2.exists());
		
		
		
		File arq3 = new File(d, "arq3.txt");
		System.out.println(arq3.exists());
		try {
			arq3.createNewFile();
		} catch (IOException ioe) {
			System.out.println(ioe);
		}
		System.out.println(arq3.exists());		
	
	
	}
	
}