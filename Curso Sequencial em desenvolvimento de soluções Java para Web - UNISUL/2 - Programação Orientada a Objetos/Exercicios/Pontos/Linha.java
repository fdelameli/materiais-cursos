public class Linha {

	private PontoBidimensional ponto1;
	private PontoBidimensional ponto2;

	public Linha(PontoBidimensional ponto1, PontoBidimensional ponto2) {
		this.ponto1 = ponto1;
		this.ponto2 = ponto2;
	}

	public PontoBidimensional getPonto1() {
		return this.ponto1;
	}

	public PontoBidimensional getPonto2() {
		return this.ponto2;
	}

	public double getDistancia() {
		double x = Math.pow(ponto2.getCoordenada_x() - ponto1.getCoordenada_x(), 2);
		double y = Math.pow(ponto2.getCoordenada_y() - ponto1.getCoordenada_y(), 2);
		double distancia = Math.sqrt(x + y);
		return distancia;
	}

	public PontoBidimensional getPontoMedio() {
		double x = (ponto1.getCoordenada_x() + ponto2.getCoordenada_x()) / 2;
		double y = (ponto1.getCoordenada_y() + ponto2.getCoordenada_y()) / 2;
		return new PontoBidimensional(x, y);
	}
}