package entidades;

import java.util.GregorianCalendar;

/**
 * Classe que representa uma estadia.
 * @author Fabio Dela Bruna / Carlos Henrique Sá
 */
public class Estadia {
	
	//atributos
	
	private Quarto quarto;
	private GregorianCalendar dataInicialReserva;
	private GregorianCalendar dataFinalReserva;
	private long qtdDias;
	
	
	//construtores
	
	public Estadia(){
		this(null, new GregorianCalendar(), new GregorianCalendar());
		this.qtdDias = (this.dataFinalReserva.getTimeInMillis() - this.dataInicialReserva.getTimeInMillis())/1000/60/60/24;
	}
	
	
	/**
	 * Construtor com parâmetros.
	 */
	public Estadia(Quarto quarto, GregorianCalendar dataInicialReserva, GregorianCalendar dataFinalReserva) {
		super();
		this.quarto = quarto;
		this.dataInicialReserva = dataInicialReserva;
		this.dataFinalReserva = dataFinalReserva;
		this.qtdDias = (this.dataFinalReserva.getTimeInMillis() - this.dataInicialReserva.getTimeInMillis())/1000/60/60/24;
	}
		
	
	//métodos principais
	
	/**
	 * Método que retorna a quantidade de dias de um determinado aluguel.
	 */
	public long getQuantidadeDias(){
		return this.qtdDias;
	}

	
	//getters e setters
	
	public Quarto getQuarto() {
		return quarto;
	}

	public void setQuarto(Quarto quarto) {
		this.quarto = quarto;
	}

	public String getDataInicialReserva() {
		String data = this.dataInicialReserva.get(GregorianCalendar.DAY_OF_MONTH)
		+ "/" + this.dataInicialReserva.get(GregorianCalendar.MONTH)
		+ "/" + this.dataInicialReserva.get(GregorianCalendar.YEAR);
		return data;
	}

	public void setDataInicialReserva(GregorianCalendar dataInicialReserva) {
		this.dataInicialReserva = dataInicialReserva;
	}

	public String getDataFinalReserva() {
		String data = this.dataFinalReserva.get(GregorianCalendar.DAY_OF_MONTH)
		+ "/" + this.dataFinalReserva.get(GregorianCalendar.MONTH)
		+ "/" + this.dataFinalReserva.get(GregorianCalendar.YEAR);
		return data;
	}

	public void setDataFinalReserva(GregorianCalendar dataFinalReserva) {
		this.dataFinalReserva = dataFinalReserva;
	}

	public long getQtdDias() {
		return this.qtdDias;
	}

	public void setQtdDias(long qtdDias) {
		this.qtdDias = qtdDias;
	}	

	
	
	//toString

	public String toString(){
		return String.format("Tipo Quarto: %s\nData Inicial Aluguel: %s      --> Data Final Aluguel: %s\nQuantidade Dias: %s\n\n", 
				this.quarto.getTipoQuarto(), getDataInicialReserva(), getDataFinalReserva(), this.qtdDias);
	}

		
}

