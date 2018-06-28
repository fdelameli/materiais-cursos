package br.unisul.trabalho.listas;

import javax.swing.JOptionPane;


/**
 * Representa a lista de produtos vendidos.
 * @author Fabio Dela Bruna.
 * @since 16/03/2008.
 */
public class ListVenda implements IList{

	public Product[] venda;
	public int last;
	private final int TAM = 5;

	
	public ListVenda() {
		this.venda = new Product[TAM];
		this.last = -1;
	}

	
	/**
	 * Busca o produto na lista de compras.
	 * @param nome Nome do produto
	 */
	public Product productAt(String nome){
		for (int i = 0; i < size(); i++) {
			if(nome.equals(venda[i].getNomeProduto())){
				return venda[i];
			}
		}
		return null;
	}

	
	/**
	 * Insere um produto na lista de compras.
	 * @param p Produto a ser inserido.
	 */
	public void insert(Product prod){
		this.last++;
		this.venda[this.last] = prod;
	}

	
	/**
	 * Remove um produto da lista de produtos comprados.
	 * @param p Produto a ser removido.
	 */
	public void remove(String nome) {
		int position = findProduct(nome);
		if(position > -1)
			removeAt(position);
	
		JOptionPane.showMessageDialog(null, "PRODUTO NÃO CADASTRADO!");
	}

	
	/**
	 * Faz o cálculo do total a ser pago pelo cliente.
	 * @return double.
	 */
	public double totalCompra(){
		double total = 0.0;
		for (int i = 0; i < size(); i++) {
			total += venda[i].getValor();
		}
		return total;
	}
	
	
	/**
	 * Remove um produto da lista (ListProducts).
	 * @param position
	 * @throws InvalidPositionException
	 */
	public void removeAt(int position){
		
		for (int i = position; i < this.last; i++){
			this.venda[i] = this.venda[i+1];}
		this.last--;
	}
	
	
	/**
	 * Pega a posição de um determinado elemento na lista.
	 * @param product Produto
	 */
	public int findProduct(String nome) {
		for (int i = 0; i <= this.last; i++) {
			if(this.venda[i].getNomeProduto().equals(nome))
				return i;
		}
		return -1;
	}
	
	
	/**
	 * Mostra todos os elementos comprados até um determinado momento;
	 */
	public void showAll(){
		if(size() > -1){
			for(int i = 0; i < size(); i++){
				JOptionPane.showMessageDialog(null, venda[i].toString());
			}
		}else{
			JOptionPane.showMessageDialog(null, "NENHUMA PRODUTO COMPRADO NO MOMENTO");
		}
	}
	
	
	/**
	 * Soma o total das compras.
	 */
	public double total(){
		double total = 0.0;
		for (int i = 0; i < size(); i++) {
			total += venda[i].getValor();
		}
		return total;
	}
	
	
	/**
	 * Verifica se a lista de compras está vazia.
	 * @return boolean.
	 */
	public boolean isEmpty(){
		return this.last == -1;
	}
	
	
	/**
	 * Retorna o tamanho da lista.
	 */
	public int size(){
		return this.last + 1;
	}
}