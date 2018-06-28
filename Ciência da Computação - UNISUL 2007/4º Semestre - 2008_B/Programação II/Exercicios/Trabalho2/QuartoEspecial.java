
public class QuartoEspecial extends Quarto {

	//construtor
	public QuartoEspecial(int numQuarto, int qtdPessoas, double valorDiaria) {
		super(numQuarto, qtdPessoas, valorDiaria);
	}

	public QuartoEspecial(){
		super();
	}

	//metodos
	public double calculaDiaria(int qtdDias){
		this.setVerificaEstadia(false);
		return this.getValorDiaria()* qtdDias;
	}

}