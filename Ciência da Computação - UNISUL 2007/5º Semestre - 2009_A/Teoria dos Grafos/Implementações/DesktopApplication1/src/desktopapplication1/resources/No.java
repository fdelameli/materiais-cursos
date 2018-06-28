package desktopapplication1.resources;

import java.util.*;

public class No implements Comparable {
	
        private String nome = "";
	private Vector arestas = new Vector();
	private No anterior;
	//Variável que armazena o custo atual do caminho partindo da fonte.
        private double custo = Caminho.valorMaximo;
	
	//Contrutor com paramêtros
	public No(String nome) {
		this.setNome(nome);
	}
	
        //Métodos
        
        public void adicionarAresta(Aresta aresta) {
		if (aresta == null)
			throw new IllegalArgumentException("Parametro invalido - aresta nula");
		
		if (this.getArestas().indexOf(aresta) == -1)
			this.getArestas().add(aresta);
	}
        
	public double getCaminho(No destino) {
		Iterator i = this.getArestas().iterator();
		
		while (i.hasNext()) {
			Aresta aresta = (Aresta)i.next();
			
			if ((aresta.getOrigem().compareTo(this) == 0 && aresta.getDestino().compareTo(destino) == 0) ||
				(aresta.getOrigem().compareTo(destino) == 0 && aresta.getDestino().compareTo(this) == 0))
				return aresta.getDistancia();
		}
		return Integer.MAX_VALUE;
	}
	
	public No[] getVizinhos() {
		No[] nos = new No[this.getArestas().size()];
		Iterator i = this.getArestas().iterator();
		
		if (this.getArestas().size() == 0)
			return null; // Sem n�s vizinhos
		
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
        
        //Getters e Setters
        
         public void setNome(String nome) {
		this.nome = nome;
	}
        
	public String getNome() {
		return this.nome;
	}
	
        public void setArestas(Vector arestas) {
		this.arestas = arestas;
	}

	public Vector getArestas() {
		return this.arestas;
	}
	
        public void setAnterior(No anterior) {
		this.anterior = anterior;
	}
	
        public No getAnterior() {
		return this.anterior;
	}
	
        public void setCusto(double custo) {
		this.custo = custo;
	}
        
	public double getCusto() {
		return this.custo;
	}
	        
        //Equals
	
	public boolean equals(Object obj) {
		return this.compareTo(obj) == 0;
	}
	
        //toString
        
	public String toString() {
		return this.nome;
	}
        
        //CompareTo
        
	public int compareTo(Object obj) {
		if (obj == null)
			return -1;
		if (obj instanceof No) {
                    No no = (No) obj;
                    return this.getNome().compareToIgnoreCase(no.getNome());
		} else {
                    return -1;
                }
	}
}
