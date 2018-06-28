public class Professor extends Pessoa {

    private double salario;
    
    public Professor(String nome) {
        super(nome);
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    public void imprimeSalario() { 
        System.out.println(salario);
    }	 

    public void imprimeTipo() {
        System.out.println("Professor");
    }
}