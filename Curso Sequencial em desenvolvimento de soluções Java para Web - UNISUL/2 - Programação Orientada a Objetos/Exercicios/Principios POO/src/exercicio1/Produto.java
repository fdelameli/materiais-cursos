package exercicio1;

public class Produto {

	// atributos
	
	private long codigo;
	private String nome;
	private int qtdMin;
	private int qtdEstoque;
	private double valorProduto;
	private static double taxa = 5.0;
	
	
	// construtores
	
	public Produto() {
		this(0, null, 0, 0, 0.0);
	}

	public Produto(long codigo, String nome, int qtdMin, int qtdEstoque, double valorProduto) {
		this.codigo = codigo;
		this.nome = nome;
		this.qtdMin = qtdMin;
		this.qtdEstoque = qtdEstoque;
		this.valorProduto = valorProduto;
	}
	
	public Produto(long codigo, String nome) {
		this.codigo = codigo;
		this.nome = nome;
		this.qtdMin = 0;
		this.qtdEstoque = 0;
		this.valorProduto = 0.0;
	}
	
	
	// métodos principais
	
	public int aumentaQtdEstoque(int qtd){
		this.qtdEstoque += qtd;
		return this.qtdEstoque;
	}
	
	public int aumentaQtdEstoque(){
		this.aumentaQtdEstoque(1);
		return qtdEstoque;
	}
	
	public int diminuiQdtEstoque(int qtd){
		if(qtd <= 0){
			mostraErro();
		}else{
			int qtdAux = this.qtdEstoque - qtd;
			if(qtdAux < 0){
				mostraErro();
			}else{
				this.qtdEstoque -= qtd;
			}
		}
		return qtdEstoque;
	}
	
	public int diminuiQdtEstoque(){
		this.diminuiQdtEstoque(1);
		return this.qtdEstoque;
	}
	
	public double aumentaValor(double taxa){
		this.valorProduto *= (1 + taxa/100);
		return valorProduto;
	}
	
	public double aumentaValor(){
		this.aumentaValor(taxa);
		return valorProduto;
	}
	
	public double diminuiValor(double taxa){
		double valorAux = this.valorProduto * (1 - taxa/100);
		if(valorAux <= 0){
			mostraErro();
		}else{
			this.valorProduto += valorAux;
		}
		return this.valorProduto;
	}
	
	public double diminuiValor(){
		this.diminuiValor(taxa);
		return valorProduto;
	}
	
	public boolean qtdAbaixoMin(){
		if(qtdEstoque < qtdMin)
			return true;
		else
			return false;
	}
	
	public boolean estoqueSuficiente(int qtd){
		return this.qtdEstoque >= qtd;
	}
	
	private void mostraErro(){
		System.out.println("ERRO: valor/quantidade deve ser maior que zero!");
	}

	
	// getters e setters
	
	public long getCodigo() {
		return codigo;
	}

	public void setCodigo(long codigo) {
		this.codigo = codigo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getQtdEstoque() {
		return qtdEstoque;
	}

	public void setQtdEstoque(int qtdEstoque) {
		this.qtdEstoque = qtdEstoque;
	}

	public int getQtdMin() {
		return qtdMin;
	}

	public void setQtdMin(int qtdMin) {
		this.qtdMin = qtdMin;
	}

	public double getValorProduto() {
		return valorProduto;
	}

	public void setValorProduto(double valorProduto) {
		this.valorProduto = valorProduto;
	}
	
	
	// equals e toString
	
	public String toString(){
		return ". . :DADOS DO PRODUTO: . .\n" +
				"\nCódigo: " + this.codigo +
				"\nNome: " + this.nome +
				"\nQtd Mínima: " + this.qtdMin +
				"\nQtd Estoque: " + this.qtdEstoque +
				"\nPreço: " + this.valorProduto;
	}
	

	
	public boolean equals(Object obj){
		if(obj instanceof Produto){
			Produto prod = (Produto) obj;
			return this.codigo == prod.codigo
			&& this.nome.equals(prod.nome)
			&& this.qtdMin == prod.qtdMin
			&& this.qtdEstoque == prod.qtdEstoque
			&& this.valorProduto == prod.valorProduto;
		}else{
			return false;
		}
	}
	
	
}
