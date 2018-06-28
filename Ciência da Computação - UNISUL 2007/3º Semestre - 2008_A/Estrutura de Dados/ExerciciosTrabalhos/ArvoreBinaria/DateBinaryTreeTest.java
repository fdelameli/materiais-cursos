
public class DateBinaryTreeTest {
	
	public static void main(String[] args) {
		
		
		//criando novas datas
		DateBinaryTree d1 = new DateBinaryTree(31,1,1980);
		DateBinaryTree d2 = new DateBinaryTree(25,3,1995);
		DateBinaryTree d3 = new DateBinaryTree(20,2,1996);
		DateBinaryTree d4 = new DateBinaryTree(21,4,1996);
		DateBinaryTree d5 = new DateBinaryTree(15,5,2000);
		DateBinaryTree d6 = new DateBinaryTree(15,6,2005);
		DateBinaryTree d7 = new DateBinaryTree(15,7,2008);
		
		BinarySearchTree bst = new BinarySearchTree();
		
		//inserindo as datas na árvore
		bst.insert(d7);
		bst.insert(d5);
		bst.insert(d2);
		bst.insert(d3);
		bst.insert(d6);
		bst.insert(d1);
		bst.insert(d4);
		
		//imprimindo a árvore inteira
		System.out.println("=====ÁRVORE-COMPLETA=====\n");
		bst.printTree();
		System.out.println("\n\n");
		
		//buscando a menor data da árvore
		System.out.println("=====MENOR-DATA=====\n");
		System.out.println(bst.findMin());
		System.out.println("\n\n");
		
		//buscando a maior dara da árvore
		System.out.println("=====MAIOR-DATA=====\n");
		System.out.println(bst.findMax());
		System.out.println("\n\n");
		
		//removendo uma data da árvore
		System.out.println("=====REMOVE-A-DATA-" + d3 + "=====");
		bst.remove(d3);
		System.out.println("\n\n");
		
		//mostrando a árvore depois de remover d3.
		System.out.println("=====NOVA-ÁRVORE=====\n");
		bst.printTree();

	}

}
