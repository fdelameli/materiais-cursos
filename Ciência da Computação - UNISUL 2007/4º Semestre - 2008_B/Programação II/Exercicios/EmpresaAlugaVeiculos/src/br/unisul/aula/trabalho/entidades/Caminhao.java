package br.unisul.aula.trabalho.entidades;


/**
 * Entidade Caminhão.
 * @author Fabio Dela Bruna, Marcio Ozório Teixeira.
 * @since 12/05/2008
 */
public class Caminhao extends Veiculo {

	//attributes

	private static final double VALOR_DIARIA = 175.0;
	private static final String TIPO_VEICULO = "Caminhão";
	
	
	//constructors
	
	/**
	 * Construtor default.
	 */
	public Caminhao() {
		super();
	}
	
	/**
	 * Construtor com parametros
	 */
	public Caminhao(int codigo, double valor, double valorKm, String marca, String modelo,
			String cor, String placa, String numeroRenavam) {
		super(codigo, valor, valorKm, marca, modelo, cor, placa, numeroRenavam);
	}

	
	//métodos principais do modelo.

	@Override
	public double getValorDiaria() {
		return VALOR_DIARIA;
	}
	
	@Override
	public String getTipoVeiculo() {
		return TIPO_VEICULO;
	}
	
}
