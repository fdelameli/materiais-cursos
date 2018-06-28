

/**
 * Classe que representa um ítem de venda.
 * @created 31-mai-2008 11:25:41
 * @author Fabio Dela Bruna
 */
public class ItemVenda {

	//atributos
	
	private Produto produto;
	private int quantidade;
	private double desconto;

	
	//construtores
	
	public ItemVenda(){
		this(new Produto(), 0, 0.0);
	}

	public ItemVenda(Produto produto, int quantidade, double desconto) {
		super();
		this.produto = produto;
		this.quantidade = quantidade;
		this.desconto = desconto;
	}


	//métodos do modelo

	public double totalItemComDesconto(){
		return totalItemSemDesconto() * (1 - this.desconto / 100.0);
	}

	public double totalItemSemDesconto(){
		return this.quantidade * this.produto.getPreco();
	}

	public int incrementaEstoque(){
		return this.produto.incrementaEstoque(this.quantidade);
	}

	public int decrementaEstoque(){
		return this.produto.decrementaEstoque(this.quantidade);
	}

	public int incrementaQuantidade(int qtd){
		return this.quantidade += qtd;
	}

	public int decrementaQuantidade(int qtd){
		return this.quantidade -= qtd;
	}
	
	
	//getters e setters
	
	public double getDesconto() {
		return desconto;
	}

	public void setDesconto(double desconto) {
		this.desconto = desconto;
	}

	public Produto getProduto() {
		return produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}

	public int getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}
	
	
	//método toString()

	public String toString(){
		return this.produto.getDescricao() + 
		"\t" + this.quantidade + 
		"\t" + this.produto.getPreco() + 
		"\t" + this.totalItemSemDesconto() + 
		"\t" + this.totalItemComDesconto();
	}
	
	
	//método equals()
	
	public boolean equals(Object obj){
		if(this == obj){
			return true;
		}else{
			if(obj instanceof ItemVenda){
				return ((ItemVenda) obj).getProduto().equals(this.getProduto());
			}
		}
		return false;
	}

}