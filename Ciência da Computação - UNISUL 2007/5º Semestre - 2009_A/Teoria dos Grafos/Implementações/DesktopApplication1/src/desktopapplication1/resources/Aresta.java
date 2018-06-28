package desktopapplication1.resources;

/**
 * Classe responsável por representar as arestas do grafo.
 *
 * @author Fabio Dela Bruna, Márcio Ozório Teixeira
 */
public class Aresta {

    private No origem;
    private No destino;
    private double distancia;
    
    //Construtor com parâmetros.
    public Aresta(No origem, No destino, double distancia) {
        this.setNos(origem, destino);
        this.setDistancia(distancia);
    }
    
    //Getters e Setters

    public void setNos(No origem, No destino) {
        if (origem == null || destino == null) {
            return;        //Altera somente se a origem for diferente do destino.
        }
        if (origem.compareTo(destino) == 0) {
            return;
        }
        this.origem = origem;
        this.destino = destino;

        this.origem.adicionarAresta(this);
        this.destino.adicionarAresta(this);
    }

    public double getDistancia() {
        return this.distancia;
    }

    public void setDistancia(double distancia) {
        this.distancia = distancia;
    }

    public No getDestino() {
        return this.destino;
    }

    public No getOrigem() {
        return this.origem;
    }

    //Equals
    public boolean equals(Object obj) {
        return this.compareTo(obj) == 0;
    }
    //toString
    public String toString() {
        return String.format("Origem: %s »»»» Peso: %s Km. »»»» Destino: %s.", this.getOrigem(), this.getDistancia(), this.getDestino());
    }
    //CompareTo
    public int compareTo(Object obj) {
        if (obj == null) {
            return -1;
        }
        if (obj instanceof Aresta) {
            Aresta aresta = (Aresta) obj;

            if ((this.origem.compareTo(aresta.getOrigem()) == 0 && this.destino.compareTo(aresta.getDestino()) == 0) ||
                    (this.origem.compareTo(aresta.getDestino()) == 0 && this.destino.compareTo(aresta.getOrigem()) == 0)) {
                return 0;
            } else {
                return -1;
            }
        } else {
            return -1;
        }
    }
}
