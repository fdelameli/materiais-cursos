

/**
 * @author Fabio
 * @version 1.0
 * @created 07-jun-2008 10:43:35
 */
public class PessoaJuridica extends Cliente {

	//atributos
	
	private String cpnj;
	private String nomeContato;
	private String inscricaoEstadual;

	
	//construtores
	
	public PessoaJuridica(){

	}

	public PessoaJuridica(int codigo, String nome, String fone, Endereco endereco,
		Endereco enderecoEntrega, String cnpj, String nomeContato, String inscricaoEstadual) {
		super(codigo, nome, fone, endereco, enderecoEntrega);
		this.cpnj = cnpj;
		this.nomeContato = nomeContato;
		this.inscricaoEstadual = inscricaoEstadual;
	}

	
	//getters e setters
	
	public String getCpnj() {
		return cpnj;
	}

	public void setCpnj(String cpnj) {
		this.cpnj = cpnj;
	}

	public String getNomeContato() {
		return nomeContato;
	}

	public void setNomeContato(String nomeContato) {
		this.nomeContato = nomeContato;
	}

	public String getInscricaoEstadual() {
		return inscricaoEstadual;
	}

	public void setInscricaoEstadual(String inscricaoEstadual) {
		this.inscricaoEstadual = inscricaoEstadual;
	}
	

}