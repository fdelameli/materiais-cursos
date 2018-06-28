package testeexer2;


public class AlunoDoutorado extends Aluno {

	private String tese;

	public AlunoDoutorado(String nome){
		super(nome);
		this.tese = "";
	}
	public AlunoDoutorado() {
		super();
		this.tese = "";
	}


	public void imprimeTipo(){
		System.out.println(this.getClass().getName());
	}

	public void imprimeTese(){
		System.out.println(this.tese);
	}


	public String getTese() {
		return tese;
	}


	public void setTese(String tese) {
		this.tese = tese;
	}

	
}