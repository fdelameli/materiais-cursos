package PassagensAereas.src;


public class Avioes {

	private String modelo;
	private String numeroDeSerie;
	private int numeroDePassageiros;
	private int anoDeFabricacao;
	private int mesDeFabricacao;
	private int diaDaFabricacao;
	
	
	
	
	
	
	// ***************************CONSTRUTORES******************************
	
	public Avioes(){
		
	}
	
	
	public Avioes(String modelo, String numeroDeSerie, int numeroDePassageiros,
			int anoDeFabricacao, int mesDeFabricacao, int diaDaFabricacao) {
		super();
		this.modelo = modelo;
		this.numeroDeSerie = numeroDeSerie;
		this.numeroDePassageiros = numeroDePassageiros;
		this.anoDeFabricacao = anoDeFabricacao;
		this.mesDeFabricacao = mesDeFabricacao;
		this.diaDaFabricacao = diaDaFabricacao;
	}


	
	
	//***********************************GETS E SETS********************************
	
	

	public Avioes(String string, String string2, Integer integer, Integer integer2, Integer integer3, Integer integer4) {
		// TODO Auto-generated constructor stub
	}


	public String getModelo() {
		return modelo;
	}


	public void setModelo(String modelo) {
		this.modelo = modelo;
	}


	public String getNumeroDeSerie() {
		return numeroDeSerie;
	}


	public void setNumeroDeSerie(String numeroDeSerie) {
		this.numeroDeSerie = numeroDeSerie;
	}


	public int getNumeroDePassageiros() {
		return numeroDePassageiros;
	}


	public void setNumeroDePassageiros(int numeroDePassageiros) {
		this.numeroDePassageiros = numeroDePassageiros;
	}


	public int getAnoDeFabricacao() {
		return anoDeFabricacao;
	}


	public void setAnoDeFabricacao(int anoDeFabricacao) {
		this.anoDeFabricacao = anoDeFabricacao;
	}


	public int getMesDeFabricacao() {
		return mesDeFabricacao;
	}


	public void setMesDeFabricacao(int mesDeFabricacao) {
		this.mesDeFabricacao = mesDeFabricacao;
	}


	public int getDiaDaFabricacao() {
		return diaDaFabricacao;
	}


	public void setDiaDaFabricacao(int diaDaFabricacao) {
		this.diaDaFabricacao = diaDaFabricacao;
	}
	
	
	
	
	
	
	
	
	
	


}
