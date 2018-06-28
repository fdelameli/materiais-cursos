import javax.swing.*;
import java.util.Stack;
import java.util.Vector;

class SemanticoNovo implements Constants
{
	static final int contexto_readln = 1;
	static final int contexto_expressao=2;
	Stack pilha_if;
	Stack pilha_while;
	Stack pilha_repeat;
	Stack pilha_procedure;
	Stack pilha_case;
	Stack pilha_for;
	Stack area_literais;
	DadosInstrucao[] area_instrucoes = new DadosInstrucao[200];
	TabelaSimbolos tbs;
	static int tipo_identificador;
	static int end_ts;
	static String nome_identificador;
	static int nivel_var,desloc_var; //usados em #114<->#115 e #137<->#138
	static int endereco_desvio;
	static int contexto;
	static boolean houve_parametros;
	static int n_par_efetivos;
	static int nivel_atual_case; //usado para controlar case's aninhados
		
    public String executaAcao(int x, String valorAcao)
    {
    	x = x - 87;
    	/*é necessário diminuir 87 para facilitar a identificação das ações
    	semânticas*/
    	
    	
    	String resultado_erro = "";
    	
    	String erro = "";
    	
    	DadosSimbolo ret;
    	DadosCase dados_case;
    	
    	//ação semantica
    	switch(x)
    	{
    		case 100:	
						pilha_if = new Stack();
						pilha_while = new Stack();
						pilha_repeat = new Stack();
						pilha_procedure = new Stack();
						pilha_case = new Stack();
						pilha_for = new Stack();
						area_literais = new Stack();
						n_par_efetivos = 0;
						nivel_atual_case = 0;
						
    					tbs = new TabelaSimbolos(this);
						tbs.nivel_atual = 0; //tabela de instruções
						tbs.pt_livre = 0; //índice da tabela de símbolos
						tbs.nv = 0;
    		 			tbs.desloc = 3; //tabela de instruções
    		 			tbs.lc = 0; //índice da instrução que está sendo gerada na tabela de códigos
		
						//inicializa vetor da tabela de espalhamento (tab_hash)
						for (int i=0;i<100;i++)
							tbs.tab_hash[i]=-1;
    				  break;
    				  
    		case 101: insereInstrucao("PARA",-1,-1);
    				  //Verificar a utilização de rótulos através da tabela de símbolos
    				  break;
    				  
    		case 102: insereInstrucao("AMEM",-1, tbs.desloc ); //ver após escrever #104
    				  break;
    				  
    		case 103: tipo_identificador = tbs.rotulo;	
    				  break;
    				  
    		case 104: 
    				  
    				  switch(tipo_identificador)
    				  {
    						case 3 : //Rótulo
    								
    								  erro = tbs.insere(valorAcao,tbs.rotulo);
    										  
									  if (erro.length()>0)
									  {
									  	resultado_erro = "O rótulo " +  valorAcao + " já foi declarada.";
									  	break;
									  }
									  else
									  {
									  	int ret_rotulo = tbs.busca(valorAcao);
									  	tbs.tab_simb[ret_rotulo].geralA = 0;
									  	tbs.tab_simb[ret_rotulo].geralB = 0;
									  }
									  break;
    										  
    						case 1 : //Variável
    								
    								  erro = tbs.insere(valorAcao,tbs.variavel);
    										  
									  if (erro.length()>0)
									  {
									  	resultado_erro = "A variável " +  valorAcao + " já foi declarada.";
									  	break;
									  }
									  else
									  {
									  	tbs.nv = tbs.nv + 1;
									  }
									  break;
    										  
    						case 4 : //Parâmetro(Procedimento)
    						
									  erro = tbs.insere(valorAcao,tbs.parametro);
									  
									  if (erro.length()>0)
									  {
									  	resultado_erro = "O parâmetro " +  valorAcao + " já foi declarada.";
									  	break;
									  }
									  else
									  {
									  	  //tbs.n_par = tbs.n_par + 1;                          
									  }
									  break;
    										  
    				  }
    		
    				  break;
    		
    		case 105: erro = tbs.insere(valorAcao,tbs.constante);
    				  if (erro.length()>0)
    				  {
    				  	resultado_erro = "A constante " + valorAcao + " já foi declarada.";
    				  	break;
    				  }
    				  else
    				  {
    				  	end_ts = tbs.busca(valorAcao);
    				  }
    				  
    				  break;

    		case 106: tbs.setGeralA(Integer.parseInt(valorAcao), end_ts);
    				  break;
    				  
    		case 107: tipo_identificador = tbs.variavel;
    				  break;
    				  
    		case 108: tbs.insere(valorAcao,tbs.procedimento);
    				  end_ts=tbs.busca(valorAcao);
    				  houve_parametros = false;
    				  tbs.n_par = 0;
    				  break;
    				  
    		case 109: if(houve_parametros)
    				  {
    				  	tbs.setGeralB(tbs.n_par,end_ts);
    				  	int i = -1;
    				  	int prim_par = -1;
    				  	
    				  	
    				  	//procura o índice do primeiro parâmetro
    				  	while (prim_par==-1)
    				  	{
    				  		i = i + 1;
    				  		
    				  		if (tbs.tab_simb[i].categoria==tbs.parametro)
    				  			prim_par = i;
    				  	}
    				  	
    				  	//preencher atributos dos parâmetros
    				  	int cont = 0;
    				  	for (i=prim_par;cont<tbs.n_par;i++)
    				  	{
    				  		tbs.setGeralA(-(tbs.n_par-cont),i);
    				  		cont = cont + 1;
    				  	}	
    				  }
    				  
    				  insereInstrucao("DSVS",-1,-1);
    				  pilha_procedure.push(("" + (tbs.lc-1)));
    				  pilha_procedure.push(("" + (tbs.n_par)));
    				  break;
    				  
    		case 110: int n_parametros,endereco_dsvs;
    				  n_parametros = Integer.parseInt("" + (String)pilha_procedure.pop());
    				  endereco_dsvs = Integer.parseInt("" + (String)pilha_procedure.pop());
    				  insereInstrucao("RETU",-1,n_parametros+1);
    				  //O que é "verifica utilização de rótulos na TS"?
    				  alteraInstrucao(endereco_dsvs,2,tbs.lc);
    				  tbs.deleta();
    				  tbs.nivel_atual = tbs.nivel_atual - 1;    				  
    				  break;
    				  
    		case 111: tipo_identificador = tbs.parametro;
    				  houve_parametros = true;
    				  break;
    				  
    		case 112: nome_identificador = valorAcao;  //identificador de instrução rotulada ou comando de atribuição
    				  break;
    				  
    		case 113: ret = tbs.getSimbolo(nome_identificador);
    				  //Está na tabela de símbolos?
    				  if (ret!=null)
    				  {
    				  		//...e é rótulo?
    				  		if (ret.categoria==tbs.rotulo)
    				  		{
    				  			if (ret.nivel!=tbs.nivel_atual)    				  			
    				  				resultado_erro = "O rótulo " + valorAcao + " foi declarado em outro nível.";
    				  			else
    				  			{
    				  				tbs.completaInstRot(tbs.busca(valorAcao));
    				  			}
    				  		}
    				  		else
    				  			resultado_erro = nome_identificador + " não é um rótulo.";
    				  }
    				  else
    				  	resultado_erro = nome_identificador + " não foi declarado.";
    				  break;
    				  
    		case 114: ret = tbs.getSimbolo(nome_identificador);
    				  //Está na tabela de símbolos?
    				  if (ret!=null)
    				  {
    				  		//...e é variável?
    				  		if (ret.categoria==tbs.variavel)
    				  		{
    				  			nivel_var = tbs.nivel_atual - ret.nivel; //diferença de nível
    				  			desloc_var = ret.geralA; //deslocamento
    				  		}
    				  		else
    				  			resultado_erro = nome_identificador + " não é uma variável.";
    				  }
    				  else
    				  	resultado_erro = nome_identificador + " não foi declarado.";
    				  break;
    				  
    		case 115: insereInstrucao("ARMZ",nivel_var,desloc_var);
    				  break;
    				  
    		case 116:     				  
    				  ret = tbs.getSimbolo(valorAcao);
    				  //Está na tabela de símbolos?
    				  
    				  if (ret!=null)
    				  {
    				  		//...e é procedure?
    				  		if ((ret.categoria) == tbs.procedimento)
    				  		{
    				  			endereco_desvio = tbs.busca(valorAcao);
    				  		}
    				  		else
    				  			resultado_erro = valorAcao + " não é uma procedure.";
    				  }
    				  else
    				  	resultado_erro = valorAcao + " não foi declarado.";
    				  break;
    				  
    		case 117: if (tbs.n_par!=n_par_efetivos)
    				  {
    				  	resultado_erro = "Número de parâmetros incorreto.";
    				  	JOptionPane.showMessageDialog(null,"n_par=" + tbs.n_par + " \nefetivos=" + n_par_efetivos);
    				  }
    				  else
    				  {
    				  	int dif_nivel_proc,endereco_proc;
    				  	dif_nivel_proc = tbs.nivel_atual - tbs.tab_simb[endereco_desvio].nivel;
    				  	endereco_proc = tbs.tab_simb[endereco_desvio].geralA;
    				  	insereInstrucao("CALL",dif_nivel_proc,endereco_proc);
    				  }
    				  
    				  n_par_efetivos = 0;
    				  break;
    				  
    		case 118: n_par_efetivos = n_par_efetivos + 1;
    				  break;
    				  
    		case 119:
    				  ret = tbs.getSimbolo(valorAcao);
    				  //Está na tabela de símbolos?
    				  
    				  if (ret!=null)
    				  {
    				  		//...e é rótulo?
    				  		if ((ret.categoria) == tbs.rotulo)
    				  		{
    				  			if (ret.nivel != tbs.nivel_atual)
    				  			{
    				  				resultado_erro = "O rótulo " + valorAcao + " foi declarado em outro nível.";
    				  			}
    				  			else
    				  			{
    				  				//existe endereço da instrução rotulada?
    				  				if (ret.geralA!=0)
    				  					insereInstrucao("DSVS",-1,ret.geralA);
    				  				else
    				  				{
    				  					insereInstrucao("DSVS",-1,-1);
    				  					tbs.guardaRefFut(tbs.busca(valorAcao));
    				  				}
    				  				endereco_desvio = tbs.busca(valorAcao);
    				  			}
    				  		}
    				  		else
    				  			resultado_erro = valorAcao + " não é um rótulo.";
    				  }
    				  else
    				  	resultado_erro = valorAcao + " não foi declarado.";
    				  break;
    				  
    		case 120: insereInstrucao("DSVF",-1,-1);
    				  pilha_if.push(""+(tbs.lc-1));
    				  break;
    				  
    		case 121: int endereco_dsvs_if = Integer.parseInt("" + pilha_if.pop());
    				  alteraInstrucao(endereco_dsvs_if,2,tbs.lc);
    				  break;
    				  
    		case 122: int endereco_dsvf_if = Integer.parseInt("" + pilha_if.pop());
    				  alteraInstrucao(endereco_dsvf_if,2,tbs.lc + 1);
    				  insereInstrucao("DSVS",-1,-1);
    				  pilha_if.push(""+(tbs.lc-1));
    				  break;
    				  
    		case 123: pilha_while.push("" + (tbs.lc));
    				  break;
    				  
    		case 124: insereInstrucao("DSVF",-1,-1);
    				  pilha_while.push(""+(tbs.lc-1));
    				  break;
    				  
    		case 125: int endereco_dsvf = Integer.parseInt("" + pilha_while.pop());
    				  alteraInstrucao(endereco_dsvf,2,tbs.lc + 1);
    				  int endereco_ret = Integer.parseInt("" + pilha_while.pop());
    				  insereInstrucao("DSVS",-1,endereco_ret);
    				  break;
    				  
    		case 126: pilha_repeat.push("" + (tbs.lc));
    				  break;
    				  
    		case 127: int endereco_ret_repeat = Integer.parseInt("" + pilha_repeat.pop());
    				  insereInstrucao("DSVF",-1,endereco_ret_repeat);
    				  break;
    				  
    		case 128: contexto = contexto_readln;
    				  break;
    				  
    		case 129: switch(contexto)
					  {
						case contexto_readln : DadosSimbolo ret_read = tbs.getSimbolo(valorAcao);
						  //Está na tabela de símbolos?
						  if (ret_read!=null)
						  {
						  		//...e é variável?
						  		if (ret_read.categoria==tbs.variavel)
						  		{
						  			insereInstrucao("LEIT",-1,-1);
						  			insereInstrucao("ARMZ",tbs.nivel_atual-ret_read.nivel,ret_read.geralA);					    				  			
						  		}
						  		else
						  			resultado_erro = valorAcao + " não é uma variável.";
						  }
						  else
						  	resultado_erro = valorAcao + " não foi declarado.";
						  break;
											  
						case contexto_expressao : DadosSimbolo ret_exp = tbs.getSimbolo(valorAcao);
							  //Está na tabela de símbolos?
							  if (ret_exp!=null)
							  {
							  		//...e é procedure?
							  		if ((ret_exp.categoria==tbs.procedimento)||(ret_exp.categoria==tbs.rotulo))
							  		{
							  			resultado_erro = valorAcao + " você não pode utilizar uma procedure ou rótulo em uma expressão.";
							  		}
							  		else
							  		{
							  			if (ret_exp.categoria==tbs.constante)
							  				insereInstrucao("CRCT",-1,ret_exp.geralA);
							  			else
							  				insereInstrucao("CRVL",tbs.nivel_atual-ret_exp.nivel,ret_exp.geralA);
							  		}
							  }
							  else
							  	resultado_erro = valorAcao + " não foi declarado.";
							  break;
					  }
					  break;

    		case 130: area_literais.push("" + valorAcao);
    				  insereInstrucao("IMPRLIT",-1, (area_literais.size()-1) );
    				  break;
    				  
    		case 131: insereInstrucao("IMPR",-1,-1);
    				  break;
    		
    		case 132:  nivel_atual_case = nivel_atual_case + 1;
    				  break;
    				  
    		case 133: //resolve os "DSVS"
    				  do
    				  {
    				   	dados_case = (DadosCase)(pilha_case.pop());
    				  	alteraInstrucao(dados_case.endereco,2,tbs.lc);
    				  }while((dados_case.nivel==nivel_atual_case) && (pilha_case.size()>0));
    				  
    				  insereInstrucao("AMEM",-1,-1); //op2 é -1 mesmo!
    				  nivel_atual_case = nivel_atual_case - 1;
    				  break;
    				  
    		case 134: insereInstrucao("COPI",-1,-1);
    				  insereInstrucao("CRCT",-1,Integer.parseInt(valorAcao));
    				  insereInstrucao("CMIG",-1,-1);


    				  //resolve os "DSVT"
    				  int qtde_case = pilha_case.size();
    				  DadosInstrucao inst_case;
    				  String nome_desvio_case;
    				  for (int i=0;i<qtde_case;i++)
    				  {
    				    dados_case =  (DadosCase)(pilha_case.peek());
    				    inst_case = getInstrucao(dados_case.endereco);
    				    nome_desvio_case = inst_case.nome;

    				  	if( (dados_case.nivel==nivel_atual_case) && (nome_desvio_case.equals("DSVT")) )
    				  	{
	    				  	alteraInstrucao(dados_case.endereco,2,tbs.lc+1);
						    pilha_case.pop();
					  	}
    				  }
    				  
    				  insereInstrucao("DSVF",-1,-1);
    				  pilha_case.push(new DadosCase(tbs.lc-1,nivel_atual_case));
    				  break;
    				  
    		case 135: dados_case = (DadosCase)(pilha_case.pop());
    				  alteraInstrucao(dados_case.endereco,2,tbs.lc+1);
    				  insereInstrucao("DSVS",-1,-1);
    				  pilha_case.push(new DadosCase(tbs.lc-1,nivel_atual_case));
    				  break;
    				  
    		case 136: insereInstrucao("COPI",-1,-1);
    				  insereInstrucao("CRCT",-1,Integer.parseInt(valorAcao));
    				  insereInstrucao("CMIG",-1,-1);
    				  insereInstrucao("DSVT",-1,-1);
    				  pilha_case.push(new DadosCase(tbs.lc-1,nivel_atual_case));
    				  break;
    				  
    		case 137: 
    				  ret = tbs.getSimbolo(valorAcao);
    				  //Está na tabela de símbolos?
    				  
    				  if (ret!=null)
    				  {
    				  		//...e é variável?
    				  		if ((ret.categoria) == tbs.variavel)
    				  		{
    				  			end_ts = tbs.busca(valorAcao);
    				  		}
    				  		else
    				  			resultado_erro = valorAcao + " não é uma variável.";
    				  }
    				  else
    				  	resultado_erro = valorAcao + " não foi declarado.";
    				  break;
    				  
    		case 138: ret = tbs.tab_simb[end_ts];
    				  nivel_var = tbs.nivel_atual - ret.nivel;
    				  desloc_var = ret.geralA;
		    		  insereInstrucao("ARMZ",nivel_var,desloc_var);
    				  break;
    		case 139: pilha_for.push("" + tbs.lc);
    				  insereInstrucao("COPI",-1,-1);
    				  insereInstrucao("CRVL",nivel_var,desloc_var);
    				  insereInstrucao("CMAI",-1,-1);
    				  insereInstrucao("DSVF",-1,-1);
    				  pilha_for.push("" + (tbs.lc-1));
    				  pilha_for.push("" + end_ts);
    				  break;
    				  
    		case 140: end_ts = Integer.parseInt("" + pilha_for.pop());
    				  ret = tbs.tab_simb[end_ts];
    				  nivel_var = tbs.nivel_atual - ret.nivel;
    				  desloc_var = ret.geralA;
		    		  insereInstrucao("CRVL",nivel_var,desloc_var);
		    		  
    				  insereInstrucao("CRCT",-1,1);
    				  insereInstrucao("SOMA",-1,-1);
    				  insereInstrucao("ARMZ",nivel_var,desloc_var);
    				  int endereco_ret_for = Integer.parseInt("" + pilha_for.pop());
    				  alteraInstrucao(endereco_ret_for,2,tbs.lc+1);
    				  endereco_ret_for = Integer.parseInt("" + pilha_for.pop());
    				  insereInstrucao("DSVS",-1,endereco_ret_for);
    				  insereInstrucao("AMEM",-1,-1); //op2 é -1 mesmo!
    				  break;
    		case 141: insereInstrucao("CMIG",-1,-1);
    				  break;
    		case 142: insereInstrucao("CMME",-1,-1);
    				  break;
    		case 143: insereInstrucao("CMMA",-1,-1);
    				  break;
    		case 144: insereInstrucao("CMAI",-1,-1);
    				  break;
    		case 145: insereInstrucao("CMEI",-1,-1);
    				  break;
    		case 146: insereInstrucao("CMDF",-1,-1);
    				  break;
    		case 147: insereInstrucao("INVR",-1,-1);
    				  break;
    		case 148: insereInstrucao("SOMA",-1,-1);
    				  break;
    		case 149: insereInstrucao("SUBT",-1,-1);
    				  break;
    		case 150: insereInstrucao("DISJ",-1,-1);
    				  break;
    		case 151: insereInstrucao("MULT",-1,-1);
    				  break;
    		case 152: insereInstrucao("DIVI",-1,-1);
    				  break;
    		case 153: insereInstrucao("CONJ",-1,-1);
    				  break;
    		case 154: insereInstrucao("CRCT",-1,Integer.parseInt(valorAcao));
    				  break;
    		case 155: insereInstrucao("NEGA",-1,-1);
    				  break;
    		case 156: contexto = contexto_expressao;
    				  break;
    				  

    	}
    	
    	return resultado_erro;
    }
    
