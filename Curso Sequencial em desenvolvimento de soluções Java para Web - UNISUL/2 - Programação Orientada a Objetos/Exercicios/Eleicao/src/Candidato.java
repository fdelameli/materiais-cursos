
/**
 * Classe que representa um candidato.
 * @author Fabio Dela Bruna
 * @created 31-mai-2008 16:29:20
 */
public class Candidato {

	//atributos
	
	private int numero;
	private String nome;
	private int quantidadeVotos;
	private Partido partido;

	
	//construtores
	
	public Candidato(){
		this(0, "", new Partido());
	}

	public Candidato(int numero, String nome, Partido partido) {
		super();
		this.numero = numero;
		this.nome = nome;
		this.quantidadeVotos = 0;
		this.partido = partido;
	}


	//métodos do modelo

	public void adicionaVoto(){
		this.quantidadeVotos++;
	}

	
	//getters e setters
	
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public Partido getPartido() {
		return partido;
	}

	public void setPartido(Partido partido) {
		this.partido = partido;
	}

	public int getQuantidadeVotos() {
		return quantidadeVotos;
	}

	public void setQuantidadeVotos(int quantidadeVotos) {
		this.quantidadeVotos = quantidadeVotos;
	}
	
}