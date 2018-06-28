
public class FuncionarioAssalariado extends Funcionario {

	// atributos
	
	private double salarioSemanal;
		
	
	// construtor
	
	/**
	 * Construtor com parâmetros
	 */
	public FuncionarioAssalariado(String nome, String sobrenome, String cpf, double salario) {
		super(nome, sobrenome, cpf);
		this.salarioSemanal = salario;		
	}

	
	// métodos
	
	@Override
	public double salario() {
		return salarioSemanal;
	}

	
	// getters e setters
	
	/**
	 * @return the salarioSemanal
	 */
	public double getSalarioSemanal() {
		return salarioSemanal;
	}

	/**
	 * @param salarioSemanal the salarioSemanal to set
	 */
	public void setSalarioSemanal(double salarioSemanal) {
		this.salarioSemanal = salarioSemanal;
	}
	
	
	// toString
	
	public String toString(){
		return String.format("%s\nSalário Semanal: %s", super.toString(), salarioSemanal);
	}
	
}