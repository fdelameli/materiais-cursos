
public class Endereco {

	private String rua;
	private String bairro;
	private String cidade;
	private String cep;
	private String nuTelefone;

	//construtor
	public Endereco(String rua, String bairro, String cidade, String cep, String nuTelefone){
		this.rua = rua;
		this.bairro = bairro;
		this.cidade = cidade;
		this.cep = cep;
		this.nuTelefone = nuTelefone;
	}

	public Endereco() {
		this("", "", "", "", "");
	}

	//gets e sets
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

	public String getNuTelefone() {
		return nuTelefone;
	}

	public void setNuTelefone(String nuTelefone) {
		this.nuTelefone = nuTelefone;
	}

	public String getRua() {
		return rua;
	}

	public void setRua(String rua) {
		this.rua = rua;
	}
}