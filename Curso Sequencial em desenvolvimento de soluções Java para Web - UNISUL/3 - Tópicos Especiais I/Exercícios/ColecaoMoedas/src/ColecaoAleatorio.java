import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Vector;


public class ColecaoAleatorio implements PersistenciaColecao {

	//atributos
	private File arquivo;
	private RandomAccessFile arquivoAleatorio;
	
	
	//construtor
	public ColecaoAleatorio(String arquivo) {
		try {
			this.arquivo = new File(arquivo);
			this.arquivoAleatorio = new RandomAccessFile(this.arquivo, "rw");
			if (arquivoAleatorio.length() == 0) {
				for (int i = 1; i <=10; i++) {
					Moeda moeda = new Moeda();
					writeRecord(this.arquivoAleatorio, moeda, i);
				}
			}
		} catch (FileNotFoundException fnfe) {
			System.err.println("Arquivo não encontrado!");
			System.out.println(fnfe);
		} catch (IOException ioe) {
			System.err.println("Erro na gravação!");
			System.out.println(ioe);
		} finally {
			fecharArquivo(arquivoAleatorio);
		}
	}
	
	
	//métodos principais
	
	@Override
	public boolean alterarMoeda(Moeda moeda) {
		boolean alterado = false;
		try {
			arquivoAleatorio = new RandomAccessFile(this.arquivo, "rw");
			Moeda tempMoeda = readRecord(arquivoAleatorio, moeda.getCodigo());
			if (tempMoeda.getCodigo() != 0) {
				writeRecord(arquivoAleatorio, moeda, moeda.getCodigo());
				alterado = true;
			}
		} catch (IOException ioe) {
			System.err.println("Erro de leitura ou gravação!");
			System.out.println(ioe);
		} finally {
			fecharArquivo(arquivoAleatorio);
		}
		return alterado;
	}

	@Override
	public Moeda consultarMoeda(int codigo) {
		Moeda moeda = null;
		try {
			arquivoAleatorio = new RandomAccessFile(this.arquivo, "rw");
			Moeda tempMoeda = readRecord(arquivoAleatorio, codigo);
			if (tempMoeda.getCodigo() != 0) {
				moeda = tempMoeda;
			}
		} catch (IOException ioe) {
			System.err.println("Erro de leitura!");
			System.out.println(ioe);
		} finally {
			fecharArquivo(arquivoAleatorio);
		}
		return moeda;
	}

	@Override
	public boolean inserirMoeda(Moeda moeda) {
		boolean inserido = false;
		try {
			arquivoAleatorio = new RandomAccessFile(this.arquivo, "rw");
			writeRecord(arquivoAleatorio, moeda, moeda.getCodigo());
			inserido = true;
		} catch (IOException ioe) {
			System.err.println("Erro de leitura ou gravação!");
			System.out.println(ioe);
		} finally {
			fecharArquivo(arquivoAleatorio);
		}
		return inserido;
	}

	@Override
	public Moeda[] listarMoedas() {
		Vector<Moeda> lista = new Vector<Moeda>();
		try {
			arquivoAleatorio = new RandomAccessFile(this.arquivo, "rw");
			for (int i = 1; i <= 10; i++) {
				Moeda moeda = readRecord(arquivoAleatorio, i);
				if (moeda.getCodigo() != 0) {
					lista.add(moeda);
				}
			}
		} catch (IOException ioe) {
			System.err.println("Erro de Leitura!");
		} finally {
			fecharArquivo(arquivoAleatorio);
		}
		return vectorToArray(lista);
	}

	@Override
	public boolean removerMoeda(int codigo) {
		boolean excluido = false;
		try {
			this.arquivoAleatorio = new RandomAccessFile(this.arquivo, "rw");
			Moeda moeda = readRecord(this.arquivoAleatorio, codigo);
			if (moeda.getCodigo() != 0) {
				writeRecord(this.arquivoAleatorio, new Moeda(), codigo);
				excluido = true;
			}
		} catch (IOException ioe) {
			System.err.println("Erro de leitura ou gravação!");
			System.out.println(ioe);
		} finally {
			fecharArquivo(this.arquivoAleatorio);
		}
		return excluido;
	}
	
	
	//métodos auxiliares

