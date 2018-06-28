public class AvlNode {
    
    Comparable element;
    AvlNode left;
    AvlNode right;
    int height;
    int quantidade;
    
    public AvlNode(Comparable element) {
        this(element, null, null);
    }
    
    public AvlNode(Comparable element, AvlNode left, AvlNode right) {
        this.element = element;
        this.left = left;
        this.right = right;
        this.height = 0;
        this.quantidade = 1;
    }
    
    public boolean equals(Object obj) {
    	if(this == obj)
    		return true;
    	if (obj instanceof AvlNode) {
			AvlNode node = (AvlNode) obj;
			boolean l = (left != null)? this.left.equals(node.left) : true;
			boolean r = (right!= null)? this.right.equals(node.right) : true;
			return l
				&& r
				&& node.element.equals(this.element)
				&& node.quantidade == this.quantidade
				&& node.height == this.height;
		}
    	return false;
    }
    
    public void incrementaQuantidade(){
    	this.quantidade++;
    }
    
    public void decrementaQuantidade(){
    	if(quantidade!=0)
    		this.quantidade--;
    }
}