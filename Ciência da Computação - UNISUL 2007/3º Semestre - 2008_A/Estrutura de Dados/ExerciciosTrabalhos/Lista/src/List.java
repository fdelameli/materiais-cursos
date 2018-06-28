
public interface List {

	public int size();
	
	public boolean isEmpty();
	
	public void insertFirst(Object element) throws FullListException;
	
	public void insertLast(Object element) throws FullListException;
	
	public void insertAt(Object element, int position) throws InvalidPositionException, FullListException;
	
	public Object first() throws EmptyListException;
	
	public Object last() throws EmptyListException;
	
	public Object elementAt(int position) throws InvalidPositionException;
	
	public int findElement(Object element);
	
	public void removeFirst() throws EmptyListException;
	
	public void removeLast() throws EmptyListException;
	
	public void remove(Object element);
		
	public void removeAt(int position) throws InvalidPositionException;
}
