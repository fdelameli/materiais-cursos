import java.util.GregorianCalendar;



/**
 * @author Fabio
 * @version 1.0
 * @created 21-jun-2008 14:24:02
 */
public class LocacaoDiaria extends Locacao {

	//constructors
	
	public LocacaoDiaria(GregorianCalendar dataInicial, GregorianCalendar dataFinal, double kmInicial, double kmFinal, Cliente cliente, Veiculo veiculo) {
		super(dataInicial, dataFinal, kmInicial, kmFinal, cliente, veiculo);
		
	}


	//main method
	
	public double calculaValorLocacao(){
		return this.getQuantDias() * this.getVeiculo().getValorDiaria();
	}

}