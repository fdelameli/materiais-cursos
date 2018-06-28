package br.unisul.aula.trabalho.entidades;


/**
 * Entidade Ônibus.
 * @author Fabio Dela Bruna, Marcio Ozório Teixeira.
 * @since 12/05/2008
 */
public class Onibus extends Veiculo {
	
	//attributes

	private static final double VALOR_DIARIA = 200.0;
	private static final String TIPO_VEICULO = "Ônibus";
	
	
	//constructors
	
	/**
	 * Construtor default.
	 */
	public Onibus() {
		super();
	}
	
	/**
	 * Construtor com parametros
	 */
	public Onibus(int codigo, double valor, double valorKm, String marca, String modelo,
			String cor, String placa, String numeroRenavam) {
		super(codigo, valor, valorKm, marca, modelo, cor, placa, numeroRenavam);
	}

	
	//metodos principais do modelo.
	
	@Override
	public double getValorDiaria() {
		return VALOR_DIARIA;
	}
	
	@Override
	public String getTipoVeiculo() {
		return TIPO_VEICULO;
	}
	
}
