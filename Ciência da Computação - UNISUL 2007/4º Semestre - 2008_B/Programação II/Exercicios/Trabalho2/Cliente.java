

public abstract class Cliente {

	private String nome;
	private String dtNascimento;
	private String identidade;
	private String cpf;
	private Endereco endereco;


	//construtor
	public Cliente(String nome, String dtNascimento, String identidade, String cpf, Endereco endereco){
		this.nome = nome;
		this.dtNascimento = dtNascimento;
		this.identidade = identidade;
		this.cpf = cpf;
		this.endereco = endereco;
	}

	public Cliente () {
		this("", "", "", "", null);
	}

	//metodos

	public abstract double calculaDiariaPorCliente(Quarto quarto, int numDias);

	//Gets e Sets
	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getDtNascimento() {
		return dtNascimento;
	}

	public void setDtNascimento(String dtNascimento) {
		this.dtNascimento = dtNascimento;
	}

	public String getIdentidade() {
		return identidade;
	}

	public void setIdentidade(String identidade) {
		this.identidade = identidade;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}
}