    public DadosInstrucao getInstrucao(int posicao)
    {
    	return area_instrucoes[posicao];
    }
    
    private void insereInstrucao(String nome, int op1, int op2)
    {
    	area_instrucoes[tbs.lc] = new DadosInstrucao();
    	area_instrucoes[tbs.lc].codigo = tbs.lc;
    	area_instrucoes[tbs.lc].nome = nome;
    	area_instrucoes[tbs.lc].op1 = op1;
    	area_instrucoes[tbs.lc].op2 = op2;
    	tbs.lc = tbs.lc + 1;
    }
    
    private void alteraInstrucao(int endereco, int qual_op, int valor)
    {
    	if (qual_op==1)
    		area_instrucoes[endereco].op1 = valor;
    	else
    		area_instrucoes[endereco].op2 = valor;
    }
    
    public DadosInstrucao[] getInstrucoes()
    {
    	return area_instrucoes;
    }
    
    public Vector getLiterais()
    {
    	return area_literais;
    }
    
    private DadosLimpos limpaInstrucao(DadosInstrucao dado)
    {
    	DadosLimpos temp = new DadosLimpos();
    	
    	temp.codigo = dado.codigo;
    	temp.nome = dado.nome;
    	temp.op1 = "" + dado.op1;
    	temp.op2 = "" + dado.op2;
    	
    	//Coloca "-" em OP1
    	if (temp.nome.equals("AMEM")||
    		temp.nome.equals("CRCT")||
    		temp.nome.equals("DSVS")||
    		temp.nome.equals("DSVF")||
    		temp.nome.equals("DSVT")||
    		temp.nome.equals("IMPRLIT"))
    	{
    		temp.op1 = "-";
    	}
    	else
    	{
    		//Coloca "-" em OP1 e OP2
	    	if (temp.nome.equals("SOMA")||
	    		temp.nome.equals("SUBT")||
	    		temp.nome.equals("MULT")||
	    		temp.nome.equals("DIVI")||
	    		temp.nome.equals("INVR")||
	    		temp.nome.equals("NEGA")||
	    		temp.nome.equals("CONJ")||
	    		temp.nome.equals("DISJ")||
	    		temp.nome.equals("CMME")||
	    		temp.nome.equals("CMMA")||
	    		temp.nome.equals("CMIG")||
	    		temp.nome.equals("CMDF")||
	    		temp.nome.equals("CMEI")||
	    		temp.nome.equals("CMAI")||
	    		temp.nome.equals("IMPR")||
	    		temp.nome.equals("PARA")||
	    		temp.nome.equals("LEIT"))
	    	{
	    		temp.op1 = temp.op2 = "-";
	    	}
    		
    	}
    	return temp;
    }
}

