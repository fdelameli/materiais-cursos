import java.io.File;
/**
Classe para Filtrar apenas arquivos com a extensão .pas
@ Rogério Cortina
*/
public class FileFilter extends javax.swing.filechooser.FileFilter 
{
  
  public boolean accept(File f) 
  {
    //se for diretório
    
    if (f.isDirectory()) 
      return true;
  
    //Retorna a extensão do arquivo

    String extension = getExtension(f);
    //verifica se a extensão é igual a pas
    if (extension.equals("pas"))
       return true; 
    
    return false;
  }
    
  public String getDescription() 
  {
      return "*.pas";
  }

  private String getExtension(File f) 
  {
    String s = f.getName();
    int i = s.lastIndexOf('.');
    if (i > 0 &&  i < s.length() - 1) 
      return s.substring(i+1).toLowerCase();
    return "";
  }
}