public class AlunoGraduacao extends Aluno {

    private int numeroDisciplinas;
    
    public AlunoGraduacao(String nome) {
        super(nome);
    }

    public void setNumeroDisciplinas(int numeroDisciplinas) {
        this.numeroDisciplinas = numeroDisciplinas;
    }

    public void imprimeNumeroDisciplinas() {
        System.out.println(numeroDisciplinas);
    }
   
    public void imprimeTipo() {
        System.out.println("Aluno da Graduaçao");
    }
}