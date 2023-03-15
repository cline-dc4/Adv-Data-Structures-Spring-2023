import java.util.ArrayList;
/**
 * Abstract heap class
 * @author dthomas
 *
 */
public abstract class HeapClass {
	
	/** Pointer to the ArrayList */
	protected ArrayList<Node> array;

	/**
	 * Method that removes the root node. It throws an exception if the heap is empty
	 * @return A pointer to the node deleted
	 * @throws An exception if the tree is empty
	*/
	public abstract Node removeNode() throws Exception;
	
	/** Method that inserts the new value 
	 * @param newValue The new value to be inserted
	 * */
	public abstract void insertNode(Integer newValue);
	
	/** 
	 * Constructor
	 */
	public HeapClass()
	{
		array = new ArrayList<Node>();
	}
	
	/**
	 * This method prints out the tree a level at a time, from left to right
	 */
	public void levelOrderTraversal()
	{
		System.out.println("Size: " + array.size());
		for (int i = 0; i < array.size(); i++)
		{
			System.out.print(array.get(i).getData() + " ");
		}
		System.out.println();
	}
	
	
}
