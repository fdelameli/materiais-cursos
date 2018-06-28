
public class FuncionarioComissionado extends Funcionario {

	// atributos
	
	private double vendaBruta;
	private double porcentagem;
	
	
	// construtor
	
	/**
	 * Construtor com parametros
	 * @param nome
	 * @param sobrenome
	 * @param cpf
	 */
	public FuncionarioComissionado(String nome, String sobrenome, String cpf, double vendaBruta, double porcentagem) {
		super(nome, sobrenome, cpf);
		this.vendaBruta = vendaBruta;
		this.porcentagem = porcentagem;		
	}

	
	// métodos
	
	@Override
	public double salario() {
		return vendaBruta * porcentagem;
	}


	// getters e setters
	
	/**
	 * @return the porcentagem
	 */
	public double getPorcentagem() {
		return porcentagem;
	}

	/**
	 * @param porcentagem the porcentagem to set
	 */
	public void setPorcentagem(double porcentagem) {
		this.porcentagem = porcentagem;
	}

	/**
	 * @return the vendaBruta
	 */
	public double getVendaBruta() {
		return vendaBruta;
	}

	/**
	 * @param vendaBruta the vendaBruta to set
	 */
	public void setVendaBruta(double vendaBruta) {
		this.vendaBruta = vendaBruta;
	}

	
	// toString
	
	public String toString(){
		return String.format("%s\nVenda Bruta: R$ %s\nPorcetagem: %s\nSalario: %s", super.toString(), vendaBruta, porcentagem, salario());
	}
	
}
