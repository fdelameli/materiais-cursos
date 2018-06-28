public class PontoBidimensional extends PontoUnidimensional {

	private double coordenada_y;

	public PontoBidimensional() {
		super();
		this.coordenada_y = 0;
	}
	
	public PontoBidimensional(double x, double y) {
		super(x);
		this.coordenada_y = y;
	}

	public double getCoordenada_y() {
		return coordenada_y;
	}

	public void setCoordenada_y(double coordenada_y) {
		this.coordenada_y = coordenada_y;
	}

	public String toString() {
		return "Eu sou um ponto bidimensional." 
			+ "\n Minha coordenada x eh: "	
			+ this.getCoordenada_x() 
			+ "\n Minha coordenada y eh: "
			+ this.coordenada_y;
	}
	
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj instanceof PontoBidimensional) {
			PontoBidimensional ponto = (PontoBidimensional) obj;
			return super.equals(ponto) 
				&& this.coordenada_y == ponto.coordenada_y;
		}
		return false;
	}
	
}