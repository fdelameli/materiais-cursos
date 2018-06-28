

/**
 * Clase que representa um Produto.
 * @created 31-mai-2008 11:25:42
 * @author Fabio Dela Bruna
 */
public class Produto {
	
	//atributos

	private int codigo;
	private String descricao;
	private int qtdEstoque;
	private double preco;

	
	//construtores
	
	public Produto(){
		this(0, "", 0, 0.0);
	}

	public Produto(int codigo, String descricao, int qtdEstoque, double preco) {
		super();
		this.codigo = codigo;
		this.descricao = descricao;
		this.qtdEstoque = qtdEstoque;
		this.preco = preco;
	}


	//métodos do modelo

	public int decrementaEstoque(int qtd){
		return 0;
	}

	public int incrementaEstoque(int qtd){
		return 0;
	}

	
	//getters e setters
	
	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public double getPreco() {
		return preco;
	}

	public void setPreco(double preco) {
		this.preco = preco;
	}

	public int getQtdEstoque() {
		return qtdEstoque;
	}

	public void setQtdEstoque(int qtdEstoque) {
		this.qtdEstoque = qtdEstoque;
	}
	
	
	//método equals()
	
	public boolean equals(Object obj){
		if(this == obj){
			return true;
		}else{
			if(obj instanceof Produto){
				Produto prod = (Produto) obj;
				return this.codigo == prod.codigo;
			}
		}
		return false;
	}
	
	
	//método toString()
	
	
	
}