package aula01.exercicio02;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;

public class IMC {

	public static String getIMC (double peso, double altura){
		DecimalFormat df = new DecimalFormat("###,###,##0.00");
		DecimalFormatSymbols ds = new DecimalFormatSymbols();
		ds.setGroupingSeparator('.');
		ds.setDecimalSeparator(',');
		df.setDecimalFormatSymbols(ds);
		double imc = peso /(altura * altura);
		return df.format(imc);
	}
}
