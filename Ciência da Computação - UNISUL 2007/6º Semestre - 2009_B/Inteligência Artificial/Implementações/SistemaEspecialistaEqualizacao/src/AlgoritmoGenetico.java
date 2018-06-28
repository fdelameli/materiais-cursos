import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * Classe que implementa um algorítmo genético para o problema de
 * otimização combinatória para um equalizador.
 * 
 * @author Almir Hoepers, Fabio Dela Bruna, Márcio Ozório Teixeira.
 */
public class AlgoritmoGenetico {


	/**
	 * List de Cromossos que compõe a população inicial.
	 */
	private List<Cromossomo> populacaoInicial; 

	/**
	 * Objeto do tipo Cromossomo que representa o cromossomo que obtver
	 * melhor fitnees durante a execução do algoritmo. 
	 */
	private Cromossomo melhorCromossomo;
	private int countMutacao;

	/**
	 * Constante que representa o numero da população inicial.
	 */
	private static final int NU_POPULACAO = 10;

	/**
	 * Constante que representa o número de botões que o equalizador possui.
	 */
	private static final int NU_BOTOES = 9;

	/**
	 * JDialog que exibe o log do sistema.
	 */
	private FrameLog log;
	private String textoLog;
	private int countLog = -1;
	private int fitnessTotal;
	



	/**
	 * Construtor default da classe.
	 */
	public AlgoritmoGenetico() {
		log = new FrameLog();
		populacaoInicial = new ArrayList<Cromossomo>();
		countMutacao = 0;
		textoLog = "";
	}


	/**
	 * Método que inicializa o Algoritmo Genético.
	 */
	public Cromossomo equalizador() {

		geraPopulacaoInicial(); 

		for ( Cromossomo c : populacaoInicial ) {
			calculaFitness( c );
		}

		selecionaIndividuos();

		crossOver();

		log.setTextToLog(textoLog);
		log.setVisible(true);

		return melhorCromossomo;
	}


	/**
	 * Gera a população inicial que é de 10.
	 */
	private void geraPopulacaoInicial() {

		for ( int i = 0; i < NU_POPULACAO; i++ ) {

			Cromossomo cromossomo = new Cromossomo(); // Cria uma nova instância do objeto Cromossomo;

			for ( int j = 0; j < NU_BOTOES; j++ ) {

				int pos = 1 + ( int )( Math.random() * 15 ); // gera números aleatórios entre 1 e 16;
				String binario = decToBinary( pos ); // converte de decimal para binário;

				for ( int k = 0; k < binario.length(); k++ ) {
					cromossomo.getCodigoGenetico().add( Integer.parseInt( "" + binario.charAt( k ) ) );
				}				
			}
			populacaoInicial.add( cromossomo );
		}
	}


	/**
	 * Imprime o código genético e o fitness de cada Cromossomo.
	 */
	public void imprimiCromossomos() {
		for (int i = 0; i < NU_POPULACAO; i++) {
			for (int j = 0; j < populacaoInicial.get(i).getCodigoGenetico().size(); j++) {
				System.out.print(""+populacaoInicial.get(i).getCodigoGenetico().get(j));
			}
			System.out.print("\t" + populacaoInicial.get(i).getFitness());
			System.out.println();
		}

	}

	public void imprimiCromossomo(Cromossomo cromossomo) {
		for (int j = 0; j < cromossomo.getCodigoGenetico().size(); j++) {
			System.out.print(""+cromossomo.getCodigoGenetico().get(j));
		}
		System.out.print("\t" + cromossomo.getFitness());
		System.out.println();

	}

