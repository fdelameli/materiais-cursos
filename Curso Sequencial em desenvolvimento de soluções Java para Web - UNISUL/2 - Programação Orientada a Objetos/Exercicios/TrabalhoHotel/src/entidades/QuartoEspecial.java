package entidades;

/**
 * Classe que representa um Quarto do tipo Especial.
 * @author Fabio Dela Bruna / Carlos Henrique Sá
 *
 */
public class QuartoEspecial extends Quarto {
	
	//atributos
	
	private static final String TIPO = "ESPECIAL";

	
	//construtores
	
	/**
	 * Construtor default.
	 */
	public QuartoEspecial() {
		super();
	}

	/**
	 * Construtor com parâmetros.
	 */
	public QuartoEspecial(int qtdPessoas, double valorDiaria) {
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