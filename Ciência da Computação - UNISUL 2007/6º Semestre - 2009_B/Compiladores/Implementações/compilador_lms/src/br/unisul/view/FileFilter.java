package br.unisul.view;
import java.io.File;

/**
 * Classe para Filtrar apenas arquivos com a extensão .lms
 * @author Fabio Dela Bruna, Márcio Ozório Teixeira
 */
public class FileFilter extends javax.swing.filechooser.FileFilter {

	
	public boolean accept( File f ) {
		//se for diretório
		if ( f.isDirectory() ) 
			return true;

		//Retorna a extensão do arquivo
		String extension = getExtension( f );

		//verifica se a extensão é igual a lms
		if ( extension.equals( "lms" ) )
			return true; 

		return false;
	}

	/**
	 * Retorna a descrição do arquivo.
	 */
	public String getDescription() {
		return "*.lms";
	}

	/**
	 * Retorna a extensão do arquivo.
	 */
	private String getExtension( File f ) {
		String s = f.getName();
		int i = s.lastIndexOf( '.' );
		if ( i > 0 &&  i < s.length() - 1 ) 
			return s.substring( i + 1 ).toLowerCase();
		return "";
	}
}