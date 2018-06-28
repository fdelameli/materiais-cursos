import java.io.Serializable;
import java.util.ArrayList;

/**
 * Classe que representa uma carteira.
 * @author Fabio Dela Bruna.
 */
public class Carteira implements Serializable {
	
	private static final long serialVersionUID = 1L;
	private ArrayList<Moeda> moedas;
	
	
	/**
	 * Construtor default.
	 */
	public Carteira() {
		super();
		this.moedas = new ArrayList<Moeda>();
	}
	
	
	/**
	 * Método que retorna a soma do valor de todas as moedas.
	 * @return Valor total das moedas.
	 */
	public double saldoCarteira() {
		double saldo = 0;
		for (Moeda moeda : this.moedas) {
			saldo += moeda.getValor();
		}
		return saldo;
	}



	public ArrayList<Moeda> getMoedas() {
		return moedas;
	}

	public void setMoedas(ArrayList<Moeda> moedas) {
		this.moedas = moedas;
	}
	
}
