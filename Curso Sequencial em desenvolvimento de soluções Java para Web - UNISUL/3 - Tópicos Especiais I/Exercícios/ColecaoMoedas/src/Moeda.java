//import java.io.Serializable;


public class Moeda /* implements Serializable */ {

	//atributos
	private int codigo;
	private String nome;
	private String nacionalidade;
	private int anoCunhagem;
	private double valor;
	private int quantidade;
	
	public static final int TAM_REGISTRO = 110;
	public static final int TAM_STRING = 20;
	
	
	//construtor default
	public Moeda() {
		this(0, "", "", 0, 0, 0);
	}

	//construtor com parâmetros
	public Moeda(int codigo, String nome, String nacionalidade, int anoCunhagem, double valor, int quantidade) {
		super();
		this.codigo = codigo;
		this.nome = nome;
		this.nacionalidade = nacionalidade;
		this.anoCunhagem = anoCunhagem;
		this.valor = valor;
		this.quantidade = quantidade;
	}

	
	//getters e setters
	
	public int getCodigo() {
		return codigo;
	}
	
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getAnoCunhagem() {
		return anoCunhagem;
	}

	public void setAnoCunhagem(int anoCunhagem) {
		this.anoCunhagem = anoCunhagem;
	}

	public String getNacionalidade() {
		return nacionalidade;
	}

	public void setNacionalidade(String nacionalidade) {
		this.nacionalidade = nacionalidade;
	}

	public double getValor() {
		return valor;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}

	public int getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}
	
	
	//toString
	
	public String toString() {
		return this.codigo + "\t" + this.nome + "\t" + this.nacionalidade + "\t" +
			this.anoCunhagem + "\t" + this.valor + "\t" + this.quantidade;
	}
	
}
