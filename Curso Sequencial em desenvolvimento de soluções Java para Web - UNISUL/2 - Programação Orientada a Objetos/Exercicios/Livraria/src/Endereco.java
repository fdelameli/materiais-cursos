

/**
 * Classe que representa um emdereço.
 * @created 31-mai-2008 11:25:41
 * @author Fabio Dela Bruna
 */
public class Endereco {

	//atributos
	
	private int numero;
	private String rua;
	private String bairro;
	private String cidade;
	private String estado;
	private String cep;

	
	//construtores

	public Endereco(){
		this(0, "", "", "", "", "");
	}

	public Endereco(int numero, String rua, String bairro, String cidade, String estado, String cep) {
		super();
		this.numero = numero;
		this.rua = rua;
		this.bairro = bairro;
		this.cidade = cidade;
		this.estado = estado;
		this.cep = cep;
	}

	
	//getters e setters.
	
	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public String getRua() {
		return rua;
	}

	public void setRua(String rua) {
		this.rua = rua;
	}

}