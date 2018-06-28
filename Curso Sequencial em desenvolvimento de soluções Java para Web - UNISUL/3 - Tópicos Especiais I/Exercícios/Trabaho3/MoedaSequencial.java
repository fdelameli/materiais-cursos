import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.StringTokenizer;
import java.util.Vector;

public class MoedaSequencial implements PersistenciaMoeda{

	// atributos
	private File arquivo;
	private BufferedReader entrada;
	private PrintWriter saida;

	// construtor
	public MoedaSequencial(String arquivo) {
		this.arquivo = new File(arquivo);
	}

	//------------------------------------------
	//Metodos principais
	//------------------------------------------
	
	// método para inserir uma Moeda
	public boolean inserirMoeda(Moeda moeda) {
		boolean inserido = false;
		try {
			saida = new PrintWriter(new FileWriter(this.arquivo, true));
			writeRecord(saida, moeda);
			inserido = true;
		} catch (IOException ioe) {
			System.out.println("Erro de gravação");
			System.out.println(ioe);
		} finally {
			fecharFluxo(saida);
		}
		return inserido;
	}
	
	// método para consultar uma moeda
	public Moeda consultarMoeda(int codigo) {
		Moeda moeda = null;
		try {
			entrada = new BufferedReader(new FileReader(this.arquivo));
			String line;
			while ((line = entrada.readLine()) != null) {
				Moeda moeda1 = readRecord(line);
				if (moeda1.getCodigo() == codigo) {
					moeda = moeda1;
				}
			}
		} catch (IOException ioe) {
			System.out.println("Erro de leitura");
			System.out.println(ioe);
		} finally {
			fecharFluxo(entrada);
		}
		return moeda;
	}

	// método para remover uma moeda
	public boolean removerMoeda(int codigo) {
		boolean excluido = false;
		try {
			entrada = new BufferedReader(new FileReader(this.arquivo));
			File temp = new File("temp.txt");
			saida = new PrintWriter(new FileWriter(temp));
			String line;
			while ((line = entrada.readLine()) != null) {
				Moeda moeda = readRecord(line);
				if (moeda.getCodigo() == codigo) {
					excluido = true;
				} else {
					writeRecord(saida, moeda);
				}
			}
			if (excluido) {
				entrada.close();
				saida.close();
				copiarArquivo(temp, this.arquivo);
			}
		} catch (IOException ioe) {
			System.out.println("Erro de leitura ou gravação");
			System.out.println(ioe);
		} finally {
			fecharFluxo(entrada);
			fecharFluxo(saida);
		}
		return excluido;
	}

	// método para alterar uma moeda
	public boolean alterarMoeda(Moeda moeda) {
		boolean alterado = false;
		try {
			entrada = new BufferedReader(new FileReader(this.arquivo));
			File temp = new File("temp.txt");
			saida = new PrintWriter(new FileWriter(temp));
			String line;
			while ((line = entrada.readLine()) != null) {
				Moeda moeda1= readRecord(line);
				if (moeda1.getAnoCunhagem() == moeda.getAnoCunhagem()) {
					writeRecord(saida, moeda);
					alterado = true;
				}
				else {
					writeRecord(saida, moeda1);
				}
			}
			if (alterado) {
				entrada.close();
				saida.close();
				copiarArquivo(temp, this.arquivo);
				temp.delete();
			}
		} catch (IOException ioe) {
			System.out.println("Erro de leitura ou gravação");
			System.out.println(ioe);
		} finally {
			fecharFluxo(entrada);
			fecharFluxo(saida);
		}
		return alterado;
	}

	// método para listar as moedas
	public Moeda[] listarMoedas() {
		Vector<Moeda> lista = new Vector<Moeda>();
		try {
			entrada = new BufferedReader(new FileReader(this.arquivo));
			String line;
			while ((line = entrada.readLine()) != null) {
				Moeda moeda = readRecord(line);
				lista.add(moeda);
			}
		} catch (IOException e) {
			System.out.println("Erro de leitura");
		} finally {
			fecharFluxo(entrada);
		}
		return vectorToArray(lista);
	}
	
	//------------------------------------------
	//Metodos de apoio
	//------------------------------------------
	
	// método que transforma um vector em um array de moedas
	private Moeda[] vectorToArray(Vector<Moeda> lista) {
		Moeda[] moeda = new Moeda[lista.size()];
		for (int i = 0; i < lista.size(); i++) {
			moeda[i] = lista.get(i);
		}
		return moeda;
	}

	// método para copiar um arquivo para o outro
	private void copiarArquivo(File de, File para) {
		try {
			entrada = new BufferedReader(new FileReader(de));
			saida = new PrintWriter(new FileWriter(para));
			String line;
			while ((line = entrada.readLine()) != null) {
				Moeda moeda= readRecord(line);
				writeRecord(saida, moeda);
			}
		} catch (IOException ioe) {
			System.out.println("Erro de leitura ou gravação");
			System.out.println(ioe);
		} finally {
			fecharFluxo(entrada);
			fecharFluxo(saida);
		}
	}
	
	// método para fechar um fluxo de entrada
	private void fecharFluxo(PrintWriter saida) {
		if (saida != null) {
			saida.close();
		}
	}

	// método para fechar um fluxo de saida
	private void fecharFluxo(BufferedReader entrada) {
		try {
			if (entrada != null) {
				entrada.close();
			}
		} catch (IOException ioe) {
			System.out.println("Erro no fechamento do arquivo");
			System.out.println(ioe);
		}
	}
	
	// método para escrever um registro no arquivo
	private void writeRecord(PrintWriter saida, Moeda moeda) {
		saida.println(moeda.getCodigo()+ "\t" + moeda.getNome() + "\t" + moeda.getAnoCunhagem() + "\t" + moeda.getNacionalidade() 
						+ "\t" + moeda.getValor() + "\t" + moeda.getQuantidade());
		saida.flush();
	}
	
	//método para transformar uma linha do arquivo em um objeto do tipo Moeda
	private Moeda readRecord(String linha) {
		StringTokenizer tokens = new StringTokenizer(linha, "\t\n");
		int codigo = Integer.parseInt(tokens.nextToken());
		String nome = tokens.nextToken();
		int anoCunhagem = Integer.parseInt(tokens.nextToken());
		String nacionalidade = tokens.nextToken();
		int valor = Integer.parseInt(tokens.nextToken());
		int quantidade = Integer.parseInt(tokens.nextToken());
		Moeda moeda = new Moeda(codigo, nome, anoCunhagem, nacionalidade, valor, quantidade);
		return moeda;
	}

}
