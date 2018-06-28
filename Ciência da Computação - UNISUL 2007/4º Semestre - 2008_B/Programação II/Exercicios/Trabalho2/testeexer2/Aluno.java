package testeexer2;


public class Aluno extends Pessoa {

	private String curso;

	public Aluno(String nome){
		super(nome);
		this.curso = "";
	}
	public Aluno() {
		super();
		this.curso = "";
	}

	public void imprimeTipo(){
		System.out.println(this.getClass().getName());
	}

	public void imprimeCurso(){
		System.out.println(this.curso);
	}

	public String getCurso() {
		return curso;
	}

	public void setCurso(String curso) {
		this.curso = curso;
	}

}