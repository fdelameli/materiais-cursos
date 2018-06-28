

public class Principal {

	/**
	 * Método principal.
	 * @param args
	 */
	public static void main(String[] args) {

		// Cria uma instância de Grafo.
		Grafo g = new Grafo();

		// Cria instâncias de Vertice para cada cidade.
		Vertice a1 = new Vertice("São João Margem Esquerda");
		Vertice b1 = new Vertice("São João Margem Direita");
		Vertice c1 = new Vertice("São Bernardo");
		Vertice d1 = new Vertice("São Martinho");
		Vertice e1 = new Vertice("Humaitá de Cima");
		Vertice f1 = new Vertice("Vila Esperança");
		Vertice g1 = new Vertice("Morrotes");
		Vertice h1 = new Vertice("Dehon");
		Vertice i1 = new Vertice("Humaitá");
		Vertice j1 = new Vertice("Revoredo");
		Vertice k1 = new Vertice("São Cristóvão");
		Vertice l1 = new Vertice("Sertão dos Corrêas");
		Vertice m1 = new Vertice("Cruzeiro");
		Vertice n1 = new Vertice("Fábio Silva");
		Vertice o1 = new Vertice("Monte Castelo");
		Vertice p1 = new Vertice("Oficinas");
		Vertice q1 = new Vertice("Santo Antônio de Pádua");
		Vertice r1 = new Vertice("Centro");
		Vertice s1 = new Vertice("Recife");
		Vertice t1 = new Vertice("Passo do Gado");
		Vertice u1 = new Vertice("Santa Luzia");
		Vertice v1 = new Vertice("Praia Redonda");
		Vertice w1 = new Vertice("São Clemente");
		Vertice x1 = new Vertice("Vila Moema");
		Vertice y1 = new Vertice("Passagem");
		Vertice z1 = new Vertice("Campestre");
		
	/*	
		Vertice a1 = new Vertice("A");
		Vertice b1 = new Vertice("B");
		Vertice c1 = new Vertice("C");
		Vertice d1 = new Vertice("D");
		Vertice e1 = new Vertice("E");
		Vertice f1 = new Vertice("F");
		Vertice g1 = new Vertice("G");
		Vertice h1 = new Vertice("H");
		Vertice i1 = new Vertice("I");
		Vertice j1 = new Vertice("J");
		Vertice k1 = new Vertice("K");
		Vertice l1 = new Vertice("L");
		Vertice m1 = new Vertice("M");
		Vertice n1 = new Vertice("N");
		Vertice o1 = new Vertice("O");
		Vertice p1 = new Vertice("P");
		Vertice q1 = new Vertice("Q");
		Vertice r1 = new Vertice("R");
		Vertice s1 = new Vertice("S");
		Vertice t1 = new Vertice("T");
		Vertice u1 = new Vertice("U");
		Vertice v1 = new Vertice("V");
		Vertice w1 = new Vertice("W");
		Vertice x1 = new Vertice("X");
		Vertice y1 = new Vertice("Y");
		Vertice z1 = new Vertice("Z");
*/

		// Cria instância de Aresta para cada ligação entre os vertices
		// e as adiciona ao grafo.
		g.adicionaAresta("AB", 5.5, a1, b1);
		g.adicionaAresta("AC", 2.2, a1, c1);
		g.adicionaAresta("AE", 1.5, a1, e1);
		g.adicionaAresta("AG", 1.7, a1, g1);
		g.adicionaAresta("BN", 2.8, b1, n1);
		g.adicionaAresta("CE", 2.8, c1, e1);
		g.adicionaAresta("CD", 3.5, c1, d1);
		g.adicionaAresta("DF", 4.0, d1, f1);
		g.adicionaAresta("EG", 1.8, e1, g1);
		g.adicionaAresta("EF", 2.3, e1, f1);
		g.adicionaAresta("EH", 3.6, e1, h1);
		g.adicionaAresta("EI", 3.1, e1, i1);
		g.adicionaAresta("FI", 2.6, f1, i1);
		g.adicionaAresta("GH", 2.2, g1, h1);
		g.adicionaAresta("GN", 1.4, g1, n1);
		g.adicionaAresta("GP", 1.4, g1, p1);
		g.adicionaAresta("HI", 2.2, h1, i1);
		g.adicionaAresta("HP", 2.7, h1, p1);
		g.adicionaAresta("HR", 1.8, h1, r1);
		g.adicionaAresta("IJ", 2.2, i1, j1);
		g.adicionaAresta("IR", 1.8, i1, r1);
		g.adicionaAresta("IX", 3.1, i1, x1);
		g.adicionaAresta("JX", 1.9, j1, x1);
		g.adicionaAresta("JY", 1.6, j1, y1);
		g.adicionaAresta("KL", 6.9, k1, l1);
		g.adicionaAresta("KO", 5.1, k1, o1);
		g.adicionaAresta("LM", 3.2, l1, m1);
		g.adicionaAresta("MN", 1.9, m1, n1);
		g.adicionaAresta("NP", 1.4, n1, p1);
		g.adicionaAresta("OP", 1.3, o1, p1);
		g.adicionaAresta("PQ", 2.5, p1, q1);
		g.adicionaAresta("PR", 1.6, p1, r1);
		g.adicionaAresta("QR", 1.9, q1, r1);
		g.adicionaAresta("QS", 2.1, q1, s1);
		g.adicionaAresta("QU", 3.3, q1, u1);
		g.adicionaAresta("RS", 1.6, r1, s1);
		g.adicionaAresta("RX", 1.9, r1, x1);
		g.adicionaAresta("ST", 1.9, s1, t1);
		g.adicionaAresta("SX", 2.1, s1, x1);
		g.adicionaAresta("SY", 3.6, s1, y1);
		g.adicionaAresta("TU", 2.5, t1, u1);
		g.adicionaAresta("TW", 1.1, t1, w1);
		g.adicionaAresta("TZ", 3.5, t1, z1);
		g.adicionaAresta("UV", 5.2, u1, v1);
		g.adicionaAresta("VW", 4.5, v1, w1);
		g.adicionaAresta("WZ", 3.4, w1, z1);
		g.adicionaAresta("XY", 1.9, x1, y1);
		g.adicionaAresta("YZ", 3.2, y1, z1);


		// Adiciona os vertices no grafo.
		g.adicionaVertice(a1);
		g.adicionaVertice(b1);
		g.adicionaVertice(c1);
		g.adicionaVertice(d1);
		g.adicionaVertice(e1);
		g.adicionaVertice(f1);
		g.adicionaVertice(g1);
		g.adicionaVertice(h1);
		g.adicionaVertice(i1);
		g.adicionaVertice(j1);
		g.adicionaVertice(k1);
		g.adicionaVertice(l1);
		g.adicionaVertice(m1);
		g.adicionaVertice(n1);
		g.adicionaVertice(o1);
		g.adicionaVertice(p1);
		g.adicionaVertice(q1);
		g.adicionaVertice(r1);
		g.adicionaVertice(s1);
		g.adicionaVertice(t1);
		g.adicionaVertice(u1);
		g.adicionaVertice(v1);
		g.adicionaVertice(w1);
		g.adicionaVertice(x1);
		g.adicionaVertice(y1);
		g.adicionaVertice(z1);


		// Cria uma instância de MatrizAdjacencia e passa o grafo por parâmetro.
		CentroGrafo cf = new CentroGrafo(g);
		
		double[][] matriz = cf.grafoValorado();
		for (int i = 0; i < matriz.length; i++) {
			for (int j = 0; j < matriz.length; j++) {
				System.out.print(matriz[j][i] + "\t");
			}
			System.out.println();
		}
	
		
		cf.calculaCentroRaioGrafo();
		
		

		
/*		
		
		
		// MEU TESTE \\
		
		Grafo grafo2 = new Grafo();
		
		Vertice vertice1 = new Vertice("v1");
		Vertice vertice2 = new Vertice("v2");
		Vertice vertice3 = new Vertice("v3");
		Vertice vertice4 = new Vertice("v4");
		Vertice vertice5 = new Vertice("v5");
		Vertice vertice6 = new Vertice("v6");
		

		
		grafo2.adicionaAresta("a1", 7, vertice1, vertice2);
		grafo2.adicionaAresta("a2", 21, vertice1, vertice3);
		grafo2.adicionaAresta("a3", 20, vertice1, vertice4);
		grafo2.adicionaAresta("a4", 11, vertice1, vertice5);
		grafo2.adicionaAresta("a5", 6, vertice1, vertice6);
		grafo2.adicionaAresta("a7", 14, vertice2, vertice3);
		grafo2.adicionaAresta("a8", 3, vertice2, vertice4);
		grafo2.adicionaAresta("a9", 4, vertice2, vertice5);
		grafo2.adicionaAresta("a10", 11, vertice2, vertice6);
		grafo2.adicionaAresta("a13", 5, vertice3, vertice4);
		grafo2.adicionaAresta("a14", 12, vertice3, vertice5);
		grafo2.adicionaAresta("a15", 22, vertice3, vertice6);
		grafo2.adicionaAresta("a19", 9, vertice4, vertice5);
		grafo2.adicionaAresta("a20", 19, vertice4, vertice6);
		grafo2.adicionaAresta("a25", 10, vertice5, vertice6);
		
		
		
		grafo2.adicionaVertice(vertice1);
		grafo2.adicionaVertice(vertice2);
		grafo2.adicionaVertice(vertice3);
		grafo2.adicionaVertice(vertice4);
		grafo2.adicionaVertice(vertice5);
		grafo2.adicionaVertice(vertice6);
		

		CentroGrafo cf2 = new CentroGrafo(grafo2);
		
		double[][] matriz = cf2.getMatrizAdjacencia();
		for (int i = 0; i < matriz.length; i++) {
			for (int j = 0; j < matriz.length; j++) {
				System.out.print(matriz[j][i] + "\t");
			}
			System.out.println();
		}
		
		cf2.calculaCentroRaioGrafo();
	
	*/
	}
	
}
