
public class CaixaG<T> {
	
	private T t;
	
	
	public CaixaG() {}
	
	
	public CaixaG(T t) {
		this.t = t;
	}
	
	
	public void add(T t) {
		this.t = t;
	}
	
	public T get() {
		return this.t;
	}

}
