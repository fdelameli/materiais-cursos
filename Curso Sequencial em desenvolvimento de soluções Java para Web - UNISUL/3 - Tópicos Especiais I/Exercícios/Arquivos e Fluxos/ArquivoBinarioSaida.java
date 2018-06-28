import java.io.*;

public class ArquivoBinarioSaida {
    
    public static void main(String[] args) {
        
    	File file = new File("arquivo2.dat");
    	
    	System.out.println("Tamanho Inicial: " + file.length());
    	try {
            FileOutputStream writer = new FileOutputStream(file);
            DataOutputStream output = new DataOutputStream(writer);
            output.writeDouble(39.3);
            output.writeBoolean(true);
            output.writeInt(10000);
            output.flush();
            output.close();
        } catch (IOException ioe) {
            System.out.println(ioe);
        }
        System.out.println("Tamanho Final: " + file.length());
    }
}