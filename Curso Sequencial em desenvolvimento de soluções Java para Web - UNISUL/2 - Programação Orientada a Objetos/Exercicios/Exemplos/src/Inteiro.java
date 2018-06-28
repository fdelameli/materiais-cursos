
public class Inteiro implements Comparable {

	private int numero;
	
	

	
	public Inteiro(int numero) {
		this.numero = numero;
	}

	
	
	public int compareTo(Object obj) {
		Inteiro outro = (Inteiro) obj;
		if (outro.numero > this.numero) {
			return -1; 
		}else if (outro.numero < this.numero) {
			return 1;
		}else{
			return 0;
	
		}
	}
	
	
	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

}
