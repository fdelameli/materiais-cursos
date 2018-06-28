
public class Error2 {

	public static void metodo1() {
		metodo2();
	}
	
	public static void metodo2() {
		metodo1();
	}
	
	public static void main(String[] args) {
		metodo1();
	}
}
