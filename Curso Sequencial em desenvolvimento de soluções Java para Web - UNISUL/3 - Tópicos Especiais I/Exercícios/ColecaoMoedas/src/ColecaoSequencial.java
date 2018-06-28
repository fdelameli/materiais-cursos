import java.io.*;
import java.util.StringTokenizer;
import java.util.Vector;


public class ColecaoSequencial implements PersistenciaColecao {
	
	//atributos
	private File arquivo;
	private BufferedReader entrada;
	private PrintWriter saida;
	
	//construtor
	public ColecaoSequencial (String arquivo) {
		this.arquivo = new File(arquivo);
	}
	
	//métodos principais

	@Override
	public boolean alterarMoeda(Moeda moeda) {
		boolean alterado = false; 
		File temp = null;
		try {
			this.entrada = new BufferedReader(new FileReader(this.arquivo));
			temp = new File("temp.seq");
			this.saida = new PrintWriter(new FileWriter(temp));
			String line = "";
			
			while ((line = this.entrada.readLine()) != null) {
				Moeda tempMoeda = readRecord(line);
				if (moeda.getCodigo() == tempMoeda.getCodigo()) {
					writeRecord(this.saida, moeda);
					alterado = true;
				} else {
					writeRecord(this.saida, tempMoeda);
				}
			}
			if (alterado) {
				fecharFluxo(this.entrada);
				fecharFluxo(this.saida);
				copyFile(temp, this.arquivo);
			}
		} catch (IOException ioe) {
			System.err.println("Erro de leitura ou gravação");
			System.out.println(ioe);
		} finally {
			fecharFluxo(this.entrada);
			fecharFluxo(this.saida);
			temp.delete();
		}
		return alterado;
	}

	@Override
	public Moeda consultarMoeda(int codigo) {
		Moeda moeda = null;
		try {
			this.entrada = new BufferedReader(new FileReader(this.arquivo));
			String line = "";
			while ((line = this.entrada.readLine()) != null) {
				Moeda tempMoeda = readRecord(line);
				if (tempMoeda.getCodigo() == codigo) {
					moeda = tempMoeda;
				}
			}
		} catch (IOException ioe) {
			System.err.println("Erro de leitura");
			System.out.println(ioe);
		} finally {
			fecharFluxo(this.entrada);
		}
		return moeda;
	}

	@Override
	public boolean inserirMoeda(Moeda moeda) {
		boolean inserido = false;
		try {
				this.saida = new PrintWriter(new FileWriter(this.arquivo, true));
				writeRecord(this.saida, moeda);
				inserido = true;
		} catch (IOException ioe) {
			System.err.println("Erro de gravação");
			System.out.println(ioe);
		} finally {
			fecharFluxo(this.saida);
		}
		return inserido;
	}

	@Override
	public Moeda[] listarMoedas() {
		Vector<Moeda> lista = new Vector<Moeda>();
		try {
			this.entrada = new BufferedReader(new FileReader(this.arquivo));
			String line = "";
			while ((line = this.entrada.readLine()) != null) {
				Moeda moeda = readRecord(line);
				lista.add(moeda);
			}
		} catch (IOException ioe) {
			System.err.println("Erro de leitura");
			System.out.println(ioe);
		} finally {
			fecharFluxo(this.entrada);
		}
		return lista.toArray(new Moeda[0]);
	}

	@Override
	public boolean removerMoeda(int codigo) {
		boolean removido = false;
		File temp = null;
		try {
			this.entrada = new BufferedReader(new FileReader(this.arquivo));
			temp = new File("temp.seq");
			this.saida = new PrintWriter(new FileWriter(temp));
			String line	= "";
			while ((line = this.entrada.readLine()) != null) {
				Moeda moeda = readRecord(line);
				if (moeda.getCodigo() == codigo) {
					removido = true;
				} else {
					writeRecord (this.saida, moeda);
				}
			}
			if (removido) {
				fecharFluxo(this.entrada);
				fecharFluxo(this.saida);
				copyFile(temp, this.arquivo);
			}
		} catch (IOException ioe) {
			System.err.println("Erro de leitura ou gravação");
			System.out.println(ioe);
		} finally {
			fecharFluxo(this.entrada);
			fecharFluxo(this.saida);
			temp.delete();
		}
		return removido;
	}
	
	
	//métodos auxiliares
	
	/**
	 * Método usado para fazer cópia de arquivos como um todo.
	 * @param fileOrigin - arquivo de origem.
	 * @param fileDestination - arquivo de destino.
	 */
	private void copyFile(File fileOrigin, File fileDestination) {
		try {
			this.entrada = new BufferedReader(new FileReader(fileOrigin));
			this.saida = new PrintWriter(new FileWriter(fileDestination));
			String line = "";
			while ((line = this.entrada.readLine()) != null) {
				Moeda moeda = readRecord(line);
				writeRecord(this.saida, moeda);
			}
		} catch (IOException ioe) {
			System.err.println("Erro de leitura ou gravação");
			System.out.println(ioe);
		} finally {
			fecharFluxo(this.entrada);
			fecharFluxo(this.saida);
		}

	}

	/**
	 * Método para fechar um fluxo de entrada.
	 * @param output - Objeto do tipo PrintWriter, usado para fazer a gravação dos dados em um
	 */
	private void fecharFluxo(PrintWriter output) {
		if (output != null) {
			output.close();
		}
	}
	
	/**
	 * Método para fechar um fluxo de saída.
	 * @param input - Objeto do tipo BufferedWriter, usado para fazer a leitura dos dados em uma linha do arquivo.
	 */
	private void fecharFluxo(BufferedReader input) {
		try {
			if (input != null) {
				input.close();
			}
		}catch (IOException ioe) {
			System.err.println("Erro no fechamento do arquivo");
			System.out.println(ioe);
		}
	}
	
	/**
	 * Método para escrever um registro para o arquivo.
	 * @param output - Objeto do tipo PrintWriter, usado para fazer a gravação dos dados em uma linha do arquivo.
	 * @param atleta - Atleta contendo os dados a serem gravados no arquivo de texto.
	 */ 
	private void writeRecord(PrintWriter output, Moeda moeda) {
		output.println(moeda.getCodigo() +
			"\t" + moeda.getNome() +
			"\t" + moeda.getNacionalidade() +
			"\t" + moeda.getAnoCunhagem() +
			"\t" + moeda.getValor() +
			"\t" + moeda.getQuantidade());
		output.flush();
	}

	/**
	 * Método para transformar uma linha do arquivo em um objeto do tipo Moeda
	 * @param line - String contendo os registro da moeda.
	 * @return moeda - Objeto do tipo Moeda.
	 */
	private Moeda readRecord(String line) {
		StringTokenizer tokens = new StringTokenizer(line, "\t\n");
		int codigo = Integer.parseInt(tokens.nextToken());
		String nome = tokens.nextToken();
		String nacionalidade = tokens.nextToken();
		int anoCunhagem = Integer.parseInt(tokens.nextToken());
		double valor = Double.parseDouble(tokens.nextToken());
		int quantidade = Integer.parseInt(tokens.nextToken());
		Moeda moeda = new Moeda(codigo, nome, nacionalidade, anoCunhagem, valor, quantidade);
		return moeda;
	}

}
