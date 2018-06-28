package PassagensAereas.src;


public class Atendentes extends Clientes {


	private String carteiraDeTrabalho;
	private String dataDeEmicao;




	public  Atendentes(){

	}

	public  Atendentes(String nome, String dataDeNascimento, String endereco,String fone,int CPF,int RG, String numeroMatricula, String carteiraDeTrabalho,String dataDeEmicao){

		this.setNome(nome);
		this.setDataDeNascimento(dataDeNascimento);
		this.setEndereco(endereco);
		this.setCPF(CPF);
		this.setRG(RG);
		this.setNumeroMatricula(numeroMatricula);
		this.carteiraDeTrabalho = carteiraDeTrabalho;
		this.dataDeEmicao = dataDeEmicao;
		this.setFone(fone);
		
		this.carteiraDeTrabalho = carteiraDeTrabalho;
		this.dataDeEmicao = dataDeEmicao;
				


	}
	
	
	
	//***************************************GETS E SETS************************************
	
	public Atendentes(String string, String string2, String string3, String string4, Integer integer, Integer integer2, String string5, String string6, String string7) {
		// TODO Auto-generated constructor stub
	}

	public String getCarteiraDeTrabalho() {
		return carteiraDeTrabalho;
	}

	public void setCarteiraDeTrabalho(String carteiraDeTrabalho) {
		this.carteiraDeTrabalho = carteiraDeTrabalho;
	}

	public String getDataDeEmicao() {
		return dataDeEmicao;
	}

	public void setDataDeEmicao(String dataDeEmicao) {
		this.dataDeEmicao = dataDeEmicao;
	}
	



	public String toString(){
		return this.getNome();
	}





}
