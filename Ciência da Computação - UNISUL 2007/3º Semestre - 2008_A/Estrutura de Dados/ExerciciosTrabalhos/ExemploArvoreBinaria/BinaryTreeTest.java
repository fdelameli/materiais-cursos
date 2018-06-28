public class BinaryTreeTest {

	public static void main(String[] args) {

		Inteiro i1 = new Inteiro(1);
		Inteiro i2 = new Inteiro(2);
		Inteiro i3 = new Inteiro(3);
		Inteiro i4 = new Inteiro(4);
		Inteiro i5 = new Inteiro(5);
		Inteiro i6 = new Inteiro(6);
		Inteiro i7 = new Inteiro(7);

		BinarySearchTree bst = new BinarySearchTree();
		
//		System.out.println("ELEMENTOS INSERIDOS");
		bst.insert(i3);
		bst.insert(i2);
		bst.insert(i7);
		bst.insert(i4);

		
		BinarySearchTree bst2 = new BinarySearchTree();
		bst2.insert(i3);
		bst2.insert(i2);
		bst2.insert(i7);
		bst2.insert(i3);
		
		System.out.println(bst.isEquals(bst2));
		
		
/*		
		bst.insert(i1);
		bst.insert(i5);
		bst.insert(i6);
		bst.insert(i2);
		
		bst.printTree();
		
		System.out.println();
		
		System.out.println("MENOR ELEMENTO: " + bst.findMin());
        System.out.println("MAIOR ELEMENTO: " + bst.findMax());
        
        System.out.println();
        System.out.println("REMOVENDO ELEMENTO DUPLICADO");
        
        bst.remove(i2);
        bst.printTree();
        
        System.out.println();
        System.out.println("REMOVENDO NOVAMENTE O ELEMENTO QUE ANTES ESTAVA DUPLICADO");
        
        bst.remove(i2);
        bst.printTree();
        
 */
	}
		
}