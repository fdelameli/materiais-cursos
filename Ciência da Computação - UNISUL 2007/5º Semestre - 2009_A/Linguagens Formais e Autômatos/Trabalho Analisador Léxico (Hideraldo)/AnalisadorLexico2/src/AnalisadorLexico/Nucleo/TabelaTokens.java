package AnalisadorLexico.Nucleo;
import java.util.ArrayList;

/**
 * Classe possue todas as palavras reservadas.
 * Utilizada para consulta.
 * @author 	Hideraldo Luís Simon Júnior
 * 			Marco Aurélio Lima Fernandes
 * 			Rodrigo Paschoal Jeremias
 * @since setembro de 2008
 *
 */
public class TabelaTokens {

	public ArrayList<Token> tokens= new ArrayList<Token>();

	/**
	 * Construtor da classe, onde são inseridas todas as palvras reservadas.
	 */
	public TabelaTokens() {
		super();
		this.tokens.add(new Token(1,"Program","Palavra Reservada"));
		this.tokens.add(new Token(2,"Label","Palavra Reservada"));
		this.tokens.add(new Token(3,"Const","Palavra Reservada"));
		this.tokens.add(new Token(4,"Var","Palavra Reservada"));
		this.tokens.add(new Token(5,"Procedure","Palavra Reservada"));
		this.tokens.add(new Token(6,"Begin","Palavra Reservada"));
		this.tokens.add(new Token(7,"End","Palavra Reservada"));
		this.tokens.add(new Token(8,"Integer","Palavra Reservada"));
		this.tokens.add(new Token(9,"Array","Palavra Reservada"));
		this.tokens.add(new Token(10,"Of","Palavra Reservada"));
		this.tokens.add(new Token(11,"Call","Palavra Reservada"));
		this.tokens.add(new Token(12,"Goto","Palavra Reservada"));
		this.tokens.add(new Token(13,"If","Palavra Reservada"));
		this.tokens.add(new Token(14,"Then","Palavra Reservada"));
		this.tokens.add(new Token(15,"Else","Palavra Reservada"));
		this.tokens.add(new Token(16,"While","Palavra Reservada"));
		this.tokens.add(new Token(17,"Do","Palavra Reservada"));
		this.tokens.add(new Token(18,"Repeat","Palavra Reservada"));
		this.tokens.add(new Token(19,"Until","Palavra Reservada"));
		this.tokens.add(new Token(20,"Readln","Palavra Reservada"));
		this.tokens.add(new Token(21,"Writeln","Palavra Reservada"));
		this.tokens.add(new Token(22,"Or","Operador Lógico (OU)"));
		this.tokens.add(new Token(23,"And","Operador Lógico (E)"));
		this.tokens.add(new Token(24,"Not","Operador de Negação"));
		//this.tokens.add(new Token(25,"Identificador","Palavra Reservada"));
		//this.tokens.add(new Token(26,"Inteiro","Palavra Reservada"));
		this.tokens.add(new Token(27,"For","Palavra Reservada"));
		this.tokens.add(new Token(28,"To","Palavra Reservada"));
		this.tokens.add(new Token(29,"Case","Palavra Reservada"));
		this.tokens.add(new Token(30,"+","Operador de Adição"));
		this.tokens.add(new Token(31,"-","Operador de Subtração"));
		this.tokens.add(new Token(32,"*","Operador de Multiplicação"));
		this.tokens.add(new Token(33,"/","Operador de Divisão"));
		this.tokens.add(new Token(34,"[","Abre Colchete"));
		this.tokens.add(new Token(35,"]","Fecha Colchete"));
		this.tokens.add(new Token(36,"(","Abre Parênteses"));
		this.tokens.add(new Token(37,")","Fecha Parênteses"));
		this.tokens.add(new Token(38,":=","Atribuição"));
		this.tokens.add(new Token(39,":","Dois Pontos"));
		this.tokens.add(new Token(40,"=","Igual"));
		this.tokens.add(new Token(41,">","Maior"));
		this.tokens.add(new Token(42,">=","Maior Igual"));
		this.tokens.add(new Token(43,"<","Menor"));
		this.tokens.add(new Token(44,"<=","Menor Igual"));
		this.tokens.add(new Token(45,"<>","Diferente"));
		this.tokens.add(new Token(46,",","Vírgula"));
		this.tokens.add(new Token(47,";","Ponto e Vírgula"));
		//this.tokens.add(new Token(48,"Literal","Palavra Reservada"));
		this.tokens.add(new Token(49,".","Ponto"));
		this.tokens.add(new Token(50,"..","Ponto Ponto"));
		this.tokens.add(new Token(51,"$","Delimitador"));	
	}
	
	/**
	 * Retorna o Token com o código inserido.
	 * null se o código não for encontrado.
	 * @param codigo int - codigo do token na tabela
	 * @return
	 */
	public Token retornaToken(int codigo){
		for (int i=0; i<tokens.size(); i++){
			if (codigo==tokens.get(i).getCodigo()){
				return tokens.get(i);
			}
		}
		return null;
	}
	
