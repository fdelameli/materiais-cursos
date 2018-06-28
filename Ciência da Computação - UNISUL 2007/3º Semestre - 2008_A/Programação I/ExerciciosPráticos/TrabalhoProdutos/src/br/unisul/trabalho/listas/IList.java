package br.unisul.trabalho.listas;


/**
 * Interface IList.
 * @author Fabio Dela Bruna
 * @since 	14/03/2008
 */
public interface IList {

	
	/**
	 * Insere um produto em ListProducts.
	 * @param prod - Produto.
	 */
	public abstract void insert(Product prod);
	
	
	/**
	 * Remoção de produto.
	 * @param prod - Produto.
	 */
	public abstract void remove(String prod);
	
	
	/**
	 * Efetua a busca de um produto em ListProducts.
	 * @param nome Nome do produto.
	 */
	public abstract Product productAt(String nome);
	
	
	/**
	 * Retorna a posição de um determinado elemento na lista.
	 * @param nome - Nome do produto.
	 */
	public abstract int findProduct(String nome);
	
	
	/**
	 * Mostra todos os produtos em uma determinada lista;
	 * ListProducts ou ListVenda.
	 */
	public abstract void showAll();
	
	
	/**
	 * Remove um elemento de uma determinada lista;
	 * @param position - Posição do elemento na lista.
	 */
	public abstract void removeAt(int position);
	
	
	/**
	 * Verifica a lista ListProducts está vazia.
	 */
	public abstract boolean isEmpty();
	
	
	/**
	 * Retorna o tamanho da lista
	 */
	public int size();
	
}