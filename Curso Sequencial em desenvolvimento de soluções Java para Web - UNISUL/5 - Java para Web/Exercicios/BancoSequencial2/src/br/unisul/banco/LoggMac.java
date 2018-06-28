package br.unisul.banco;

import java.util.Date;

public class LoggMac {

	public static void logSql(String sql, String classe){
		
		System.out.println(new Date()+" "+
				classe.replace("br.unisul.banco.dao.", "")+
				" - SQL : "+sql);
	}
}
