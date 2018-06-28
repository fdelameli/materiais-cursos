package PassagensAereas.src;



public class ClienteList{



	/*
	 * Variáveis principais da classe.
	 */

	private Clientes[] elements;
	private int last;
	private final int TAM = 5;



	/*
	 * Construtores
	 */

	public ClienteList(){
		this.elements = new Clientes[5];
		this.last = -1;
	}



	public ClienteList(Clientes[] elements, int last) {
		super();
		// TODO Auto-generated constructor stub
		this.elements = elements;
		this.last = last;
	}









	public Object elementAt(int position) {

		if(position<0 || position > this.last){
			System.out.println("NÃO DÁ!!!");
			return null;
		}else{return this.elements[position];}


	}

	public int findElement(Clientes Element) {
		int i;
		int retorno = -1;

		boolean acho = false;

		for(i=0;i<=last-1;i++){
			if(Element.equals(this.elements[i])){
				retorno = i;
				acho = true;
			}
		}

		if(acho == false){
			return -1;
		}else{
			return retorno;
		}


	}



	public Object first() {
		return this.elements[0];
	}

	public void insertAt(Clientes Element, int position) {
		if(isFull()){
			aumentaCapacidade();
		}

		this.elements[position] = Element;
	}


	public boolean isFull(){
		return this.elements.length == this.last;
	}



	public void insertFirst(Clientes Element)  { //lenear
		/*if(this.last == 4){
			throw new FullListException("A Lista está cheia");
			}
		this.last++;

		int i;
		for(i = this.last; i>0; i--){
			this.elements[i + 1] = this.elements[i];
		}

		this.elements[0] = Element;
		this.last++; */

		if(isFull()){
			aumentaCapacidade();

			int i;
			for(i = this.last; i>0; i--){
				this.elements[i + 1] = this.elements[i];
			}

			this.elements[0] = Element;
			this.last++;
		}




	}







	public void insertLast(Clientes element) {
		if(isFull()){
			aumentaCapacidade();
		}

		this.last++;
		this.elements[this.last] = element;
	}








	public boolean isEmpty() {
		return this.last == -1;
		}
                        //constante

	public Object last() {//Linear
		if(isEmpty()){
			System.out.println("A Lista Está vazia");
			return null;
		}else{return this.elements[last];

		}



	}




	private void aumentaCapacidade(){
		Clientes[] temp = new Clientes[this.elements.length + 5];

		for(int i = 0; i<this.elements.length; i++){
			temp[i] = this.elements[i];
		}

		this.elements = temp;
	}














	 public void remove(Object element) {
		int i;

		for(i=0;i<=last;i++){
			if(this.elements[i].equals(element)){
				removeAt(i);
			}
		}



	}



	public void removeAt(int position)  {

		if(position > this.elements.length || position < 0 ){
			System.out.println("NÃO PODE!!");
		}else{
			this.elements[position] = null;

			int i;
			for(i=position;i<=(last-1);i--){
				this.elements[i] = this.elements[i+1];
			}


			last--;
		}







	}

	public void removeFirst() {
	  if(this.last!= 0){
		  removeAt(0);
	  }else{
		  System.out.println("Não foi Possível remover");
	  }
	}



	public void removeLast() {
		if(this.last!= 0){
			  removeAt(last);
		  }else{
			  System.out.print("Não foi Possível remover");
		  }
	}

	public int size() {  //constante
		return this.last + 1;
	}















}
