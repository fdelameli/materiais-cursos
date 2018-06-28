

/**
 * @author Fabio
 * @version 1.0
 * @created 17-mai-2008 15:35:00
 */
public class Motorista {

	private String nome;
	private Carro carro;

	public Motorista(){

	}

	public void finalize() throws Throwable {

	}

	/**
	 * 
	 * @param carro
	 */
	public boolean ligarCarro(Carro carro){
		return false;
	}

	/**
	 * 
	 * @param carro
	 */
	public boolean desligarCarro(Carro carro){
		return false;
	}

	/**
	 * 
	 * @param carro
	 * @param valor
	 */
	public boolean acelerarCarro(Carro carro, int valor){
		return false;
	}

	/**
	 * 
	 * @param carro
	 * @param valor
	 */
	public boolean frearCarro(Carro carro, int valor){
		return false;
	}

}