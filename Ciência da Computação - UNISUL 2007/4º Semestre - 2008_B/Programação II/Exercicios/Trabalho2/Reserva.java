

public class Reserva {

	private Cliente cliente;
	private Quarto quarto;


	//construtor

	public Reserva(Cliente cliente, Quarto quarto) {
		this.cliente = cliente;
		this.quarto = quarto;
	}

	public Reserva() {
		this(null, null);
	}


	//gets e sets
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

}