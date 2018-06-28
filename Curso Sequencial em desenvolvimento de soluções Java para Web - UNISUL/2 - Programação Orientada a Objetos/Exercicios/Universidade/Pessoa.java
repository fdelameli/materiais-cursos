public class Pessoa {
    
    private String nome;     
    
    public Pessoa(String nome) {
        this.nome = nome;
    }
    
    public void setNome(String nome) {
    	this.nome = nome;
    }

    public void imprimeNome() {
    	System.out.println(nome);
    }
    
    public void imprimeTipo() {
        System.out.println("Pessoa");
    }
}