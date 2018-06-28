public class AvlTreeTest {
    
    public static void main(String[] args) {
        
        Inteiro i1 = new Inteiro(1);
        Inteiro i2 = new Inteiro(2);
        Inteiro i3 = new Inteiro(3);
        Inteiro i4 = new Inteiro(4);
        Inteiro i5 = new Inteiro(5);
        Inteiro i6 = new Inteiro(6);
        Inteiro i7 = new Inteiro(7);
        
        AvlTree avl = new AvlTree();
        
        avl.insert(i3);
        avl.insert(i2);
        avl.insert(i1);
        avl.insert(i4);
        avl.insert(i5);
        avl.insert(i6);
        avl.insert(i7);

        avl.printTree();
    }
}