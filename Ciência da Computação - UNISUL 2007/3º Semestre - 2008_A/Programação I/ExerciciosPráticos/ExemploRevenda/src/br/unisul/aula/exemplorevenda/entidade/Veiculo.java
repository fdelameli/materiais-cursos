package br.unisul.aula.exemplorevenda.entidade;

/**
 * Entidade Veiculo.
 * @author Fábio Dela Bruna
 * @since 22/04/2008
 */
public class Veiculo {

	// atributos
	
	private long codigo;
	private String marca;
	private String modelo;
	private int anoFabricacao;
	private int anoModelo;
	private String cor;
	private String placa;
	private String numeroChassi;
	private String numeroMotor;
	private String numeroRenavam;
	private double valorCompra;
	private String tipoCombustivel;
	
	
	// construtores
	
	/**
	 * Construtor default;
	 */
	public Veiculo() {
		super();
	}

	/**
	 * Construtor com parâmetros (com dados dos veículos).
	 * @param codigo - Código do veículo.
	 * @param marca - Marca.
	 * @param modelo - Modelo.
	 * @param anoFabricacao - Ano de fabricação.
	 * @param anoModelo - Ano de modelo.
	 * @param cor - Cor do veículo.
	 * @param placa - Placa.
	 * @param numeroChassi - Número do chassi.
	 * @param numeroMotor - Número do motor.
	 * @param numeroRenavam - Número do reavam.
	 * @param valorCompra - Valor de compra.
	 * @param tipoCombustivel - Tipo de combustível.
	 */
	public Veiculo(long codigo, String marca, String modelo, int anoFabricacao, int anoModelo, String cor, String placa, String numeroChassi, String numeroMotor, String numeroRenavam, double valorCompra, String tipoCombustivel) {
		super();
		this.codigo = codigo;
		this.marca = marca;
		this.modelo = modelo;
		this.anoFabricacao = anoFabricacao;
		this.anoModelo = anoModelo;
		this.cor = cor;
		this.placa = placa;
		this.numeroChassi = numeroChassi;
		this.numeroMotor = numeroMotor;
		this.numeroRenavam = numeroRenavam;
		this.valorCompra = valorCompra;
		this.tipoCombustivel = tipoCombustivel;
	}


	// getters e setters
	
	public long getCodigo() {
		return codigo;
	}

	public void setCodigo(long codigo) {
		this.codigo = codigo;
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

	public int getAnoFabricacao() {
		return anoFabricacao;
	}

	public void setAnoFabricacao(int anoFabricacao) {
		this.anoFabricacao = anoFabricacao;
	}

	public int getAnoModelo() {
		return anoModelo;
	}

	public void setAnoModelo(int anoModelo) {
		this.anoModelo = anoModelo;
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

	public String getNumeroChassi() {
		return numeroChassi;
	}

	public void setNumeroChassi(String numeroChassi) {
		this.numeroChassi = numeroChassi;
	}

	public String getNumeroMotor() {
		return numeroMotor;
	}

	public void setNumeroMotor(String numeroMotor) {
		this.numeroMotor = numeroMotor;
	}

	public String getNumeroRenavam() {
		return numeroRenavam;
	}

	public void setNumeroRenavam(String numeroRenavam) {
		this.numeroRenavam = numeroRenavam;
	}

	public double getValorCompra() {
		return valorCompra;
	}

	public void setValorCompra(double valorCompra) {
		this.valorCompra = valorCompra;
	}
	
	public String getTipoCombustivel() {
		return tipoCombustivel;
	}

	public void setTipoCombustivel(String tipoCombustivel) {
		this.tipoCombustivel = tipoCombustivel;
	}
	
	
	// toString
	
	public String toString(){
		return String.format("Código: %s\nMarca: %s\nModelo: %s\nAno Fabricação/Modelo  %s/%s\nCor: %s\nPlaca: %s\nNúmero chassi: %s\nNúmero Motor: %s\nNúmero renavam: %s\nTipo combustível: %s\nVALOR: %s", this.codigo, this.marca, this.modelo, this.anoFabricacao, this.anoModelo, this.cor, this.placa, this.numeroChassi, this.numeroMotor, this.numeroRenavam, this.tipoCombustivel, this.valorCompra);
	}
}
