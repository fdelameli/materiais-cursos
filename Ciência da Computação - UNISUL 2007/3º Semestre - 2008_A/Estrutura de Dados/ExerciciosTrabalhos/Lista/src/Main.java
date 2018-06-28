
public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		List array = new ArrayList();
		System.out.println(array);
		array.insertFirst("1");
		array.insertFirst("2");
		array.insertFirst("2");
		array.insertFirst("2");
		array.insertFirst("2");
		array.insertFirst("2");
		array.insertAt("X", 2);
		array.remove(2);
		System.out.println(array);
		
		/*
		 * - aumentar o vetor dinamicamente
		 * - criar metodo isFull;
		 * - valor do aumento do vetor constante (final)
		 */
		
	}
	

}
