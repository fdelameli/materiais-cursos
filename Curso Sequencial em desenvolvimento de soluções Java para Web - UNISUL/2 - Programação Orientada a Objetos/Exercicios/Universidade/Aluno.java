public class Aluno extends Pessoa {

    private String curso;

    public Aluno(String nome) {
        super(nome);
    }

    public void setCurso(String curso) {
        this.curso = curso;
    }
    
    public void imprimeCurso() {
        System.out.println(curso);
    }

    public void imprimeTipo() {
    	System.out.println("Aluno");
    }
}