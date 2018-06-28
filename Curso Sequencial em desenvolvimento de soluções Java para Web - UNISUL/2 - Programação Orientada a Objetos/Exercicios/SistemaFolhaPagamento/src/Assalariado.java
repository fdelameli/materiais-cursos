

/**
 * @author Fabio
 * @version 1.0
 * @created 21-jun-2008 09:39:22
 */
public class Assalariado extends Funcionario {

	//attributes
	
	private double salario;
	
	
	//constructors

	public Assalariado(int matricula, String nome){
		super(matricula, nome);
		this.salario = 0.0;
	}
	
	public Assalariado() {
		this(0, "");
	}


	//main methods
	
	public double calculaPagamento(){
		return this.salario;
	}
	
	
	//getters e setters

	public double getSalario() {
		return salario;
	}

	public void setSalario(double salario) {
		this.salario = salario;
	}
	
	
	//toString
	
	public String toString() {
		return super.toString() + "\nSalario: " + calculaPagamento();
	}
	

}