

/**
 * Classe que representa um cliente.
 * @created 31-mai-2008 11:25:41
 * @author Fabio Dela Bruna
 */
public class Cliente {
	
	//atributos

	private int codigo;
	private String nome;
	private String fone;
	private Endereco endereco;
	private Endereco enderecoEntrega;

	
	//construtores

	public Cliente(){
		this(0, "", "", new Endereco(), new Endereco());
	}

	public Cliente(int codigo, String nome, String fone, Endereco endereco, Endereco enderecoEntrega) {
		super();
		this.codigo = codigo;
		this.nome = nome;
		this.fone = fone;
		this.endereco = endereco;
		this.enderecoEntrega = enderecoEntrega;
	}


	//getters e setters
	
	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}
	
	public Endereco getEnderecoEntrega() {
		return enderecoEntrega;
	}

	public void setEnderecoEntrega(Endereco enderecoEntrega) {
		this.enderecoEntrega = enderecoEntrega;
	}

	public String getFone() {
		return fone;
	}

	public void setFone(String fone) {
		this.fone = fone;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

}