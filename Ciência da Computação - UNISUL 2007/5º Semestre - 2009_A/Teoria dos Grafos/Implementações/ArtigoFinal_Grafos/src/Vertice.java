/**
 * Classe que representa um vértice V de um grafo G.
 * @author Lucas Nunes, Jakson Gonçalves.
 * @since 06/07/2009.
 */
public class Vertice {

	private String rotulo;
	private String nomeBairro;
	private boolean br101;
	

	/**
	 * Construtor default.
	 */
	public Vertice() {
		super();
	}

	/**
	 * Construtor com parâmetros.
	 * @param rotulo
	 */
	public Vertice(String rotulo, String nomeBairro, boolean br101) {
		super();
		this.rotulo = rotulo;
		this.nomeBairro = nomeBairro;
		this.br101 = br101;
	}

	/**
	 * Método toString.
	 * return str.
	 */
	public String toString() {
		String str = rotulo;
		return str;
	}

	public String getRotulo() {
		return rotulo;
	}

	public void setRotulo(String rotulo) {
		this.rotulo = rotulo;
	}

	public String getNomeBairro() {
		return nomeBairro;
	}

	public void setNomeBairro(String nomeBairro) {
		this.nomeBairro = nomeBairro;
	}

	public boolean isBr101() {
		return br101;
	}

	public void setBr101(boolean br101) {
		this.br101 = br101;
	}
}