

public class Moeda{

	private int codigo;
	private String nome;
	private int anoCunhagem;
	private String nacionalidade;
	private int valor;
	private int quantidade;
	
	public static final int TAM_REGISTRO = 70;
	public static final int TAM_STRING = 25;
	
	//construtor
	public Moeda(int codigo, String nome, int anoCunhagem, String nacionalidade, int valor, int quantidade) {
		this.codigo = codigo;
		this.nome = nome;
		this.anoCunhagem = anoCunhagem;
		this.nacionalidade = nacionalidade;
		this.valor = valor;
		this.quantidade = quantidade;
	}
	
	public Moeda() {
		this(0, "", 0, "", 0, 0);
	}
	
	//----------------------------
	//Gets e Sets
	//----------------------------

	public String getNacionalidade() {
		return nacionalidade;
	}
	public void setNacionalidade(String nacionalidade) {
		this.nacionalidade = nacionalidade;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public int getQuantidade() {
		return quantidade;
	}
	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}
	public int getValor() {
		return valor;
	}
	public void setValor(int valor) {
		this.valor = valor;
	}

	public int getAnoCunhagem() {
		return anoCunhagem;
	}

	public void setAnoCunhagem(int anoCunhagem) {
		this.anoCunhagem = anoCunhagem;
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	
	//----------------------------
	// toString
	//---------------------------
	
	public String toString() {
		return codigo+ "\t" + nome + "\t" + anoCunhagem + "\t" + nacionalidade + "\t" + valor + "\t" + quantidade;
	}
}
