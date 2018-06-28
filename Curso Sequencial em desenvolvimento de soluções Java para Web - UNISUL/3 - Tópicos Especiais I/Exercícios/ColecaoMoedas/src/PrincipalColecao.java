import java.util.Scanner;

/**
 * Classe principal onde é efetuado os testes do programa.
 * @author Fabio Dela Bruna / Carlos Sá
 * @since 20/08/2008.
 */
public class PrincipalColecao {

	private static Scanner entrada = new Scanner(System.in);
	private static PersistenciaColecao colecao = new ColecaoSequencial("arquivo.seq");

	public static void main(String[] args) {
		System.out.println("BEM VINDO AO SISTEMA DE CONTROLE E CADASTRO DE MOEDAS");
		int opcao = menu();
		while (opcao != 0) {
			switch (opcao) {
				case 1: {
					inserirMoeda();
					break;
				}
				case 2: {
					consultarMoeda();
					break;
				}
				case 3: {
					alterarMoeda();
					break;
				}
				case 4: {
					removerMoeda();
					break;
				}
				case 5: {
					listarMoedas();
					break;
				}
			}
			opcao = menu();
		}
		System.out.println("MUITO OBRIGADO POR UTILIZAR O SISTEMA CONTROLE E DE CADASTRO DE MOEDAS");
	}

	private static int menu() {
		String menu = "|1| - Para inserir uma moeda"
		+ "\n|2| - Para consultar uma moeda"
		+ "\n|3| - Para alterar uma moeda"
		+ "\n|4| - Para remover uma moeda"
		+ "\n|5| - Para listar as moedas"
		+ "\n|0| - Para sair do sistema"
		+ "\nDigite sua opção....: ";
		int opcao;
		do {
			System.out.print(menu);
			opcao = entrada.nextInt();
		} while (opcao < 0 || opcao > 5);
		return opcao;
	}

	
	// métodos principais
	
	private static void inserirMoeda() {
		int codigo = leiaCodigo(entrada);
		String nome = leiaNome(entrada);
		String nacionalidade = leiaNacionalidade(entrada);
		int anoCunhagem = leiaAnoCunhagem(entrada);
		double valor = leiaValor(entrada);
		int quantidade = leiaQuantidade(entrada);

		Moeda moeda = new Moeda(codigo, nome, nacionalidade, anoCunhagem, valor, quantidade);
		
		if (colecao.inserirMoeda(moeda)) {
			System.out.println("Moeda inserida com sucesso");
		} else {
			System.out.println("Não foi possível inserir a moeda");
		}
	}

	public static void consultarMoeda() {
		int codigo = leiaCodigo(entrada);

		Moeda moeda = colecao.consultarMoeda(codigo);
		
		if (moeda != null) {
			System.out.println("Moeda encontrata com sucesso: " + moeda);
		} else {
			System.out.println("Moeda não encontra com este código: " + codigo);
		}
	}

	public static void removerMoeda() {
		int codigo = leiaCodigo(entrada);

		if (colecao.removerMoeda(codigo)) {
			System.out.println("Moeda removida com sucesso");
		} else {
			System.out.println("Moeda não encontra com este código: " + codigo);
		}
	}

	public static void alterarMoeda() {
		int codigo = leiaCodigo(entrada);
		String nome = leiaNome(entrada);
		String nacionalidade = leiaNacionalidade(entrada);
		int anoCunhagem = leiaAnoCunhagem(entrada);
		double valor = leiaValor(entrada);
		int quantidade = leiaQuantidade(entrada);

		Moeda moeda = new Moeda(codigo, nome, nacionalidade, anoCunhagem, valor, quantidade);

		if(colecao.alterarMoeda(moeda)) {
			System.out.println("Moeda alterada com sucesso");
		} else {
			System.out.println("Moeda não encontra com este código: " + codigo);
		}
	}

	public static void listarMoedas() {
		Moeda[] moedas = colecao.listarMoedas();
		if (moedas.length == 0) {
			System.out.println("Nenhum moeda cadastrada");
		}
		for (int i = 0; i < moedas.length; i++) {
			System.out.println(moedas[i]);
		}
	}
	
	
	// métodos auxiliares
	
	private static int leiaCodigo(Scanner entrada) {
		System.out.print("Digite o codigo: ");
		int codigo = entrada.nextInt();
		entrada.nextLine();
		return codigo;
	}
	
	private static String leiaNome(Scanner entrada) {
		System.out.print("Digite o nome: ");
		String nome = entrada.nextLine();
		return nome;
	}

	private static int leiaAnoCunhagem(Scanner entrada) {
		System.out.print("Digite o Ano de Cunhagem: ");
		int anoCunhagem = entrada.nextInt();
		entrada.nextLine();
		return anoCunhagem;
	}

	private static String leiaNacionalidade(Scanner entrada) {
		System.out.print("Digite a nacionalidade: ");
		String nacionalidade = entrada.nextLine();
		return nacionalidade;
	}

	private static double leiaValor(Scanner entrada) {
		System.out.print("Digite o valor: ");
		double valor = entrada.nextInt();
		entrada.nextLine();
		return valor;
	}
	
	private static int leiaQuantidade(Scanner entrada) {
		System.out.print("Digite a quantidade: ");
		int altura = entrada.nextInt();
		entrada.nextLine();
		return altura;
	}

}
