
public class QuartoComum extends Quarto {


	//construtor
	public QuartoComum(int numQuarto, int qtdPessoas, double valorDiaria) {
		super(numQuarto, qtdPessoas, valorDiaria);
	}

	public QuartoComum(){
		super();
	}

	//metodos
	public double calculaDiaria(int qtdDias){
		this.setVerificaEstadia(false);
		return this.getValorDiaria()*qtdDias;
	}
}