


import java.util.ArrayList;

/**
 * Classe que representa Aviões de determinadas companhias aéreas.
 * @author Fabio Dela Bruna, Márcio Ozório.
 * @since 31/03/2008.
 */
public class Aviao {

	
	// Atributos
	
	private String marca;
	private String modelo;
	private int ano_fabricacao;
	private int numero;
	private ArrayList<Assento> assentos;
	private int anoFabricacao;

	
	// Construtores

	/**
	 * Construtor com parametros (com dados do avião).
	 * @param marca - Marca do avião;
	 * @param modelo - Modelo;
	 * @param ano_fabricacao - Ano de fabricação;
	 * @param numero - Número do avião;
	 * @param assentos = Acentos.
	 */
	public Aviao(int numero, String marca, String modelo, int ano_fabricacao, int qtd_assentos) {
		this.marca = marca;
		this.modelo = modelo;
		this.ano_fabricacao = ano_fabricacao;
		this.numero = numero;
		this.assentos = new ArrayList<Assento>();
		for(int i = 0; i < qtd_assentos; i++){
			this.assentos.add(new Assento(""+i));
		}
	} 

	
	//Métodos principais
	
	/**
	 * Método para reservar um acento em determinado avião.
	 */
	public boolean reservaAssento(){
		for(int i = 0; i < this.assentos.size(); i++){
			if(!this.assentos.get(i).estaReservado()){
				this.assentos.get(i).reservar();
				return true;
			}
		}
		return false;
	}
	
	/**
	 * Método para verificar se há vagas para reserva.
	 */
	public boolean temVaga(){
		for(int i = 0; i < this.assentos.size(); i++){
			if(!this.assentos.get(i).estaReservado()){
				return true;
			}
		}
		return false;
	}
	
	/**
	 * Método que retorna a quantidade de acentos Livres.
	 */
	public int getAcentosLivres(){
		int contador = 0;
		for(int i=0; i<this.assentos.size();i++){
			if(this.assentos.get(i).estaReservado() == false){
				contador++;
			}
		}
		return contador;
	}
	
	/**
	 * Método que retorna a quantidade de acentos Ocupados.
	 */
	public int getAcentosOcupados(){
		int contador = 0;
		for(int i=0; i<this.assentos.size();i++){
			if(this.assentos.get(i).estaReservado() == true){
				contador++;
			}
		}
		return contador;
	}
	
	/**
	 * Método que retorna a quantidade de acentos de determinado avião.
	 * @return
	 */
	public int getNumeroDeAcentos(){
		return this.assentos.size();
	}
	
	
	//Getters and Setters
	
	/**
	 * @return the ano_fabricacao
	 */
	public int getAno_fabricacao() {
		return ano_fabricacao;
	}

	/**
	 * @param ano_fabricacao the ano_fabricacao to set
	 */
	public void setAno_fabricacao(int ano_fabricacao) {
		this.ano_fabricacao = ano_fabricacao;
	}

	/**
	 * @return the assentos
	 */
	public ArrayList<Assento> getAssentos() {
		return assentos;
	}

	/**
	 * @param assentos the assentos to set
	 */
	public void setAssentos(ArrayList<Assento> assentos) {
		this.assentos = assentos;
	}

	/**
	 * @return the marca
	 */
	public String getMarca() {
		return marca;
	}

	/**
	 * @param marca the marca to set
	 */
	public void setMarca(String marca) {
		this.marca = marca;
	}

	/**
	 * @return the modelo
	 */
	public String getModelo() {
		return modelo;
	}

	/**
	 * @param modelo the modelo to set
	 */
	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	/**
	 * @return the numero
	 */
	public int getNumero() {
		return numero;
	}

	/**
	 * @param numero the numero to set
	 */
	public void setNumero(int numero) {
		this.numero = numero;
	}
	

	//equals e toString
	
	/**
	 * Método para verificar se determinado avião já está cadastrado.
	 */
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj instanceof Aviao) {
			Aviao aviao = (Aviao) obj;
			return this.numero == aviao.numero;
		}
		return false;
	}

	/**
	 * Método para mostrar os aviões cadastrados.
	 */
	public String toString() {
		return "Marca: " + this.marca + "\nModelo: " + this.modelo + "\nAno de Fabricação: " + this.ano_fabricacao + "\nNúmero: " + this.numero;
	}
	
}