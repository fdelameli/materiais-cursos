package classes;
/**
 * Classe responsável por representar as rotas do grafo.
 *
 * @author Fabio Dela Bruna, Márcio Ozório Teixeira
 */
public class Rota {

	private Cidade cidadeOrigem;
	private Cidade cidadeDestino;
	private double distancia;

	//Construtor com parametros.
	public Rota(Cidade cidadeOrigem, Cidade cidadeDestino, double distancia) {
		this.setCidades(cidadeOrigem, cidadeDestino);
		this.setDistancia(distancia);
	}

	//Getters e Setters

	public void setCidades(Cidade cidadeOrigem, Cidade cidadeDestino) {
		if (cidadeOrigem == null || cidadeDestino == null) {
			return; //Altera somente se a cidade origem for diferente da cidade destino.
		}
		if (cidadeOrigem.compareTo(cidadeDestino) == 0) {
			return;
		}
		this.cidadeOrigem = cidadeOrigem;
		this.cidadeDestino = cidadeDestino;

		this.cidadeOrigem.adicionarRota(this);
		this.cidadeDestino.adicionarRota(this);
	}
	
	public void setDistancia(double distancia) {
		this.distancia = distancia;
	}

	public double getDistancia() {
		return this.distancia;
	}

	public Cidade getCidadeDestino() {
		return this.cidadeDestino;
	}

	public Cidade getCidadeOrigem() {
		return this.cidadeOrigem;
	}

	//Equals
	public boolean equals(Object obj) {
		return this.compareTo(obj) == 0;
	}

	//toString
	public String toString() {
		return String.format("Cidade Origem: %s »»»» Distância: %s Km. »»»» Cidade Destino: %s.",
							  this.getCidadeOrigem(), this.getDistancia(), this.getCidadeDestino());
	}

	//CompareTo
	public int compareTo(Object obj) {
		if (obj == null) {
			return -1;
		}
		if (obj instanceof Rota) {
			Rota rota = (Rota) obj;

			if ((this.cidadeOrigem.compareTo(rota.getCidadeOrigem()) == 0 && this.cidadeDestino.compareTo(rota.getCidadeDestino()) == 0)
				|| (this.cidadeOrigem.compareTo(rota.getCidadeDestino()) == 0 && this.cidadeDestino.compareTo(rota.getCidadeOrigem()) == 0)) {
				return 0;
			} else {
				return -1;
			}
		} else {
			return -1;
		}
	}
}
