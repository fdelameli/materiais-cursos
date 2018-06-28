package br.unisul.estrutura.aula;

/**
 * Esta classe representa a pessoa em termos de ser humano.
 * @author Fabio
 * @since   
 * 
 */
public class Humano {
	
	private int qtdOlhos;
	private boolean pelo; //true para sim e false para nao.
	private int qtdMembros;
	private int reproducao; //1-Sexuada 2-Assexuada
	
	
	public Humano() {
		super();
		// TODO Auto-generated constructor stub
	}


	public Humano(int qtdOlhos, boolean pelo, int qtdMembros, int reproducao) {
		super();
		this.qtdOlhos = qtdOlhos;
		this.pelo = pelo;
		this.qtdMembros = qtdMembros;
		this.reproducao = reproducao;
	}

	public String getTipoRespiracao()
	{
		return "Aeróbica";
	}

	/**
	 * @return the pelo
	 */
	public boolean isPelo() {
		return pelo;
	}


	/**
	 * @param pelo the pelo to set
	 */
	public void setPelo(boolean pelo) {
		this.pelo = pelo;
	}


	/**
	 * @return the qtdMembros
	 */
	public int getQtdMembros() {
		return qtdMembros;
	}


	/**
	 * @param qtdMembros the qtdMembros to set
	 */
	public void setQtdMembros(int qtdMembros) {
		this.qtdMembros = qtdMembros;
	}


	/**
	 * @return the qtdOlhos
	 */
	public int getQtdOlhos() {
		return qtdOlhos;
	}


	/**
	 * @param qtdOlhos the qtdOlhos to set
	 */
	public void setQtdOlhos(int qtdOlhos) {
		this.qtdOlhos = qtdOlhos;
	}


	/**
	 * @return the reproducao
	 */
	public int getReproducao() {
		return reproducao;
	}


	/**
	 * @param reproducao the reproducao to set
	 */
	public void setReproducao(int reproducao) {
		this.reproducao = reproducao;
	}
	
	

}
