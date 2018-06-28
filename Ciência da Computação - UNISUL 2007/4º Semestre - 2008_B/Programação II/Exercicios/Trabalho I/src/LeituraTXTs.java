import java.io.*;
import javax.swing.JOptionPane;

/**
 * Classe que  contém todos os métodos do programa.
 * @author Fabio Dela Bruna / Juliete Braga.
 * @since 26/08/2008.
 */
public class LeituraTXTs {

	// ATRIBUTOS
	
	private File exportacao;
	
	
	// CONSTRUTORES

	/**
	 * Construtor default.
	 */
	public LeituraTXTs() {
		this.exportacao = new File("exportacao.ser");
	}
	
	
	// MÉTODOS PRINCIPAIS
	
	/**
	 * Método sobrecarregado que recebe um único arquivo para ser serialiado.
	 * @param arquivo - arquivo.
	 */
	public boolean pegaArquivos(File arquivo) {
		
		verificaArquivoExiste(this.exportacao);
		
		boolean executado = false;
		BufferedReader entrada = null;
			
			try {
				entrada = new BufferedReader(new FileReader(arquivo));
				String linha = "";
				int cont = 1;
				while ((linha = entrada.readLine()) != null) {
					if (linha.charAt(0) == ' ') {
						;
					} else {
						Importacao importacao = pegaAtributos(linha, arquivo);  // chama o método para pegar os atributos
						serializaArquivos(importacao);  //chama o método para serializar linha por linha.
						System.out.println("Livro: " + arquivo.getName() + " --- Linha " + cont + " Serializada com sucesso!");
						cont++;
					}
				}
				executado = true;
			} catch (IOException ioe) {
				JOptionPane.showMessageDialog(null, "Erro de leitura!", "Erro", JOptionPane.ERROR_MESSAGE);
			} finally {
				fecharFluxo(entrada);
			}
		return executado;
	}
	
	/**
	 * Método sobrecarregado que recebe um vetor de arquivos para serem posterioemente serializados.
	 * @param arquivos - vetor de arquivos.
	 */
	public boolean pegaArquivos(File[] arquivos) {
		
		verificaArquivoExiste(this.exportacao);
		
		boolean executado = false;
		BufferedReader entrada = null;
		
		for (File file : arquivos) {
			
			try {
				entrada = new BufferedReader(new FileReader(file));
				String linha = "";
				int cont = 1;
				while ((linha = entrada.readLine()) != null) {
					if (linha.charAt(0) == ' ') {
						;
					} else {
						Importacao importacao = pegaAtributos(linha, file);  // chama o método para pegar os atributos
						serializaArquivos(importacao);  //chama o método para serializar linha por linha.
						System.out.println("Livro: " + file.getName() + " --- Linha " + cont + " Serializada com sucesso!");
						cont++;
					}
				}
				executado = true;
			} catch (IOException ioe) {
				JOptionPane.showMessageDialog(null, "Erro de leitura!", "Erro", JOptionPane.ERROR_MESSAGE);
			} finally {
				fecharFluxo(entrada);
			}
		}
		return executado;
	}

	
	/**
	 * Método sobrecarregado usado para a pesquisa de um determinado objeto do tipo importação
	 * que foi serializado no arquivo. A busca é feita atravéz do nome do livro,.
	 * @param livro - nome do livro.
	 * @return objeto do tipo Importação contendo os dados caso ele seja encontrado
	 * ou null caso nenhum objeto seja encontrado com os atributos em questão.
	 */
	public String mostraImportacao(String livro) {
		String retorno = "";
		ObjectInputStream entrada = null;
		
		try {
			
			entrada = new ObjectInputStream(new FileInputStream(this.exportacao));
			Importacao importacao = null;
			while (true) {
				importacao = (Importacao) entrada.readObject();
				if (importacao.getNomeLivro().equals(livro)) {  
					retorno = importacao.getCapitulo() + "." + importacao.getVersiculo() +
								"  " + importacao.getTexto() + "\n" + retorno;
				}
			}
		} catch (EOFException eofe) {
			; //não faz nada, é apenas o mecanismo para sair.
		} catch (ClassNotFoundException cnfe) {
			JOptionPane.showMessageDialog(null, "Erro de classe desconhecida!", "Erro", JOptionPane.ERROR_MESSAGE);
		} catch (IOException ioe) {
			ioe.printStackTrace();
			JOptionPane.showMessageDialog(null, "Erro de leitura!", "Erro", JOptionPane.ERROR_MESSAGE);
		} finally {
			fecharFluxo(entrada);
		}
	
		return retorno;
	}
	
