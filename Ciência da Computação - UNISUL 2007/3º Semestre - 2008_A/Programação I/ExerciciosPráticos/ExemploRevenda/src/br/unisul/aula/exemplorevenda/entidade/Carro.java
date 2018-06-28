package br.unisul.aula.exemplorevenda.entidade;

/**
 * Entidade Carro.
 * @author Fabio Dela Bruna.
 * @since 22/04/2008
 */
public class Carro extends Veiculo{
	
	// atributos
	
	private int qtdPortas;
	private boolean airbag;
	private boolean som;
	private boolean freioDisco;
	
	
	// construtores
	
	/**
	 * Construtor default.
	 */
	public Carro() {
		super();
	}

	/**
	 * Construtor com parâmetros (com dados dos carros).
	 * @param qtdPortas - Quantidade de portas.
	 * @param airbag - Airbag / SIM OU NÃO
	 * @param som - Som / SIM OU NÃO
	 * @param freioDisco - Freio a Disco / SIM OU NÃO
	 */
	public Carro(int qtdPortas, boolean airbag, boolean som, boolean freioDisco) {
		super();
		this.qtdPortas = qtdPortas;
		this.airbag = airbag;
		this.som = som;
		this.freioDisco = freioDisco;
	}


	// getters e setters

	public int getQtdPortas() {
		return qtdPortas;
	}

	public void setQtdPortas(int qtdPortas) {
		this.qtdPortas = qtdPortas;
	}

	public boolean isAirbag() {
		return airbag;
	}

	public void setAirbag(boolean airbag) {
		this.airbag = airbag;
	}

	public boolean isSom() {
		return som;
	}

	public void setSom(boolean som) {
		this.som = som;
	}

	public boolean isFreioDisco() {
		return freioDisco;
	}

	public void setFreioDisco(boolean freioDisco) {
		this.freioDisco = freioDisco;
	}
	
	
	// toString
	
	public String toString(){
		return String.format("%s\nQtd Portas: %s\nAirbag: %s\nApar. Som: %s\nFreio à Disco: %s", super.toString(), qtdPortas, airbag, som, freioDisco);
	}

}
