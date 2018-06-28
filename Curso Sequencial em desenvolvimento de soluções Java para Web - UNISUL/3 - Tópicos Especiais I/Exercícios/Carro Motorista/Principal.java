public class Principal {
	
	public static void main(String[] args) {

		Carro carro = new Carro("Ferrari");
		Motorista motorista = new Motorista("Felipe Massa");
		
		try {
			motorista.ligarCarro(carro);
		} catch (ExcecaoLigado el) {
			System.out.println(el.getMessage());
		}
		
		motorista.acelerarCarro(carro, 110);
	}
}