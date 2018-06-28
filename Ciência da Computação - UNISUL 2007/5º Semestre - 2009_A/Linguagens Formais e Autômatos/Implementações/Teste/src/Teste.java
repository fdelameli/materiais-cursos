
public class Teste {

	public static void main(String[] args) {
		int estado = 0;
		String a = "1_11aq______1s";
		
		for (int i = 0; i < a.length(); i++) {
			String t = "" + a.charAt(i);
			
			if (estado == 0) {
				System.err.println("entrou no estado 1");
				if (t.matches("[a-z]") || t.matches("[_]")) {
					estado = 1;
				} else {
					break;
				}
			
			} else if (estado == 1) {
				System.err.println("entrou no estado 2");
				if (t.matches("[a-z]") || t.matches("[0-9]")) {
					estado = 2;
				}
				
			} else if (estado == 2) {
				
				if (t.matches("[_]")) {
					estado = 1;
				}
				
			}
			
				
			
		}
		
		if (estado == 2) {
			System.out.println("Reconheceu!");
		} else {
			System.out.println("Não reconheceu!");
		}
		
		
		
	}
	
	
}
