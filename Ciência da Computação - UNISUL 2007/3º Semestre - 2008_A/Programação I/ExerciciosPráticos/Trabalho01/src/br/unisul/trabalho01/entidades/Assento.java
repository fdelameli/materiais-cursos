


/**
 * Classe que representa os acentos de um avião.
 * @author Fabio Dela Bruna, Márcio Ozório.
 * @since 02/04/2008.
 */
public class Assento {

	
	// Atributos
	
	private String numero;
	private boolean reservado;

	
	// Construtor
	
	/**
	 * Construtor com parametros (com dados dos acentos).
	 * @param reservado - Assento reservado ou não;
	 * @param numero - Número do assento;
	 */
	public Assento(String numero) {
		this.reservado = false;
		this.numero = numero;
	}
	
	
	// Métodos principais
	
	/**
	 * Método para verificar se determinado
	 */
	public boolean estaReservado() {
		return this.reservado;
	}

	/**
	 * Método para reservar determinado assento do avião.
	 */
	public boolean reservar() {
		if (this.reservado == true) {
			return false;
		} else {
			this.reservado = true;
			return true;
		}
	}
	
	
	// getters and setters
	
	/**
	 * @return the numero
	 */
	public String getNumero() {
		return numero;
	}

	/**
	 * @param numero the numero to set
	 */
	public void setNumero(String numero) {
		this.numero = numero;
	}

	/**
	 * @return the reservado
	 */
	public boolean isReservado() {
		return reservado;
	}

	/**
	 * @param reservado the reservado to set
	 */
	public void setReservado(boolean reservado) {
		this.reservado = reservado;
	}
	
	
	// equals e toString

	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj instanceof Assento) {
			Assento assento = (Assento) obj;
			return this.numero == assento.numero;
		}
		return false;
	}

	/**
	 * Método para mostrar os acentos.
	 */
	public String toString() {
		return "Número: " + this.numero + "\nReservado: " + (this.reservado?"sim":"não");
	}		
}