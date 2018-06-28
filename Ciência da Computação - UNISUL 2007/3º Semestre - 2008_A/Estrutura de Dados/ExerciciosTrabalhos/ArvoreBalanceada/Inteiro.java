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
}