import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Vector;

public class AcademiaAleatorio implements PersistenciaAcademia {

	// atributos
	private File arquivo;
	private RandomAccessFile arquivoAleatorio;

	// construtor
	public AcademiaAleatorio(String arquivo) {
		try {
			this.arquivo = new File(arquivo);
			this.arquivoAleatorio = new RandomAccessFile(this.arquivo, "rw");
			if (arquivoAleatorio.length() == 0) { // preenche o arquivo com valores default dos atletas
				for (int i = 1; i <= 10; i++) {   // executado apenas quando o arquivo estiver vazio (10 registros)
					Atleta atleta = new Atleta();
					writeRecord(this.arquivoAleatorio, atleta, i);
				}
			}
		} catch (FileNotFoundException fnfe) {
			System.out.println("Arquivo não encontrado.");
			System.out.println(fnfe);
		} catch (IOException ioe) {
			System.out.println("Erro na gravação");
			System.out.println(ioe);
		} finally {
			fecharArquivo(arquivoAleatorio);
		}
	}

	// método para inserir um atleta
	public boolean inserirAtleta(Atleta atleta) {
		boolean inserido = false;
		try {
			arquivoAleatorio = new RandomAccessFile(this.arquivo, "rw");
			writeRecord(arquivoAleatorio, atleta, atleta.getCodigo());
				// caso já tenha um registro com o mesmo código, sobrescreve
			inserido = true;
		} catch (IOException ioe) {
			System.out.println("Erro de leitura ou gravação");
			System.out.println(ioe);
		} finally {
			fecharArquivo(arquivoAleatorio);
		}
		return inserido;
	}

	// método para consultar um atleta
	public Atleta consultarAtleta(int codigo) {
		Atleta atleta = null;
		try {
			arquivoAleatorio = new RandomAccessFile(this.arquivo, "rw");
			Atleta atleta1 = readRecord(arquivoAleatorio, codigo);
			if (atleta1.getCodigo() != 0) {
				atleta = atleta1;
			}
		} catch (IOException ioe) {
			System.out.println("Erro de leitura");
			System.out.println(ioe);
		} finally {
			fecharArquivo(arquivoAleatorio);
		}
		return atleta;
	}

	// método para excluir um contato
	public boolean removerAtleta(int codigo) {
		boolean excluido = false;
		try {
			arquivoAleatorio = new RandomAccessFile(this.arquivo, "rw");
			Atleta atleta = readRecord(arquivoAleatorio, codigo);
			if (atleta.getCodigo() != 0) {
				writeRecord(arquivoAleatorio, new Atleta(), codigo);
				excluido = true;
			}
		} catch (IOException ioe) {
			System.out.println("Erro de leitura ou gravação");
			System.out.println(ioe);
		} finally {
			fecharArquivo(arquivoAleatorio);
		}
		return excluido;
	}

	// método para alterar um contato
	public boolean alterarAtleta(Atleta atleta) {
		boolean alterado = false;
		try {
			arquivoAleatorio = new RandomAccessFile(this.arquivo, "rw");
			Atleta atleta1 = readRecord(arquivoAleatorio, atleta.getCodigo());
			if (atleta1.getCodigo() != 0) {
				writeRecord(arquivoAleatorio, atleta, atleta.getCodigo());
				alterado = true;
			}
		} catch (IOException ioe) {
			System.out.println("Erro de leitura ou gravação");
			System.out.println(ioe);
		} finally {
			fecharArquivo(arquivoAleatorio);
		}
		return alterado;
	}

	// método para retornar todos atletas
	public Atleta[] listarAtletas() {
		Vector<Atleta> lista = new Vector<Atleta>();
		try {
			arquivoAleatorio = new RandomAccessFile(this.arquivo, "rw");
			for (int i = 1; i <= 10; i++) {
				Atleta atleta = readRecord(arquivoAleatorio, i);
				if (atleta.getCodigo() != 0) {
					lista.add(atleta);
				}
			}
		} catch (IOException e) {
			System.out.println("Erro de leitura");
		} finally {
			fecharArquivo(arquivoAleatorio);
		}
		System.out.println("Tamanho fina: " + arquivo.length());
		return vectorToArray(lista);
	}

	// método que transforma um vector em um array de atletas
	private Atleta[] vectorToArray(Vector<Atleta> lista) {
		Atleta[] atletas = new Atleta[lista.size()];
		for (int i = 0; i < lista.size(); i++) {
			atletas[i] = lista.get(i);
		}
		return atletas;
	}

	// método que lê uma string de tamanho específico de um arquivo
	private String readString(RandomAccessFile arquivo, int tamanho) throws IOException {
		char string[] = new char[tamanho];
		for (int i = 0; i < tamanho; i++) {
			string[i] = arquivo.readChar();
		}
		String temp = new String(string);
		return temp.trim(); // elimina os espaços em branco depois dos demais caracteres
	}

	// método que escreve uma string de tamanho específico para um arquivo
	private void writeString(RandomAccessFile arquivo, String string, int tamanho) throws IOException {
		StringBuffer buffer = null;
		if (string != null) {
			buffer = new StringBuffer(string);
		}
		else {
			buffer = new StringBuffer(tamanho);
		}
		buffer.setLength(tamanho);
		arquivo.writeChars(buffer.toString());
	}

	// método para escrever um registro para o arquivo
	private void writeRecord(RandomAccessFile arquivo, Atleta atleta, int posicao) throws IOException {
		arquivo.seek((posicao - 1) * Atleta.TAM_REGISTRO); // posiciona o ponteiro no local certo
		arquivo.writeInt(atleta.getCodigo()); // escreve o código
		writeString(arquivo, atleta.getNome(), Atleta.TAM_NOME); // escreve o nome
		arquivo.writeDouble(atleta.getAltura()); // escreve a altura
	}

	// método para ler um registro do arquivo
	private Atleta readRecord(RandomAccessFile arquivo, int posicao) throws IOException {
		arquivo.seek((posicao - 1) * Atleta.TAM_REGISTRO); //posiciona o ponteiro no locar certo
		int codigo = arquivo.readInt(); // lê o código
		String nome = readString(arquivo, Atleta.TAM_NOME); // lê o nome
		double altura = arquivo.readDouble(); // lê a altura
		Atleta atleta = new Atleta(codigo, nome, altura);
		return atleta;
	}

	// método para fechar um arquivo de acesso aleatório
	private void fecharArquivo(RandomAccessFile arquivo) {
		try {
			if (arquivo != null) {
				arquivo.close();
			}
		} catch (IOException ioe) {
			System.out.println("Erro no fechamento do arquivo.");
			System.out.println(ioe);
		}
	}	
}