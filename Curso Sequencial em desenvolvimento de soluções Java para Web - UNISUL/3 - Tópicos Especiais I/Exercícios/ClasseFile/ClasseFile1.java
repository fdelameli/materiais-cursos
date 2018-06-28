import java.io.*;

public class ClasseFile1 {
	
	public static void main(String[] args) {
		File arq1 = new File("arq1.txt");
		
		System.out.println(arq1.exists());
		
		try {
			System.out.println(arq1.createNewFile());
			System.out.println(arq1.getName());
			System.out.println(arq1.getAbsolutePath());
			System.out.println(arq1.delete());

		} catch (IOException ioe) {
			System.out.println(ioe);
		}
		System.out.println(arq1.exists());
	}

}