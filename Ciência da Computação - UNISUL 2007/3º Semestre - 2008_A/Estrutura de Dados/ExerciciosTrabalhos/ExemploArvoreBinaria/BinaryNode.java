public class BinaryNode {
    
    Comparable element;
    BinaryNode left;
    BinaryNode right;
    int qtd;
    
    /**
     * Construtor
     * @param Comparable element
     */
    public BinaryNode(Comparable element) {
        this( element, null, null, 1 );
    }
    
    /**
     * Construtor
     * @param elemento
     * @param left (esquerda)
     * @param right (direita)
     */
    public BinaryNode(Comparable element, BinaryNode left, BinaryNode right, int qtd) {
        this.element = element;
        this.left = left;
        this.right = right;
        this.qtd = qtd;	
    }
    
    
	public void aumentaQtd() {
		this.qtd++;
	}
	
	public boolean diminuiQtd() {
		if(this.qtd > 1){
			this.qtd--;
			return true;
		}
		return false;
	}
    
}