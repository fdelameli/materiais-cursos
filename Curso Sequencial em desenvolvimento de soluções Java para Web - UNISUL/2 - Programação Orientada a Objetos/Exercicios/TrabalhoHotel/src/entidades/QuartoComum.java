package entidades;

/**
 * Classe que representa um Quarto do tipo Comum.
 * @author Fabio Dela Bruna / Carlos Henrique Sá
 *
 */
public class QuartoComum extends Quarto {
	
	//atributos
	
	private static final String TIPO = "COMUM";

	
	//construtores
	
	/**
	 * Construtor default.
	 */
	public QuartoComum() {
		super();
	}
	
	/**
	 * Construtor com parâmetros.
	 */
	public QuartoComum(int qtdPessoas, double valorDiaria) {
		super(qtdPessoas, valorDiaria);
	}
	
	
	//método principal
	
	@Override
	public String getTipoQuarto(){
		return TIPO;
	}
	
	
	//toString
	
	public String toString(){
		return String.format("Tipo Quarto: %s\n%s\n", TIPO, super.toString());
	}

}
