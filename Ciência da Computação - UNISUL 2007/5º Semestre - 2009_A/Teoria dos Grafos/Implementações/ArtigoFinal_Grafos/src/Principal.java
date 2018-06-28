/**
 * Classe principal que implementa determinados tipos de grafos.
 * @author Lucas Nunes, Jakson Gonçalves.
 * @since 06/07/2009.
 */

// A MATRIZ DE ADJACÊNCIA ESTÁ MOSTRANDO OS VALORES ERRADOS.
// TEM QUE CALCULAR A EXCENTRICIDADE E O CENTRO DO GRAFO, FUDEU.

public class Principal {

	public static void main(String[] args) {

		// *********** LISTA DE ARESTAS ***********
		System.out.println("************* LISTA DE ARESTAS *************");
		Grafo g1 = criarGrafo();
		g1.mostrarListaArestas();
		System.out.println();

//		// *********** LISTA DE ADJACENCIA ***********
//		System.out.println("************* LISTA DE ADJACÊNCIA *************");
//		Vertice a = new Vertice("A", "São João Margem Esquerda");
//		Vertice b = new Vertice("B", "São João Margem Direita ");
//		Vertice c = new Vertice("C", "São Bernardo");
//		Vertice d = new Vertice("D", "São Martinho");
//		Vertice e = new Vertice("E", "Humaitá de Cima");
//		Vertice f = new Vertice("F", "Vila Esperança");
//		Vertice g = new Vertice("G", "Morrotes");
//		Vertice h = new Vertice("H", "Dehon");
//		Vertice i = new Vertice("I", "Humaitá");
//		Vertice j = new Vertice("J", "Revoredo");
//		Vertice k = new Vertice("F", "São Cristóvão");
//		Vertice l = new Vertice("L", "Sertão dos Corrêas");
//		Vertice m = new Vertice("M", "Cruzeiro");
//		Vertice n = new Vertice("N", "Fábio Silva");
//		Vertice o = new Vertice("O", "Monte Castelo");
//		Vertice p = new Vertice("P", "Oficinas");
//		Vertice q = new Vertice("Q", "Santo Antônio de Pádua");
//		Vertice r = new Vertice("R", "Centro");
//		Vertice s = new Vertice("S", "Recife");
//		Vertice t = new Vertice("T", "Passo do Gado");
//		Vertice u = new Vertice("U", "Santa Luzia");
//		Vertice v = new Vertice("V", "Praia Redonda");
//		Vertice w = new Vertice("W", "São Clemente");
//		Vertice x = new Vertice("X", "Vila Moema");
//		Vertice y = new Vertice("Y", "Passagem");
//		Vertice z = new Vertice("Z", "Campestre");
//		g1.mostrarListaAdjacencia(a);
//		g1.mostrarListaAdjacencia(b);
//		g1.mostrarListaAdjacencia(c);
//		g1.mostrarListaAdjacencia(d);
//		g1.mostrarListaAdjacencia(e);
//		g1.mostrarListaAdjacencia(f);
//		g1.mostrarListaAdjacencia(g);
//		g1.mostrarListaAdjacencia(h);
//		g1.mostrarListaAdjacencia(i);
//		g1.mostrarListaAdjacencia(j);
//		g1.mostrarListaAdjacencia(k);
//		g1.mostrarListaAdjacencia(l);
//		g1.mostrarListaAdjacencia(m);
//		g1.mostrarListaAdjacencia(n);
//		g1.mostrarListaAdjacencia(o);
//		g1.mostrarListaAdjacencia(p);
//		g1.mostrarListaAdjacencia(q);
//		g1.mostrarListaAdjacencia(r);
//		g1.mostrarListaAdjacencia(s);
//		g1.mostrarListaAdjacencia(t);
//		g1.mostrarListaAdjacencia(u);
//		g1.mostrarListaAdjacencia(v);
//		g1.mostrarListaAdjacencia(w);
//		g1.mostrarListaAdjacencia(x);
//		g1.mostrarListaAdjacencia(y);
//		g1.mostrarListaAdjacencia(z);
//		System.out.println();

		// *********** MATRIZ DE ADJACÊNCIA ***********
		System.out.println("************* MATRIZ DE ADJACÊNCIA *************");
		g1.mostrarMatrizAdjacencia();
		System.out.println();
		
		// *********** MATRIZ DE INCIDÊNCIA ***********
		System.out.println("************* MATRIZ DE INCIDÊNCIA *************");
		g1.mostrarMatrizIncidencia();
		System.out.println();
		
//		// *********** COMPLEMENTO DE MATRIZ ***********
//		System.out.println("************* COMPLEMENTO DA MATRIZ DE ADJACÊNCIA *************");
//		g1.complementarMatriz();
	}

