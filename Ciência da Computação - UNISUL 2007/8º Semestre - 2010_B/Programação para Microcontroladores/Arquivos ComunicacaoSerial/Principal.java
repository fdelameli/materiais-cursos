import java.util.Enumeration;
import gnu.io.CommPortIdentifier;
public class Principal{
	
	public static final int DELAY = 500;
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
		
		
		
	public static void escreveSerial() {
		try {
			//for( int i = 0; i < 10; i++ ) {
			while(true) {
				porta.envia("L");
				Thread.sleep(DELAY);
				porta.envia("D");
				Thread.sleep(DELAY);
			}
		} catch (Exception e) {
			
		}
	}
		
			
	public static void main(String []a){
		porta=new PortaSerial();
		listaPortas();
	
		try{
			porta.abre("COM1",1000);
			escreveSerial();
			System.exit(0);
		}catch(Exception e){
		
		}
	}
	
	

	
}
 
		

