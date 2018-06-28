import java.io.*;
import java.util.Vector;


public class ColecaoSerializable implements PersistenciaColecao {

	// atributos
	private File arquivo;
	private ObjectInputStream entrada; 
	private ObjectOutputStream saida; 

	// construtor
	public ColecaoSerializable(String arquivo) {
		this.arquivo = new File(arquivo);
	}

	
	// métodos principais

	@Override
	public boolean inserirMoeda(Moeda moeda){
		boolean inserido = false;
		File temp = new File("temp.ser");
		try {
			this.saida = new ObjectOutputStream(new FileOutputStream(temp));
			this.saida.writeObject(moeda);
			this.saida.flush();
			
			inserido = true;
			
			this.entrada = new ObjectInputStream(new FileInputStream(this.arquivo));
			Moeda moeda1 = null;
			while (true) {
				moeda1 = (Moeda)this.entrada.readObject();
				this.saida.writeObject(moeda1);
				this.saida.flush();
			}
		} catch (EOFException eofe) {
			if (inserido) {
				fecharFluxo(entrada);
				fecharFluxo(saida);
				copiarArquivo(temp, this.arquivo);
			}
		} catch (NotSerializableException e) {
			e.printStackTrace();
		} catch (IOException ioe) {
			System.err.println("Erro de leitura ou gravação");
			System.out.println(ioe);
		} catch (ClassNotFoundException cnfe) {
			System.err.println("Classe desconhecida.");
			System.out.println(cnfe);
		} finally {
			fecharFluxo(this.entrada);
			fecharFluxo(this.saida);
		}
		return inserido;
	}

	@Override
	public Moeda consultarMoeda(int codigo) {
		Moeda moeda = null;
		try {
			this.entrada = new ObjectInputStream(new FileInputStream(this.arquivo));

			Moeda moeda1 = null;
			while (true) {
				moeda1 = (Moeda) this.entrada.readObject();
				if (moeda1.getCodigo() == codigo) {
					moeda = moeda1;
				}
			}
		} catch (EOFException eofe) {
			;
		} catch (IOException ioe) {
			System.err.println("Erro de leitura");
			System.out.println(ioe);
		} catch (ClassNotFoundException cnfe) {
			System.err.println("Erro de classe desconhecida.");
			System.out.println(cnfe);
		} finally {
			fecharFluxo(this.entrada);
		}
		return moeda;
	}

	@Override
	public boolean removerMoeda(int codigo) {
		boolean excluido = false;
		File temp = new File("temp.ser");
		try {
			this.entrada = new ObjectInputStream(new FileInputStream(this.arquivo));
			this.saida = new ObjectOutputStream(new FileOutputStream(temp));

			Moeda moeda = null;
			while (true) {
				moeda = (Moeda) this.entrada.readObject();
				if (moeda.getCodigo() == codigo) {
					excluido = true;
				} else {
					this.saida.writeObject(moeda);
					this.saida.flush();
				}
			}
		} catch (EOFException eofe) {
			if (excluido) {
				fecharFluxo(this.entrada);
				fecharFluxo(this.saida);
				copiarArquivo(temp, this.arquivo);
			}
		} catch (ClassNotFoundException cnfe) {
			System.err.println("Erro de classe desconhecida.");
			System.out.println(cnfe);
		} catch (IOException ioe) {
			System.err.println("Erro de leitura ou gravação");
			System.out.println(ioe);
		} finally {
			fecharFluxo(this.entrada);
			fecharFluxo(this.saida);
		}
		return excluido;
	}

	@Override
	public boolean alterarMoeda(Moeda moeda) {
		boolean alterado = false;
		File temp = new File("temp.ser");
		try {
			this.entrada = new ObjectInputStream(new FileInputStream(this.arquivo));
			this.saida = new ObjectOutputStream(new FileOutputStream(temp));

			Moeda moeda1 = null;
			while (true) {
				moeda1 = (Moeda) this.entrada.readObject();
				if (moeda1.getCodigo() == moeda.getCodigo()) {
					this.saida.writeObject(moeda);
					this.saida.flush();
					alterado = true;
				} else {
					this.saida.writeObject(moeda1);
					this.saida.flush();
				}
			}
		} catch (EOFException eofe) {
			if (alterado) {
				fecharFluxo(this.entrada);
				fecharFluxo(this.saida);
				copiarArquivo(temp, this.arquivo);
			}
		} catch (ClassNotFoundException cnfe) {
			System.err.println("Erro de classe desconhecida.");
			System.out.println(cnfe);
		} catch (IOException ioe) {
			System.err.println("Erro de leitura ou gravação");
			System.out.println(ioe);
		} finally {
			fecharFluxo(this.entrada);
			fecharFluxo(this.saida);
		}
		return alterado;
	}

	@Override
	public Moeda[] listarMoedas() {
		Vector<Moeda> lista = new Vector<Moeda>();
		try {
			this.entrada = new ObjectInputStream(new FileInputStream(this.arquivo));
			Moeda moeda = null;
			while (true) {
				moeda = (Moeda) this.entrada.readObject();
				lista.add(moeda);
			}
		} catch (EOFException eofe) {
			;
		} catch (IOException ioe) {
			System.err.println("Erro de leitura");
			System.out.println(ioe);
		} catch (ClassNotFoundException cnfe) {
			System.err.println("Erro de classe desconhecida.");
			System.out.println(cnfe);
		} finally {
			fecharFluxo(this.entrada);
		}
		return vectorToArray(lista);
	}


	//métodos auxiliares.

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
	 * Método para copiar um arquivo para o outro.
	 * @param origem - arquivo de origem.
	 * @param destino - arquivo de destino.
	 */
	private void copiarArquivo(File origem, File destino) {
		try {
			this.entrada = new ObjectInputStream(new FileInputStream(origem));
			this.saida = new ObjectOutputStream(new FileOutputStream(destino));

			Moeda moeda = null;

			while (true) {
				moeda = (Moeda) this.entrada.readObject();
				this.saida.writeObject(moeda);
				this.saida.flush();
			}
		} catch (EOFException eofe) {
			; 
		} catch (IOException ioe) {
			System.err.println("Erro de leitura ou gravação");
			System.out.println(ioe);
		} catch (ClassNotFoundException cnfe) {
			System.err.println("Classe desconhecida.");
			System.out.println(cnfe);
		} finally {
			fecharFluxo(this.entrada);
			fecharFluxo(this.saida);
		}
	}

	/**
	 * Método para fechar o fluxo de entrada.
	 * @param entrada - fluxo de entrada.
	 */
	private void fecharFluxo(ObjectInputStream entrada) {
		try {
			if (entrada != null) {
				entrada.close();
			}
		} catch (IOException ioe) {
			System.err.println("Erro ao fechar o fluxo de entrada.");
			System.out.println(ioe);
		}
	}

	/**
	 * Método para fechar o fluxo de saida.
	 * @param saida - fluxo de saida.
	 */
	private void fecharFluxo(ObjectOutputStream saida) {
		try {
			if (saida != null) {
				saida.close();
			}
		} catch (IOException ioe) {
			System.err.println("Erro ao fechar o fluxo de saida.");
			System.out.println(ioe);
		}
	}
}
