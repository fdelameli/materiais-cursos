

/**
 * @author Fabio
 * @version 1.0
 * @created 07-jun-2008 13:45:08
 */
public class CarroPasseio extends Veiculo {

	//attributes
	
	private String modelo;

	
	//constructors
	
	public CarroPasseio(){

	}
	
	public CarroPasseio(String placa, double valor, double valorKm, double valorDiaria, double kmAtual, String cor, String modelo) {
		super(placa, valor, valorKm, valorDiaria, kmAtual, cor);
		this.modelo = modelo;
	}

	
	//getters e setters
	
	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}


}