import java.io.*;

public class ArquivoBinarioByteSaida {
    
    public static void main(String[] args) {
        
    	File file = new File("arquivo.dat");
    	
    	System.out.println("Tamanho Incial: " + file.length());
    	try {
            FileOutputStream writer = new FileOutputStream(file);
            writer.write('S');
            writer.write('e');
            writer.write('q');
            writer.write(13);
            writer.write('u');
            writer.write('e');
            writer.write('n');
            writer.write('c');
            writer.write('i');
            writer.write('a');
            writer.write('l');
            writer.flush();
            writer.close();
        } catch(IOException ioe) {
            System.out.println(ioe);
        }
        System.out.println("Tamanho Final: " + file.length());
   }
}