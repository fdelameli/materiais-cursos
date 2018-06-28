
public class Dvd extends Produto {
	
	//atributos
	
	private int duracao;
	
	
	//construtores
	
	public Dvd() {
		super();
		this.duracao = 0;
	}

	public Dvd(int codigo, String descricao, int qtdEstoque, double preco, int duracao) {
		super(codigo, descricao, qtdEstoque, preco);
		this.duracao = duracao;
	}

	
	//getters e setters
	
	public int getDuracao() {
		return duracao;
	}

	public void setDuracao(int duracao) {
		this.duracao = duracao;
	}
	

}
