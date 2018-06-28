
public class PrincipalCaixa {

	public static void main(String[] args) {


		CaixaG<String> caixa = new CaixaG<String>();

		caixa.add(new String("POO"));

		String palavra = caixa.get();
	
	System.out.println(palavra);
	}
}
