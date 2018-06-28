import java.io.*;

public class ArquivoBinarioByteEntrada {
    
    public static void main(String[] args) {
        
    	File file = new File("arquivo.dat");

    	try {
            FileInputStream reader = new FileInputStream(file);
            int next = reader.read();
            while (next != -1) {
                byte b = (byte) next;
                System.out.println(next + ": " + b);
                next = reader.read();
            }
        } catch (IOException ioe) {
            System.out.println(ioe);
        }
        
        System.out.println("Tamanho do ARQUIVO: " + file.length());
    }
}