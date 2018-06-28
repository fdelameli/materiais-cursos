
public class ExemploExcecao1 {

	public static void main(String[] args) {
		String nome = new String ("Programação para Computação II");
		System.out.println(nome.charAt(10));
		nome = null;
		System.out.println(nome.charAt(10));
	}
}
