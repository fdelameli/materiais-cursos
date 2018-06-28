package monoprogramavel;

public class Memoria {
	
	private Object [] memoria;
	
	
	public Memoria(){
		this.memoria = new Object[2];
	}
	
	
	
	public void run(Object programa) {
	  memoria [1] = programa;
	  for(int i=0;i<Integer.MAX_VALUE; i++);
	  memoria [1] = null;
	}

}
