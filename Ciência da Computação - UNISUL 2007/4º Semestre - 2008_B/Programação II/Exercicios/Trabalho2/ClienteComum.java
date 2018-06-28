
public class ClienteComum extends Cliente {

	private double taxa;

	//construtor
	public ClienteComum(String nome, String dtNascimento, String identidade, String cpf, Endereco endereco) {
		super(nome, dtNascimento, identidade, cpf, endereco);
	}

	public ClienteComum(){
		super();
	}

	//metodos

	public double calculaDiariaPorCliente(Quarto quarto, int numDias){
		double resultado = quarto.calculaDiaria(numDias);
		resultado += this.taxa;
		return resultado;
	}

	//gets e sets
	public double getTaxa() {
		return taxa;
	}

	public void setTaxa(double taxa) {
		this.taxa = taxa;
	}

}