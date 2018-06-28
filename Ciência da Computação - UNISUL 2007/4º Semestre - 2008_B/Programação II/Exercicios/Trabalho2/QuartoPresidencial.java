
public class QuartoPresidencial extends Quarto {

	//construtor
	public QuartoPresidencial(int numQuarto, int qtdPessoas, double valorDiaria) {
		super(numQuarto, qtdPessoas, valorDiaria);
	}

	public QuartoPresidencial(){
		super();
	}

	//metodos
	public double calculaDiaria(int qtdDias){
		this.setVerificaEstadia(false);
		return this.getValorDiaria()*qtdDias;
	}

}