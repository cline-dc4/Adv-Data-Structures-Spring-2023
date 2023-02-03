
/**
 * @author DC
 * @version 2/3/23
 * The generic node class for creating a binary tree.
 */
public class Node<T> 
{
	/** a pointer to the parent of the node */
	private Node<T> parent;
	
	/** a pointer to the right child of the node */
	private Node<T> rightChild;
	
	/** a pointer to the left child of the node */
	private Node<T> leftChild;
	
	/** holds the data that is in the node */
	private T data;

	/**
	 * default constructor for Node, sets all values to null.
	 */
	public Node()
	{
		setData(null);
		setRightChild(null);
		setLeftChild(null);
		setParent(null);
	}
	
	/**
	 * constructor for Node that allows data to be inputed.
	 * @param data the data being stored in the node.
	 */
	public Node(T data)
	{
		setData(data);
		setRightChild(null);
		setLeftChild(null);
		setParent(null);
	}
	
	/**
	 * getter for the parent node.
	 * @return a pointer to the parent node.
	 */
	public Node<T> getParent() 
	{
		return parent;
	}

	/**
	 * setter for parent node
	 * @param parent a pointer to the parent of this node.
	 */
	public void setParent(Node<T> parent) 
	{
		this.parent = parent;
	}

	/**
	 * a getter for the left child node.
	 * @return a pointer to the left child node.
	 */
	public Node<T> getLeftChild() 
	{
		return leftChild;
	}

	/**
	 * setter for the left child node.
	 * @param leftChild a pointer to the left child of the node.
	 */
	public void setLeftChild(Node<T> leftChild) 
	{
		this.leftChild = leftChild;
		if(leftChild != null)
		{
			leftChild.setParent(this);
		}
	}
	
	/**
	 * getter for the right child node.
	 * @return a pointer to the right child node.
	 */
	public Node<T> getRightChild() 
	{
		return rightChild;
	}

	/**
	 * setter for the right child node.
	 * @param rightChild a pointer to the right child node.
	 */
	public void setRightChild(Node<T> rightChild) 
	{
		this.rightChild = rightChild;
		if(rightChild != null)
		{
			rightChild.setParent(this);
		}
	}

	/**
	 * a getter for data.
	 * @return data stored in the node.
	 */
	public T getData()
	{
		return data;
	}

	/**
	 * a setter for data.
	 * @param data the data to be stored in the node.
	 */
	public void setData(T data)
	{
		this.data = data;
	}
}

