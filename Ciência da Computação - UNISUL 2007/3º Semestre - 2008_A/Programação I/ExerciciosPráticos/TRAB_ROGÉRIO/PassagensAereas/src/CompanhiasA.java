package PassagensAereas.src;


public class CompanhiasA {


	private String nome;
	private String sigla;
	private int avioes;
	private int voos;
	


	public  CompanhiasA(){

	}


	public  CompanhiasA(String nome,String sigla,int avioes){
		this.nome =  nome;
		this.sigla = sigla;
		this.avioes = avioes;
	}
	
	
	public CompanhiasA(String string, String string2, Integer integer) {
		// TODO Auto-generated constructor stub
	}


	public boolean sobrecarga(){
		return avioes<voos;
	}


	
	
	
	//************************************GETS E SETS**************************************
	
	public String getNome() {
		return nome;
	}


	public void setNome(String nome) {
		this.nome = nome;
	}


	public String getSigla() {
		return sigla;
	}


	public void setSigla(String sigla) {
		this.sigla = sigla;
	}


	public int getAvioes() {
		return avioes;
	}


	public void setAvioes(int avioes) {
		this.avioes = avioes;
	}










}
