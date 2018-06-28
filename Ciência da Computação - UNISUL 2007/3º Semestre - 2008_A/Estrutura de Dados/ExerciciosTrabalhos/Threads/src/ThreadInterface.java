public class ThreadInterface implements Runnable{

	private StringBuffer buf;
	private String texto;

	public ThreadInterface(StringBuffer buf, String texto){
		this.buf = buf;
		this.texto = texto;
	}

	public void run(){
		for(int i=0; i < 20; i++) {
			buf.append(texto);
			for(int j=0; j < Integer.MAX_VALUE/600; j++);
		}
	}
}
