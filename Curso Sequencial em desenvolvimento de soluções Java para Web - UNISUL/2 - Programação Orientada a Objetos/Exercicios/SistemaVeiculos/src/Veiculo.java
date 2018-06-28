

/**
 * @author Fabio
 * @version 1.0
 * @created 07-jun-2008 13:45:08
 */
public class Veiculo {

	//attributes
	
	private String placa;
	private double valor;
	private double valorKm;
	private double valorDiaria;
	private double kmAtual;
	private String cor;

	
	//constructors
	
	public Veiculo(){
	
	}

	public Veiculo(String placa, double valor, double valorKm, double valorDiaria, double kmAtual, String cor) {
		super();
		this.placa = placa;
		this.valor = valor;
		this.valorKm = valorKm;
		this.valorDiaria = valorDiaria;
		this.kmAtual = kmAtual;
		this.cor = cor;
	}
	
	
	//getters e setters

	public double getValor() {
		return valor;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}

	public String getPlaca() {
		return placa;
	}

	public void setPlaca(String placa) {
		this.placa = placa;
	}

	public double getValorKm() {
		return valorKm;
	}

	public void setValorKm(double valorKm) {
		this.valorKm = valorKm;
	}

	public double getValorDiaria() {
		return valorDiaria;
	}

	public void setValorDiaria(double valorDiaria) {
		this.valorDiaria = valorDiaria;
	}

	public double getKmAtual() {
		return kmAtual;
	}

	public void setKmAtual(double kmAtual) {
		this.kmAtual = kmAtual;
	}

	public String getCor() {
		return cor;
	}

	public void setCor(String cor) {
		this.cor = cor;
	}
	

}