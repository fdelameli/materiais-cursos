public class AlunoDoutorado extends Aluno {

    private String tese;

    public AlunoDoutorado(String nome) {
        super(nome);
    }
    
    public void setTese(String tese) {
        this.tese = tese;
    }

    public void imprimeTese() {
        System.out.println(tese);
    }

    public void imprimeTipo() {
        System.out.println("Aluno do Doutorado");
    }
}