import java.util.GregorianCalendar;



/**
 * @author Fabio
 * @version 1.0
 * @created 21-jun-2008 14:24:02
 */
public class LocacaoKm extends Locacao {

	//constructors

	public LocacaoKm(GregorianCalendar dataInicial, GregorianCalendar dataFinal, double kmInicial, double kmFinal, Cliente cliente, Veiculo veiculo) {
		super(dataInicial, dataFinal, kmInicial, kmFinal, cliente, veiculo);
	}


	//main methods

	public double calculaValorLocacao(){
		return this.getKmPercorrida() * this.getVeiculo().getValorKm();

	}

}