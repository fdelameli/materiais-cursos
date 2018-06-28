

/**
 * @author Fabio
 * @version 1.0
 * @created 07-jun-2008 13:45:08
 */
public class Onibus extends Veiculo {

	//attributes
	
	private int maximoPassageiros;

	
	//constructors
	
	public Onibus(){

	}
	
	public Onibus(String placa, double valor, double valorKm, double valorDiaria, double kmAtual, String cor, int maximoPassageiros) {
		super(placa, valor, valorKm, valorDiaria, kmAtual, cor);
		this.maximoPassageiros = maximoPassageiros;
	}

	
	//getters e setters
	
	public int getMaximoPassageiros() {
		return maximoPassageiros;
	}

	public void setMaximoPassageiros(int maximoPassageiros) {
		this.maximoPassageiros = maximoPassageiros;
	}
	

}