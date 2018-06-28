
public class Cd extends Produto {
	
	//atributos
	
	private int numeroFaixas;
	private int duracao;
	
	
	//construtores
	
	public Cd() {
		super();
		this.numeroFaixas = 0;
		this.duracao = 0;
	}

	public Cd(int codigo, String descricao, int qtdEstoque, double preco, int numeroFaixas, int duracao) {
		super(codigo, descricao, qtdEstoque, preco);
		this.numeroFaixas = numeroFaixas;
		this.duracao = duracao;
	}
	
	
	//getters e setters

	public int getNumeroFaixas() {
		return numeroFaixas;
	}

	public void setNumeroFaixas(int numeroFaixas) {
		this.numeroFaixas = numeroFaixas;
	}

	public int getDuracao() {
		return duracao;
	}

	public void setDuracao(int duracao) {
		this.duracao = duracao;
	}
	
	

}
