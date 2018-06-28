package compiladorLMS.analise_sintatica;

import java.util.ArrayList;
import java.util.Stack;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;

import compiladorLMS.analise_lexica.AnalisadorLexico;
import compiladorLMS.analise_lexica.TabelaToken;
import compiladorLMS.analise_lexica.Token;


/**
 * Classe responsável por realizar a análise sintática do código-fonte.
 * @author Fabio Dela Bruna, Márcio Ozório Teixeira.
 */
public class AnalisadorSintatico {

	/**
	 * Armazena a tabela de tokens.
	 */
	private ArrayList<Token> tabelaTokens = new TabelaToken().getTabelaTokens();
	
	
	/**
	 * Armazena a tabela de parse.
	 */
	private ArrayList<Regra> tabelaDeParse;
	
	/**
	 * Pilha de entrada. Fornecida pela análise léxica.
	 */
	private Stack<Integer> pilhaDeEntrada;
	
	/**
	 * Pilha de expansão.
	 */
	private Stack<Integer> pilhaDeExpansao;
	
	/**
	 * Constante que define o código do simbolo inicial da gramática.
	 */
	private final int SIMBOLO_INICIAL = 52;
	
	/**
	 * Constante que define o código do simbolo <code>cadeia vazia</code>.
	 */
	private final int CADEIA_VAZIA = 0;
	
	/**
	 * Armazena o simbolo do topo da pilha de expansão. 
	 */
	private int X;
	
	/**
	 * Armazena o token do topo da pilha de entrada.
	 */
	private int a;
	
	/**
	 * Armazena true se o fonte tiver erros 
	 * ou false, caso não contenha erros.
	 */
	private boolean temErro;
	
	/**
	 * Armazena a descrição do erro, caso tenha encontrado,
	 * caso contrário fica vazia;
	 */
	private String descricaoErro = null;
	
	/**
	 * Armazena os simbolos reconhecidos pela analise léxica.
	 */
	private ArrayList<Token> simbolosReconhecidos;
	
	/**
	 * Construtor da classe.
	 */
	public AnalisadorSintatico( String prog ) {
		
		pilhaDeEntrada = new Stack<Integer>(); // inicializa a pilha de entrada
		
		simbolosReconhecidos = new AnalisadorLexico().efetuarAnalise( prog );
		
		// preenche a pilha de entrada com os dados da análise léxica.
		for ( int i = 0; i < simbolosReconhecidos.size(); i++ ) {
			pilhaDeEntrada.push( simbolosReconhecidos.get(i).getCodigo() );
		}
		
		// inicializa a pilha de expansão.
		pilhaDeExpansao = new Stack<Integer>();
		pilhaDeExpansao.push( SIMBOLO_INICIAL ); // põe o simbolo inicial no topo da pilha de expansão.
		
		// pega a tabela de parse.
		tabelaDeParse = new DefinicoesSintaticas().getTabelaDeParse();
		
		iniciaAnalise(); // chama o método para inicializar a análise.

	}
	
