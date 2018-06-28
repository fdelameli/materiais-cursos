

/**
 * @author Fabio
 * @version 1.0
 * @created 21-jun-2008 09:39:23
 */
public class Horista extends Funcionario {

	//attributes
	
	private double valorHora;
	private double numeroHoras;

	
	//constructors
	
	public Horista(int matricula, String nome){
		super(matricula, nome);
		this.valorHora = 0.0;
		this.numeroHoras = 0.0;
	}
	
	public Horista() {
		this(0, "");
	}


	//main methods

	public double calculaPagamento(){
		return this.valorHora * this.numeroHoras;
	}
	
	
	//getters e setters

	public double getValorHora() {
		return valorHora;
	}

	public void setValorHora(double valorHora) {
		this.valorHora = valorHora;
	}

	public double getNumeroHoras() {
		return numeroHoras;
	}

	public void setNumeroHoras(double numeroHoras) {
		this.numeroHoras = numeroHoras;
	}
	
	
	//toString
	
	public String toString() {
		return super.toString() + "\nQuant. Horas Trabalhadas: " + this.numeroHoras + "    --> Valor Hora: " + this.valorHora + "\nSalario: " + calculaPagamento();
	}
	

}