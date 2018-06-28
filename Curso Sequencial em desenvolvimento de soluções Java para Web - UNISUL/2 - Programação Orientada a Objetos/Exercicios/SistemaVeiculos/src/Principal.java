import java.util.GregorianCalendar;


public class Principal {

	public static void main(String[] args) {
		
		GregorianCalendar d1 = new GregorianCalendar(2008, 6, 21);
		GregorianCalendar d2 = new GregorianCalendar(2008, 6, 30);
		
		CarroPasseio cp = new CarroPasseio("", 10000.0, 10.0, 5.0, 100.0,"Vermelho", "Gol");
		
		Cliente c1 = new Cliente(100100, "Fabio");
		
		LocacaoDiaria ld = new LocacaoDiaria(d1, d2, 100.0, 200.0, c1, cp);
		System.out.println("Locação Diária: " + ld.calculaValorLocacao());
		
		LocacaoKm lk = new LocacaoKm(d1, d2, 100.0, 200.0, c1, cp);
		System.out.println("Locação Km: " + lk.calculaValorLocacao());
		
		LocacaoKmDiaria lkd = new LocacaoKmDiaria(d1, d2, 100.0, 200.0, c1, cp);
		System.out.println("Locação Km-Diaria: " + lkd.calculaValorLocacao());
	}
}
