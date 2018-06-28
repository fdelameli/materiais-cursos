import java.io.*;
import javax.swing.JOptionPane;

/**
 * Classe Principal, na qual é executado o programa
 * @author Márcio Ozório Teixeira / Edu Schmoller.
 * @since 01/09/2008.
 */
public class Principal {

	public static void main(String[] args) {

		int opcao = Integer
				.parseInt(JOptionPane
						.showInputDialog("Digite uma Opção:\n\n"
								+ "1 - Importar os arquivos .txts para um arquivo .ser\n"
								+ "2 - Ler o conteúdo importado\n" + "0 - Sair"));

		while (opcao != 0) {

			switch (opcao) {
			case 1: {

				opcao = 0;
				int opcao2 = Integer.parseInt(JOptionPane
						.showInputDialog("Digite o livro a ser importado:\n\n"
								+ "1 - Mateus\n" + "2 - João\n" + "3 - Lucas\n"
								+ "4 - Marcos\n" + "0 - Sair"));

				while (opcao2 != 0) {
					
					switch (opcao2) {

					case 1: {

						File arquivo = new File("Textos/mateus.txt");
						File gerado = new File("Serializados/mateus.ser");

						if (gerado.exists())
							gerado.delete();

						try {
							gerado.createNewFile();
						} catch (IOException e) {
							JOptionPane.showMessageDialog(null, "Não foi possível criar o arquivo!", "Erro", JOptionPane.ERROR_MESSAGE);
						}
						
						serializa(arquivo, gerado);
						opcao2 = 0;
						break;
					}

					case 2: {

						File arquivo = new File("Textos/joao.txt");
						File gerado = new File("Serializados/joao.ser");

						if (gerado.exists())
							gerado.delete();

						try {
							gerado.createNewFile();
						} catch (IOException e) {
							JOptionPane.showMessageDialog(null, "Não foi possível criar o arquivo!", "Erro", JOptionPane.ERROR_MESSAGE);
						}

						serializa(arquivo, gerado);
						opcao2 = 0;
						break;
					}
					case 3: {

						File arquivo = new File("Textos/lucas.txt");
						File gerado = new File("Serializados/lucas.ser");

						if (gerado.exists())
							gerado.delete();

						try {
							gerado.createNewFile();
						} catch (IOException e) {
							JOptionPane.showMessageDialog(null, "Não foi possível criar o arquivo!", "Erro", JOptionPane.ERROR_MESSAGE);
						}

						serializa(arquivo, gerado);
						opcao2 = 0;
						break;
					}
					case 4: {

						File arquivo = new File("Textos/marcos.txt");
						File gerado = new File("Serializados/marcos.ser");

						if (gerado.exists())
							gerado.delete();

						try {
							gerado.createNewFile();
						} catch (IOException e) {
							JOptionPane.showMessageDialog(null, "Não foi possível criar o arquivo!", "Erro", JOptionPane.ERROR_MESSAGE);
						}

						serializa(arquivo, gerado);
						opcao2 = 0;
						break;
						}
					}
				}	
				break;
			}
			case 2: {

				opcao = 0;

				int livro = Integer
						.parseInt(JOptionPane
								.showInputDialog("Digite o número do livro que deseja ler:\n\n"
										+ "1 - Mateus\n"
										+ "2 - Lucas\n"
										+ "3 - João\n" + "4 - Marcos\n"));

				int capitulo = Integer
						.parseInt(JOptionPane
								.showInputDialog("Digite o capitulo do livro a ser pesquisado: \n"));

				while (livro != 0) {

					switch (livro) {

					case 1: {
						File caminhoLivro = new File("Serializados/mateus.ser");
						lerSerializado(caminhoLivro, capitulo);
						livro = 0;
						break;
					}
					case 2: {
						File caminhoLivro = new File("Serializados/lucas.ser");
						lerSerializado(caminhoLivro, capitulo);
						livro = 0;
						break;
					}
					case 3: {
						File caminhoLivro = new File("Serializados/joao.ser");
						lerSerializado(caminhoLivro, capitulo);
						livro = 0;
						break;
					}
					case 4: {
						File caminhoLivro = new File("Serializados/marcos.ser");
						lerSerializado(caminhoLivro, capitulo);
						livro = 0;
						break;
						}
					}
				}
			}
		}
	}
}

