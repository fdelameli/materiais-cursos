import java.util.Hashtable;
import javax.swing.*;
import java.util.Vector;

class Tabela
{  
  public int      codigo;
  public String   nome;
  public String   valor;
}

public class Lexico
{
  private Hashtable tokens = new Hashtable();
  private String conteudo = "";
  private Vector pilhatoken = new Vector();
  private String erro = null;  

  private boolean isLetra(char l)
  {
	  if( ((l >= 65) && (l <= 90)) || ((l >= 97) && (l <= 122)) )
	  {
	    return true;
	  }
	    return false;
  }

  private boolean isNumero(char l)
  {
	  if( (l >= 48) && (l <= 57) )
    {
	    return true;
	  }
	  return false;
  }

  private char getTokenSeguinte(int index)
  {
    if((index + 1) < conteudo.length())
    {
      return conteudo.charAt(index+1); 
    }
    return 257;
  }
  
  private void identificaToken(String tk)
  {
  	tk = tk.toUpperCase();
  	    
    if(tokens.get(tk) != null )//Verifica se o valor esta diretamente na tabela hash(PALAVRA RESERVADA)
    {   
      Tabela tb = new Tabela();
      tb.codigo = Integer.parseInt((String)tokens.get(tk));
      tb.nome   = tk;
      
      if(tb.codigo <= 30) tb.valor  = "Palavra reservada";
      if( (tb.codigo > 30) && (tb.codigo < 35) ) tb.valor  = "Operador aritmético";
      if( (tb.codigo >= 35) && (tb.codigo < 39) ) tb.valor  = "Operador de prioridade";
      if(tb.codigo == 39) tb.valor  = "Atribuição";
      if(tb.codigo == 40) tb.valor  = "Separador";
      if(tb.codigo == 41) tb.valor  = "Igual";
      if(tb.codigo == 42) tb.valor  = "Maior";
      if(tb.codigo == 43) tb.valor  = "Maior igual";
      if(tb.codigo == 44) tb.valor  = "Menor";
      if(tb.codigo == 45) tb.valor  = "Menor igual";
      if(tb.codigo == 46) tb.valor  = "Diferente";
      if(tb.codigo == 47) tb.valor  = "Vírgula";
      if(tb.codigo == 48) tb.valor  = "Ponto e vírgula";
      if(tb.codigo == 49) tb.valor  = "Literal";
      if(tb.codigo == 50) tb.valor  = "Ponto";
      if(tb.codigo == 51) tb.valor  = "Dois pontos";
      if(tb.codigo == 1) tb.valor  = "Dólar";

      pilhatoken.add(tb);
      return;
    }
    else//Caso não exista, verificamos(INDENTIFICADORES, NÚMEROS, LITERAIS)
    {
      if(tk.charAt(0) == '"')//LITERAL
      {
        Tabela tb = new Tabela();
        tb.codigo = 49;
        tb.nome   = "Literal";
        tb.valor  = tk;
          if (tb.valor.length()>255) 
          {
            erro = "Erro encontrado: \"" + tk + "\" - Literal excede tamanho máximo (max 255)";
            return;
          }
        pilhatoken.add(tb);
          
        return;
      }
      else
      {
        if(isLetra(tk.charAt(0)))//IDENTIFICADOR
        {
          Tabela tb = new Tabela();
          tb.codigo = 26;
          tb.nome   = "Identificador";
          tb.valor  = tk;
            if (tb.valor.length()>30)
            {
              erro = "Erro encontrado: \"" + tk + "\" - Nome de indentificador muito extenso (max 30)";
              return;
            }
          pilhatoken.add(tb);
          return;
        }
        else//NÚMERO
        {          
          try
          {
            int conv = Integer.parseInt(tk);
            
            if(( conv <= 32767) && ( conv >= -32767))
            {
              Tabela tb = new Tabela();
              tb.codigo = 27;
              tb.nome   = "Inteiro";
              tb.valor  = tk;
              pilhatoken.add(tb);
              return;
            }
            else
            {
              erro = "Erro encontrado: \"" + tk + "\" - Inteiro excede tamanho máximo (-32767 até 32767)";
            }
          }catch(Exception ex)
          {
            erro = "Erro encontrado: \"" + tk + "\" - Inteiro excede tamanho máximo (-32767 até 32767)";
          }
        }
      }      
    }
  }  
  
