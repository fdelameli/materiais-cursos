package br.unisul.sintatico;

import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.swing.JOptionPane;

import semantico.Compilador_Semantico;

import br.unisul.model.Token;
import br.unisul.model.constants.AcoesSemanticasConstants;
import br.unisul.model.constants.AcoesSemanticasConstantsKeyNumber;
import br.unisul.model.constants.AllConstantsKeyNumber;
import br.unisul.model.constants.NaoTerminaisConstants;
import br.unisul.model.constants.NaoTerminaisConstantsKeyNumber;
import br.unisul.model.constants.TerminaisConstants;
import br.unisul.model.constants.TerminaisConstantsKeyNumber;

/**
 * Analisador Sint�tico para a linguagem LMS.  
 */

public class Compilador_Sintatico {

	private Integer[][] gramatica;
	private Integer[][] matrizParse;
	String tmp;

	public Compilador_Sintatico() {
		gramatica = loadGramatica(84, 14);
		matrizParse = loadMatrizParse(36, 53);
		tmp = "";
	}

	/**
	 * Manipula a pilha de expans�o, validando a sequ�ncia de tokens conforme gram�tica
	 * @param tokensLexico
	 */
	public void analisarBaseInteiro(List<Token> tokensLexico){
		ArrayList<Integer> reconhecidos = new ArrayList<Integer>();
		ArrayList<String> reconhecidosDebug = new ArrayList<String>();
		ArrayList<Integer> pilha = new ArrayList<Integer>();
		ArrayList<String> pilhaDebug = new ArrayList<String>();

		/**
		 * Inicializa��o da pilha
		 */
		pilha.add(51);
		pilha.add(52);//simbolo inicial
		Integer topoPilha = pilha.get(pilha.size()-1);
		Compilador_Semantico sem = new Compilador_Semantico();
		int i = 0;
		for(i = 0; i<tokensLexico.size(); i++){
			Token token = tokensLexico.get(i);
			//N�oTerminais no topo 
			while(NaoTerminaisConstants.NAOTERMINAIS.containsValue(topoPilha) || AcoesSemanticasConstants.ACOES_SEMANTICAS.containsValue(topoPilha)){
				if(NaoTerminaisConstants.NAOTERMINAIS.containsValue(topoPilha)){
					List<Integer> regra = buscaRegraGramatical(topoPilha, token);

					//Substitui um N�oTerminal por um conjunto de N�oTerminais e/ou Terminais na pilha
					pilha.remove(pilha.size()-1);
					Collections.reverse(regra);
					pilha.addAll(regra);

					if(regra != null){
						System.out.println(topoPilha +"( Proximo token: ("+token.getNmToken()+")"+ " --> Regra: " + regra.toString());
						System.out.println("PILHA -->" +pilha.toString());
						pilhaDebug = new ArrayList<String>();
						for (Integer integer : pilha) {
							pilhaDebug.add(AllConstantsKeyNumber.NAOTERMINAIS.get(integer));
						}
						System.out.println("PILHA -->"+pilhaDebug.toString());
						System.out.println("RECONHECIDO -->"+reconhecidosDebug.toString());
					} else{
						System.out.println(topoPilha +"("+token.getNmToken()+")"+ "-->"+ "##NULL##");
						System.out.println("PILHA -->" +pilha.toString());
						pilhaDebug = new ArrayList<String>();
						for (Integer integer : pilha) {
							pilhaDebug.add(AllConstantsKeyNumber.NAOTERMINAIS.get(integer));
						}
						System.out.println("PILHA -->"+pilhaDebug.toString());
						System.out.println("RECONHECIDO -->"+reconhecidosDebug.toString());
					}
					topoPilha = pilha.get(pilha.size()-1);

					if(topoPilha.equals(0)){
						pilha.remove(pilha.size()-1);
						topoPilha = pilha.get(pilha.size()-1);
					}
				}

				if(AcoesSemanticasConstants.ACOES_SEMANTICAS.containsValue(topoPilha)){
					   tmp += "AntePenultimo: "+tokensLexico.get(i-2).getNmToken().toLowerCase();
					   tmp += " | Penultimo: "+tokensLexico.get(i-1).getNmToken().toLowerCase();
					   tmp += " | A��o : "+topoPilha.intValue()+"\n";
					   System.out.println(tmp);
				   
				   sem.setAntePenultimo(""+(tokensLexico.get(i-2).getNmToken().toLowerCase()));
				   sem.setPenultimo(""+(tokensLexico.get(i-1).getNmToken().toLowerCase()));
				   sem.acaoSemantica(topoPilha.intValue());
				   pilha.remove(pilha.size()-1);
				   topoPilha = pilha.get(pilha.size()-1);
				}
			}

			if(TerminaisConstants.TERMINAIS.containsValue(topoPilha)){

				//Terminais no topo
				if (topoPilha.equals(token.getCdToken())){
					reconhecidos.add(topoPilha);
					reconhecidosDebug.add(TerminaisConstantsKeyNumber.TERMINAIS.get(topoPilha).toString());
					pilha.remove(pilha.size()-1);
					System.out.println("PILHA --> "+pilha.toString());
					pilhaDebug = new ArrayList<String>();
					for (Integer integer : pilha) {
						pilhaDebug.add(AllConstantsKeyNumber.NAOTERMINAIS.get(integer));
					}
					System.out.println("PILHA --> "+pilhaDebug.toString());
					System.out.println("RECONHECIDO --> "+reconhecidosDebug.toString());
				}else{
					System.out.println("ERRO SINT�TICO, gram�tica n�o reconhece sequencia de tokens");
					System.out.println("Topo da Pilha= "+topoPilha);
					System.out.println("Token esperado= "+token.getCdToken());
					JOptionPane.showMessageDialog(null,  "Erro Sintatico, gramatica nao reconhece sequencia de tokens" + "\n"
							+"Topo da Pilha= "+topoPilha + "\n" 
							+"C�digo do Token esperado= "+token.getCdToken() + "\n" 
							+"Tipo do Token esperado= "+token.getTpToken() + "\n");
					//					throw new NullPointerException(	 "Erro Sintatico, gramatica nao reconhece sequencia de tokens" + "\n"
					//													+"Topo da Pilha= "+topoPilha + "\n" 
					//													+"C�digo do Token esperado= "+token.getCdToken() + "\n" 
					//													+"Tipo do Token esperado= "+token.getTpToken() + "\n");
				}
			}else{
				System.out.println("ERRO SINT�TICO, Erro inesperado!");
				JOptionPane.showMessageDialog(null, "ERRO SINT�TICO, Erro insperado!");
				//				throw new NullPointerException("ERRO SINT�TICO, Erro insperado!");
			}
			topoPilha = pilha.get(pilha.size()-1);
		}
		if(topoPilha.equals(101)){
			   tmp += "AntePenultimo: "+tokensLexico.get(i-2).getNmToken().toLowerCase();
			   tmp += " | Penultimo: "+tokensLexico.get(i-1).getNmToken().toLowerCase();
			   tmp += " | A��o : "+topoPilha.intValue()+"\n";
			   System.out.println(tmp);
			sem.setAntePenultimo(""+(tokensLexico.get(i-2).getNmToken().toLowerCase()));
			sem.setPenultimo(""+(tokensLexico.get(i-1).getNmToken().toLowerCase()));
			sem.acaoSemantica(topoPilha.intValue());
			pilha.remove(pilha.size()-1);
			topoPilha = pilha.get(pilha.size()-1);
			if(topoPilha.equals(51)){
				JOptionPane.showMessageDialog(null, "AN�LISE L�XICA E SINT�TICA CONCLU�DA COM SUCESSO!!!");
			}
		}else{
			JOptionPane.showMessageDialog(null, "ERRO SINT�TICO, Ainda existem elementos na pilha!" + "\n" +"Pilha = " +pilha.toString());
			//			throw new NullPointerException("ERRO SINT�TICO, Ainda existem elementos na pilha!" + "\n" +"Pilha = " +pilha.toString());
		}

		sem.interpreta();

	}

