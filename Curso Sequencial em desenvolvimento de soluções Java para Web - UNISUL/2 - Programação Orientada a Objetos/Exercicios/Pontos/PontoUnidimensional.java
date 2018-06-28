public class PontoUnidimensional {

	private double coordenada_x;

	public PontoUnidimensional() {
		this.coordenada_x = 0;
	}
	
	public PontoUnidimensional(double x) {
		this.coordenada_x = x;
	}

	public double getCoordenada_x() {
		return coordenada_x;
	}

	public void setCoordenada_x(double coordenada_x) {
		this.coordenada_x = coordenada_x;
	}

	public String toString() {
		return "Eu sou um ponto unidimensional.\n"
			+ "Minha coordenada x eh: "
			+ this.getCoordenada_x();
	}
	
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj instanceof PontoUnidimensional) {
			PontoUnidimensional ponto = (PontoUnidimensional) obj;
			return this.coordenada_x == ponto.coordenada_x;
		}
		return false;
	}
}