	/**
	 * Método que efetua a análise sintática do programa-fonte.
	 * Caso a análise encontrar um erro, é retorna do false (para 
	 * indicar falha na análise), caso contrário, retorna true
	 * (para indicar sucesso na análise).
	 */
	public void iniciaAnalise() {
		
		int count = 0;
		
		do{ // faz o laço até que umas das pilhas esteja vazia.
		
			X = pilhaDeExpansao.elementAt( 0 ); // X recebe o elemento do topo da pilha de expansão.
			a = pilhaDeEntrada.elementAt( 0 ); // a recebe o elemento do topo da pilha de entrada.		
			
			
			if(pilhaDeEntrada.get(0) != 1 && count == 0){ //se não estiver símbolo inicial Program no inicio da cadeia ocorre um erro.
				descricaoErro = "Sem regra para " + tabelaTokens.get(a-1).getTipo().toLowerCase() + " '" + buscaSimbolo(a) + "' na posição inicial.";
				temErro = true;
				break; 
				
			} else {
				
				count++;
				
			if ( X > 0 && X <= 51 ) { // verifica se X é um terminal
				if ( X == a ) {
					pilhaDeExpansao.remove( 0 ); // remove X da pilha.
					pilhaDeEntrada.remove( 0 ); // remove a da pilha.
				} else { //erro o terminal encontrado na pilha de entrada não é igual ao teminal esperado na pilha de expansão.
					if(tabelaTokens.get(a-1).getTipo().equals(tabelaTokens.get(a-1).getToken()) && tabelaTokens.get(X-1).getTipo().equals(tabelaTokens.get(X-1).getToken())){
						descricaoErro = "Não esperava o " + tabelaTokens.get(a-1).getTipo() + " ' " + buscaSimbolo(a) + " '," +
										" era esperado um " + tabelaTokens.get(X-1).getTipo() +".";
					} else {
						if(tabelaTokens.get(a-1).getTipo().equals(tabelaTokens.get(a-1).getToken())){
							descricaoErro = "Não esperava o " + tabelaTokens.get(a-1).getTipo() + " ' " + buscaSimbolo(a) + " '," +
						    				" era esperado um " + tabelaTokens.get(X-1).getTipo() + " '" + tabelaTokens.get(X-1).getToken() + "'.";
						} else {
							if(tabelaTokens.get(X-1).getTipo().equals(tabelaTokens.get(X-1).getToken())){
								descricaoErro = "Não esperava o " + tabelaTokens.get(a-1).getTipo() + " ' " + buscaSimbolo(a) + " '," +
							    " era esperado um " + tabelaTokens.get(X-1).getTipo() +".";
							} else {
									descricaoErro = "Não esperava o " + tabelaTokens.get(a-1).getTipo() + " ' " + tabelaTokens.get(a-1).getToken() + " '," +
													" era esperado um " + tabelaTokens.get(X-1).getTipo() + " '" + tabelaTokens.get(X-1).getToken() + "'.";
								}
							}
						}
					temErro = true;
					break; // sai fora do laço pois encontrou um erro.
				}
				
			} else { // é não-terminal
				Regra regraReturn = getRegraFromTabelaDeParse( X, a ); // pega a regra na tabela de parse para X e a
				
				if ( regraReturn != null  ) { // se for diferente de null, então encontrou uma regra.
					ArrayList<Integer> derivacoes = getDerivacoes( regraReturn.getRegra() ); //retorna as derivações para a regra.
						
					if ( derivacoes.get( 0 ) == CADEIA_VAZIA ){ // verifica se é cadeia vazia
						pilhaDeExpansao.remove( 0 ); // remove X da pilha.
					} else { // se não é cadeia vazia
						derivaNaoTerminal( derivacoes, X ); // deriva nao-terminal X.
					}
						
				} else { // erro, pois não existe regra para X e a.
					descricaoErro = "Não esperava fim da cadeia após " + tabelaTokens.get(a-1).getTipo() + " '" + buscaSimbolo(a) + "'.";
					temErro = true;
					break; // sai fora do laço pois encontrou um erro.
				}
			}
			
			//Verifica se a pilha de entrada ficou vazia
			if(pilhaDeEntrada.isEmpty() && !pilhaDeExpansao.isEmpty()){
				descricaoErro = "Sem regra para fim da cadeia para " + tabelaTokens.get(X-1).getTipo().toLowerCase() + " '" + buscaSimbolo(X) + "'.";
				temErro = true;
				break;
			}
		  }
			
		} while ( !pilhaDeExpansao.isEmpty() || !pilhaDeEntrada.isEmpty() ); 

		if ( !temErro ) { // se análise for sucesso
			JOptionPane.showMessageDialog( null, new JLabel( "Análise sintática efetuada com sucesso!", SwingConstants.CENTER ), 
					"Sucesso", JOptionPane.PLAIN_MESSAGE , new ImageIcon("icons/ok.png"));
		} else { // se for falha
			JOptionPane.showMessageDialog( null, "ERRO SINTÁTICO!\n" + descricaoErro,
					"Erro", JOptionPane.ERROR_MESSAGE, new ImageIcon("icons/error.png") );
		}
	
	}
	

	/**
	 * Retorna a regra correspondente de acordo com os dados informados. 
	 */
	private Regra getRegraFromTabelaDeParse( Integer X, Integer a ) {
		Regra temp = null;
		for ( int i = 0; i < tabelaDeParse.size(); i++ ) {
			if ( tabelaDeParse.get( i ).getNaoTerminal() == X &&
					tabelaDeParse.get( i ).getTerminal() == a ) {
				temp = tabelaDeParse.get( i );
			}
		}
		return temp;
	}
	
	
	
	/**
	 * Retorna as derivações para a regra especificada.
	 */
	private ArrayList<Integer> getDerivacoes( Integer r ) {
		for ( int i = 0; i < tabelaDeParse.size(); i++ ) {
			if ( tabelaDeParse.get( i ).getRegra() == r )
				return tabelaDeParse.get( i ).getDerivacoes();
		}
		return null;
	}
	
	
	/**
	 * Substitui o não-terminal em questão por suas derivações.
	 */
	private void derivaNaoTerminal( ArrayList<Integer> deriv, Integer X ) {
		pilhaDeExpansao.remove( X ); // remove X da pilha
		//armazena as derivações de X na pilha
		for ( int i = 0; i < deriv.size(); i++ ) {
			pilhaDeExpansao.add( i, deriv.get( i ) );
		}		
	}
	
	/**
	 * Método que busca na tabela de simbolos reconhecidos o token a partir do código repassado
	 * @param codigo, do token a ser pesquisado
	 * @return temp, a string contendo o token em si
	 */
	private String buscaSimbolo(int codigo){
		String temp = null; 
		for (int i = 0; i < simbolosReconhecidos.size(); i++) {
			if(simbolosReconhecidos.get(i).getCodigo() == codigo)
				temp = simbolosReconhecidos.get(i).getToken();
		}
		return temp;
	}
	
}
