import java.io.File;

import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

/**
 * Classe principal do programa usada para executá-lo.
 * @author Fabio Dela Bruna / Juliete Braga
 * @since
 */
public class Principal {

	/**
	 * Método principal do programa.
	 */
	public static void main(String[] args) {
		
		mostraMenssagemBoasVindas();
		
		LeituraTXTs leitura = new LeituraTXTs();
		byte opcao1 = 0;
		
			do {
			
				opcao1 = menuGeral();
				if (opcao1 == 0) {
					mostraMenssagemSaida();
					System.exit(0);
				}
		
				switch (opcao1) {
				
					case 1 : {
						
						byte opcao2 = 0;
						
						do {
							
							opcao2 = menuImportarArquivos();
				
							switch (opcao2) {
							
								case 1 : {
									File arquivo = new File("livros/joao.txt");
									if (leitura.pegaArquivos(arquivo)) {
										mostraMenssagemSerializacaoCompletada();
									}
									break;
								}
									
								case 2 : {
									File arquivo = new File("livros/lucas.txt");
									if (leitura.pegaArquivos(arquivo)) {
										mostraMenssagemSerializacaoCompletada();
									}
									break;
								}
									
								case 3 : {
									File arquivo = new File("livros/marcos.txt");
									if (leitura.pegaArquivos(arquivo)) {
										mostraMenssagemSerializacaoCompletada();
									}
									break;
								}
									
								case 4 : {
									File arquivo = new File("livros/mateus.txt");
									if (leitura.pegaArquivos(arquivo)) {
										mostraMenssagemSerializacaoCompletada();
									}
									break;
								}
									
								case 5 : {
									int msg = mostraMenssagemConfirmacao();
	
									if (msg != 0) {
										break;
									} else {
										File pasta = new File("livros");
										File[] arquivos = pasta.listFiles();
										if (leitura.pegaArquivos(arquivos)) {
											mostraMenssagemSerializacaoCompletada();
										}
										break;
									}
								}
								
							}
							
						} while (opcao2 != 0);
						break;
						
					}
					
					case 2 : {
						
						byte opcao3 = 0;
						
						do {
													
							opcao3 = menuLerConteudoImportado();
							
							switch (opcao3) {
							
								case 1 : { // mostra busca apenas pelo livro;								
									String livro = JOptionPane.showInputDialog(null, "Digite o nome do livro:",
											"Busca por livro", JOptionPane.PLAIN_MESSAGE).toUpperCase();
							
									String retorno = leitura.mostraImportacao(livro);
									if (retorno == "") {
										mostraMenssagemErro(livro);							
									} else {
										JTextArea texto = new JTextArea(40, 80);
										JScrollPane scrollPane = new JScrollPane(texto);
										texto.setText(retorno);
										texto.setEditable(false); // torna o texto impossível de se editar
										//texto.setEnabled(false);  
									
										JOptionPane.showMessageDialog(null, scrollPane,
												"Livro: " + livro, JOptionPane.PLAIN_MESSAGE); 
									}
									break;
								}
								
								case 2 : { // mostra busca pelo livro e capítulo
									String livro = JOptionPane.showInputDialog(null, "Digite o nome do livro:",
											"Busca por livro e capítulo", JOptionPane.PLAIN_MESSAGE).toUpperCase();
									byte capitulo = Byte.parseByte(JOptionPane.showInputDialog(null, "Digite o capítulo:",
											"Busca por livro e capítulo", JOptionPane.PLAIN_MESSAGE));
									
									String retorno = leitura.mostraImportacao(livro, capitulo);
									if (retorno == "") {
										mostraMenssagemErro(livro, capitulo);
									} else {
										JTextArea texto = new JTextArea(40, 80);
										JScrollPane scrollPane = new JScrollPane(texto);
										texto.setText(retorno);	
										texto.setEditable(false); // torna o texto impossível de se editar
										//texto.setEnabled(false);
									
									JOptionPane.showMessageDialog(null, scrollPane,
											"Livro: " + livro + "  /  Capítulo: " + capitulo, JOptionPane.PLAIN_MESSAGE);
									}
									break;
								}
								
								case 3 : { // mostra busca pelo livro, capítulo e versículo
									String livro = JOptionPane.showInputDialog(null, "Digite o nome do livro:",
											"Busca por livro, capítulo e versículo", JOptionPane.PLAIN_MESSAGE).toUpperCase();
									byte capitulo = Byte.parseByte(JOptionPane.showInputDialog(null, "Digite o capítulo:",
											"Busca por livro, capítulo e versículo", JOptionPane.PLAIN_MESSAGE));
									byte versiculo = Byte.parseByte(JOptionPane.showInputDialog(null, "Digite o versículo:",
											"Busca por livro, capítulo e versículo", JOptionPane.PLAIN_MESSAGE));
									
									String retorno = leitura.mostraImportacao(livro, capitulo, versiculo);
									if (retorno == "") {
										mostraMenssagemErro(livro, capitulo, versiculo);
									} else {
										JTextArea texto = new JTextArea(5, 80);
										JScrollPane scrollPane = new JScrollPane(texto);
										texto.setText(retorno);
										texto.setEditable(false); // torna o texto impossível de se editar
										//texto.setEnabled(false);
									
									JOptionPane.showMessageDialog(null, scrollPane,
											"Livro: " + livro + "  /  Capítulo: " + capitulo + "  /  Versículo: " + versiculo, JOptionPane.PLAIN_MESSAGE);
									}
									break;
								}
								
							}
							
						} while (opcao3 < 0 || opcao3 > 3);
						break;
					}
					
					
					default : {
						mostraMenssagemErroOpcaoInvalida();
					}
					
				}
			
		} while (opcao1 != 0);
		
		
		mostraMenssagemSaida();
		System.exit(0);
		
	}
			
			
	// MÉTODOS AUXILIARES
	