	/**
	 * Efetua o cálculo do fitness de acordo com a fórmula pré-determinada.
	 * Pelo fato de o java trabalhar como sendo 0 (zero) a posição inicial
	 * de um array, então diminuimos em 1 (um) cada índice da fórmula.
	 * @param c Objeto do tipo Cromossomo para calcular seu fitness.
	 */
	private void calculaFitness( Cromossomo c ) {
		int result = 9 + 
		c.getCodigoGenetico().get(  1 ) * c.getCodigoGenetico().get(  4 ) - 
		c.getCodigoGenetico().get( 22 ) * c.getCodigoGenetico().get( 13 ) +
		c.getCodigoGenetico().get( 23 ) * c.getCodigoGenetico().get(  3 ) - 
		c.getCodigoGenetico().get( 20 ) * c.getCodigoGenetico().get(  9 ) +
		c.getCodigoGenetico().get( 35 ) * c.getCodigoGenetico().get( 14 ) -
		c.getCodigoGenetico().get( 10 ) * c.getCodigoGenetico().get( 25 ) +
		c.getCodigoGenetico().get( 15 ) * c.getCodigoGenetico().get( 16 ) +
		c.getCodigoGenetico().get(  2 ) * c.getCodigoGenetico().get( 32 ) +
		c.getCodigoGenetico().get( 27 ) * c.getCodigoGenetico().get( 18 ) +
		c.getCodigoGenetico().get( 11 ) * c.getCodigoGenetico().get( 33 ) -
		c.getCodigoGenetico().get( 30 ) * c.getCodigoGenetico().get( 31 ) -
		c.getCodigoGenetico().get( 21 ) * c.getCodigoGenetico().get( 24 ) +
		c.getCodigoGenetico().get( 34 ) * c.getCodigoGenetico().get( 26 ) -
		c.getCodigoGenetico().get( 28 ) * c.getCodigoGenetico().get(  6 ) +
		c.getCodigoGenetico().get(  7 ) * c.getCodigoGenetico().get( 12 ) -
		c.getCodigoGenetico().get(  5 ) * c.getCodigoGenetico().get(  8 ) +
		c.getCodigoGenetico().get( 17 ) * c.getCodigoGenetico().get( 19 ) -
		c.getCodigoGenetico().get(  0 ) * c.getCodigoGenetico().get( 29 ) +
		c.getCodigoGenetico().get( 22 ) * c.getCodigoGenetico().get(  3 ) +
		c.getCodigoGenetico().get( 20 ) * c.getCodigoGenetico().get( 14 ) +
		c.getCodigoGenetico().get( 25 ) * c.getCodigoGenetico().get( 15 ) +
		c.getCodigoGenetico().get( 30 ) * c.getCodigoGenetico().get( 11 ) +
		c.getCodigoGenetico().get( 24 ) * c.getCodigoGenetico().get( 18 ) +
		c.getCodigoGenetico().get(  6 ) * c.getCodigoGenetico().get(  7 ) +
		c.getCodigoGenetico().get(  8 ) * c.getCodigoGenetico().get( 17 ) +
		c.getCodigoGenetico().get(  0 ) * c.getCodigoGenetico().get( 32 );
		c.setFitness( result ); // seta o fitness para o cromossomo.
	}


	/** 
	 * Converte decimal para binário. 
	 * @param dec O número decimal para converter. 
	 * @return Uma String contendo o número binário. 
	 */  
	public static String decToBinary( int dec ) {  
		String result = "";  

		while( dec > 0 ) {  
			result = ( dec & 1 ) + result;  
			dec >>= 1;  
		}  

		/* Completa os números binário com 0 para formar números de 4 bits */
		int qtd = 4 - result.length();
		String temp = "";

		for ( int i = 0; i < qtd; i++ ) {
			temp += "0";
		}
		/* Fim da gambiarra */

		return temp + result;  
	}  


