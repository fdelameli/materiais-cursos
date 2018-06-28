
public class DataBinaryTreeTest {
	
	public static void main(String[] args) {
		Data d1 = new Data(5,1,2004);
		Data d2 = new Data(6,2,2005);
		Data d3 = new Data(1,4,2007);
		Data d4 = new Data(6,4,2007);
		Data d5 = new Data(6,5,2008);
		Data d6 = new Data(6,6,2009);
		Data d7 = new Data(6,7,2012);
		
		BinarySearchTree bst = new BinarySearchTree();
		
		bst.insert(d5);
		bst.insert(d1);
		bst.insert(d6);
		bst.insert(d4);
		bst.insert(d3);
		bst.insert(d2);
		bst.insert(d7);
		
		bst.printTree();
		System.out.printf("Remove(%s)",d5);
		bst.remove(d5);
		System.out.println();
		System.out.println("New Tree:");
		
		bst.printTree();
	}

}
