import java.io.*;
import java.util.*;

public class ArquivoTextoEntrada {
    
    public static void main(String[] args) {
        
        File file = new File("arquivo2.txt");
        try {
            FileReader reader = new FileReader(file);
            BufferedReader input = new BufferedReader(reader);
            String line;
             while ((line = input.readLine()) != null) {
                StringTokenizer tokens = new StringTokenizer(line);
                while(tokens.hasMoreTokens()) {
                	System.out.println(tokens.nextToken());
                }
            }
            input.close();
        } catch (IOException ioe) {
            System.out.println(ioe);
        }
    }
}