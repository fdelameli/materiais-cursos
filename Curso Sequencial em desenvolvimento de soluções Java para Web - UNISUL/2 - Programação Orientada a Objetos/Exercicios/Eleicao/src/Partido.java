
/**
 * Classe que representa um Partido.
 * @author Fabio Dela Bruna
 * @created 31-mai-2008 16:29:21
 */
public class Partido {

	//atributos
	
	private int numero;
	private String sigla;
	private String nome;
	private int quantidadeVotos;

	
	//construtores
	
	public Partido(){
		this(0, "", "", 0);
	}

	public Partido(int numero, String sigla, String nome, int quantidadeVotos) {
		super();
		this.numero = numero;
		this.sigla = sigla;
		this.nome = nome;
	}


	//métodos principais

	public void adicionaVoto(){
		this.quantidadeVotos++;
	}

	
	//getters e setters
	
	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public String getSigla() {
		return sigla;
	}

	public void setSigla(String sigla) {
		this.sigla = sigla;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getQuantidadeVotos() {
		return quantidadeVotos;
	}

	public void setQuantidadeVotos(int quantidadeVotos) {
		this.quantidadeVotos = quantidadeVotos;
	}

	
}