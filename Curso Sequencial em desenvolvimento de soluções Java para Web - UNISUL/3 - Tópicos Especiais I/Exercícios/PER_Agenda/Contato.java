public class Contato {
    
    private int numero; // número do contato
	private String nome; // nome do contato
	private int idade; // idade do contato
    private String telefone; // telefone do contato
    
    public Contato() {
    	this.numero = 0;
    	this.nome = "";
    	this.idade = 0;
    	this.telefone = "";
    }
    
    public Contato(int numero, String nome, int idade, String telefone) {
		this.numero = numero;
		this.nome = nome;
		this.idade = idade;
		this.telefone = telefone;
	}
    
	public int getIdade() {
		return idade;
	}

	public void setIdade(int idade) {
		this.idade = idade;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String toString() {
        return this.numero + "\t" + this.nome + "\t" + this.idade + "\t" + this.telefone;
    }
}