	/**
	 * Método responsável pela leitura de arquivos já serializados
	 * @param arquivo
	 * @param capitulo
	 * @param versiculo
	 */
	private static void lerSerializado(File arquivo, int capitulo) {

		String dados = "";
		ObjectInputStream in = null;

		try {

			in = new ObjectInputStream(new FileInputStream(arquivo));
			Importacao importacao = null;

			while (true) {

				importacao = (Importacao) in.readObject();

				if (importacao.getCapitulo() == capitulo) {
					dados += importacao.getCapitulo() + "." + importacao.getVersículo() + "  " + importacao.getTexto() + "\n";
				}
			}

		} catch (EOFException eofe) {
			;
		} catch (ClassNotFoundException e) {
			JOptionPane.showMessageDialog(null, "Classe desconhecida!", "Erro", JOptionPane.ERROR_MESSAGE);
		} catch (FileNotFoundException e) {
			JOptionPane.showMessageDialog(null, "Arquivo desconhecido!", "Erro", JOptionPane.ERROR_MESSAGE);
		} catch (IOException e) {
			JOptionPane.showMessageDialog(null, "Leitura desconhecida!", "Erro", JOptionPane.ERROR_MESSAGE);
		}
		
		JOptionPane.showMessageDialog(null, "Conteúdo do livro e capítulo solicitado: \n\n" + dados);

	}

	/**
	 * Método responsável pela serialização de arquivos txt`s.
	 * @param arquivo
	 * @param gerado
	 */
	private static void serializa(File arquivo, File gerado) {

		BufferedReader inarquivo = null;
		String linha = "";
		int cont = 0;

		try {

			inarquivo = new BufferedReader(new FileReader(arquivo));

			ObjectOutputStream saida = new ObjectOutputStream(new FileOutputStream(gerado));

			while ((linha = inarquivo.readLine()) != null) {
				
				if (linha.charAt(0) == ' ') {
					; //Não faz nada.
				} else {

					Importacao importacao = pegaDados(arquivo, linha); //chama o método pegaDados para pegar os dados
					saida.writeObject(importacao);
					saida.flush();

					cont++;

					System.out.println("Linha Serializada: " + cont);

				}
			}
			System.out.println("Arquivo:\n " + arquivo.getName() + "\nSerializado com Sucesso!");

		} catch (FileNotFoundException e) {
			JOptionPane.showMessageDialog(null, "Arquivo desconhecido!", "Erro", JOptionPane.ERROR_MESSAGE);
		} catch (IOException e) {
			JOptionPane.showMessageDialog(null, "Erro durante a Serialização!", "Erro", JOptionPane.ERROR_MESSAGE);
		}
	}

	/**
	 * Método responsável por pegar os atributos de cada linha e transformar em um objeto do tipo Importacao.
	 * @param arquivo
	 * @param linha
	 * @return importacao
	 */
	private static Importacao pegaDados(File arquivo, String linha) {

		String livro = arquivo.getName().substring(0,
				arquivo.getName().indexOf("."));
		int indicePonto = linha.indexOf(".");
		int capitulo = Integer.parseInt(linha.substring(0, indicePonto));
		int indiceEspaco = linha.indexOf(" ");
		int versiculo = Integer.parseInt(linha.substring((indicePonto + 1),
				indiceEspaco));
		String texto = linha.substring(indiceEspaco + 1);

		Importacao importacao = new Importacao(livro, capitulo, versiculo,
				texto);
		return importacao;
	}
}
