package multiprogramavel;

import java.util.ArrayList;
import java.util.Iterator;


public class Gerenciador {

	private ArrayList<Object> listPro; // elementos da fila
	private ArrayList<Object> filaEspera; // fila de espera para execução
	private Tabela tab;

	
	public Gerenciador(){
		this.listPro = new ArrayList<Object>();
		this.filaEspera = new ArrayList<Object>();
		this.tab = new Tabela();
	}
	
	
	
    public void enqueue(Object programa) {
		this.listPro.add(programa);
    }
    
    
    public void addFilaEspera(Object programa) {
    	this.filaEspera.add(programa);
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
    		for (int j = 0; j < Tabela.getTAM(); j++) {
				if(this.tab.getTabela()[j] == true) {
		    		System.out.println("Memoria: Processo " + (i+1));
		    		if(memoria.getIndice() <5){
			    		memoria.run(dequeue());{
			    		}
			    		break;
		    		}
				} else {
					addFilaEspera(dequeue());
					System.out.println("Fila Espera: Processo " + (i+1));
				}
			}

    	}
    }
}
