import java.io.*;

public class ArquivoBinarioEntrada {
    
    public static void main(String[] args) {
        
    	File file = new File("arquivo2.dat");
        
        try {
            FileInputStream reader = new FileInputStream(file);
            DataInputStream input = new DataInputStream(reader);
            double d = input.readDouble();
            System.out.println(d);
            boolean b = input.readBoolean();
            System.out.println(b);
            int i = input.readInt();
            System.out.println(i);
            input.close();
        } catch (EOFException eofe) {
        	System.out.println("Final do arquivo");
        } catch (IOException ioe) {
            System.out.println(ioe);
        }
    }
}