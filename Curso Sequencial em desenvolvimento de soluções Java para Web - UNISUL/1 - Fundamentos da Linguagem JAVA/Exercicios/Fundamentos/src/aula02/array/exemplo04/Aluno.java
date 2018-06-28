package aula02.array.exemplo04;

public class Aluno {

	String nome;
	double n1, n2, n3;
	
	
	public Aluno(String nome, double n1, double n2, double n3) {
		super();
		this.nome = nome;
		this.n1 = n1;
		this.n2 = n2;
		this.n3 = n3;
	}
	
	
	public double getMedia(){
		return (n1+n2+n3)/3;
	}
	
}