class DadosCase
{
	public int endereco;
	public int nivel;
	
	DadosCase(int ende, int nv)
	{
		endereco = ende;
		nivel = nv;
	}
}

class DadosInstrucao
{
	public int codigo;
	public String nome;
	public int op1;
	public int op2;

	DadosInstrucao()
	{
		nome = "";
		codigo = op1 = op2 = 0;
	}
}

class DadosLimpos
{
	public int codigo;
	public String nome;
	public String op1;
	public String op2;

	DadosLimpos()
	{
		nome = op1 = op2 = "";
		codigo = 0;
	}
}



/*
######################
#					 #
# TABELA DE SÍMBOLOS #
#					 #
######################
*/

class DadosSimbolo
{
	public String nome;
	public int categoria;
	public int nivel;
	public int geralA;
	public int geralB;
	public int prox;
	
	DadosSimbolo()
	{
		nome = "";
		categoria = nivel = geralA = geralB = prox = 0;
	}
}

class TabelaSimbolos
{
	public final int variavel= 1;
	public final int procedimento = 2;
	public final int rotulo = 3;
	public final int parametro = 4;
	public final int constante = 5;
		
	public int categoria;
	public int lc;
	public int nivel_atual;
	public int nv;
	public int pt_livre;
	public int ind_tab;
	public int ind_ts;
	
