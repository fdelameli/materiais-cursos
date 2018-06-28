import java.io.Serializable;


public class Moeda implements Serializable {

	private static final long serialVersionUID = 1L;
	private double valor;
	private String descricao;
	
	
	
	public Moeda() {
		super();
	}

	public Moeda(double valor, String descricao) {
		super();
		this.valor = valor;
		this.descricao = descricao;
	}

	
	
	public double getValor() {
		return valor;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
}
