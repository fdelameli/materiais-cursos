public class PolinomioTest {
    
    public static void main(String[] args) {
        
        Polinomio p = new Polinomio();
        p.insereTermo(2, 2);
        p.insereTermo(1, 1);
        p.insereTermo(1, 0);
        System.out.println(" + 2x^2 + 1x^1 + 1x^0 ou equivalente");
        System.out.println(p);
        System.out.println();
        
        Polinomio g = new Polinomio();
        g.insereTermo(3, 3);
        g.insereTermo(4, 0);
        System.out.println(" + 3x^3 + 4x^0 ou equivalente");
        System.out.println(g);
        System.out.println();
              
        Polinomio h = new Polinomio();
        h.insereTermo(-8, 7);
        h.insereTermo(10, 5);
        h.insereTermo(-4, 2);
        System.out.println(" - 8x^7 + 10x^5 - 4x^2 ou equivalente");
        System.out.println(h);
        System.out.println();
              
        Polinomio r = p.soma(g);
        System.out.println(" + 3x^3 + 2x^2 + 1x^1 + 5x^0 ou equivalente");
        System.out.println(r);
        System.out.println();
        
        r = p.multiplica(g);
        System.out.println(" + 6x^5 + 3x^4 + 3x^3 + 8x^2 + 4x^1 + 4x^0 ou equivalente");
        System.out.println(r);
        System.out.println();
       
        r = p.soma(h);
        System.out.println(" - 8x^7 + 10x^5 - 2x^2 + 1x^1 + 1x^0 ou equivalente");
        System.out.println(r);
        System.out.println();
       
        r = p.multiplica(h);
        System.out.println(" - 16x^9 - 8x^8 + 12x^7 + 10x^6 + 10x^5 - 8x^4 - 4x^3 - 4x^2 ou equivalente");
        System.out.println(r);
        System.out.println();
       
        System.exit(0);
    }
}


