public class Principal2{
	public static void main(String []args){
		StringBuffer buf = new StringBuffer();

		Thread inter1 = new Thread(new ThreadInterface(buf, "thread 1\n"));
		Thread inter2 = new Thread(new ThreadInterface(buf, "thread 2\n"));
		Thread inter3 = new Thread(new ThreadInterface(buf, "thread 3\n"));

		inter1.start();
		inter2.start();
		inter3.start();

		for(int i=0; i < Integer.MAX_VALUE/10; i++);
		System.out.println(buf.toString());
	}
}
