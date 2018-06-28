public class ArrayStack {

	public static final int CAPACITY = 5;
	private int capacity;
	private String elements[] = new String[5];





	public ArrayStack() {
		this(CAPACITY);
	}

	public ArrayStack(int cap) {
		this.capacity = cap;
		this.elements = new String[capacity];
		this.top = -1;
	}

	public int size() {
		return (top + 1);
	}

	public boolean isEmpty() {
		return (top < 0);
	}



	int top = 1;
	public void push(String obj)  {
		// falta implementar
		if(this.size()>capacity){
			aumentaCapacidade();
		}else{
			elements[top]=obj;
			top++;
		}





	}




	public String top() {
		// falta implementar
		if(isEmpty()){
			return null;
		}else{
			return this.elements[top];
		}
	}



	public String pop() {
		if(isEmpty()){
			return null;
		}else{
			String retorno = this.elements[top];
			this.elements[top] = null;
			top--;
			return retorno;
		}
	}



	public void aumentaCapacidade(){
		String[] temp = new String[elements.length + CAPACITY];

		for(int i = 0;i<=elements.length;i++){
			temp[i] = elements[i];
		}

		elements = temp;

	}


}