	public static int posicao;
	
	public int desloc;
	public int n_par;
	public int Tamanho_tabHash = 100;
	public int[] tab_hash = new int[100];
	public DadosSimbolo[] tab_simb = new DadosSimbolo[100];
	
	SemanticoNovo semanticoNovo;
	
	public TabelaSimbolos(SemanticoNovo sn)
	{
		semanticoNovo = sn;
	}
	
	
	
	public void completaInstRot(int posicao)
	{
		int aux_inst;
		int endereco = semanticoNovo.area_instrucoes[ tab_simb[posicao].geralB].op2;
		semanticoNovo.area_instrucoes[ tab_simb[posicao].geralB].op2 = lc;
		while (endereco!=0)
		{
			aux_inst = semanticoNovo.area_instrucoes[endereco].op2;
			semanticoNovo.area_instrucoes[endereco].op2 = lc;
			endereco = aux_inst;
		}
		tab_simb[posicao].geralB = 0;
	}
	
	public void guardaRefFut(int posicao)
	{
		/*Em lugar de "lc" como está no material impresso, foi colocado "lc-1" porque
		foi necessário primeiro gerar a instrução para depois guardar a referência futura.
		Se não fosse feito dessa forma, a posição da instrução não existiria e seria
		provocada uma exceção*/

		if (tab_simb[posicao].geralB == 0)
		{
			tab_simb[posicao].geralB = lc-1;
			semanticoNovo.area_instrucoes[lc-1].op2 = 0;
		}
		else
		{
			int aux_inst = tab_simb[posicao].geralB;
			while(semanticoNovo.area_instrucoes[aux_inst].op2!=0)
			{
				aux_inst = semanticoNovo.area_instrucoes[aux_inst].op2;
			}
			
			semanticoNovo.area_instrucoes[aux_inst].op2 = semanticoNovo.area_instrucoes[lc-1].op2;
			semanticoNovo.area_instrucoes[lc-1].op2 = 0;
		}
	}
	
