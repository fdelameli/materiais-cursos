package testeexer2;


public class Pessoa {

	private String nome;

	public Pessoa(String nome){
		this.nome = nome;
	}
	public Pessoa() {
		this("");
	}


	public void imprimeTipo(){
		System.out.println(this.getClass().getName());
	}


	public String getNome() {
		return nome;
	}


	public void setNome(String nome) {
		this.nome = nome;
	}

	
}