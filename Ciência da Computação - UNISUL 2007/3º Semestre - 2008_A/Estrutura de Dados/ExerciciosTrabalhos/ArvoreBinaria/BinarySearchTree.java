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
/*		if(t == null){
			printMessage();
			return null;
		}
		if(t.left != null)
			return findMin(t.left);
		else
			return t;
*/
		if(t.left != null)
			return findMin(t.left);
		return t;
	}

	private BinaryNode findMax(BinaryNode t) {
/*		if(t == null){
			printMessage();
			return null;
		}
		if(t.right != null)
			return findMax(t.right);
		else
			return t;
*/
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
			; // duplicado, nao faça nada
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
					t.element = findMin(t.right).element;
					t.right = remove(t.element, t.right);
				}else{
					t = (t.left != null) ? t.left : t.right;
				}
		return t;
	}	

	private void printTree(BinaryNode t) {
		if(t != null){
			printTree(t.left);
			System.out.println(t.element.toString());
			printTree(t.right);
		}
	}
	
	private void printMessage(){
		System.out.println("ÁRVORE VAZIA!");
	}
}