import java.util.*;

public class PrincipalAcademia {

	private static Scanner entrada = new Scanner(System.in);
	private static PersistenciaAcademia academia = new AcademiaAleatoria("academia_ale.txt");

	public static void main(String[] args) {
		System.out.println("BEM VINDO AO SISTEMA DE CONTROLE DE ATLETAS");
		int opcao = menu();
		while (opcao != 0) {
			switch (opcao) {
				case 1: {
					inserirAtleta();
					break;
				}
				case 2: {
					consultarAtleta();
					break;
				}
				case 3: {
					alterarAtleta();
					break;
				}
				case 4: {
					removerAtleta();
					break;
				}
				case 5: {
					listarAtletas();
					break;
				}
			}
			opcao = menu();
		}
		System.out.println("MUITO OBRIGADO POR UTILIZAR O SISTEMA DE CONTROLE DE ATLETAS");
	}

	private static int menu() {
		String menu = "1 - Para inserir um atleta"
		+ "\n2 - Para consultar um atleta"
		+ "\n3 - Para alterar um atleta"
		+ "\n4 - Para remover um atleta"
		+ "\n5 - Para listar os atletas"
		+ "\n0 - Para sair do sistema"
		+ "\nDigite sua opção....: ";
		int opcao;
		do {
			System.out.print(menu);
			opcao = entrada.nextInt();
		} while (opcao < 0 || opcao > 5);
		return opcao;
	}
	
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
	
	private static double leiaAltura(Scanner entrada) {
		System.out.print("Digite a altura: ");
		double altura = entrada.nextDouble();
		entrada.nextLine();
		return altura;
	}

	private static void inserirAtleta() {
		int codigo = leiaCodigo(entrada);
		String nome = leiaNome(entrada);
		double altura = leiaAltura(entrada);
		
		Atleta atleta = new Atleta(codigo, nome, altura);
		
		if (academia.inserirAtleta(atleta)) {
			System.out.println("Atleta inserido com sucesso");
		} else {
			System.out.println("Não foi possível inserir atleta");
		}
	}

	public static void consultarAtleta() {
		int codigo = leiaCodigo(entrada);

		Atleta atleta = academia.consultarAtleta(codigo);
		
		if (atleta != null) {
			System.out.println("Atleta encontrato com sucesso: " + atleta);
		} else {
			System.out.println("Atleta não encontra com este código: " + codigo);
		}
	}

	public static void removerAtleta() {
		int codigo = leiaCodigo(entrada);

		if (academia.removerAtleta(codigo)) {
			System.out.println("Atleta removido com sucesso");
		} else {
			System.out.println("Atleta não encontra com este código: " + codigo);
		}
	}

	public static void alterarAtleta() {
		int codigo = leiaCodigo(entrada);
		String nome = leiaNome(entrada);
		double altura = leiaAltura(entrada);
		
		Atleta atleta = new Atleta(codigo, nome, altura);

		if(academia.alterarAtleta(atleta)) {
			System.out.println("Atleta alterado com sucesso");
		} else {
			System.out.println("Atleta não encontra com este código: " + codigo);
		}
	}

	public static void listarAtletas() {
		Atleta[] atletas = academia.listarAtletas();
		if (atletas.length == 0) {
			System.out.println("Nenhum atleta cadastrado");
		}
		for (int i = 0; i < atletas.length; i++) {
			System.out.println(atletas[i]);
		}
	}
}