	private List<Integer> buscaRegraGramatical(Integer naoTerminal, Token token) {
		List<Integer> retorno = null;
		for (int i = 0; i < matrizParse.length; i++) {
			if(matrizParse[i][0] != null){
				if(matrizParse[i][0].equals(naoTerminal)){
					//iniciamos na coluna 1 pois a coluna 0 da matriz de parsing n�o nos interessa neste caso.
					int j = 1;

					//53 � o n�mero total de colunas da matriz de parsing da nossa gramatica
					while (j < 53){
						Integer cabecalho = matrizParse[0][j];
						if(cabecalho.equals(token.getCdToken())){
							Integer regraGramatica = matrizParse[i][j];
							if (regraGramatica != -1){
								retorno = retornaRegra(regraGramatica);
								break;
							}else{
								JOptionPane.showMessageDialog(null,"ERRO SINT�TICO, Sem regra para= "+naoTerminal+" ~ "+token.getNmToken());
//								throw new NullPointerException("ERRO SINT�TICO, Sem regra para= "+naoTerminal+" ~ "+token.getNmToken());
							}
						}
						j++;
					}
				}
			}
		}
		return retorno;
	}

	private List<Integer> retornaRegra(int regra) {
		List<Integer> regras = new ArrayList<Integer>();
		int i = 0;
		Integer regraG = gramatica[regra][i];
		while (i < 13) {
			i++;
			regraG = gramatica[regra][i];
			if (regraG != null) {
				regras.add(regraG);
			} else {
				break;
			}
		}

		return regras;
	}


