import java.util.Enumeration;
import gnu.io.CommPortIdentifier;
import javax.swing.*;
public class Principal{
	public static PortaSerial porta = null;
	
	public static void listaPortas(){
			Enumeration pList = porta.getListaPorta();			
		    while (pList.hasMoreElements()) {
		        CommPortIdentifier cpi = (CommPortIdentifier)pList.nextElement();
		        if (cpi.getPortType() == CommPortIdentifier.PORT_SERIAL) {
		            System.out.println(cpi.getName());
		        }
    		}
	}  
	public static void escreveSerial(){
		try{
			String str="";	
			while(true){				
				str=JOptionPane.showInputDialog(null,"Insira o comando");
				porta.envia(str);	
			}	
		}catch(Exception e){
			
		}
	}	  			
	public static void main(String []a){
		 porta=new PortaSerial();
		listaPortas();
	
		try{
			porta.abre("COM1",1000);
			escreveSerial();
		}catch(Exception e){
		
		}
	}
	
}
 
		

