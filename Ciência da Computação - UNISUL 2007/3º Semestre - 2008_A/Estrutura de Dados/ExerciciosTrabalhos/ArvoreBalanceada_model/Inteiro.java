public class Inteiro implements Comparable {
    
    private int numero;
    
    public Inteiro(int numero) {
        this.numero = numero;
    }
    
    public int compareTo(Comparable obj) {
        Inteiro inteiro = (Inteiro) obj;
        if (inteiro.numero > this.numero)
            return -1;
        else if (inteiro.numero < this.numero)
            return 1;
        else
            return 0;
    }
    
    public String toString() {
        return String.valueOf(this.numero);
    }
    
    public boolean equals(Object obj) {
    	if(this == obj)
    		return true;
    	if (obj instanceof Inteiro) {
			Inteiro inteiro = (Inteiro) obj;
			return this.numero == inteiro.numero;
		}
    	return super.equals(obj);
    }
}