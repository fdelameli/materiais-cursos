package multiprogramavel;

public class Tabela {
	
	private boolean alocado;
	private boolean [] tabela;
	private static final int TAM = 5;
	
	
	public Tabela(){
		this.alocado = false;
		this.tabela = new boolean[this.TAM];
		this.tabela[0] = true;
		for (int i = 1; i < tabela.length; i++) {
			this.tabela[i] =this.alocado; 
		}
	}


	/**
	 * @return the alocado
	 */
	public boolean isAlocado() {
		return alocado;
	}


	/**
	 * @param alocado the alocado to set
	 */
	public void setAlocado(boolean alocado) {
		this.alocado = alocado;
	}


	/**
	 * @return the tAM
	 */
	public static int getTAM() {
		return TAM;
	}


	/**
	 * @return the tabela
	 */
	public boolean[] getTabela() {
		return tabela;
	}


	/**
	 * @param tabela the tabela to set
	 */
	public void setTabela(boolean[] tabela) {
		this.tabela = tabela;
	}
	
	
	

}
