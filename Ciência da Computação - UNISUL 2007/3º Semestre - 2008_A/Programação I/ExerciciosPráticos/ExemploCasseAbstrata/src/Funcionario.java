
public class Funcionario extends Pessoa{

	
	// construtor
	
	/**
	 * Construtor com parâmetros
	 * @param nome - nome do funcionario
	 * @param idade - idade do funcionario
	 */
	public Funcionario(String nome, int idade) {
		super(nome, idade);
	
	}

	
	// métodos
	
	@Override
	public boolean verificaDependentes() {
		return false;
	}
	
	

}
