import javax.swing.JOptionPane;


public class desafio4 {
	
	public static void main(String[] args) {
		String abc = "ABCDEFGHIJKLMNOPQRSTUVXZ";
		String tempStr = "";
		
		int valorChaver = -1;
		do{
			valorChaver = Integer.parseInt(JOptionPane.showInputDialog("Informe a chave"));
		}while(valorChaver < 0 || valorChaver > 26);
		
		String entrada = JOptionPane.showInputDialog("informe a entrada").toUpperCase();
		for (int i = 0; i < entrada.length(); i++) {
			char temp = entrada.charAt(i);
			int posicao = -1;
			for (int j = 0; j < abc.length(); j++) {
				if(abc.charAt(j) == temp){
					posicao = j;
				}
			}
			if(posicao >= 0){
				
				int v = posicao - valorChaver;
				if(v >= 0){
//					tempStr += abc.charAt(v);
				}else{
					v = abc.length() + v;
				}
//				v = v % abc.length(); 
				tempStr += abc.charAt(v);
//				tempStr += abc.charAt((abc.length())% abc.length());
			}else{
				tempStr += temp;
			}
		}
		
		JOptionPane.showMessageDialog(null, tempStr);
	}	

}
