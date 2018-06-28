public class BinarySearchTree {

	private BinaryNode root;

	public BinarySearchTree() {
		root = null;
	}

	public void makeEmpty() {
		root = null;
	}

	public boolean isEmpty() {
		return root == null;
	}

	public Comparable find(Comparable x) {
		return elementAt(find(x, root));
	}

	public Comparable findMin() {
		return elementAt(findMin(root));
	}

	public Comparable findMax() {
		return elementAt(findMax(root));
	}

	public void insert(Comparable x) {
		root = insert(x, root);
	}

	public void remove(Comparable x) {
		root = remove(x, root);
	}

	public boolean isEquals(BinarySearchTree x){
		return isEquals(x.root, root);
	}

	public void printTree() {
		if (isEmpty()) {
			System.out.println("A árvore está vazia");
		}
		else {
			printTree(root);
		}
	}

	private Comparable elementAt(BinaryNode t) {
		return t == null ? null : t.element;
	}

	private BinaryNode find(Comparable x, BinaryNode t) {
		if (t == null) 
			return null;
		if (x.compareTo(t.element) < 0)
			return find(x, t.left);
		else if (x.compareTo(t.element) > 0)
			return find(x, t.right);
		else
			return t;
	}

	private BinaryNode findMin(BinaryNode t) {
		if(t.left != null)
			return findMin(t.left);
		return t;
	}

	private BinaryNode findMax(BinaryNode t) {
		if(t.right != null)
			return findMax(t.right);
		return t;
	}

	private BinaryNode insert(Comparable x, BinaryNode t) {
		if (t == null)
			t = new BinaryNode(x);
		else if (x.compareTo(t.element) < 0)
			t.left = insert(x, t.left);	
		else if (x.compareTo(t.element) > 0)
			t.right = insert(x, t.right);
		else
			t.aumentaQtd();
		return t;
	}

	private BinaryNode remove(Comparable x, BinaryNode t){
		if(t == null){
			printMessage();
			return null;
		}
		if(x.compareTo(t.element) > 0)	
			t.right = remove(x, t.right);
		else
			if(x.compareTo(t.element) < 0)
				t.left = remove(x, t.left);
			else
				if(t.left != null && t.right != null){
					if(t.diminuiQtd() == false){
						t.element = findMin(t.right).element;
						t.right = remove(t.element, t.right);
					}
				}else{
					if(t.diminuiQtd() == false)
						t = (t.left != null) ? t.left : t.right;
				}
		return t;
	}	

	private void printTree(BinaryNode t) {
		if(t != null){
			printTree(t.left);
			System.out.println("Elemento: " + t.element + " -------> qtd: " + t.qtd);
			printTree(t.right);
		}
	}

	boolean result = true;
	public boolean isEquals(BinaryNode x, BinaryNode t) {
		if(x == null || t == null) {
			result = false;
		} else {
			if(t.element.compareTo(x.element)==0){
				if(x.left!=null && t.left != null) {
					if(isEquals(x.left, t.left))
						if(x.left.qtd == t.left.qtd){
							result = true;
						}else{
							result = false;
						}
				} 	

				if(x.right!=null && t.right!=null) {
					if(isEquals(x.right, t.right))
						if(x.right.qtd == t.right.qtd){
							result = true;
						}else{
							result = false;
						}
				} 
			} else {
				result = false;
			}
		}
		return result;
	}

	private void printMessage(){
		System.out.println("ÁRVORE VAZIA!");
	}

}