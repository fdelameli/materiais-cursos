package semantico;

import javax.swing.JOptionPane;

import semantico.view.Instrucoes_Maquina;
import br.unisul.model.Pilha;
import br.unisul.model.TabelaSimbolos;

/**
 * Analisador Semantico para a linguagem LMS.  
 */
public class Compilador_Semantico {
	
	private TabelaSimbolos TS;
	private Pilha ifs;
	private Pilha whiles;
	private Pilha repeats;
	private Pilha procedures;
	private Pilha parametros;
	private Pilha cases;
	private Pilha fors;
	private int nv; //numero de variaveis num bloco
	private int np;
	private int deslocamento; //deslocamento em rela��o a base
	private AreaInstrucoes AI;
	private AreaLiterais AL;
	private Hipotetica maquinaHipotetica;
	private String penultimo;
	private String antepenultimo;
	private String nomeIdentificador="";
	private String tipo_identificador="";
	private boolean temParametro;
	private int acaoAcumulada=3;
	private int nivelAtual=0;
	private int for_end_nome=0;
	private int end_ident = 0;
	private String nome_atribuicao_esquerda = "";
	private String nomeProcedimento="";
	private int npe=0;
	private String contexto="";
	private Instrucoes_Maquina instrucoes;	
	private String erro;
	private String nomePro="";
	
	
	/**
	 * Construtor sem par�metros
	 */
	public Compilador_Semantico(){
		maquinaHipotetica = new Hipotetica();
		AI = new AreaInstrucoes();//inicializa LC
		AL = new AreaLiterais(); // inicializa LIT
		
		instrucoes = new Instrucoes_Maquina();
	}
		
	/**
	 * Retorna penultimo
	 * @return penultimo
	 */
	public String getPenultimo() {
		return penultimo;
	}
	
	/**
	 * Seta Penultimo
	 * @param penultimo
	 */
	public void setPenultimo(String penultimo) {
		this.penultimo = penultimo;
	}

	/**
	 * Seta Antepenultimo
	 * @param antepenultimo
	 */
	public void setAntePenultimo(String antepenultimo) {
		this.antepenultimo = antepenultimo;
	}
	
