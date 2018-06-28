package br.unisul.aula.exemplorevenda.entidade;

/**
 * Entidade Moto.
 * @author Fabio Dela Bruna
 * @since 22/04/2008
 */
public class Moto extends Veiculo{

	// atributos
	
	private boolean partidaEletrica;

	
	// construtores
	
	/**
	 * Construtor default.
	 */
	public Moto() {
		super();		
	}

	/**
	 * Construtor com parâmetros(com dados da moto).
	 * @param partidaEletrica - Partida Elétrica / SIM ou NÃO
	 */
	public Moto(boolean partidaEletrica) {
		super();
		this.partidaEletrica = partidaEletrica;
	}


	// getters e setters
	
	public boolean isPartidaEletrica() {
		return partidaEletrica;
	}

	public void setPartidaEletrica(boolean partidaEletrica) {
		this.partidaEletrica = partidaEletrica;
	}
	
	
	// toString
	
	public String toString(){
		return String.format("%s\nPartida Elétrica: %s", super.toString(), partidaEletrica);
	}
	
	
}
