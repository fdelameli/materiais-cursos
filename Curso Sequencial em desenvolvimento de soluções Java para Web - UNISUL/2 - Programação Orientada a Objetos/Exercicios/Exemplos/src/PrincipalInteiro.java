
public class PrincipalInteiro {

	public static void main(String[] args) {
		
		Inteiro i1 = new Inteiro(10);
		Inteiro i2 = new Inteiro(20);
		
		if(i1.compareTo(i2) < 0) {
			System.out.println("i2 é maior que i1");
		} else if(i1.compareTo(i2) > 0) {
			System.out.println("i2 é menor que i1");
		} else {
			System.out.println("i2 é igual a i1");
		}
	}
}