	/**
	 * Método que cria um grafo G.
	 */
	public static Grafo criarGrafo() {
		Grafo g = new Grafo();
		Vertice a1 = new Vertice("A", "São João Margem Esquerda", true);
		Vertice b1 = new Vertice("B", "São João Margem Direita", true);
		Vertice c1 = new Vertice("C", "São Bernardo", false);
		Vertice d1 = new Vertice("D", "São Martinho", false);
		Vertice e1 = new Vertice("E", "Humaitá de Cima", true);
		Vertice f1 = new Vertice("F", "Vila Esperança", true);
		Vertice g1 = new Vertice("G", "Morrotes", true);
		Vertice h1 = new Vertice("H", "Dehon", true);
		Vertice i1 = new Vertice("I", "Humaitá", true);
		Vertice j1 = new Vertice("J", "Revoredo", true);
		Vertice k1 = new Vertice("F", "São Cristóvão", true);
		Vertice l1 = new Vertice("L", "Sertão dos Corrêas", true);
		Vertice m1 = new Vertice("M", "Cruzeiro", true);
		Vertice n1 = new Vertice("N", "Fábio Silva", true);
		Vertice o1 = new Vertice("O", "Monte Castelo", false);
		Vertice p1 = new Vertice("P", "Oficinas", false);
		Vertice q1 = new Vertice("Q", "Santo Antônio de Pádua", false);
		Vertice r1 = new Vertice("R", "Centro", false);
		Vertice s1 = new Vertice("S", "Recife", false);
		Vertice t1 = new Vertice("T", "Passo do Gado", false);
		Vertice u1 = new Vertice("U", "Santa Luzia", false);
		Vertice v1 = new Vertice("V", "Praia Redonda", false);
		Vertice w1 = new Vertice("W", "São Clemente", false);
		Vertice x1 = new Vertice("X", "Vila Moema", false);
		Vertice y1 = new Vertice("Y", "Passagem", false);
		Vertice z1 = new Vertice("Z", "Campestre", false);
		g.inserirVertice(a1);
		g.inserirVertice(b1);
		g.inserirVertice(c1);
		g.inserirVertice(d1);
		g.inserirVertice(e1);
		g.inserirVertice(f1);
		g.inserirVertice(g1);
		g.inserirVertice(h1);
		g.inserirVertice(i1);
		g.inserirVertice(j1);
		g.inserirVertice(k1);
		g.inserirVertice(l1);
		g.inserirVertice(m1);
		g.inserirVertice(n1);
		g.inserirVertice(o1);
		g.inserirVertice(p1);
		g.inserirVertice(q1);
		g.inserirVertice(r1);
		g.inserirVertice(s1);
		g.inserirVertice(t1);
		g.inserirVertice(u1);
		g.inserirVertice(v1);
		g.inserirVertice(w1);
		g.inserirVertice(x1);
		g.inserirVertice(y1);
		g.inserirVertice(z1);
		
		//Valores em metros (m).
		Aresta ab = new Aresta("AB", 5.5, a1, b1);
		Aresta ac = new Aresta("AC", 2.2, a1, c1);
		Aresta ae = new Aresta("AE", 1.5, a1, e1);
		Aresta ag = new Aresta("AG", 1.7, a1, g1);
		Aresta bn = new Aresta("BN", 2.8, b1, n1);
		Aresta ce = new Aresta("CE", 2.8, c1, e1);
		Aresta cd = new Aresta("CD", 3.5, c1, d1);
		Aresta df = new Aresta("DF", 4.0, d1, f1);
		Aresta eg = new Aresta("EG", 1.8, e1, g1);
		Aresta ef = new Aresta("EF", 2.3, e1, f1);
		Aresta eh = new Aresta("EH", 3.6, e1, h1);
		Aresta ei = new Aresta("EI", 3.1, e1, i1);
		Aresta fi = new Aresta("FI", 2.6, f1, i1);
		Aresta gh = new Aresta("GH", 2.2, g1, h1);
		Aresta gn = new Aresta("GN", 1.4, g1, n1);
		Aresta gp = new Aresta("GP", 1.4, g1, p1);
		Aresta hi = new Aresta("HI", 2.2, h1, i1);
		Aresta hp = new Aresta("HP", 2.7, h1, p1);
		Aresta hr = new Aresta("HR", 1.8, h1, r1);
		Aresta ij = new Aresta("IJ", 2.2, i1, j1);
		Aresta ir = new Aresta("IR", 1.8, i1, r1);
		Aresta ix = new Aresta("IX", 3.1, i1, x1);
		Aresta jx = new Aresta("JX", 1.9, j1, x1);
		Aresta jy = new Aresta("JY", 1.6, j1, y1);
		Aresta kl = new Aresta("KL", 6.9, k1, l1);
		Aresta ko = new Aresta("KO", 5.1, k1, o1);
		Aresta lm = new Aresta("LM", 3.2, l1, m1);
		Aresta mn = new Aresta("MN", 1.9, m1, n1);
		Aresta np = new Aresta("NP", 1.4, n1, p1);
		Aresta op = new Aresta("OP", 1.3, o1, p1);
		Aresta pq = new Aresta("PQ", 2.5, p1, q1);
		Aresta pr = new Aresta("PR", 1.6, p1, r1);
		Aresta qr = new Aresta("QR", 1.9, q1, r1);
		Aresta qs = new Aresta("QS", 2.1, q1, s1);
		Aresta qu = new Aresta("QU", 3.3, q1, u1);
		Aresta rs = new Aresta("RS", 1.6, r1, s1);
		Aresta rx = new Aresta("RX", 1.9, r1, x1);
		Aresta st = new Aresta("ST", 1.9, s1, t1);
		Aresta sx = new Aresta("SX", 2.1, s1, x1);
		Aresta sy = new Aresta("SY", 3.6, s1, y1);
		Aresta tu = new Aresta("TU", 2.5, t1, u1);
		Aresta tw = new Aresta("TW", 1.1, t1, w1);
		Aresta tz = new Aresta("TZ", 3.5, t1, z1);
		Aresta uv = new Aresta("UV", 5.2, u1, v1);
		Aresta vw = new Aresta("VW", 4.5, v1, w1);
		Aresta wz = new Aresta("WZ", 3.4, w1, z1);
		Aresta xy = new Aresta("XY", 1.9, x1, y1);
		Aresta yz = new Aresta("YZ", 3.2, y1, z1);
		g.inserirArestas(ab);
		g.inserirArestas(ac);
		g.inserirArestas(ae);
		g.inserirArestas(ag);
		g.inserirArestas(bn);
		g.inserirArestas(ce);
		g.inserirArestas(cd);
		g.inserirArestas(df);
		g.inserirArestas(eg);
		g.inserirArestas(ef);
		g.inserirArestas(eh);
		g.inserirArestas(ei);
		g.inserirArestas(fi);
		g.inserirArestas(gh);
		g.inserirArestas(gn);
		g.inserirArestas(gp);
		g.inserirArestas(hi);
		g.inserirArestas(hp);
		g.inserirArestas(hr);
		g.inserirArestas(ij);
		g.inserirArestas(ir);
		g.inserirArestas(ix);
		g.inserirArestas(jx);
		g.inserirArestas(jy);
		g.inserirArestas(kl);
		g.inserirArestas(ko);
		g.inserirArestas(lm);
		g.inserirArestas(mn);
		g.inserirArestas(np);
		g.inserirArestas(op);
		g.inserirArestas(pq);
		g.inserirArestas(pr);
		g.inserirArestas(qr);
		g.inserirArestas(qs);
		g.inserirArestas(qu);
		g.inserirArestas(rs);
		g.inserirArestas(rx);
		g.inserirArestas(st);
		g.inserirArestas(sx);
		g.inserirArestas(sy);
		g.inserirArestas(tu);
		g.inserirArestas(tw);
		g.inserirArestas(tz);
		g.inserirArestas(uv);
		g.inserirArestas(vw);
		g.inserirArestas(wz);
		g.inserirArestas(xy);
		g.inserirArestas(yz);
		return g;
	}
}