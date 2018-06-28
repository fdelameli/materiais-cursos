

/**
 * @author Fabio
 * @version 1.0
 * @created 17-mai-2008 15:35:00
 */
public class Carro {

	private String placa;
	private int velocidade;
	private boolean estado;

	public Carro(){

	}

	public void finalize() throws Throwable {

	}

	public boolean ligar(){
		return false;
	}

	public boolean desligar(){
		return false;
	}

	/**
	 * 
	 * @param valor
	 */
	public boolean aumentarVelocidade(int valor){
		return false;
	}

	/**
	 * 
	 * @param valor
	 */
	public boolean deminuirVelocidade(int valor){
		return false;
	}

}