
public class ClienteEspecial extends Cliente {

	//construtor
	public ClienteEspecial(String nome, String dtNascimento, String identidade, String cpf, Endereco endereco) {
		super(nome, dtNascimento, identidade, cpf, endereco);
	}

	public ClienteEspecial(){
		super();
	}

	//metodos
	public double calculaDiariaPorCliente(Quarto quarto, int numDias){
		return quarto.calculaDiaria(numDias);
	}

}