package br.unisul.model.constants;

import java.util.HashMap;
import java.util.Map;

/**
 * 
 * @author Almir Hoepers, Guilherme Azevedo, Thiago Ghisi
 * Classe contendo todas as palavras reservadas e seus respectivos Códigos
 */
public class PalavrasReservadasConstants{
    
    public static final Map<String,Integer> PALAVRAS_RESERVADAS;
    
    static {
        
        PALAVRAS_RESERVADAS = new HashMap<String,Integer>();

        PALAVRAS_RESERVADAS.put("AND",23);
        PALAVRAS_RESERVADAS.put("ARRAY",9);
        PALAVRAS_RESERVADAS.put("BEGIN",6);
        PALAVRAS_RESERVADAS.put("CALL",11);
        PALAVRAS_RESERVADAS.put("CASE",29);
        PALAVRAS_RESERVADAS.put("CONST",3);
        PALAVRAS_RESERVADAS.put("DO",17);
        PALAVRAS_RESERVADAS.put("ELSE",15);
        PALAVRAS_RESERVADAS.put("END",7);
        PALAVRAS_RESERVADAS.put("FOR",27);
        PALAVRAS_RESERVADAS.put("GOTO",12);
        PALAVRAS_RESERVADAS.put("IF",13);
        PALAVRAS_RESERVADAS.put("INTEGER",8);
        PALAVRAS_RESERVADAS.put("LABEL",2);
        PALAVRAS_RESERVADAS.put("NOT",24);
        PALAVRAS_RESERVADAS.put("OF",10);
        PALAVRAS_RESERVADAS.put("OR",22);
        PALAVRAS_RESERVADAS.put("PROCEDURE",5);
        PALAVRAS_RESERVADAS.put("PROGRAM",1);
        PALAVRAS_RESERVADAS.put("READLN",20);
        PALAVRAS_RESERVADAS.put("REPEAT",18);
        PALAVRAS_RESERVADAS.put("THEN",14);
        PALAVRAS_RESERVADAS.put("TO",28);
        PALAVRAS_RESERVADAS.put("UNTIL",19);
        PALAVRAS_RESERVADAS.put("VAR",4);
        PALAVRAS_RESERVADAS.put("WHILE",16);
        PALAVRAS_RESERVADAS.put("WRITELN",21);
    }
}
