import java.util.ArrayList;


public class Cromossomo {

	private ArrayList<Integer> codigoGenetico;
	private int fitness;
	
	
	public Cromossomo() {
		codigoGenetico = new ArrayList<Integer>();
		fitness = 0;
	}
	
	
	public Cromossomo( ArrayList<Integer> codigoGenetico ) {
		this.codigoGenetico = codigoGenetico;
	}

	public ArrayList<Integer> getCodigoGenetico() {
		return codigoGenetico;
	}

	public void setCodigoGenetico(ArrayList<Integer> codigoGenetico) {
		this.codigoGenetico = codigoGenetico;
	}
	
	public int getFitness() {
		return fitness;
	}

	public void setFitness(int fitness) {
		this.fitness = fitness;
	}

	
	
	public String toString() {
		String ret = "";
		
		for (int i = 0; i < codigoGenetico.size(); i++) {
			ret += codigoGenetico.get(i);
		}
		
		return ret; 
	}
	
	public boolean equals (Object obj) {
		if(this==obj)
			return true;
		if (obj instanceof Cromossomo) {
			Cromossomo fitness = (Cromossomo) obj;
			return this.fitness == fitness.fitness;
		}
	return false;
	}
}