	/**
	 * Método elitísta de escolha dos melhores indivíduos da população
	 * e seta o melhorCromossomo
	 * @param populacao 
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public void selecionaIndividuos(){
		//--
		Object[] populacaoOrdenada = getPopulacaoInicial().toArray();

		Arrays.sort( populacaoOrdenada,
				new Comparator() {
			public int compare( Object c1, Object c2 ) {
				return  ( ( Cromossomo)c2 ).getFitness() - ( ( Cromossomo) c1 ).getFitness();
			}
		}
		);
		//--
		setPopulacaoInicial(new ArrayList<Cromossomo>());
		for (int i = 0; i < 6; i++) {
			getPopulacaoInicial().add((Cromossomo)populacaoOrdenada[i]);
		}
		//--
		
		if(getMelhorCromossomo() == null){
			setMelhorCromossomo(new Cromossomo());
		}
		
		if(getMelhorCromossomo().getFitness() < getPopulacaoInicial().get(0).getFitness()){
			setMelhorCromossomo(getPopulacaoInicial().get(0));
		}

	}

	public void crossOver(){
		for(int i=1; i<=300; i++){
			List<Cromossomo> temp = new ArrayList<Cromossomo>();
			for(int j=0; j<getPopulacaoInicial().size(); j+=2){
				Cromossomo filho1 = new Cromossomo();
				filho1.getCodigoGenetico().addAll(getPopulacaoInicial().get(j).getCodigoGenetico().subList(0, 12));
				filho1.getCodigoGenetico().addAll(getPopulacaoInicial().get(j+1).getCodigoGenetico().subList(12, 24));
				filho1.getCodigoGenetico().addAll(getPopulacaoInicial().get(j).getCodigoGenetico().subList(24, 36));
				calculaFitness(filho1);
				temp.add(filho1);
				//--
				Cromossomo filho2 = new Cromossomo();
				filho2.getCodigoGenetico().addAll(getPopulacaoInicial().get(j+1).getCodigoGenetico().subList(0, 12));
				filho2.getCodigoGenetico().addAll(getPopulacaoInicial().get(j).getCodigoGenetico().subList(12, 24));
				filho2.getCodigoGenetico().addAll(getPopulacaoInicial().get(j+1).getCodigoGenetico().subList(24, 36));
				calculaFitness(filho2);
				temp.add(filho2);
			}
			getPopulacaoInicial().addAll(temp);
			
			int total = 0;
			for (int j = 0; j < populacaoInicial.size(); j++) {
				total += populacaoInicial.get(j).getFitness();
			}
			
			textoLog += "Iteração: " + ++countLog + "\t";
			textoLog += "Melhor Cromossomo da Interação: " + getPopulacaoInicial().get(0).getCodigoGenetico().toString()+"\t";
			textoLog += "Fitness: " + getPopulacaoInicial().get(0).getFitness()+"\n";
			textoLog += "\tFitness Total: " + total + "\n";
			textoLog += "Melhor Cromossomo: " + melhorCromossomo.getCodigoGenetico().toString()+ "\t";
			textoLog += melhorCromossomo.getFitness()+"\n\n";
			
			if(fitnessTotal < total){
				fitnessTotal = total;
				countMutacao = 0;
			} else {
				countMutacao++;
			}
			
			if(countMutacao == 10){
				mutacao();
				countMutacao = 0;
			}
			
			selecionaIndividuos();
		}
	}

	/**
	 * Efetua a mutação.
	 */
	public void mutacao(){
		textoLog += "mutação...\n\n";
		int indiceCromossomo = 1 + ( int )( Math.random() * 5 );//Defini o indice do cromossomo a ser mutado
		int indiceCodigo = 1 + ( int )( Math.random() * 35 );//Defini o indice do codigoGenetico a ser modificado 
		if(getPopulacaoInicial().get(indiceCromossomo).getCodigoGenetico().get(indiceCodigo) == 0){
			getPopulacaoInicial().get(indiceCromossomo).getCodigoGenetico().add(indiceCodigo, 1);
		} else if(getPopulacaoInicial().get(indiceCromossomo).getCodigoGenetico().get(indiceCodigo) == 1){
			getPopulacaoInicial().get(indiceCromossomo).getCodigoGenetico().add(indiceCodigo, 0);
		}
		
	}

	
	//------------------------------------
	// Getters and Setters
	//------------------------------------

	public void setPopulacaoInicial(List<Cromossomo> populacaoInicial) {
		this.populacaoInicial = populacaoInicial;
	}

	public List<Cromossomo> getPopulacaoInicial() {
		return populacaoInicial;
	}

	public Cromossomo getMelhorCromossomo() {
		return melhorCromossomo;
	}

	public void setMelhorCromossomo(Cromossomo melhorCromossomo) {
		this.melhorCromossomo = melhorCromossomo;
	}

	public int getCountMutacao() {
		return countMutacao;
	}

	public void setCountMutacao(int countMutacao) {
		this.countMutacao = countMutacao;
	}
}
