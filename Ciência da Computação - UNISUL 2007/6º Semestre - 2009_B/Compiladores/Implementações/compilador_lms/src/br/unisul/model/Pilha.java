package br.unisul.model;

/**
 * Estrutura de Dados Pilha
 */
public class Pilha {
	
	private Integer pilha[];
	private int indice;
	
	public Pilha(){
		inicializa();
	}
	
	/**
	 * Retorna true se estiver vazia e false se estiver cheia
	 * @return valor booleano
	 */
	public boolean estaVazia(){
		
		if (indice==0){
			return true;
		}else{
			return false;
		}	
	
	}
	
	/**
	 * Retorna false se estiver vazia e true se estiver cheia
	 * @return valor booleano
	 */
	public boolean estaCheia(){
		
		if (indice==0){
			return false;
		}else{
			return true;
		}
	
	}
	
	/**
	 * inicializa as variaveis utilizadas pela pilha
	 */
	public void inicializa(){
		pilha = new Integer[1000];
		indice = 0;
	}
	
	/**
	 * Insere um elemento novo na pilha
	 * @param elemento
	 */
	public void insereElemento(int elemento){
		
		pilha[indice] = elemento;	
		indice++;
		
	}
	
	/**
	 * Tira o ultimo elemento da pilha
	 * @return true or false
	 */
	public boolean tiraElemento(){
		
		if (indice == 0){
			return false;
		}else{
			indice--;
			pilha[indice] = null;
			return true;
		}
		
	}
	
	/**
	 * Retorna o elemento do topo da pilha
	 * @return topo
	 */
	public int veTopo(){
		
		return pilha[indice-1];
	}
	
	/**
	 * Retorna um string com todos os elementos da pilha
	 * @return String
	 */
	public String listaPilha(){
		
		String tot = "";
		
		for(int i=0; i<indice; i++){
			tot = tot+pilha[i]+" ";
		}
		
		return tot;
	}
	
}
