public class BinaryNode {
    
    Comparable element;
    BinaryNode left;
    BinaryNode right;
    
    /**
     * Construtor
     * @param Comparable element
     */
    public BinaryNode(Comparable element) {
        this( element, null, null );
    }
    
    /**
     * Construtor
     * @param elemento
     * @param left (esquerda)
     * @param right (direita)
     */
    public BinaryNode(Comparable element, BinaryNode left, BinaryNode right) {
        this.element = element;
        this.left = left;
        this.right = right;
    }

    
}