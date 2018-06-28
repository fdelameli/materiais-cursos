
/**
 * @author Fabio
 * @version 1.0
 * @created 21-jun-2008 09:39:23
 */
public class Funcionario {

	//attributes
	
	private int matricula;
	private String nome;

	
	//constructors
	
	public Funcionario(int matricula, String nome){
		this.matricula = matricula;
		this.nome = nome;
	}

	public Funcionario() {
		this(0, "");
	}
	

	//main methods

	public double calculaPagamento(){
		return 0;
	}
	
	
	//getters e setters

	public int getMatricula() {
		return matricula;
	}

	public void setMatricula(int matricula) {
		this.matricula = matricula;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	
	
	//equals and toString
	
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj instanceof Funcionario) {
			Funcionario f = (Funcionario) obj;
			return this.matricula == f.matricula;
		}
		return false;
	}
	
	public String toString() {
		return ("Nome: " + this.nome + "    -->  Matricula: " + this.matricula);
	}

}