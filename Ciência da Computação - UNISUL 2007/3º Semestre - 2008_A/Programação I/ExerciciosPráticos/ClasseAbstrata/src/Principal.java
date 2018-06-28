
public class Principal {

	public static void main(String[] args) {
		
		Funcionario f1 = new FuncionarioAssalariado("Fabio", "Dela Bruna", "312321321", 600);
		Funcionario f2 = new FuncionarioHorista("Sueli", "Scremin", "325341232", 55, 15);
		Funcionario f3 = new FuncionarioComissionado("Alguém", "Sei-lá-O-que", "873837434", 10000, 0.1);
		
		Funcionario[] funcionarios = new Funcionario[3];
		funcionarios[0] = f1;
		funcionarios[1] = f2;
		funcionarios[2] = f3;
	
		double totalFolhaPagamento = 0;
		
		for (Funcionario f : funcionarios) {
			System.out.println("===================================");
			System.out.println((f));
			System.out.println("===================================\n");
			totalFolhaPagamento += f.salario();
		}
		
		System.out.println("===================================");
		
		System.out.println("Total da folha de pagamento: " + totalFolhaPagamento);
		
		System.out.println("===================================");
	}
}
