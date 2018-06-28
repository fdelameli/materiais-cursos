public class ThreadHeranca extends java.lang.Thread{
	private StringBuffer buf;
	private String texto;

	public ThreadHeranca(StringBuffer buf, String texto){
		this.buf = buf;
		this.texto = texto;
	}

	public void run(){
		for(int i=0; i < 20; i++){
			buf.append(texto);
			try {
				sleep((long)(Math.random() * 100));
			} catch (InterruptedException ie) {
			}
		}
	}
}
