
public class Caixa {

	private Object objeto;
	
	
	public Caixa(){}
	
	
	public Caixa(Object obj) {
		this.objeto = obj;
	}
	
	
	public void add(Object obj){
		this.objeto = obj;
	}
	
	public Object get() {
		return this.objeto;
	}
	
	
}
