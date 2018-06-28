import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Vector;


public class MoedaSerializable implements PersistenciaMoeda {

	private File arquivo;
	private ObjectInputStream entrada; 
	private ObjectOutputStream saida; 

	// construtor
	public MoedaSerializable(String arquivo) {
		this.arquivo = new File(arquivo);
	}

	//------------------------------------------
	//Metodos principais
	//------------------------------------------

	// método para inserir uma moeda
	public boolean inserirMoeda(Moeda moeda) {
		boolean inserido = false;
		File temp = new File("temp.ser");
		try {
			saida = new ObjectOutputStream(new FileOutputStream(temp));
			saida.writeObject(moeda);
			saida.flush();
			
			inserido = true;
			
			entrada = new ObjectInputStream(new FileInputStream(arquivo));
			Moeda moeda1 = null;
			while (true) {
				moeda1 = (Moeda) entrada.readObject();
				saida.writeObject(moeda1);
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

	// método para consultar uma moeda
	public Moeda consultarMoeda(int codigo) {
		Moeda moeda = null;
		try {
			entrada = new ObjectInputStream(new FileInputStream(this.arquivo));

			Moeda moeda1 = null;
			while (true) {
				moeda1 = (Moeda) entrada.readObject();
				if (moeda1.getCodigo() == codigo) {
					moeda = moeda1;
				}
			}
		} catch (EOFException eofe) {
			;
		} catch (IOException ioe) {
			System.out.println("Erro de leitura");
			System.out.println(ioe);
		} catch (ClassNotFoundException cnfe) {
			System.out.println("Erro de classe desconhecida.");
			System.out.println(cnfe);
		} finally {
			fecharFluxo(entrada);
		}
		return moeda;
	}

	// método para remover uma moeda
	public boolean removerMoeda(int codigo) {
		boolean excluido = false;
		File temp = new File("temp.ser");
		try {
			entrada = new ObjectInputStream(new FileInputStream(this.arquivo));
			saida = new ObjectOutputStream(new FileOutputStream(temp));

			Moeda moeda = null;
			while (true) {
				moeda = (Moeda) entrada.readObject();
				if (moeda.getCodigo() == codigo) {
					excluido = true;
				} else {
					saida.writeObject(moeda);
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

	// método para alterar uma moeda
	public boolean alterarMoeda(Moeda moeda) {
		boolean alterado = false;
		File temp = new File("temp.ser");
		try {
			entrada = new ObjectInputStream(new FileInputStream(this.arquivo));
			saida = new ObjectOutputStream(new FileOutputStream(temp));

			Moeda moeda1 = null;
			while (true) {
				moeda1 = (Moeda) entrada.readObject();
				if (moeda1.getCodigo() == moeda.getCodigo()) {
					saida.writeObject(moeda);
					saida.flush();
					alterado = true;
				} else {
					saida.writeObject(moeda1);
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

	// método para listar as moedas
	public Moeda[] listarMoedas() {
		Vector<Moeda> lista = new Vector<Moeda>();
		try {
			entrada = new ObjectInputStream(new FileInputStream(this.arquivo));
			Moeda moeda = null;
			while (true) {
				moeda = (Moeda) entrada.readObject();
				lista.add(moeda);
			}
		} catch (EOFException eofe) {
			;
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

	//------------------------------------------
	//Metodos de apoio
	//------------------------------------------

	// método para transformar um vector em um array de moedas
	private Moeda[] vectorToArray(Vector<Moeda> lista) {
		Moeda[] moedas = new Moeda[lista.size()];
		for (int i = 0; i < lista.size(); i++) {
			moedas[i] = lista.get(i);
		}
		return moedas;
	}

	// método para copiar um arquivo para o outro
	private void copiarArquivo(File de, File para) {
		try {
			entrada = new ObjectInputStream(new FileInputStream(de));
			saida = new ObjectOutputStream(new FileOutputStream(para));

			Moeda moeda = null;

			while (true) {
				moeda = (Moeda) entrada.readObject();
				saida.writeObject(moeda);
				saida.flush();
			}
		} catch (EOFException eofe) {
			; 
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
