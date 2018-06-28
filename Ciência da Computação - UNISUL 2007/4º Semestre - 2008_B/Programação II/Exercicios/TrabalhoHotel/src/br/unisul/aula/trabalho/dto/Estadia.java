package br.unisul.aula.trabalho.dto;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 * Classe que representa uma estadia.
 * @author Fabio Dela Bruna / Márcio Teixeira Ozório.
 * @since 14/05/2008.
 */
public class Estadia {
	
	//atributos
	
	private Quarto quarto;
	private GregorianCalendar dataInicioEstadia;
	private GregorianCalendar dataFimEstadia;
	
	
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
	public Estadia(Quarto quarto, GregorianCalendar dataEstadia) {
		super();
		this.quarto = quarto;
		this.dataInicioEstadia = dataEstadia;
	}

	
	//getters e setters

	/**
	 * Retorna a data inicial de uma estadia no formato: dd/MM/yyyy.
	 */
	public String getDataInicioEstadia() {
		String data = this.dataInicioEstadia.get(GregorianCalendar.DAY_OF_MONTH) + 
		"/" + this.dataInicioEstadia.get(GregorianCalendar.MONTH) +
		"/" + this.dataInicioEstadia.get(GregorianCalendar.YEAR);
		return data;
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
		

	public String toString(){
		return String.format("Quantidade Dias: %s  --->  Data Reserva: %s", 
				this.qtdDias, getDataReserva());
	}
	
}
