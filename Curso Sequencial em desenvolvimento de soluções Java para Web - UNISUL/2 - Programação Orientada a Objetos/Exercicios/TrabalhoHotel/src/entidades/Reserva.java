package entidades;

import java.util.GregorianCalendar;

/**
 * Classe que representa uma reserva.
 * @author Fabio Dela Bruna / Carlos Henrique Sá
 */
public class Reserva {

	//atributos
	
	private Cliente cliente;
	private Quarto quarto;
	private GregorianCalendar dataInicialReserva;
	private GregorianCalendar dataFinalReserva;
	private long QtdDias;
	
	
	//construtores
	
	/**
	 * Construtor default.
	 */
	public Reserva() {
		this(null, null, new GregorianCalendar(), new GregorianCalendar());
	}
	
	/**
	 * Construtor com parâmetros.
	 * @param cliente - Cliente.
	 * @param quarto - Quarto.
	 * @param dataInicialReserva - Data Inicial da Reserva.
	 * @param dataFinalReserva - Data Final da Reserva.
	 */
	public Reserva(Cliente cliente, Quarto quarto, GregorianCalendar dataInicialReserva, GregorianCalendar dataFinalReserva){
		this.cliente = cliente;
		this.quarto = quarto;
		this.dataInicialReserva = dataInicialReserva;
		this.dataFinalReserva = dataFinalReserva;
		this.QtdDias = (this.dataFinalReserva.getTimeInMillis() - this.dataInicialReserva.getTimeInMillis())/1000/60/60/24;
	}

	
	//getters e setters
	
	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Quarto getQuarto() {
		return quarto;
	}

	public void setQuarto(Quarto quarto) {
		this.quarto = quarto;
	}

	public GregorianCalendar getDataInicialReserva() {
		return this.dataFinalReserva;
	}

	public void setDataInicialReserva(GregorianCalendar dataInicialReserva) {
		this.dataInicialReserva = dataInicialReserva;
	}

	public long getQtdDias() {
		return QtdDias;
	}

	public void setQtdDias(long qtdDias) {
		QtdDias = qtdDias;
	}

	public GregorianCalendar getDataFinalReserva() {
		return this.dataFinalReserva;
	}

	public void setDataFinalReserva(GregorianCalendar dataFinalReserva) {
		this.dataFinalReserva = dataFinalReserva;
	}
	
	
	//toString
	
	public String toString(){
		
		String dataInicial = this.dataInicialReserva.get(GregorianCalendar.DAY_OF_MONTH)
		+ "/" + this.dataInicialReserva.get(GregorianCalendar.MONTH)
		+ "/" + this.dataInicialReserva.get(GregorianCalendar.YEAR);
		
		String dataFinal = this.dataFinalReserva.get(GregorianCalendar.DAY_OF_MONTH)
		+ "/" + this.dataFinalReserva.get(GregorianCalendar.MONTH)
		+ "/" + this.dataFinalReserva.get(GregorianCalendar.YEAR);
		
		return String.format("Cliente: %s %s\nQuarto: %s    -->  Valor Diária: %s\nData Inicial Reserva: %s     -->  Data Final Reserva: %s\n",
				this.cliente.getNome(), this.cliente.getSobrenome(), this.quarto.getTipoQuarto(), this.quarto.getValorDiaria(), dataInicial, dataFinal);
	}
	
	
}
