package br.unisul.aula.trabalho.entidades;

import java.util.GregorianCalendar;

public class AluguelKmDiaria extends Aluguel {

	//constructors
	
	/**
	 * Construtor default.
	 */
	public AluguelKmDiaria() {
		super();
	}

	/**
	 * Construtor com parâmetros.
	 */
	public AluguelKmDiaria(Veiculo veiculo, GregorianCalendar dataInicioAluguel,
			GregorianCalendar dataTerminoAluguel, double kmInicial, double kmFinal) {
		super(veiculo, dataInicioAluguel, dataTerminoAluguel, kmInicial, kmFinal);
	}
	
	
	//main method
	
	/**
	 * Metodo que retorna o valor total do aluguel.
	 * Para este tipo de aluguel, é cobrado 50% do valor da km percorrida
	 * E 20% do valor da diária normal de um determinado carro.
	 * @return Valor do aluguel.
	 */
	public double calculaValorAluguel() {
		return ((this.getKmPercorrida() * this.getVeiculo().getValorKm() * 0.5)
				+ (this.getQtdDiasAluguel() * this.getVeiculo().getValorDiaria() * 0.2));
	}

	
	//toString
	
	public String toString() {
		return String.format("%s\n> VALOR TOTAL DO ALUGUEL: %s", super.toString(), calculaValorAluguel());
	}
	
}
