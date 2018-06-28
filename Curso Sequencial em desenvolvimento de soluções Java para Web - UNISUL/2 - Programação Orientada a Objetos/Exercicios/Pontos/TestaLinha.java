public class TestaLinha {

	public static void main(String[] args) {

		PontoBidimensional p1 = new PontoTridimensional(12, 12, 2);
		PontoBidimensional p2 = new PontoBidimensional (16, 16);
		
		Linha ll = new Linha (p1, p2);
		System.out.println(ll.getDistancia());
		
	}
}