  private void principal(String txt)
  {
    boolean STRING = false;
    boolean COMENT = false;
    conteudo = txt;
    String buffer = "";
    
    for(int i = 0; i < conteudo.length(); i++)
    {
      if(erro != null)
        break;
      
      if( ((conteudo.charAt(i) == '"') || (STRING == true)) && (COMENT == false) )
      {
        STRING = true;
        if(getTokenSeguinte(i) != (char)257)//Se não chegar no final do arquivo.
        {
          if(getTokenSeguinte(i) == '"')
          {
            buffer = (buffer + conteudo.charAt(i)) + '"';
            identificaToken(buffer);
            buffer = "";
            i+=1;
            STRING = false;            
            continue;
          }
          else
          {
            buffer += conteudo.charAt(i);            
            continue;
          }
        }
        else
        {
          erro = "Final de arquivo (Final de LITERAL não encontrado)";
          continue;
        }
      }
         
      if( (COMENT == true) && (STRING == false) )
      {
        if(getTokenSeguinte(i) != (char)257)//Se não chegar no final do arquivo.
        {
          if((conteudo.charAt(i) == '*') && (getTokenSeguinte(i) == '/'))
          {
            COMENT = false;            
            i+=1;
            continue;
          }
          else
          {
            continue;
          }
        }
        else
        {
          erro = "Final de arquivo (Final de COMENTÁRIO não encontrado)";
          continue;
        }
      }

      if( (STRING == false) && (conteudo.charAt(i) == '/') )
      {
        if(getTokenSeguinte(i) != (char)257)//Se não chegar no final do arquivo.
        {
          if( (getTokenSeguinte(i) == '*') )
          {
            COMENT = true;
            i+=1;
            if (getTokenSeguinte(i) == (char)257) 
             erro = "Final de arquivo (Final de COMENTÁRIO não encontrado)";
            continue;
          }
          else
          {
            identificaToken("/");
            continue;
          }
        }
        else
        {
          identificaToken("/");
          continue;
        }
      }
      
      if(conteudo.charAt(i) == ' ')
      {
        continue;
      }

      if(conteudo.charAt(i) == (char)10)
      {
        continue;
      }
      
      if(conteudo.charAt(i) == (char)9)
      {
        continue;
      }

      if(conteudo.charAt(i) == '.')
      {
        if(getTokenSeguinte(i) != (char)257)//Se não chegar no final do arquivo.
        {
          if(getTokenSeguinte(i) == '.')
          {            
            identificaToken("..");
            i+=1;
            continue;
          }
          else
          {
            identificaToken(".");
            continue;
          }
        }
        else//Se foi final de arquivo pega o token corrente e manda identificar
        {
          identificaToken(".");
          continue;
        }        
      }

      if(conteudo.charAt(i) == '>')
      {
        if(getTokenSeguinte(i) != (char)257)//Se não chegar no final do arquivo.
        {
          if(getTokenSeguinte(i) == '=')
          {            
            identificaToken(">=");
            i+=1;
            continue;
          }
          else
          {
            identificaToken(">");
            continue;
          }
        }
        else//Se foi final de arquivo pega o token corrente e manda identificar
        {
          identificaToken(">");
          continue;
        }
      }

      if(conteudo.charAt(i) == '<')
      {
        if(getTokenSeguinte(i) != (char)257)//Se não chegar no final do arquivo.
        {
          if(getTokenSeguinte(i) == '>')
          {            
            identificaToken("<>");
            i+=1;
            continue;
          }
          
          if(getTokenSeguinte(i) == '=')
          {            
            identificaToken("<=");
            i+=1;
            continue;
          }
          
          identificaToken("<");
          continue;
        }
        else//Se foi final de arquivo pega o token corrente e manda identificar
        {
          identificaToken("<");
          continue;
        }        
      }

      if(isLetra(conteudo.charAt(i)))
      {
        if(getTokenSeguinte(i) != (char)257)//Se não chegar no final do arquivo.
        {
          if(isNumero(getTokenSeguinte(i)) || isLetra(getTokenSeguinte(i)))
          {
            buffer += conteudo.charAt(i);          
            continue;
          }
          else
          {
            buffer += conteudo.charAt(i);
            identificaToken(buffer);
            buffer = "";
            continue;
          }        
        }
        else
        {
          buffer += conteudo.charAt(i);
          identificaToken(buffer);
          buffer = "";
          continue;//ver
        }
      }
      
      if(isNumero(conteudo.charAt(i)))
      {
        if(getTokenSeguinte(i) != (char)257)//Se não chegar no final do arquivo.
        {
          if(isNumero(getTokenSeguinte(i)) )
          {
            buffer += conteudo.charAt(i);          
            continue;
          }
          else
          {
            if(isLetra(getTokenSeguinte(i))&&(isLetra(buffer.charAt(0))))
            {
              buffer += conteudo.charAt(i);
              continue;
            }
            
            buffer += conteudo.charAt(i);
            identificaToken(buffer);
            buffer = "";
            continue;
          }
        }
        else
        {
          buffer += conteudo.charAt(i);
          identificaToken(buffer);
          buffer = "";
          continue;//ver
        }
      }

      if(conteudo.charAt(i) == '+')
      {
        identificaToken("+");
        continue;
      }

      if(conteudo.charAt(i) == '-')
      {
        identificaToken("-");
        continue;
      }

      if(conteudo.charAt(i) == '[')
      {
        identificaToken("[");
        continue;
      }
      
      if(conteudo.charAt(i) == ']')
      {
        identificaToken("]");
        continue;
      }

      if(conteudo.charAt(i) == '(')
      {
        identificaToken("(");
        continue;
      }

      if(conteudo.charAt(i) == ')')
      {
        identificaToken(")");
        continue;
      }

      if(conteudo.charAt(i) == '=')
      {
        identificaToken("=");
        continue;
      }

      if(conteudo.charAt(i) == ',')
      {
        identificaToken(",");
        continue;
      }

      if(conteudo.charAt(i) == ';')
      {
        identificaToken(";");
        continue;
      }

      if(conteudo.charAt(i) == '*')
      {
        identificaToken("*");
        continue;
      }

      if(conteudo.charAt(i) == ':')
      {
        if(getTokenSeguinte(i) != (char)257)//Se não chegar no final do arquivo.
        {
          if(getTokenSeguinte(i) == '=')
          {            
            identificaToken(":=");
            i+=1;
            continue;
          }
          else
          {
            identificaToken(":");
            continue;
          }
        }
        else//Se foi final de arquivo pega o token corrente e manda identificar
        {
          identificaToken(":");
          continue;
        }        
      }

      erro = "Erro encontrado: \"" + conteudo.charAt(i) + "\" - Caracter inválido";
      
    }//fecha o for
  }//fecha a procedure
  