	/**
	 * Método sobrecarregado usado para a pesquisa de um determinado objeto do tipo importação
	 * que foi serializado no arquivo. A busca é feita atravéz do nome do livro e do capítulo.
	 * @param livro - nome do livro.
	 * @param capitulo - capitulo.
	 * @return objeto do tipo Importação contendo os dados caso ele seja encontrado
	 * ou null caso nenhum objeto seja encontado com os atributos em questão.
	 */
	public String mostraImportacao(String livro, byte capitulo) {
		String retorno = "";
		ObjectInputStream entrada = null;
		
		try {
			
			entrada = new ObjectInputStream(new FileInputStream(this.exportacao));
			Importacao importacaoTemp = null;
			while (true) {
				importacaoTemp = (Importacao) entrada.readObject();
				if ((importacaoTemp.getNomeLivro().equals(livro)) 
						&& importacaoTemp.getCapitulo() == capitulo){
			
					retorno = importacaoTemp.getCapitulo() + "." + importacaoTemp.getVersiculo() +
								"  " + importacaoTemp.getTexto() + "\n" + retorno;
				}
			}
		} catch (EOFException eofe) {
			; //não faz nada, é apenas o mecanismo para sair.
		} catch (ClassNotFoundException cnfe) {
			JOptionPane.showMessageDialog(null, "Erro de classe desconhecida!", "Erro", JOptionPane.ERROR_MESSAGE);
		} catch (IOException ioe) {
			JOptionPane.showMessageDialog(null, "Erro de leitura!", "Erro", JOptionPane.ERROR_MESSAGE);
		} finally {
			fecharFluxo(entrada);
		}
	
		return retorno;
	}
	
	/**
	 * Método sobrecarregado usado para a pesquisa de um determinado objeto do tipo importação
	 * que foi serializado no arquivo. A busca é feita atravéz do nome do livro, do capítulo e do versículo.
	 * @param livro - nome do livro.
	 * @param capitulo - capítulo.
	 * @param versiculo - versículo.
	 * @return objeto do tipo Importação contendo os dados caso ele seja encontrado
	 * ou null caso nenhum objeto seja encontado com os atributos em questão.
	 */
	public String mostraImportacao(String livro, byte capitulo, byte versiculo) {
		String retorno = "";
		Importacao importacao = null;
		ObjectInputStream entrada = null;
		
		
		try {
			
			entrada = new ObjectInputStream(new FileInputStream(this.exportacao));
			Importacao importacaoTemp = null;
			while (true) {
				importacaoTemp = (Importacao) entrada.readObject();
				if ((importacaoTemp.getNomeLivro().equals(livro)) 
						&& importacaoTemp.getCapitulo() == capitulo
						&& importacaoTemp.getVersiculo() == versiculo) {
					
					importacao = importacaoTemp;
					retorno = importacao.getCapitulo() + "." + importacao.getVersiculo() +
								"  " + importacao.getTexto() + "\n";
					
				}
			}
		} catch (EOFException eofe) {
			; //não faz nada, é apenas o mecanismo para sair.
		} catch (ClassNotFoundException cnfe) {
			JOptionPane.showMessageDialog(null, "Erro de classe desconhecida!", "Erro", JOptionPane.ERROR_MESSAGE);
		} catch (IOException ioe) {
			JOptionPane.showMessageDialog(null, "Erro de leitura!", "Erro", JOptionPane.ERROR_MESSAGE);
		} finally {
			fecharFluxo(entrada);
		}
	
		return retorno;
	}

	
	// MÉTODOS AUXILIARES

	
	/**
	 * Método que recebe um objeto do tipo Importacao (formado por uma linha) e grava no arquivo.
	 * @param importacao - Objeto do tipo Importacao.
	 */
	private void serializaArquivos(Importacao importacao) {
		boolean serializado = false;
		File temp = new File("temp.ser");
		ObjectInputStream entrada = null;
		ObjectOutputStream saida = null;
		
		try {
			
			saida = new ObjectOutputStream(new FileOutputStream(temp));
			saida.writeObject(importacao);
			saida.flush();
			
			serializado = true;
			
			entrada = new ObjectInputStream(new FileInputStream(this.exportacao));
			Importacao importacaoTemp = null;
			
			while (true) { // copia cada objeto do tipo Importacao para o arquivo temporário
				importacaoTemp = (Importacao) entrada.readObject();
				saida.writeObject(importacaoTemp);
				saida.flush();
			}
		
		} catch (EOFException eofe) {
			if (serializado) {
				fecharFluxo(entrada);
				fecharFluxo(saida);
				copiarArquivo(temp, this.exportacao);
			} else {
				System.err.println("Nao pode ser serializado!");
			}

		} catch (IOException ioe) {
			JOptionPane.showMessageDialog(null, "Erro de leitura ou gravação ao serializar objeto!", "Erro", JOptionPane.ERROR_MESSAGE);
		} catch (ClassNotFoundException cnfe) {
			JOptionPane.showMessageDialog(null, "Erro de classe desconhecida!", "Erro", JOptionPane.ERROR_MESSAGE);
		} finally {
			fecharFluxo(entrada);
			fecharFluxo(saida);
		}
	}
	
/*	private void serializaArquivos(Importacao importacao) {

		ObjectOutputStream saida = null;
		
		try {
			
			saida = new ObjectOutputStream(new FileOutputStream(this.exportacao, true));
			saida.writeObject(importacao);
			saida.flush();
			
			
		} catch (IOException ioe) {
			JOptionPane.showMessageDialog(null, "Erro de leitura ou gravação ao serializar objeto!", "Erro", JOptionPane.ERROR_MESSAGE);
		} finally {

			fecharFluxo(saida);
		}
	}*/
	
