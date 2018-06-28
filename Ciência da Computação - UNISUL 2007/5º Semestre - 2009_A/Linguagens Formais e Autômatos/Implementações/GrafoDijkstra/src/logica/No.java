package logica;

import java.util.*;

public class No implements Comparable {
	private String nome = "";
	private Vector arestas = new Vector();
	
	private No anterior;
	private int D = Caminho.INFINITY; // Custo atual do caminho partindo da fonte
	
	public No() {}
	
	public No(String nome) {
		this.setNome(nome);
	}
	
	public String getNome() {
		return this.nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public Vector getArestas() {
		return this.arestas;
	}
	
	public void setArestas(Vector arestas) {
		this.arestas = arestas;
	}
	
	public int getPeso(No destino) {
		Iterator i = this.getArestas().iterator();
		
		while (i.hasNext()) {
			Aresta aresta = (Aresta)i.next();
			
			if ((aresta.getOrigem().compareTo(this) == 0 && aresta.getDestino().compareTo(destino) == 0) ||
				(aresta.getOrigem().compareTo(destino) == 0 && aresta.getDestino().compareTo(this) == 0))
				return aresta.getPeso();
		}
		
		return Integer.MAX_VALUE;
	}
	
	public void adicionarAresta(Aresta aresta) {
		if (aresta == null)
			throw new IllegalArgumentException("Parametro invalido - aresta nula");
		
		if (this.getArestas().indexOf(aresta) == -1)
			this.getArestas().add(aresta);
	}
	
	public boolean removerAresta(Aresta aresta) {
		return this.getArestas().remove(aresta);
	}
	
	public void removerNo() {
		for (int i = 0; i < this.getArestas().size(); i++) {
			Aresta a = (Aresta)this.getArestas().elementAt(i);
			
			if (a.removerAresta() > 0)
				i--;
		}
	}
	
	public No getAnterior() {
		return this.anterior;
	}
	
	public void setAnterior(No anterior) {
		this.anterior = anterior;
	}
	
	public int getD() {
		return this.D;
	}
	
	public void setD(int D) {
		this.D = D;
	}
	
	public No[] getVizinhos() {
		No[] nos = new No[this.getArestas().size()];
		Iterator i = this.getArestas().iterator();
		
		if (this.getArestas().size() == 0)
			return null; // Sem nós vizinhos
		
		int count = 0;
		while (i.hasNext()) {
			Aresta aresta = (Aresta)i.next();
			
			if (aresta.getOrigem().compareTo(this) == 0)
				nos[count] = aresta.getDestino();
			else
				nos[count] = aresta.getOrigem();
			
			count++;
		}
		
		return nos;
	}
	
	public int compareTo(Object obj) {
		if (obj == null)
			return -1;
		
		if (obj instanceof No) {
			No other = (No) obj;
			
			return this.getNome().compareToIgnoreCase(other.getNome());
		}
		else
			return -1;
	}
	
	public boolean equals(Object obj) {
		return this.compareTo(obj) == 0;
	}
	
	public String toString() {
		return this.getNome();
	}
}
