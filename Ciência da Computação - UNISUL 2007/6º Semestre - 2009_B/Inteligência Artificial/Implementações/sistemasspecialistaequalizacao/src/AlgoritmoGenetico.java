import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Random;


public class AlgoritmoGenetico {

	private Random rand = new Random();
	private Cromossomo cromossomo;
	private List<Cromossomo> populacaoInicial; 
	private static final int NU_POPULACAO = 10; // populacao inicial
	private static final int NU_BOTOES = 9; // quantidade de botoes
	private Cromossomo melhorCromossomo;


	/**
	 * Construtor.
	 */
	public AlgoritmoGenetico() {
		populacaoInicial = new ArrayList<Cromossomo>();
	}
	
	
	public void nomeADecidir() {
		
		geraPopulacaoInicial(); 
		
		for (Cromossomo c : populacaoInicial) {
			calculaFitness(c);
		}
		
		selecionaIndividuos(populacaoInicial);
	}


	/**
	 * Gera a população inicial.
	 */
	private void geraPopulacaoInicial() {

		for (int i = 0; i < NU_POPULACAO; i++) {

			cromossomo = new Cromossomo();

			for (int j = 0; j < NU_BOTOES; j++) {

				int pos = 1+(int)(Math.random()*15); // gera números aleatórios entre 1 e 16;
				String binario = decToBinary( pos );
				
				for (int k = 0; k < binario.length(); k++) {
					cromossomo.getCodigoGenetico().add(Integer.parseInt(""+binario.charAt(k)));
				}
				
			}
			
			populacaoInicial.add(cromossomo);
		}

	}
	
	
	


	public void imprimiCromossomos() {
		for (int i = 0; i < NU_POPULACAO; i++) {
			for (int j = 0; j < populacaoInicial.get(i).getCodigoGenetico().size(); j++) {
				System.out.print(""+populacaoInicial.get(i).getCodigoGenetico().get(j));
			}
			System.out.println();
		}

	}
	
	
	/**
	 * Efetua o cálculo do fitness.
	 */
	private void calculaFitness(Cromossomo c) {
		int result = 9 + 
			c.getCodigoGenetico().get(1) * c.getCodigoGenetico().get(4) - 
			c.getCodigoGenetico().get(22) * c.getCodigoGenetico().get(13) +
			c.getCodigoGenetico().get(23) * c.getCodigoGenetico().get(3) - 
			c.getCodigoGenetico().get(20) * c.getCodigoGenetico().get(9) +
			c.getCodigoGenetico().get(35) * c.getCodigoGenetico().get(14) -
			c.getCodigoGenetico().get(10) * c.getCodigoGenetico().get(25) +
			c.getCodigoGenetico().get(15) * c.getCodigoGenetico().get(16) +
			c.getCodigoGenetico().get(2) * c.getCodigoGenetico().get(32) +
			c.getCodigoGenetico().get(27) * c.getCodigoGenetico().get(18) +
			c.getCodigoGenetico().get(11) * c.getCodigoGenetico().get(33) -
			c.getCodigoGenetico().get(30) * c.getCodigoGenetico().get(31) -
			c.getCodigoGenetico().get(21) * c.getCodigoGenetico().get(24) +
			c.getCodigoGenetico().get(34) * c.getCodigoGenetico().get(26) -
			c.getCodigoGenetico().get(28) * c.getCodigoGenetico().get(6) +
			c.getCodigoGenetico().get(7) * c.getCodigoGenetico().get(12) -
			c.getCodigoGenetico().get(5) * c.getCodigoGenetico().get(8) +
			c.getCodigoGenetico().get(17) * c.getCodigoGenetico().get(19) -
			c.getCodigoGenetico().get(0) * c.getCodigoGenetico().get(29) +
			c.getCodigoGenetico().get(22) * c.getCodigoGenetico().get(3) +
			c.getCodigoGenetico().get(20) * c.getCodigoGenetico().get(14) +
			c.getCodigoGenetico().get(25) * c.getCodigoGenetico().get(15) +
			c.getCodigoGenetico().get(30) * c.getCodigoGenetico().get(11) +
			c.getCodigoGenetico().get(24) * c.getCodigoGenetico().get(18) +
			c.getCodigoGenetico().get(6) * c.getCodigoGenetico().get(7) +
			c.getCodigoGenetico().get(8) * c.getCodigoGenetico().get(17) +
			c.getCodigoGenetico().get(0) * c.getCodigoGenetico().get(32);
		
			c.setFitness( result );
	}


	/** 
	 * Converts decimal to binary 
	 * 
	 * @param dec The decimal number to convert 
	 * @return A string containing the binary number. 
	 */  
	public static String decToBinary( int dec ) {  
		String result = "";  

		while( dec > 0 ) {  
			result = (dec & 1) + result;  
			dec >>= 1;  
		}  

		/* Inícia da gambiarra */
		int qtd = 4 - result.length();
		String temp = "";
		
		for (int i = 0; i < qtd; i++) {
			temp += "0";
		}
		/* Fim da gambiarra */
		
		return temp+result;  
	}  
	
	/**
	 * Método elitísta de escolha dos melhores indivíduos da população.
	 * @param populacao
	 * @return
	 */
	public List<Cromossomo> selecionaIndividuos(List<Cromossomo> populacao){
		List<Cromossomo> individuosSelecionados = new ArrayList<Cromossomo>();
		Arrays.sort(populacao.toArray(), null);
		return individuosSelecionados;
	}

}
