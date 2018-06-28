package multiprogramavel;


public class Principal {

	public static void main(String[] args) {
		
		String pro01 = new String("PROGRAMA01");
		String pro02 = new String("PROGRAMA02");
		String pro03 = new String("PROGRAMA03");
		String pro04 = new String("PROGRAMA04");
		String pro05 = new String("PROGRAMA05");
		String pro06 = new String("PROGRAMA06");
		String pro07 = new String("PROGRAMA07");
		
		Gerenciador ger = new Gerenciador();
		
		ger.enqueue(pro01);
		ger.enqueue(pro02);
		ger.enqueue(pro03);
		ger.enqueue(pro04);
		ger.enqueue(pro05);
		ger.enqueue(pro06);
		ger.enqueue(pro07);
		
		ger.executaProcesso();
	}

}
