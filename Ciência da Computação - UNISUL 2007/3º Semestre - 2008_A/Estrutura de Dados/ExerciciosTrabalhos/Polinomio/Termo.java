public class Termo {

    private int coeficiente; //o coeficiente do termo
    private int expoente; //o expoente do termo
    private Termo proximo; //ponteiro para o próximo termo
    
    // construtores
    
    public Termo(int coeficiente, int expoente, Termo proximo) {
		this.coeficiente = coeficiente;
		this.expoente = expoente;
		this.proximo = proximo;
	}

	public Termo(int coeficiente, int expoente) {
		this.coeficiente = coeficiente;
		this.expoente = expoente;
		this.proximo = null;
	}

	
	public Termo() {
        this(0, 0, null);
    }

	
	// getters e setters
	
	public int getCoeficiente() {
		return coeficiente;
	}

	public void setCoeficiente(int coeficiente) {
		this.coeficiente = coeficiente;
	}

	public int getExpoente() {
		return expoente;
	}

	public void setExpoente(int expoente) {
		this.expoente = expoente;
	}

	public Termo getProximo() {
		return proximo;
	}

	public void setProximo(Termo proximo) {
		this.proximo = proximo;
	}
	
	public String toString(){
		return coeficiente + "x^" + expoente;
	}

	
	
	/**
	 * Faz a multiplicação entre os termos.
	 * @param termo
	 * @return
	 */
	public Termo fazMultiplicacao(Termo termo){
		int coefi;
		int expoe;

		coefi = termo.coeficiente * this.coeficiente;
		expoe = termo.expoente + this.expoente;
		return new Termo(coefi, expoe);
	}
    
}