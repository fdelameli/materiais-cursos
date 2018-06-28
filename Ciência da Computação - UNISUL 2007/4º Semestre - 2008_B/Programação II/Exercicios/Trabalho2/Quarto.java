


public abstract class Quarto {

	private int numQuarto;
	private int qtdPessoas;
	private double valorDiaria;
	private boolean verificaReservado;
	private boolean verificaEstadia;

	//construtor
	public Quarto(int numQuarto, int qtdPessoas, double valorDiaria){
		this.numQuarto = numQuarto;
		this.qtdPessoas = qtdPessoas;
		this.valorDiaria = valorDiaria;
		this.verificaReservado = false;
		this.verificaEstadia = false;
	}

	public Quarto() {
		this(0,0,0.0);
		this.verificaReservado = false;
		this.verificaEstadia = false;
	}

	//metodos
	public abstract double calculaDiaria(int numDias);

	public boolean fazerReserva() {
		if(this.verificaReservado == false && this.verificaEstadia == false) {
			verificaReservado = true;
			return true;
		} else {
			return false;
		}
	}

	public boolean fazerEstadia() {
		if(this.verificaReservado == false && this.verificaEstadia == false) {
			verificaEstadia = true;
			return true;
		} else {
			return false;
		}
	}


	//gets e sets
	public int getNumQuarto() {
		return numQuarto;
	}

	public void setNumQuarto(int numQuarto) {
		this.numQuarto = numQuarto;
	}

	public int getQtdPessoas() {
		return qtdPessoas;
	}

	public void setQtdPessoas(int qtdPessoas) {
		this.qtdPessoas = qtdPessoas;
	}

	public double getValorDiaria() {
		return valorDiaria;
	}

	public void setValorDiaria(double valorDiaria) {
		this.valorDiaria = valorDiaria;
	}

	public boolean isVerificaEstadia() {
		return verificaEstadia;
	}

	public void setVerificaEstadia(boolean verificaEstadia) {
		this.verificaEstadia = verificaEstadia;
	}

	public boolean isVerificaReservado() {
		return verificaReservado;
	}

	public void setVerificaReservado(boolean verificaReservado) {
		this.verificaReservado = verificaReservado;
	}

}