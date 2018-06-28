import java.util.ArrayList;



/**
 * @author Fabio
 * @version 1.0
 * @created 21-jun-2008 14:11:09
 */
public class Cliente {

	//attributes
	
	private int codigo;
	private String nome;
	private ArrayList<Locacao> locacoes;
	
	
	//constructors

	
	public Cliente(int codigo, String nome) {
		this.codigo = codigo;
		this.nome = nome;
		this.locacoes = new ArrayList<Locacao>();
	}
	
	public Cliente(){
		this(0, "");
		this.locacoes = new ArrayList<Locacao>();
	}

	
	//main methods
	
	public double calculaValorLocacao(){
		return 0;
	}
	
	
	//getters e setters

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public ArrayList<Locacao> getLocacoes() {
		return locacoes;
	}

	public void setLocacoes(ArrayList<Locacao> locacoes) {
		this.locacoes = locacoes;
	}


}