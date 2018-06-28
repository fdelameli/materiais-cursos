 package br.unisul.aula.trabalho.entidades;

import java.util.GregorianCalendar;


/**
 * Entidade Aluguel.
 * @author Fabio Dela Bruna, Marcio Ozório Teixeira.
 * @since 12/05/2008
 */
public class Aluguel {
	
	//attributes
	
	private Veiculo veiculo;
	private GregorianCalendar dataInicioAluguel;
	private GregorianCalendar dataTerminoAluguel;
	private long qtdDiasAluguel;
	private double valorTotal;
	private double kmInicial;
	private double kmFinal;
	private double kmPercorrida;
	
	
	//constructors
	
	/**
	 * Construtor default
	 */
	public Aluguel() {
		this(null, new GregorianCalendar(), new GregorianCalendar(), 0, 0);
		this.qtdDiasAluguel = (this.dataTerminoAluguel.getTimeInMillis() - this.dataInicioAluguel.getTimeInMillis())/1000/60/60/24;
		this.kmPercorrida = this.kmFinal = this.kmInicial;
		this.valorTotal = calculaValorAluguel();
	}

	/** 
	 * Construtor com parâmetros.
	 * 
	 * @param veiculo - Veículo alugado.
	 * @param dataInicioAluguel - Data de início do aluguel.
	 * @param dataTerminoAluguel - Data de término do aluguel.
	 * @param kmInicial - Quilometragem inicial do veículo.
	 * @param kmFinal - Quilometragem final do veículo.
	 */
	public Aluguel(Veiculo veiculo, GregorianCalendar dataInicioAluguel, GregorianCalendar dataTerminoAluguel, double kmInicial, double kmFinal) {
		super();
		this.veiculo = veiculo;
		this.dataInicioAluguel = dataInicioAluguel;
		this.dataTerminoAluguel = dataTerminoAluguel;
		this.qtdDiasAluguel = (this.dataTerminoAluguel.getTimeInMillis() - this.dataInicioAluguel.getTimeInMillis())/1000/60/60/24;
		this.kmInicial = kmInicial;
		this.kmFinal = kmFinal;
		this.kmPercorrida = kmFinal - kmInicial;
		this.valorTotal = calculaValorAluguel();
	}
	
	
	//main methods
	
	/**
	 * Metodo que retorna o valor total do aluguel.
	 * @return Valor do aluguel.
	 */
	public double calculaValorAluguel() {
		return 0;
	}
	
	
	//getters e setters

	public Veiculo getVeiculo() {
		return veiculo;
	}

	public void setVeiculo(Veiculo veiculo) {
		this.veiculo = veiculo;
	}

	public String getDataInicioAluguel() {
		String data = this.dataInicioAluguel.get(GregorianCalendar.DAY_OF_MONTH)
		+ "/" + this.dataInicioAluguel.get(GregorianCalendar.MONTH)
		+ "/" + this.dataInicioAluguel.get(GregorianCalendar.YEAR);
		return data;
	}

	public void setDataInicioAluguel(GregorianCalendar dataInicioAluguel) {
		this.dataInicioAluguel = dataInicioAluguel;
	}

	public String getDataTerminoAluguel() {
		String data = this.dataTerminoAluguel.get(GregorianCalendar.DAY_OF_MONTH)
		+ "/" + this.dataTerminoAluguel.get(GregorianCalendar.MONTH)
		+ "/" + this.dataTerminoAluguel.get(GregorianCalendar.YEAR);
		return data;
	}

	public void setDataTerminoAluguel(GregorianCalendar dataTerminoAluguel) {
		this.dataTerminoAluguel = dataTerminoAluguel;
	}

	public long getQtdDiasAluguel() {
		return qtdDiasAluguel;
	}

	public void setQtdDiasAluguel(long qtdDiasAluguel) {
		this.qtdDiasAluguel = qtdDiasAluguel;
	}

	public double getKmInicial() {
		return kmInicial;
	}

	public void setKmInicial(double kmInicial) {
		this.kmInicial = kmInicial;
	}

	public double getKmFinal() {
		return kmFinal;
	}

	public void setKmFinal(double kmFinal) {
		this.kmFinal = kmFinal;
	}

	public double getKmPercorrida() {
		return kmPercorrida;
	}

	public void setKmPercorrida(double kmPercorrida) {
		this.kmPercorrida = kmPercorrida;
	}
	
	public double getValorTotal() {
		return valorTotal;
	}

	public void setValorTotal(double valorTotal) {
		this.valorTotal = valorTotal;
	}
	
	
	//toString

	public String toString() {
		return String.format("<<< DADOS ALUGUEL >>>\nVeículo: %s\nData Inicio Aluguel: %s\nData Termino Aluguel: %s"
				+"\nQtd Dias Aluguel: %s\nKm Inicial: %s km   --> Km Final: %s km   --> Km Percorrida: %s km",
				this.veiculo.toString(), getDataInicioAluguel(), getDataTerminoAluguel(), this.qtdDiasAluguel,
				this.kmInicial, this.kmFinal, this.kmPercorrida);
	}

}
