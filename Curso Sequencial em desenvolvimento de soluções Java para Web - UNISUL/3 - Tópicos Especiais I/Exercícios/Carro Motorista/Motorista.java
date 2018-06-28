public class Motorista {
	
	private String nome;
	
	public Motorista(String nome) {
		this.nome = nome;
	}
	
	public void ligarCarro(Carro carro) throws ExcecaoLigado {
//		try {
			carro.ligar();
//		} catch (ExcecaoLigado el) {
//			System.out.println(el.getMessage());
//		}
	}
	
	public void desligarCarro(Carro carro) {
		try {
			carro.desligar();
		} catch (ExcecaoLigado el) {
			System.out.println(el.getMessage());
		}
	}
	
	public int acelerarCarro(Carro carro, int valor) {
		int velocidade = 0;
		try {
			velocidade = carro.acelerar(valor);
		} catch (ExcecaoLigado el) {
			System.out.println(el.getMessage());
		} catch (ExcecaoVelocidade ev) {
			System.out.println(ev.getMessage());
		}
		return velocidade;	
	}
	
	public int freiarCarro(Carro carro, int valor) {
		int velocidade = 0;
		try {
			velocidade = carro.frear(valor);
		} catch (ExcecaoLigado el) {
			System.out.println(el.getMessage());
		} catch (ExcecaoVelocidade ev) {
			System.out.println(ev.getMessage());
		}
		return velocidade;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
}