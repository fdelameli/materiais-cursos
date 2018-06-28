package br.unisul.model;

/**
 * Classe responsável pela Tabela de Simbolos e Métodos de Exclusão, Inserção e Busca
 */

public class TabelaSimbolos {

	/**
	 * variaveis globais
	 */
	private String tabela[][];

	private int pt_livre;
	private int nivelMax;

	/**
	 * Construtor da TS
	 */
	public TabelaSimbolos() {
		nivelMax =0;
		pt_livre = 0;
		tabela = new String[2000][5];
	}

	/**
	 * Método de Busca da TS
	 * 
	 * @param nome
	 * @return o indice do nome procurado
	 */
	public int busca(String nome) {

		for (int i = (pt_livre - 1); i >= 0; i--) {
			if (tabela[i][0] != null) {
				if (nome.equals(tabela[i][0])) {
					return i;
				}
			}
		}

		return -1;
	}

	/**
	 * Método de Inserção da TS
	 * 
	 * @param nome
	 * @param categoria
	 * @param nivel
	 * @param geral_a
	 * @param geral_b
	 * @return verdadeiro caso o identificado não estiver na tabela e false caso
	 *         ele ja esteja declarado e no mesmo nivel
	 */
	public boolean insercao(String nome, String categoria, String nivel,
			String geral_a, String geral_b) {

		int index = busca(nome);
		
		if (index == -1) {
			tabela[pt_livre][0] = nome;
			tabela[pt_livre][1] = categoria;
			tabela[pt_livre][2] = nivel;
			tabela[pt_livre][3] = geral_a;
			tabela[pt_livre][4] = geral_b;
			pt_livre++;
			
			int n= Integer.parseInt(nivel);
			if (n>nivelMax){
				nivelMax=n;
			}
			
		} else {
			if (tabela[index][2].compareTo(nivel) == 0) {
				return false;
			} else {
				tabela[pt_livre][0] = nome;
				tabela[pt_livre][1] = categoria;
				tabela[pt_livre][2] = nivel;
				tabela[pt_livre][3] = geral_a;
				tabela[pt_livre][4] = geral_b;
				pt_livre++;
			}
		}
		
		return true;
	}

	public void altera(int indice, String nome, String categoria, String nivel,
		String geral_a, String geral_b) {
		tabela[indice][0] = nome;
		tabela[indice][1] = categoria;
		tabela[indice][2] = nivel;
		tabela[indice][3] = geral_a;
		tabela[indice][4] = geral_b;
		
		int n= Integer.parseInt(nivel);
		if (n>nivelMax){
			nivelMax=n;
		}
	}

	/**
	 * Método de Deleção da TS
	 * 
	 * @return elementos removidos
	 */
	public void delecao() {

		int nivelTab = 0;

		
		for (int i = (pt_livre - 1); i >= 0; i--) {
			if (tabela[i][0] != null) {
				nivelTab = Integer.parseInt(tabela[i][2]);
				if (nivelTab == nivelMax && nivelTab!=0) {
					tabela[i][0] = null;
					tabela[i][1] = null;
					tabela[i][2] = null;
					tabela[i][3] = null;
					tabela[i][4] = null;
				}
			}
		}

	}

	/**
	 * Getter do pt_livre
	 * 
	 * @return ultima posição livre
	 */
	public int getPt_livre() {
		return pt_livre;
	}

	/**
	 * Setter do pt_livre
	 * 
	 * @param pt_livre
	 */
	public void setPt_livre(int pt_livre) {
		this.pt_livre = pt_livre;
	}

	/**
	 * Getter da TS
	 * 
	 * @return tabela de Simbolos
	 */
	public String[][] getTabela() {
		return tabela;
	}

	/**
	 * Setter da TS
	 * 
	 * @param tabela
	 */
	public void setTabela(String[][] tabela) {
		this.tabela = tabela;
	}
	
	public String toString(){
		String aux="";
		
		for (int i=0; i<tabela.length; i++){
			if (tabela[i][0]!=null){
				for (int j=0; j<5; j++){
					aux = aux + tabela[i][j] + " ";
				}
				aux+="\n";
			}else{
				break;
			}
		}
		
		return aux;
	}

	/**
	 * Método Principal da Classe TabelaDeSímbolos
	 * 
	 * @param args
	 */
	public static void main(String[] args) {

		

	}

}