	/**
	 * Retorna Antepenultimo
	 * @return antepenultimo
	 */
	public String getAntePenultimo() {
		return antepenultimo;
	}

	
	/**
	 * M�todo que realiza as a��es sem�nticas
	 * @param acao
	 */
	@SuppressWarnings("static-access")
	public void acaoSemantica(int acao){
		
		System.out.println("A��o: "+acao);
		switch (acao){
		//Reconhecendo o nome do programa.
		case 100:{
			ifs = new Pilha();	
			whiles = new Pilha();
			repeats = new Pilha();
			procedures = new Pilha();
			parametros = new Pilha();
			cases = new Pilha();
			fors = new Pilha();
			TS = new TabelaSimbolos();
			maquinaHipotetica.InicializaAI(AI);//inicializa area de instru��es da maquina hipot�tica
			maquinaHipotetica.InicializaAL(AL);//�rea de literais da m�quina hipot�tica
			TS = new TabelaSimbolos();//variaveis inicializadas na tabeladesimbolos
			nv = 0;
			deslocamento = 3;	
			break;
		}
		
		//Final do programa
		case 101:{
			instrucoes.insereInstrucao(26, 0, 0);			
			maquinaHipotetica.IncluirAI(AI, 26, 0, 0);//gera instru��o PARA
			for(int i = 0;i < TS.getTabela().length; i++){ //verifica a utiliza��o de r�tulos atrav�s da tabela de simbolos
				if (TS.getTabela()[i][0]!=null){
					if(TS.getTabela()[i][1].equals("r�tulo")){

						if (!TS.getTabela()[i][4].equals("")){
							erro = "ERRO SEM�NTICO: AINDA EXISTE R�TULOS DECLARADOS";
							JOptionPane.showMessageDialog(null, erro, "ERRO SEM�NTICO",  JOptionPane.ERROR_MESSAGE);
						}
						break;
					}
				}
			}
						
			break;
		}
		
		//Ap�s declara��o de vari�vel
		case 102:{
			instrucoes.insereInstrucao(24, 0, acaoAcumulada);
			maquinaHipotetica.IncluirAI(AI, 24, 0, acaoAcumulada);//gera instru��o AMEM
			acaoAcumulada=3;
			break;
		}
		
		//ap�s LABEL em declara��o de r�tulo
		case 103:{
			tipo_identificador = "r�tulo";
			break;
		}
		
		//Encontrado o nome de r�tulo, de vari�vel, ou de par�metro de procedure em declara��o
		case 104:{
			
			acaoAcumulada++;
			if (tipo_identificador.equals("r�tulo")){
				if (TS.busca(penultimo)!= -1){
					int nivel  = Integer.parseInt(TS.getTabela()[TS.busca(penultimo)][2]);
					if(nivel == nivelAtual){
						System.out.println("ERRO SEM�NTICO: R�TULO J� DECLARADO NO MESMO NIVEL");
					}
					else{
						TS.insercao(penultimo, "r�tulo", nivelAtual+"", "0", "");
					}
				}else{
					TS.insercao(penultimo, "r�tulo", nivelAtual+"", "0", "");
				}
			}

			if (tipo_identificador.equals("vari�vel")){
				if (TS.busca(penultimo)==-1){
						TS.insercao(penultimo, "vari�vel", nivelAtual+"", deslocamento+"", "");
						deslocamento++;
						nv = nv + 1;
				}else{
					erro = "ERRO SEM�NTICO: VARIAVEL J� DECLARADA";
					JOptionPane.showMessageDialog(null, erro, "ERRO SEM�NTICO",  JOptionPane.ERROR_MESSAGE);
				}
			}
			
			if (tipo_identificador.equals("par�metro")){
				if (TS.busca(penultimo)!=-1){
					int nivel  = Integer.parseInt(TS.getTabela()[TS.busca(penultimo)][2]);
					if(nivel == nivelAtual){
						erro = "ERRO SEM�NTICO: PARAMETRO J� DECLARADO NO MESMO NIVEL";
						JOptionPane.showMessageDialog(null, erro, "ERRO SEM�NTICO",  JOptionPane.ERROR_MESSAGE);
					}else{
						TS.insercao(penultimo, "par�metro", nivelAtual+"", "", "");
						parametros.insereElemento(TS.busca(penultimo));
						np = np + 1;
					}	
				}else{
					TS.insercao(penultimo, "par�metro", nivelAtual+"", "", "");
					parametros.insereElemento(TS.busca(penultimo));
					np = np + 1;
				}
			}
			break;
		}
		
		//Reconhecido nome de constante em declara��o
		case 105:{
			if(TS.busca(penultimo) != -1){
				erro = ("ERRO SEM�NTICO: CONSTANTE J� DECLARADA");
				JOptionPane.showMessageDialog(null, erro, "ERRO SEM�NTICO",  JOptionPane.ERROR_MESSAGE);
			} else {
				TS.insercao(penultimo, "constante", nivelAtual+"", "0", "0");
				end_ident = TS.busca(penultimo);
			}
			break;
		}
		
		//Reconhecido valor de contante em declara��o
		case 106:{
			String[][] tabelaSimbolo = TS.getTabela();
			tabelaSimbolo[end_ident][3] = penultimo;
			TS.setTabela(tabelaSimbolo);
			break;
		}
		
		//Antes de lista de identificadores em declara��o de vari�veis
		case 107:{
			tipo_identificador="vari�vel";//seta tipo_identificador = vari�vel
			nv =0; //zera contador de variaveis
			break;
		}
		
		//ap�s nome de procedure em declara��o
		case 108:{
			deslocamento=3;
			nomePro = penultimo;
			TS.insercao(penultimo, "procedure", nivelAtual+"", (AI.LC+1)+"", "0");//verificar se n�o precisa colocar diferen�a de nivel
			setTemParametro(false);
			parametros.insereElemento(TS.busca(penultimo));
			nivelAtual=nivelAtual+1;//aumenta nivel -verificar ?
			np=0;
			break;
		}
		
		//Ap�s declara��o de procedure
		case 109:{
			if (np > 0){
				String[][] tabelaSimbolo = TS.getTabela();
				tabelaSimbolo[TS.busca(nomePro)][4]=np+"";//atualiza numero de par�metros na TS para a procedure em quest�o GeralB = np
				for(int i = 0; i < np; i++){
					tabelaSimbolo[parametros.veTopo()][3] = (-(np-i))+"";
					
					parametros.tiraElemento();
				}
				TS.setTabela(tabelaSimbolo);
				
			}
			
			instrucoes.insereInstrucao(19, 0, 0);
			maquinaHipotetica.IncluirAI(AI, 19, 0, 0);//gera instru��o DSVS
			procedures.insereElemento(AI.LC-1); // Adiciona endere�o na pilha de procedure
			
			parametros.insereElemento(np);//adiciona numero de par�metros
			break;
		}
		
		//Fim de procedure
		case 110:{
			
			parametros.tiraElemento(); //retira numero de parametros
			
			instrucoes.insereInstrucao(1, 0, np+1);
			maquinaHipotetica.IncluirAI(AI, 1, 0, np+1); // Gera instru��o RETU
			
			for(int i = 0;i < TS.getTabela().length; i++){ //verifica a utiliza��o de r�tulos atrav�s da tabela de simbolos
				if (TS.getTabela()[i][0]!=null){
					if(TS.getTabela()[i][1].equals("r�tulo")){

						if (!TS.getTabela()[i][4].equals("")){
							erro = "ERRO SEM�NTICO: AINDA EXISTE R�TULOS DECLARADOS";
							JOptionPane.showMessageDialog(null, erro, "ERRO SEM�NTICO",  JOptionPane.ERROR_MESSAGE);
						}
						break;
					}
				}
			}
			
			instrucoes.alteraInstrucao(procedures.veTopo(), 0, AI.LC+1);
			maquinaHipotetica.AlterarAI(AI, procedures.veTopo(), 0, AI.LC); // Resolve desvio DSVS da a��o 109
			procedures.tiraElemento(); // tira da pilha de controle de procedure o endere�o da instru��o de desvio
			
			//System.out.println(TS.toString());
			TS.delecao(); // delete nomes do escopo do nivel na TS
			//System.out.println(TS.toString());
			
			nivelAtual = nivelAtual -1; // decrementa nivel
			
			break;
		}
		
		//Antes de par�metros formais de procedures
		case 111:{
			tipo_identificador="par�metro";
			setTemParametro(true);
			break;
		}
		
		//Identificador de instru��o rotulada ou comando de atribui��o
		case 112:{
			nomeIdentificador = penultimo;
			break;
		}
		
		//Instru��o rotulada
		case 113:{
			if ((TS.busca(nomeIdentificador)!=-1)){
				if (TS.getTabela()[TS.busca(nomeIdentificador)][1].equals("r�tulo")){
					if(!TS.getTabela()[TS.busca(nomeIdentificador)][2].equals(nivelAtual+"")){
						erro =("ERRO SEM�NTICO: R�TULO N�O EST� NO ESCOPO");
					}else {
						String[][] tabelaSimbolo = TS.getTabela();
						
						tabelaSimbolo[TS.busca(nomeIdentificador)][3]=AI.LC+"";
						
						if (!(tabelaSimbolo[TS.busca(nomeIdentificador)][4].equals(""))){
							//percorre lista de referencias futuras
							String lista = tabelaSimbolo[TS.busca(nomeIdentificador)][4]; 
							int qtd=0;//o ultimo n�o possui espa�o em branco por isso o 1
							
							//quantidade de indices na lista
							for (int i=0; i<lista.length(); i++){
								if (lista.charAt(i)==' '){
									qtd++;
								}
							}
							
							int endereco=0;
							
							lista = tiraProximo(lista);
							
							for(int i=0; i<qtd; i++){
								
								
								endereco = Integer.parseInt(pegaProximo(lista));
								lista = tiraProximo(lista);
								
								instrucoes.alteraInstrucao(endereco, 0, AI.LC+1);//verificar
								maquinaHipotetica.AlterarAI(AI, endereco, 0, AI.LC);
								
							}
							
							
							
						}
						
						tabelaSimbolo[TS.busca(nomeIdentificador)][4]="";
						
						TS.setTabela(tabelaSimbolo);					
						
					}
				}else{
					erro =("ERRO SEM�NTICO: R�TULO N�O EST� DECLARADO");
				}
			}else{
				erro =("ERRO SEM�NTICO: R�TULO N�O EST� DECLARADO");
			}
			
			break;
		}
		
		//Atribui��o para esquerda
		case 114:{
			if ((TS.busca(nomeIdentificador)!=-1)){
				if(!(TS.getTabela()[TS.busca(nomeIdentificador)][1].equals("vari�vel"))){
					erro = "ERRO SEM�NTICO: ATRIBUI��O DA PARTE ESQUERDA INV�LIDA";
					JOptionPane.showMessageDialog(null, erro, "ERRO SEM�NTICO",  JOptionPane.ERROR_MESSAGE);
				} else {
					nome_atribuicao_esquerda = nomeIdentificador;
				}
			} else {
				erro = "ERRO SEM�NTICO: IDENTIFICADOR N�O ENCONTRADO NA TABELA DE S�MBOLOS";
				JOptionPane.showMessageDialog(null, erro, "ERRO SEM�NTICO",  JOptionPane.ERROR_MESSAGE);
			}
			
			
			break;
		}
		
		//Ap�s express�o em atribui��o
		case 115:{
			if(nome_atribuicao_esquerda == null || nome_atribuicao_esquerda.equals("")){
				JOptionPane.showMessageDialog(null, "ERRO CRITICO!", "Erro durante a execu��o",	JOptionPane.ERROR_MESSAGE);
			}
			int d_nivel = nivelAtual - Integer.parseInt(TS.getTabela()[TS.busca(nome_atribuicao_esquerda)][2]); // calculo Diferenca de Nivel
			instrucoes.insereInstrucao(4, d_nivel, Integer.parseInt(TS.getTabela()[TS.busca(nome_atribuicao_esquerda)][3]));
			maquinaHipotetica.IncluirAI(AI, 4, d_nivel, Integer.parseInt(TS.getTabela()[TS.busca(nome_atribuicao_esquerda)][3]));//gera instru��o ARMZ
			break;
		}
		
		//chamada de procedure
		case 116:{
						
			if(TS.busca(penultimo)!=-1){
				if (TS.getTabela()[TS.busca(penultimo)][1].equals("procedure")){
					nomeProcedimento=penultimo;
				}
			}else{
				System.out.println("ERRO SEM�NTICO: PROCEDURE N�O DECLARADA");
			}
			break;
		}
		
		//Ap�s comando call
		case 117:{
						
			if (Integer.parseInt(TS.getTabela()[TS.busca(nomeProcedimento)][4]) != np){
				erro =("ERRO SEM�NTICO: NUMERO DE PARAMETROS DA PROCEDURE "+nomeProcedimento+" N�O CONFEREM COM OS NUMEROS PARAMETROS PASSADOS");
			}else{
				instrucoes.insereInstrucao(25, 0, Integer.parseInt(TS.getTabela()[TS.busca(nomeProcedimento)][3])+1);
				maquinaHipotetica.IncluirAI(AI, 25, 0, Integer.parseInt(TS.getTabela()[TS.busca(nomeProcedimento)][3]));//gera instru��o CALL		
			}
			break;
		}
		
		//Ap�s express�o, em comando call
		case 118:{
			npe++;
			break;
		}
		
		//Comando GOTO
		case 119:{
			

			if (TS.busca(penultimo)!=-1 && TS.getTabela()[TS.busca(penultimo)][1].equals("r�tulo")){
				
				if (!TS.getTabela()[TS.busca(penultimo)][2].equals(nivelAtual+"")){
					erro = "ERRO SEM�NTICO: O R�TULO N�O ESTA DECLARADO NO ESCOPO DO NIVEL";
					JOptionPane.showMessageDialog(null, erro, "ERRO SEM�NTICO",  JOptionPane.ERROR_MESSAGE);
				}else{
					int op2 = Integer.parseInt(TS.getTabela()[TS.busca(penultimo)][3]);
					if (op2 != 0){
						instrucoes.insereInstrucao(19, 0, 0);
						maquinaHipotetica.IncluirAI(AI, 19, 0, op2);//gera instru��o DSVS
					}else{
						instrucoes.insereInstrucao(19, 0, 0);
						maquinaHipotetica.IncluirAI(AI, 19, 0, 0);//gera instru��o DSVS
						
						//guarda endere�o na lista de referencias futuras
						String[][] tabelaSimbolo = TS.getTabela();
						int ind = TS.busca(penultimo);
						
						tabelaSimbolo[ind][4]=tabelaSimbolo[ind][4]+" "+(AI.LC-1);
						
						TS.setTabela(tabelaSimbolo);						
					}
					
				}
				
			}else{
				erro = "ERRO SEM�NTICO: IDENTIFICADOR N�O EST� DECLARADO";
				JOptionPane.showMessageDialog(null, erro, "ERRO SEM�NTICO",  JOptionPane.ERROR_MESSAGE);
			}
			
			break;
		}
		
		//Ap�s express�o num comando IF
		case 120:{
			instrucoes.insereInstrucao(20, 0, 0);
			maquinaHipotetica.IncluirAI(AI, 20, 0, 0);//gera instru��o DSVF
			ifs.insereElemento(AI.LC-1);//armazena na pilha do if
			break;
		}
		
		//Ap�s instru��o IF
		case 121:{
			instrucoes.alteraInstrucao(ifs.veTopo(), 0, AI.LC+1);
			maquinaHipotetica.AlterarAI(AI, ifs.veTopo(), 0, AI.LC);
			ifs.tiraElemento();
			break;
		}
		
		//Ap�s dom�nio do THEN, antes do ELSE
		case 122:{
			instrucoes.alteraInstrucao(ifs.veTopo(), 0, AI.LC+2);
			maquinaHipotetica.AlterarAI(AI, ifs.veTopo(), 0, AI.LC+1);
			ifs.tiraElemento();
			instrucoes.insereInstrucao(19, 0, 0);
			maquinaHipotetica.IncluirAI(AI, 19, 0, 0);
			ifs.insereElemento(AI.LC-1);
			break;
		}
		
		//Comando WHILE antes da express�o
		case 123:{
			whiles.insereElemento(AI.LC);
			break;
		}
		
		//Comando WHILE depois da express��o
		case 124:{
			instrucoes.insereInstrucao(20, 0, 0);
			maquinaHipotetica.IncluirAI(AI, 20, 0, 0);
			whiles.insereElemento(AI.LC-1);
			break;
		}
		
		//Ap�s comando WHILE
		case 125:{
			instrucoes.alteraInstrucao(whiles.veTopo(), 0, AI.LC+2);
			maquinaHipotetica.AlterarAI(AI, whiles.veTopo(), 0, AI.LC+1);
			whiles.tiraElemento();
			instrucoes.insereInstrucao(19, 0, whiles.veTopo());
			maquinaHipotetica.IncluirAI(AI, 19, 0, whiles.veTopo());
			whiles.tiraElemento();
			break;
		}
		
		//Comando REPEAT - Inicio
		case 126:{
			repeats.insereElemento(AI.LC);
			break;
		}
		
		//Comando REPEAT - Fim
		case 127:{
			instrucoes.insereInstrucao(20, 0, repeats.veTopo()+1);
			maquinaHipotetica.IncluirAI(AI, 20, 0, repeats.veTopo());
			repeats.tiraElemento();
			break;
		}
		
		//Comando READLN - Inicio
		case 128:{
			contexto="readln";
			break;
		}
		
		//Identificador de vari�vel
		case 129:{
			if (TS.busca(penultimo)==-1){

				erro = "ERRO SEM�NTICO: IDENTIFICADOR N�O EST� DECLARADO";
				JOptionPane.showMessageDialog(null, erro, "ERRO SEM�NTICO",  JOptionPane.ERROR_MESSAGE);
				
			}else{

				int d_nivel = nivelAtual -  Integer.parseInt(TS.getTabela()[TS.busca(penultimo)][2]); // calculo Diferenca de Nivel

				if (contexto.equals("readln")){
						if (TS.getTabela()[TS.busca(penultimo)][1].equals("vari�vel")){
						    instrucoes.insereInstrucao(21, 0, 0);
							maquinaHipotetica.IncluirAI(AI, 21, 0, 0);
							instrucoes.insereInstrucao(4, d_nivel, Integer.parseInt(TS.getTabela()[TS.busca(penultimo)][3]));
							maquinaHipotetica.IncluirAI(AI, 4, d_nivel, Integer.parseInt(TS.getTabela()[TS.busca(penultimo)][3]));
						}else{
							//System.out.println("ERRO SEM�NTICO: IDENTIFICADOR N�O � VARI�VEL");
							erro = "ERRO SEM�NTICO: IDENTIFICADOR N�O � VARI�VEL";
							JOptionPane.showMessageDialog(null, erro, "ERRO SEM�NTICO",  JOptionPane.ERROR_MESSAGE);
						}
				}

				if (contexto.equals("express�o")){
					
					if (TS.busca(penultimo)==-1){
						//System.out.println("ERRO SEM�NTICO: IDENTIFICADOR N�O EST� DECLARADO");
						erro = "ERRO SEM�NTICO: IDENTIFICADOR N�O EST� DECLARADO";
						JOptionPane.showMessageDialog(null, erro, "ERRO SEM�NTICO",  JOptionPane.ERROR_MESSAGE);
					}else{
						if(TS.getTabela()[TS.busca(penultimo)][1].equals("procedure") || TS.getTabela()[TS.busca(penultimo)][1].equals("r�tulo")){
							//System.out.println("ERRO SEM�NTICO: IDENTIFICADOR N�O � UMA CONSTANTE");
							erro = "ERRO SEM�NTICO: IDENTIFICADOR N�O � UMA CONSTANTE";
							JOptionPane.showMessageDialog(null, erro, "ERRO SEM�NTICO",  JOptionPane.ERROR_MESSAGE);
						}else{
							if (TS.getTabela()[TS.busca(penultimo)][1].equals("constante")){
								instrucoes.insereInstrucao(3, 0, Integer.parseInt(TS.getTabela()[TS.busca(penultimo)][3]));
								maquinaHipotetica.IncluirAI(AI, 3, 0, Integer.parseInt(TS.getTabela()[TS.busca(penultimo)][3]));
							}else{
								instrucoes.insereInstrucao(2, d_nivel, Integer.parseInt(TS.getTabela()[TS.busca(penultimo)][3]));
								maquinaHipotetica.IncluirAI(AI, 2, d_nivel, Integer.parseInt(TS.getTabela()[TS.busca(penultimo)][3]));						
							}
						}
					}
				}
			}
	
			break;
		}
		
		//WRITELN - Ap�s literal na instru��o WRITELN
		case 130:{
			maquinaHipotetica.IncluirAL(AL, penultimo);
			instrucoes.insereInstrucao(23, 0, AL.LIT-1);
			maquinaHipotetica.IncluirAI(AI, 23, 0, AL.LIT-1);
			break;
		}
		
		//WRITELN ap�s express�o
		case 131:{
			instrucoes.insereInstrucao(22, 0, 0);
			maquinaHipotetica.IncluirAI(AI, 22, 0, 0);//gera instru��o IMPR
			break;
		}
		
		//Ap�s palavra reservada CASE
		case 132:{
			//cases.insereElemento(AI.LC);//verificar??????
			break;
		}
		
		//Ap�s comando CASE
		case 133:{
			instrucoes.alteraInstrucao(cases.veTopo(), 0, AI.LC+1);
			maquinaHipotetica.AlterarAI(AI,cases.veTopo(), 0, AI.LC);//completa instru��es de desvio DSVS
			cases.tiraElemento();
			
			instrucoes.insereInstrucao(24, 0, -1);
			maquinaHipotetica.IncluirAI(AI, 24, 0, -1);//gera instru��o AMEM -1
			
			break;
		}
		
		//Ramo do CASE ap�s inteiro, ultimo da lista
		case 134:{
			instrucoes.insereInstrucao(28, 0, 0);
			maquinaHipotetica.IncluirAI(AI, 28, 0, 0);//gera instru��o copia
			
			int ant = Integer.parseInt(antepenultimo);		
			instrucoes.insereInstrucao(3, 0, ant);
			maquinaHipotetica.IncluirAI(AI, 3, 0, ant);//gera instru��o CRCT
			
			instrucoes.insereInstrucao(15, 0, 0);
			maquinaHipotetica.IncluirAI(AI, 15, 0, 0);//gera instru��o CMIG
			
			if (!cases.estaVazia()){
				instrucoes.alteraInstrucao(cases.veTopo(), 0, AI.LC+2);
				maquinaHipotetica.AlterarAI(AI, cases.veTopo(), 0, AI.LC+1);//resolve instru��es do tipo DSVT
				cases.tiraElemento();
			}
			
			
			instrucoes.insereInstrucao(20, 0, 0);
			maquinaHipotetica.IncluirAI(AI, 20, 0, 0);//gera instru��o DSVF com parametros desconhecidos
			cases.insereElemento(AI.LC-1);

			
			
			break;
		}
		
		//Ap�s comando em CASE
		case 135:{
			instrucoes.alteraInstrucao(cases.veTopo(), 0, AI.LC+2);
			maquinaHipotetica.AlterarAI(AI, cases.veTopo(), 0, AI.LC+1);//resolve ultima instru��o de desvio do tipo DSVF
			cases.tiraElemento();
			
			instrucoes.insereInstrucao(19, 0, 0);
			maquinaHipotetica.IncluirAI(AI, 19, 0, 0); //gera instru��o DSVS
			cases.insereElemento(AI.LC-1);//salva endere�o na pilha do case para posterior marca��o		
			break;
		}
		
		//Ramo do CASE. ap�s inteiro
		case 136:{
			
			if (cases.estaCheia()){
				instrucoes.alteraInstrucao(cases.veTopo(), 0, AI.LC+2);
				maquinaHipotetica.AlterarAI(AI, cases.veTopo(), 0, AI.LC+1);//resolve instru��es do tipo DSVT
				cases.tiraElemento();
			}
			
			instrucoes.insereInstrucao(28, 0, 0);
			maquinaHipotetica.IncluirAI(AI, 28, 0, 0);//gera instru��o COPIA
			
			int ant = Integer.parseInt(antepenultimo);
			instrucoes.insereInstrucao(3, 0, ant);
			maquinaHipotetica.IncluirAI(AI, 3, 0, ant);//gera instru��o CRCT
			
			instrucoes.insereInstrucao(15, 0, 0);
			maquinaHipotetica.IncluirAI(AI, 15, 0, 0);//gera instru��o CMIG
			
			instrucoes.insereInstrucao(29, 0, 0);
			maquinaHipotetica.IncluirAI(AI, 29, 0, 0);//gera instru��o DSVT
			
			cases.insereElemento(AI.LC-1); //salva endere�o na pilha do case para posterior marca��o
			break;
		}
		
		//Ap�s vari�vel controle comando FOR
		case 137:{
			if (TS.busca(penultimo)!=-1 && TS.getTabela()[TS.busca(penultimo)][1].equals("vari�vel") ){
				for_end_nome=TS.busca(penultimo);			
			}else{
				//System.out.println("ERRO SEM�NTICO: VARIAVEL N�O DECLARADA OU N�O PERTENCE A CATEGORIA VARIAVEL");
				erro = "ERRO SEM�NTICO: VARIAVEL N�O DECLARADA OU N�O PERTENCE A CATEGORIA VARIAVEL";
				JOptionPane.showMessageDialog(null, erro, "ERRO SEM�NTICO",  JOptionPane.ERROR_MESSAGE);
			}
			break;
		}
		
		//Ap�s express�o valor inicial
		case 138:{
			int op1 = nivelAtual-(Integer.parseInt(TS.getTabela()[for_end_nome][2]));
			int op2 = Integer.parseInt(TS.getTabela()[for_end_nome][3]);
			instrucoes.insereInstrucao(4, op1, op2);
			maquinaHipotetica.IncluirAI(AI, 4, op1, op2);//gera instru��o ARMZ
			break;
		}
		
		//Ap�s express�o - Valor final
		case 139:{
			fors.insereElemento(AI.LC);//armazena pilha de controle o endere�o da instru��o dsvs
			
			instrucoes.insereInstrucao(28, 0, 0);
			maquinaHipotetica.IncluirAI(AI, 28, 0, 0);//gera instru��o COPIA
			
			int op1 = nivelAtual-(Integer.parseInt(TS.getTabela()[for_end_nome][2]));
			int op2 = Integer.parseInt(TS.getTabela()[for_end_nome][3]);			
			instrucoes.insereInstrucao(2, op1, op2);
			maquinaHipotetica.IncluirAI(AI, 2, op1, op2);//gera instru��o CRVL - atributos salvos em #137
			
			instrucoes.insereInstrucao(18, 0, 0);
			maquinaHipotetica.IncluirAI(AI, 18, 0, 0);//gera instru��o CMAI
		
			fors.insereElemento(AI.LC);
			instrucoes.insereInstrucao(20, 0, 0);
			maquinaHipotetica.IncluirAI(AI, 20, 0, 0);//gera instru��o DSVF com parametros desconhecidos
			break;
		}
		
		//Ap�s comando em FOR
		case 140:{
			
			int op1 = nivelAtual-(Integer.parseInt(TS.getTabela()[for_end_nome][2]));
			int op2 = Integer.parseInt(TS.getTabela()[for_end_nome][3]);
				
			instrucoes.insereInstrucao(2, op1, op2);
			maquinaHipotetica.IncluirAI(AI, 2, op1, op2);//gera instru��o CRVL

			
			instrucoes.insereInstrucao(3, 0, 1);
			maquinaHipotetica.IncluirAI(AI, 3, 0, 1);//gera instru��o CRCT
			
			instrucoes.insereInstrucao(5, 0, 0);
			maquinaHipotetica.IncluirAI(AI, 5, 0, 0);//gera instru��o SOMA
			
			instrucoes.insereInstrucao(4, op1, op2);
			maquinaHipotetica.IncluirAI(AI, 4, op1, op2);//gera instru��o ARMZ
			
			instrucoes.alteraInstrucao(fors.veTopo(), 0, AI.LC+1);
			maquinaHipotetica.AlterarAI(AI, fors.veTopo(), 0, AI.LC+1);//completa instru��o dsvf
			fors.tiraElemento();
			
			instrucoes.insereInstrucao(19, 0, fors.veTopo()+1);
			maquinaHipotetica.IncluirAI(AI, 19, 0, fors.veTopo());//gera instru��o DSVS
			
			instrucoes.insereInstrucao(24, 0, -1);
			maquinaHipotetica.IncluirAI(AI, 24, 0, -1);//gera instru��o AMEM -1
			
			break;
		}
		
		//Compara Igual
		case 141:{
			maquinaHipotetica.IncluirAI(AI, 15, 0, 0);//gera instru��o CMIG
			break;
		}
		
		//Compara Menor
		case 142:{
			instrucoes.insereInstrucao(13, 0, 0);
			maquinaHipotetica.IncluirAI(AI, 13, 0, 0);//gera instru��o CMME
			break;
		}
		
		//Compara Maior
		case 143:{
			instrucoes.insereInstrucao(14, 0, 0);
			maquinaHipotetica.IncluirAI(AI, 14, 0, 0);//gera instru��o CMMA
			break;
		}
		
		//Compara Maior Igual
		case 144:{
			instrucoes.insereInstrucao(18, 0, 0);
			maquinaHipotetica.IncluirAI(AI, 18, 0, 0);//gera instru��o CMAI
			break;
		}
		
		//Compara Menor Igual
		case 145:{
			instrucoes.insereInstrucao(17, 0, 0);
			maquinaHipotetica.IncluirAI(AI, 17, 0, 0);//gera instru��o CMEI
			break;
		}
		
		//Compara Diferente
		case 146:{
			instrucoes.insereInstrucao(16, 0, 0);
			maquinaHipotetica.IncluirAI(AI, 16, 0, 0);//gera instru��o CMDF
			break;
		}
		
		//Inverte Sinal
		case 147:{
			instrucoes.insereInstrucao(9, 0, 0);
			maquinaHipotetica.IncluirAI(AI, 9, 0, 0);//gera instru��o INVR
			break;
		}
		
		//Opera��o de Soma com elementos do topo e sub-topo
		case 148:{
			instrucoes.insereInstrucao(5, 0, 0);
			maquinaHipotetica.IncluirAI(AI, 5, 0, 0);//gera instru��o SOMA
			break;
		}
		
		//Opera��o de Subtra��o
		case 149:{
			instrucoes.insereInstrucao(6, 0, 0);
			maquinaHipotetica.IncluirAI(AI, 6, 0, 0);//gera instru��o SUBT
			break;
		}
		
		//Opera��o OR
		case 150:{
			instrucoes.insereInstrucao(12, 0, 0);
			maquinaHipotetica.IncluirAI(AI, 12, 0, 0);//gera instru��o DISJ
			break;
		}
		
		//Opera��o de Multiplica��o
		case 151:{
			instrucoes.insereInstrucao(7, 0, 0);
			maquinaHipotetica.IncluirAI(AI, 7, 0, 0);//gera instru��o MULT
			break;
		}
		
		//Opera��o de Divis�o
		case 152:{
			instrucoes.insereInstrucao(8, 0, 0);
			maquinaHipotetica.IncluirAI(AI, 8, 0, 0);//gera instru��o DIVI
			break;
		}
		
		//Opera��o AND
		case 153:{
			instrucoes.insereInstrucao(11, 0, 0);
			maquinaHipotetica.IncluirAI(AI, 11, 0, 0);//gera instru��o CONJ
			break;
		}
		
		//Carrega Constante na pilha
		case 154:{
			int pen = Integer.parseInt(penultimo);
			instrucoes.insereInstrucao(3, 0, pen);
			maquinaHipotetica.IncluirAI(AI, 3, 0, pen);//gera instru��o CRCT
			break;
		}
		
		//Opera��o de Nega��o
		case 155:{
			instrucoes.insereInstrucao(10, 0, 0);
			maquinaHipotetica.IncluirAI(AI, 10, 0, 0);//gera instru��o NEGA
			break;
		}
		
		//Express�o - Vari�vel
		case 156:{
			contexto="express�o";
			break;
			
		}default:{
			System.out.println("Erro com a a��o : "+acao);
		}
		
		
		
		}

		
	}
	
