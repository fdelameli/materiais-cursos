package br.unisul.aula.trabalho.entidades;


/**
 * Entidade Veículo.
 * @author Fabio Dela Bruna, Marcio Ozório Teixeira.
 * @since 12/05/2008
 */
public class Veiculo {

	//attributes
	
	private int codigo;
	private double valor;
	private double valorKm;
	private String marca;
	private String modelo;
	private String cor;
	private String placa;
	private String numeroRenavam;
	private boolean alugado;
	
	
	//constructors
	
	/**
	 * Construtor default.
	 */
	public Veiculo() {
		this(0, 0, 0, "", "", "", "", "");
		this.alugado = false;
	}
	
	/**
	 * Construtor com parâmetros.
	 * 
	 * @param codigo - Código do veículo.
	 * @param valor - Valor do Carro.
	 * @param valorKm - Valor por quilometro.
	 * @param marca - Marca.
	 * @param modelo - Modelo.
	 * @param cor - Cor.
	 * @param placa - Placa.
	 * @param numeroRenavam - Número Renavam.
	 */
	public Veiculo(int codigo, double valor, double valorKm, String marca, String modelo,
			String cor, String placa, String numeroRenavam) {
		super();
		this.codigo = codigo;
		this.valor = valor;
		this.valorKm = valorKm;
		this.marca = marca;
		this.modelo = modelo;
		this.cor = cor;
		this.placa = placa;
		this.numeroRenavam = numeroRenavam;
		this.alugado = false;
	}
	
	
	//métodos PRINCIPAIS

	/**
	 * Método que retorna o valor da diária de um determinado veículo.
	 * @return Valor do Aluguel.
	 */
	public double getValorDiaria(){
		return 0;
	}
	
	/**
	 * Método que retorna o tipo do veículo.
	 * @return Tipo do veículo.
	 */
	public String getTipoVeiculo(){
		return null;
	}
	
	
	//getters e setters
	
	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public double getValor() {
		return valor;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}

	public double getValorKm() {
		return valorKm;
	}

	public void setValorKm(double valorKm) {
		this.valorKm = valorKm;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public String getCor() {
		return cor;
	}

	public void setCor(String cor) {
		this.cor = cor;
	}

	public String getPlaca() {
		return placa;
	}

	public void setPlaca(String placa) {
		this.placa = placa;
	}

	public String getNumeroRenavam() {
		return numeroRenavam;
	}

	public void setNumeroRenavam(String numeroRenavam) {
		this.numeroRenavam = numeroRenavam;
	}

	public boolean isAlugado() {
		return alugado;
	}

	public void setAlugado(boolean alugado) {
		this.alugado = alugado;
	}
	
	
	//toString e equals
	
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj instanceof Veiculo) {
			Veiculo veiculo = (Veiculo) obj;
			return (this.numeroRenavam.equals(veiculo.getNumeroRenavam())
					&& this.placa.equals(veiculo.getPlaca()));
		}
		return false;
	}
	
	public String toString(){
		return String.format("<<< DADOS VEÍCULO >>>\nTIPO: %s   --> Valor Diária: %s\nCódigo: %s\nMarca: %s\nModelo: %s\nCor: %s\nAlugado %s\n",
				getTipoVeiculo(), getValorDiaria(), this.codigo, this.marca, this.modelo, this.cor, (this.alugado ? "SIM" : "NÃO"));
	}
	
}
