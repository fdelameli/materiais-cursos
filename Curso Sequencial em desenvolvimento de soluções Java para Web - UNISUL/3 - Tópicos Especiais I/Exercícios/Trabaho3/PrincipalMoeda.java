import java.util.Scanner;

public class PrincipalMoeda {

	private static Scanner entrada = new Scanner(System.in);
	private static PersistenciaMoeda moeda = new MoedaSequencial("arquivo.seq");

	public static void main(String[] args) {
		System.out.println("BEM VINDO AO SISTEMA DE CADASTRO DE MOEDAS");
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
		System.out.println("MUITO OBRIGADO POR UTILIZAR O SISTEMA DE CADASTRO DE MOEDAS");
	}

	private static int menu() {
		String menu = "1 - Para inserir uma moeda"
		+ "\n2 - Para consultar uma moeda"
		+ "\n3 - Para alterar uma moeda"
		+ "\n4 - Para remover uma moeda"
		+ "\n5 - Para listar as moedas"
		+ "\n0 - Para sair do sistema"
		+ "\nDigite sua opção....: ";
		int opcao;
		do {
			System.out.print(menu);
			opcao = entrada.nextInt();
		} while (opcao < 0 || opcao > 5);
		return opcao;
	}

	//------------------------------------------
	//Metodos principais
	//------------------------------------------

	private static void inserirMoeda() {
		int codigo = leiaCodigo(entrada);
		String nome = leiaNome(entrada);
		int anoCunhagem = leiaAnoCunhagem(entrada);
		String nacionalidade = leiaNacionalidade(entrada);
		int valor = leiaValor(entrada);
		int quantidade = leiaQuantidade(entrada);

		Moeda moed = new Moeda(codigo, nome, anoCunhagem, nacionalidade, valor, quantidade);
		
		if (moeda.inserirMoeda(moed)) {
			System.out.println("Moeda inserida com sucesso");
		} else {
			System.out.println("Não foi possível inserir a moeda");
		}
	}

	public static void consultarMoeda() {
		int codigo = leiaCodigo(entrada);

		Moeda moed = moeda.consultarMoeda(codigo);
		
		if (moed != null) {
			System.out.println("Moeda encontrata com sucesso: " + moed);
		} else {
			System.out.println("Moeda não encontra com este código: " + codigo);
		}
	}

	public static void removerMoeda() {
		int codigo = leiaCodigo(entrada);

		if (moeda.removerMoeda(codigo)) {
			System.out.println("Moeda removida com sucesso");
		} else {
			System.out.println("Moeda não encontra com este código: " + codigo);
		}
	}

	public static void alterarMoeda() {
		int codigo = leiaCodigo(entrada);
		String nome = leiaNome(entrada);
		int anoCunhagem = leiaAnoCunhagem(entrada);
		String nacionalidade = leiaNacionalidade(entrada);
		int valor = leiaValor(entrada);
		int quantidade = leiaQuantidade(entrada);

		Moeda moed = new Moeda(codigo, nome, anoCunhagem, nacionalidade, valor, quantidade);

		if(moeda.alterarMoeda(moed)) {
			System.out.println("Moeda alterada com sucesso");
		} else {
			System.out.println("Moeda não encontra com este código: " + codigo);
		}
	}

	public static void listarMoedas() {
		Moeda[] moedas = moeda.listarMoedas();
		if (moedas.length == 0) {
			System.out.println("Nenhum moeda cadastrada");
		}
		for (int i = 0; i < moedas.length; i++) {
			System.out.println(moedas[i]);
		}
	}
	
	//------------------------------------------
	//Metodos de apoio
	//------------------------------------------

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

	private static int leiaValor(Scanner entrada) {
		System.out.print("Digite o valor: ");
		int valor = entrada.nextInt();
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
