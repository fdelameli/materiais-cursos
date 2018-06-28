package desktopapplication1.resources;

import java.util.*;

/**
 * Classe responsável por representar o caminho mínimo do grafo.
 * 
 * @author Fabio Dela Bruna, Márcio Ozório Teixeira.
 */
public class Caminho {
    
	public static int valorMaximo = Integer.MAX_VALUE;
	
	private No[] nos;
	// Vetor de Caminho mínimo reconhecidos.
        private No[] nosReconhecidos; 
        double distanciaTotal = 0.0;
	
        //Construtor com parametros
	public Caminho(No[] nos) {
		this.setNos(nos);
	}
	
        //Getters e Setters
        
        public void setNos(No[] nos) {
		this.nos = nos;
	}
        
	public No[] getNos() {
		return this.nos;
	}
        
        public void setDistanciaTotal(double valor){
            this.distanciaTotal = valor;
        }
        
        public double getDistanciaTotal(){
            return this.distanciaTotal;
        }
	
	/* Método responsável por verificar se determinado nó está em nosReconhecidos */
	public boolean existeEmNosReconhecidos(No no) {
		for (int i = 0; i < nosReconhecidos.length; i++) {
			if (no.compareTo(nosReconhecidos[i]) == 0)
				return true;
		} 
		return false;
	}
	
        /* Método responsável por determinar o menor caminho entre dois vértices. */
	public No[] menorCaminho(No origem, No destino) {
		int i = 0;
                int j = 0;
		No menor = null;
                // Último nó adicionado a nosReconhecidos.
                No atual = null; 
                             
		
		nosReconhecidos = new No[nos.length];
		nosReconhecidos[j++] = origem;
		
		for (i = 0; i < nos.length; i++) {
			nos[i].setCusto(valorMaximo);
			nos[i].setAnterior(null);
		}
		
		atual = origem;
		
		// Distância de um nó para ele mesmo é inexistente
		atual.setCusto(0); 
		
		No[] vizinhos = atual.getVizinhos();
		
		if (vizinhos == null)
			return null;
		
		for (i = 0; i < vizinhos.length; i++)
			vizinhos[i].setAnterior(atual);
		
		while (atual.compareTo(destino) != 0) {
			menor = null;
			
			for (i = 0; i < nos.length; i++) {
				if (!existeEmNosReconhecidos(nos[i])) {
					if (menor == null)
						menor = nos[i];
					
					if (atual.getCusto() + atual.getCaminho(nos[i]) < nos[i].getCusto()) {
                                            if (atual.getCaminho(nos[i]) < valorMaximo) {
							nos[i].setCusto((atual.getCusto() + atual.getCaminho(nos[i])));
                                                        
                                                        distanciaTotal += atual.getCaminho(nos[i]);
                                                        
							if (atual.getCaminho(nos[i]) < valorMaximo){
								nos[i].setAnterior(atual);
                                                                
                                                        }
						}
					}
					
					if (nos[i].getCusto() < menor.getCusto()) {
						menor = nos[i];
					}
				}
			}
			
			atual = menor;
			nosReconhecidos[j++] = atual;
		}
		
		Stack pilha = new Stack();
		No[] retorno = new No[nosReconhecidos.length];
		atual = nosReconhecidos[j - 1];
		i = 0;
		
		while (atual != null) {
			pilha.push(atual);
			atual = atual.getAnterior();
		}
		
		j = pilha.size();
		for (i = 0; i < j; i++)
			retorno[i] = (No)pilha.pop();
		
		return retorno;
	}
}
