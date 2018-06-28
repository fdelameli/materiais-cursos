import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Classe que representa um eleitor.
 * @author Fabio Dela Bruna
 * @created 31-mai-2008 16:29:21
 */
public class Eleitor {

	//atributos
	
	private String nome;
	private Date dataNascimento;
	private int numeroInscricao;
	private Secao secao;
	private Date dataEmissaoTitulo;
	private boolean votou;

	
	//construtores
	
	public Eleitor(){
		this("", new Date(), 0, new Secao(), new Date(), false);
	}

	public Eleitor(String nome, Date dataNascimento, int numeroInscricao, Secao secao, Date dataEmissaoTitulo, boolean votou) {
		super();
		this.nome = nome;
		this.dataNascimento = dataNascimento;
		this.numeroInscricao = numeroInscricao;
		this.secao = secao;
		this.dataEmissaoTitulo = dataEmissaoTitulo;
	}

	
	//métodos do modelo
	
	public boolean votar(Candidato candidato){
		if(!this.votou){
			candidato.adicionaVoto();
			return true;
		}
		return false;
	}

	
	//getters e setters
	
	public String getDataEmissaoTitulo() {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		String dataFormatada = sdf.format(this.dataNascimento);
		return dataFormatada;
	}

	public void setDataEmissaoTitulo(Date dataEmissaoTitulo) {
		this.dataEmissaoTitulo = dataEmissaoTitulo;
	}

	public String getDataNascimento() {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		String dataFormatada = sdf.format(this.dataNascimento);
		return dataFormatada;
	}

	public void setDataNascimento(Date dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getNumeroInscricao() {
		return numeroInscricao;
	}

	public void setNumeroInscricao(int numeroInscricao) {
		this.numeroInscricao = numeroInscricao;
	}

	public Secao getSecao() {
		return secao;
	}

	public void setSecao(Secao secao) {
		this.secao = secao;
	}

}