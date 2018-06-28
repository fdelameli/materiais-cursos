

/**
 * @author Fabio
 * @version 1.0
 * @created 07-jun-2008 13:45:08
 */
public class Caminhao extends Veiculo {

	//attributes
	
	private double cargaMaximaKg;
	private double alturaMaximaM;
	private double comprimento;

	
	//constructors
	
	public Caminhao(){

	}
	
	public Caminhao(String placa, double valor, double valorKm,
			double valorDiaria, double kmAtual, String cor,
			double cargaMaximaKg, double alturaMaximaM, double comprimento) {
		super(placa, valor, valorKm, valorDiaria, kmAtual, cor);
		this.cargaMaximaKg = cargaMaximaKg;
		this.alturaMaximaM = alturaMaximaM;
		this.comprimento = comprimento;
	}

	
	//getters e setters

	public double getCargaMaximaKg() {
		return cargaMaximaKg;
	}

	public void setCargaMaximaKg(double cargaMaximaKg) {
		this.cargaMaximaKg = cargaMaximaKg;
	}

	public double getAlturaMaximaM() {
		return alturaMaximaM;
	}

	public void setAlturaMaximaM(double alturaMaximaM) {
		this.alturaMaximaM = alturaMaximaM;
	}

	public double getComprimento() {
		return comprimento;
	}

	public void setComprimento(double comprimento) {
		this.comprimento = comprimento;
	}
	

}