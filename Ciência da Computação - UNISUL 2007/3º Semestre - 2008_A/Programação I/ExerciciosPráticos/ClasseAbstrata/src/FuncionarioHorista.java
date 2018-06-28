
public class FuncionarioHorista extends Funcionario {

	// atributos
	
	private double horasTrabalhadas;
	private double valorHora;
	
	
	// construtor
	
	/**
	 * Construtor com parametros
	 * @param nome
	 * @param sobrenome
	 * @param cpf
	 */
	public FuncionarioHorista(String nome, String sobrenome, String cpf, double horas, double valor) {
		super(nome, sobrenome, cpf);
		this.horasTrabalhadas = horas;
		this.valorHora = valor;
	}

	
	// métodos
	
	@Override
	public double salario() {
		double salario = 0;
		if(horasTrabalhadas <= 40)
			salario = 40 * valorHora;
		else
			salario = 40 * valorHora + (horasTrabalhadas - 40) * valorHora * 1.5;
		
		return salario;
	}


	// getters e setters
	
	/**
	 * @return the horasTrabalhadas
	 */
	public double getHorasTrabalhadas() {
		return horasTrabalhadas;
	}

	/**
	 * @param horasTrabalhadas the horasTrabalhadas to set
	 */
	public void setHorasTrabalhadas(double horasTrabalhadas) {
		this.horasTrabalhadas = horasTrabalhadas;
	}

	/**
	 * @return the valorHora
	 */
	public double getValorHora() {
		return valorHora;
	}

	/**
	 * @param valorHora the valorHora to set
	 */
	public void setValorHora(double valorHora) {
		this.valorHora = valorHora;
	}
	
	
	// toString
	
	public String toString(){
		return String.format("%s\nSalario: %s", super.toString(), salario());
	}
	
}
