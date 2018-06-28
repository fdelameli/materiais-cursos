package br.unisul.aula.trabalho.entidades;


/**
 * Entidade Moto.
 * @author Fabio Dela Bruna, Marcio Ozório Teixeira.
 * @since 12/05/2008
 */
public class Moto extends Veiculo {
	
	//attributes
	
	private boolean partilaEletrica;
	private boolean freioDisco;
	private static final double VALOR_DIARIA = 300.0;
	private static final String TIPO_VEICULO = "Carro de Passeio";
	
	
	//constructors
	
	/**
	 * Construtor default
	 */
	public Moto() {
		super();
		this.freioDisco = false;
		this.partilaEletrica = false;
	}
	
	/**
	 * Construtor com parametros
	 */
	public Moto(int codigo, double valor, double valorKm, String marca, String modelo, String cor, String placa,
			String numeroRenavam, boolean partidaEletrica, boolean freioDisco) {
		super(codigo, valor, valorKm, marca, modelo, cor, placa, numeroRenavam);
		this.partilaEletrica = partidaEletrica;
		this.freioDisco = freioDisco;
	}

	
	//main methods
	
	@Override
	public double getValorDiaria() {
		return VALOR_DIARIA;
	}
	
	@Override
	public String getTipoVeiculo() {
		return TIPO_VEICULO;
	}
	
	
	//getters e setters

	public boolean isPartilaEletrica() {
		return partilaEletrica;
	}

	public void setPartilaEletrica(boolean partilaEletrica) {
		this.partilaEletrica = partilaEletrica;
	}

	public boolean isFreioDisco() {
		return freioDisco;
	}

	public void setFreioDisco(boolean freioDisco) {
		this.freioDisco = freioDisco;
	}

}
