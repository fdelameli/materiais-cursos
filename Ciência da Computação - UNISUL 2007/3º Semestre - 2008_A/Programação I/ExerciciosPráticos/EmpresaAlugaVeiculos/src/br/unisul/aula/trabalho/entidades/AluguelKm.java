package br.unisul.aula.trabalho.entidades;

import java.util.GregorianCalendar;

public class AluguelKm extends Aluguel {

	//constructors
	
	/**
	 * Construtor default.
	 */
	public AluguelKm() {
		super();
	}

	/**
	 * Construtor com parâmetros.
	 */
	public AluguelKm(Veiculo veiculo, GregorianCalendar dataInicioAluguel,
			GregorianCalendar dataTerminoAluguel, double kmInicial, double kmFinal) {
		super(veiculo, dataInicioAluguel, dataTerminoAluguel, kmInicial, kmFinal);
	}
	
	
	//main method
	
	/**
	 * Metodo que retorna o valor total do aluguel.
	 * Para este tipo de aluguel
	 * @return Valor do aluguel.
	 */
	public double calculaValorAluguel() {
		return this.getVeiculo().getValorKm() * this.getKmPercorrida();
	}

	
	//toString
	
	public String toString() {
		return String.format("<<< DADOS ALUGUEL >>>\nVeículo: %s\nData Inicio Aluguel: %s\nData Termino Aluguel: %s"
				+"\nKm Inicial: %s km   --> Km Final: %s km   --> Km Percorrida: %s km\nValor/KM: %s\nVALOR TOTAL ALUGUEL: %s",
				this.getVeiculo().toString(), getDataInicioAluguel(), getDataTerminoAluguel(), this.getKmInicial(),
				this.getKmFinal(), this.getKmPercorrida(), this.getVeiculo().getValorKm(), calculaValorAluguel());
	}
}