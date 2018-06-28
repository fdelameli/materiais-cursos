package classestring;
import javax.swing.JOptionPane;

public class Compareto {

	static String palavra,palavra1;
	static int valor;
	
	public static void main(String[] args) {
			
				palavra = JOptionPane.showInputDialog(null,"Digite uma palavra: "); 
				palavra1 = JOptionPane.showInputDialog(null,"Digite outra palavra: ");
				valor = (palavra.compareTo(palavra1));
				
				if (valor == 0){
					JOptionPane.showMessageDialog(null, "Palavras Alfabeticamente Iguais");
				}else{
					if (valor < 0){
						JOptionPane.showMessageDialog(null, "Primeira palavra digitada é alfabeticamente maior!");
					}else{
						JOptionPane.showMessageDialog(null, "Ultima palavra digitada é alfabeticamente maior!");
					}
						
				}
				
			

			}


	}


