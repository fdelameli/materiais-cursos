import java.io.*;
import java.util.Vector;

public class AcademiaSerializable implements PersistenciaAcademia {

	// atributos
	private File arquivo; // arquivo
	private ObjectInputStream entrada; // fluxo de entrada
	private ObjectOutputStream saida; // fluxo de saída

	// construtor
	public AcademiaSerializable(String arquivo) {
		this.arquivo = new File(arquivo);
	}

	// método para inserir um atleta
	public boolean inserirAtleta(Atleta atleta) {
		boolean inserido = false;
		File temp = new File("temp.ser");
		try {
			saida = new ObjectOutputStream(new FileOutputStream(temp));
			saida.writeObject(atleta);
			saida.flush();
			
			inserido = true;
			
			entrada = new ObjectInputStream(new FileInputStream(arquivo));
			Atleta atleta1 = null;
			while (true) { // copia cada um dos atletas para o arquivo temporário
				atleta1 = (Atleta) entrada.readObject();
				saida.writeObject(atleta1);
				saida.flush();
			}
		} catch (EOFException eofe) {
			if (inserido) {
				fecharFluxo(entrada);
				fecharFluxo(saida);
				copiarArquivo(temp, this.arquivo);
			}
		} catch (IOException ioe) {
			System.out.println("Erro de leitura ou gravação");
			System.out.println(ioe);
		} catch (ClassNotFoundException cnfe) {
			System.out.println("Classe desconhecida.");
			System.out.println(cnfe);
		} finally {
			fecharFluxo(entrada);
			fecharFluxo(saida);
		}
		return inserido;
	}

	// método para consultar um atleta
	public Atleta consultarAtleta(int codigo) {
		Atleta atleta = null;
		try {
			entrada = new ObjectInputStream(new FileInputStream(this.arquivo));

			Atleta atleta1 = null;
			while (true) {
				atleta1 = (Atleta) entrada.readObject();
				if (atleta1.getCodigo() == codigo) {
					atleta = atleta1;
				}
			}
		} catch (EOFException eofe) {
			; // não faz nada. É apenas o mecanismo para sair
		} catch (IOException ioe) {
			System.out.println("Erro de leitura");
			System.out.println(ioe);
		} catch (ClassNotFoundException cnfe) {
			System.out.println("Erro de classe desconhecida.");
			System.out.println(cnfe);
		} finally {
			fecharFluxo(entrada);
		}
		return atleta;
	}

	// método para remover um atleta
	public boolean removerAtleta(int codigo) {
		boolean excluido = false;
		File temp = new File("temp.ser");
		try {
			entrada = new ObjectInputStream(new FileInputStream(this.arquivo));
			saida = new ObjectOutputStream(new FileOutputStream(temp));

			Atleta atleta = null;
			while (true) {
				atleta = (Atleta) entrada.readObject();
				if (atleta.getCodigo() == codigo) {
					excluido = true;
				} else {
					saida.writeObject(atleta);
					saida.flush();
				}
			}
		} catch (EOFException eofe) {
			if (excluido) {
				fecharFluxo(entrada);
				fecharFluxo(saida);
				copiarArquivo(temp, this.arquivo);
			}
		} catch (ClassNotFoundException cnfe) {
			System.out.println("Erro de classe desconhecida.");
			System.out.println(cnfe);
		} catch (IOException ioe) {
			System.out.println("Erro de leitura ou gravação");
			System.out.println(ioe);
		} finally {
			fecharFluxo(entrada);
			fecharFluxo(saida);
		}
		return excluido;
	}

	// método para alterar um atleta
	public boolean alterarAtleta(Atleta atleta) {
		boolean alterado = false;
		File temp = new File("temp.ser");
		try {
			entrada = new ObjectInputStream(new FileInputStream(this.arquivo));
			saida = new ObjectOutputStream(new FileOutputStream(temp));

			Atleta atleta1 = null;
			while (true) {
				atleta1 = (Atleta) entrada.readObject();
				if (atleta1.getCodigo() == atleta.getCodigo()) {
					saida.writeObject(atleta);
					saida.flush();
					alterado = true;
				} else {
					saida.writeObject(atleta1);
					saida.flush();
				}
			}
		} catch (EOFException eofe) {
			if (alterado) {
				fecharFluxo(entrada);
				fecharFluxo(saida);
				copiarArquivo(temp, this.arquivo);
			}
		} catch (ClassNotFoundException cnfe) {
			System.out.println("Erro de classe desconhecida.");
			System.out.println(cnfe);
		} catch (IOException ioe) {
			System.out.println("Erro de leitura ou gravação");
			System.out.println(ioe);
		} finally {
			fecharFluxo(entrada);
			fecharFluxo(saida);
		}
		return alterado;
	}

	// método para retornar todos os atletas
	public Atleta[] listarAtletas() {
		Vector<Atleta> lista = new Vector<Atleta>();
		try {
			entrada = new ObjectInputStream(new FileInputStream(this.arquivo));
			Atleta atleta = null;
			while (true) {
				atleta = (Atleta) entrada.readObject();
				lista.add(atleta);
			}
		} catch (EOFException eofe) {
			; // não faz nada. É apenas o mecanismo para sair
		} catch (IOException ioe) {
			System.out.println("Erro de leitura");
			System.out.println(ioe);
		} catch (ClassNotFoundException cnfe) {
			System.out.println("Erro de classe desconhecida.");
			System.out.println(cnfe);
		} finally {
			fecharFluxo(entrada);
		}
		return vectorToArray(lista);
	}

	// método para transformar um vector em um array de atletas
	private Atleta[] vectorToArray(Vector<Atleta> lista) {
		Atleta[] atletas = new Atleta[lista.size()];
		for (int i = 0; i < lista.size(); i++) {
			atletas[i] = lista.get(i);
		}
		return atletas;
	}

	// método para copiar um arquivo para o outro
	private void copiarArquivo(File de, File para) {
		try {
			entrada = new ObjectInputStream(new FileInputStream(de));
			saida = new ObjectOutputStream(new FileOutputStream(para));

			Atleta atleta = null;

			while (true) {
				atleta = (Atleta) entrada.readObject();
				saida.writeObject(atleta);
				saida.flush();
			}
		} catch (EOFException eofe) {
			; // não faz nada. É apenas o mecanismo para sair 
		} catch (IOException ioe) {
			System.out.println("Erro de leitura ou gravação");
			System.out.println(ioe);
		} catch (ClassNotFoundException cnfe) {
			System.out.println("Classe desconhecida.");
			System.out.println(cnfe);
		} finally {
			fecharFluxo(entrada);
			fecharFluxo(saida);
		}
	}

	// método para fechar o fluxo de entrada
	private void fecharFluxo(ObjectInputStream entrada) {
		try {
			if (entrada != null) {
				entrada.close();
			}
		} catch (IOException ioe) {
			System.out.println("Erro ao fechar o fluxo de entrada.");
			System.out.println(ioe);
		}
	}

	// método para fechar o fluxo de saida
	private void fecharFluxo(ObjectOutputStream saida) {
		try {
			if (saida != null) {
				saida.close();
			}
		} catch (IOException ioe) {
			System.out.println("Erro ao fechar o fluxo de saida.");
			System.out.println(ioe);
		}
	}
}