	/**
	 * M�todo que passa a �rea de Instru��es e de Literais para a m�quina interpretar
	 * @return msg de erro
	 */
	@SuppressWarnings("static-access")
	public String interpreta(){
		
		mostraInstrucoes();
		maquinaHipotetica.Interpreta(AI, AL);
		
		if (erro!=null){
			JOptionPane.showMessageDialog(null, erro, "ERRO SEM�NTICO FINAL", JOptionPane.ERROR_MESSAGE);
			return erro;
		}else{
			JOptionPane.showMessageDialog(null, "Execu��o realizada com Sucesso!", "EXECU��O", JOptionPane.INFORMATION_MESSAGE);
			return "nada";
		}
		
	}
	
	/**
	 * M�todo respons�vel por exibir as instru��es geradas
	 */
	public void mostraInstrucoes(){
		
		instrucoes.setVisible(true);
		
	}
	
	/**
	 * M�todo criado para pegar o primeiro elemento de uma lista de referencias futuras
	 * @param a
	 * @return pegaProximo
	 */
	public String pegaProximo(String a){
		
		String aux="";
		
		for (int i=0; i<a.length(); i++){
			if (a.charAt(i)!=' '){
				aux=aux+a.charAt(i);
			}else{
				break;
			}
		}
		
		
		return aux;
	}
	
	/**
	 * M�todo criado para retirar o primeiro elemento de uma lista de referencias futuras
	 * @param a
	 * @return aux
	 */
	public String tiraProximo(String a){
		
		String aux="";
		
		for (int i=0; i<a.length(); i++){
			if (a.charAt(i)==' '){
				for(int j=i+1; j<a.length(); j++){
					aux=aux+a.charAt(j);
				}			
				break;
			}
		}
		
		return aux;
	}

	public void setTemParametro(boolean temParametro) {
		this.temParametro = temParametro;
	}

	public boolean isTemParametro() {
		return temParametro;
	}

}