	/**
	 * Método usado para, caso o arquivo ja exista ele deleta o mesmo
	 * e depois cria ele novamente (regras estabelecidas pelo professor).
	 * @param arquivo - arquivo.
	 */
	private void verificaArquivoExiste(File arquivo) {
		if (arquivo.exists())
			arquivo.delete();
		
		try {
			arquivo.createNewFile();
		} catch (IOException ioe) {
			JOptionPane.showMessageDialog(null, "Não foi possível criar o arquivo!", "Erro", JOptionPane.ERROR_MESSAGE);
		}
	}
	
	/**
	 * Método usado para pegar os atributos de cada linha específica e transformar em um objeto do tipo Importacao.
	 * @param linha - String contendo os atributos a serem retirados.
	 * @param arquivo - arquivo.
	 * @return - objeto do tipo Importacao.
	 */
	private Importacao pegaAtributos(String linha, File arquivo) {
		String nomeLivro = arquivo.getName().substring(0, arquivo.getName().indexOf(".")).toUpperCase();
		int indicePonto = linha.indexOf(".");
		byte capitulo = Byte.parseByte(linha.substring(0, indicePonto));
		int IndiceEspaco = linha.indexOf(" ");
		byte versiculo = Byte.parseByte(linha.substring((indicePonto+1), IndiceEspaco));
		String texto = linha.substring(IndiceEspaco+1).toUpperCase();
		Importacao importacao = new Importacao(nomeLivro, capitulo, versiculo, texto);
		return importacao;
	}
	
	/**
	 * Método usado para fazer cópia de arquivos como um todo.
	 * @param de - arquivo de origem.
	 * @param para - arquivo de destino.
	 */
	private void copiarArquivo(File de, File para) {
		ObjectInputStream entrada = null;
		ObjectOutputStream saida = null;
		
		try {
			entrada = new ObjectInputStream(new FileInputStream(de));
			saida = new ObjectOutputStream(new FileOutputStream(para));
			Importacao importacao = null;

			while (true) {
				try {
				importacao = (Importacao) entrada.readObject();
				saida.writeObject(importacao);
				saida.flush();
				
				} catch (EOFException eofe) {
					break;
				}
			}
//		} catch (EOFException eofe) {
//			; // não faz nada. É apenas o mecanismo para sair.
		} catch (IOException ioe) {
			JOptionPane.showMessageDialog(null, "Erro de leitura ou gravação ao copiar arquivo!", "Erro", JOptionPane.ERROR_MESSAGE);
		} catch (ClassNotFoundException cnfe) {
			JOptionPane.showMessageDialog(null, "Erro de classe desconhecida!", "Erro", JOptionPane.ERROR_MESSAGE);
		} finally {
			fecharFluxo(entrada);
			fecharFluxo(saida);
		}
	}
	
	// MÉTODOS AUXILIARES SOBRECARREGADOS.
	
	/**
	 * Método para fechar o fluxo de entrada do tipo BufferedReader.
	 * @param entrada - fluxo de entrada.
	 */
	private void fecharFluxo(BufferedReader entrada) {
		try {
			if (entrada != null) {
				entrada.close();
			}
		} catch (IOException eio) {
			JOptionPane.showMessageDialog(null, "Erro ao fechar o fluxo de entrada!", "Erro", JOptionPane.ERROR_MESSAGE);
		}
	}

	/**
	 * Método para fechar o fluxo de entrada do tipo ObjectInputStream.
	 * @param entrada - Fluxo de entrada.
	 */
	private void fecharFluxo(ObjectInputStream entrada) {
		try {
			if (entrada != null) {
				entrada.close();
			}
		} catch (IOException ioe) {
			JOptionPane.showMessageDialog(null, "Erro ao fechar o fluxo de entrada!", "Erro", JOptionPane.ERROR_MESSAGE);
		}
	}

	/**
	 * Método para fechar um fluxo de saida do tipo ObjectOutputStream.
	 * @param saida - Fluxo de saida
	 */
	private void fecharFluxo(ObjectOutputStream saida) {
		try {
			if (saida != null) {
				saida.close();
			}
		} catch (IOException ioe) {
			JOptionPane.showMessageDialog(null, "Erro ao fechar o fluxo de saida!", "Erro", JOptionPane.ERROR_MESSAGE);
		}
	}
	 
	
}
