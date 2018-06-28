package br.unisul.exercicio3;

/**
 * Classe Produto Bean.
 * @author Fabio Dela Bruna
 * @since 29/11/2008
 *
 */
public class ProdutoBean {

	/**
	 * codigo - Codigo do produto.
	 */
	private int codigo;
	
	/**
	 * descricao - Descrição do produto.
	 */
	private String descricao;
	
	/**
	 * valor - Valor do produto.
	 */
	private double valor;
	
	
	/**
	 * Construtor default da classe ProdutoBean.
	 */
	public ProdutoBean() {
		super();
	}


	/**
	 * @return the codigo
	 */
	public int getCodigo() {
		return codigo;
	}

	/**
	 * @param codigo the codigo to set
	 */
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	/**
	 * @return the descricao
	 */
	public String getDescricao() {
		return descricao;
	}

	/**
	 * @param descricao the descricao to set
	 */
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	/**
	 * @return the valor
	 */
	public double getValor() {
		return valor;
	}

	/**
	 * @param valor the valor to set
	 */
	public void setValor(double valor) {
		this.valor = valor;
	}
	
}