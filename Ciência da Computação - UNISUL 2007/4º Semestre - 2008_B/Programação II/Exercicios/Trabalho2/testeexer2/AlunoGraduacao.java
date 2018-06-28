package testeexer2;


public class AlunoGraduacao extends Aluno {

	private int numDisciplinas;

	public AlunoGraduacao(String nome){
		super(nome);
		this.numDisciplinas = 0;
	}
	public AlunoGraduacao() {
		super();
		this.numDisciplinas = 0;
	}


	public void imprimeTipo(){
		System.out.println(this.getClass().getName());
	}

	public void imprimeNumDisciplinas(){
		System.out.println(this.numDisciplinas);
	}

	//gets e sets
	public int getNumDisciplinas() {
		return numDisciplinas;
	}


	public void setNumDisciplinas(int numDisciplinas) {
		this.numDisciplinas = numDisciplinas;
	}

}