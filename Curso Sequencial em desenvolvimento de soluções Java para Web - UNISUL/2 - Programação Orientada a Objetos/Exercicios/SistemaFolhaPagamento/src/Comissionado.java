

/**
 * @author Fabio
 * @version 1.0
 * @created 21-jun-2008 10:55:27
 */
public class Comissionado extends Funcionario {

	//attributes

	private double vendaMensal;
	private double porcentagem;
	
	
	//constructors

	
	public Comissionado(int matricula, String nome) {
		super(matricula, nome);
		this.vendaMensal = 0.0;
		this.porcentagem = 0.0;
	}
	
	public Comissionado(){
		this(0, "");
	}


	//main methods

	public double calculaPagamento(){
		return this.vendaMensal * (porcentagem /100);
	}
	
	
	//getters e setters

	public double getVendaMensal() {
		return vendaMensal;
	}

	public void setVendaMensal(double vendaMensal) {
		this.vendaMensal = vendaMensal;
	}

	public double getPorcentagem() {
		return porcentagem;
	}

	public void setPorcentagem(double porcentagem) {
		this.porcentagem = porcentagem;
	}
	
	
	//toString
	
	public String toString() {
		return super.toString() + "\nVendaMensal: " + this.vendaMensal + "    --> Porcentagen: " + this.porcentagem + " %\nSalario: " + calculaPagamento();
	}
	

}