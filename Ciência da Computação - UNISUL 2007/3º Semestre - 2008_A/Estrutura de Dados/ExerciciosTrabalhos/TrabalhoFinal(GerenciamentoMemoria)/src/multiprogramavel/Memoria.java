package multiprogramavel;

public class Memoria {
	
	private Object [] memoria;
	private int indice; 
	
	
	public Memoria(){
		this.memoria = new Object[5];
		this.indice = 0;
	}
	
	
	
	public void run(Object programa) {
		for (int i = 0; i < Integer.MAX_VALUE; i++) {
			
		}
		this.memoria[this.indice] = programa;
		this.indice++;
//	  memoria [1] = programa;
//	  for(int i=0;i<Integer.MAX_VALUE; i++);
//	  memoria [1] = null;
	}



	/**
	 * @return the indice
	 */
	public int getIndice() {
		return indice;
	}



	/**
	 * @param indice the indice to set
	 */
	public void setIndice(int indice) {
		this.indice = indice;
	}
	
	

}
