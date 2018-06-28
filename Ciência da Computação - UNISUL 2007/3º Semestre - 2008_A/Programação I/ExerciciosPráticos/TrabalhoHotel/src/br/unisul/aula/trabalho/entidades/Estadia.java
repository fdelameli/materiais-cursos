package br.unisul.aula.trabalho.entidades;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Classe que representa uma estadia.
 * @author Fabio Dela Bruna / Márcio Teixeira Ozório.
 * @since 14/05/2008.
 */
public class Estadia {
	
	//atributos
	
	private Quarto quarto;
	private int qtdDias;
	private Date dataReserva;
	
	
	//construtores
	
	/**
	 * Construtor default.
	 */
	public Estadia() {
		super();
	}
	
	/**
	 * Construtor com parâmetros.
	 * @param quarto - Quarto revervado pelo cliente.
	 * @param qtdDias - Quantidade de dias.
	 * @param dataReserva - Data em que a reserva foi efetuada.
	 */
	public Estadia(Quarto quarto, int qtdDias, Date dataReserva) {
		super();
		this.quarto = quarto;
		this.qtdDias = qtdDias;
		this.dataReserva = dataReserva;
	}

	
	//getters e setters

	/**
	 * @return the dataReserva
	 */
	public String getDataReserva() {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		String dataFormatada = sdf.format(dataReserva);
		return dataFormatada;
	}

	/**
	 * @param dataReserva the dataReserva to set
	 */
	public void setDataReserva(Date dataReserva) {
		this.dataReserva = dataReserva;
	}

	/**
	 * @return the quarto
	 */
	public Quarto getQuarto() {
		return quarto;
	}

	/**
	 * @param quarto the quarto to set
	 */
	public void setQuarto(Quarto quarto) {
		this.quarto = quarto;
	}
	
	/**
	 * @return the qtdDias
	 */
	public int getQtdDias() {
		return qtdDias;
	}

	/**
	 * @param qtdDias the qtdDias to set
	 */
	public void setQtdDias(int qtdDias) {
		this.qtdDias = qtdDias;
	}
	

	public String toString(){
		return String.format("Quantidade Dias: %s  --->  Data Reserva: %s", 
				this.qtdDias, getDataReserva());
	}
	
}
