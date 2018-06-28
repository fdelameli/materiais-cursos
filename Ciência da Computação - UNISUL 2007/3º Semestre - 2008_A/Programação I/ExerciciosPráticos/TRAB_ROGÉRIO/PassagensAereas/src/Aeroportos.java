package PassagensAereas.src;


public class Aeroportos {


	private String nome;
	private String local;



	public Aeroportos(){

	}


	public Aeroportos(String nome, String local) {
		super();
		this.nome = nome;
		this.local = local;
	}










	// *************************************GETS e SETS************************************
	// *************************************************************************************

	public String getLocal() {
		return local;
	}


	public void setLocal(String local) {
		this.local = local;
	}


	public String getNome() {
		return nome;
	}


	public void setNome(String nome) {
		this.nome = nome;
	}

	public String toString(){
		return nome;
	}

















}
