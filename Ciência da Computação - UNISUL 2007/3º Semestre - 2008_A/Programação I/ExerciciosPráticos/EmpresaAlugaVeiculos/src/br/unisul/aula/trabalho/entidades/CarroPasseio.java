package br.unisul.aula.trabalho.entidades;

public class CarroPasseio extends Veiculo{
	
	//attributes

	private static final double VALOR_DIARIA = 300.0;
	private static final String TIPO_VEICULO = "Carro de Passeio";


	//constructors
	
	/**
	 * Construtor default.
	 */
	public CarroPasseio() {
		super();
	}
	
	/**
	 * Construtor com parametros
	 */
	public CarroPasseio(int codigo, double valor, double valorKm, String marca, String modelo,
			String cor, String placa, String numeroRenavam) {
		super(codigo, valor, valorKm, marca, modelo, cor, placa, numeroRenavam);
	}

	
	//métodos principais do modelo

	@Override
	public double getValorDiaria() {
		return VALOR_DIARIA;
	}
	
	@Override
	public String getTipoVeiculo() {
		return TIPO_VEICULO;
	}

}
