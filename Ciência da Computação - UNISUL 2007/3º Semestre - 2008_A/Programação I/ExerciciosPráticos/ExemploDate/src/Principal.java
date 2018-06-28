import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;


public class Principal {

	public static void main(String[] args) {
		
		Date dataSistema = new Date(	);
		
//		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy - hh:mm:ss:S a"); // PATTERN
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy - HH:mm");
	
		
		try {
			dataSistema = sdf.parse("23/04/1989 - 17:30");
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		String dataFormatada = sdf.format(dataSistema);
		
		System.out.println(dataFormatada);
		
		
	}
}