	/**
	 * Retorna o Token verificado.
	 * null se o Token não for encontrado.
	 * @param cadeia String - nome do Token a ser verificado
	 * @return
	 */
	public Token procurarToken(String cadeia){
		for (int i=0; i<tokens.size(); i++){
			if (cadeia.compareToIgnoreCase(tokens.get(i).getNome())==0){
				return tokens.get(i);
			}
		}
		return null;
	}
	
	/**
	 * Retorna o Token verificado.
	 * null se o Token não for encontrado.
	 * @param c char - nome do Token a ser verificado
	 * @return Token
	 */
	public Token procurarToken(char c){
		for (int i=0; i<tokens.size(); i++){
			if (tokens.get(i).getNome().length()==1){
				if (c==tokens.get(i).getNome().charAt(0)){
					return tokens.get(i);
				}
			}
		}
		return null;
	}
	
	/**
	 * Retorna um ArrayList<Token> com todos os símbolos não terminais
	 * @return ArrayList<Token>
	 */
	public ArrayList<Token> TabelaCompleta() {
		this.tokens= new ArrayList<Token>();
		this.tokens.add(new Token(1,"Program","Palavra Reservada"));
		this.tokens.add(new Token(2,"Label","Palavra Reservada"));
		this.tokens.add(new Token(3,"Const","Palavra Reservada"));
		this.tokens.add(new Token(4,"Var","Palavra Reservada"));
		this.tokens.add(new Token(5,"Procedure","Palavra Reservada"));
		this.tokens.add(new Token(6,"Begin","Palavra Reservada"));
		this.tokens.add(new Token(7,"End","Palavra Reservada"));
		this.tokens.add(new Token(8,"Integer","Palavra Reservada"));
		this.tokens.add(new Token(9,"Array","Palavra Reservada"));
		this.tokens.add(new Token(10,"Of","Palavra Reservada"));
		this.tokens.add(new Token(11,"Call","Palavra Reservada"));
		this.tokens.add(new Token(12,"Goto","Palavra Reservada"));
		this.tokens.add(new Token(13,"If","Palavra Reservada"));
		this.tokens.add(new Token(14,"Then","Palavra Reservada"));
		this.tokens.add(new Token(15,"Else","Palavra Reservada"));
		this.tokens.add(new Token(16,"While","Palavra Reservada"));
		this.tokens.add(new Token(17,"Do","Palavra Reservada"));
		this.tokens.add(new Token(18,"Repeat","Palavra Reservada"));
		this.tokens.add(new Token(19,"Until","Palavra Reservada"));
		this.tokens.add(new Token(20,"Readln","Palavra Reservada"));
		this.tokens.add(new Token(21,"Writeln","Palavra Reservada"));
		this.tokens.add(new Token(22,"Or","Operador Lógico (OU)"));
		this.tokens.add(new Token(23,"And","Operador Lógico (E)"));
		this.tokens.add(new Token(24,"Not","Operador de Negação"));
		this.tokens.add(new Token(25,"Identificador","Identificador"));
		this.tokens.add(new Token(26,"Inteiro","Número Inteiro"));
		this.tokens.add(new Token(27,"For","Palavra Reservada"));
		this.tokens.add(new Token(28,"To","Palavra Reservada"));
		this.tokens.add(new Token(29,"Case","Palavra Reservada"));
		this.tokens.add(new Token(30,"+","Operador de Adição"));
		this.tokens.add(new Token(31,"-","Operador de Subtração"));
		this.tokens.add(new Token(32,"*","Operador de Multiplicação"));
		this.tokens.add(new Token(33,"/","Operador de Divisão"));
		this.tokens.add(new Token(34,"[","Abre Colchete"));
		this.tokens.add(new Token(35,"]","Fecha Colchete"));
		this.tokens.add(new Token(36,"(","Abre Parênteses"));
		this.tokens.add(new Token(37,")","Fecha Parênteses"));
		this.tokens.add(new Token(38,":=","Atribuição"));
		this.tokens.add(new Token(39,":","Dois Pontos"));
		this.tokens.add(new Token(40,"=","Igual"));
		this.tokens.add(new Token(41,">","Maior"));
		this.tokens.add(new Token(42,">=","Maior Igual"));
		this.tokens.add(new Token(43,"<","Menor"));
		this.tokens.add(new Token(44,"<=","Menor Igual"));
		this.tokens.add(new Token(45,"<>","Diferente"));
		this.tokens.add(new Token(46,",","Vírgula"));
		this.tokens.add(new Token(47,";","Ponto e Vírgula"));
		this.tokens.add(new Token(48,"Literal","Constante Literal"));
		this.tokens.add(new Token(49,".","Ponto"));
		this.tokens.add(new Token(50,"..","Ponto Ponto"));
		this.tokens.add(new Token(51,"$","Delimitador"));	
		return this.tokens;
	}
}