	public DadosSimbolo getSimbolo(String nome)
	{
		int ret_busca = busca(nome);
		
		if (ret_busca!=-1)
			return tab_simb[ret_busca];
		else
			return null;
	}
	
	public void setGeralA(int valor, int posicao)
	{
		tab_simb[posicao].geralA = valor;
	}
	
	public void setGeralB(int valor, int posicao)
	{
		tab_simb[posicao].geralB = valor;
	}

	int hash(String id)
	{
		int i,j;
		
		j = 0;
		
		for (i=0;i<id.length();i++)
			j=j + id.charAt(i);
		
		return ( Math.abs(j) % (Tamanho_tabHash) + 1);
	}
	
	public int busca(String id)
	{
		int ind_ts = -1;
		
		ind_tab = hash(id);
		posicao = -1;
		
		if (tab_hash[ind_tab]!=-1)
		{
			ind_ts = tab_hash[ind_tab];
			while (ind_ts!=-1)
			{
				if (tab_simb[ind_ts].nome.equals(id))
				{
					posicao = ind_ts;
					ind_ts = -1;
				}
				else
					ind_ts = tab_simb[ind_ts].prox;
			}
		}
		
		return posicao;
	}
	
	public String insere(String id, int categoria)
	{
		posicao = busca(id);
		
		if ( (posicao!=-1) && (tab_simb[posicao].nivel==nivel_atual) )
			return "Identificador já existe no nível";
		else
		{
			tab_simb[pt_livre] = new DadosSimbolo();
			tab_simb[pt_livre].nome = id;
			tab_simb[pt_livre].categoria = categoria;
			tab_simb[pt_livre].nivel = nivel_atual;
			
			switch (categoria)
			{
				case variavel: tab_simb[pt_livre].geralA = desloc;
							   desloc = desloc + 1;
							   break;
							   
				case procedimento: tab_simb[pt_livre].geralA = lc + 1; //ver
								   desloc = 3;
								   nivel_atual = nivel_atual + 1;
								   //ender_proc = pt_livre; //ver - não usado ainda
								   break;
								   
				case rotulo: tab_simb[pt_livre].geralA = 0;
							 tab_simb[pt_livre].geralB = 0;
							 break;
							 
				case parametro: n_par = n_par + 1;
							    break;
			}
			
			tab_simb[pt_livre].prox = tab_hash[ind_tab];
			tab_hash[ind_tab] = pt_livre;
			pt_livre = pt_livre + 1;
		}
		
		return "";
	}
	
	public String deleta()
	{
		int erro=0;
		
		ind_ts = pt_livre - 1;
		while ( (tab_simb[ind_ts].nivel==nivel_atual) && (erro==0) )
		{
			if ( (tab_simb[ind_ts].categoria == rotulo) && (tab_simb[ind_ts].geralA!=0) )
				erro = 0;
			else
			{
				ind_tab = hash(tab_simb[ind_ts].nome);
				tab_hash[ind_tab] = tab_simb[ind_ts].prox;
				tab_simb[ind_ts].prox = 0;
				ind_ts = ind_ts - 1;
			}
		}
		pt_livre = ind_ts;
		nivel_atual = nivel_atual - 1;
		return "" + erro;
	}
}