public class AvlTree {
    
    private AvlNode root;
    
    public AvlTree() {
        root = null;
    }
    
    /**
     * Insere na árvore; itens duplicados são ignorados.
     * @param x o item a inserir.
     */
    public void insert(Comparable x) {
        root = insert(x, root);
    }
    
    /**
     * Remove da árvore. Nada é feito se x não for encontrado.
     * @param x o item a remover.
     */
    public void remove(Comparable x) {
        System.out.println("Ainda não foi implementado");
    }
    
    /**
     * Procura o menor item da árvore.
     * @return o menor item ou null se a árvore estiver vazia.
     */
    public Comparable findMin() {
        return elementAt(findMin(root));
    }
    
    /**
     * Procura o maior item da árvore.
     * @return o maior item ou null se a árvore estiver vazia.
     */
    public Comparable findMax() {
        return elementAt(findMax(root));
    }
    
    /**
     * Procura um item na árvore.
     * @param x o item a procurar.
     * @return o item correspondente ou null se o item não for encontrado.
     */
    public Comparable find(Comparable x) {
        return elementAt(find(x, root));
    }
    
    /**
     * Esvazia a árvore.
     */
    public void makeEmpty( ) {
        root = null;
    }
    
    /**
     * Testa se a árvore esta vazia.
     * @return true se a árvore estiver vazia, false caso contrário.
     */
    public boolean isEmpty( ) {
        return root == null;
    }
    
    /**
     * Imprime o conteúdo da árvore em ordem crescente.
     */
    public void printTree( ) {
        if (isEmpty())
            System.out.println("A árvore está vazia");
        else
            printTree( root );
    }
    
    /**
     * Método interno para recuperar o atributo elemento.
     * @param t o nó.
     * @return o elemento ou null se element for null.
     */
    private Comparable elementAt(AvlNode t) {
        return t == null ? null : t.element;
    }
    
    /**
     * Método interno para inserir em uma sub-árvore.
     * @param x o item a inserir.
     * @param t o nodo que é a raiz da árvore.
     * @return a nova raiz.
     */
    private AvlNode insert(Comparable x, AvlNode t) {
    	return null;
    	// ainda não foi implementado
    }
    
    /**
     * Método interno para producar o menor item da subárvore.
     * @param t o nós raiz da árvore.
     * @return nó contendo o menor item.
     */
    
    // não é recursivo
    private AvlNode findMin( AvlNode t ) {
    	if(t == null)
			return t;
		if (t.left == null)
			return t;
		
		AvlNode temp =  findMin(t.left);
		if(temp.qtd == 0){
			if(t.qtd == 0)
				temp = (t.right!=null) ? findMin(t.right) : t;
			else
				temp = t;
		}
		return temp;
	}	
    
       
    /**
     * Método inteno para procurar o maior item da subárvore.
     * @param t o nós raiz da árvore.
     * @return nó contendo o maior item.
     */
    
    // não é recursivo
    private AvlNode findMax( AvlNode t ) {
    	if(t == null)
			return null;
		if (t.right == null)
			return t;
		
		AvlNode temp =  findMax(t.right);
		if(temp.qtd == 0){
			if(t.qtd == 0)
				temp = (t.left!=null) ? findMax(t.left) : t;
			else
				temp = t;
		}
		return temp;
		
	}
  
    
    /**
     * Método interno para procurar um item na subárvore.
     * @param x o item a ser procurado.
     * @param t o nós raiz da árvore.
     * @return nó contendo o elemento produrado.
     */
    
    // não é recursivo
    private AvlNode find( Comparable x, AvlNode t ) {
       	return null;
    	// ainda não foi implementado
    }
    
    /**
     * Método interno para imprimir a subárvore em ordem crescente
     * @param t o nós raiz da árvore.
     */
    private void printTree( AvlNode t ) {
    	if( t != null ){
			printTree( t.left );
			
			if(t.qtd>0)
				System.out.println( t.element );
			
			printTree( t.right );
		}
	}
    
    /**
     * Return a altura do nós t, ou -1, se null.
     */
    private static int height(AvlNode t) {
        return t == null ? -1 : t.height;
    }
    
    /**
     * Return maximo dos dois valores.
     */
    private static int max(int lhs, int rhs) {
        return lhs > rhs ? lhs : rhs;
    }
    
    /**
     * Gira o nó com o filho da esquerda.
     * Para uma árvore AVL, esta é uma rotação simples (caso 1).
     * Altera alturas, e então retorna o raiz.
     */
    private static AvlNode rotateWithLeftChild(AvlNode k2) {
       	return null;
    	// ainda não foi implementado
    }
    
    /**
     * Gira o nó com o filho da direita.
     * Para árvore AVL, esta é uma rotação simples (caso 4).
     * Altera alturas, e então retorna o raiz.
     */
    private static AvlNode rotateWithRightChild(AvlNode k1) {
        //falta implementar
    	return null;
    }
    
    /**
     * Rotação dupla: first left child
     * with its right child; then node k3 with new left child.
     * Para árvore AVL, esta é uma rotação dupla (caso 2.
     * Altera alturas, e então retorna o raiz.
     */
    private static AvlNode doubleWithLeftChild(AvlNode k3) {
       	return null;
    	// ainda não foi implementado
    }
    
    /**
     * Rotação Dupla: first right child
     * with its left child; then node k1 with new right child.
     * Para árvore AVL, esta é uma rotação dupla (caso 2.
     * Altera alturas, e então retorna o raiz.
     */
    private static AvlNode doubleWithRightChild( AvlNode k1 ) {
       	return null;
    	// ainda não foi implementado
    }
}