package testeexer2;


public class Professor extends Pessoa {

	private double salario;

	public Professor(String nome){
		super(nome);
		this.salario = 0.0;
	}
	public Professor() {
		super();
		this.salario = 0.0;
	}


	public void imprimeTipo(){
		System.out.println(this.getClass().getName());
	}

	public void imprimeSalario(){
		System.out.println(this.salario);
	}

	public double getSalario() {
		return salario;
	}


	public void setSalario(double salario) {
		this.salario = salario;
	}


}