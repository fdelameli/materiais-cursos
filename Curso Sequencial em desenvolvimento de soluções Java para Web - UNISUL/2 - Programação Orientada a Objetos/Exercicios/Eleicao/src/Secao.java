import java.util.ArrayList;

/**
 * Classe que representa uma seção eleitoral.
 * @author Fabio Dela Bruna
 * @created 31-mai-2008 16:29:21
 */
public class Secao {

	//atributos
	
	private int numero;
	private String nome;
	private ArrayList<Eleitor> eleitores;

	
	//construtores
	
	public Secao(){
		this(0, "", new ArrayList<Eleitor>());
	}

	public Secao(int numero, String nome, ArrayList<Eleitor> eleitores) {
		super();
		this.numero = numero;
		this.nome = nome;
		this.eleitores = new ArrayList<Eleitor>();
	}


	//métodos principais

	public boolean incluiEleitor(Eleitor eleitor){
		this.eleitores.add(eleitor);
		return true;
	}

	
	public boolean exluiEleitor(Eleitor eleitor){
		this.eleitores.remove(eleitor);
		return true;
	}


	//getters e setters
	
	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public ArrayList<Eleitor> getEleitores() {
		return eleitores;
	}

	public void setEleitores(ArrayList<Eleitor> eleitores) {
		this.eleitores = eleitores;
	}
	
}