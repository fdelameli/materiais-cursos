public class AvlNode {
    
    Comparable element;
    AvlNode left;
    AvlNode right;
    int height;
    short qtd;
    
    public AvlNode(Comparable element) {
        this(element, null, null);
    }
    
    public AvlNode(Comparable element, AvlNode left, AvlNode right) {
        this.element = element;
        this.left = left;
        this.right = right;
        this.height = 0;
        this.qtd = 1;
    }

}