
public class Principal {

	public static void main(String[] args) {
		
		SetorPessoal sp = new SetorPessoal();
		
		Assalariado a1 = new Assalariado(1, "Ana");
		a1.setSalario(2000.00);
		
		Assalariado a2 = new Assalariado(2, "Joana");
		a2.setSalario(1000.00);
		
		Horista h1 = new Horista(3, "José");
		h1.setNumeroHoras(50.0);
		h1.setValorHora(20.0);
		
		Comissionado c1 = new Comissionado(4, "Fabio");
		c1.setVendaMensal(1000.00);
		c1.setPorcentagem(15.5	);
		
		AssalariadoComissionado ac = new AssalariadoComissionado(5, "Sueli");
		ac.setVendaMensal(10000.00);
		ac.setPorcentagem(50.0);
		ac.setSalario(20000.00);
		
		
		sp.incluiFuncionario(a1);
		sp.incluiFuncionario(a2);
		sp.incluiFuncionario(h1);
		sp.incluiFuncionario(c1);
		sp.incluiFuncionario(ac);
		
		sp.geraFolhaPagamento();
	}
}