	public static Integer[][] loadMatrizParse(int linhas, int colunas){
		File file = new File("LMS/matriz_parse.txt");
		ReadFile rf = new ReadFile();
		String[][] matrizTemp = rf.toArray(linhas, colunas, file);
		Integer[][] result = new Integer[matrizTemp.length][matrizTemp[0].length];
		for(int i=0; i<matrizTemp.length; i++){
			for(int j=0; j<matrizTemp[0].length; j++){
				if (i==0 && j==0) {
					//nao faz nada, pois � ~ = vazio
				}else if(i==0){
					result[i][j]= TerminaisConstants.TERMINAIS.get(matrizTemp[i][j]).intValue();
				}else if(j==0){
					result[i][j]= NaoTerminaisConstants.NAOTERMINAIS.get(matrizTemp[i][j]).intValue();
				}else{
					result[i][j]= Integer.parseInt(matrizTemp[i][j]);
				}
			}
		}
		return result;
	}

	public static Integer[][] loadGramatica(int linhas, int colunas){
		File file = new File("LMS/gramaticaSemantico.txt");
		ReadFile rf = new ReadFile();
		String[][] matrizTemp = rf.toArray(linhas, colunas, file);
		Integer[][] result = new Integer[matrizTemp.length][matrizTemp[0].length];

		for(int i=0; i<matrizTemp.length; i++){
			for(int j=0; j<matrizTemp[0].length; j++){
				if(matrizTemp[i][j] != null){
					System.out.println(matrizTemp[i][j]);
					if(isNaoTerminal(matrizTemp[i][j])){
						result[i][j]= NaoTerminaisConstants.NAOTERMINAIS.get(matrizTemp[i][j]).intValue();
					}else if (isTerminal(matrizTemp[i][j])) {
						result[i][j]= TerminaisConstants.TERMINAIS.get(matrizTemp[i][j]).intValue();
					}else if (isAcaoSemantica(matrizTemp[i][j])){
						result[i][j]= AcoesSemanticasConstants.ACOES_SEMANTICAS.get(matrizTemp[i][j]).intValue();
					}
				}
			}
		}

		return result;
	}

	private static boolean isTerminal(String topoDaPilha) {
		if(topoDaPilha != null && TerminaisConstantsKeyNumber.TERMINAIS.containsValue(topoDaPilha)){
			return true;
		}
		return false;
	}

	private static boolean isNaoTerminal(String topoDaPilha) {
		if(topoDaPilha != null && NaoTerminaisConstantsKeyNumber.NAOTERMINAIS.containsValue(topoDaPilha)){
			return true;
		}
		return false;
	}
	
	private static boolean isAcaoSemantica(String topoDaPilha) {
		if(topoDaPilha != null && AcoesSemanticasConstantsKeyNumber.ACOES_SEMANTICAS.containsValue(topoDaPilha)){
			return true;
		}
		return false;
	}
	
	public boolean verificaTerminal(int cdSimbolo){
		if( TerminaisConstants.TERMINAIS.containsValue(cdSimbolo) ){
			return true;
		}
		return false;
	}

	public boolean verificaNaoTerminal(int cdSimbolo){
		if( NaoTerminaisConstants.NAOTERMINAIS.containsValue(cdSimbolo) ){
			return true;
		}
		return false;
	}

}