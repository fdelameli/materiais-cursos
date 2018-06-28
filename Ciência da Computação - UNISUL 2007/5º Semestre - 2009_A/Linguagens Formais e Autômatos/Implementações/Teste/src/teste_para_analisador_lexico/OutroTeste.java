package teste_para_analisador_lexico;

public class OutroTeste {

	public static void main(String[] args) {
		
		String teste2 = "__";
		
		if (teste2.matches(
				"(" +
				"([_]*|[a-z])" + //começo: qualquer quantidade de underscore ou uma letra.
				"(\\d|[a-z]|[_])*" + //meio: qualquer quatidade de dígitos, letras ou underscore.
				"(\\d|[a-z])+)" + //fim: pelo menos um dígito ou letra.
				
				"|" + // ou
				
				"([+]{0,1}|[-])" + //começo: ter o sinal [-], ou [+], ou nenhum.
				"(\\d+" + //meio: pelo menos um dígito.
				"|" + // ou
				"\\d+[.]\\d+(\\d+|[E]" + //meio: pelo menos um dígito, seguido de um [.], seguido de pelo menos um dígito, seguindo do sinal de expoente[E].
				"([+]{0,1}|[-])\\d+)" + // fim: termina com um dígito, com ou sem sinal.
				")"
			)) {
			System.out.println("OK");
		} else {
			System.out.println("Shit!");
		}
	
// "(([_]*|[a-z])(\\d|[a-z]|[_])*(\\d|[a-z])+)|([+]{0,1}|[-])\\d+(\\d*|\\d*[.]\\d+(\\d*|[E]([+]{0,1}|[-])\\d+))"
	}
}
