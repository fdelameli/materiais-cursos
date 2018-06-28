
public class Principal {

	public static void main(String[] args) {
		
		Funcionario f = new Funcionario("A", 20);
		Cliente c = new Cliente("B", 30);
		
		Pessoa p1 = f;
		Pessoa p2 = c;
		
	}
}
