
public class ClientePreferencial extends Cliente {

	//construtor
	public ClientePreferencial(String nome, String dtNascimento, String identidade, String cpf, Endereco endereco) {
		super(nome, dtNascimento, identidade, cpf, endereco);
	}

	public ClientePreferencial(){
		super();
	}

	//metodos

	public double calculaDiariaPorCliente(Quarto quarto, int numDias){
		double resultado = quarto.calculaDiaria(numDias);
		resultado = resultado - (resultado*20/100);
		return resultado;
	}
}