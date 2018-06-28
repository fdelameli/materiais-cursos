

/**
 * @author Fabio
 * @version 1.0
 * @created 07-jun-2008 10:43:35
 */
public class PessoaFisica extends Cliente {

	//atributos
	
	private String cpf;
	private String rg;
	
	
	//construtores

	public PessoaFisica(){
		super();
		this.cpf = "";
		this.rg = "";
	}

	public PessoaFisica(int codigo, String nome, String fone, Endereco endereco, Endereco enderecoEntrega, String cpf, String rg) {
		super(codigo, nome, fone, endereco, enderecoEntrega);
		this.cpf = cpf;
		this.rg = rg;
	}
	
	
	//getters e setters

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getRg() {
		return rg;
	}

	public void setRg(String rg) {
		this.rg = rg;
	}
	

}