	/**
	 * Método que transforma um vetor em um array de moedas.
	 * @param lista - vetor de moedas.
	 * @return - array de moedas.
	 */
	private Moeda[] vectorToArray(Vector<Moeda> lista) {
		Moeda[] moedas = new Moeda[lista.size()];
		for (int i = 0; i < lista.size(); i++) {
			moedas[i] = lista.get(i);
		}
		return moedas;
	}
	
	/**
	 * Método que lê uma string de tamanho específico de um arquivo.
	 * @param arquivo - arquivo de um arquivo.
	 * @param tamanho - tamanho da string.
	 * @return - String contendo os dados.
	 * @throws IOException
	 */
	private String readString(RandomAccessFile arquivo, int tamanho) throws IOException {
		char string[] = new char[tamanho];
		for (int i = 0; i < tamanho; i++) {
			string[i] = arquivo.readChar();
		}
		String aux = new String(string);
		return aux.trim();
	}
	
	/**
	 * Método que escreve uma string de tamanho específico para um arquivo.
	 * @param arquivo - arquivo a ser gravado.
	 * @param string - String contendo os dados.
	 * @param tamanho - tamanho da String.
	 * @throws IOException
	 */
	private void writeString(RandomAccessFile arquivo, String string, int tamanho) throws IOException {
		StringBuffer buffer = null;
		if (string != null) {
			buffer = new StringBuffer(string);
		} else {
			buffer = new StringBuffer(tamanho);
		}
		buffer.setLength(tamanho);
		arquivo.writeChars(buffer.toString());
	}
	
	/**
	 * Método para escrever um registro para o arquivo.
	 * @param arquivo - arquivo a ser gravado.
	 * @param moeda - moeda contendo os dados.
	 * @param posicao - posição no arquivo.
	 * @throws IOException
	 */
	private void writeRecord(RandomAccessFile arquivo, Moeda moeda, int posicao) throws IOException {
		arquivo.seek((posicao - 1) * Moeda.TAM_REGISTRO);
		arquivo.writeInt(moeda.getCodigo());
		writeString(arquivo, moeda.getNome(), Moeda.TAM_STRING);
		writeString(arquivo, moeda.getNacionalidade(), Moeda.TAM_STRING);
		arquivo.writeInt(moeda.getAnoCunhagem());
		arquivo.writeDouble(moeda.getValor());
		arquivo.writeInt(moeda.getQuantidade());
	}
	
	/**
	 * Método para ler um registro do arquivo.
	 * @param arquivo - arquivo a ser lido.
	 * @param posicao - posição no arquivo.
	 * @return - Objeto do tipo Moeda.
	 * @throws IOException
	 */
	private Moeda readRecord(RandomAccessFile arquivo, int posicao) throws IOException {
		arquivo.seek((posicao - 1) * Moeda.TAM_REGISTRO);
		int codigo = arquivo.readInt();
		String nome = readString(arquivo, Moeda.TAM_STRING);
		String nacionalidade = readString(arquivo, Moeda.TAM_STRING);
		int anoCunhagem = arquivo.readInt();
		double valor = arquivo.readDouble();
		int quantidade = arquivo.readInt();
		Moeda moeda = new Moeda(codigo, nome, nacionalidade, anoCunhagem, valor, quantidade);
		return moeda;
	}
	
	/**
	 * Método para fechar um arquivo de acesso aleatório.
	 * @param arquivo - Arquivo a ser fechado.
	 */
	private void fecharArquivo(RandomAccessFile arquivo) {
		try {
			if (arquivo != null) {
				arquivo.close();
			}
		} catch (IOException ioe) {
			System.err.println("Erro no fechamento do arquivo!");
			System.out.println(ioe);
		}
	}
}