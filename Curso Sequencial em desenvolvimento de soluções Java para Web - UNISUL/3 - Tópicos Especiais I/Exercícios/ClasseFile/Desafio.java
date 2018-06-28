import java.io.File;
import java.io.IOException;

import javax.naming.directory.DirContext;


public class Desafio {

	public static void main(String[] args) {
		
		File d = new File( "pasta1" );
		
		System.out.println( d.mkdir() );
		
		File arq = new File( d, "arquivo.txt" );
		
		try {
			System.out.println( arq.createNewFile() );
			System.out.println( arq.exists() );
			System.out.println( arq.delete() );
			System.out.println( d.delete() );
		} catch (IOException ioe) {
			System.out.println( ioe.getMessage() );
		}
		
	}
}
