package br.unisul.trabalho.listas;

import javax.swing.JOptionPane;


/**
 * Representa a lista de produtos cadastrados (ListProducts).
 * @author Fabio Dela Bruna.
 * @since 15/03/2008.
 */
public class ListProducts implements IList {

	public Product[] products;
	private int last;
	private final int TAM = 5;

	
	public ListProducts() {
		products = new Product[TAM];
		last = -1;
	}
	
	
	/**
	 * Busca o produto na lista de produtos cadastrados.
	 * @param nome Nome do produto
	 */
	public Product productAt(String nome){
		for (int i = 0; i < size(); i++){
			if(nome.equals(products[i].getNomeProduto())){
				return products[i];
			}
		}
		return null;
	}

	
	/**
	 * Insere um produto na lista (sempre na última posição da lista).
	 * @param prod - Produto a ser inserido.
	 */
	public void insert(Product prod) {
		this.last++;
		this.products[this.last] = prod;
	}

	
	/**
	 * Remove um produto da lista de produtos cadastrados.
	 * @param p Produto a ser removido.
	 */
	public void remove(String nome) {
		int position = findProduct(nome);
		if(position > -1)
			removeAt(position);
		
		JOptionPane.showMessageDialog(null, "PRODUTO NÃO CADASTRADO!");
	}

	
	/**
	 * Remove um produto da lista (ListProducts).
	 */
	public void removeAt(int position){
		
		for (int i = position; i < this.last; i++){
			this.products[i] = this.products[i+1];}
		this.last--;
	}
	
	
	/**
	 * Pega a posição de um determinado elemento na lista.
	 * @param product Produto
	 */
	public int findProduct(String nome) {
		for (int i = 0; i <= this.last; i++) {
			if(this.products[i].getNomeProduto().equals(nome))
				return i;
		}
		return -1;
	}

	
	
	/**
	 * Mostra todos os produtos cadastrados.
	 */
	public void showAll(){
		if(size() > -1){
			for (int i = 0; i < size(); i++){
				JOptionPane.showMessageDialog(null, products[i].toString());
			}
		}else{
			JOptionPane.showMessageDialog(null, "NENHUM PRODUTO CADASTRADO!");
		}
	}
	
	
	/**
	 * Verifica se a lista de produtos cadastrados está vazia.
	 */
	public boolean isEmpty() {
		return last == -1;
	}
	
	
	/**
	 * Retorna o tamanho da lista.
	 */
	public int size(){
		return this.last + 1;
	}
	
}