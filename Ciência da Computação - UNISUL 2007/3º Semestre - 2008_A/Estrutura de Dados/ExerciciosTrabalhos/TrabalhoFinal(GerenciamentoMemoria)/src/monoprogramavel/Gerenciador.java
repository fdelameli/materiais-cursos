package monoprogramavel;

import java.util.ArrayList;
import java.util.Iterator;


public class Gerenciador {

	private ArrayList<Object> listPro; // elementos da fila

	
	public Gerenciador(){
		this.listPro = new ArrayList<Object>();
	}
	
	
	
    public void enqueue(Object programa) {
		this.listPro.add(programa);
    }

    public Object dequeue() throws RuntimeException {
		if(this.listPro.isEmpty())
			throw new RuntimeException("Nenhum Programa para ser executado");
		Object temp = this.listPro.get(0);
		this.listPro.remove(0);
		return temp;
		//    	Object temp = this.elements[this.first];
//    	ArrayList<Object>temp = new ArrayList<Object>();
//		for(int i=0; i<listPro.size(); i++) {
//			temp = this.listPro[i+1];
//		}
//		this.elements[this.rear]= null;
//		this.rear-=1;
//    	return temp;
    }

    public void executaProcesso() {
    	Memoria memoria = new Memoria();
    	
//    	Iterator<Object> it = this.listPro.iterator();
//    	while(it.hasNext()){
//    		Object obj = it.next();
//    		System.out.println("Processo: ");
//    		memoria.run(obj);
//    	}
    	int tamanhoLista = this.listPro.size();
    	for(int i=0; i < tamanhoLista; i++) {
    		System.out.println("Processo:"+i);
    		memoria.run(dequeue());
    	}
    }
}
