package br.unisul.aula.trabalho.entidades;

import java.util.GregorianCalendar;

public class AluguelDiaria extends Aluguel {
	
	//constructors
	
	/**
	 * Construtor default.
	 */
	public AluguelDiaria() {
		super();
	}

	/**
	 * Construtor com parâmetros.
	 */
	public AluguelDiaria(Veiculo veiculo, GregorianCalendar dataInicioAluguel,
			GregorianCalendar dataTerminoAluguel, double kmInicial, double kmFinal) {
		super(veiculo, dataInicioAluguel, dataTerminoAluguel, kmInicial, kmFinal);
	}
	
	
	//main method
	
	/**
	 * Metodo que retorna o valor total do aluguel.
	 * @return Valor do aluguel.
	 */
	public double calculaValorAluguel() {
		return this.getVeiculo().getValorDiaria() * this.getQtdDiasAluguel();
	}

	
	//toString
	
	public String toString() {
		return String.format("<<< DADOS ALUGUEL >>>\nVeículo: %s\nData Inicio Aluguel: %s\nData Termino Aluguel: %s\nQuant. Dias de Aluguel: %s\nVALOR TOTAL ALUGUEL: %s",
				this.getVeiculo().toString(), getDataInicioAluguel(), getDataTerminoAluguel(), this.getQtdDiasAluguel(), calculaValorAluguel());
	}
}
