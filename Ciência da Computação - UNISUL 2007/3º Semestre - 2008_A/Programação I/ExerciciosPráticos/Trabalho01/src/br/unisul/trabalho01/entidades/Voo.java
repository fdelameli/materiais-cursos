
/**
 * Classe que representa vôos de determinadas companhias.
 * @author Fabio Dela Bruna.
 * @since 30/03/2008.
 */
public class Voo {

	
	// Atributos
	
	private int numero;
	private String data;
	private Aeroporto origem;
	private Aeroporto destino;
	private Aviao aviao;
	
	
	// Construtores

	/**
	 * Construtor com parâmetros (com dados do Voo).
	 * @param numero - Número do vôo;
	 * @param data - Data;
	 * @param origem - Origem;
	 * @param destino - Destino;
	 * @param aviao - Avião;
	 */
	public Voo(int numero, String data, Aeroporto origem, Aeroporto destino, Aviao aviao) {
		super();
		this.numero = numero;
		this.data = data;
		this.origem = origem;
		this.destino = destino;
		this.aviao = aviao;
	}

	
	// Getters and Setters

	/**
	 * @return the aviao
	 */
	public Aviao getAviao() {
		return aviao;
	}

	/**
	 * @param aviao the aviao to set
	 */
	public void setAviao(Aviao aviao) {
		this.aviao = aviao;
	}

	/**
	 * @return the data
	 */
	public String getData() {
		return data;
	}

	/**
	 * @param data the data to set
	 */
	public void setData(String data) {
		this.data = data;
	}

	/**
	 * @return the destino
	 */
	public Aeroporto getDestino() {
		return destino;
	}

	/**
	 * @param destino the destino to set
	 */
	public void setDestino(Aeroporto destino) {
		this.destino = destino;
	}

	/**
	 * @return the numero
	 */
	public int getNumero() {
		return numero;
	}

	/**
	 * @param numero the numero to set
	 */
	public void setNumero(int numero) {
		this.numero = numero;
	}

	/**
	 * @return the origem
	 */
	public Aeroporto getOrigem() {
		return origem;
	}

	/**
	 * @param origem the origem to set
	 */
	public void setOrigem(Aeroporto origem) {
		this.origem = origem;
	}

	
	// equals e toString
	
	/**
	 * Método que verifica se um vôo já esta cadastrado.
	 */
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj instanceof Voo) {
			Voo voo = (Voo) obj;
			return this.numero == voo.numero;
		}
		return false;
	}
	
	/**
	 * Método toString para mostrar os vôos.
	 */
	public String toString() {
		return "-- VOO: Número " + this.numero + " --\nOrigem: " + this.origem
				+ "\nDestino: " + this.destino + "\nData: "
				+ this.data + "\nAcentos livres: " + getAviao().getAcentosLivres() + "\n\n";
	}
}