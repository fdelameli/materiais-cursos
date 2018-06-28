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
        
        bst.insert(i3);
        bst.insert(i4);
        bst.insert(i2);
        bst.insert(i7);
        bst.insert(i5);
        bst.insert(i1);
        bst.insert(i6);
        bst.insert(i3);
        
		bst.remove(i3);
        System.out.println("==Menor Número==");
        System.out.println(bst.findMin());
       
        System.out.println();
        
        System.out.println("==Maior Número==");
        System.out.println(bst.findMax());
        
        System.out.println();
        
        System.out.println("==Árvore Completa==");
        bst.printTree();
        
    }
}