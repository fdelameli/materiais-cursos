package compiladorLMS.analise_lexica;

/**
 * Classe que representa um token da análise léxica.
 * @author Fabio Dela Bruna, Marcio Ozório Teixeira.
 *
 */
public class Token {
	
	/**
	 * Representa o código do token.
	 */
	private int codigo;
	
	/**
	 * Representa o tipo do token.
	 */
	private String tipo;

	/**
	 * Representa o token em questão ou o texto que foi
	 * digitado pelo usuário e reconhecido pela análise léxica.
	 */
	private String token;
	
	
	
	/**
	 * Construtor que recebe os dados do token por parâmetro.
	 */
	public Token( int codigo, String token, String tipo) {
		this.codigo = codigo;
		this.token = token;
		this.tipo = tipo;
	}
	
	
	/**
	 * Retorna o código do token.
	 */
	public int getCodigo() {
		return codigo;
	}

	/**
	 * Retorna o tipo do token.
	 */
	public String getTipo() {
		return tipo;
	}

	/**
	 * Retorna o token digitado pelo usuário e reconhecido pela análise léxica.
	 */
	public String getToken() {
		return token;
	}

	/**
	 * Seta o token digitado pelo usuário.
	 */
	public void setToken( String t ) {
		token = t;
	}
	
}
