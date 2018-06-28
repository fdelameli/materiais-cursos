
public class Estadia {

	private int qtdDias;
	private Quarto quarto;
	private Cliente cliente;


	//construtor
	public Estadia(int qtdDias, Quarto quarto, Cliente cliente){
		this.qtdDias = qtdDias;
		this.quarto = quarto;
		this.cliente = cliente;
	}

	public Estadia() {
		this(0, null, null);
	}

	//gets e sets
	public Quarto getQuarto() {
		return quarto;
	}


	public void setQuarto(Quarto quarto) {
		this.quarto = quarto;
	}

	public int getQtdDias() {
		return qtdDias;
	}

	public void setQtdDias(int qtdDias) {
		this.qtdDias = qtdDias;
	}
	public Cliente getCliente() {
		return cliente;
	}


	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

}