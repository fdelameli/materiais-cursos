

/**
 * @author Fabio
 * @version 1.0
 * @created 07-jun-2008 13:45:08
 */
public class Motor {

	//attributes
	
	private int qtdCilindros;
	private double potencia;

	
	//constructors
	
	public Motor(){
		this(0, 0);
	}

	public Motor(int qtdCilindros, double potencia) {
		super();
		this.qtdCilindros = qtdCilindros;
		this.potencia = potencia;
	}

	
	//getters e setters
	
	public int getQtdCilindros() {
		return qtdCilindros;
	}

	public void setQtdCilindros(int qtdCilindros) {
		this.qtdCilindros = qtdCilindros;
	}

	public double getPotencia() {
		return potencia;
	}

	public void setPotencia(double potencia) {
		this.potencia = potencia;
	}

	

}