	/**
	 * Menu Principal do programa.
	 * @return opção selecionada.
	 */
	private static byte menuGeral() {
		return Byte.parseByte(JOptionPane.showInputDialog(null, "\n< O que você deseja fazer ? >\n" +
				"\n| 1 |   Importar arquivos .txts" +
				"\n| 2 |   Ler conteúdo até então importado\n" +
				"\n| 0 |   < SAIR >",
				"* MENU PRINCIPAL *", JOptionPane.PLAIN_MESSAGE));	
	}
	
	/**
	 * Menu de importação de arquivos.
	 * @return opção selecionada.
	 */
	private static byte menuImportarArquivos() {
		return Byte.parseByte(JOptionPane.showInputDialog(null, "< Selecione o arquivo >\n" +
				"\n| 1 |   Importar livro:  joao.txt" +
				"\n| 2 |   Importar livro:  lucas.txt" +
				"\n| 3 |   Importar livro:  marcos.txt" +
				"\n| 4 |   Importar livro:  marcos.txt" +
				"\n| 5 |   Importar todos os livros acima\n" +
				"\n| 0 |   < Voltar |",
				"* IMPORTAÇÃO DE ARQUIVOS .TXTs *", JOptionPane.PLAIN_MESSAGE));
	}
	
	/**
	 * Menu de Leitura do conteúdo já importado (serializado).
	 * @return opção selecionada.
	 */
	private static byte menuLerConteudoImportado() {
		return Byte.parseByte(JOptionPane.showInputDialog(null, "< Selecione sua opção de leitura >\n" +
				"\n| 1 |   Buscar por nome do livro" +
				"\n| 2 |   Buscar por nome do livro e capítulo" +
				"\n| 3 |   Buscar por nome do livro, capítulo e versículo\n" +
				"\n| 0 |   < Voltar |",
				"* LER CONTEÚDO IMPORTADO *", JOptionPane.PLAIN_MESSAGE));
	}
	
	/**
	 * Método que mostra uma menssagem de agradecimento quando o programa é encerrado.
	 */
	private static void mostraMenssagemSaida() {
		JOptionPane.showMessageDialog(null, ". . :  MUITO OBRIGADO POR UTILIZAR NOSSO SISTEMA !!!  : . .",
				"Fechando o sistema ...",JOptionPane.PLAIN_MESSAGE);
	}
	
	/**
	 * Método que mostra uma menssagem de erro toda vez quem uma opção inválida for selecionada nos menus.
	 */
	private static void mostraMenssagemErroOpcaoInvalida() {
		JOptionPane.showMessageDialog(null, "Opção inválida!",
				"Erro", JOptionPane.ERROR_MESSAGE);
	}
	
	/**
	 * Método que mostra uma menssagem de boas vindas quando o programa é iniciado.
	 */
	private static void mostraMenssagemBoasVindas() {
		JOptionPane.showMessageDialog(null, ". . :  BEM VINDO AO SISTEMA DE SERIALIZAÇÃO DE ARQUIVOS !!!  : . .",
				"Iniciando o sistema ...", JOptionPane.PLAIN_MESSAGE);
	}
	
	/**
	 * Método que mostra uma menssagem indicando que a serialização foi efetuada com sucesso.
	 */
	private static void mostraMenssagemSerializacaoCompletada()	{
		JOptionPane.showMessageDialog(null, "Arquivo(s) serializado(s) com sucesso!",
				"Serialização completada", JOptionPane.PLAIN_MESSAGE);
	}
	
	/**
	 * Método sobrecarregado que mostra uma menssagem de erro sempre
	 * que o usuário digitar um nome de livro não-válido..
	 * @param livro - nome do livro.
	 */
	private static void mostraMenssagemErro(String livro) {
		JOptionPane.showMessageDialog(null, "Nenhum texto foi encontrado com esses dados:\n" + "\nLivro:  " + livro,
				"Erro", JOptionPane.ERROR_MESSAGE);
	}
	
	/**
	 * Método sobrecarregado que mostra uma menssagem de erro sempre que o usuário
	 * digitar um nome do livro ou capítulo que não é válido.
	 * @param livro - nome do livro.
	 * @param capitulo - cápitulo.
	 */
	private static void mostraMenssagemErro(String livro, byte capitulo) {
		JOptionPane.showMessageDialog(null, "Nenhum texto foi encontrado com esses dados:\n" +
				"\nLivro:  " + livro + "\nCapítulo:  " + capitulo,
				"Erro", JOptionPane.ERROR_MESSAGE);
	}
	
	/**
	 * Método sobrecarregado que mostra uma menssagem de erro sempre que o usuário digitar
	 * um nome do livro, capítulo ou versículo que não não são válidos.
	 * @param livro - nome do livro.
	 * @param capitulo - capítulo.
	 * @param versiculo - versículo.
	 */
	private static void mostraMenssagemErro(String texto, byte capitulo, byte versiculo) {
		JOptionPane.showMessageDialog(null, "Nenhum texto foi encontrado com esses dados:\n" +
				"\nLivro:  " + texto + "\nCapítulo:  " + capitulo + "\nVersículo:  " + versiculo,
				"Erro", JOptionPane.ERROR_MESSAGE);
	}
	
	private static int mostraMenssagemConfirmacao() {
		return JOptionPane.showConfirmDialog(null, "Esse método pode levar até 10 minutos para ser executado!!!\nDeseja Continuar?",
				"Confirme sua escolha: ", JOptionPane.YES_NO_OPTION);
	}
	
}