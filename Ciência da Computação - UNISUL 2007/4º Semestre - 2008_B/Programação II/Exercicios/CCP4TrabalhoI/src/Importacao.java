import java.io.Serializable;

/**
 * Classe que representa o objeto de cada linha dos textos dos arquivos txt`s.
 * @author Márcio Ozório Teixeira / Edu Schmoller.
 * @since 01/09/2008.
 */
public class Importacao implements Serializable{

	private static final long serialVersionUID = 1L;
	private String livro;
	private int capitulo;
	private int versículo;
	private String texto;

	/**
	 * Construtor padrão
	 */
	public Importacao() {
		super();
	}

	/**
	 * Construtor com parâmetros
	 * @param nomeLivro
	 * @param capitulo
	 * @param versículo
	 * @param texto
	 */
	public Importacao(String nomeLivro, int capitulo, int versículo,
			String texto) {
		super();
		this.livro = nomeLivro;
		this.capitulo = capitulo;
		this.versículo = versículo;
		this.texto = texto;
	}

	
	/**
	 * Getters e Setters
	 */
	
	public String getNomeLivro() {
		return livro;
	}

	public void setNomeLivro(String nomeLivro) {
		this.livro = nomeLivro;
	}

	public int getCapitulo() {
		return capitulo;
	}

	public void setCapitulo(int capitulo) {
		this.capitulo = capitulo;
	}

	public int getVersículo() {
		return versículo;
	}

	public void setVersículo(int versículo) {
		this.versículo = versículo;
	}

	public String getTexto() {
		return texto;
	}

	public void setTexto(String texto) {
		this.texto = texto;
	}

	
}
