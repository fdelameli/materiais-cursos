package PassagensAereas.src;





public class Clientes {

	private String numeroMatricula;
	private String nome;
	private String dataDeNascimento;
	private String endereco;
	private String fone;
	private int CPF;
	private int RG;



	//*************        Construtores       **************************************


	public  Clientes(){

	}

	public  Clientes(String nome, String dataDeNascimento, String endereco,String fone,int CPF,int RG, String numeroMatricula){

		this.nome = nome;
		this.dataDeNascimento = dataDeNascimento;
		this.endereco = endereco;
		this.CPF = CPF;
		this.RG = RG;
		this.numeroMatricula = numeroMatricula;
		this.fone = fone;

	}




	// ****************************Funções e Procedimentos*******************************





	//*****************************GetsSets***********************************************


	public Clientes(String string, String string2, String string3, String string4, Integer integer, Integer integer2, String string5) {
		// TODO Auto-generated constructor stub
	}

	public int getCPF() {
		return CPF;
	}

	public void setCPF(int cpf) {
		CPF = cpf;
	}

	public String getDataDeNascimento() {
		return dataDeNascimento;
	}

	public void setDataDeNascimento(String dataDeNascimento) {
		this.dataDeNascimento = dataDeNascimento;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getNumeroMatricula() {
		return numeroMatricula;
	}

	public void setNumeroMatricula(String numeroMatricula) {
		this.numeroMatricula = numeroMatricula;
	}

	public int getRG() {
		return RG;
	}

	public void setRG(int rg) {
		RG = rg;
	}

	public String getFone() {
		return fone;
	}

	public void setFone(String fone) {
		this.fone = fone;
	}

	
	

	public String toString(){
		return nome;
	}










}
