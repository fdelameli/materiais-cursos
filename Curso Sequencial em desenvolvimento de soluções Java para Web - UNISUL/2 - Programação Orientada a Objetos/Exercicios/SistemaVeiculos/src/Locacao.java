import java.util.GregorianCalendar;


/**
 * @author Fabio
 * @version 1.0
 * @created 21-jun-2008 14:11:09
 */
public abstract class Locacao {

	//attributes
	
	private GregorianCalendar dataInicial;
	private GregorianCalendar dataFinal;
	private long quantDias;
	private double kmInicial;
	private double kmFinal;
	private double kmPercorrida;
	private Cliente cliente;
	private Veiculo veiculo;

	
	//constructors
	
	public Locacao(GregorianCalendar dataInicial, GregorianCalendar dataFinal, double kmInicial, double kmFinal, Cliente cliente, Veiculo veiculo) {
		this.dataInicial = dataInicial;
		this.dataFinal = dataFinal;
		this.quantDias = (dataFinal.getTimeInMillis() - dataInicial.getTimeInMillis())/1000/60/60/24;
		this.kmInicial = kmInicial;
		this.kmFinal = kmFinal;
		this.kmPercorrida = kmFinal - kmInicial;
		this.cliente = cliente;
		this.veiculo = veiculo;
	}
	
	public Locacao(){
		this(new GregorianCalendar(), new GregorianCalendar(), 0, 0, new Cliente(), new Veiculo());
		this.kmPercorrida = this.kmFinal - this.kmInicial;
		this.quantDias = (dataFinal.getTimeInMillis() - dataInicial.getTimeInMillis())/1000/60/60/24;
	}


	//main method
	
	public double calculaValorLocacao(){
		return 0;
	}

	
	//getters e setters
	
	public GregorianCalendar getDataInicial() {
		return dataInicial;
	}

	public void setDataInicial(GregorianCalendar dataInicial) {
		this.dataInicial = dataInicial;
	}

	public GregorianCalendar getDataFinal() {
		return dataFinal;
	}

	public void setDataFinal(GregorianCalendar dataFinal) {
		this.dataFinal = dataFinal;
	}

	public long getQuantDias() {
		return quantDias;
	}

	public void setQuantDias(long quantDias) {
		this.quantDias = quantDias;
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

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Veiculo getVeiculo() {
		return veiculo;
	}

	public void setVeiculo(Veiculo veiculo) {
		this.veiculo = veiculo;
	}
	
	

}