public class PontoTridimensional extends PontoBidimensional {

	private double coordenada_z;

	public PontoTridimensional() {
		super();
		this.coordenada_z = 0;
	}
	
	public PontoTridimensional(double x, double y, double z) {
		super(x, y);
		this.coordenada_z = z;
	}

	public double getCoordenada_z() {
		return coordenada_z;
	}

	public void setCoordenada_z(double coordenada_z) {
		this.coordenada_z = coordenada_z;
	}

	public String toString() {
		return "Eu sou um ponto tridimensional." 
			+ "\n Minha coordenada x eh: "
			+ this.getCoordenada_x() 
			+ "\n Minha coordenada y eh: "
			+ this.getCoordenada_y() 
			+ "\n Minha coordenada z eh: "
			+ this.getCoordenada_z();
	}
}