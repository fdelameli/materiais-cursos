import java.util.ArrayList;

/**
 * Classe que representa uma zona eleitoral.
 * @author Fabio Dela Bruna
 * @created 31-mai-2008 16:29:21
 */
public class Zona {

	//atributos
		
	private int numero;
	private String descricao;
	private ArrayList<Secao> secoes;

	
	//construtores
	
	public Zona(){
		this(0, "", new ArrayList<Secao>());
	}

	public Zona(int numero, String descricao, ArrayList<Secao> secoes) {
		super();
		this.numero = numero;
		this.descricao = descricao;
		this.secoes = new ArrayList<Secao>();
	}


	//métodos principais

	public boolean incluiSecao(Secao secao){
		this.secoes.add(secao);
		return true;
	}


	public boolean excluiSecao(Secao secao){
		this.secoes.remove(secao);
		return true;
	}


	//getters e setters

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public ArrayList<Secao> getSecoes() {
		return secoes;
	}

	public void setSecoes(ArrayList<Secao> secoes) {
		this.secoes = secoes;
	}


}