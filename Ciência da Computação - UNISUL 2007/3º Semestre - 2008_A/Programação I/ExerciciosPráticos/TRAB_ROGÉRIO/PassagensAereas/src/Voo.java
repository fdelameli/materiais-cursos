package PassagensAereas.src;





// PRECISA DE AEROPORTOS...
public class Voo {

	private int numero;
	private String siglaCompanhia;
	private double hSaida;
	private double hChegada;
	private double saida;
	private double chegada;
	private String aeroSaida;
	private String aeroChegada;
	private Avioes aviao;
	public  ArrayList clientes;




	public Voo(){

	}




	public Voo(int numero, String companhia, double saida,
			double chegada, double saida2, double chegada2,
			String aeroSaida, String aeroChegada) {
		super();
		this.numero = numero;
		this.siglaCompanhia = companhia;
		hSaida = saida;
		hChegada = chegada;
		saida = saida2;
		chegada = chegada2;
		this.aeroSaida = aeroSaida;
		this.aeroChegada = aeroChegada;
		
	}
	
	
	
	public Voo(Integer integer, String string, Double double1, Double double2, Double double3, Double double4, String string2, String string3) {
		// TODO Auto-generated constructor stub
	}




	public boolean lotado(){
		return clientes.size()>aviao.getNumeroDePassageiros();
	}
	
	public void adicionarCliente(Object cliente){
		this.clientes.insertLast(cliente);
	}


	//***********************************GETS E SETS********************************
	
	public int getNumero() {
		return numero;
	}




	public void setNumero(int numero) {
		this.numero = numero;
	}




	public String getCompanhia() {
		return siglaCompanhia;
	}




	public void setSiglaCompanhia(String companhia) {
		this.siglaCompanhia = companhia;
	}




	public double getHSaida() {
		return hSaida;
	}




	public void setHSaida(double saida) {
		hSaida = saida;
	}




	public double getHChegada() {
		return hChegada;
	}




	public void setHChegada(double chegada) {
		hChegada = chegada;
	}




	public double getSaida() {
		return saida;
	}




	public void setSaida(double saida) {
		this.saida = saida;
	}




	public double getChegada() {
		return chegada;
	}




	public void setChegada(double chegada) {
		this.chegada = chegada;
	}




	public String getAeroSaida() {
		return aeroSaida;
	}




	public void setAeroSaida(String aeroSaida) {
		this.aeroSaida = aeroSaida;
	}




	public String getAeroChegada() {
		return aeroChegada;
	}




	public void setAeroChegada(String aeroChegada) {
		this.aeroChegada = aeroChegada;
	}




	public ArrayList getCliente() {
		return clientes;
	}




	public void setCliente(ArrayList clientes) {
		this.clientes = clientes;
	}
	
	public String toString(){
		return String.valueOf(numero);
	}
	
	


}
