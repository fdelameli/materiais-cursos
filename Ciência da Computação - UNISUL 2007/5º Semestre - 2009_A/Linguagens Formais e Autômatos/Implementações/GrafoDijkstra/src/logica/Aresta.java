package logica;

public class Aresta {
	private No origem;
	private No destino;
	private int peso;
	
	public Aresta(No origem, No destino, int peso) {
		this.setNos(origem, destino);
		this.setPeso(peso);
	}
	
	public No getOrigem() {
		return this.origem;
	}
	
	public void setNos(No origem, No destino) {
		if (origem == null || destino == null)
			return;
		
		// Só altera se a origem for diferente do destino
		if (origem.compareTo(destino) == 0)
			return;
		
		this.origem = origem;
		this.destino = destino;
		
		this.origem.adicionarAresta(this);
		this.destino.adicionarAresta(this);
	}
	
	public int removerAresta() {
		if (this.getOrigem() == null || this.getDestino() == null)
			return 0;
		
		int res = 0;
		
		if (this.getOrigem().removerAresta(this))
			res++;
		
		if (this.getDestino().removerAresta(this))
			res++;
		
		return res;
	}
	
	public No getDestino(){
		return this.destino;
	}
	
	public int getPeso() {
		return this.peso;
	}
	
	public void setPeso(int peso) {
		this.peso = peso;
	}
	
	public String toString() {
		return this.getOrigem() + " ---- (" + this.getPeso() + ") ---- " + this.getDestino();
	}
	
	public int compareTo(Object obj) {
		if (obj == null)
			return -1;
		
		if (obj instanceof Aresta) {
			Aresta other = (Aresta) obj;
			
			if ((this.origem.compareTo(other.getOrigem()) == 0 && this.destino.compareTo(other.getDestino()) == 0) ||
				(this.origem.compareTo(other.getDestino()) == 0 && this.destino.compareTo(other.getOrigem()) == 0))
				return 0;
			
			return -1;
		}
		else
			return -1;
	}
	
	public boolean equals(Object obj) {
		return this.compareTo(obj) == 0;
	}
}