  public Vector analisar(Memo aux)
  {
    String texto = aux.getTexto();
    
    principal(texto);

    Vector retorno = new Vector();
    if(erro == null)
      erro = "Sucesso!";
      
    retorno.addElement(pilhatoken);    
    retorno.addElement(erro);
    	
    return retorno;
  }
 
  public Lexico()
  {
    addTokens();
  }

  private void addTokens()
  {
  	
    tokens.put("",             "0");
    tokens.put("$",             "1");
    
    
    tokens.put("PROGRAMA",       "2");
    tokens.put("ROTULO",         "3");
    tokens.put("CONSTANTE",         "4");
    tokens.put("VARIAVEL",           "5");
    tokens.put("PROCEDIMENTO",     "6");
    tokens.put("INICIO",         "7");
    tokens.put("FIM",           "8");
    tokens.put("INTEIRO",       "9");
    tokens.put("VETOR",         "10");
    tokens.put("DE",            "11");
    tokens.put("CHAMADA",          "12");
    tokens.put("VAIPARA",          "13");
    tokens.put("SE",            "14");
    tokens.put("ENTAO",          "15");
    tokens.put("SENAO",          "16");
    tokens.put("ENQUANTO",         "17");
    tokens.put("FACA",            "18");
    tokens.put("REPITA",        "19");
    tokens.put("ATEQUE",         "20");
    tokens.put("LERLINHA",        "21");
    tokens.put("ESCREVELINHA",       "22");
    tokens.put("OU",            "23");
    tokens.put("E",           "24");
    tokens.put("NAO",           "25");
    tokens.put("IDENTIFICATOR", "26");
    tokens.put("INTEGER NUMBER",       "27");
    tokens.put("PARA",           "28");
    tokens.put("ATE",            "29");
    tokens.put("CASO",          "30");
    tokens.put("+",             "31");
    tokens.put("-",             "32");
    tokens.put("*",             "33");
    tokens.put("/",             "34");
    tokens.put("[",             "35");
    tokens.put("]",             "36");
    tokens.put("(",             "37");
    tokens.put(")",             "38");
    tokens.put(":=",            "39");
    tokens.put(":",             "40");
    tokens.put("=",             "41");
    tokens.put(">",             "42");
    tokens.put(">=",            "43");
    tokens.put("<",             "44");
    tokens.put("<=",            "45");
    tokens.put("<>",            "46");
    tokens.put(",",             "47");
    tokens.put(";",             "48");
    tokens.put("Literal",       "49");
    tokens.put(".",             "50");
    tokens.put("..",            "51");
  }
}